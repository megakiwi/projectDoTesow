package pl.testy.frontend.factory.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PersonalPage extends  BasePage{


    @FindBy(id = "a[href=\"/me/privacy\"]")
    public WebElement  privateLink;

    @FindBy(id = "a[href=\"/me/notifications\"]")
    public WebElement  notification;


    public PersonalPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
}
