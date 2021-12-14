package tests;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.Wait;

@Test
public class LoginPageTest extends BaseTest{
    @Autowired
    LoginPage loginPage;

    @Test
    public void settingsButtonLeadsToLoginPage(){
        page.getSettings().click();
        loginPage.getNextButton().click();
        Wait.forMillis(5000);
    }
}
