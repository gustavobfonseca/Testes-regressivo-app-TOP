package org.example;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.cucumber.core.gherkin.Feature;
import io.cucumber.core.gherkin.Step;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.*;
import io.cucumber.java.en.Then;
import io.cucumber.java.pt.*;
import org.example.PageObjects.*;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
//import sun.jvm.hotspot.utilities.AssertionFailure;

import java.io.File;
import java.io.IOException;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class DefinicaoPassosCucumber {

    @Dado("que estou na área não logada do app")
    public void anExampleScenario() throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Login telaLogin = new Login(driver);
        Tela tela = new Tela(driver);
        Celular.autorizarLocalizacao(driver);
        Thread.sleep(3000);
        try{
            MobileElement confirmarNotificacoes = tela.buscarElementoNaTela("//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_allow_button\"]", 10);
            tela.clicarEmElemento(confirmarNotificacoes);
            System.out.println("Confirmação de notificações presente");

        }catch (Exception e){
            System.out.println("Confirmação de notificações não está presente, seguindo fluxo");
        }


        telaLogin.buscarElementos();
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

    @Quando("submeto minhas credenciais válidas para login, cpf {string} e senha {string}")
    public void submetoMinhasCredenciaisVálidasParaLogin(String cpf, String senha) throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Login telaLogin = new Login(driver);

        telaLogin.buscarElementos();
        telaLogin.limparCamposLogin();
        telaLogin.preencherFormulario(cpf, senha);
        telaLogin.logar();
    }


    @Entao("acesso a home do aplicativo")
    public void acessoAHomeDoAplicativo() throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;

        Home telaHome = new Home(driver);

        Thread.sleep(3000);
        telaHome.esperarBotaoBiometria();
//        telaHome.clicarBotaoAtivarBiometria();
        try {
            telaHome.arrastarModalParaBaixo();
        } catch (Exception e) {
            telaHome.clicarBotaoModalQueroConhecer();
        }
        Assert.assertEquals("Tenha uma boa viagem.", telaHome.getMsgBoaViagem().getText());
    }

    @Entao("acesso a tela home do aplicativo")
    public void acessoATelaHomeDoAplicativo() throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;

        Home telaHome = new Home(driver);

        telaHome.clicarBotaoModalQueroConhecer();

        Assert.assertEquals("Tenha uma boa viagem.", telaHome.getMsgBoaViagem().getText());
    }

    @Entao("visualizo o modal de codigo invalido")
    public void visualizarModalErroCodigoSms() throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;

        EsqueciMinhaSenha esqueciMinhaSenha = new EsqueciMinhaSenha(driver);


        esqueciMinhaSenha.buscarModalErroSms();
    }

    @After
    public void after(Scenario scenario) throws IOException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;

        // Pega o caminho do arquivo da feature
        String nomeFeature = scenario.getUri().getPath();
