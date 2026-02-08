package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;

public class HomePage extends BasePage {

    private final By botaoPrimeiroNivel = By.id("com.fanatee.codycross:id/btn_play");

    public void tocarNoPrimeiroNivel() {
        click(botaoPrimeiroNivel);
    }

    public boolean telaInicialEstaVisivel() {
        return isVisible(botaoPrimeiroNivel);
    }



//    // Método para mapear os elementos da aplicação através das coordenadas (placeholders)
//    // Preencher de acordo com os valores do seu dispositivo
//
//    private final Point btnMenuPerfil = new Point(101,174);
//    private final Point btnMenuOpt = new Point(959,170);
//    private final Point btnLoginFaceBk = new Point(1005,785);
//    private final Point btnFecharXSalvarProgresso = new Point(1010, 803);
//    private final Point btnFecharMenuPerfil = new Point(955, 151);
//    private final Point botaoPrimeiroNivel = new Point(202, 1491);
//    private final Point botaoConfig = new Point(532, 2079);
//    private final Point botaoJogar = new Point(542, 1808);
//
//    private final Point telaHome = new Point(188, 2299);
//    private final Point telaLoja = new Point(991, 2359);
//    private final Point telaEventos = new Point(243, 2336);
//    private final Point telaSocial = new Point(445,2338 );
//    private final Point telaBiblioteca = new Point(629, 2350);
//
//    public void tocarNoPrimeiroNivel() { tap(botaoPrimeiroNivel); }
//    public void abrirConfigur() { tap(btnMenuOpt); }
//    public void tocarContinuaracoes() { tap(botaoJogar); }
//
//    // As validações abaixo não possuem checagem visual por coordenadas; mantidas como stubs.
//    public boolean telaInicialEstaVisivel() { pause(300); return true; }
//    public boolean tituloVisivel() { pause(100); return true; }
//    public boolean moedasVisiveis() { pause(100); return true; }
//    public boolean bannerMissaoDiariaVisivel() { pause(100); return true; }
}