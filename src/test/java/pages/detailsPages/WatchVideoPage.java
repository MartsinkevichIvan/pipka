package pages.detailsPages;

import blocks.detailsBlocks.VideoPlayer;
import blocks.detailsBlocks.watchVideoPageBlocks.WatchVideoPageCommentaries;
import blocks.detailsBlocks.watchVideoPageBlocks.WatchVideoPageSecondaryColumn;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;
import pages.AbstractPage;
import spring.annotations.PageObject;

@PageObject
@Getter
public class WatchVideoPage extends AbstractPage{

    @Autowired
    WatchVideoPageSecondaryColumn WatchVideoPageSecondaryColumn;
    @Autowired
    VideoPlayer videoPlayer;
    @Autowired
    WatchVideoPageCommentaries pageCommentaries;
    @Autowired
    WatchVideoPagePrimaryInfoBox primaryInfoBox;
    @Autowired
    WatchVideoPageSecondaryInfoBox secondaryInfoBox;


    public static class WatchVideoPagePrimaryInfoBox extends AbstractPage{
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
    }
    public static class WatchVideoPageSecondaryInfoBox extends AbstractPage{
        /*
        Video Author Secondary Info
        */
        @FindBy(xpath = "//div[@class='style-scope ytd-video-secondary-info-renderer']/child::div[@id='subscribe-button']")
        private WebElement authorSubscribeButton;
        @FindBy(xpath = "//ytd-expander[@class='style-scope ytd-video-secondary-info-renderer']/child::div[@id='content']")
        private WebElement authorSecondaryInfobox;
    }













}
