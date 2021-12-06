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


    WebElement self;

    @FindBy(xpath = "//a[@id='thumbnail']")
    WebElement thumbnailImages;


    public WatchVideoPageSecondaryColumn(){
        this.self = SingletonDriver.getDriver().findElement(By.xpath("//div[@id='secondary' and @class=\"style-scope ytd-watch-flexy\"]"));
    }

    public WatchVideoPageSecondaryColumn(WebElement element){
        this.self = element;
    }

}
