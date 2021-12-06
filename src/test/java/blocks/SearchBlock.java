package blocks;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.AbstractPage;
import spring.annotations.Block;
import spring.annotations.PageObject;

@Block
@Getter
public class SearchBlock{
    @FindBy(id = "search")
    private WebElement self;

    @FindBy(id = "logo-icon")
    private WebElement logoIcon;

}
