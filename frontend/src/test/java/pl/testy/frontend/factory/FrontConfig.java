package pl.testy.frontend.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pl.testy.frontend.Configuration;

import java.util.concurrent.TimeUnit;

public class FrontConfig {


    protected WebDriver driver;


    @BeforeAll
    protected static void beforeAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    protected void beforeEach() {
        if (null == driver) {
            driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(Configuration.URL);
    }

    @AfterEach
    protected void afterEach() {
        driver.quit();
        driver = null;
    }

}
