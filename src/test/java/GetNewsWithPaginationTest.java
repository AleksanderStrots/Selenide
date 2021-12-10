import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.testng.asserts.SoftAssert;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetNewsWithPaginationTest extends SetUp {
    private final SoftAssert sa = new SoftAssert();

    @Test
    public void getNewsWithPaginationTest() {
        open(Constants.HOME_PAGE_URL);
        $(By.xpath("//body[1]/div[1]/div[1]/main[1]/div[2]")).shouldBe(Condition.visible);
        $(By.xpath("//body[1]/div[1]/div[1]/main[1]/div[2]")).scrollIntoView(false);

        int currentPostsOnPage = $$(By.cssSelector("#root > div > main > div:nth-child(2) > div")).size();
        System.out.println(currentPostsOnPage);
//        assertEquals(Constants.POSTS_ON_PAGE, currentPostsOnPage);
        $(By.xpath("//body[1]/div[1]/div[1]/main[1]/div[2]")).scrollIntoView(false);
        int currentPostsOnPage2 = $$(By.cssSelector("#root > div > main > div:nth-child(2) > div")).size();
        System.out.println(currentPostsOnPage2);
    }
}
