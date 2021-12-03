import com.codeborne.selenide.Condition;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;
import org.testng.asserts.SoftAssert;

import static com.codeborne.selenide.Selenide.open;

public class CreateNewPostTest extends SetUp {
    private final LoginPage loginPage = new LoginPage();
    private final Methods methods = new Methods();
    private final HeaderElements headerElements = new HeaderElements();
    private final AccountPage accountPage = new AccountPage();
    private final HomePage homePage = new HomePage();
    SoftAssert sa = new SoftAssert();

    @Epic(value = "Account page.")
    @Feature("Create post.")
    @Story("Valid values.")
    @Description(value = "Post creation check with valid values.")
    @Test
    public void createNewPostTestPositive() {

        open(loginPage.homePageURL);
        methods.registration(6);
        methods.createPost(10,10,10);

        sa.assertEquals(accountPage.postTitle.getText(), methods.title, "Wrong title");
        sa.assertEquals(accountPage.postText.getText(), methods.postText, "Wrong content");
        sa.assertEquals(accountPage.postTag.getText(), "#" + methods.tag, "Wrong tag");
        sa.assertEquals(accountPage.postAuthor.getText(), methods.loginText, "Wrong author");

        headerElements.homeButton.shouldBe(Condition.visible).click();
        homePage.post.shouldBe(Condition.visible);
        sa.assertTrue(homePage.post.exists(), "Post not exists");
        sa.assertEquals(homePage.postText.getText(), methods.postText, "Wrong content");
        sa.assertAll();
//        methods.deleteUser();
    }

    @Epic(value = "Account page.")
    @Feature("Create post.")
    @Story("Invalid title.")
    @Description(value = "Post creation check with invalid title.")
    @Test
    public void createNewPostTestNegativeInvalidTitle() {
        open(loginPage.homePageURL);
        methods.registration(6);
        methods.createPost(1,10,10);
        accountPage.errorMessage.should(Condition.exist);
        sa.assertTrue(accountPage.errorMessage.exists(), "Error message not exists");
        sa.assertEquals(accountPage.errorMessage.getText(), "news title size not valid", "Wrong error message");
        sa.assertAll();
//        methods.deleteUser();
    }

    @Epic(value = "Account page.")
    @Feature("Create post.")
    @Story("Invalid content.")
    @Description(value = "Post creation check with invalid content.")
    @Test
    public void createNewPostTestNegativeInvalidContent() {
        open(loginPage.homePageURL);
        methods.registration(6);
        methods.createPost(10,1,10);
        accountPage.errorMessage.should(Condition.exist);
        sa.assertTrue(accountPage.errorMessage.exists(), "Error message not exists");
        sa.assertEquals(accountPage.errorMessage.getText(), "NEWS_DESCRIPTION_SIZE_NOT_VALID", "Wrong error message");
        sa.assertAll();
//        methods.deleteUser();
    }

    @Epic(value = "Account page.")
    @Feature("Create post.")
    @Story("Invalid tags.")
    @Description(value = "Post creation check with invalid tags.")
    @Test
    public void createNewPostTestNegativeInvalidTags() {
        open(loginPage.homePageURL);
        methods.registration(6);
        methods.createPost(10,10,0);

        accountPage.errorMessage.should(Condition.exist);
        sa.assertTrue(accountPage.errorMessage.exists(), "Error message not exists");
        sa.assertEquals(accountPage.errorMessage.getText(), "TAGS_NOT_VALID", "Wrong error message");
        sa.assertAll();
//        methods.deleteUser();
    }
}
