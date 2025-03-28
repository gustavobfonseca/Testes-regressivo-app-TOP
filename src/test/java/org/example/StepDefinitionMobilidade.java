package org.example;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.example.PageObjects.Home;
import org.example.PageObjects.Login;
import org.example.PageObjects.PerfilDoUsuario;
import org.example.PageObjects.Tela;
import org.junit.Assert;

public class StepDefinitionMobilidade {

    @Quando("clico na opção \"Mapa das estações\"")
    public void clicoNaOpçãoMapaDasEstações() throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Home home = new Home(driver);
        Thread.sleep(3000);
        home.buscarMapa();

    }

    @Quando("clico na opção \"Mobilidade\"")
    public void clicoNaOpçãoMobilidade() throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Home home = new Home(driver);
        Thread.sleep(3000);
        home.buscarMobilidade();
        Tela tela = new Tela(driver);
        tela.clicarEmElemento("//android.widget.TextView[@text=\"Mobilidade\"]", 10);
    }

    @Dado("que eu acesso a tela home do aplicativo")
    public void queEuAcessoATelaHomeDoAplicativo() throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Login telaLogin = new Login(driver);
        telaLogin.buscarElementos();
        telaLogin.buscarElementos();
        telaLogin.limparCamposLogin();
        telaLogin.preencherFormulario("54926406829", "Teste@123");
        telaLogin.logar();
        Home telaHome = new Home(driver);

//        Thread.sleep(3000);
//        telaHome.esperarBotaoBiometria();
        try {
            telaHome.arrastarModalParaBaixo();
        } catch (Exception e) {
            telaHome.clicarBotaoModalQueroConhecer();
        }
        Assert.assertEquals("Tenha uma boa viagem.", telaHome.getMsgBoaViagem().getText());
    }

    @Então("visualizo a tela de Disponível em breve")
    public void visualizoATelaDeDisponivelEmBreve() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Home home = new Home(driver);

        home.buscarDisponivelEmBreve();
    }

    @Dado("que eu esteja na tela home do aplicativo")
    public void queEuEstejaNaTelaHomeDoAplicativo() throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Home home = new Home(driver);
//        Thread.sleep(15000);
        home.buscarBotaoBilhetes();
