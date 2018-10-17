package pl.testy.frontend.factory.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginEmailPage extends  BasePage{


    @FindBy(id = "usernameOrEmail")
    public WebElement  usernameOrEmail;


    @FindBy(css = "button[type=\"submit\"]")
    public WebElement buttonContinue;


    public LoginEmailPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
}
