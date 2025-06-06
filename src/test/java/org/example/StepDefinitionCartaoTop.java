package org.example;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.example.PageObjects.*;
import org.junit.Assert;
import org.openqa.selenium.Point;
import org.openqa.selenium.StaleElementReferenceException;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class StepDefinitionCartaoTop {
    @Quando("eu clico em Cartão TOP")
    public void euClicoEmCartãoTOP() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Home telaHome = new Home(driver);

        telaHome.buscarBotaoCartaoTop();
        telaHome.clicarBotaoCartaoTop();
    }

    @E("clico em Comprar Créditos")
    public void clicoEmComprarCréditos() throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        CartaoTop tela1CartaoTop = new CartaoTop(driver);
        Tela tela = new Tela(driver);

        MobileElement botaoComprarCreditos = tela.buscarElementoNaTela("//*[@text=\"Comprar \n" + "Créditos\"]", 20);
        tela.clicarEmElemento("//*[@text=\"Comprar \n" + "Créditos\"]", "//android.widget.TextView[@text=\"Comum\"]");

    }

    @E("clico na opção Comum")
    public void clicoNaOpçãoComum() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        CartaoTop tela2CartaoTop = new CartaoTop(driver);

        tela2CartaoTop.buscarBotaoComum();
        tela2CartaoTop.clicarBotaoComum();

    }


    @E("insiro o valor de R$ {string}")
    public void insiroOValorDeR$(String arg0) {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        CartaoTop tela2CartaoTop = new CartaoTop(driver);
        Tela tela = new Tela(driver);

        driver.navigate().back();
        tela2CartaoTop.inputarValorDeCredito(arg0);
        tela.clicarEmElemento("//android.widget.TextView[@text=\"CONFIRMAR\"]", 10);

    }

    @E("clico em Comprar")
    public void clicoEmComprar() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        CartaoTop tela2CartaoTop = new CartaoTop(driver);

        tela2CartaoTop.buscarBotaoComprarTela2();
        tela2CartaoTop.clicarBotaoComprarTela2();
    }

    @E("submeto a opção Cartão de crédito como forma de pagamento")
    public void submetoAOpçãoCartãoDeCréditoComoFormaDePagamento() {

        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        CartaoTop tela3CartaoTop = new CartaoTop(driver);

        tela3CartaoTop.buscarBotaoCartaoDeCredito();
        tela3CartaoTop.clicarBotaoCartaoDeCredito();
        tela3CartaoTop.buscarBotaoConfirmarTela3();
        tela3CartaoTop.clicarBotaoConfirmarTela3();
    }

    @E("finalizo com o cvv incorreto")
    public void finalizoComOCvvIncorreto() {


    }

    @E("submeto a opção Cartão de Débito como forma de pagamento")
    public void submetoAOpçãoCartãoDeDébitoComoFormaDePagamento() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        CartaoTop tela3CartaoTop = new CartaoTop(driver);
        Tela tela = new Tela(driver);

        tela.scrollAteElemento("//android.widget.TextView[@text=\"DETALHES DA COMPRA\"]", 10, "new UiSelector().text(\"TROCAR\")");
        tela.clicarEmElemento("//android.widget.TextView[@text=\"TROCAR\"]", 10);
        tela.clicarEmElemento("//android.widget.TextView[@text=\"•••• 6091\"]", 10);
        tela.scrollAteElemento("//android.widget.TextView[@text=\"PAGAMENTO\"]", 10, "new UiSelector().text(\"CONFIRMAR PAGAMENTO\")");
        tela.clicarEmElemento("//android.widget.TextView[@text=\"CONFIRMAR PAGAMENTO\"]", 10);
    }

    @E("clico na opção Escolar")
    public void clicoNaOpçãoEscolar() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        CartaoTop tela2CartaoTop = new CartaoTop(driver);

        tela2CartaoTop.buscarBotaoEscolar();
        tela2CartaoTop.clicarBotaoEscolar();
    }

    @E("submeto pix como forma de pagamento")
    public void submetoPixComoFormaDePagamento() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        CartaoTop tela3CartaoTop = new CartaoTop(driver);

        tela3CartaoTop.buscarOpcaoPix();
        tela3CartaoTop.clicarOpcaoPix();
        tela3CartaoTop.buscarBotaoConfirmarTela3();
        tela3CartaoTop.clicarBotaoConfirmarTela3();
    }

    @Então("visualizo a tela de codigo pix gerado para pagamento")
    public void visualizoATelaDeCodigoPixGeradoParaPagamento() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        CartaoTop tela4CartaoTop = new CartaoTop(driver);

        tela4CartaoTop.buscarTelaPix();
        assertTrue(tela4CartaoTop.getTextoCopiarCodigoPix().isDisplayed());
    }

    @E("expando o modal de saldo")
    public void expandoOModalDeSaldo() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Tela tela = new Tela(driver);

        tela.clicarEmElemento("//android.widget.TextView[@text=\"\uE8B4\"]", "//android.widget.TextView[@text=\"Saldo Detalhado:\"]");

    }

    @E("clico na opção Saiba mais no item escolar")
    public void clicoNaOpçãoSaibaMaisNoItemEscolar() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        CartaoTop tela1CartaoTop = new CartaoTop(driver);

        tela1CartaoTop.buscarSaibaMaisEscolar();
        tela1CartaoTop.clicarBotaoSaibaMais();
    }

    @Entao("visualizo a tela de beneficio escolar meia tarifa")
    public void visualizoATelaDeBeneficioEscolarMeiaTarifa() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        CartaoTop tela2CartaoTop = new CartaoTop(driver);

        tela2CartaoTop.buscarTelaInformativoMeiaTarifa();
        assertTrue(tela2CartaoTop.getTextoBeneficioEscolar().isDisplayed());
    }

    @Então("visualizo a tela de confirmação de pagamento via pix")
    public void visualizoATelaDeConfirmaçãoDePagamentoViaPix() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        MeusBilhetes telaMeusBilhetes = new MeusBilhetes(driver);

        telaMeusBilhetes.buscarFormaDePagamentoTelaConfirmacaoPix();
        assertTrue(telaMeusBilhetes.getTextoPixCopiaECola().isDisplayed());
    }

    @E("aguardo por mais de {int} minuto e meio na tela")
    public void aguardoPorMaisDeMinutoEMeioNaTela(int arg0) {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        CartaoTop tela4CartaoTop = new CartaoTop(driver);

        tela4CartaoTop.buscarTelaPixExpirado();
    }

    @Então("visualizo a tela de {string}")
    public void visualizoATelaDe(String arg0) {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        CartaoTop tela4CartaoTop = new CartaoTop(driver);

        tela4CartaoTop.buscarTelaPixExpirado();
        assertTrue(tela4CartaoTop.getMensagemPixExpirado().isDisplayed());
    }

    @E("clico no ícone informativo \\(i) no texto de {string} no modal de saldo")
    public void clicoNoÍconeInformativoINoTextoDeNoModalDeSaldo(String arg0) throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        CartaoTop tela1CartaoTop = new CartaoTop(driver);
        Thread.sleep(5000);
        tela1CartaoTop.buscarIconeInformativoAtualizacaoSaldo();
