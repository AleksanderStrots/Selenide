import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import java.io.File;

public class ChangePostTest {
    private final AccountPage accountPage = new AccountPage();
    private final Methods methods = new Methods();

    @Test
    public void changePostTestPositive() {
        methods.registration(6);
        methods.createPost(10, 10, 10);

        accountPage.getChangePostButton().shouldBe(Condition.visible).click();
        accountPage.getChangePostWindow().shouldBe(Condition.visible);
        accountPage.getChangePostTitleField().sendKeys(Methods.generateRandomHexString(10));
        methods.title = accountPage.getChangePostTitleField().getAttribute("value");
        accountPage.getChangePostTextField().sendKeys(Methods.generateRandomHexString(10));
        methods.postText = accountPage.getChangePostTextField().getAttribute("value");
        accountPage.getChangePostTagsField().sendKeys(Methods.generateRandomHexString(10));
        methods.tag = accountPage.getChangePostTagsField().getAttribute("value");
        File file = new File(new File(Constants.POST_PICTURE_PATH_FOR_CHANGE).getAbsolutePath());
        accountPage.getChangePostPictureButton().sendKeys(file.getAbsolutePath());
        accountPage.getNewPostSaveButton().click();

    }
}
