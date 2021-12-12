package blocks;

import org.openqa.selenium.WebElement;

public class VideoCard extends Card {
    WebElement self;

    public VideoCard(WebElement el){
        this.self = el;
    }
}
