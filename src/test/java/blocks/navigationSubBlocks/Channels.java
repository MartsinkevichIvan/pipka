package blocks.navigationSubBlocks;

import blocks.checkers.checkCommonElements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import spring.annotations.Block;

import java.util.List;
import java.util.function.Supplier;

@Block
public class Channels implements checkCommonElements {

    @FindBy(xpath = "//a[@href='/feed/guide_builder']//ancestor::ytd-guide-section-renderer")
    private WebElement self;


    @Override
    public List<WebElement> getCommonWebElementsOfBlock() {

        return self.findElements(By.xpath(".//a"));
    }

    public enum ChannelsValuesEnum implements Supplier<String> {

        CHANNELS("Каталог каналов");

        private String value;

        ChannelsValuesEnum(String value) {
            this.value = value;
        }

        @Override
        public String get() {
            return value;
        }
    }
}
