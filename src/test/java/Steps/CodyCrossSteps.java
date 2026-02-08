package Steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Quando;
import io.cucumber.java.pt.Então;
import org.junit.Assert;
import pages.HomePage;
import pages.LevelPage;

import java.util.Arrays;

public class CodyCrossSteps {

    private final HomePage homePage = new HomePage();
    private final LevelPage levelPage = new LevelPage();

    @Dado("que o aplicativo CodyCross foi aberto")
    public void que_o_aplicativo_foi_aberto() {
        Assert.assertTrue(
                "Tela inicial não foi exibida",
                homePage.telaInicialEstaVisivel()
        );
    }

    @Quando("acesso o primeiro nível do jogo")
    public void acesso_o_primeiro_nivel() {
        homePage.tocarNoPrimeiroNivel();
    }

    @Quando("seleciono as letras da palavra inicial")
    public void seleciono_as_letras_da_palavra_inicial() {

        levelPage.selecionarSequenciaDeLetras(
                Arrays.asList(0, 1, 2, 3)
        );
    }

    @Então("o progresso do nível deve ser atualizado")
    public void o_progresso_deve_ser_atualizado() {
        Assert.assertTrue(
                "Indicador de progresso não encontrado",
                levelPage.progressoEstaVisivel()
        );
    }
}