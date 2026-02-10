package pages;

public class HomePage extends BasePage {

    public void tocarBotaoJogar() {
        ocrService.tocarNoTexto("Jogar");
    }

    public void selecionarPrimeiroNivel() {
        ocrService.tocarNoTexto("Nível 1");
    }

    public boolean telaInicialEstaVisivel() {
        return esperarTextoVisivel("CodyCross", 10) || esperarTextoVisivel("Jogar", 10);
    }
}
