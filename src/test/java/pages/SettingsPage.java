package pages;

import blocks.elements.ListOfToogle;
import blocks.settingsPageBlocks.SettingsBlock;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import spring.annotations.PageObject;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@PageObject
@Getter
public class SettingsPage extends AbstractPage{
    @Autowired
    SettingsBlock settingsBlock;
    @Autowired
    @Lazy
    AccountSettingSubPage accountSettingSubPage;
    @Autowired
    @Lazy
    NotificationSettingSubPage notificationSettingSubPage;
    @Autowired
    @Lazy
    PlaybackSettingSubPage playbackSettingSubPage;
    @Autowired
    @Lazy
    PrivacySettingsSubPage privacySettingsSubPage;
    @Autowired
    @Lazy
    ConnectedAppsSettingsSubPage connectedAppsSettingsSubPage;
    @Autowired
    @Lazy
    BillingSettingsSubPage billingSettingsSubPage;
    @Autowired
    @Lazy
    AdvancedSettingsSubPage advancedSettingsSubPage;

    @PageObject
    @Getter
    public static class AccountSettingSubPage{
        @FindBy(xpath = "//a[text()='Создать канал']")
        private WebElement createChannelLink;

        @FindBy(xpath = "//a[text()='Настроить аккаунт Google']")
        private WebElement googleAccountSettingsLink;

        @FindBy(xpath = "//a[text()='Оформить YouTube Premium']")
        private WebElement youTubePremiumSubscriptionLink;
    }

    @PageObject
    @Getter
    public static class NotificationSettingSubPage{
        //        @FindBy(xpath = "//*[text()='Общие']/ancestor::ytd-item-section-renderer//*[@id='toggle']")
        //        private List<WebElement> commonNotificationToggles;
        private final ListOfToogle<CommonNotificationSettingsValues> commonNotificationToggles = new ListOfToogle<>(
                By.xpath("//*[text()='Общие']/ancestor::ytd-item-section-renderer//*[@id='toggle']"));

        @FindBy(xpath = "//*[text()='Уведомления по электронной почте']/ancestor::ytd-item-section-renderer//*[@id='toggle']")
        private List<WebElement> emailNotificationToggles;

        @FindBy(xpath = "//a[@href='/feed/channels']")
        private WebElement subscriptionChannelsListLink;

        @FindBy(xpath = "//*[contains(text(), 'emails_from_youtube')]")
        private WebElement emailNotificationHelpLink;

        @FindBy(xpath = "//*[contains(text(), 'emails_from_youtube')]")
        private WebElement notificationLanguageSelection;

        //        public WebElement getEmailNotificationSetting(EmailNotificationSettingsValues setting){
        //            return commonNotificationToggles.stream().filter(webElement -> setting.getValue().equals(webElement.getAttribute("aria-label"))).findFirst().get();
        //        }

        @Getter
        public enum CommonNotificationSettingsValues implements Supplier<String>{
            BROWSER_NOTIFICATIONS("Уведомления в браузере"),
            SUBSCRIPTIONS("Подписки"),
            RECOMMENDED_VIDEO("Рекомендованные видео"),
            CHANNEL_ACTIONS("Действия на канале"),
            COMMENTS_ACTIONS("Действия с комментариями"),
            COMMENT_ANSWERS("Ответы на комментарии"),
            MENTIONS("Упоминания"),
            CONTENT_SHARING("Записи с моим контентом на других каналах");
            private String value;

            CommonNotificationSettingsValues(String value){
                this.value = value;
            }

            public String get(){
                return value;
            }

            public static List<String> getSettingsStringList(){
                return Arrays.stream(values()).map(CommonNotificationSettingsValues::getValue).collect(Collectors.toList());
            }
        }

        @Getter
        public enum EmailNotificationSettingsValues{
            FAMILY_RECOMMENDATIONS("Новости YouTube и YouTube Детям, а также рекомендации для всей семьи"),
            LAST_ACTION_ON_CHANNEL("Уведомления о последних действиях на моем канале и новости сервиса (кроме тех, на которые отменена подписка)"),
            YOUTUBE_GENERAL_NEWS("Общие новости YouTube"),
            YOUTUBE_PREMIUM_NEWS("Новости YouTube Premium"),
            AUTHOR_NEWS("Новости для авторов");
            private String value;

            EmailNotificationSettingsValues(String value){
                this.value = value;
            }

            public static List<String> getSettingsStringList(){
                return Arrays.stream(values()).map(EmailNotificationSettingsValues::getValue).collect(Collectors.toList());
            }
        }
    }

    @PageObject
    @Getter
    public static class PlaybackSettingSubPage{
        @FindBy(xpath = "//tp-yt-paper-checkbox")
        private List<WebElement> playbackSettingsList;

        @FindBy(xpath = "//tp-yt-paper-radio-button")
        private List<WebElement> playerAV1Settings;

        public WebElement getPlaybackSetting(PlaybackSettingsValues setting){
            return playbackSettingsList.stream().filter(webElement -> setting.getValue().equals(webElement.getAttribute("aria-label"))).findFirst().get();
        }

        public WebElement getPlaybackAV1Setting(PlaybackAV1SettingsValues setting){
            return playbackSettingsList.stream().filter(webElement -> setting.getValue().equals(webElement.getAttribute("aria-label"))).findFirst().get();
        }

