package tests;

import blocks.settingsPageBlocks.SettingsBlock;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SettingsPage;
import utils.Wait;

import static utils.Wait.*;

@Test
public class LoginPageTest extends BaseTest{
    @Autowired
    LoginPage loginPage;
    @Autowired
    SettingsPage settingsPage;

    @Test
    public void userCanLogin(){
        page.getSettings().click();
        waitForVisibilityOfElement(loginPage.getEmailInput()).sendKeys(getUserCredentials("email"));
        loginPage.getNextButton().click();
        waitForVisibilityOfElement(loginPage.getPasswordInput()).sendKeys(getUserCredentials("password"));
        loginPage.getNextButton().click();
        Assert.assertEquals(settingsPage.getSettingsBlock().getTitle().getText(), "НАСТРОЙКИ");
    }
}
