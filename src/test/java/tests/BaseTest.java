package tests;

import driver.SingletonDriver;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterSuite;
import spring.SpringConfig;

@ContextConfiguration(classes = SpringConfig.class)
public class BaseTest extends AbstractTestNGSpringContextTests{

    @AfterSuite(alwaysRun = true)
    public void configureSuite(){
        SingletonDriver.closeDriver();
    }

}
