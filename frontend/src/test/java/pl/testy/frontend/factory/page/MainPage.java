package pl.testy.frontend.factory.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends  BasePage{

    @FindBy(css = "li.x-nav-item.x-nav-item--wide.x-nav-item--logged-in a.x-nav-link.x-link")
    // to pole nie inicjalizuje sie w momencie ładowania strony
    // dopiero jak odwołamy się do pola
    public WebElement logIn;





    public MainPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
}
