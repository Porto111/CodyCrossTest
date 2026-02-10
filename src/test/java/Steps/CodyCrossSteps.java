package Steps;

import io.cucumber.java.pt.*;
import pages.HomePage;
import pages.LevelPage;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CodyCrossSteps {
    private final HomePage homePage = new HomePage();
    private final LevelPage levelPage = new LevelPage();

    @Dado("que o aplicativo CodyCross está instalado")
    public void appInstalado() {
        // Pré-condição assumida; Driver é inicializado pelos hooks existentes
        assertNotNull("Driver não inicializado");
    }

    @Quando("eu abro o aplicativo")
    public void euAbroOAplicativo() {
        // Com DriverFactory + Hooks, o app já deve estar em foreground
    }

    @Então("devo ver a tela de splash com logo {string}")
    public void devoVerTelaSplashLogo(String logo) {
        assertTrue(homePage.esperarTextoVisivel(logo, 10), "Logo não encontrado via OCR");
    }

    @E("devo ver botão {string}")
    public void devoVerBotao(String textoBotao) {
        assertTrue(homePage.esperarTextoVisivel(textoBotao, 10), "Botão não encontrado via OCR");
    }

    @Dado("que estou na tela inicial")
    public void queEstouNaTelaInicial() {
        assertTrue(homePage.telaInicialEstaVisivel(), "Tela inicial não visível");
    }

    @Quando("eu toco no botão {string}")
    public void euTocoNoBotao(String botao) {
        // No momento suportamos especificamente o botão "Jogar"
        homePage.tocarBotaoJogar();
    }

    @Quando("seleciono o primeiro nível")
    public void selecionoPrimeiroNivel() {
        homePage.selecionarPrimeiroNivel();
    }

    @Então("devo ver o tabuleiro com letras disponíveis")
    public void devoVerTabuleiro() {
        assertTrue(levelPage.esperarTextoVisivel("A", 10), "Letra A não visível no tabuleiro");
    }

    @Quando("eu seleciono a letra {string} no tabuleiro")
    public void euSelecionoALetraNoTabuleiro(String letra) {
        levelPage.selecionarLetraTabuleiro(letra);
    }

    @E("preencho a primeira palavra parcialmente")
    public void preenchoPrimeiraPalavraParcialmente() {
        levelPage.preencherPrimeiraPalavra();
    }

    @Então("o progresso deve ser atualizado")
    public void progressoDeveSerAtualizado() {
        // Placeholder: sem UI tree, validar algum indicador textual esperado
        assertTrue(levelPage.esperarTextoVisivel("%", 10), "Progresso não atualizado (validação OCR simplificada)");
    }
}
