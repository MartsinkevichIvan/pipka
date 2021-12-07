package tests;

import driver.SingletonDriver;
import org.openqa.selenium.JavascriptExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;
import pages.WatchVideoPage;
import utils.Wait;

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
        System.out.println("getLocation = " + watchVideoPage.getSecondaryColumn().thumbnailImages().getLocation());
        Assert.assertTrue(watchVideoPage.getSecondaryColumn().thumbnailImages().isDisplayed());
        Wait.forMillis(5000);
        //Assert.assertTrue(page.getLogoIcon().isDisplayed());
    }
}
