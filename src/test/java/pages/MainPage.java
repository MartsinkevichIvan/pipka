package pages;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import spring.annotations.PageObject;

@PageObject
@Getter
public class MainPage extends AbstractPage{
    @FindBy(id = "search")
    private WebElement search;
    @FindBy(id = "logo-icon")
    private WebElement logoIcon;



}
