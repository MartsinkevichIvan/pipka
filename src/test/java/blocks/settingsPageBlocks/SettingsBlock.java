package blocks.settingsPageBlocks;

import blocks.videoPlayer.VideoPlayer;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import spring.annotations.Block;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.lang.String.format;

@Block
@Getter
public class SettingsBlock {

    @FindBy(xpath = "//ytd-settings-sidebar-renderer[@class='style-scope ytd-browse']")
    private WebElement self;

    public WebElement getTitle(){
        return getSelf().findElement(By.xpath("//div[text()='Настройки']"));
    }

//----------------------Using pattern ---------------------------------
//    private static final String MENU_SETTINGS_PATTERN =  "//yt-formatted-string[contains(text(), '%s')]/../../..";
//    public WebElement getSetting(Settings setting){
//        return getSelf()
//                .findElement(By.xpath(format(MENU_SETTINGS_PATTERN, setting.getSetting())));
//    }

    @FindBy(xpath = "//ytd-compact-link-renderer")
    private List<WebElement> menuSection;

    public WebElement getSetting(Settings setting){
        return menuSection.stream().filter(webElement -> setting.getSetting().equals(webElement.getText())).findFirst().get();
    }

    @Getter
    public enum Settings{
        ACCOUNT("Аккаунт"),
        NOTIFICATIONS("Уведомления"),
        PLAYBACK("Воспроизведение"),
        PRIVACY("Конфиденциальность"),
        SHARING("Связанные приложения"),
        BILLING("Расчеты и платежи"),
        ADVANCED("Расширенные настройки");

        private String setting;

        Settings(String setting){
            this.setting = setting;
        }

        public static List<String> getSettingsStringList(){
            return Arrays.stream(values())
                    .map(Settings::getSetting)
                    .collect(Collectors.toList());
        }
    }
}
