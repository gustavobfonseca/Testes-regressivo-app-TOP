package org.example;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
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
        telaLogin.limparCamposLogin();
        telaLogin.preencherFormulario("327.721.478-86", "SenhaIncorreta");
        telaLogin.logar();
    }

    @Entao("visualizo o modal de CPF e, ou Senha inválidos")
    public void theScenarioPasses() throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Login telaLogin = new Login(driver);

        telaLogin.buscarModalErro();
        Assert.assertEquals("CPF e/ou senha inválidos.", telaLogin.getModalErro().getText());
        telaLogin.buscarBotaoFecharModalCPFSenha();
        telaLogin.clicarBotaoFecharModalCPFSenha();
        telaLogin.buscarElementos();
        telaLogin.limparCamposLogin();
    }

    @Quando("submeto minhas credenciais válidas para login")
    public void submetoMinhasCredenciaisVálidasParaLogin() throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Login telaLogin = new Login(driver);


        telaLogin.buscarElementos();
        telaLogin.limparCamposLogin();
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
        Assert.assertEquals("Tenha uma boa viagem.", telaHome.getMsgBoaViagem().getText());
    }

    @After
    public void includeScreenshot(Scenario scenario) throws IOException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;

        if(scenario.isFailed()) {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            byte[] fileContent = FileUtils.readFileToByteArray(screenshot);
            scenario.attach(fileContent, "image/png", "image1");
        }}

    @Quando("submeto minhas credenciais bloqueadas para login")
    public void submetoMinhasCredenciaisBloqueadasParaLogin() throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Login telaLogin = new Login(driver);


        telaLogin.buscarElementos();
        telaLogin.limparCamposLogin();
        telaLogin.preencherFormulario("73040542559", "Devires@123");
        telaLogin.logar();
    }


    @Entao("visualizo o modal de usuário bloqueado")
    public void visualizoOModalDeUsuárioBloqueado() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Login telaLogin = new Login(driver);

        telaLogin.buscarMensagemContaBloqueada();
        Assert.assertTrue(telaLogin.getTextoModalContaBloqueada().isDisplayed());
    }

    @Dado("que acesso a opção esqueci minha senha na área não logada")
    public void queAcessoAOpçãoEsqueciMinhaSenhaNaÁreaNãoLogada() throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Login telaLogin = new Login(driver);

        telaLogin.buscarElementos();
        telaLogin.limparCamposLogin();
        telaLogin.clicarEsqueciMinhaSenha();
    }

    @Quando("informo um CPF bloqueado")
    public void informoUmCPFBloqueado() throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        EsqueciMinhaSenha telaEsqueciSenha = new EsqueciMinhaSenha(driver);
        telaEsqueciSenha.buscarElementos();

        telaEsqueciSenha.preencherInputCpf("73040542559");
        telaEsqueciSenha.clicarBotaoConfirmar();
    }

    @Entao("visualizo o modal de usuário bloqueado na tela de esqueci minha senha")
    public void visualizoOModalDeUsuárioBloqueadoNaTelaDeEsqueciMinhaSenha() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        EsqueciMinhaSenha telaEsqueciSenha = new EsqueciMinhaSenha(driver);

        telaEsqueciSenha.buscarMensagemContaBloqueada();
        Assert.assertTrue(telaEsqueciSenha.getTextoModalContaBloqueada().isDisplayed());
    }

    @Quando("informo um CPF inválido")
    public void informoUmCPFInválido() throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        EsqueciMinhaSenha telaEsqueciminhaSenha = new EsqueciMinhaSenha(driver);
        telaEsqueciminhaSenha.buscarElementos();
        telaEsqueciminhaSenha.preencherInputCpf("12345678910");
        telaEsqueciminhaSenha.clicarBotaoConfirmar();
    }


    @Entao("visualizo a mensagem de Documento inválido")
    public void visualizoAMensagemDeDocumentoInválido() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        EsqueciMinhaSenha telaEsqueciminhaSenha = new EsqueciMinhaSenha(driver);
        telaEsqueciminhaSenha.buscarMensagemCPFInvalido();
        Assert.assertTrue(telaEsqueciminhaSenha.getMsgCPFInvalido().isDisplayed());

    }

    @E("reseto o app")
    public void resetoOApp() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Celular.resetApp(driver);
    }

    @E("clico em cancelar")
    public void clicoEmCancelar() throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        EsqueciMinhaSenha telaEsqueciminhaSenha = new EsqueciMinhaSenha(driver);

        telaEsqueciminhaSenha.buscarElementos();
        telaEsqueciminhaSenha.clicarBotaoCancelar();
    }



    @E("vou para a minha home do aplicativo")
    public void vouParaAMinhaHomeDoAplicativo() throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;

        Home telaHome = new Home(driver);

        telaHome.esperarBotaoBiometria();
        telaHome.clicarBotaoAtivarBiometria();

        telaHome.arrastarModalParaBaixo();
    }

    @Quando("que eu acesso o menu Bilhetes Qr Code na home do aplicativo tendo cartão de crédito cadastrado")
    public void queEuAcessoOMenuNaHomeDoAplicativoTendoCartãoDeCréditoCadastrado() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Home telaHome = new Home(driver);

        telaHome.buscarBotaoBilhetes();
        telaHome.clicarBotaoBilhetes();
    }

    @E("clico na opçao Comprar Bilhetes")
    public void clicoNaOpçaoComprarBilhetes() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        MeusBilhetes paginaMeusBilhetes = new MeusBilhetes(driver);

        paginaMeusBilhetes.buscarElementos();
        paginaMeusBilhetes.clicarBotaoComprarBilhetes();
    }

    @E("clico na opção CPTM, Metrô")
    public void clicoNaOpção() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        MeusBilhetes telaMeusBilhetes = new MeusBilhetes(driver);

        telaMeusBilhetes.buscarBotaoCPTM();
        telaMeusBilhetes.clicarBotaoCPTM();

    }

    @E("seleciono a quantidade de bilhetes")
    public void selecionoAQuantidadeDeBilhetes() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        MeusBilhetes telaMeusBilhetes = new MeusBilhetes(driver);
        telaMeusBilhetes.buscarBotaoUnidades();
        telaMeusBilhetes.clicarBotaoUnidades();
    }

    @E("confirmo Cartão de crédito como forma de pagamento")
    public void confirmoCartãoDeCréditoComoFormaDePagamento() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        MeusBilhetes telaMeusBilhetes = new MeusBilhetes(driver);

        telaMeusBilhetes.buscarOpcaoCartaoDeCredito();
        telaMeusBilhetes.clicarOpcaoCartaoDeCredito();
        telaMeusBilhetes.clicarBotaoConfirmarFormaPagamento();
    }

    @Então("visualizo a tela de Pagamento efetuado com sucesso")
    public void visualizoATelaDePagamentoEfetuadoComSucesso() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        MeusBilhetes telaMeusBilhetes = new MeusBilhetes(driver);

        telaMeusBilhetes.buscarMensagemCompraRealizadaComSucesso();
        assertTrue(telaMeusBilhetes.getMensagemCompraRealizadaComSucesso().isDisplayed());
        telaMeusBilhetes.buscarBotaoVoltarParaHome();
        telaMeusBilhetes.clicarBotaoVoltarParaHome();
    }

    @E("confirmo o pagamento informando o CVV {string}")
    public void confirmoOPagamentoInformandoOCVV(String arg0) {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        MeusBilhetes telaMeusBilhetes = new MeusBilhetes(driver);

        telaMeusBilhetes.buscarElementosConfirmarCompra();
        telaMeusBilhetes.inserirCvv(arg0);
        telaMeusBilhetes.clicarBotaoConfirmarCompra();
    }

    @Então("visualizo a tela de Erro no pagamento")
    public void visualizoATelaDeErroNoPagamento() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        MeusBilhetes telaMeusBilhetes = new MeusBilhetes(driver);

        telaMeusBilhetes.buscarMensagemFalhaNoPagamento();
        assertTrue(telaMeusBilhetes.getMensagemFalhaNoPagamento().isDisplayed());
    }

    @Quando("informo o seguinte CPF {string}")
    public void informoOSeguinteCPF(String arg0) throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        EsqueciMinhaSenha telaEsqueciminhaSenha = new EsqueciMinhaSenha(driver);
        telaEsqueciminhaSenha.buscarElementos();
        telaEsqueciminhaSenha.preencherInputCpf(arg0);
        telaEsqueciminhaSenha.clicarBotaoConfirmar();
    }

    @E("insiro o token")
    public void insiroOToken() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        EsqueciMinhaSenha telaEsqueciminhaSenha = new EsqueciMinhaSenha(driver);

        telaEsqueciminhaSenha.buscarInput0();
        telaEsqueciminhaSenha.clicarInput0();
        String token = OTPUtils.getOTPtokenByPhoneNumberOrEmail("32772147886");
        telaEsqueciminhaSenha.inserirInputs(token);
    }
}


