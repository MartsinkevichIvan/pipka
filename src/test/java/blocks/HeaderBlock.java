package blocks;

import blocks.checkers.checkCommonElements;
import driver.SingletonDriver;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;
import spring.annotations.Block;

import java.util.List;
import java.util.function.Supplier;

@Block
@Getter
public class HeaderBlock implements checkCommonElements {

    @Autowired
    SearchBlock searchBlock;

    @FindBy(xpath = "//div[@id='masthead-container']")
    private WebElement self;

    @FindBy(xpath = "//div[@id='start']//a[@id='logo']")
    protected WebElement logoIcon;

    @FindBy(xpath = "//div[@id='start']//yt-icon-button[@id='guide-button']")
    private WebElement btnGuide;

    @FindBy(xpath = "//ytd-button-renderer[@class='style-scope ytd-masthead style-suggestive size-small']")
    private WebElement btnSignIn;

    @FindBy(xpath = "//ytd-topbar-menu-button-renderer//button[@aria-label='Настройки']")
    private WebElement dropDownMenuSettings;

    @FindBy(xpath = "//ytd-topbar-menu-button-renderer//button[@aria-label='Приложения YouTube']")
    private WebElement dropDownAppsYoutube;

    @Override
    public List<WebElement> getCommonWebElementsOfBlock() {
        return SingletonDriver.getDriver().findElements(By.xpath(".//ytd-compact-link-renderer"));
    }

    public enum YoutubeApps implements Supplier<String> {

        YOUTUBE_TV("YouTube TV"),
        YOUTUBE_MUSIC("YouTube Music"),
        YOUTUBE_FOR_KIDS("YouTube Детям"),
        YOUTUBE_FOR_MUSICIANS("YouTube для музыкантов");

        private String value;

        YoutubeApps(String value) {
            this.value = value;
        }

        @Override
        public String get() {
            return value;
        }
    }
}
