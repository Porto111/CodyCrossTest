package pages;

public class HomePage extends BasePage {

//    public void tocarBotaoJogar() {
//        if (!tocarPorTexto("Jogar")) {
//            throw new RuntimeException("Texto 'Jogar' não encontrado na tela via OCR.");
//        }
//    }

    public void tocarBotaoJogar() throws InterruptedException {
        // DEBUG: veja EXATAMENTE o que o OCR leu
        Thread.sleep(30000);
        System.out.println("=== OCR leu: '" + ocrService.getTextFromScreen() + "'");

        if (!ocrService.textoExisteNaTela("Jogar")) {
            throw new RuntimeException("Texto 'Jogar' não encontrado via OCR.");
        }
        tap(543, 1790); // suas coordenadas
    }

    public void tocarBotaoSalvarProgresso() {
        if (!tocarPorTexto("Salvar progresso")) {
            throw new RuntimeException("Texto 'Salvar progresso' não encontrado na tela via OCR.");
        }
    }

    public void selecionarPrimeiroNivel() {
        if (!tocarPorTexto("Nível 1")) {
            throw new RuntimeException("Texto 'Nível 1' não encontrado na tela via OCR.");
        }
    }

    public boolean telaInicialEstaVisivel() {
        return esperarTextoVisivel("CodyCross", 10) || esperarTextoVisivel("Jogar", 10);
    }
}
