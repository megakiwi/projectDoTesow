package pl.testy.frontend.factory.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void waitForVisibilityOfElement(WebElement webElem, int maxWaitTime){
        WebDriverWait driverWait = new WebDriverWait(driver, maxWaitTime);
        driverWait.until(ExpectedConditions.visibilityOf(webElem));

    }
}
