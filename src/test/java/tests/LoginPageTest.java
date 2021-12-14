package tests;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.Wait;
import static utils.Wait.*;

@Test
public class LoginPageTest extends BaseTest{
    @Autowired
    LoginPage loginPage;

    @Test
    public void userCanLogin(){
        page.getSettings().click();
        loginPage.getEmailInput().sendKeys(getUserCredentials("email"));
        loginPage.getNextButton().click();
        waitForVisibilityOfElement(loginPage.getPasswordInput()).sendKeys(getUserCredentials("password"));
        loginPage.getNextButton().click();
        Wait.forMillis(5000);
    }
}
