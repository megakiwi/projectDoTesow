package pl.testy.frontend.factory.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NotificationPage extends  BasePage{


    @FindBy(id = ".notification-settings-form-stream:nth-child(3) li.notification-settings-form-stream-option__item:nth-child(2) input")
    public WebElement  secondSelector;


    public NotificationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
}
