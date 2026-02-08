package hooks;

import drivers.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import static drivers.DriverFactory.getDriver;

public class Hooks {

    @Before
    public void iniciarSessao() {
        getDriver();
    }

    @After
    public void finalizarSessao() {
        DriverFactory.quitDriver();
    }
}