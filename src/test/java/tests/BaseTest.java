package tests;

import driver.SingletonDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.MainPage;
import service.PropertyDataReader;
import spring.SpringConfig;
import utils.TestListener;

@Listeners(TestListener.class)
@ContextConfiguration(classes = SpringConfig.class)
public class BaseTest extends AbstractTestNGSpringContextTests implements PropertyDataReader {
    @Autowired
    MainPage page;

    @BeforeMethod(alwaysRun = true)
    public void configurePage() {
        SingletonDriver.getDriver().get(getUrl(MAIN));
    }

    @AfterMethod(alwaysRun = true)
    public void configureSuite() {
        SingletonDriver.deleteCookies();
    }

    @AfterSuite(alwaysRun = true)
    public void deleteSuite() {
        SingletonDriver.closeDriver();
    }
}
