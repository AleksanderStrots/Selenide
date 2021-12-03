import com.codeborne.selenide.Condition;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.Test;
import org.testng.asserts.SoftAssert;

import static com.codeborne.selenide.Selenide.open;

public class GetDistinctNewsTest extends SetUp {
    private final LoginPage loginPage = new LoginPage();
    private final Methods methods = new Methods();
    private final HeaderElements headerElements = new HeaderElements();
    private final HomePage homePage = new HomePage();
    SoftAssert sa = new SoftAssert();

    @Epic(value = "Home page.")
    @Feature("Filter.")
    @Story("By Title.")
    @Description(value = "Check the search functionality.")
    @Test
    public void getDistinctNewsTest() {

        open(loginPage.homePageURL);
        methods.registration(6);
        methods.createPost(10,10,10);

        headerElements.homeButton.shouldBe(Condition.visible).click();
        homePage.searchField.val(methods.title);
        homePage.searchButton.shouldBe(Condition.visible).click();
        homePage.post.shouldBe(Condition.visible);
        sa.assertTrue(homePage.post.exists(), "Post not exists");
        sa.assertEquals(homePage.postTitle.getText(), methods.title, "Wrong title");
        sa.assertEquals(homePage.postText.getText(), methods.postText, "Wrong content");
        sa.assertEquals(homePage.postTags.getText(), "#" + methods.tag, "Wrong tag");
        sa.assertAll();
//        methods.deleteUser();
    }
}
