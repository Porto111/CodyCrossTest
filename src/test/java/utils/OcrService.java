package utils;

import drivers.DriverFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import net.sourceforge.tess4j.Word;

import java.awt.Rectangle;
import java.io.File;
import java.util.List;

public class OcrService {

    private final WebDriver driver;
    private final ITesseract tesseract;

    public OcrService() {
        this.driver = DriverFactory.getDriver();   // pega o driver atual
        this.tesseract = new Tesseract();
        tesseract.setDatapath("C:/tessdata");
        tesseract.setLanguage("por+eng");
    }

    public String getTextFromScreen() {
        try {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            return tesseract.doOCR(screenshot);
        } catch (TesseractException e) {
            throw new RuntimeException("Erro ao executar OCR no screenshot", e);
        }
    }

    /**
     * Procura o texto e devolve o centro do bounding box.
     */
    public java.awt.Point localizarTexto(String textoProcurado) {
        try {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            // reconhece palavra a palavra com bounding box
            List<Word> words = tesseract.getWords(screenshot, ITesseract.RECOGNIZE_TYPE_TEXTLINE);

            for (Word w : words) {
                if (w.getText().equalsIgnoreCase(textoProcurado)) {
                    Rectangle rect = w.getBoundingBox();
                    int centerX = rect.x + rect.width / 2;
                    int centerY = rect.y + rect.height / 2;
                    return new java.awt.Point(centerX, centerY);
                }
            }
            return null;
        } catch (TesseractException e) {
            throw new RuntimeException("Erro ao executar OCR no screenshot", e);
        }
    }

    /**
     * Localiza o texto via OCR e toca nas coordenadas encontradas.
     */
    public boolean tocarNoTexto(String textoProcurado) {
        java.awt.Point p = localizarTexto(textoProcurado);
        if (p == null) {
            return false;
        }
        tapFn.accept(p.getX(), p.getY());
        return true;
    }
}
