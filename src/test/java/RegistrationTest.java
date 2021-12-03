import com.codeborne.selenide.Condition;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.asserts.SoftAssert;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegistrationTest extends SetUp {
    LoginPage loginPage = new LoginPage();
    Methods methods = new Methods();
    HeaderElements headerElements = new HeaderElements();
    SoftAssert sa = new SoftAssert();

    @Epic(value = "Login page.")
    @Feature("Registration.")
    @Story("Valid Registration.")
    @Description(value = "Check new user registration.")
    @Test
    public void registrationTestPositive() {
        open(loginPage.homePageURL);
        methods.registration(6);
        headerElements.helloHeader.shouldHave(Condition.text("Hello, " + methods.loginText));
        assertEquals(headerElements.helloHeader.getText(), "Hello, " + methods.loginText, "Greeting not matching");
//        methods.deleteUser();
    }

    @Epic(value = "Login page.")
    @Feature("Registration.")
    @Story("Invalid Values.")
    @Description(value = "Check error message exists.")
    @Test
    public void registrationTestNegative() {
        open(loginPage.homePageURL);
        methods.registration(1);
        headerElements.errorMessage.shouldBe(Condition.visible);
        sa.assertTrue(headerElements.errorMessage.exists(), "Error message not exists");
        sa.assertEquals(headerElements.errorMessage.getText(), "Log in or register", "Wrong error message");
        sa.assertAll();
//        methods.deleteUser();
    }
}
