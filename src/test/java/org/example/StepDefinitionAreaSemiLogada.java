package org.example;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.cucumber.java.eo.Se;
import io.cucumber.java.pt.*;
import org.example.PageObjects.*;
import org.junit.Assert;

import java.util.concurrent.ExecutionException;

import static org.junit.Assert.assertTrue;

public class StepDefinitionAreaSemiLogada {

    @Dado("que realizo o logout para a área semi logada do app, estando com a biometria habilitada")
    public void queRealizoOLogoutParaAÁreaSemiLogadaDoAppEstandoComABiometriaHabilitada() throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Login telaLogin = new Login(driver);
        telaLogin.buscarElementos();
        telaLogin.limparCamposLogin();
        telaLogin.preencherFormulario("13715099054", "Devires@123");
        telaLogin.logar();

        Home telaHome = new Home(driver);

        telaHome.esperarBotaoBiometria();
        telaHome.clicarBotaoAtivarBiometria();

        try {
            telaHome.arrastarModalParaBaixo();
        } catch (Exception e) {
            telaHome.clicarBotaoModalQueroConhecer();
        }
        Assert.assertEquals("Tenha uma boa viagem.", telaHome.getMsgBoaViagem().getText());

        telaHome.deslogar();
    }
    @Dado("que realizo o logout para a área semi logada do app, estando com a biometria desabilitada")
    public void queRealizoOLogoutParaAÁreaSemiLogadaDoAppEstandoComABiometriaDesabilitada() throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Login telaLogin = new Login(driver);
        telaLogin.buscarElementos();
        telaLogin.limparCamposLogin();
        telaLogin.preencherFormulario("13715099054", "Devires@123");
        telaLogin.logar();

        Home telaHome = new Home(driver);

        telaHome.esperarBotaoBiometria();
        telaHome.clicarBotaoAtivarBiometria();

        try {
            telaHome.arrastarModalParaBaixo();
        } catch (Exception e) {
            telaHome.clicarBotaoModalQueroConhecer();
        }
        Assert.assertEquals("Tenha uma boa viagem.", telaHome.getMsgBoaViagem().getText());

        telaHome.desativarBiometria();
    }

    @Quando("submeto a senha correta do CPF")
    public void submetoASenhaCorretaDoCPF() throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        SemiLogado semiLogado = new SemiLogado(driver);

        semiLogado.buscarElementos();
        semiLogado.preencherSenhaPadrao();

    }

    @E("clico em \"Entrar\" na área semi logada")
    public void clicoEmEntrar() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        SemiLogado semiLogado = new SemiLogado(driver);

        semiLogado.clicarBotaoEntrar();
    }

    @Então("sou logado para a home do aplicativo com o modal de ativação de biometria")
    public void souLogadoParaAHomeDoAplicativoComOModalDeAtivaçãoDeBiometria() throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Home telaHome = new Home(driver);

        Thread.sleep(3000);
        telaHome.esperarBotaoBiometria();
        telaHome.clicarBotaoAtivarBiometria();

        telaHome.buscarMensagemBemVindo();
//        Assert.assertEquals("Tenha uma boa viagem.", telaHome.getMsgBoaViagem().getText());
    }

    @Então("visualizo a solicitação de biometria para login")
    public void visualizoOModalTelaDeSolicitaçãoDeBiometriaParaLogin() throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        SemiLogado semiLogado = new SemiLogado(driver);

        semiLogado.buscarMensagemSenhaObrigatoria();
        driver.navigate().back();
        semiLogado.buscarElementos();
    }

    @Dado("que acesso a área semi logada do aplicativo")
    public void queAcessoAÁreaSemiLogadaDoAplicativo() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        SemiLogado semiLogado = new SemiLogado(driver);

        semiLogado.buscarElementos();
    }


    @Quando("clico em \"Esqueci minha senha.\"")
    public void clicoEmEsqueciMinhaSenha() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        SemiLogado semiLogado = new SemiLogado(driver);
        semiLogado.buscarElementos();
        semiLogado.getLinkEsqueciMinhaSenha().click();
    }

    @Quando("submeto a senha incorreta para o CPF")
    public void submetoASenhaIncorretaParaOCPF() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        SemiLogado semiLogado = new SemiLogado(driver);

        semiLogado.buscarElementos();
        semiLogado.preencherSenha("SenhaIncorreta@123");

    }

    @Então("visualizo o modal de CPF e, ou senha incorretos")
    public void visualizoOModalDeCPFEOuSenhaIncorretos() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Login telaLogin = new Login(driver);

        telaLogin.buscarModalErro();
        Assert.assertEquals("CPF e/ou senha inválidos.", telaLogin.getModalErro().getText());
        telaLogin.buscarBotaoFecharModalCPFSenha();
        telaLogin.clicarBotaoFecharModalCPFSenha();

        SemiLogado semiLogado = new SemiLogado(driver);
        semiLogado.buscarElementos();
    }
}
