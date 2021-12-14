package pages;

import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import spring.annotations.PageObject;

@PageObject
@Getter
public class LoginPage extends AbstractPage{
    @FindBy(xpath = "//input[@type='email']")
    WebElement emailInput;

    @FindBy(xpath = "//div[@id='identifierNext']")
    WebElement nextButton;
}
