package tests;

import blocks.settingsPageBlocks.SettingsBlock;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.SettingsPage;
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
        settingsPage.getSettingsBlock().getSetting(SettingsBlock.Settings.NOTIFICATIONS).click();
        for (WebElement element : settingsPage.getNotificationSettingSubPage().getNotificationSettingsToggles()){
            log.info("Toggle " + element.getAttribute("aria-label") + " pressed??? == " + element.getAttribute("aria-pressed"));
            if ("true".equals(element.getAttribute("aria-pressed"))){
                waitForVisibilityOfElement(element).click();
                log.info("Toggle " + element.getAttribute("aria-label") + " clicked");
            }
        }
        Wait.forMillis(3000);
    }

    @Test
    public void allSettingsAreAvailable(){
        page.getSettings().click();
        waitForVisibilityOfElement(loginPage.getEmailInput()).sendKeys(getUserCredentials("email"));
        loginPage.getNextButton().click();
        waitForVisibilityOfElement(loginPage.getPasswordInput()).sendKeys(getUserCredentials("password"));
        loginPage.getNextButton().click();
        for (WebElement element : settingsPage.getSettingsBlock().getMenuSection()){
            element.click();
            Wait.forMillis(1000);
        }
        Wait.forMillis(5000);
    }
}
