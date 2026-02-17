package Steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.HomePage;
import pages.LevelPage;

import java.time.Duration;

import static drivers.DriverFactory.driver;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CodyCrossSteps {
    private final HomePage homePage = new HomePage();
    private final LevelPage levelPage = new LevelPage();

    @Dado("que o aplicativo CodyCross foi aberto")
    public void queOAplicativoCodyCrossFoiAberto() {

        String packageName = "com.fanatee.cody"; // ajuste para o pacote real

        // Garante que o app está instalado
        if (!driver.isAppInstalled(packageName)) {
            throw new IllegalStateException("App CodyCross não está instalado no dispositivo.");
        }

        // Garante que o app está aberto (se já não foi aberto pelas capabilities)
        driver.activateApp(packageName); // ou driver.launchApp() se usar desired capabilities

        // Espera explícita até a primeira tela carregar
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
        // Troque o localizador abaixo por algo confiável da tela inicial do CodyCross
        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//android.widget.TextView[@content-desc=\"CodyCross\"]"))
        );
    }

    @Quando("eu toco no botão {string}")
    public void euTocoNoBotao(String botao) {
        // No momento suportamos especificamente o botão "Jogar"
        homePage.tocarBotaoJogar();
    }


    @Então("devo ver a tela de splash com logo {string}")
    public void devoVerTelaSplashLogo(String logo) {
        assertTrue(homePage.esperarTextoVisivel(logo, 10), "Logo não encontrado via OCR");
    }

    @Dado("que o aplicativo CodyCross foi aberto")
    public void que_o_aplicativo_codycross_foi_aberto() {
        // aqui você já garante que o app está iniciado e a home carregou
        boolean visivel = homePage.telaInicialEstaVisivel();
        Assert.assertTrue("Tela inicial do CodyCross não está visível.", visivel);
    }

    @Quando("eu tocar no botão Jogar")
    public void eu_tocar_no_botao_jogar() {
        homePage.tocarBotaoJogar();
    }

    @Quando("eu tocar no botão Salvar progresso")
    public void eu_tocar_no_botao_salvar_progresso() {
        homePage.tocarBotaoSalvarProgresso();
    }

    @Entao("a tela inicial do primeiro nível deve ser exibida")
    public void a_tela_inicial_do_primeiro_nivel_deve_ser_exibida() {
        boolean visivel = homePage.esperarTextoVisivel("Nível 1", 15);
        Assert.assertTrue("Tela do primeiro nível não apareceu.", visivel);
    }
}


