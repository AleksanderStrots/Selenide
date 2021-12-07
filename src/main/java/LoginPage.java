import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

// TODO глобальные константы должны храниться в interface и в специальном файле(homePageUrl не принадлежит LoginPage)
    String homePageURL = "https://news-feed-2.dunice-testing.com/";

    SelenideElement regWindow = $(By.className("modal-content"));
    SelenideElement emailReg = $(By.cssSelector("body > div.fade.modal.show > div > div > form > div:nth-child(1) > input"));
    SelenideElement loginReg = $(By.cssSelector("body > div.fade.modal.show > div > div > form > div:nth-child(2) > input"));
    SelenideElement passwordReg = $(By.cssSelector("body > div.fade.modal.show > div > div > form > div:nth-child(3) > input"));
    SelenideElement avatarReg = $(By.id("formFileLg"));
    SelenideElement closeButton = $(byText("Close"));
    SelenideElement saveButton = $(byText("Save"));

}
