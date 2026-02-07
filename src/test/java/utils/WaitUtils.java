package utils;

import config.TestConfig;

import drivers.DriverFactory;

import org.openqa.selenium.By;

import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {

    private static WebDriverWait wait() {

        return new WebDriverWait(

                DriverFactory.getDriver(),

                Duration.ofSeconds(TestConfig.DEFAULT_TIMEOUT)

        );

    }

    public static void waitForVisible(By locator) {

        wait().until(ExpectedConditions.visibilityOfElementLocated(locator));

    }

    public static void waitForClickable(By locator) {

        wait().until(ExpectedConditions.elementToBeClickable(locator));

    }

}

