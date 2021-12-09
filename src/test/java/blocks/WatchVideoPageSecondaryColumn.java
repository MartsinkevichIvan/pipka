package blocks;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import spring.annotations.Block;

import java.util.List;

@Block
@Getter
public class WatchVideoPageSecondaryColumn {

    @FindBy(xpath = "//div[@id='secondary' and @class='style-scope ytd-watch-flexy']")
    private WebElement self;
    public WebElement getTumbnailImages(){
        return getSelf().findElement(By.xpath(".//a[@id='thumbnail']"));
    }
    public WebElement getVideoTitle(){
        return getSelf().findElement(By.xpath(".//span[@id='video-title']"));
    }
    public WebElement getChannelName(){
        return getSelf().findElement(By.xpath(".//yt-formatted-string[@class='style-scope ytd-channel-name']"));
    }
    public WebElement getViewCounter(){
        return getSelf().findElement(By.xpath(".//div[@id='metadata-line']//span[@class='style-scope ytd-video-meta-block'][1]"));
    }
    public WebElement getDateCounter(){
        return getSelf().findElement(By.xpath(".//div[@id='metadata-line']//span[@class='style-scope ytd-video-meta-block'][2]"));
    }
    public WebElement getThreeDotsMenu(){
        return getSelf().findElement(By.xpath(".//yt-icon[@class='style-scope ytd-menu-renderer']"));
    }
    public WebElement getAddToQueueLink(){
        return getSelf().findElement(By.xpath(".//tp-yt-paper-item[@class='style-scope ytd-menu-service-item-renderer']"));
    }

    /*
    Playlist box in the secondary column
     */
    public WebElement getPlaylistMainModal(){
        return getSelf().findElement(By.xpath(".//ytd-playlist-panel-renderer[@id='playlist']"));
    }
    public WebElement getRemoveALLItemsFromPlaylist(){
        return getSelf().findElement(By.xpath(".//div[@id='end-actions']"));
    }
    //all items
    public WebElement getPlaylistBoxItems(){
        return getSelf().findElement(By.xpath(".//div[@id='items' and @class='playlist-items style-scope ytd-playlist-panel-renderer']"));
    }
    //specific item
    public WebElement getPlaylistBoxItem(){
        return getSelf().findElement(By.xpath(".//ytd-playlist-panel-video-renderer[@id='playlist-items']"));
    }
    public WebElement getPlaylistBoxItemThumbnail(){
        return getSelf().findElement(By.xpath(".//a[@id='thumbnail']"));
    }
    public WebElement getPlaylistBoxItemVideoTitle(){
        return getSelf().findElement(By.xpath(".//span[@id='video-title']"));
    }
    public WebElement getPlaylistItemAuthor(){
        return getSelf().findElement(By.xpath(".//span[@id='byline']"));
    }


    /*
    Dialog Popup container
     */
    public WebElement getPopupContainer(){
        return getSelf().findElement(By.xpath(".//tp-yt-paper-dialog[@class='style-scope ytd-popup-container']"));
    }
    public WebElement getPopupContainerDismissButton(){
        return getSelf().findElement(By.xpath(".//ytd-button-renderer[@id='dismiss-button']"));
    }







}
