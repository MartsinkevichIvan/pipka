package tests;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.MainPage;

@Test
public class SingleTest extends BaseTest{
    @Autowired
    MainPage page;

    @Test
    public void checkSearchDisplayed(){
        Assert.assertTrue(page.getSearchBlock().getLogoIcon().isDisplayed());
    }

    @Test
    public void testShouldFail(){
        Assert.fail();
    }
}