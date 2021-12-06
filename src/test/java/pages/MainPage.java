package pages;

<<<<<<< HEAD
import blocks.FilterBlock;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
=======
import blocks.SearchBlock;
import lombok.Getter;
>>>>>>> 7767d425fb033de428820ff149a064f86548f2e2
import org.springframework.beans.factory.annotation.Autowired;
import spring.annotations.PageObject;

@PageObject
@Getter
public class MainPage extends AbstractPage{
<<<<<<< HEAD

    @Autowired
    FilterBlock filterBlock;

    @FindBy(id = "search")
    private WebElement search;
    @FindBy(id = "logo-icon")
    private WebElement logoIcon;

    public void sad(){
        search.isDisplayed();
    }

=======
    @Autowired
    SearchBlock searchBlock;
>>>>>>> 7767d425fb033de428820ff149a064f86548f2e2
}
