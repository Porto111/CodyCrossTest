package pages;

import drivers.DriverFactory;
import org.openqa.selenium.By;
import utils.WaitUtils;

public abstract class BasePage {

    protected void click(By locator) {
        WaitUtils.waitForClickable(locator);
        DriverFactory.getDriver().findElement(locator).click();
    }

    protected boolean isVisible(By locator) {
        try {
            WaitUtils.waitForVisible(locator);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}