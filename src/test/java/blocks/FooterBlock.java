package blocks;

import blocks.checkers.checkCommonElements;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import spring.annotations.Block;
import java.util.List;
import java.util.function.Supplier;

@Block
@Getter
public class FooterBlock implements checkCommonElements {

    @FindBy(xpath = "//ytd-guide-renderer[@id='guide-renderer']//div[@id='footer']")
    private WebElement self;

    @Override
    public List<WebElement> getCommonWebElementsOfBlock() {
        return self.findElements(By.xpath(".//div[@id='footer']//a"));
    }

    public enum FooterValues implements Supplier<String> {

        ABOUT_SERVICE("О сервисе"),
        PRESS("Прессе"),
        COPYRIGHT("Авторские права"),
        CONTACT_US("Связаться с нами"),
        CREATORS("Авторам"),
        ADVERTISERS("Рекламодателям"),
        DEVELOPERS("Разработчикам"),
        TERMS("Условия использования"),
        PRIVACY("Конфиденциальность"),
        POLICIES("Правила и безопасность"),
        HOW_YOUTUBE_WORKS("Как работает YouTube"),
        TESTING_NEW_FUNCTIONS("Тестирование новых функций");

        private String value;

        FooterValues(String value) {
            this.value = value;
        }

        @Override
        public String get() {
            return value;
        }
    }
}
