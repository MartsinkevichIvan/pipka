package utils;

import com.epam.reportportal.testng.ReportPortalTestNGListener;
import driver.SingletonDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;

public class TestListener extends ReportPortalTestNGListener {

    private Logger log = LogManager.getRootLogger();

    @Override
    public void onTestStart(ITestResult iTestResult) {
        super.onTestStart(iTestResult);
        log.info("TEST " + iTestResult.getName() + " STARTED SUCCESSFULLY");
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        log.info("TEST " + iTestResult.getName() + " PASSED SUCCESSFULLY");
        super.onTestSuccess(iTestResult);
    }

    @Override
    public void onTestFailure(ITestResult testResult) {
        log.info("RP_MESSAGE#BASE64#{}#{}",
                ((TakesScreenshot) SingletonDriver
                        .getDriver())
                        .getScreenshotAs(OutputType.BASE64),
                "TEST " + testResult.getName() + " FAILED");
        super.onTestFailure(testResult);
    }
}