//        Assert.assertEquals("Tenha uma boa viagem.", home.getMsgBoaViagem().getText());

    }

    @Então("minha foto é removida no perfil de usuário")
    public void minhaFotoÉRemovidaNoPerfilDeUsuário() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        PerfilDoUsuario perfilDoUsuario = new PerfilDoUsuario(driver);

        perfilDoUsuario.buscarPerfilSemFoto();
    }

    @E("removida na apresentação da Home")
    public void removidaNaApresentaçãoDaHome() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Home home = new Home(driver);
        home.buscarFotoDePerfil();
    }

    @E("insiro um endereco de origem e destino")
    public void insiroUmEnderecoDeOrigemEDestino() throws InterruptedException {

        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Tela tela= new Tela(driver);
        Thread.sleep(5000);
        tela.clicarEmElemento("//*[contains(@content-desc, 'Brasil')]", 10);
        Thread.sleep(5000);
        tela.inputNoElemento("//android.widget.EditText[@text=\"Onde você está?\"]", "Rua Anny 870");
        Thread.sleep(5000);
        tela.clicarEmElemento("//android.widget.TextView[@text=\"Rua Anny, 870 - São João Climaco, São Paulo - SP, Brasil\"]", 10);
        MobileElement inputEndereco = tela.buscarElementoNaTela("//android.widget.TextView[@content-desc=\"Para onde vamos?\"]", 10);
        tela.clicarEmElemento("//android.widget.TextView[@content-desc=\"Para onde vamos?\"]", 10);
        Thread.sleep(5000);
        tela.inputNoElemento("//android.widget.EditText[@text=\"Para onde vamos?\"]", "Rua Haddock Lobo");
//        tela.clicarEmElemento("//android.widget.TextView[contains(text,  \"Brasil\"]", 10);
        tela.clicarEmElemento("//android.widget.TextView[@text=\"Rua Haddock Lobo - Cerqueira César, São Paulo - SP, Brasil\"]", 10);
    }

    @E("clico em Onibus e Metro")
    public void clicoEmOnibusEMetro() throws InterruptedException {
        Thread.sleep(10000);
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Tela tela= new Tela(driver);

        tela.clicarEmElemento("//android.widget.TextView[@content-desc=\"Ônibus e metrô\"]", 10);
        Thread.sleep(10000);

    }

    @Então("visualizo a lista de rotas ate o destino")
    public void visualizoAListaDeRotasAteODestino() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Tela tela= new Tela(driver);

        MobileElement linha = tela.buscarElementoNaTela("(//android.widget.TextView[@content-desc=\"5029-10\"])[1]", 10);

        Assert.assertTrue(linha.isDisplayed());
    }

    @E("seleciono uma das rotas listadas")
    public void selecionoUmaDasRotasListadas() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Tela tela= new Tela(driver);

        tela.clicarEmElemento("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup", 10);

    }

    @E("arrasto o modal pra cima")
    public void arrastoOModalPraCima() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Tela tela= new Tela(driver);

        MobileElement linhaOnibus = tela.buscarElementoNaTela("//android.widget.TextView[@content-desc=\"5029-10\"]", 10);
        MobileElement botaoVoltar = tela.buscarElementoNaTela("//android.widget.TextView[@text=\"\uF124\"]", 10);

        tela.arrastarParaOLado(linhaOnibus.getLocation().getX(), linhaOnibus.getLocation().getY(),
                linhaOnibus.getLocation().getX(), botaoVoltar.getLocation().getY());
    }

    @E("deslizo o modal até o final")
    public void deslizoOModalAtéOFinal() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Tela tela = new Tela(driver);

        MobileElement linha2 = tela.buscarElementoNaTela("//android.widget.TextView[@content-desc=\"Sacomã - Plataforma 1\"]", 10);
        MobileElement endereco = tela.buscarElementoNaTela("//android.widget.TextView[@content-desc=\"Rua Anny, 870, Sacoma, São Paulo, São Paulo\"]", 10);

        tela.arrastarParaOLado(endereco.getCenter().getX(), linha2.getCenter().getY(),
                endereco.getCenter().getX(), endereco.getCenter().getY());

    }

    @E("clico em encerrar viagem")
    public void clicoEmEncerrarViagem() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Tela tela= new Tela(driver);

        tela.clicarEmElemento("//android.widget.TextView[@content-desc=\"Encerrar viagem\"]", 10);

    }

    @E("arrasto o mapa")
    public void arrastoOMapa() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Tela tela= new Tela(driver);

        MobileElement localizacao = tela.buscarElementoNaTela("//android.view.View[@content-desc=\"Mapa do Google\"]/android.view.View", 10);
        MobileElement botaoVoltar = tela.buscarElementoNaTela("//android.widget.TextView[@text=\"\uF124\"]", 10);

        tela.arrastarParaOLado(localizacao.getCenter().getX(), localizacao.getCenter().getY(),
                botaoVoltar.getCenter().getX(), botaoVoltar.getCenter().getY());
    }

    @E("clico em re centralizar")
    public void clicoEmReCentralizar() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Tela tela= new Tela(driver);

        tela.clicarEmElemento("//android.widget.TextView[@text=\"\uF37F\"]", 10);
    }

    @Então("o mapa centraliza para minha posição atual")
    public void oMapaCentralizaParaMinhaPosiçãoAtual() {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;
        Tela tela= new Tela(driver);

        MobileElement localizacao = tela.buscarElementoNaTela("//android.view.View[@content-desc=\"Mapa do Google\"]/android.view.View", 10);
        MobileElement botaoVoltar = tela.buscarElementoNaTela("//android.widget.TextView[@text=\"\uF124\"]", 10);
        MobileElement botaoCentralizar = tela.buscarElementoNaTela("//android.widget.TextView[@text=\"\uF37F\"]", 10);

        Assert.assertEquals(botaoVoltar.getLocation().getY() - localizacao.getLocation().getY(),
                botaoCentralizar.getLocation().getY() - localizacao.getLocation().getY());
    }
}