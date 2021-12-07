import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class AccountPage {

// TODO лучше использовать final var или lombok val для всех типов
// TODO нужно ставить модификатор доступа private и создавать геттеры и сеттеры(через lombok) на поля чтобы соблюдать инкапсуляцию
    SelenideElement userInfo = $(By.xpath("//div[contains(text(),'User info')]"));
    SelenideElement updateButton = $(By.xpath("//button[contains(text(),'Update')]"));
    SelenideElement newPostButton = $(By.xpath("//button[contains(text(),'New Post')]"));
    SelenideElement loginInfo = $(By.xpath("//body/div[@id='root']/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]"));
    SelenideElement emailInfo = $(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]"));

    // post
    SelenideElement posts = $(By.cssSelector("#root > div > div > div:nth-child(2) > div:nth-child(4) > div"));
    SelenideElement postTitle = $(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[4]/div[1]/div[1]/div[1]"));
    SelenideElement postText = $(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[4]/div[1]/div[1]/p[1]"));
    SelenideElement postTag = $(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[4]/div[1]/div[1]/div[2]"));
    SelenideElement postAuthor = $(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[4]/div[1]/a[1]"));
    SelenideElement errorMessage = $(By.cssSelector("div:nth-child(2) div:nth-child(1) div.Profile_profile__3dzvr div:nth-child(2) > div.fade.alert.alert-danger.show:nth-child(4)"));

    // update profile form
    SelenideElement updateProfileWindow = $(By.xpath("//body/div[3]/div[1]/div[1]"));
    SelenideElement newEmail = $(By.xpath("//body/div[3]/div[1]/div[1]/form[1]/div[1]/input[1]"));
    SelenideElement newName = $(By.xpath("//body/div[3]/div[1]/div[1]/form[1]/div[2]/input[1]"));
    SelenideElement newAvatarButton = $(By.xpath("//body/div[3]/div[1]/div[1]/form[1]/div[3]/input[1]"));
    SelenideElement updateProfileCloseButton = $(By.xpath("//button[contains(text(),'Close')]"));
    SelenideElement updateProfileSaveButton = $(By.xpath("//button[contains(text(),'Save')]"));

    // new post form
    SelenideElement addNewPostWindow = $(By.xpath("//body/div[3]/div[1]/div[1]"));
    SelenideElement newPostTitleField = $(By.xpath("//body/div[3]/div[1]/div[1]/form[1]/div[1]/input[1]"));
    SelenideElement newPostTextField = $(By.xpath("//body/div[3]/div[1]/div[1]/form[1]/div[2]/textarea[1]"));
    SelenideElement newPostPictureButton = $(By.xpath("//body/div[3]/div[1]/div[1]/form[1]/div[3]/input[1]"));
    SelenideElement newPostTagsField = $(By.xpath("//body/div[3]/div[1]/div[1]/form[1]/div[4]/input[1]"));
    SelenideElement newPostCloseButton = $(By.xpath("//button[contains(text(),'Close')]"));
    SelenideElement newPostSaveButton = $(By.xpath("//button[contains(text(),'Save')]"));

}
