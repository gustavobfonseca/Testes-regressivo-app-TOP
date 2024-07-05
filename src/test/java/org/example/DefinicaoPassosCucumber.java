package org.example;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.*;
import io.cucumber.java.pt.*;
import org.example.PageObjects.*;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;

import java.io.File;
import java.io.IOException;
import java.sql.Driver;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

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
        assertTrue(telaLogin.getTextoModalContaBloqueada().isDisplayed());
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
        assertTrue(telaEsqueciSenha.getTextoModalContaBloqueada().isDisplayed());
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
        assertTrue(telaEsqueciminhaSenha.getMsgCPFInvalido().isDisplayed());

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
        //paginaMeusBilhetes.clicarFormasDePgto();
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
        telaMeusBilhetes.buscarBotaoVoltarParaHome();
        telaMeusBilhetes.clicarBotaoVoltarParaHome();
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
    public void insiroOToken() throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        EsqueciMinhaSenha telaEsqueciminhaSenha = new EsqueciMinhaSenha(driver);

        telaEsqueciminhaSenha.buscarInput0();
        telaEsqueciminhaSenha.clicarInput0();
        Thread.sleep(3000);
        String token = OTPUtils.getOTPtokenByPhoneNumberOrEmail("+5514996237865");
        telaEsqueciminhaSenha.inserirInputs(token);
    }

    @E("confirmo Cartão de débito como forma de pagamento")
    public void confirmoCartãoDeDébitoComoFormaDePagamento() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        MeusBilhetes telaMeusBilhetes = new MeusBilhetes(driver);

        telaMeusBilhetes.buscarOpcaoCartaoDebito();
        telaMeusBilhetes.clicarOpcaoDebito();
        telaMeusBilhetes.clicarBotaoConfirmarFormaPagamento();
    }




    @E("submeto as informações corretas do cartão")
    public void submetoAsInformaçõesCorretasDoCartão(DataTable dataTable) {
        List<Map<String, String>> dados = dataTable.asMaps(String.class, String.class);
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        InserirDadosCartao paginaCartoes = new InserirDadosCartao(driver);
        for(Map<String, String> linha : dados) {
            String nomeCartao = linha.get("NomeCartao");
            String numeroCartao = linha.get("numeroCartao");
            String validadeCartao = linha.get("dtVal");
            String cvvCartao = linha.get("cvv");
            String cpfTitular = linha.get("numCelular");

            paginaCartoes.buscarElementos();
            paginaCartoes.preencherFormularioCadastroCartao(nomeCartao, numeroCartao, validadeCartao, cvvCartao, cpfTitular);

        }
    }

    @E("submeto as credenciais para login")
    public void submetoAsCredenciaisParaLogin(DataTable dataTable) throws InterruptedException {
        List<Map<String, String>> dados = dataTable.asMaps(String.class, String.class);
        for(Map<String, String> linha : dados){
            String argumento1 = linha.get("cpf");
            String argumento2 = linha.get("senha");

            AppiumDriver driver = AppiumDriverConfig.Instance().driver;
            Login telaLogin = new Login(driver);

            telaLogin.buscarElementos();
            telaLogin.limparCamposLogin();
            telaLogin.preencherFormulario(argumento1, argumento2);
            telaLogin.logar();
        }
    }

    @E("clico na opção Formas de Pagamento")
    public void clicoNaOpçãoFormasDePagamento() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        MeusBilhetes paginaMeusBilhetes = new MeusBilhetes(driver);

        paginaMeusBilhetes.buscarElementos();
        paginaMeusBilhetes.clicarFormasDePgto();
    }

    @E("clico em Adicionar forma de pagamento")
    public void clicoEmAdicionarFormaDePagamento() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        MeusBilhetes paginaMeusBilhetes = new MeusBilhetes(driver);

        paginaMeusBilhetes.buscarElementosFormasDePagamento();
        paginaMeusBilhetes.clicarBotaoAdicionarFormaPagamento();
    }

    @E("clico na opção Cartão de crédito")
    public void clicoNaOpçãoCartãoDeCrédito() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        MeusBilhetes paginaMeusBilhetes = new MeusBilhetes(driver);

        paginaMeusBilhetes.buscarFormasDePagamento();
        paginaMeusBilhetes.clicarBotaoCartaoDeCreditoFormaPgto();
    }


    @Entao("visualizo a tela de Cartão cadastro com sucesso")
    public void visualizoATelaDeCartãoCadastroComSucesso() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        MeusBilhetes paginaMeusBilhetes = new MeusBilhetes(driver);

        paginaMeusBilhetes.buscarElementosTelaCadastroRealizado();
        assertTrue(paginaMeusBilhetes.getMsgCadastroCartaoSucesso().isDisplayed());
        paginaMeusBilhetes.clicarBotaoVoltarParaInicio();
    }

    @E("clico na opção excluir cartão")
    public void clicoNaOpçãoExcluirCartão() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        MeusBilhetes paginaMeusBilhetes = new MeusBilhetes(driver);

        paginaMeusBilhetes.buscarLixeiraExcluirCartao();
        paginaMeusBilhetes.clicarLixeiraExcluirCartao();
    }

    @E("confirmo a exclusão")
    public void confirmoAExclusão() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        MeusBilhetes paginaMeusBilhetes = new MeusBilhetes(driver);

        paginaMeusBilhetes.buscarBotaoConfirmarExclusaoCartao();
        paginaMeusBilhetes.clicarBotaoConfirmarExclusaoCartao();
    }

    @Entao("o cartão não deverá estar listado")
    public void oCartãoNãoDeveráEstarListado() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        //Thread.sleep(10000);
        WebDriverWait espera = new WebDriverWait(driver, 50);
        espera.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@content-desc=\"ADICIONAR FORMA DE PAGAMENTO\"]")));


    }

    @E("volto para o menu")
    public void voltoParaOMenu() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        MeusBilhetes paginaMeusBilhetes = new MeusBilhetes(driver);


    }

    @E("clico na opção Cartão de débito")
    public void clicoNaOpçãoCartãoDeDébito() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        MeusBilhetes paginaMeusBilhetes = new MeusBilhetes(driver);

        paginaMeusBilhetes.buscarFormasDePagamento();
        paginaMeusBilhetes.clicarBotaoCartaoDeDebitoFormaPgto();
    }

    @Entao("visualizo a tela de falha no cadastro")
    public void visualizoATelaDeFalhaNoCadastro() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        MeusBilhetes telaMeusBilhetes = new MeusBilhetes(driver);

        telaMeusBilhetes.buscarElementosTelaFalhaCadastro();
        assertTrue(telaMeusBilhetes.getMsgFalhaCadastroCartao().isDisplayed());
        telaMeusBilhetes.buscarBotaoVoltarParaOInicio();
        telaMeusBilhetes.clicarBotaoVoltarParaHome();
    }

    @E("eu desligo a conexão de internet do dispositivo")
    public void euDesligoAConexãoDeInternetDoDispositivo() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        driver.executeScript("mobile: shell", ImmutableMap.of("command", "svc wifi disable"));
        driver.executeScript("mobile: shell", ImmutableMap.of("command", "svc data disable"));
    }

    @E("clico na opção Acessar meus bilhetes Offline")
    public void clicoNaOpçãoAcessarMeusBilhetesOffline() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        MeusBilhetes telaMeusBilhetes = new MeusBilhetes(driver);

        telaMeusBilhetes.buscarElementosTelaSemConexao();
        telaMeusBilhetes.clicarBotaoAcessarBilhetesOffline();

    }

    @E("submeto as seguintes credenciais validas para login, cpf {string}, senha {string}")
    public void submetoAsSeguintesCredenciaisValidasParaLoginCpfSenha(String arg0, String arg1) throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Login telaLogin = new Login(driver);


        telaLogin.buscarElementos();
        telaLogin.limparCamposLogin();
        telaLogin.preencherFormulario(arg0, arg1);
        telaLogin.logar();
    }

    @Entao("visualizo a lista de bilhetes disponiveis para uso")
    public void visualizoAListaDeBilhetesDisponiveisParaUso() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        MeusBilhetes telaMeusBilhetes = new MeusBilhetes(driver);

        telaMeusBilhetes.buscarMensagemListaDeBilhetes();
        assertTrue(telaMeusBilhetes.getMsgListaDeBilhetes().isDisplayed());

    }

    @E("reestabeleço a conexão com a internet")
    public void reestabeleçoAConexãoComAInternet() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        driver.executeScript("mobile: shell", ImmutableMap.of("command", "svc wifi enable"));
        driver.executeScript("mobile: shell", ImmutableMap.of("command", "svc data enable"));
    }

    @E("clico em tentar novamente")
    public void clicoEmTentarNovamente() throws InterruptedException {
        Thread.sleep(7000);
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        MeusBilhetes telaMeusBilhetes = new MeusBilhetes(driver);

        telaMeusBilhetes.buscarElementosTelaSemConexao();
        telaMeusBilhetes.clicarBotaoTentarNovamente();
    }

    @Entao("visualizo a tela de formas de pagamento")
    public void visualizoATelaDeFormasDePagamento() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        MeusBilhetes telaMeusBilhetes = new MeusBilhetes(driver);

        telaMeusBilhetes.buscarCartoesEmFormasDePgto();
        assertTrue(telaMeusBilhetes.getCartaoDeCredito().isDisplayed());
    }

    @E("clico no ultimo registro de compra no historico")
    public void clicoNoUltimoRegistroDeCompraNoHistorico() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        MeusBilhetes telaMeusBilhetes = new MeusBilhetes(driver);

        telaMeusBilhetes.buscarUltimaCompraDeBilhete();
        telaMeusBilhetes.clicarUltimaCompraDeBilhete();
    }

    @Entao("visualizo o modal com os detalhes da compra")
    public void visualizoOModalComOsDetalhesDaCompra() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        MeusBilhetes telaMeusBilhetes = new MeusBilhetes(driver);

        telaMeusBilhetes.buscarModalDetalhesCompra();
        Assert.assertTrue(telaMeusBilhetes.getModalDetalhesCompra().isDisplayed());
    }

    @Quando("eu habilito o mock do token no perfil do usuario")
    public void euHabilitoOMockDoTokenNoPerfilDoUsuario() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Home telaHome = new Home(driver);

        telaHome.buscarFotoDePerfil();
        telaHome.clicarFotoDePerfil();
        telaHome.scrolAteOpcaoMock();
        telaHome.clicarBotaoMockTokenGemalto();
        driver.navigate().back();
    }

    @E("confirmo saldo disponível como forma de pagamento")
    public void confirmoSaldoDisponívelComoFormaDePagamento() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        MeusBilhetes telaMeusBilhetes = new MeusBilhetes(driver);

        telaMeusBilhetes.buscarOpcaoSaldoEmConta();
        telaMeusBilhetes.clicarSaldoEmConta();
        telaMeusBilhetes.clicarBotaoConfirmarFormaPagamento();

    }

    @E("confirmo o pagamento informando a senha correta {string}")
    public void confirmoOPagamentoInformandoASenhaCorreta(String arg0) {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        MeusBilhetes telaMeusBilhetes = new MeusBilhetes(driver);

        telaMeusBilhetes.buscarInputSenhaSaldoEmConta();
        telaMeusBilhetes.clicarInput0SenhaSaldoEmConta();
        telaMeusBilhetes.inserirSenhaConta(arg0);
        telaMeusBilhetes.clicarBotaoConfirmarCompra();
    }
}


