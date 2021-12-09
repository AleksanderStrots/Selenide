import com.codeborne.selenide.Condition;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;
import org.testng.asserts.SoftAssert;
import java.io.File;

public class ChangeUserInfoTest extends SetUp {

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

        methods.registration(6);

        headerElements.getAccountButton().shouldBe(Condition.visible).click();
        accountPage.getUpdateButton().shouldBe(Condition.visible).click();
        accountPage.getUpdateProfileWindow().shouldBe(Condition.visible);
        accountPage.getNewEmail().sendKeys(methods.generateRandomHexString(6) + "@gmail.com");
        String newEmail = accountPage.getNewEmail().getAttribute("value");
        accountPage.getNewName().sendKeys(methods.generateRandomHexString(6));
        String newName = accountPage.getNewName().getAttribute("value");
        File file = new File(new File(Constants.AVATAR_PATH_FOR_CHANGE).getAbsolutePath());
        accountPage.getNewAvatarButton().sendKeys(file.getAbsolutePath());
        accountPage.getUpdateProfileSaveButton().shouldBe(Condition.visible).click();
        accountPage.getLoginInfo().shouldBe(Condition.visible).shouldHave(Condition.exactText("User login: " + newName));
        accountPage.getEmailInfo().shouldBe(Condition.visible).shouldHave(Condition.exactText("User e-mail: " + newEmail));
        sa.assertEquals(accountPage.getEmailInfo().getText(), ("User e-mail: " + newEmail), "Wrong user e-mail");
        sa.assertEquals(accountPage.getLoginInfo().getText(), ("User login: " + newName), "Wrong user login");
        sa.assertAll();

//        methods.deleteUser();
    }
}
