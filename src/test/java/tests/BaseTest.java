package tests;

import driver.SingletonDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.*;
import pages.MainPage;
import service.PropertyDataReader;
import spring.SpringConfig;
import utils.TestListener;

@Listeners(TestListener.class)
@ContextConfiguration(classes = SpringConfig.class)
public class BaseTest extends AbstractTestNGSpringContextTests implements PropertyDataReader {

    @Autowired
    MainPage page;

    @BeforeTest(alwaysRun = true)
    public void configurePage(){
        SingletonDriver.getDriver().get(getUrl(MAIN));
    }

    @AfterMethod(alwaysRun = true)
    public void configureSuite(){
        SingletonDriver.closeDriver();
    }

}
