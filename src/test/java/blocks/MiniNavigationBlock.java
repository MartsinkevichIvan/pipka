package blocks;

import blocks.checkers.checkCommonElements;
import driver.SingletonDriver;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import spring.annotations.Block;

import java.util.List;
import java.util.function.Supplier;

@Block
@Getter
public class MiniNavigationBlock implements checkCommonElements {

    @FindBy (xpath = "//ytd-mini-guide-renderer[@role='navigation']")
    private WebElement self;

    @Override
    public List<WebElement> getCommonWebElementsOfBlock() {
        return SingletonDriver.getDriver().findElements(By.xpath("//ytd-mini-guide-renderer//a"));
    }

    public enum MiniNavigationValuesEnum implements Supplier<String> {

        MAIN("Главная"),
        NAVIGATOR("Навигатор"),
        SUBSCRIPTIONS("Подписки"),
        LIBRARY("Библиотека"),
        HISTORY("История");

        private String value;

        MiniNavigationValuesEnum(String value) {
            this.value = value;
        }

        @Override
        public String get() {
            return value;
        }
    }

    public boolean blockIsDisplayed(){
        return SingletonDriver.getDriver().findElements(By.xpath("//ytd-mini-guide-renderer[@role='navigation']")).size() != 0;
    }
}
