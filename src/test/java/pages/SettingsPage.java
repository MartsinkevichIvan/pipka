package pages;

import blocks.settingsPageBlocks.SettingsBlock;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import spring.annotations.PageObject;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@PageObject
@Getter
public class SettingsPage extends AbstractPage {
    @Autowired
    SettingsBlock settingsBlock;
    @Autowired
    @Lazy
    AccountSettingSubPage accountSettingSubPage;
    @Autowired
    @Lazy
    NotificationSettingSubPage notificationSettingSubPage;

    @PageObject
    @Getter
    public static class AccountSettingSubPage {
        @FindBy(xpath = "//a[text()='Создать канал']")
        private WebElement createChannel;

        @FindBy(xpath = "//a[text()='Настроить аккаунт Google']")
        private WebElement googleAccountSettings;

        @FindBy(xpath = "//a[text()='Оформить YouTube Premium']")
        private WebElement youTubePremiumSubscription;
    }

    @PageObject
    @Getter
    public static class NotificationSettingSubPage {
//        @FindBy(xpath = "//*[@id='toggle']") //[not(contains(@aria-label, 'Уведомления в браузере'))]
//        private List<WebElement> notificationSettingsToggles;

//--------------------------- Split into 2 blocks-----------------
        @FindBy(xpath = "//*[text()='Общие']/ancestor::ytd-item-section-renderer//*[@id='toggle']")
        private List<WebElement> notificationSettingsToggles; // todo rename to generalNotificationToggles

        @FindBy(xpath = "//*[text()='Уведомления по электронной почте']/ancestor::ytd-item-section-renderer//*[@id='toggle']")
        private List<WebElement> emailNotificationToggles;

        @FindBy(xpath = "//a[@href='/feed/channels']")
        private WebElement subscriptionChannelsList;

        @Getter
        public enum NotificationSettingsValues{ // todo mean they are general (rename to GeneralNotificationSettingsValues
            BROWSER_NOTIFICATIONS("Уведомления в браузере"),
            SUBSCRIPTIONS("Подписки"),
            RECOMMENDED_VIDEO("Рекомендованные видео"),
            CHANNEL_ACTIONS("Действия на канале"),
            COMMENTS_ACTIONS("Действия с комментариями"),
            COMMENT_ANSWERS("Ответы на комментарии"),
            MENTIONS("Упоминания"),
            CONTENT_SHARING("Записи с моим контентом на других каналах"),
            FAMILY_RECOMMENDATIONS("Новости YouTube и YouTube Детям, а также рекомендации для всей семьи"),
            LAST_ACTION_ON_CHANNEL("Уведомления о последних действиях на моем канале и новости сервиса (кроме тех, на которые отменена подписка)"),
            YOUTUBE_GENERAL_NEWS("Общие новости YouTube"),
            YOUTUBE_PREMIUM_NEWS("Новости YouTube Premium"),
            AUTHOR_NEWS("Новости для авторов");
            private String text;
            NotificationSettingsValues(String text){
                this.text = text;
            }
            public static List<String> getSettingsStringList(){
                return Arrays.stream(values())
                        .map(NotificationSettingsValues::getText)
                        .collect(Collectors.toList());
            }
        }
        @Getter
        public enum EmailNotificationSettingsValues{
//            BROWSER_NOTIFICATIONS("Уведомления в браузере"),
//            SUBSCRIPTIONS("Подписки"),
//            RECOMMENDED_VIDEO("Рекомендованные видео"),
//            CHANNEL_ACTIONS("Действия на канале"),
//            COMMENTS_ACTIONS("Действия с комментариями"),
//            COMMENT_ANSWERS("Ответы на комментарии"),
//            MENTIONS("Упоминания"),
//            CONTENT_SHARING("Записи с моим контентом на других каналах"),
            FAMILY_RECOMMENDATIONS("Новости YouTube и YouTube Детям, а также рекомендации для всей семьи"),
            LAST_ACTION_ON_CHANNEL("Уведомления о последних действиях на моем канале и новости сервиса (кроме тех, на которые отменена подписка)"),
            YOUTUBE_GENERAL_NEWS("Общие новости YouTube"),
            YOUTUBE_PREMIUM_NEWS("Новости YouTube Premium"),
            AUTHOR_NEWS("Новости для авторов");
            private String text;
            EmailNotificationSettingsValues(String text){
                this.text = text;
            }
            public static List<String> getSettingsStringList(){
                return Arrays.stream(values())
                        .map(EmailNotificationSettingsValues::getText)
                        .collect(Collectors.toList());
            }
        }
    }
}