//        System.out.println(nomeFeature);

        if (scenario.isFailed()) {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            byte[] fileContent = FileUtils.readFileToByteArray(screenshot);
            scenario.attach(fileContent, "image/png", "image1");
            System.out.println("\n alguns cenários precisam que o driver seja inicializado com 'appium --allow-insecure=adb_shell'\n");
        }

        if (nomeFeature.toLowerCase().contains("login")) {
//            System.out.println("É cenário da feature de login");
            try {
                Celular.limparCache(driver);
                Celular.resetApp(driver);
            } catch (Exception e) {
                System.out.println("Tentando resetar o app novamente, feature de login");
                Celular.limparCache(driver);
                Celular.resetApp(driver);
            }
        } else {
            String nomeCenario = scenario.getName();
            if(nomeCenario.toLowerCase().contains("reseto o app")){
                Celular.limparCache(driver);
            }
            try {
                Celular.resetApp(driver);
            } catch (Exception e) {
                System.out.println("Tentando resetar o app novamente");
                Celular.resetApp(driver);
            }
        }
    }

    @Quando("submeto minhas credenciais bloqueadas para login")
    public void submetoMinhasCredenciaisBloqueadasParaLogin() throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Login telaLogin = new Login(driver);


        telaLogin.buscarElementos();
        telaLogin.limparCamposLogin();
        telaLogin.preencherFormulario("73040542559", "Teste123");
        telaLogin.logar();
    }


    @Entao("visualizo o modal de usuário bloqueado")
    public void visualizoOModalDeUsuárioBloqueado() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Login telaLogin = new Login(driver);
        telaLogin.buscarModalContaBloqueada();
    }

    @Entao("sou direcionado para o WhatsApp da Central de atendimento Autopass")
    public void verificarRedirecionamentoWhatsapp() throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Login telaLogin = new Login(driver);

        telaLogin.verificarRedirecionamentoWhatsapp();
    }

    @Entao("visualizo o modal de \"CPF já cadastrado\".")
    public void modalCpfJaCadastrado() throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Cadastro cadastro = new Cadastro(driver);
        cadastro.buscarModalCpfJaCadastrado();
    }

    @E("clico no botão 'Atendimento via Whatsapp' no modal")
    public void clicarBotaoAtendimentoWhatsApp() throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Login telaLogin = new Login(driver);

        telaLogin.clicarBotaoAtendimentoWhatsApp();
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

    @Quando("clico na opção \"Central de Ajuda\"")
    public void clicoCentralDeAjuda() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Login login = new Login(driver);
        login.clicarCentralDeAjuda();
    }

    @E("clico no botão Enviar mensagem")
    public void enviarMensagem() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Login login = new Login(driver);

        login.clicarEnviarMensagem();
    }

    @E("clico em \"Continuar\" com os demais campos preenchidos corretamente, menos o e-mail")
    public void continuarComEmailSemArroba() throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Cadastro cadastro = new Cadastro(driver);
        cadastro.buscarElementos();
        cadastro.preencherNome();
        cadastro.preencherDataNascimentoPadrao();
        cadastro.escolherGenero();
        Thread.sleep(2000);
        cadastro.preencherTelefonePadrao();
        cadastro.clicarBotaoContinuar();
    }

    @E("clico em \"Continuar\" com os demais campos preenchidos corretamente, menos o celular")
    public void continuarComCelularSemDDD() throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Cadastro cadastro = new Cadastro(driver);
        cadastro.buscarElementos();
        cadastro.preencherNome();
        cadastro.preencherDataNascimentoPadrao();
        cadastro.escolherGenero();
        Thread.sleep(2000);
        cadastro.preencherEmailPadrao();
        cadastro.clicarBotaoContinuar();
    }

    @E("clico em \"Continuar\" com os demais campos preenchidos dentro dos critérios de aceite, menos a data de nascimento")
    public void continuarComIdadeMenorQue13() throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Cadastro cadastro = new Cadastro(driver);
        cadastro.buscarElementos();
        cadastro.preencherNome();
        cadastro.escolherGenero();
        Thread.sleep(2000);
        cadastro.preencherEmailPadrao();
        cadastro.preencherTelefonePadrao();
        cadastro.clicarBotaoContinuar();
    }

    @E("informo e-mail fora do padrão sem \"@\"")
    public void emailSemArroba() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Cadastro cadastro = new Cadastro(driver);
        cadastro.buscarElementos();
        cadastro.preencherEmail("emailSemArroba.com");
    }

    @E("informo a data de nascimento menor que 13 anos")
    public void menorDe13Anos() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Cadastro cadastro = new Cadastro(driver);

        LocalDate currentDate = LocalDate.now();
        Integer anoAtual = currentDate.getYear();
        Integer anoDeNascimento = anoAtual - 12;
        String dataNascimento = "01/01/" + anoDeNascimento;

        cadastro.buscarElementos();
        cadastro.preencherDataNascimento(dataNascimento);
    }

    @E("informo DDD + celular com menos de 11 dígitos")
    public void celularDDDMenos11Digitos() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Cadastro cadastro = new Cadastro(driver);
        cadastro.buscarElementos();
        cadastro.preencherTelefone("1193392346");
    }

    @E("informo DDD + celular inválido sem começar com 9")
    public void celularInvalido() throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Cadastro cadastro = new Cadastro(driver);
        cadastro.buscarElementos();
        cadastro.limparTelefone();
        cadastro.preencherTelefone("11333923464");
    }

    @Entao("visualizo a mensagem de \"E-mail inválido\" no campo \"E-mail\".")
    public void emailInválido() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Cadastro cadastro = new Cadastro(driver);
        cadastro.mensagemEmailInvalido();
    }

    @Entao("visualizo a mensagem de \"Não é possível cadastrar menores de idade\" no campo \"Data de nascimento\"")
    public void dtNascMenorDe13() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Cadastro cadastro = new Cadastro(driver);
        cadastro.dtNascInvalida();
    }

    @Entao("visualizo a mensagem de \"Telefone inválido\" no campo \"Celular\".")
    public void telefoneInvalido() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Cadastro cadastro = new Cadastro(driver);
        cadastro.mensagemTelefoneInvalido();
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

    @E("informo um CPF inválido para cadastro")
    public void informoUmCPFInválidoCadastro() throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Cadastro cadastro = new Cadastro(driver);
        cadastro.buscarElementos();
        cadastro.preencherCpf("12312312377");
    }


    @Entao("visualizo a mensagem de Documento inválido")
    public void visualizoAMensagemDeDocumentoInválido() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        EsqueciMinhaSenha telaEsqueciminhaSenha = new EsqueciMinhaSenha(driver);
        telaEsqueciminhaSenha.buscarMensagemCPFInvalido();
        assertTrue(telaEsqueciminhaSenha.getMsgCPFInvalido().isDisplayed());

    }

    @Quando("reseto o app")
    public void resetoOApp() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Celular.resetApp(driver);
    }

    @Dado("que reseto o app")
    public void queResetoOApp() {
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
//        telaHome.clicarBotaoAtivarBiometria();
//        try {
//            telaHome.arrastarModalParaBaixo();
//        } catch (Exception e) {
//            telaHome.clicarBotaoModalQueroConhecer();
//        }
    }

    @E("redefino a senha")
    public void redefinirSenha() throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;

        Home telaHme = new Home(driver);
        telaHme.redefinirSenhaPeloPerfil();
    }

    @E("informo um CPF já cadastrado")
    public void cpfCadastrado() throws Exception {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Cadastro cadastro = new Cadastro(driver);
        cadastro.buscarElementos();
        cadastro.preencherCpf("06193372067");

    }

    @Quando("que eu acesso o menu Bilhetes Qr Code na home do aplicativo tendo cartão de crédito cadastrado")
    public void queEuAcessoOMenuNaHomeDoAplicativoTendoCartãoDeCréditoCadastrado() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Home telaHome = new Home(driver);

        //Celular.resetApp(driver);

        telaHome.buscarBotaoBilhetes();
        telaHome.clicarBotaoBilhetes();
    }

    @Quando("acesso a opção \"Criar uma conta\"")
    public void criarUmaConta() throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Login telaHome = new Login(driver);

        telaHome.buscarElementos();
        telaHome.clicarCriarConta();
    }

    @E("clico na opçao Comprar Bilhetes")
    public void clicoNaOpçaoComprarBilhetes() throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        MeusBilhetes paginaMeusBilhetes = new MeusBilhetes(driver);

        Thread.sleep(10000);
