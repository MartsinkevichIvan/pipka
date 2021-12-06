package blocks;

import java.util.List;
import driver.SingletonDriver;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.springframework.beans.factory.annotation.Autowired;
import spring.annotations.Block;

@Block
@Getter
public class FilterBlock{

//    @Autowired
    WebElement self;


    private List<WebElement> filtersList = SingletonDriver.getDriver().findElements
            (By.xpath("//div[@class='style-scope ytd-rich-grid-renderer' and @id='header']//iron-selector/yt-chip-cloud-chip-renderer/yt-formatted-string"));

//    @FindAll({
//            @FindBy(xpath = "//iron-selector/yt-chip-cloud-chip-renderer/yt-formatted-string[text()='Все']"),
//            @FindBy(xpath = "//iron-selector/yt-chip-cloud-chip-renderer/yt-formatted-string[text()='Сейчас в эфире']")
//    })
//    private List<WebElement>listOfFilters;


}
