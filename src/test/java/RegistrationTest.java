import com.codeborne.selenide.Condition;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.asserts.SoftAssert;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegistrationTest extends SetUp {
    private final Methods methods = new Methods();
    private final HeaderElements headerElements = new HeaderElements();
    private final SoftAssert sa = new SoftAssert();

    @Epic(value = "Login page.")
    @Feature("Registration.")
    @Story("Valid Registration.")
    @Description(value = "Check new user registration.")
    @Test
    public void registrationTestPositive() {
        methods.registration(6);
        headerElements.getHelloHeader().shouldHave(Condition.text("Hello, " + methods.loginText));
        assertEquals(headerElements.getHelloHeader().getText(), "Hello, " + methods.loginText, "Greeting not matching");
        methods.deleteUser();
    }

    @Epic(value = "Login page.")
    @Feature("Registration.")
    @Story("Invalid Values.")
    @Description(value = "Check error message exists.")
    @Test
    public void registrationTestNegative() {
        methods.registration(1);
        headerElements.getErrorMessage().shouldBe(Condition.visible);
        sa.assertTrue(headerElements.getErrorMessage().exists(), "Error message not exists");
        sa.assertEquals(headerElements.getErrorMessage().getText(), "USERNAME_SIZE_NOT_VALID", "Wrong error message");
        sa.assertAll();
    }
}