//        paginaMeusBilhetes.buscarElementosTentativasMaximas();
        paginaMeusBilhetes.buscarElementos();
        //paginaMeusBilhetes.clicarFormasDePgto();
        paginaMeusBilhetes.clicarBotaoComprarBilhetes();
    }

    @E("clico na opçao Comprar Bilhetes estando offline")
    public void clicoNaOpçaoComprarBilhetesEstandoOffline() throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        MeusBilhetes paginaMeusBilhetes = new MeusBilhetes(driver);

        Thread.sleep(10000);
//        paginaMeusBilhetes.buscarElementosTentativasMaximas();
        paginaMeusBilhetes.buscarElementos();
        //paginaMeusBilhetes.clicarFormasDePgto();
        paginaMeusBilhetes.clicarBotaoComprarBilhetes();
    }

    @E("informo um CPF válido ainda não cadastrado")
    public void cpfValidoNaoCadastrado() throws Exception {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Cadastro cadastro = new Cadastro(driver);
        cadastro.buscarElementos();
        cadastro.preencherCpf();

        try {
            cadastro.buscarModalCpfJaCadastrado();

            Login telaHome = new Login(driver);
            telaHome.buscarElementos();
            telaHome.clicarCriarConta();

            cpfValidoNaoCadastrado();
        } catch (Exception exception) {

        }
    }

    @E("clico em confirmar cadastrar senha")
    public void confirmarCadastrarSenha() throws Exception {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Cadastro cadastro = new Cadastro(driver);
        cadastro.clicarBotaoConfirmarCadastroSenha();
    }

    @Entao("visualizo a mensagem de \"CPF inválido\" no campo CPF.")
    public void visualizarMensagemCpfInválido() throws Exception {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Cadastro cadastro = new Cadastro(driver);
        cadastro.mensagemCpfInválido();
    }

    @E("aceito os termos de uso e privacidade")
    public void aceitarTermos() throws Exception {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Cadastro cadastro = new Cadastro(driver);
        cadastro.aceitarTermos();
    }

    @Entao("visualizo o modal de \"Cadastro realizado com sucesso\".")
    public void visualizarModalCadastro() throws Exception {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Cadastro cadastro = new Cadastro(driver);
        cadastro.visualizarModalCadastrado();

        Login login = new Login(driver);
        login.buscarElementos();
    }

    @E("submeto os demais dados corretamente até a finalização do formulário")
    public void finalizarCadastro() throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Cadastro cadastro = new Cadastro(driver);

        cadastro.buscarElementos();
        cadastro.preencherNome();
        cadastro.preencherDataNascimentoPadrao();
        cadastro.escolherGenero();
        Thread.sleep(2000);
        cadastro.preencherEmailPadrao();
        cadastro.preencherTelefonePadrao();
        cadastro.clicarBotaoContinuar();
    }

    @E("clico na opção CPTM, Metrô")
    public void clicoNaOpção() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        MeusBilhetes telaMeusBilhetes = new MeusBilhetes(driver);

        telaMeusBilhetes.buscarBotaoCPTM();
        telaMeusBilhetes.clicarBotaoCPTM();

    }

    @E("clico na opção Metro e Trem")
    public void clicoNaOpçãoMetroETrem() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Tela tela = new Tela(driver);

        tela.clicarEmElemento("//android.widget.TextView[@text=\"Metrô e Trem\"]", 10);
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

    }

    @E("confirmo o pagamento informando o CVV {string}")
    public void confirmoOPagamentoInformandoOCVV(String arg0) throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Tela tela = new Tela(driver);

        tela.inputNoElemento("//android.widget.EditText[@content-desc=\"informar cvv\"]", arg0);
        Thread.sleep(1000);
        Map<String, Object> keyEvent = new HashMap<>();
        keyEvent.put("action", "done");
        driver.executeScript("mobile: performEditorAction", keyEvent);
//        driver.navigate().back();
        Thread.sleep(1000);
