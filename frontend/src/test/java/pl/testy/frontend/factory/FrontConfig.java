package pl.testy.frontend.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import pl.testy.frontend.Configuration;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class FrontConfig {


    protected WebDriver driver;

    public void setDriver(WebDriver driver) {
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @BeforeAll
    protected static void beforeAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    protected void setUp() throws MalformedURLException {




        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        capabilities.setBrowserName("chrome");
        capabilities.setPlatform(Platform.WIN10);

        if (driver == null) {
            try {
 //ta zmianna srodowsowa ktora determinuje czy testy maja byc wykonywane lokalnie czy na remocie
                if (System.getenv().get("BROWSER").equals("remote")) {
                    driver = new RemoteWebDriver(new URL(Configuration.URL_REMOTE), capabilities);
                    driver.manage().window().setSize(new Dimension(1920, 1080));
                } else {
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                }
            } catch (NullPointerException n) {
                driver = new ChromeDriver();
                driver.manage().window().maximize();
            }
        }

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
