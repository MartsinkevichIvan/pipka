package tests;

import blocks.settingsPageBlocks.SettingsBlock;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SettingsPage;
import utils.SettingsPageTestUtils;
import utils.Wait;

import static utils.Wait.waitForVisibilityOfElement;

public class SettingsPageTest extends BaseTest{
    @Autowired
    LoginPage loginPage;
    @Autowired
    SettingsPage settingsPage;

    @Test
    public void NotificationsSettingsAreAvailable(){
        page.getSettings().click();
        waitForVisibilityOfElement(loginPage.getEmailInput()).sendKeys(getUserCredentials("email"));
        loginPage.getNextButton().click();
        waitForVisibilityOfElement(loginPage.getPasswordInput()).sendKeys(getUserCredentials("password"));
        loginPage.getNextButton().click();
        settingsPage.getSettingsBlock().getSetting(SettingsBlock.SettingsValues.NOTIFICATIONS).click();
        SettingsPageTestUtils
                .turnOffToggles(settingsPage.getNotificationSettingSubPage().getCommonNotificationSettingsToggles());

        SettingsPageTestUtils
                .turnOffToggles(settingsPage.getNotificationSettingSubPage().getEmailNotificationToggles());
        Wait.forMillis(3000);
    }

    @Test
    public void allSettingsAreAvailable(){
        page.getSettings().click();
        waitForVisibilityOfElement(loginPage.getEmailInput()).sendKeys(getUserCredentials("email"));
        loginPage.getNextButton().click();
        waitForVisibilityOfElement(loginPage.getPasswordInput()).sendKeys(getUserCredentials("password"));
        loginPage.getNextButton().click();
        for (WebElement element : settingsPage.getSettingsBlock().getMenuSections()){
            element.click();
            Wait.forMillis(1000);
        }
        Wait.forMillis(5000);
    }
}
