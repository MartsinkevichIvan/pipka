package blocks.navigationSubBlocks;

import blocks.checkers.checkCommonElements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import spring.annotations.Block;

import java.util.List;
import java.util.function.Supplier;

@Block
public class BestOnYoutube implements checkCommonElements {

    @FindBy(xpath = "//yt-formatted-string[text()='Лучшее на YouTube']//ancestor::ytd-guide-section-renderer")
    private WebElement self;

    @Override
    public List<WebElement> getCommonWebElementsOfBlock() {
        return self.findElements(By.xpath(".//a"));
    }

    public enum BestOnYoutubeValues implements Supplier<String> {

        MUSIC("Музыка"),
        SPORT("Спорт"),
        GAMES("Видеоигры"),
        NEWS("Новости"),
        TRANSLATIONS("Трансляции"),
        PANORAMIC_VIDEOS("Панорамные видео");

        private String value;

        BestOnYoutubeValues(String value) {
            this.value = value;
        }

        @Override
        public String get() {
            return value;
        }
    }
}
