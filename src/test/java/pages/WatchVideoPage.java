package pages;

import blocks.Listing;
import blocks.VideoCard;
import driver.SingletonDriver;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import spring.annotations.PageObject;

import java.util.List;

@PageObject
@Getter
public class WatchVideoPage extends AbstractPage {


    //    @Autowired
    @FindBy(xpath = "//div[@id='secondary' and @class=\"style-scope ytd-watch-flexy\"]")
//WatchVideoPageSecondaryColumn secondaryColumn;
            WebElement secondaryColumn;

    /*
    VIDEO PLAYER
     */
    @FindBy(xpath = "//button[@class='ytp-play-button ytp-button']")
    private WebElement playerPlayPauseButton;
    @FindBy(xpath = "//button[@class='ytp-next-button ytp-button']")
    private WebElement playerNextButton;
    @FindBy(xpath = "//button[@class='ytp-mute-button ytp-button']")
    private WebElement playerMuteButton;
    @FindBy(xpath = "//button[@class='ytp-volume-slider-handle']")
    //style="left: 40px;" from 0 to 40px
    private WebElement playerVolumeSlider;
    @FindBy(xpath = "//span[@class='ytp-time-current']")
    private WebElement playerCurrentTime;
    @FindBy(xpath = "//span[@class='ytp-time-duration']")
    private WebElement playerDurationTime;
    @FindBy(xpath = "//div[@class='ytp-autonav-toggle-button']")
    //aria-checked='true'; true - turned on, false - turned off
    private WebElement playerAutonavToggleButton;
    @FindBy(xpath = "//button[@class='ytp-button ytp-settings-button']")
    // //button[@class='ytp-button ytp-settings-button' and @aria-expanded='true']
    //or css ariaExpanded=true
    private WebElement playerSettingsButton;
    @FindBy(xpath = "//button[@class='ytp-mute-button ytp-button']")
    private WebElement playerMiniPlayerButton;
    @FindBy(xpath = "//button[@class='ytp-size-button ytp-button']")
    private WebElement playerWideScreenButton;
    @FindBy(xpath = "//button[@class='ytp-fullscreen-button ytp-button']")
    private WebElement playerFullScreenButton;


    private List<VideoCard> videoCardList = Listing.getListing(SingletonDriver.getDriver().findElements(By.xpath(".//ytd-compact-video-renderer[@class='style-scope ytd-watch-next-secondary-results-renderer']")), VideoCard.class);

    /*
    Video info box
     */
    @FindBy(xpath = "//span[@class='view-count style-scope ytd-video-view-count-renderer']")
    private WebElement infoViewsCounter;


    @FindBy(xpath = "//yt-icon[@class='style-scope ytd-toggle-button-renderer']")
    //button attribute iconName_ = like
    private WebElement infoButtonLike;


    /*
    Video Author Info
     */
    @FindBy(xpath = "//div[@class='style-scope ytd-video-secondary-info-renderer']/child::div[@id='subscribe-button']")
    private WebElement authorSubscribeButton;


    /*
    Commentaries
     */
    @FindBy(xpath = "//span[@class='style-scope yt-formatted-string']/ancestor::h2")
    //or h2[@class='style-scope ytd-comments-header-renderer']
    private WebElement commentariesCounter;


}
