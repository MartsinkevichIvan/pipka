package utils;

import driver.SingletonDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.annotation.CheckReturnValue;
import javax.annotation.ParametersAreNonnullByDefault;
import java.time.Duration;

import static java.lang.System.nanoTime;
import static java.util.concurrent.TimeUnit.MILLISECONDS;

@ParametersAreNonnullByDefault
public class Wait{
    private final long startTimeNano;
    private final long timeoutNano;
    private static final int EXPLICIT_WAIT_TIMEOUT = 10;

    public Wait(long timeoutMs){
        startTimeNano = nanoTime();
        timeoutNano = MILLISECONDS.toNanos(timeoutMs);
    }

    @CheckReturnValue
    public boolean isTimeoutReached(){
        return nanoTime() - startTimeNano > timeoutNano;
    }

    public void sleep(long milliseconds){
        if(isTimeoutReached()) return;
        try{
            Thread.sleep(milliseconds);
        }catch(InterruptedException e){
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }

    /**
     * Sleep at least given number of milliseconds.
     * Default {@link Thread#sleep(long)} doesn't guarantee the sleep duration, it can awake earlier.
     *
     * @param milliseconds the number of milliseconds to sleep
     */
    public static void forMillis(long milliseconds){
        Wait stopwatch = new Wait(milliseconds);
        do{
            stopwatch.sleep(milliseconds);
        }while(!stopwatch.isTimeoutReached());
    }

    public static WebElement waitForVisibilityOfElement(WebElement webElement){
        return new WebDriverWait(SingletonDriver.getDriver(), Duration.ofSeconds(EXPLICIT_WAIT_TIMEOUT)).until(ExpectedConditions.visibilityOf(webElement));
    }

    public static WebElement waitForElementToBeClickable(WebElement webElement){
        return new WebDriverWait(SingletonDriver.getDriver(), Duration.ofSeconds(EXPLICIT_WAIT_TIMEOUT)).until(ExpectedConditions.elementToBeClickable(webElement));
    }
}
