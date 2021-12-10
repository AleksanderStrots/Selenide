import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import lombok.SneakyThrows;
import org.openqa.selenium.Alert;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.switchTo;

import java.io.File;
import java.util.Random;

public class Methods {

    private final LoginPage loginPage = new LoginPage();
    private final HeaderElements headerElements = new HeaderElements();
    private final AccountPage accountPage = new AccountPage();

    String loginText;
    String emailText;
    String passwordText;
    String title;
    String postText;
    String tag;

    // random string generation
    public static String generateRandomHexString(int length) {
        Random r = new Random();
        StringBuffer sb = new StringBuffer();
        while (sb.length() < length) {
            sb.append(Integer.toHexString(r.nextInt()));
        }
        return sb.toString().substring(0, length);
    }

    @Step("registration")
    public void registration(int symbolCount) {
        open(Constants.HOME_PAGE_URL);
        headerElements.getSignUpButton().shouldBe(Condition.visible).click();
        loginPage.regWindow.shouldBe(Condition.visible);
        loginPage.emailReg.shouldBe(Condition.visible).click();
        loginPage.emailReg.sendKeys(generateRandomHexString(symbolCount) + "@gmail.com");
        emailText = loginPage.emailReg.getAttribute("value");
        System.out.println(emailText);
        loginPage.loginReg.shouldBe(Condition.visible).click();
        loginPage.loginReg.sendKeys(generateRandomHexString(symbolCount));
        loginText = loginPage.loginReg.getAttribute("value");
        loginPage.passwordReg.shouldBe(Condition.visible).click();
        loginPage.passwordReg.sendKeys(generateRandomHexString(symbolCount));
        passwordText = loginPage.passwordReg.getAttribute("value");
        System.out.println(passwordText);
        File file = new File(new File(Constants.AVATAR_PATH_FOR_REG).getAbsolutePath());
        loginPage.avatarReg.sendKeys(file.getAbsolutePath());
        loginPage.saveButton.click();
        headerElements.getHelloHeader().shouldBe(Condition.visible);
    }

    @Step("create post")
    public void createPost(int titleSymbolCount, int postTextSymbolCount, int tagSymbolCount) {
        headerElements.getAccountButton().shouldBe(Condition.visible).click();
        accountPage.getUserInfo().shouldBe(Condition.visible);
        accountPage.getNewPostButton().shouldBe(Condition.visible).click();
        accountPage.getAddNewPostWindow().shouldBe(Condition.visible);
        accountPage.getNewPostTitleField().sendKeys(Methods.generateRandomHexString(titleSymbolCount));
        title = accountPage.getNewPostTitleField().getAttribute("value");
        accountPage.getNewPostTextField().sendKeys(Methods.generateRandomHexString(postTextSymbolCount));
        postText = accountPage.getNewPostTextField().getAttribute("value");
        accountPage.getNewPostTagsField().sendKeys(Methods.generateRandomHexString(tagSymbolCount));
        tag = accountPage.getNewPostTagsField().getAttribute("value");
        File file = new File(new File(Constants.POST_PICTURE_PATH).getAbsolutePath());
        accountPage.getNewPostPictureButton().sendKeys(file.getAbsolutePath());
        accountPage.getNewPostSaveButton().click();
    }

    public void deletePost() {
        headerElements.getAccountButton().shouldBe(Condition.visible).click();
        accountPage.getPost().shouldBe(Condition.visible);
//        accountPage.getDeletePostButton().shouldBe(Condition.visible).click();
    }

    @SneakyThrows
    public void deleteUser() {
        headerElements.getAccountButton().shouldBe(Condition.visible).click();
        accountPage.getDeleteProfileButton().shouldBe(Condition.visible).click();
        Alert alert = switchTo().alert();
        alert.accept();
        Thread.sleep(2000);
    }
}
