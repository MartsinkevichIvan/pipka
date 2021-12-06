package tests;

import driver.SingletonDriver;
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
        watchVideoPage.getVideoCardList();
        watchVideoPage.getSecondaryColumn().click();
        Wait.forMillis(5000);
        Assert.assertTrue(page.getLogoIcon().isDisplayed());
    }
}
