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
                .setAutomationName("UIAutomator2")
                // App já instalado: informar apenas o package e permitir auto-discovery da activity
                .setAppPackage(TestConfig.APP_PACKAGE)
                .setAppActivity(TestConfig.APP_ACTIVITY) // REMOVIDO para evitar erro de Activity inexistente
                .setNoReset(true) // manter dados do app
                .setAutoGrantPermissions(true) // conceder permissões automaticamente
                .setAppWaitForLaunch(false); // não aguardar lançamento se já estiver em foreground

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