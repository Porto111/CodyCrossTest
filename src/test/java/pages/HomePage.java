package pages;

import org.openqa.selenium.By;

public class HomePage extends BasePage {

    private final By botaoPrimeiroNivel =
            By.id("com.fanatee.codycross:id/btn_play");

    public void tocarNoPrimeiroNivel() {
        click(botaoPrimeiroNivel);
    }

    public boolean telaInicialEstaVisivel() {
        return isVisible(botaoPrimeiroNivel);
    }
}