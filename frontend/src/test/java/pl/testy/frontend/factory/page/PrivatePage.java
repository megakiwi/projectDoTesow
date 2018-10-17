package pl.testy.frontend.factory.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PrivatePage extends  BasePage{


    @FindBy(className = "form-toggle__switch")
    public WebElement  swich;

    @FindBy(css = "button[type=\"submit\"]")
    public WebElement  buttonSave;


    public PrivatePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
}
