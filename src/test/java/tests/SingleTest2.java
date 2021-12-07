package tests;

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

@Test
public class SingleTest2 extends BaseTest{
    @Autowired
    MainPage page;

    @Autowired
    WatchVideoPage watchVideoPage;

    @Test
    public void checkSearchDisplayed(){
        SingletonDriver.getDriver().get("https://www.youtube.com/watch?v=SLe3dhLIHjI");
        Wait.forMillis(4000);
        System.out.println(watchVideoPage.getSecondaryColumn().getVideoTitle().getText());
        //Assert.assertTrue(watchVideoPage.getSecondaryColumn().thumbnailImages().isDisplayed());
        Wait.forMillis(2000);
    }
}
