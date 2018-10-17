package pl.testy.frontend.factory.test;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pl.testy.frontend.Configuration;
import pl.testy.frontend.factory.FrontConfig;
import pl.testy.frontend.factory.page.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FrontEndTest extends FrontConfig {


   //@Test
    public void _1Test(){
        MainPage page = new MainPage(driver);


        assertTrue(driver.getTitle().contains("WordPress"));

        WebElement logIn =
        driver.findElement(By.cssSelector("li.x-nav-item.x-nav-item--wide.x-nav-item--logged-in a.x-nav-link.x-link"));

        assertEquals("Log In",logIn.getText());
        assertTrue(logIn.isDisplayed());

        page.logIn.click();

        LoginEmailPage loginEmailPage = new LoginEmailPage(driver);
        loginEmailPage.waitForVisibilityOfElement(loginEmailPage.usernameOrEmail,100);
        loginEmailPage.waitForVisibilityOfElement(loginEmailPage.buttonContinue,100);
        assertTrue(loginEmailPage.usernameOrEmail.isDisplayed());
        assertTrue(loginEmailPage.buttonContinue.isDisplayed());

        loginEmailPage.usernameOrEmail.clear();
        loginEmailPage.usernameOrEmail.sendKeys(Configuration.LOGIN);
        loginEmailPage.buttonContinue.click();


        LoginPasswordPage loginPage = new LoginPasswordPage(driver);
        loginPage.waitForVisibilityOfElement(loginPage.buttonLogIn,100);
        loginPage.waitForVisibilityOfElement(loginPage.password,100);
        assertTrue(loginPage.buttonLogIn.isDisplayed());
        assertTrue(loginPage.password.isDisplayed());

        loginPage.password.clear();
        loginPage.password.sendKeys(Configuration.PASSWORD);
        loginPage.buttonLogIn.click();


        UserMainPage userMainPage = new UserMainPage(driver);
        userMainPage.waitForVisibilityOfElement(userMainPage.buttonAvatar, 100);
        userMainPage.buttonAvatar.click();


        PersonalPage personalPage = new PersonalPage(driver);
        personalPage.waitForVisibilityOfElement(personalPage.privateLink, 100);
        personalPage.privateLink.click();


        PrivatePage privatePage = new PrivatePage(driver);
        privatePage.waitForVisibilityOfElement(privatePage.swich, 100);
        privatePage.waitForVisibilityOfElement(privatePage.buttonSave, 100);

        assertFalse(privatePage.buttonSave.isEnabled());

        privatePage.swich.click();
        assertTrue(privatePage.buttonSave.isEnabled());
    }

    @Test
    public void _2Test(){
        MainPage page = new MainPage(driver);


        assertTrue(driver.getTitle().contains("WordPress"));

        WebElement logIn =
                driver.findElement(By.cssSelector("li.x-nav-item.x-nav-item--wide.x-nav-item--logged-in a.x-nav-link.x-link"));

        assertEquals("Log In",logIn.getText());
        assertTrue(logIn.isDisplayed());

        page.logIn.click();

        LoginEmailPage loginEmailPage = new LoginEmailPage(driver);
        loginEmailPage.waitForVisibilityOfElement(loginEmailPage.usernameOrEmail,100);
        loginEmailPage.waitForVisibilityOfElement(loginEmailPage.buttonContinue,100);
        assertTrue(loginEmailPage.usernameOrEmail.isDisplayed());
        assertTrue(loginEmailPage.buttonContinue.isDisplayed());

        loginEmailPage.usernameOrEmail.clear();
        loginEmailPage.usernameOrEmail.sendKeys(Configuration.LOGIN);
        loginEmailPage.buttonContinue.click();


        LoginPasswordPage loginPage = new LoginPasswordPage(driver);
        loginPage.waitForVisibilityOfElement(loginPage.buttonLogIn,100);
        loginPage.waitForVisibilityOfElement(loginPage.password,100);
        assertTrue(loginPage.buttonLogIn.isDisplayed());
        assertTrue(loginPage.password.isDisplayed());

        loginPage.password.clear();
        loginPage.password.sendKeys(Configuration.PASSWORD);
        loginPage.buttonLogIn.click();


        UserMainPage userMainPage = new UserMainPage(driver);
        userMainPage.waitForVisibilityOfElement(userMainPage.buttonAvatar, 100);
        userMainPage.buttonAvatar.click();


        PersonalPage personalPage = new PersonalPage(driver);
        personalPage.waitForVisibilityOfElement(personalPage.notification, 100);
        personalPage.notification.click();


        NotificationPage notificationPage = new NotificationPage(driver);
        notificationPage.waitForVisibilityOfElement(notificationPage.secondSelector, 100);

        assertTrue(notificationPage.secondSelector.isSelected());
        notificationPage.secondSelector.click();
        assertFalse(notificationPage.secondSelector.isSelected());
        notificationPage.secondSelector.click();
        assertTrue(notificationPage.secondSelector.isSelected());


    }
}
