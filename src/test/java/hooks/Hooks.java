package hooks;

import drivers.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

    @Before
    public void iniciarSessao() {
        DriverFactory.getDriver();
    }

    @After
    public void finalizarSessao() {
        DriverFactory.quitDriver();
    }
}