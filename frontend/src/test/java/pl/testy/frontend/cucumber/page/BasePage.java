package pl.testy.frontend.cucumber.page;

import org.openqa.selenium.WebDriver;

public class BasePage {
    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }
}
