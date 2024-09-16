package org.example;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.example.PageObjects.*;

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

        tela1CartaoTop.buscarBotaoComprarCreditos();
        Thread.sleep(2000);
        tela1CartaoTop.clicarBotaoComprarCreditos();

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

        tela2CartaoTop.inputarValorDeCredito(arg0);

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

        tela3CartaoTop.buscarBotaoCartaoDeDebito();
        tela3CartaoTop.clicarBotaoCartaoDeDebito();
        tela3CartaoTop.buscarBotaoConfirmarTela3();
        tela3CartaoTop.clicarBotaoConfirmarTela3();
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
        CartaoTop tela1CartaoTop = new CartaoTop(driver);

        tela1CartaoTop.buscarBotaoExpandirModalSaldo();
        tela1CartaoTop.clicarBotaoExpandirModalSaldo();

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

        tela1CartaoTop.buscarBotaoComunicarPerdaCartao();
        tela1CartaoTop.clicarBotaoComunicarPerdaCartao();
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

        tela1CartaoTop.buscarIconeFiltro();
        tela1CartaoTop.clicarFiltroDeHistorico();
    }

    @E("filtro por periodo e uso")
    public void filtroPorPeriodoEUso() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        CartaoTop tela2CartaoTop = new CartaoTop(driver);

        tela2CartaoTop.buscarElementosFiltro();
        tela2CartaoTop.clicarFiltroDePeriodo();
        tela2CartaoTop.clicarFiltroDeTipoDeTransacao();
        tela2CartaoTop.clicarBotaoAplicarFiltros();
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

        MobileElement elementoExpandirModalBeneficio = tela.buscarElementoNaTela("(//android.widget.TextView[@text=\"\uE8B4\"])[2]", 20);
        tela.clicarEmElemento(elementoExpandirModalBeneficio);
    }

    @E("clico no icone Saiba Mais no item Passe Livre")
    public void clicoNoIconeSaibaMaisNoItemPasseLivre() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Tela tela = new Tela(driver);

        MobileElement elementoSaibaMais = tela.buscarElementoNaTela("//android.widget.TextView[@text=\"Saiba mais\"]", 20);
        tela.clicarEmElemento(elementoSaibaMais);
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

        MobileElement elementoSaibaMaisSenior = tela.buscarElementoNaTela("//android.widget.TextView[@text=\"Saiba mais\"]", 20);
        tela.clicarEmElemento(elementoSaibaMaisSenior);
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

        MobileElement botaoQueroCancelarMeuCartao = tela.buscarElementoNaTela("//android.widget.TextView[@content-desc=\"MANTER MEU CARTÃO TRANSPORTE\"]", 20);
        tela.clicarEmElemento(botaoQueroCancelarMeuCartao);
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

        MobileElement botaoReceberEmCasa = tela.buscarElementoNaTela("//android.widget.TextView[@text=\"Receber em casa (R$ 28,50)\"]", 20);
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
}
