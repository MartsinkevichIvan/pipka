package tests;

import driver.SingletonDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import pages.MainPage;
import service.UrlDataReader;
import spring.SpringConfig;
import utils.TestListener;

@Listeners(TestListener.class)
@ContextConfiguration(classes = SpringConfig.class)
public class BaseTest extends AbstractTestNGSpringContextTests implements UrlDataReader {
    protected final int WAITING_TIME = 10;

    @Autowired
    MainPage page;

    @BeforeSuite(alwaysRun = true)
    public void configurePage(){
        SingletonDriver.getDriver().get(UrlDataReader.getUrl("youTubeUrls", "main"));
    }

    @AfterSuite(alwaysRun = true)
    public void configureSuite(){
        SingletonDriver.closeDriver();
    }

}
