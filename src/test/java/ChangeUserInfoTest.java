import com.codeborne.selenide.Condition;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;
import org.testng.asserts.SoftAssert;

import java.io.File;

import static com.codeborne.selenide.Selenide.open;

public class ChangeUserInfoTest extends SetUp {

    private final LoginPage loginPage = new LoginPage();
    private final Methods methods = new Methods();
    private final HeaderElements headerElements = new HeaderElements();
    private final AccountPage accountPage = new AccountPage();
    SoftAssert sa = new SoftAssert ();

    @Epic(value = "Account page.")
    @Feature("Change user info.")
    @Story("Valid values.")
    @Description(value = "Checking user information change.")
    @Test
    public void changeUserInfo() {

        open(loginPage.homePageURL);

        methods.registration(6);

        headerElements.accountButton.shouldBe(Condition.visible).click();
        accountPage.updateButton.shouldBe(Condition.visible).click();
        accountPage.updateProfileWindow.shouldBe(Condition.visible);
        accountPage.newEmail.sendKeys(methods.generateRandomHexString(6) + "@gmail.com");
        String newEmail = accountPage.newEmail.getAttribute("value");
        accountPage.newName.sendKeys(methods.generateRandomHexString(6));
        String newName = accountPage.newName.getAttribute("value");
        String avatarPath = "src/main/resources/avatar-2.jpeg";
        File file = new File(new File(avatarPath).getAbsolutePath());
        accountPage.newAvatarButton.sendKeys(file.getAbsolutePath());
        accountPage.updateProfileSaveButton.shouldBe(Condition.visible).click();
        accountPage.loginInfo.shouldBe(Condition.visible).shouldHave(Condition.exactText("User login: " + newName));
        accountPage.emailInfo.shouldBe(Condition.visible).shouldHave(Condition.exactText("User e-mail: " + newEmail));
        sa.assertEquals(accountPage.emailInfo.getText(), ("User e-mail: " + newEmail), "Wrong user e-mail");
        sa.assertEquals(accountPage.loginInfo.getText(), ("User login: " + newName), "Wrong user login");
        sa.assertAll();

//        methods.deleteUser();
    }
}
