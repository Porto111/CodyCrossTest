package utils;

import drivers.DriverFactory;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

public class OcrService {

    private final WebDriver driver;
    private final ITesseract tesseract;

    public OcrService() {
        this.driver = DriverFactory.getDriver();
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
     * Versão SIMPLES sem bounding box (usa OCR para validar se texto existe).
     * Para coordenadas, você pode usar coordenadas fixas da tela do CodyCross.
     */
    public boolean textoExisteNaTela(String textoProcurado) {
        String textoTela = getTextFromScreen().toLowerCase();
        return textoTela.contains(textoProcurado.toLowerCase());
    }

    /**
     * Versão com bounding box básico (sem RECOGNIZE_TYPE).
     * Se ainda der erro, comente essa parte e use coordenadas fixas.
     */
    public Point localizarTexto(String textoProcurado) {
        try {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            BufferedImage image = ImageIO.read(screenshot);

            // Usa doOCR com configurações simples (sem getWords problemático)
            String resultado = tesseract.doOCR(screenshot);

            // Por enquanto, retorna coordenadas "estimadas" baseadas no tamanho da tela
            // (ajuste conforme o seu device - use Appium Inspector para pegar)
            int screenWidth = driver.manage().window().getSize().getWidth();
            int screenHeight = driver.manage().window().getSize().getHeight();

            // Exemplo: "Jogar" fica tipicamente na parte inferior direita
            if (resultado.toLowerCase().contains(textoProcurado.toLowerCase())) {
                return new Point(screenWidth - 200, screenHeight - 300); // ajuste esses números
            }

            return null;
        } catch (Exception e) {
            throw new RuntimeException("Erro ao localizar texto via OCR", e);
        }
    }

    public boolean tocarNoTexto(String textoProcurado) {
        Point p = localizarTexto(textoProcurado);
        if (p == null) {
            return false;
        }
        // Chama o tap da BasePage (você passa isso de fora)
        ((pages.BasePage) driver).tap(p.x, p.y); // ← ajuste para chamar o seu método tap
        return true;
    }
}
