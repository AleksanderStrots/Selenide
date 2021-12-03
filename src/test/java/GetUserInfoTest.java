import com.codeborne.selenide.Condition;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;
import org.testng.asserts.SoftAssert;

import static com.codeborne.selenide.Selenide.open;

public class GetUserInfoTest extends SetUp {

    private final LoginPage loginPage = new LoginPage();
    private final Methods methods = new Methods();
    private final HeaderElements headerElements = new HeaderElements();
    private final AccountPage accountPage = new AccountPage();
    SoftAssert sa =new SoftAssert();

    @Epic(value = "Account page.")
    @Feature("Get User Info.")
    @Story("User Info.")
    @Description(value = "Check user info.")
    @Test
    public void getInfoTest() {
        open(loginPage.homePageURL);
        methods.registration(6);

        headerElements.accountButton.shouldBe(Condition.visible).click();
        accountPage.userInfo.shouldBe(Condition.visible);
        accountPage.loginInfo.shouldBe(Condition.visible).shouldHave(Condition.exactText("User login: " + methods.loginText));
        accountPage.emailInfo.shouldBe(Condition.visible).shouldHave(Condition.exactText("User e-mail: " + methods.emailText));
        sa.assertEquals(accountPage.emailInfo.getText(), ("User e-mail: " + methods.emailText), "Wrong user e-mail");
        sa.assertEquals(accountPage.loginInfo.getText(), ("User login: " + methods.loginText), "Wrong user login");
        sa.assertAll();

//        methods.deleteUser();
    }
}
