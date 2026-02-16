package utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

import java.io.File;

public class OcrService {

    private WebDriver driver;
    private final Tesseract tesseract;

    public OcrService() {
        this.driver = driver;
        this.tesseract = new Tesseract();

        // Ajuste esse caminho para a pasta tessdata na sua máquina
        // (onde ficam os arquivos .traineddata)
        tesseract.setDatapath("C:/tessdata");
        // Idiomas que você quer usar
        tesseract.setLanguage("por+eng");
    }

    /**
     * Tira um screenshot da tela atual e devolve o texto reconhecido via OCR.
     */
    public String getTextFromScreen() {
        try {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            return tesseract.doOCR(screenshot);
        } catch (TesseractException e) {
            throw new RuntimeException("Erro ao executar OCR no screenshot", e);
        }
    }

    public boolean tocarNoTexto(String jogar) {
        return false;
    }
}
