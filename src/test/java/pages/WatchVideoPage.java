package pages;

import blocks.VideoCard;
import blocks.VideoPlayer;
import blocks.WatchVideoPageSecondaryColumn;
import driver.CustomFieldDecorator;
import driver.SingletonDriver;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;
import spring.annotations.PageObject;

import java.util.List;

@PageObject
@Getter
public class WatchVideoPage extends AbstractPage {


    @Autowired
    WatchVideoPageSecondaryColumn WatchVideoPageSecondaryColumn;
    @Autowired
    VideoPlayer videoPlayer;




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
