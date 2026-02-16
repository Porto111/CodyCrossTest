package pages;

public class LevelPage extends BasePage {

    public void selecionarLetraTabuleiro(String letra) {
        ocrService.tocarNoTexto(letra);
    }

    public void preencherPrimeiraPalavra() {
        // Placeholder: tocar em um slot detectável por OCR/visual
        ocrService.tocarNoTexto("slot");
    }
}
