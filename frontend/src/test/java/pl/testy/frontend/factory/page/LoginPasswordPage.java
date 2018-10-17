package pl.testy.frontend.factory.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPasswordPage extends  BasePage{

    @FindBy(css = "input[type=\"password\"]")
    public WebElement  password;


    @FindBy(css = "button[type=\"submit\"]")
    public WebElement buttonLogIn;


    public LoginPasswordPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
}
