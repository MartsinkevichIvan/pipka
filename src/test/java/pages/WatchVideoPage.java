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

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@PageObject
@Getter
public class WatchVideoPage extends AbstractPage {


    @Autowired
    WatchVideoPageSecondaryColumn WatchVideoPageSecondaryColumn;
    @Autowired
    VideoPlayer videoPlayer;




    /*
    Video Primary info box
     */
    @FindBy(xpath = "//span[@class='view-count style-scope ytd-video-view-count-renderer']")
    private WebElement infoViewsCounter;
    @FindBy(xpath = "//yt-icon[@class='style-scope ytd-toggle-button-renderer']")
    //button attribute iconName_ = like
    private WebElement infoButtonLike;
    @FindBy(xpath = "//div[@class='style-scope ytd-video-primary-info-renderer' and @id='menu']")
    private WebElement infoPrimaryContainer;

    @FindBy(xpath = "//div[@id='menu-container']/descendant::button[@class='style-scope yt-icon-button'][1]")
    private WebElement infoPrimaryContainerLike;
    @FindBy(xpath = "//div[@id='menu-container']/descendant::button[@class='style-scope yt-icon-button'][2]")
    private WebElement infoPrimaryContainerDislike;
    @FindBy(xpath = "//div[@id='menu-container']/descendant::button[@class='style-scope yt-icon-button'][3]")
    private WebElement infoPrimaryContainerShare;
    @FindBy(xpath = "//div[@id='menu-container']/descendant::button[@class='style-scope yt-icon-button'][4]")
    private WebElement infoPrimaryContainerSave;
    @FindBy(xpath = "//yt-formatted-string[contains(text(),'Хотите добавить это видео в плейлист?')]")
    private WebElement infoPrimaryContainerSaveLoginPOPUP;
    @FindBy(xpath = "//div[@id='menu-container']/descendant::button[@class='style-scope yt-icon-button'][5]")
    private WebElement infoPrimaryContainerReport;



    /*
    Video Author Secondary Info
     */
    @FindBy(xpath = "//div[@class='style-scope ytd-video-secondary-info-renderer']/child::div[@id='subscribe-button']")
    private WebElement authorSubscribeButton;
    @FindBy(xpath = "//ytd-expander[@class='style-scope ytd-video-secondary-info-renderer']/child::div[@id='content']")
    private WebElement authorSecondaryInfobox;


    /*
    Commentaries
     */
    @FindBy(xpath = "//span[@class='style-scope yt-formatted-string']/ancestor::h2")
    //or h2[@class='style-scope ytd-comments-header-renderer']
    private WebElement commentariesCounter;
    @FindBy(xpath = "//div[@id='body']")
    private WebElement commentBody;
    @FindBy(xpath = "//div[@id='body']/child::div[@id='author-thumbnail']")
    private WebElement commentAuthorThumbnail;
    //name and comment date
    @FindBy(xpath = "//div[@id='body']/descendant::div[@id='header-author']")
    private WebElement commentAuthorHeader;
    @FindBy(xpath = "//div[@id='body']/descendant::div[@id='content']")
    private WebElement commentContentText;
    @FindBy(xpath = "//div[@id='body']/descendant::span[@id='vote-count-left']")
    private WebElement commentVoteCounter;
    @FindBy(xpath = "//div[@id='body']/preceding::div[@id='replies']")
    private WebElement commentExpandReplies;





}
