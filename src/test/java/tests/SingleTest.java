package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

@Test
public class SingleTest extends BaseTest{

    @Test
    public void checkSearchDisplayed(){
        Assert.assertTrue(page.getHeaderBlock().getSearchBlock().getSearchField().isDisplayed());
    }

    @Test
    public void testShouldFail(){
        Assert.fail();
    }
}