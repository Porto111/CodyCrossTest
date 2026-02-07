package utils;

import config.TestConfig;
import drivers.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;


import java.time.Duration;

public class WaitUtils {

    private static FluentWait<WebDriver> getWait() {
        WebDriver driver = DriverFactory.getDriver();
        return new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(TestConfig.DEFAULT_TIMEOUT))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);
    }

    public static void waitForVisible(By locator) {
        try {
            getWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (TimeoutException e) {
            throw new TimeoutException("Elemento não ficou visível dentro do timeout: " + locator, e);
        }
    }

    public static void waitForClickable(By locator) {
        try {
            getWait().until(ExpectedConditions.elementToBeClickable(locator));
        } catch (TimeoutException e) {
            throw new TimeoutException("Elemento não ficou clicável dentro do timeout: " + locator, e);
        }
    }
}

