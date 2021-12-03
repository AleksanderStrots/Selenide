import com.codeborne.selenide.Condition;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;
import org.testng.asserts.SoftAssert;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginTest extends SetUp {

    private final LoginPage loginPage = new LoginPage();
    private final Methods methods = new Methods();
    private final HeaderElements headerElements = new HeaderElements();
    SoftAssert sa = new SoftAssert();


    @Epic(value = "Login page.")
    @Feature("Login.")
    @Story("Valid Login.")
    @Description(value = "Check sign in with email and password.")
    @Test
    public void loginTestPositive() {

        open(loginPage.homePageURL);

        // registration
        methods.registration(6);

        // login
        headerElements.quitButton.click();
        headerElements.emailField.sendKeys(methods.emailText);
        headerElements.passwordField.sendKeys(methods.passwordText);
        headerElements.logInButton.click();
        headerElements.helloHeader.shouldHave(Condition.text("Hello, " + methods.loginText));
        assertEquals(("Hello, " + methods.loginText), headerElements.helloHeader.getText(), "Greeting not matching");

        // delete user
//        methods.deleteUser();
    }

    @Epic(value = "Login page.")
    @Feature("Login.")
    @Story("Invalid Password.")
    @Description(value = "Check sign in with invalid password.")
    @Test
    public void loginTestNegativeInvalidPassword() {
        open(loginPage.homePageURL);
        methods.registration(6);

        headerElements.quitButton.click();
        headerElements.emailField.sendKeys(methods.emailText);
        headerElements.passwordField.sendKeys(Methods.generateRandomHexString(10));
        headerElements.logInButton.click();
        headerElements.errorMessage.shouldHave(Condition.visible);
        sa.assertTrue(headerElements.errorMessage.exists(), "Error message not exists");
        sa.assertEquals(headerElements.errorMessage.getText(), "password not valid");
        sa.assertAll();
//        methods.deleteUser();
    }

    @Epic(value = "Login page.")
    @Feature("Login.")
    @Story("Invalid email.")
    @Description(value = "Check sign in with invalid email.")
    @Test
    public void loginTestNegativeInvalidEmail() {
        open(loginPage.homePageURL);
        methods.registration(6);

        headerElements.quitButton.click();
        headerElements.emailField.sendKeys(Methods.generateRandomHexString(10) + "@gmail.com");
        headerElements.passwordField.sendKeys(methods.passwordText);
        headerElements.logInButton.click();
        headerElements.errorMessage.shouldBe(Condition.visible);
        sa.assertTrue(headerElements.errorMessage.exists(), "Error message not exists");
        sa.assertEquals(headerElements.errorMessage.getText(), "Could not find user", "Wrong error message");
        sa.assertAll();
//        methods.deleteUser();
    }
}