//        MobileElement confirmar = tela.buscarElementoNaTela("//android.widget.TextView[@content-desc=\"CONFIRMAR\"]", 10);
//        assertTrue(confirmar.isEnabled());
//        System.out.println(confirmar.getCenter());
//
//        tela.clicarEmElemento("//android.widget.TextView[@content-desc=\"CONFIRMAR\"]", 10);
    }

    @Então("visualizo a tela de Erro no pagamento")
    public void visualizoATelaDeErroNoPagamento() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Tela tela = new Tela(driver);

        MobileElement erro = tela.buscarElementoNaTela("//android.widget.TextView[@text=\"Falha no pagamento!\"]", 60);
        assertTrue(erro.isDisplayed());
        }

    @Quando("informo o seguinte CPF {string} que possui o email 'testecav8@gmail.com' e o telefone '+5511922334456'")
    public void informoOSeguinteCPF(String arg0) throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        EsqueciMinhaSenha telaEsqueciminhaSenha = new EsqueciMinhaSenha(driver);
        telaEsqueciminhaSenha.buscarElementos();
        telaEsqueciminhaSenha.preencherInputCpf(arg0);
        telaEsqueciminhaSenha.clicarBotaoConfirmar();
    }

    @E("insiro o token sms")
    public void insiroOTokenSms() throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        EsqueciMinhaSenha telaEsqueciminhaSenha = new EsqueciMinhaSenha(driver);
        Tela tela = new Tela(driver);

        try{
            MobileElement botaoNegar = tela.buscarElementoNaTela("//android.widget.Button[@resource-id=\"com.google.android.gms:id/negative_button\"]", 10);
            tela.clicarEmElemento(botaoNegar);
        } catch (Exception e){
            System.out.println("Modal não encontrado, seguindo fluxo");
        }

        Thread.sleep(2000);
        telaEsqueciminhaSenha.buscarInput0Sms();
        telaEsqueciminhaSenha.clicarInput0();
        String token = OTPUtils.getOTPtokenByPhoneNumberOrEmail("+5511994787098");
        telaEsqueciminhaSenha.inserirInputs(token);
        Thread.sleep(2000);
    }

    @E("insiro o token sms invalido")
    public void insiroOTokenSmsInvalido() throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        EsqueciMinhaSenha telaEsqueciminhaSenha = new EsqueciMinhaSenha(driver);
        Tela tela = new Tela(driver);

        try{
            MobileElement botaoNegar = tela.buscarElementoNaTela("//android.widget.Button[@resource-id=\"com.google.android.gms:id/negative_button\"]", 10);
            tela.clicarEmElemento(botaoNegar);
        } catch (Exception e){
            System.out.println("Modal não encontrado, seguindo fluxo");
        }

        telaEsqueciminhaSenha.buscarInput0Sms();
        telaEsqueciminhaSenha.clicarInput0();
        telaEsqueciminhaSenha.inserirInputs("111111");
        Thread.sleep(2000)
        ;
    }

    @E("insiro o token email")
    public void insiroOTokenEmail() throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        EsqueciMinhaSenha telaEsqueciminhaSenha = new EsqueciMinhaSenha(driver);

        Thread.sleep(5000);
        telaEsqueciminhaSenha.buscarInput0Email();
        telaEsqueciminhaSenha.clicarInput0();
        String token = OTPUtils.getOTPtokenByPhoneNumberOrEmail("matheusmunari0@gmail.com");
        telaEsqueciminhaSenha.inserirInputs(token);
    }

    @E("insiro o token email invalido")
    public void insiroOTokenEmailInvalido() throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        EsqueciMinhaSenha telaEsqueciminhaSenha = new EsqueciMinhaSenha(driver);

        telaEsqueciminhaSenha.buscarInput0Email();
        telaEsqueciminhaSenha.clicarInput0();
        Thread.sleep(3000);
        telaEsqueciminhaSenha.inserirInputs("111111");
    }

    @E("clico em confirmar")
    public void confirmar() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        EsqueciMinhaSenha telaEsqueciMinhaSenha = new EsqueciMinhaSenha(driver);

        telaEsqueciMinhaSenha.clicarBotaoConfirmar();
    }

    @E("clico em confirmar sms")
    public void confirmarSms() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        EsqueciMinhaSenha telaEsqueciminhaSenha = new EsqueciMinhaSenha(driver);

        telaEsqueciminhaSenha.clicarBotaoConfirmarSms();
    }

    @E("insiro a senha {string}")
    public void inserirNovaSenha(String novaSenha) {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        EsqueciMinhaSenha telaEsqueciminhaSenha = new EsqueciMinhaSenha(driver);

        telaEsqueciminhaSenha.preencherInputSuaSenha(novaSenha);
    }

    @E("confirmo a nova senha {string}")
    public void confirmarNovaSenha(String confirmarSenha) {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        EsqueciMinhaSenha telaEsqueciminhaSenha = new EsqueciMinhaSenha(driver);

        telaEsqueciminhaSenha.preencherInputConfirmarSenha(confirmarSenha);
    }

    @E("clico em confirmar redefinir senha")
    public void confirmarRedefinirSenha() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        EsqueciMinhaSenha telaEsqueciminhaSenha = new EsqueciMinhaSenha(driver);

        telaEsqueciminhaSenha.clicarBotaoConfirmarRedefinirSenha();
    }

    @E("clico no botão \"Continuar\" com os demais campos em branco")
    public void continuarComCamposEmBranco() throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Cadastro cadastro = new Cadastro(driver);
        cadastro.buscarElementos();
        cadastro.clicarBotaoContinuar();
    }

    @Entao("visualizo as mensagens de campos obrigatórios nos campos em branco.")
    public void vizualizarMensagemErroBranco() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Cadastro cadastro = new Cadastro(driver);

        cadastro.buscarElementos();
        cadastro.buscarMensagensErroObrigatoria();
    }

    @E("clico em confirmar email")
    public void confirmarEmail() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        EsqueciMinhaSenha telaEsqueciminhaSenha = new EsqueciMinhaSenha(driver);

        telaEsqueciminhaSenha.clicarBotaoConfirmarEmail();
    }

    @E("confirmo Cartão de débito como forma de pagamento")
    public void confirmoCartãoDeDébitoComoFormaDePagamento() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Tela tela = new Tela(driver);

        tela.clicarEmElemento("//android.widget.TextView[@text=\"PAGAMENTO\"]", 10);
        tela.clicarEmElemento("(//android.widget.TextView[@text=\"Débito\"])[1]", 60);
        tela.scrollAteElemento("//android.widget.TextView[@text=\"PAGAMENTO\"]", 10, "//android.widget.TextView[@text=\"CONFIRMAR PAGAMENTO\"]");
        tela.clicarEmElemento("//android.widget.TextView[@text=\"CONFIRMAR PAGAMENTO\"]", 10);
    }


    @E("submeto as informações corretas do cartão")
    public void submetoAsInformaçõesCorretasDoCartão(DataTable dataTable) {
        List<Map<String, String>> dados = dataTable.asMaps(String.class, String.class);
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        InserirDadosCartao paginaCartoes = new InserirDadosCartao(driver);
        for (Map<String, String> linha : dados) {
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
        for (Map<String, String> linha : dados) {
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
    public void clicoNaOpçãoFormasDePagamento() throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        MeusBilhetes paginaMeusBilhetes = new MeusBilhetes(driver);
        Tela tela = new Tela(driver);
        int tentativas = 0;

        while (tentativas < 10){
            try{
                tela.clicarEmElemento("//android.widget.TextView[@text=\"Formas de \n" +
                        "Pagamento\"]", 10);
                tela.buscarElementoNaTela("//android.widget.TextView[@text=\"ADICIONAR CARTÃO\"]", 10);
                break;
            }catch (Exception e){
                tentativas++;
                System.out.println("Elemento não encontrado, tentando novamente");
            }
        }


        Thread.sleep(10000);
    }

    @E("clico em Adicionar forma de pagamento")
    public void clicoEmAdicionarFormaDePagamento() throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        MeusBilhetes paginaMeusBilhetes = new MeusBilhetes(driver);
        Tela tela = new Tela(driver);

        Thread.sleep(3000);
        tela.clicarEmElemento("//android.widget.TextView[@text=\"ADICIONAR CARTÃO\"]", 10);

    }

    @E("clico na opção Cartão de crédito")
    public void clicoNaOpçãoCartãoDeCrédito() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        MeusBilhetes paginaMeusBilhetes = new MeusBilhetes(driver);

        paginaMeusBilhetes.buscarFormasDePagamento();
        paginaMeusBilhetes.clicarBotaoCartaoDeCreditoFormaPgto();
    }


    @Entao("visualizo a tela de Cartão cadastrado com sucesso")
    public void visualizoATelaDeCartãoCadastroComSucesso() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        MeusBilhetes paginaMeusBilhetes = new MeusBilhetes(driver);
        Tela tela = new Tela(driver);

        MobileElement mensagem = tela.buscarElementoNaTela("//android.widget.TextView[@text=\"Cadastro realizado com sucesso!\"]", 20);
        assertTrue(mensagem.isDisplayed());
    }

    @Entao("verifico os criterios de aceite dos campos \"Sua senha\" e \"Confirmar senha\" validando as mensagens exibidas")
    public void criterioDeAceiteNovaSenha() throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        EsqueciMinhaSenha esqueciMinhaSenha = new EsqueciMinhaSenha(driver);

        esqueciMinhaSenha.novaSenhaTesteCriterioDeAceite();
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
        espera.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text=\"ADICIONAR CARTÃO\"]")));

    }

    @E("volto para o menu")
    public void voltoParaOMenu() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Tela tela = new Tela(driver);

        tela.buscarElementoNaTela("//android.widget.TextView[@content-desc=\"VOLTAR PARA A HOME\"]",10);
        tela.clicarEmElemento("//android.widget.TextView[@content-desc=\"VOLTAR PARA A HOME\"]", 10);

    }

    @E("clico na opção Cartão de débito")
    public void clicoNaOpçãoCartãoDeDébito() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        MeusBilhetes paginaMeusBilhetes = new MeusBilhetes(driver);
        Tela tela = new Tela(driver);

        tela.clicarEmElemento("//android.widget.TextView[@text=\"Débito\"]", 10);

    }

    @Entao("visualizo a tela de falha no cadastro")
    public void visualizoATelaDeFalhaNoCadastro() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        MeusBilhetes telaMeusBilhetes = new MeusBilhetes(driver);
        Tela tela = new Tela(driver);

        MobileElement mensagem = tela.buscarElementoNaTela("//android.widget.TextView[@text=\"Falha no cadastro\"]", 20);
        assertTrue(mensagem.isDisplayed());

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
        Tela tela = new Tela(driver);

        MobileElement mensagem = tela.buscarElementoNaTela("//android.widget.TextView[@text=\"ADICIONAR CARTÃO\"]", 10);

        assertTrue(mensagem.isDisplayed());
    }

    @E("clico no ultimo registro de compra no historico")
    public void clicoNoUltimoRegistroDeCompraNoHistorico() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        MeusBilhetes telaMeusBilhetes = new MeusBilhetes(driver);
        Tela tela = new Tela(driver);

        tela.clicarEmElemento("(//android.view.ViewGroup[@content-desc=\"Compra de Bilhetes  1 Un. CPTM / Metrô no valor de 5.2 reais\"])[1]", 10);
    }

    @Entao("visualizo o modal com os detalhes da compra")
    public void visualizoOModalComOsDetalhesDaCompra() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        MeusBilhetes telaMeusBilhetes = new MeusBilhetes(driver);

        telaMeusBilhetes.buscarModalDetalhesCompra();
        Assert.assertTrue(telaMeusBilhetes.getModalDetalhesCompra().isDisplayed());
    }

    @E("eu habilito o mock do token no perfil do usuario")
    public void euHabilitoOMockDoTokenNoPerfilDoUsuario() throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Home telaHome = new Home(driver);

        telaHome.buscarFotoDePerfil();
        telaHome.clicarFotoDePerfil();
        telaHome.scrolAteOpcaoMock();
        telaHome.clicarBotaoMockTokenGemalto();
        Thread.sleep(1000);
        driver.navigate().back();
    }

    @E("eu clico no botao do mock gemalto token")
    public void euClicoNoBotaoMockGemaltoToken() throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Tela tela = new Tela(driver);
        Home telaHome = new Home(driver);

        telaHome.buscarFotoDePerfil();
        telaHome.clicarFotoDePerfil();
        while (true){
            try {
                tela.buscarElementoNaTela("//android.widget.TextView[@text=\"DADOS PESSOAIS\"]", 20);
                break;
            }catch (Exception e){
                tela.clicarEmElemento("//android.widget.TextView[@text=\"TENTAR NOVAMENTE\"]", 10);
            }
        }
        tela.scrollAteElemento("//android.widget.TextView[@text=\"DADOS PESSOAIS\"]", 20, "new UiSelector().text(\"Mock gemalto token\")");
        MobileElement botaoMockGemalto = tela.buscarElementoNaTela("//android.view.ViewGroup[@content-desc=\"Mock gemalto token\"]/android.view.ViewGroup", 20);
        tela.clicarEmElemento(botaoMockGemalto);

