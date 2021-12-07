import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class HomePage {
    SelenideElement searchField = $(By.xpath("//body/div[@id='root']/div[1]/main[1]/div[1]/form[1]/div[1]/input[1]"));
    SelenideElement searchButton = $(By.xpath("//button[contains(text(),'Search')]"));
    SelenideElement post = $(By.xpath("//body/div[@id='root']/div[1]/main[1]/div[2]/div[1]"));
    SelenideElement postTitle = $(By.xpath("/html[1]/body[1]/div[1]/div[1]/main[1]/div[2]/div[1]/div[1]/div[1]"));
    SelenideElement postText = $(By.xpath("/html[1]/body[1]/div[1]/div[1]/main[1]/div[2]/div[1]/div[1]/p[1]"));
    SelenideElement postTags = $(By.xpath("//body/div[@id='root']/div[1]/main[1]/div[2]/div[1]/div[1]/div[2]"));

}