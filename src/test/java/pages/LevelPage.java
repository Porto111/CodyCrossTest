package pages;

import drivers.DriverFactory;

import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;

import java.util.List;

public class LevelPage extends BasePage {

    private final By letrasDisponiveis =

            By.id("com.fanatee.codycross:id/letter");

    private final By indicadorProgresso =

            By.id("com.fanatee.codycross:id/progress");

    public void selecionarSequenciaDeLetras(List<Integer> indices) {

        List<WebElement> letras =

                DriverFactory.getDriver().findElements(letrasDisponiveis);

        for (Integer index : indices) {

            letras.get(index).click();

        }

    }

    public boolean progressoEstaVisivel() {

        return isVisible(indicadorProgresso);

    }

}

