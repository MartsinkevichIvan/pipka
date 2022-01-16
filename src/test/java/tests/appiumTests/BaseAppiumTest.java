package tests.appiumTests;

import appiumDriver.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseAppiumTest {

    @BeforeMethod(groups = "mobile")
    public void createSession() {
        DriverManager.getAppiumDriver().get("https://www.youtube.com");
    }

    @AfterTest(alwaysRun = true)
    public void closeSession() {
        DriverManager.closeAppiumDriver();
        DriverManager.closeAppium();
        DriverManager.closeEmulator();
    }
}
