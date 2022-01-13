package tests;

import blocks.navigationSubBlocks.Advanced;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.adminPages.SettingsPage;

import static utils.Wait.*;

@Test (groups = "web")
public class LoginPageTest extends BaseTest {
    @Autowired
    LoginPage loginPage;
    @Autowired
    SettingsPage settingsPage;

    @Test
    public void userCanLogin() {
        page.switchToNavigationBlock().getAdvanced().getSettingElement(Advanced.MainValuesEnum.SETTINGS).click();
        waitForVisibilityOfElement(loginPage.getEmailInput()).sendKeys(getUserCredentials("email"));
        loginPage.getNextButton().click();
        waitForVisibilityOfElement(loginPage.getPasswordInput()).sendKeys(getUserCredentials("password"));
        loginPage.getNextButton().click();
        Assert.assertTrue(settingsPage.getHeaderBlock().getTopBarButtons().size() > 2);
    }
}
