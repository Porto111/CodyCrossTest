package pages;

public class LevelPage extends BasePage {



    public void preencherPrimeiraPalavra() {
        // Placeholder: tocar em um slot detectável por OCR/visual
        ocrService.tocarNoTexto("slot");
    }

    public void selecionarLetraTabuleiro(String letra) {
        if (!tocarPorTexto("letra")) {
            throw new RuntimeException("Texto 'letra' não encontrado na tela via OCR.");
        }
    }

}