        @Getter
        public enum PlaybackSettingsValues{
            IN_VIDEO_INFO_CARDS("Показывать в видео подсказки"),
            SUBTITLES_AND_CAPTIONS("Всегда показывать субтитры"),
            INCLUDE_AUTO_GENERATED_CAPTIONS("Показывать автоматически созданные субтитры, если они доступны");
            private String value;

            PlaybackSettingsValues(String value){
                this.value = value;
            }

            public static List<String> getSettingsStringList(){
                return Arrays.stream(values()).map(PlaybackSettingsValues::getValue).collect(Collectors.toList());
            }
        }

        @Getter
        public enum PlaybackAV1SettingsValues{
            AUTO("Автоматически (рекомендовано)"), PREFER_AV1_FOR_SD("Использовать AV1 для SD-контента"), ALWAYS_PREFER_AV1("Всегда использовать AV1");
            private String value;

            PlaybackAV1SettingsValues(String value){
                this.value = value;
            }

            public static List<String> getSettingsStringList(){
                return Arrays.stream(values()).map(PlaybackAV1SettingsValues::getValue).collect(Collectors.toList());
            }
        }
    }

    @PageObject
    @Getter
    public static class PrivacySettingsSubPage{
        @FindBy(xpath = "//tp-yt-paper-toggle-button")
        private List<WebElement> privacySettingsList;
        //---------------Links-----------------------------------------
        @FindBy(xpath = "//a[contains(@href, '/terms')]")
        private WebElement termsOfServiceLink;

        @FindBy(xpath = "//a[contains(@href, '/privacy')]")
        private WebElement googlePrivacyPolicyLink;

        @FindBy(xpath = "//a[contains(@href, '/7280190')]")
        private WebElement changePlaylistPrivacyHelpLink;

        @FindBy(xpath = "//a[@href='/feed/channels']")
        private WebElement subscriptionChannelsListLink;

        @FindBy(xpath = "//a[contains(@href, 'settings/ads')]")
        private WebElement adsSettingsLink;

        @FindBy(xpath = "//a[contains(@href, 'families/answer')]")
        private WebElement googleAccountManagingWithFamilyLink;

        //-------------------------------------------------------------------
        public WebElement getPrivacySetting(PrivacySettingsValues setting){
            return privacySettingsList.stream().filter(webElement -> setting.getValue().equals(webElement.getAttribute("aria-label"))).findFirst().get();
        }

        @Getter
        public enum PrivacySettingsValues{
            KEEP_PLAYLIST_PRIVATE("Не показывать информацию о сохраненных плейлистах"), KEEP_SUBSCRIPTIONS_PRIVATE("Не показывать информацию о моих подписках");
            private String value;

            PrivacySettingsValues(String value){
                this.value = value;
            }

            public static List<String> getSettingsStringList(){
                return Arrays.stream(values()).map(PrivacySettingsValues::getValue).collect(Collectors.toList());
            }
        }
    }

    @PageObject
    @Getter
    public static class ConnectedAppsSettingsSubPage{
        @FindBy(xpath = "//a[contains(@href, 'myaccount.google.com/accountlinking')]")
        private WebElement connectedAppsFullListLink;

        @FindBy(xpath = "//ytd-connected-app-renderer//tp-yt-paper-button[@id='button']")
        private List<WebElement> appsList;

        public WebElement getAppForConnection(AppsForConnectionValues setting){
            return appsList.stream().filter(webElement -> webElement.getAttribute("aria-label").contains(setting.getValue())).findFirst().get();
        }

        @Getter
        public enum AppsForConnectionValues{
            ACTIVISION("Activision"),
            BATTLE_NET("Battle.net"),
            SUMMONERS_WAR("Summoners War"),
            EPIC_GAMES("Epic Games"),
            GARENA("Garena"),
            MLBB("MLBB"),
            NETEASE_KNIVES_OUT("NetEase Knives Out"),
            NETEASE_IDENTITY_V("NetEase Identity V"),
            PUBG("PUBG"),
            PUBG_MOBILE("PUBG MOBILE"),
            RIOT_GAMES("Riot Games"),
            SUPERSELL("Supercell"),
            UBISOFT("Ubisoft");
            private String value;

            AppsForConnectionValues(String value){
                this.value = value;
            }

            public static List<String> getSettingsStringList(){
                return Arrays.stream(values()).map(AppsForConnectionValues::getValue).collect(Collectors.toList());
            }
        }
    }

    @PageObject
    @Getter
    public static class BillingSettingsSubPage{
        @FindBy(xpath = "//a[contains(@href, 'password_authentication')]")
        private WebElement purchaseVerificationHelpLink;

        @FindBy(xpath = "//div[contains(text(), 'Функция быстрых покупок')]/ancestor::ytd-connected-app-renderer//div[@id='connect-button']")
        private WebElement quickPurchaseEnableButton;
    }

    @PageObject
    @Getter
    public static class AdvancedSettingsSubPage{
        @FindBy(xpath = "//div[text()='Идентификатор пользователя']/..//yt-button-renderer[@id='copy-button']")
        private WebElement userIdentificationCopyButton;
    }
}