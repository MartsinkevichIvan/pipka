package tests;

import blocks.navigationSubBlocks.Advanced;
import blocks.settingsPageBlocks.SettingsBlock.SettingsValues;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.adminPages.SettingsPage;

import pages.adminPages.SettingsPage.NotificationSettingSubPage.NotificationSettingsValues;
import pages.adminPages.SettingsPage.PlaybackSettingSubPage.PlaybackAV1SettingsValues;
import utils.Wait;

import static utils.Wait.waitForVisibilityOfElement;

@Test
public class SettingsPageTest extends BaseTest{
    @Autowired
    LoginPage loginPage;
    @Autowired
    SettingsPage settingsPage;

    @BeforeMethod(alwaysRun = true)
    public void openSettingsPage(){
        if(page.getHeaderBlock().getTopBarButtons().size()<3){
            page.switchToNavigationBlock().getAdvanced().getSettingElement(Advanced.MainValuesEnum.SETTINGS).click();
            waitForVisibilityOfElement(loginPage.getEmailInput()).sendKeys(getUserCredentials("email"));
            loginPage.getNextButton().click();
            waitForVisibilityOfElement(loginPage.getPasswordInput()).sendKeys(getUserCredentials("password"));
            loginPage.getNextButton().click();
        }
        else {
            page.switchToNavigationBlock().getAdvanced().getSettingElement(Advanced.MainValuesEnum.SETTINGS).click();
        }
    }
    @Test(priority = -1)
    public void allSettingsAreAvailable(){
        for(WebElement element : settingsPage.getSettingsBlock().getMenuSections()){
            element.click();
            Wait.forMillis(1000);
            String pageTitle = waitForVisibilityOfElement(settingsPage.getSettingTitle()).getText();
            Assert.assertEquals(pageTitle, element.getText());

        }
    }

    @Test
    public void allNotificationSettingsAreAvailable(){
        settingsPage.getSettingsBlock().getSetting(SettingsValues.NOTIFICATIONS).click();
        settingsPage.getNotificationSettingSubPage().getNotificationToggles().checkAll().uncheckAll();
        Wait.forMillis(1000);
    }

    @Test
    public void commentAnswerNotificationSettingIsAvailable(){
        settingsPage.getSettingsBlock().getSetting(SettingsValues.NOTIFICATIONS).click();
        settingsPage.getNotificationSettingSubPage().getNotificationToggles().setToggleActive(NotificationSettingsValues.COMMENT_ANSWERS);
        settingsPage.getNotificationSettingSubPage().getNotificationToggles().setToggleInactive(NotificationSettingsValues.COMMENT_ANSWERS);
        Wait.forMillis(1000);
    }

    @Test
    public void playbackSettingsAreAvailable(){
        settingsPage.getSettingsBlock().getSetting(SettingsValues.PLAYBACK).click();
        settingsPage.getPlaybackSettingSubPage().getPlaybackCheckboxes().checkAll().uncheckAll();
        Wait.forMillis(1000);
    }
    @Test
    public void playbackRadioButtonsAreAvailable(){
        settingsPage.getSettingsBlock().getSetting(SettingsValues.PLAYBACK).click();
        settingsPage.getPlaybackSettingSubPage().getPlaybackAV1SettingsRadioButtons().getButton(PlaybackAV1SettingsValues.ALWAYS_PREFER_AV1).setActive();
        settingsPage.getPlaybackSettingSubPage().getPlaybackAV1SettingsRadioButtons().getButton(PlaybackAV1SettingsValues.PREFER_AV1_FOR_SD).isActive();
        settingsPage.getPlaybackSettingSubPage().getPlaybackAV1SettingsRadioButtons().getButton(PlaybackAV1SettingsValues.AUTO).setActive();
        Wait.forMillis(1000);
    }

    @Test
    public void allPrivacySettingAreAvailable(){
        settingsPage.getSettingsBlock().getSetting(SettingsValues.PRIVACY).click();
        settingsPage.getPrivacySettingsSubPage().getPrivacySettingsToggles().checkAll().uncheckAll();
        Wait.forMillis(1000);
    }
}
