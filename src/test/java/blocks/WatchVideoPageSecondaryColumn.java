package blocks;

import driver.SingletonDriver;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;
import spring.annotations.Block;

@Block
@Getter
public class WatchVideoPageSecondaryColumn {

    @FindBy(xpath = "//div[@id='secondary' and @class='style-scope ytd-watch-flexy']")
    private WebElement self;
    @FindBy(xpath = "//a[@id='thumbnail']")
//    @FindBy(xpath = "//div[@id='secondary']/descendant::a[@id='thumbnail']")
    private WebElement thumbnailImages;


    public WebElement thumbnailImages(){
        return getSelf().findElement(By.xpath("//a[@id='thumbnail']"));
    }
    @FindBy(xpath = "//span[@id='video-title']")
    private WebElement videoTitle;
    @FindBy(xpath = "//yt-formatted-string[@class='style-scope ytd-channel-name']")
    private WebElement channelName;
    @FindBy(xpath = "//div[@id='metadata-line']//span[@class='style-scope ytd-video-meta-block'][1]")
    private WebElement viewCounter;
    @FindBy(xpath = "//div[@id='metadata-line']//span[@class='style-scope ytd-video-meta-block'][2]")
    private WebElement dateCounter;
    @FindBy(xpath = "//yt-icon[@class='style-scope ytd-menu-renderer']")
    private WebElement threeDotsMenu;
    @FindBy(xpath = "//tp-yt-paper-item[@class='style-scope ytd-menu-service-item-renderer']")
    private WebElement addToQueueLink;
    @FindBy(xpath = "//div[@class=\"playlist-items style-scope ytd-playlist-panel-renderer\"]/ancestor::ytd-playlist-panel-renderer[@class='style-scope ytd-watch-flexy']")
    private WebElement playlistMainModal;




//    public WatchVideoPageSecondaryColumn(){
//        this.self = SingletonDriver.getDriver().findElement(By.xpath("//div[@id='secondary' and @class=\"style-scope ytd-watch-flexy\"]"));
//    }
//
//    public WatchVideoPageSecondaryColumn(WebElement element){
//        this.self = element;
//    }

}
