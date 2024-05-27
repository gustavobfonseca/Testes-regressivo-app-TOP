package org.example;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.*;
import io.cucumber.java.pt.*;
import org.example.PageObjects.*;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;
import java.io.IOException;

import java.io.File;
import java.io.IOException;
import java.sql.Driver;

import static org.junit.Assert.assertTrue;

public class DefinicaoPassosCucumber {
    AppiumDriver driver = AppiumDriverConfig.Instance().driver;
    Login telaLogin = new Login(driver);

    @Dado("que estou na área não logada do app")
    public void anExampleScenario() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Login telaLogin = new Login(driver);

    }

    @Quando("submeto minhas credenciais inválidas para login")
    public void allStepDefinitionsAreImplemented() throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Login telaLogin = new Login(driver);

        telaLogin.buscarElementos();
        telaLogin.preencherFormulario("327.721.478-86", "SenhaIncorreta");
        telaLogin.logar();
    }

    @Entao("visualizo o modal de CPF e, ou Senha inválidos")
    public void theScenarioPasses() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Login telaLogin = new Login(driver);

        telaLogin.buscarModalErro();
        Assert.assertEquals("CPF e/ou senha inválidos.", telaLogin.getModalErro().getText());

    }


    @After
    public void includeScreenshot(Scenario scenario) throws IOException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;

        if(scenario.isFailed()) {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            byte[] fileContent = FileUtils.readFileToByteArray(screenshot);
            scenario.attach(fileContent, "image/png", "image1");
        }}

    @Quando("submeto minhas credenciais válidas para login")
    public void submetoMinhasCredenciaisVálidasParaLogin() throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Login telaLogin = new Login(driver);


        telaLogin.buscarElementos();
        telaLogin.preencherFormulario("327.721.478-86", "Devires@123");
        telaLogin.logar();
    }


    @Entao("acesso a home do aplicativo")
    public void acessoAHomeDoAplicativo() throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;

        Home telaHome = new Home(driver);

        telaHome.esperarBotaoBiometria();
        telaHome.clicarBotaoAtivarBiometria();

        telaHome.arrastarModalParaBaixo();

        //Assert.assertEquals("Tenha uma boa viagem.", telaHome.getMsgBoaViagem().getText());
        Assert.assertEquals("BUG teste", telaHome.getMsgBoaViagem().getText());
    }
}
