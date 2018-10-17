package pl.testy.frontend.factory.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserMainPage extends  BasePage{


    @FindBy(css = "a.masterbar__item.masterbar__item-me")
    public WebElement buttonAvatar;


    public UserMainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
}
