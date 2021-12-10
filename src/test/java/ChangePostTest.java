import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

public class ChangePostTest {
    private final AccountPage accountPage = new AccountPage();
    private final Methods methods = new Methods();

    @Test
    public void changePostTestPositive() {
        methods.registration(6);
        methods.createPost(10, 10, 10);

//        accountPage.getChangePostButton().shouldBe(Condition.visible).click();

    }
}
