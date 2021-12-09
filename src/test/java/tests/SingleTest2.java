package tests;

import blocks.VideoPlayer;
import driver.SingletonDriver;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.WatchVideoPage;
import utils.Wait;

import java.util.List;
import java.util.stream.Collectors;

@Test
public class SingleTest2 extends BaseTest{
    @Autowired
    MainPage page;

    @Autowired
    WatchVideoPage watchVideoPage;

    @Test
    public void checkSearchDisplayed(){
        SingletonDriver.getDriver().get("https://www.youtube.com/watch?v=BGtDUl-HJqY");
        Wait.forMillis(4000);
        watchVideoPage.getVideoPlayer().getPlayerSettingsButton().click();
        Wait.forMillis(500);
        watchVideoPage.getVideoPlayer().getPlayerContextMenu().click();
        Wait.forMillis(500);
        var texts = watchVideoPage.getVideoPlayer().getPlayerSubtitlesList().stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
        for(String str: texts){
            System.out.println(str);
        }


        Assert.assertTrue(VideoPlayer.PlayerQuality.getTexts().containsAll(texts));

//        System.out.println(watchVideoPage.getSecondaryColumn().getVideoTitle().getText());
        //Assert.assertTrue(watchVideoPage.getSecondaryColumn().thumbnailImages().isDisplayed());
        Wait.forMillis(2000);
    }
}