//        telaHome.clicarBotaoMockTokenGemalto();
        Thread.sleep(1000);
        driver.navigate().back();
    }

    @E("confirmo saldo disponível como forma de pagamento")
    public void confirmoSaldoDisponívelComoFormaDePagamento() throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        MeusBilhetes telaMeusBilhetes = new MeusBilhetes(driver);

        Tela tela = new Tela(driver);

        tela.clicarEmElemento("//android.widget.TextView[@text=\"TROCAR\"]", 10);
        tela.clicarEmElemento("//android.widget.TextView[@text=\"Saldo disponível\"]", 60);
        tela.scrollAteElemento("//android.widget.TextView[@text=\"PAGAMENTO\"]", 10, "new UiSelector().text(\"CONFIRMAR PAGAMENTO\")");
        Thread.sleep(100);
        tela.clicarEmElemento("//android.widget.TextView[@text=\"CONFIRMAR PAGAMENTO\"]", 10);

    }

    @E("confirmo o pagamento informando a senha correta {string}")
    public void                                                                                                                                                                                                                                                                                                                         confirmoOPagamentoInformandoASenhaCorreta(String arg0) {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        MeusBilhetes telaMeusBilhetes = new MeusBilhetes(driver);

        telaMeusBilhetes.buscarInputSenhaSaldoEmConta();
        telaMeusBilhetes.clicarInput0SenhaSaldoEmConta();
        telaMeusBilhetes.inserirSenhaConta(arg0);
        telaMeusBilhetes.clicarBotaoConfirmarCompra();
    }

    @Dado("que eu reseto o driver")
    public void queEuResetoODriver() throws Exception {
        AppiumDriverConfig.Instance().driver = null;
    }

    @E("clico em 'Continuar' informando todos os dados pessoais corretamente")
    public void clicoEmInformandoTodosOsDadosPessoaisCorretamente() throws Exception {
        AppiumDriver appiumDriver = AppiumDriverConfig.Instance().driver;
        Cadastro cadastro = new Cadastro(appiumDriver);
        Tela tela = new Tela(appiumDriver);

        cadastro.buscarElementos();
        String cpf = Cadastro.fakeCpf();
        tela.inputNoElemento("//android.widget.EditText[@content-desc=\"Campo com cpf digitado\"]", cpf);
        Thread.sleep(3000);
        tela.inputNoElemento("//android.widget.EditText[@content-desc=\" Campo para digitação do nome completo\"]", "Teste Cadastro");
        tela.inputNoElemento("//android.widget.EditText[@content-desc=\"Campo para informar data de nascimento completa\"]", "24052005");
        tela.clicarEmElemento("//android.widget.EditText[@content-desc=\"Campo para informar o gênero\"]", 10);
        tela.clicarEmElemento("//android.widget.TextView[@text=\"Masculino\"]", 10);
        Thread.sleep(1000);
        tela.inputNoElemento("//android.widget.EditText[@content-desc=\"Campo para informar email\"]", "matheusmunari0@gmail.com");
        tela.inputNoElemento("//android.widget.EditText[@content-desc=\"Campo para informar telefone\"]", "11994787098");
        cadastro.clicarBotaoContinuar();
    }

    @Então("visualizo o modal de código inválido")
    public void visualizoOModalDeCódigoInválido() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Cadastro cadastro = new Cadastro(driver);
        cadastro.buscarModalErroSms();
    }

    @E("clico em \"REENVIAR CÓDIGO\" após término do contador SMS")
    public void clicoEmReenviarCódigoApósTérminoDoContadorSms() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Cadastro cadastro = new Cadastro(driver);
        String token = OTPUtils.getOTPtokenByPhoneNumberOrEmail("+5514996237865");
        System.out.println("primeiro código sms: " + token);
        cadastro.esperarReenviarCodigo("//android.widget.TextView[@content-desc=\"REENVIAR CÓDIGO\"]");
    }

    @E("clico em \"REENVIAR CÓDIGO\" após término do contador e-mail")
    public void clicoEmReenviarCódigoApósTérminoDoContadorEmail() throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Cadastro cadastro = new Cadastro(driver);
        Thread.sleep(2000);
        String token = OTPUtils.getOTPtokenByPhoneNumberOrEmail("testecav8@gmail.com");
        System.out.println("primeiro código e-mail: " + token);
        cadastro.esperarReenviarCodigo("//android.widget.TextView[@content-desc=\"REENVIAR CÓDIGO\"]");
    }

    @Então("recebo um novo código atualizado via SMS")
    public void receboUmNovoCódigoAtualizadoViaSMS() throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        String token = OTPUtils.getOTPtokenByPhoneNumberOrEmail("+5514996237865");


        if (token.isEmpty()) {
            throw new AssertionError("token vazio");
        } else {
            System.out.println("recebido novo token sms: " + token);

            WebDriverWait esperarSumir = new WebDriverWait(driver, 10);

            esperarSumir.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//android.widget.TextView[@content-desc=\"REENVIAR CÓDIGO\"]")));
            Thread.sleep(1500);
        }
    }

    @Então("recebo um novo código atualizado via e-mail")
    public void receboUmNovoCódigoAtualizadoViaEmail() throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        String token = OTPUtils.getOTPtokenByPhoneNumberOrEmail("testecav8@gmail.com");

        if (token.isEmpty()) {
            throw new AssertionError("token vazio");
        } else {
            System.out.println("recebido novo token e-mail: " + token);

            WebDriverWait esperarSumir = new WebDriverWait(driver, 10);

            esperarSumir.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//android.widget.TextView[@content-desc=\"REENVIAR CÓDIGO\"]")));
            Thread.sleep(1500);
        }

    }

    @E("clico em Editar meu número de celular")
    public void editarNumeroDeCelular() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Cadastro cadastro = new Cadastro(driver);
        cadastro.clicarEditarNumeroCelular();
    }

    @E("informo o número de telefone errado \"11911234567\"")
    public void informoONúmeroDeTelefoneErrado() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Cadastro cadastro = new Cadastro(driver);

        cadastro.buscarElementos();
        cadastro.preencherTelefone("11911234567");
    }

    @E("clico em \"CONFIRMAR NÚMERO\" após inserir um novo número de celular")
    public void clicoEmConfirmarNúmeroApósInserirUmNovoNúmeroDeCelular() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Cadastro cadastro = new Cadastro(driver);
        cadastro.alterarNumero();
        cadastro.confirmarAlterarNumero();

    }

    @Então("o modal é fechado exibindo a tela de confirmação com os 4 últimos dígitos do número atualizado")
    public void oModalÉFechadoExibindoATelaDeConfirmaçãoComOsÚltimosDígitosDoNúmeroAtualizado() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Cadastro cadastro = new Cadastro(driver);
        cadastro.buscarTextoComNumeroAlterado();
    }

    @E("clico em Editar meu endereço de e-mail")
    public void clicoEmEditarMeuEndereçoDeEMail() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Cadastro cadastro = new Cadastro(driver);
        cadastro.clicarEditarEmail();
    }

    @E("clico em \"CONFIRMAR E-MAIL\" após inserir um novo e-mail")
    public void clicoEmConfirmarEmailApósInserirUmNovoEMail() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Cadastro cadastro = new Cadastro(driver);
        cadastro.alterarEmail();
        cadastro.confirmarAlterarEmail();
    }

    @Então("o modal é fechado exibindo a tela de confirmação com o e-mail atualizado")
    public void oModalÉFechadoExibindoATelaDeConfirmaçãoComOEMailAtualizado() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Cadastro cadastro = new Cadastro(driver);
        cadastro.buscarTextoComEmailAlterado();
    }

    @E("informo o endereço de e-mail errado \"email.errado@gmail.com\"")
    public void informoOEndereçoDeEMailErrado() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Cadastro cadastro = new Cadastro(driver);
        cadastro.buscarElementos();
        cadastro.preencherEmail("email.errado@gmail.com");
    }


    @Entao("verifico os criterios de aceite do campo \"Sua senha\" validando o estado do botão \"Confirmar\" e visualizando os checks nos requisítos da senha")
    public void verificoOsCriteriosDeAceiteDoCampoSuaSenhaValidandoOEstadoDoBotãoConfirmarEVisualizandoOsChecksNosRequisítosDaSenha() throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Cadastro cadastro = new Cadastro(driver);
        cadastro.cadastrarSenhaTesteCriterioDeAceite();

    }

    @E("confirmo pix como forma de pagamento")
    public void confirmoPixComoFormaDePagamento() {

        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        MeusBilhetes telaMeusBilhetes = new MeusBilhetes(driver);

        Tela tela = new Tela(driver);

        tela.clicarEmElemento("//android.widget.TextView[@text=\"TROCAR\"]", 10);
        tela.clicarEmElemento("(//android.widget.TextView[@text=\"Pix\"])[2]", 10);
        tela.scrollAteElemento("//android.widget.TextView[@text=\"PAGAMENTO\"]", 10, "new UiSelector().text(\"CONFIRMAR PAGAMENTO\")");
        tela.clicarEmElemento("//android.widget.TextView[@text=\"CONFIRMAR PAGAMENTO\"]", 10);

    }
  
    @E("não possua foto de perfil")
    public void nãoPossuaFotoDePerfil() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Home home = new Home(driver);
        home.buscarFotoDePerfil();
    }

    @E("que autorizo as notificações")
    public void autorizoAsNotificações() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Tela tela = new Tela(driver);

        MobileElement botaoConfirmarNotificacoes = tela.buscarElementoNaTela("//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_allow_button\"]", 10);
        tela.clicarEmElemento(botaoConfirmarNotificacoes);
    }

    @E("seleciono {int} bilhete")
    public void selecionoBilhete(int arg0) {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Tela tela = new Tela(driver);

        if(arg0 > 1){
            for (int i = 1; i < arg0; i++){
                tela.clicarEmElemento("//android.widget.TextView[@text=\"+\"]", 10);
            }
        }

        tela.clicarEmElemento("//android.widget.TextView[@text=\"CONFIRMAR\"]", 10);

    }

    @E("avanço para as formas de pagamento")
    public void avançoParaAsFormasDePagamento() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Tela tela = new Tela(driver);

        tela.scrollAteElemento("//android.widget.TextView[@text=\"*Conheça os benefícios, programa e regulamento\"]", 10, "new UiSelector().text(\"CONTINUAR COMPRA COM PONTOS\")");

        tela.clicarEmElemento("//android.widget.TextView[@text=\"TALVEZ MAIS TARDE\"]", 10);
    }

    @E("confirmo Cartão de débito de final {string} como forma de pagamento")
    public void confirmoCartãoDeDébitoDeFinalComoFormaDePagamento(String arg0) throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Tela tela = new Tela(driver);

        tela.scrollAteElemento("//android.widget.TextView[@text=\"DETALHES DA COMPRA\"]", 10, "new UiSelector().text(\"TROCAR\")");
        tela.clicarEmElemento("//android.widget.TextView[@text=\"TROCAR\"]", 10);
        tela.clicarEmElemento("//android.widget.TextView[@text=\"•••• " + arg0 + "\"]", 60);
        tela.scrollAteElemento("//android.widget.TextView[@text=\"PAGAMENTO\"]", 10, "new UiSelector().text(\"CONFIRMAR PAGAMENTO\")");
        Thread.sleep(100);
        tela.clicarEmElemento("//android.widget.TextView[@text=\"CONFIRMAR PAGAMENTO\"]", 10);
    }

    @E("volto para a home")
    public void voltoParaAHome() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Tela tela = new Tela(driver);

        tela.clicarEmElemento("//android.widget.TextView[@text=\"\uE96F\"]", 10);
    }

    @E("clico em Conta Digital na home")
    public void clicoEmContaDigitalNaHome() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Tela tela = new Tela(driver);

        tela.clicarEmElemento("//android.widget.TextView[@text=\"Conta\n" +
                "Digital\"]", 60);
        tela.buscarElementoNaTela("//android.widget.TextView[@content-desc=\"Saldo\"]", 60);

    }

    @E("confirmo Cartão de credito de final {string} como forma de pagamento")
    public void confirmoCartãoDeCreditoDeFinalComoFormaDePagamento(String arg0) throws InterruptedException {

        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Tela tela = new Tela(driver);

        tela.clicarEmElemento("//android.widget.TextView[@text=\"TROCAR\"]", 10);
        tela.clicarEmElemento("//android.widget.TextView[@text=\"•••• " + arg0 + "\"]", 60);
        tela.scrollAteElemento("//android.widget.TextView[@text=\"PAGAMENTO\"]", 10, "new UiSelector().text(\"CONFIRMAR PAGAMENTO\")");
        Thread.sleep(100);
        tela.clicarEmElemento("//android.widget.TextView[@text=\"CONFIRMAR PAGAMENTO\"]", 10);

    }

    @E("confirmo Cartão de credito válido")
    public void confirmoCartãoDeCreditoVálido() throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Tela tela = new Tela(driver);

        tela.clicarEmElemento("//android.widget.TextView[@text=\"TROCAR\"]", 10);
        tela.clicarEmElemento("(//android.widget.TextView[@text=\"Crédito\"])[1]", 60);
        tela.scrollAteElemento("//android.widget.TextView[@text=\"PAGAMENTO\"]", 10, "new UiSelector().text(\"CONFIRMAR PAGAMENTO\")");
        Thread.sleep(100);
        tela.clicarEmElemento("//android.widget.TextView[@text=\"CONFIRMAR PAGAMENTO\"]", 10);



    }

    @E("confirmo Cartão de credito inválido")
    public void confirmoCartãoDeCreditoInválido() throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Tela tela = new Tela(driver);

        tela.clicarEmElemento("//android.widget.TextView[@text=\"TROCAR\"]", 10);
        tela.clicarEmElemento("(//android.widget.TextView[@text=\"Crédito\"])[2]", 60);
        tela.scrollAteElemento("//android.widget.TextView[@text=\"PAGAMENTO\"]", 10, "new UiSelector().text(\"CONFIRMAR PAGAMENTO\")");
        Thread.sleep(100);
        tela.clicarEmElemento("//android.widget.TextView[@text=\"CONFIRMAR PAGAMENTO\"]", 10);

    }

    @E("continuo a compra com pontos")
    public void continuoACompraComPontos() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Tela tela = new Tela(driver);

        tela.clicarEmElemento("//android.widget.TextView[@text=\"CONTINUAR COMPRA COM PONTOS\"]", 10);

    }

    @E("clico em {int} pontos")
    public void clicoEmPontos(int arg0) {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Tela tela = new Tela(driver);

        tela.clicarEmElemento("//android.widget.TextView[@text=\"" + arg0 + " PONTOS\"]", 10);
    }

    @E("clico em outro valor")
    public void clicoEmOutroValor() {

        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Tela tela = new Tela(driver);

        tela.clicarEmElemento("//android.widget.TextView[@text=\"OUTRO VALOR\"]", 10);
    }

    @E("insiro o valor de R$ {string} em pontos")
    public void insiroOValorDeR$EmPontos(String arg0) {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Tela tela = new Tela(driver);

        tela.buscarElementoNaTela("//android.widget.EditText[@content-desc=\"Informe o valor desejado\"]", 20);
        tela.inputNoElemento("//android.widget.EditText[@content-desc=\"Informe o valor desejado\"]", arg0);
        tela.clicarEmElemento("//android.widget.TextView[@text=\"CONFIRMAR\"]", 10);
    }

    @E("continuo a recarga com pontos")
    public void continuoARecargaComPontos() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Tela tela = new Tela(driver);

        tela.clicarEmElemento("//android.widget.TextView[@text=\"CONTINUAR RECARGA COM PONTOS\"]", 10);

    }

    @E("clico na opção Formas de Pagamento estando offline")
    public void clicoNaOpçãoFormasDePagamentoEstandoOffline() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;

        Tela tela = new Tela(driver);
        int tentativas = 0;

        while (tentativas < 10){
            try{
                tela.clicarEmElemento("//android.widget.TextView[@text=\"Formas de \n" +
                        "Pagamento\"]", 10);
                tela.buscarElementoNaTela("//android.widget.TextView[@content-desc=\"acessar meus bilhetes offline\"]", 10);
                break;
            }catch (Exception e){
                tentativas++;
                System.out.println("Elemento não encontrado, tentando novamente");
            }
        }

    }
}


