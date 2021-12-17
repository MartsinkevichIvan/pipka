package blocks.navigationSubBlocks;

import blocks.HeaderBlock;
import blocks.checkers.checkCommonElements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import spring.annotations.Block;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@Block
public class UserHistory {

    @FindBy(xpath = "//yt-formatted-string[text()='Библиотека']//ancestor::ytd-guide-section-renderer")
    private WebElement self;

    @FindBy (xpath = "//yt-formatted-string[text()='Библиотека']//ancestor::ytd-guide-section-renderer//a")
    private List<WebElement> elementsOfUserHistory;

    public enum UserHistoryValuesEnum implements Supplier<String> {

        MAIN("Библиотека"),
        NAVIGATOR("История");

        private String value;

        UserHistoryValuesEnum(String value) {
            this.value = value;
        }

        @Override
        public String get() {
            return value;
        }

        public static List<String> getTexts(){
            return Arrays.stream(values()).map(UserHistoryValuesEnum::get).collect(Collectors.toList());
        }
    }
}
