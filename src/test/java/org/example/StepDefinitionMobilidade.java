package org.example;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Quando;
import org.example.PageObjects.Home;

public class StepDefinitionMobilidade {

    @Quando("clico na opção Mapa das estações")
    public void clicoNaOpçãoMapaDasEstações() throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Home home = new Home(driver);
        Thread.sleep(3000);
        home.buscarMapaMobilidade();

    }
}