//        tela1CartaoTop.clicarIconeInformativoAtualizacaoSaldo();
    }

    @E("clico no botão {string}")
    public void clicoNoBotão(String arg0) {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        CartaoTop tela1CartaoTop = new CartaoTop(driver);
        Tela tela = new Tela(driver);

        tela.clicarEmElemento("//android.widget.TextView[@text=\"Comunicar \n" +
                "Perda/Roubo\"]", 20);

    }

    @E("clico em {string}")
    public void clicoEm(String arg0) throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        CartaoTop tela1CartaoTop = new CartaoTop(driver);

        tela1CartaoTop.buscarBotaoProsseguirComCancelamento();
        Thread.sleep(2000);
        tela1CartaoTop.clicarBotaoProsseguirComCancelamento();
    }

    @Então("sou direcionado para o chatbot da Pefisa via WhatsApp")
    public void souDirecionadoParaOChatbotDaPefisaViaWhatsApp() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        CartaoTop tela3CartaoTop = new CartaoTop(driver);

        tela3CartaoTop.buscarNomeContatoChatbotPefisa();
        assertTrue(tela3CartaoTop.getNomeChatbotPefisa().isDisplayed());
    }

    @E("clico no botao de expandir o modal de benefícios")
    public void clicoNoBotaoDeExpandirOModalDeBenefícios() throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        CartaoTop tela1CartaoTop = new CartaoTop(driver);
        Thread.sleep(5000);
        tela1CartaoTop.buscarIconeExpansaoModalBeneficios();
        tela1CartaoTop.clicarIconeExpansaoModalBeneficios();
    }

    @E("clico em Saiba Mais")
    public void clicoEmSaibaMais() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        CartaoTop tela1CartaoTop = new CartaoTop(driver);

        tela1CartaoTop.buscarLinkSaibaMaisMeiaTarifa();
        tela1CartaoTop.clicarLinkSaibaMaisMeiaTarifa();
    }

    @Então("sou direcionado para a pagina da EMTU de beneficio escolar")
    public void souDirecionadoParaAPaginaDaEMTUDeBeneficioEscolar() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        CartaoTop tela3CartaoTop = new CartaoTop(driver);

        tela3CartaoTop.buscarTextoBeneficioEscolarPasseLivre();
        assertTrue(tela3CartaoTop.getTextoBeneficioEscolarPasseLivre().isDisplayed());

    }

    @E("clico no icone de filtro")
    public void clicoNoIconeDeFiltro() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        CartaoTop tela1CartaoTop = new CartaoTop(driver);
        Tela tela = new Tela(driver);

        tela.clicarEmElemento("//android.widget.TextView[@text=\"\uE9AE\"]", 10);

    }

    @E("filtro por periodo e uso")
    public void filtroPorPeriodoEUso() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        CartaoTop tela2CartaoTop = new CartaoTop(driver);
        Tela tela = new Tela(driver);

