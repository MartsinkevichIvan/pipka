package tests;

import driver.SingletonDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.Wait;
import service.PropertyDataReader;

import java.time.Duration;

@Test
public class LoginPageTest extends BaseTest{
    @Autowired
    LoginPage loginPage;

    @Test
    public void userCanLogin(){
        page.getSettings().click();
        loginPage.getEmailInput().sendKeys(getUserCredentials("email"));
        loginPage.getNextButton().click();
        new WebDriverWait(SingletonDriver.getDriver(), Duration.ofSeconds(WAITING_TIME))
                .until(ExpectedConditions.visibilityOf(loginPage.getPasswordInput())).sendKeys(getUserCredentials("password"));
        loginPage.getNextButton().click();
        Wait.forMillis(5000);
    }
}
