package drivers;

import config.TestConfig;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {

    private static AndroidDriver driver;

    public static AndroidDriver getDriver() {
        if (driver == null) {
            createDriver();
        }
        return driver;
    }

    private static void createDriver() {

        UiAutomator2Options options = new UiAutomator2Options()
                .setDeviceName(TestConfig.DEVICE_NAME)
                .setPlatformName(TestConfig.PLATFORM_NAME)
                .setAppPackage(TestConfig.APP_PACKAGE)
                .setAppActivity(TestConfig.APP_ACTIVITY)
                .setNoReset(TestConfig.NO_RESET);

        try {
            driver = new AndroidDriver(
                    new URL(TestConfig.APPIUM_URL),
                    options
            );
        } catch (MalformedURLException e) {
            throw new RuntimeException("URL do Appium inválida", e);
        }
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}