//        tela.clicarEmElemento("//android.widget.TextView[@text=\"\uE9AE\"]", 10);
        tela.clicarEmElemento("//android.widget.TextView[@text=\"7 dias\"]", 10);
        tela.clicarEmElemento("//android.widget.TextView[@text=\"Compra/Recarga\"]", 10);
        tela.clicarEmElemento("//android.widget.TextView[@content-desc=\"APLICAR FILTROS\"]", 10);

    }

    @Então("visualizo o registro de uso do cartao")
    public void visualizoORegistroDeUsoDoCartao() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        CartaoTop tela1CartaoTop = new CartaoTop(driver);

        tela1CartaoTop.buscarRegistroDeUso();
        assertTrue(tela1CartaoTop.getRegistroDeUso().isDisplayed());
    }

    @E("expando o modal de beneficios")
    public void expandoOModalDeBeneficios() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Tela tela = new Tela(driver);

//        MobileElement elementoExpandirModalBeneficio = tela.buscarElementoNaTela("(//android.widget.TextView[@text=\"\uE8B4\"])[2]", 20);
        tela.clicarEmElemento("(//android.widget.TextView[@text=\"\uE8B4\"])[2]", "//android.widget.TextView[@text=\"Benefícios Detalhados:\"]");

    }

    @E("clico no icone Saiba Mais no item Passe Livre")
    public void clicoNoIconeSaibaMaisNoItemPasseLivre() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Tela tela = new Tela(driver);

        for(int i = 0; i < 10;){
            try{
                MobileElement elementoSaibaMais = tela.buscarElementoNaTela("//android.widget.TextView[@text=\"Saiba mais\"]", 20);
                tela.clicarEmElemento(elementoSaibaMais);
                tela.buscarElementoNaTela("//android.widget.TextView[@content-desc=\"Dúvidas sobre seu Benefício Escolar?\"]", 10);
                break;
            }catch (Exception e){
                i++;
                expandoOModalDeBeneficios();
            }
        }

    }

    @Então("visualizo a tela informativa do beneficio Passe Livre")
    public void visualizoATelaInformativaDoBeneficioPasseLivre() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Tela tela = new Tela(driver);

        MobileElement textoBeneficioPasseLivre = tela.buscarElementoNaTela("//android.widget.TextView[@content-desc=\"Benefício Escolar (,Passe Livre,)\"]", 20);
        assertTrue(textoBeneficioPasseLivre.isDisplayed());
    }


    @Então("visualizo a informação do benefício Passe Livre com a data de validade")
    public void visualizoAInformaçãoDoBenefícioPasseLivreComADataDeValidade() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Tela tela = new Tela(driver);

        MobileElement textoValidadeBeneficio = tela.buscarElementoNaTela("//android.widget.TextView[@text=\"VALID.\"]", 20);
        assertTrue(textoValidadeBeneficio.isDisplayed());
    }

    @E("clico na label de Dúvidas sobre seu benefício escolar?")
    public void clicoNaLabelDeDúvidasSobreSeuBenefícioEscolar() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Tela tela = new Tela(driver);

        MobileElement botaoDuvidasSobreBeneficioEscolar = tela.buscarElementoNaTela("//android.widget.TextView[@content-desc=\"Dúvidas sobre seu Benefício Escolar?\"]", 20);
        tela.clicarEmElemento(botaoDuvidasSobreBeneficioEscolar);
    }

    @Então("sou direcionado para a pagina de beneficio escolar EMTU")
    public void souDirecionadoParaAPaginaDeBeneficioEscolarEMTU() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Tela tela = new Tela(driver);

        MobileElement textoEmtu = tela.buscarElementoNaTela("//android.widget.Image[@text=\"Home EMTU\"]", 20);
        assertTrue(textoEmtu.isDisplayed());
    }

    @Então("visualizo a informação do benefício Sênior com a data de validade")
    public void visualizoAInformaçãoDoBenefícioSêniorComADataDeValidade() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Tela tela = new Tela(driver);

        MobileElement textoValidadeBeneficioSenior = tela.buscarElementoNaTela("//android.widget.TextView[@text=\"VALID.\"]", 20);
        assertTrue(textoValidadeBeneficioSenior.isDisplayed());
        MobileElement textoBeneficioSenior = tela.buscarElementoNaTela("(//android.widget.TextView[@text=\"Senior\"])[2]", 20);
        assertTrue(textoBeneficioSenior.isDisplayed());
    }

    @E("clico no icone Saiba Mais no item Senior")
    public void clicoNoIconeSaibaMaisNoItemSenior() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Tela tela = new Tela(driver);

        for(int i = 0; i < 10;){
            try{
                MobileElement elementoSaibaMaisSenior = tela.buscarElementoNaTela("//android.widget.TextView[@text=\"Saiba mais\"]", 20);
                tela.clicarEmElemento(elementoSaibaMaisSenior);
                break;
            }catch (Exception e){
                i++;
                expandoOModalDeBeneficios();
            }
        }
    }

    @Então("visualizo a tela informativa do beneficio Senior")
    public void visualizoATelaInformativaDoBeneficioSenior() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Tela tela = new Tela(driver);

        MobileElement textoBeneficioSenior = tela.buscarElementoNaTela("//android.widget.TextView[@text=\"Benefício Senior\"]", 20);
        assertTrue(textoBeneficioSenior.isDisplayed());
    }

    @E("clico no texto Central de Ajuda")
    public void clicoNoTextoCentralDeAjuda() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Tela tela = new Tela(driver);

        MobileElement elementoCentralDeAjuda = tela.buscarElementoNaTela("//android.widget.TextView[@text=\"Central de Ajuda\"]", 20);
        tela.clicarEmElemento(elementoCentralDeAjuda);
    }

    @Então("sou direcionado para a página do TOP Sênior na Central de Ajuda Autopass")
    public void souDirecionadoParaAPáginaDoTOPSêniorNaCentralDeAjudaAutopass() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Tela tela = new Tela(driver);

        MobileElement textoTopSenior = tela.buscarElementoNaTela("(//android.widget.TextView[@text=\"TOP Senior\"])[1]", 20);
        assertTrue(textoTopSenior.isDisplayed());
    }

    @Então("visualizo a informação de ambos os benefícios com suas datas de validade")
    public void visualizoAInformaçãoDeAmbosOsBenefíciosComSuasDatasDeValidade() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Tela tela = new Tela(driver);

        MobileElement textoValidadeBeneficioSenior = tela.buscarElementoNaTela("(//android.widget.TextView[@text=\"VALID.\"])[1]", 20);
        assertTrue(textoValidadeBeneficioSenior.isDisplayed());
        MobileElement textoBeneficioSenior = tela.buscarElementoNaTela("//android.widget.TextView[@text=\"Senior\"]", 20);
        assertTrue(textoBeneficioSenior.isDisplayed());

        MobileElement textoValidadeBeneficioPasseLivre = tela.buscarElementoNaTela("//android.widget.TextView[@text=\"Escolar Passe Livre\"]", 20);
        assertTrue(textoValidadeBeneficioPasseLivre.isDisplayed());
        MobileElement textoBeneficioPasseLivre = tela.buscarElementoNaTela("//android.widget.TextView[@text=\"Escolar Passe Livre\"]", 20);
        assertTrue(textoBeneficioPasseLivre.isDisplayed());
    }

    @E("clico em Perdi meu cartão")
    public void clicoEmPerdiMeuCartão() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Tela tela = new Tela(driver);

        MobileElement cartaoPerdiMeuCartao = tela.buscarElementoNaTela("//android.widget.TextView[@content-desc=\"Perdi meu Cartão\"]", 20);
        tela.clicarEmElemento(cartaoPerdiMeuCartao);

        MobileElement botaoContinuar = tela.buscarElementoNaTela("//android.widget.TextView[@content-desc=\"CONTINUAR\"]", 20);
        tela.clicarEmElemento(botaoContinuar);
    }

    @E("clico em continuar o cancelamento")
    public void clicoEmContinuarOCancelamento() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Tela tela = new Tela(driver);

        MobileElement botaoContinuarCancelamento = tela.buscarElementoNaTela("//android.widget.TextView[@content-desc=\"CONTINUAR\"]", 20);
        tela.clicarEmElemento(botaoContinuarCancelamento);
    }


    @E("clico em quero cancelar meu cartao")
    public void clicoEmQueroCancelarMeuCartao() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Tela tela = new Tela(driver);

        tela.buscarElementoNaTela("//android.widget.TextView[@content-desc=\"SOLICITAR SEGUNDA VIA\"]", 30);
    }

    @E("clico no botão Eu Quero")
    public void clicoNoBotãoEuQuero() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Tela tela = new Tela(driver);

        tela.scrollAteElemento("//android.widget.TextView[@text=\"Facilidade no embarque\"]",
                20,
                "new UiSelector().text(\"EU QUERO\")");

        MobileElement botaoEuQuero = tela.buscarElementoNaTela("//android.widget.TextView[@content-desc=\"EU QUERO\"]", 20);
        tela.clicarEmElemento(botaoEuQuero);
    }

    @E("seleciono a opção receber em casa")
    public void selecionoAOpçãoReceberEmCasa() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Tela tela = new Tela(driver);

        MobileElement botaoReceberEmCasa = tela.buscarElementoNaTela("//android.widget.TextView[contains(@text, 'Receber em casa')]", 20);
        tela.clicarEmElemento(botaoReceberEmCasa);
        MobileElement botaoContinuar = tela.buscarElementoNaTela("//android.widget.TextView[@content-desc=\"CONTINUAR\"]", 20);
        tela.clicarEmElemento(botaoContinuar);
        MobileElement botaoContinuarParaPagamento = tela.buscarElementoNaTela("//android.widget.TextView[@content-desc=\"CONTINUAR\"]", 20);
        tela.clicarEmElemento(botaoContinuarParaPagamento);
    }

    @Então("sou direcionado para o serviço de cartão da Pacman")
    public void souDirecionadoParaOServiçoDeCartãoDaPacman() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Tela tela = new Tela(driver);

        MobileElement botaoSolicitarPacman = tela.buscarElementoNaTela("//android.widget.Button[@text=\"Solicitar\"]", 20);
        assertTrue(botaoSolicitarPacman.isDisplayed());
    }

    @E("clico em Continuar")
    public void clicoEmContinuar() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Tela tela = new Tela(driver);

        MobileElement botaoContinuar = tela.buscarElementoNaTela("//android.widget.TextView[@content-desc=\"CONTINUAR\"]", 20);
        tela.clicarEmElemento(botaoContinuar);
    }


    @E("clico em retirar nas Pernambucanas")
    public void clicoEmRetirarNasPernambucanas() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Tela tela = new Tela(driver);

        MobileElement botaoRetirarPernambucanas = tela.buscarElementoNaTela("//android.widget.TextView[@text=\"Retirar nas Pernambucanas (grátis)\"]", 20);
        tela.clicarEmElemento(botaoRetirarPernambucanas);

        MobileElement botaoContinuar = tela.buscarElementoNaTela("//android.widget.TextView[@content-desc=\"CONTINUAR\"]", 20);
        tela.clicarEmElemento(botaoContinuar);
    }


    @E("concluo o agendamento")
    public void concluoOAgendamento() throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Thread.sleep(20000);
        driver.navigate().back();
    }

    @Então("so devo visualizar o elemento de retirar na loja")
    public void soDevoVisualizarOElementoDeRetirarNaLoja() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Tela tela = new Tela(driver);

        tela.buscarElementoNaTela("//android.widget.TextView[@text=\"Retirar nas Pernambucanas (grátis)\"]", 20);

        List elementos = driver.findElementsByXPath("//android.widget.TextView[@text=\"Receber em casa (R$ 28,50)\"]");
        assertTrue(elementos.isEmpty());
    }

    @E("excluo o cache do app")
    public void excluoOCacheDoApp() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        try {
            Celular.limparCache(driver);
        } catch (Exception e) {
            System.out.println("Tentando resetar o app novamente, feature Cartão TOP");
            Celular.limparCache(driver);
        }
    }

    @E("logo com uma conta recem criada")
    public void logoComUmaConteRecemCriada() throws Exception {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Tela tela = new Tela(driver);

        String senha ="Devires@123";
        String cpf = PostUser.criarUser(senha, "2000-12-30");

        MobileElement inputCpf = tela.buscarElementoNaTela("//android.widget.EditText[@content-desc=\"Espaço para digitar o cpf \"]", 40);
        MobileElement inputSenha = tela.buscarElementoNaTela("//android.widget.EditText[@content-desc=\"Espaço para digitar senha\"]", 40);
        MobileElement botaoEntrar = tela.buscarElementoNaTela("//android.widget.TextView[@content-desc=\"ENTRAR\"]", 40);

        tela.inputNoElemento(inputCpf, cpf);
        tela.inputNoElemento(inputSenha, senha);
        tela.clicarEmElemento(botaoEntrar);

    }

    @E("autorizo o aplicativo a acessar a localizacao")
    public void autorizoOAplicativoAAcessarALocalizacao() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;

        Celular.autorizarLocalizacao(driver);
    }


    @E("logo com uma conta recem criada com mais de sessenta anos")
    public void logoComUmaContaRecemCriadaComMaisDeSessentaAnos() throws Exception {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Tela tela = new Tela(driver);

        String senha ="Devires@123";
        String cpf = PostUser.criarUser(senha, "1960-12-30");

        MobileElement inputCpf = tela.buscarElementoNaTela("//android.widget.EditText[@content-desc=\"Espaço para digitar o cpf \"]", 40);
        MobileElement inputSenha = tela.buscarElementoNaTela("//android.widget.EditText[@content-desc=\"Espaço para digitar senha\"]", 40);
        MobileElement botaoEntrar = tela.buscarElementoNaTela("//android.widget.TextView[@content-desc=\"ENTRAR\"]", 40);

        tela.inputNoElemento(inputCpf, cpf);
        tela.inputNoElemento(inputSenha, senha);
        tela.clicarEmElemento(botaoEntrar);
    }

    @E("clico em Talvez Mais Tarde")
    public void clicoEmTalvezMaisTarde() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Tela tela = new Tela(driver);

        tela.clicarEmElemento("//android.widget.TextView[@text=\"TALVEZ MAIS TARDE\"]", 10);
    }

    @E("submeto o cartao final {string}")
    public void submetoOCartaoFinal(String arg0) {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Tela tela = new Tela(driver);



        tela.buscarElementoNaTela("//android.widget.TextView[@text=\"PAGAMENTO\"]", 10);
        tela.scrollAteElemento("//android.widget.TextView[@text=\"DETALHES DA COMPRA\"]", 10, "new UiSelector().text(\"TROCAR\")");
        tela.clicarEmElemento("//android.widget.TextView[@text=\"TROCAR\"]", 10);
        tela.clicarEmElemento("//android.widget.TextView[@text=\"•••• " + arg0 + "\"]", 10);
        tela.scrollAteElemento("//android.widget.TextView[@text=\"PAGAMENTO\"]", 10, "new UiSelector().text(\"CONFIRMAR PAGAMENTO\")");
        tela.clicarEmElemento("//android.widget.TextView[@text=\"CONFIRMAR PAGAMENTO\"]", 10);
    }

    @E("submeto pix como forma de pagamento para recarga comum")
    public void submetoPixComoFormaDePagamentoParaRecargaComum() {

        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Tela tela = new Tela(driver);

        tela.buscarElementoNaTela("//android.widget.TextView[@text=\"PAGAMENTO\"]", 10);
        tela.scrollAteElemento("//android.widget.TextView[@text=\"DETALHES DA COMPRA\"]", 10, "new UiSelector().text(\"TROCAR\")");
        tela.clicarEmElemento("//android.widget.TextView[@text=\"TROCAR\"]", 10);
        tela.clicarEmElemento("(//android.widget.TextView[@text=\"Pix\"])[2]", 10);
        tela.scrollAteElemento("//android.widget.TextView[@text=\"PAGAMENTO\"]", 10, "new UiSelector().text(\"CONFIRMAR PAGAMENTO\")");
        tela.clicarEmElemento("//android.widget.TextView[@text=\"CONFIRMAR PAGAMENTO\"]", 10);

    }

    @E("clico em Duvidas sobre o seu Beneficio Escolar")
    public void clicoEmDuvidasSobreOSeuBeneficioEscolar() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Tela tela = new Tela(driver);

        tela.clicarEmElemento("//android.widget.TextView[@content-desc=\"Dúvidas sobre seu Benefício Escolar?\"]", 10);
    }

    @Entao("sou direcionado para a pagina da EMTU de beneficio meia tarifa")
    public void souDirecionadoParaAPaginaDaEMTUDeBeneficioMeiaTarifa() {

        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Tela tela = new Tela(driver);

        MobileElement telaEmtu = tela.buscarElementoNaTela("//android.widget.Image[@text=\"Estudantes e Professores\"]", 20);

        assertTrue(telaEmtu.isDisplayed());
    }

    @Então("visualizo a tela de cancelamento enviado")
    public void visualizoATelaDeCancelamentoEnviado() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Tela tela = new Tela(driver);

        MobileElement botaoSegundaVia = tela.buscarElementoNaTela("//android.widget.TextView[@content-desc=\"SOLICITAR SEGUNDA VIA\"]", 20);
        assertTrue(botaoSegundaVia.isDisplayed());
    }

    @Então("visualizo a tela de beneficio escolar passe livre")
    public void visualizoATelaDeBeneficioEscolarPasseLivre() {

        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Tela tela = new Tela(driver);

        MobileElement textoPasseLivre = tela.buscarElementoNaTela("//android.widget.TextView[@content-desc=\"Benefício Escolar (,Passe Livre,)\"]", 20);

        assertTrue(textoPasseLivre.isDisplayed());
    }

    @E("dou scroll até outro valor")
    public void douScrollAtéOutroValor() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Tela tela = new Tela(driver);

        MobileElement pontos = tela.buscarElementoNaTela("//android.widget.TextView[@text=\"150 PONTOS\"]", 10);
        MobileElement agoraNao = tela.buscarElementoNaTela("//android.widget.TextView[@text=\"AGORA NÃO\"]", 10);

        Point center = pontos.getCenter();
        Point center2 = agoraNao.getCenter();

        tela.arrastarParaOLado(center.getX(), center.getY(), center2.getX(), center2.getY());
    }

    @Então("o filtro deve ser aplicado")
    public void oFiltroDeveSerAplicado() throws InterruptedException {
        Thread.sleep(3000);

    }
}
