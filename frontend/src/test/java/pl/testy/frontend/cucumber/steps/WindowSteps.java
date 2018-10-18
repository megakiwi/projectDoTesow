package pl.testy.frontend.cucumber.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pl.testy.frontend.cucumber.CucumberStepConfig;
import pl.testy.frontend.cucumber.page.DiaryTestPage;

import java.util.Set;

import static org.junit.Assert.assertTrue;

public class WindowSteps {
    WebDriver driver;

    DiaryTestPage diaryTestPage;

    String _1PageWindowHandle;
    String _2PageWindowHandle;

    public WindowSteps(CucumberStepConfig config) {
        try {
            driver = config.setUp();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    @Given("^User is one main page$")
    public void userIsOneMainPage() {
        driver.get("http://www.testdiary.com/training/selenium/selenium-test-page/");
        this._1PageWindowHandle = driver.getWindowHandle(); // tu pobieramy id aktywnego okna
        diaryTestPage = new  DiaryTestPage(driver);
        diaryTestPage.widnowFrame.isDisplayed();

        int hyperLinkYCord = diaryTestPage.widnowFrame.getLocation().getY();
        int hyperLinkXCord = diaryTestPage.widnowFrame.getLocation().getX();

        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollBy(" + hyperLinkXCord + "," +hyperLinkYCord+ " )");

        new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(diaryTestPage.widnowFrame));

        assertTrue(true);

    }

    @When("^User press link$")
    public void userPressLink() {
        diaryTestPage.widnowFrame.click();
        assertTrue(true);

    }

    @Then("^User is switch to other window$")
    public void userIsSwitchToOtherWindow() {
        //tu mamy aktywne dwa okna, bo po kliknieciu otowrzyl nowe okno.
        //wiec mmy dwa id w getWindowHandles
        Set<String> pageWindows = driver.getWindowHandles();
        for(String windowHandler:pageWindows ){
            if(!windowHandler.equals(_1PageWindowHandle)){
                this._2PageWindowHandle = windowHandler;
            }
        }


        driver.switchTo().window(_2PageWindowHandle);

        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("testpagelink")));

        driver.switchTo().window(_2PageWindowHandle).close();

        driver.switchTo().window(_1PageWindowHandle);

        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Open page in a new window")));


    }

}
