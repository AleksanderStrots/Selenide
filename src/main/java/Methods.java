import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

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
        headerElements.signUpButton.shouldBe(Condition.visible).click();
        loginPage.regWindow.shouldBe(Condition.visible);
        loginPage.emailReg.shouldBe(Condition.visible).click();
        loginPage.emailReg.sendKeys(generateRandomHexString(symbolCount) + "@gmail.com");
        emailText = loginPage.emailReg.getAttribute("value");
        loginPage.loginReg.shouldBe(Condition.visible).click();
        loginPage.loginReg.sendKeys(generateRandomHexString(symbolCount));
        loginText = loginPage.loginReg.getAttribute("value");
        loginPage.passwordReg.shouldBe(Condition.visible).click();
        loginPage.passwordReg.sendKeys(generateRandomHexString(symbolCount));
        passwordText = loginPage.passwordReg.getAttribute("value");
        String avatarPath = "src/main/resources/avatar.jpeg";
        File file = new File(new File(avatarPath).getAbsolutePath());
        loginPage.avatarReg.sendKeys(file.getAbsolutePath());
        loginPage.saveButton.click();
        headerElements.helloHeader.shouldBe(Condition.visible);
    }

    @Step("create post")
    public void createPost(int titleSymbolCount, int postTextSymbolCount, int tagSymbolCount) {
        headerElements.accountButton.shouldBe(Condition.visible).click();
        accountPage.userInfo.shouldBe(Condition.visible);
        accountPage.newPostButton.shouldBe(Condition.visible).click();
        accountPage.addNewPostWindow.shouldBe(Condition.visible);
        accountPage.newPostTitleField.sendKeys(Methods.generateRandomHexString(titleSymbolCount));
        title = accountPage.newPostTitleField.getAttribute("value");
        accountPage.newPostTextField.sendKeys(Methods.generateRandomHexString(postTextSymbolCount));
        postText = accountPage.newPostTextField.getAttribute("value");
        accountPage.newPostTagsField.sendKeys(Methods.generateRandomHexString(tagSymbolCount));
        tag = accountPage.newPostTagsField.getAttribute("value");
        String picturePath = "src/main/resources/postPicture.jpeg";
        File file = new File(new File(picturePath).getAbsolutePath());
        accountPage.newPostPictureButton.sendKeys(file.getAbsolutePath());
        accountPage.newPostSaveButton.click();

    }

//    public void deleteUser() {
//        headerElements.accountButton.shouldBe(Condition.visible).click();
//        accountPage.deleteUser.shouldBe(Condition.visible).click();
//    }

}
