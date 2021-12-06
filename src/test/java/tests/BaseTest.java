package tests;

import com.epam.reportportal.testng.ReportPortalTestNGListener;
import driver.SingletonDriver;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Listeners;
import spring.SpringConfig;
import utils.TestListener;

@Listeners({TestListener.class, ReportPortalTestNGListener.class})
@ContextConfiguration(classes = SpringConfig.class)
public class BaseTest extends AbstractTestNGSpringContextTests{

    @AfterSuite(alwaysRun = true)
    public void configureSuite(){
        SingletonDriver.closeDriver();
    }

}
