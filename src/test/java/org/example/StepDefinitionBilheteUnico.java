package org.example;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.example.PageObjects.InserirDadosCartao;
import org.example.PageObjects.Tela;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class StepDefinitionBilheteUnico {

    AppiumDriver driver = AppiumDriverConfig.Instance().driver;
    Tela tela = new Tela(driver);

    @Quando("navego ate Bilhete Unico")
    public void selecionoOMotivoDoCancelamentoDoCadastro() {
        tela.clicarEmElemento("//android.widget.TextView[@text=\"Bilhete\n" +
                "Único\"]", 30);
    }


    @Entao("visualizo a tela de onboarding de Bilhete Unico")
    public void visualizoATelaDeOnboardingDeBilheteUnico() {
        MobileElement msgOnboarding = tela.buscarElementoNaTela("//android.widget.TextView[@text=\"Agora você pode recarregar seu Bilhete Único pelo App TOP\"]", 10);
        Assert.assertTrue(msgOnboarding.isDisplayed());
    }

    @E("clico em Cadasrar Bilhete Unico")
    public void clicoEmCadasrarBilheteUnico() {
        tela.scrollAteElemento(
                "//android.widget.TextView[@text=\"Agora você pode recarregar seu Bilhete Único pelo App TOP\"]",
                10,
                "new UiSelector().text(\"CADASTRAR BILHETE ÚNICO\")");

        tela.clicarEmElemento("//android.widget.TextView[@text=\"CADASTRAR BILHETE ÚNICO\"]", 10);
    }

    @E("clico em Onde Encontrar o Numero do Bilhete Unico")
    public void clicoEmOndeEncontrarONumeroDoBilheteUnico() {
        tela.clicarEmElemento("//android.widget.TextView[@text=\"Onde encontrar o número do \n" +
                "Bilhete Único?\"]", 10);
    }

    @Entao("visualizo o modal informativo sobre a localizacao do numero do bilhete")
    public void visualizoOModalInformativoSobreALocalizacaoDoNumeroDoBilhete() {
        MobileElement modalNumeroBilhete = tela.buscarElementoNaTela("//android.widget.TextView[@text=\"Onde encontrar o número do Bilhete Único?\"]", 10);
        Assert.assertTrue(modalNumeroBilhete.isDisplayed());
    }

    @E("submeto as informacoes validas do bilhete")
    public void submetoAsInformacoesValidasDoBilhete(DataTable dataTable) {
        List<Map<String, String>> dados = dataTable.asMaps(String.class, String.class);
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        InserirDadosCartao paginaCartoes = new InserirDadosCartao(driver);
        for (Map<String, String> linha : dados) {
            String numBu = linha.get("numero");
            String apelido = linha.get("apelido");

            tela.inputNoElemento("//android.widget.EditText[@text=\"0000000000\"]", numBu);
            tela.inputNoElemento("//android.widget.EditText[@text=\"Ex.: Meu Bilhete Único\"]", apelido);
        }
        tela.clicarEmElemento("//android.widget.TextView[@text=\"CONTINUAR\"]", 10);
    }

    @Entao("devo visualizar a tela do BU")
    public void devoVisualizarATelaDoBU() {
        MobileElement telaBu = tela.buscarElementoNaTela("//android.widget.TextView[@text=\"BU Matheus\"]", 10);

        Assert.assertTrue(telaBu.isDisplayed());

    }

    @E("clico em Saiba Mais na tela de BU")
    public void clicoEmSaibaMaisNaTelaDeBU() {
        tela.clicarEmElemento("//android.widget.TextView[@text=\"Saber mais\"]", 10);
    }

    @E("clico em adicionar novo cartao")
    public void clicoEmAdicionarNovoCartao() {
        tela.clicarEmElemento("//android.widget.TextView[@text=\"ADICIONAR NOVO CARTÃO\"]", 10);
    }

    @Entao("visualizo o numero do novo cartao cadastrado igual a {string}")
    public void visualizoONumeroDoNovoCartaoCadastradoIgualA(String arg0) {
        MobileElement numeroBu = tela.buscarElementoNaTela("//android.widget.TextView[@text=\"463114703\"]", 10);
        Assert.assertTrue(numeroBu.isDisplayed());
    }

    @Entao("visualizo a tela de bilhetes cadastrados")
    public void visualizoATelaDeBilhetesCadastrados() {
        tela.clicarEmElemento("//android.widget.TextView[@text=\"VER TODOS OS CARTÕES\"]", 10);

        MobileElement bilhete1 = tela.buscarElementoNaTela("//android.widget.TextView[@text=\"556005492\"]", 10);
        MobileElement bilhete2 = tela.buscarElementoNaTela("//android.widget.TextView[@text=\"463114703\"]", 10);

        Assert.assertTrue(bilhete1.isDisplayed() && bilhete2.isDisplayed());
    }

    @Entao("visualizo a tela de bilhetes cadastrados com os {int} bilhetes")
    public void visualizoATelaDeBilhetesCadastradosComOsBilhetes(int arg0) {
        tela.clicarEmElemento("//android.widget.TextView[@text=\"VER TODOS OS CARTÕES\"]", 10);

        MobileElement bilhete1 = tela.buscarElementoNaTela("//android.widget.TextView[@text=\"556005492\"]", 10);
        MobileElement bilhete2 = tela.buscarElementoNaTela("//android.widget.TextView[@text=\"463114703\"]", 10);
        MobileElement bilhete3 = tela.buscarElementoNaTela("//android.widget.TextView[@text=\"510824478\"]", 10);

        Assert.assertTrue(bilhete1.isDisplayed() && bilhete2.isDisplayed() && bilhete3.isDisplayed());
    }

    @E("o botao de cadastrar bilhete unico inativo")
    public void oBotaoDeCadastrarBilheteUnicoInativo() throws InterruptedException {
        tela.clicarEmElemento("//android.widget.TextView[@text=\"ADICIONAR NOVO CARTÃO\"]", 10);
        Thread.sleep(1500);
        MobileElement bilhete3 = tela.buscarElementoNaTela("//android.widget.TextView[@text=\"510824478\"]", 10);
        Assert.assertTrue(bilhete3.isDisplayed());
    }

    @E("excluo o cartao recem cadastrado")
    public void excluoOCartaoRecemCadastrado() {
        tela.clicarEmElemento("//android.widget.TextView[@text=\"510824478\"]", 10);
        tela.clicarEmElemento("//android.widget.TextView[@text=\"Editar\n" +
                "Cartão\"]", 20);
        tela.clicarEmElemento("//android.widget.TextView[@text=\"EXCLUIR BILHETE ÚNICO\"]", 20);
        tela.clicarEmElemento("//android.widget.TextView[@text=\"SIM, EXCLUIR\"]", 20);
    }

    @E("excluo o cartao numero {string}")
    public void excluoOCartaoNumero(String arg0) {
        tela.clicarEmElemento("//android.widget.TextView[@text=\"" + arg0 + "\"]", 10);
        tela.clicarEmElemento("//android.widget.TextView[@text=\"Editar\n" +
                "Cartão\"]", 20);
        tela.clicarEmElemento("//android.widget.TextView[@text=\"EXCLUIR BILHETE ÚNICO\"]", 20);
        tela.clicarEmElemento("//android.widget.TextView[@text=\"SIM, EXCLUIR\"]", 20);

    }

    @Entao("visualizo a mensagem de Bilhete Unico ja vinculado ao seu cadastro no campo numero")
    public void visualizoAMensagemDeBilheteUnicoJaVinculadoAoSeuCadastroNoCampoNumero() {
        MobileElement textoConflito = tela.buscarElementoNaTela("//android.widget.TextView[@text=\"Bilhete Único já vinculado ao seu cadastro.\"]", 20);
        Assert.assertTrue(textoConflito.isDisplayed());
    }

    @E("clico no bilhete unico de numero {string}")
    public void clicoNoBilheteUnicoDeNumero(String arg0) {
        tela.clicarEmElemento("//android.widget.TextView[@text=\"" + arg0 + "\"]", 120);
    }

    @E("clico em editar bilhete unico")
    public void clicoEmEditarBilheteUnico() {
        tela.clicarEmElemento("//android.widget.TextView[@text=\"Editar\n" +
                "Cartão\"]", 20);
    }

    @E("altero o apelido do cartao")
    public void alteroOApelidoDoCartao() {
        tela.clicarEmElemento("//android.widget.TextView[@text=\"\uE912\"]", 10);
        tela.inputNoElemento("//android.widget.EditText[@text=\"BU Matheus\"]", "MATHEUS ESTUDANTE");
        tela.clicarEmElemento("//android.widget.TextView[@text=\"SALVAR ALTERAÇÃO\"]", 10);
    }

    @Entao("visualizo a tela de visualizacao de bilhete com o nome alterado")
    public void visualizoATelaDeVisualizacaoDeBilheteComONomeAlterado() {
        MobileElement bilheteAlterado = tela.buscarElementoNaTela("//android.widget.TextView[@text=\"MATHEUS ESTUDANTE\"]", 10);
    }

    @E("clico em Recargar")
    public void clicoEmRecargar() {
        tela.clicarEmElemento("//android.widget.TextView[@text=\"Recarregar\"]", 20);
    }

    @E("clico em Comum")
    public void clicoEmComum() {
        tela.clicarEmElemento("//android.widget.TextView[@text=\"Comum\"]", 20);
        tela.clicarEmElemento("//android.widget.TextView[@text=\"CONTINUAR\"]", 20);
    }

    @E("confirmo um valor entre {int} e {int}")
    public void confirmoUmValorEntreE(int arg0, int arg1) {
        tela.clicarEmElemento("//android.widget.TextView[@text=\"CONTINUAR\"]", 20);
    }

    @E("confirmo pix como forma de pagamento para recarga de BU")
    public void confirmoPixComoFormaDePagamentoParaRecargaDeBU() {
        tela.clicarEmElemento("//android.widget.TextView[@text=\"Pix\"]", 20);
        tela.clicarEmElemento("//android.widget.TextView[@text=\"CONTINUAR\"]", 20);
    }

    @Entao("visualizo a tela de codigo pix gerado para recarga de bilhete unico podendo copiar o codigo via icone ou botao Copiar Codigo Pix")
    public void visualizoATelaDeCodigoPixGeradoParaRecargaDeBilheteUnicoPodendoCopiarOCodigoViaIconeOuBotaoCopiarCodigoPix() {
        MobileElement textoRecargaBu = tela.buscarElementoNaTela("//android.widget.TextView[@text=\"Recarga de Bilhete Único\"]", 60);
        MobileElement iconeCopiarCodigo = tela.buscarElementoNaTela("//android.widget.TextView[@text=\"\uE8F0\"]", 60);
        MobileElement botaoCopiarCodigo = tela.buscarElementoNaTela("//android.widget.TextView[@text=\"COPIAR CÓDIGO PIX\"]", 60);

        Assert.assertTrue(textoRecargaBu.isDisplayed() && iconeCopiarCodigo.isDisplayed() && botaoCopiarCodigo.isDisplayed());

    }

    @Entao("visualizo a tela de codigo pix expirado depois de mais de {int} minuto e meio de espera")
    public void visualizoATelaDeCodigoPixExpiradoDepoisDeMaisDeMinutoEMeioDeEspera(int arg0) {
        MobileElement codigoPixExpirado = tela.buscarElementoNaTela("//android.widget.TextView[@text=\"Parece que o tempo para pagamento do código PIX foi excedido. Por favor, realize sua compra novamente.\"]", 180);

        Assert.assertTrue(codigoPixExpirado.isDisplayed());
    }

    @E("clico em Diaria")
    public void clicoEmDiaria() {
        tela.clicarEmElemento("//android.widget.TextView[@text=\"Diário\"]", 20);
        tela.clicarEmElemento("//android.widget.TextView[@text=\"CONTINUAR\"]", 20);
    }

    @E("confirmo a opcao Onibus Metro e Trem")
    public void confirmoAOpcaoOnibusMetroETrem() {
        tela.clicarEmElemento("//android.widget.TextView[@text=\"Ônibus, Metrô e Trem\"]", 20);
        tela.clicarEmElemento("//android.widget.TextView[@text=\"CONTINUAR\"]", 20);
    }

    @E("confirmo o numero de cotas entre {int} e {int}")
    public void confirmoONumeroDeCotasEntreE(int arg0, int arg1) {
        tela.clicarEmElemento("//android.widget.TextView[@text=\"CONTINUAR\"]", 20);
    }

    @E("confirmo a opcao Metro e Trem")
    public void confirmoAOpcaoMetroETrem() {
        tela.clicarEmElemento("//android.widget.TextView[@text=\"Metrô e Trem\"]", 20);
        tela.clicarEmElemento("//android.widget.TextView[@text=\"CONTINUAR\"]", 20);

    }

    @E("confirmo a opcao onibus")
    public void confirmoAOpcaoOnibus() {
        tela.clicarEmElemento("//android.widget.TextView[@text=\"Ônibus\"]", 20);
        tela.clicarEmElemento("//android.widget.TextView[@text=\"CONTINUAR\"]", 20);
    }

    @E("clico em Mensal")
    public void clicoEmMensal() {
        tela.clicarEmElemento("//android.widget.TextView[@text=\"Mensal\"]", 20);
        tela.clicarEmElemento("//android.widget.TextView[@text=\"CONTINUAR\"]", 20);

    }

    @Entao("não devo visualizar o cartão numero {string} na lista de cartoes")
    public void nãoDevoVisualizarOCartãoNumeroNaListaDeCartoes(String arg0) throws InterruptedException {
        Thread.sleep(3000);
        List cartaoExcluido = driver.findElementsByXPath("//android.widget.TextView[@text=\"" + arg0 + "\"]");
        Assert.assertTrue(cartaoExcluido.isEmpty());
    }

    @E("excluo o único cartao cadastrado")
    public void excluoOÚnicoCartaoCadastrado() {
        tela.clicarEmElemento("//android.widget.TextView[@text=\"Editar\n" +
                "Cartão\"]", 20);
        tela.clicarEmElemento("//android.widget.TextView[@text=\"EXCLUIR BILHETE ÚNICO\"]", 20);
        tela.clicarEmElemento("//android.widget.TextView[@text=\"SIM, EXCLUIR\"]", 20);
    }

    @Então("visualizo a tela de - Você não possui nenhum bilhete único cadastrado.")
    public void visualizoATelaDeVocêNãoPossuiNenhumBilheteÚnicoCadastrado() {
        tela.buscarElementoNaTela("//android.widget.TextView[@text=\"Bilhete Único excluido com sucesso!\"]", 30);

        MobileElement mensagemNenhumBu = tela.buscarElementoNaTela("//android.widget.TextView[@text=\"Bilhete Único excluido com sucesso!\"]", 20);
        MobileElement botaoAdicionarCartao = tela.buscarElementoNaTela("//android.widget.TextView[@text=\"ADICIONAR NOVO CARTÃO\"]", 20);

        Assert.assertTrue(mensagemNenhumBu.isDisplayed() && botaoAdicionarCartao.isDisplayed());
    }

    @Entao("visualizo a mensagem de \"Bilhete único já está vinculado a outro perfil.” No campo Número")
    public void visualizoAMensagemDeBilheteÚnicoJáEstáVinculadoAOutroPerfilNoCampoNúmero() throws Throwable {
        MobileElement textoConflito = tela.buscarElementoNaTela("//android.widget.TextView[@text=\"Bilhete Único já está vinculado a outro perfil.\"]", 20);
        Assert.assertTrue(textoConflito.isDisplayed());
    }

    @E("adiciono {int} cotas")
    public void adicionoCotas(int arg0) {
        MobileElement addCotas = tela.buscarElementoNaTela("//android.widget.TextView[@text=\"+\"]", 10);
        for (int i = 0; i < arg0-1; i++) {
            tela.clicarEmElemento(addCotas);
        }
    }
}
