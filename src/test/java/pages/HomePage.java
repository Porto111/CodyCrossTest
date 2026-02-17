package pages;

public class HomePage extends BasePage {

    public void tocarBotaoJogar() {
        if (!tocarPorTexto("Jogar")) {
            throw new RuntimeException("Texto 'Jogar' não encontrado na tela via OCR.");
        }
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
