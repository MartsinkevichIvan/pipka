package tests;

import driver.SingletonDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;
import utils.Wait;
import utils.pageUtils.FilterBlockUtil;

@Test
public class SingleTest extends BaseTest{

    @Autowired
    MainPage page;

    @Test
    public void checkSearchDisplayed(){
        SingletonDriver.getDriver().get("https://www.youtube.com/");
        Wait.forMillis(3000);
        var elements = page.getFilterBlock().getFiltersList();

        page.getFilterBlock().getFiltersList();

    }
}
