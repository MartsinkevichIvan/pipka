package tests;

import driver.SingletonDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;
import utils.Wait;

@Test
public class SingleTest extends BaseTest{
    @Autowired
    MainPage page;

    @Test
    public void checkSearchDisplayed(){
        SingletonDriver.getDriver().get("https://www.youtube.com/");
        Wait.forMillis(3000);
        Assert.assertTrue(page.getSearchBlock().getLogoIcon().isDisplayed());
    }
}
