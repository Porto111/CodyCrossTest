package pages;

import drivers.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import utils.WaitUtils;

import java.time.Duration;
import java.util.Arrays;

public abstract class BasePage {

    protected final utils.OcrService ocrService = new utils.OcrService();

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

    protected String obterTexto(By locator) {
        WaitUtils.waitForVisible(locator);
        return DriverFactory.getDriver().findElement(locator).getText();
    }

    protected boolean exists(By locator) {
        try {
            WebElement el = DriverFactory.getDriver().findElement(locator);
            return el != null;
        } catch (NoSuchElementException e) {
            return false;
        }
    }


    //Método criaado para utilização das coordenadas posicionais
    // Tap por coordenadas (x, y) usando ações W3C
    protected void tap(int x, int y) {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence seq = new Sequence(finger, 1);
        seq.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), x, y));
        seq.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        seq.addAction(new Pause(finger, Duration.ofMillis(100)));
        seq.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        DriverFactory.getDriver().perform(Arrays.asList(seq));
    }

    protected void tap(Point p) {
        tap(p.getX(), p.getY());
    }


    protected void pause(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ignored) {
        }
    }

    public boolean esperarTextoVisivel(String texto, int timeoutSegundos) {
        // Delega para OCR service (pode tocar ao validar)
        return ocrService.tocarNoTexto(texto);
    }
}