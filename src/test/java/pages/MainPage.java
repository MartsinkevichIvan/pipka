package pages;

import blocks.FilterBlock;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;
import spring.annotations.PageObject;

@PageObject
@Getter
public class MainPage extends AbstractPage{

    @Autowired
    FilterBlock filterBlock;

    @FindBy(id = "search")
    private WebElement search;
    @FindBy(id = "logo-icon")
    private WebElement logoIcon;

    public void sad(){
        search.isDisplayed();
    }

}
