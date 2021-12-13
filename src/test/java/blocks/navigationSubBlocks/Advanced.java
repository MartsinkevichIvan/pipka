package blocks.navigationSubBlocks;

import blocks.checkers.checkCommonElements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import spring.annotations.Block;

import java.util.List;
import java.util.function.Supplier;

@Block
public class Advanced implements checkCommonElements {

    @FindBy(xpath = "//yt-formatted-string[text()='Настройки']//ancestor::ytd-guide-section-renderer")
    private WebElement self;

    @Override
    public List<WebElement> getCommonWebElementsOfBlock() {
        return self.findElements(By.xpath("//a"));
    }

    public enum MainValuesEnum implements Supplier<String> {

        SETTINGS("Настройки"),
        REPORTS("Жалобы"),
        REFERENCE("Справка"),
        FEEDBACK("Отправить отзыв");

        private String value;

        MainValuesEnum(String value) {
            this.value = value;
        }

        @Override
        public String get() {
            return value;
        }
    }
}
