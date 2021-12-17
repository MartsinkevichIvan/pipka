package blocks.elements;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


@Getter
public class Toogle extends BaseElementBlock{
    WebElement self;

    public Toogle(WebElement self){
        this.self = self;
    }

    private final WebElement toogle = getSelf().findElement(By.id("toggle"));
    private final WebElement title = getSelf().findElement(By.id("title"));
    private final WebElement subTitle = getSelf().findElement(By.id("subtitle"));

    public boolean isActive(){
        return getToogle().getAttribute("aria-pressed").equals("true");
    }

    public Toogle set(boolean value){
        if(isActive() ^ value) getToogle().click();
        return this;
    }
}
