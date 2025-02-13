package org.example;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.example.PageObjects.Home;
import org.example.PageObjects.Tela;
import org.junit.Assert;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.touch.TouchActions;

import java.util.Set;

public class StepDefinitionMinhasVantagens {

    private final AppiumDriver driver = AppiumDriverConfig.Instance().driver;
    private final Tela tela = new Tela(driver);

    @E("dou scroll até Minhas Vantagens")
    public void douScrollAteMinhasVantagens() {
        tela.scrollAteElemento(
                "//android.widget.TextView[@text=\"Transporte\"]",
                20,
                "new UiSelector().text(\"SuperTOP\n" +
                        "\")");

    }

    @E("clico em TOP+ recompensas")
    public void clicoEmTOPRecompensas() {
        MobileElement topMaisRecompensas = tela.buscarElementoNaTela(
                "//android.widget.TextView[@text=\"TOP +\n" +
                "Recompensas\"]", 20);
        tela.clicarEmElemento(topMaisRecompensas);
    }

    @Então("visualizo o onboarding do TOP + recompensas")
    public void visualizoOOnboardingDoTOPRecompensas() {
        MobileElement textoOnboarding = tela.buscarElementoNaTela("//android.widget.TextView[@text=\"Você faz parte do\n" +
                "TOP+ Recompensas\"]", 20);
        Assert.assertTrue(textoOnboarding.isDisplayed());
        Set contextHandles = driver.getContextHandles();
        for(Object contextHandle : contextHandles){
            System.out.println("Contexto disponível: " + contextHandle);
        }
    }

    @Quando("avanco pelas tres etapas do onboarding")
    public void avancoPelasTresEtapasDoOnboarding() {
        tela.clicarEmElemento("//android.widget.TextView[@content-desc=\"PRÓXIMO\"]",
                "//android.widget.TextView[@text=\"Economia com\n" +
                        "praticidade\"]");

        tela.clicarEmElemento("//android.widget.TextView[@content-desc=\"PRÓXIMO\"]",
                "//android.widget.TextView[@content-desc=\"PRÓXIMO\"]");

        MobileElement botaoProximo = tela.buscarElementoNaTela("//android.widget.TextView[@content-desc=\"PRÓXIMO\"]", 20);
        tela.clicarEmElemento(botaoProximo);
    }

    @Então("sou direcionado para a webview na Minu")
    public void souDirecionadoParaAWebviewNaMinu() throws InterruptedException {
        tela.buscarElementoNaTela("//android.widget.Button[@text=\"Minhas recompensas\"]", 30);
        Thread.sleep(1000);
    }

    @Quando("clico em Pular na primeira tela do onboarding")
    public void clicoEmPularNaPrimeiraTelaDoOnboarding() {
        MobileElement botaoPular = tela.buscarElementoNaTela("//android.widget.TextView[@text=\"PULAR\"]", 10);
        tela.clicarEmElemento(botaoPular);
    }

    @Quando("clico em nao mostrar mais")
    public void clicoEmNaoMostrarMais() {
        MobileElement botaoNaoMostrarmais = tela.buscarElementoNaTela("//android.widget.TextView[@text=\"NÃO MOSTRAR MAIS\"]", 20);
        tela.clicarEmElemento(botaoNaoMostrarmais);
    }

    @E("fecho a webview da Minu")
    public void fechoAWebviewDaMinu() {
        driver.navigate().back();
    }

    @Quando("eu acesso o TOP Saude")
    public void euAcessoOTOPSaude() {
        MobileElement topSaude = tela.buscarElementoNaTela("//android.widget.TextView[@text=\"TOP +\n" +
                "Recompensas\"]", 20);
        Point pontoA = topSaude.getLocation();
        MobileElement personalizarFavoritos = tela.buscarElementoNaTela("//android.widget.TextView[@text=\"Personalizar\n" +
                "Favoritos\"]", 20);
        Point pontoB = personalizarFavoritos.getLocation();
        tela.arrastarParaOLado(pontoA.getX(), pontoA.getY(), pontoB.getX(), pontoB.getY());
        MobileElement botaoTopSaude = tela.buscarElementoNaTela("//android.widget.TextView[@text=\"TOP\n" +
                "Saúde\"]", 20);
        tela.clicarEmElemento(botaoTopSaude);
    }


    @Então("sou direcionado para a pagina de guia medico da AVUS")
    public void souDirecionadoParaAPaginaDeGuiaMedicoDaAVUS() {
        tela.buscarElementoNaTela("//android.widget.TextView[@text=\"Bem-vindo ao TOP Saúde!\"]", 20);

    }

    @E("clico em Saiba mais")
    public void clicoEmSaibaMais() {
        MobileElement verPlanos = tela.buscarElementoNaTela("//android.widget.TextView[@content-desc=\"VER PLANOS\"]", 20);
        tela.clicarEmElemento(verPlanos);

        MobileElement saibaMais = tela.buscarElementoNaTela("//android.widget.TextView[@text=\"Saiba mais sobre o TOP Saúde\"]", 20);
        tela.clicarEmElemento(saibaMais);
    }

    @Então("sou direcionado para a pagina do TOP Saude")
    public void souDirecionadoParaAPaginaDoTOPSaude() {
        MobileElement textoTopSaude = tela.buscarElementoNaTela("(//android.widget.TextView[@text=\"TOP Saúde\"])[1]", 20);
        Assert.assertTrue(textoTopSaude.isDisplayed());
    }

    @E("clico em Quero Contratar")
    public void clicoEmQueroContratar() {
        tela.scrollAteElemento("//android.widget.TextView[@content-desc=\"VER PLANOS\"]", 10, "new UiSelector().text(\"QUERO CONTRATAR\")");

        MobileElement queroContratar = tela.buscarElementoNaTela("//android.widget.TextView[@content-desc=\"QUERO CONTRATAR\"]", 20);
        tela.clicarEmElemento(queroContratar);
    }

    @Então("sou direcionado para a webview da Avus")
    public void souDirecionadoParaAWebviewDaAvus() {
        MobileElement textoTopSaude = tela.buscarElementoNaTela("(//android.widget.TextView[@text=\"TOP Saúde\"])[2]", 20);
        Assert.assertTrue(textoTopSaude.isDisplayed());

    }

    @E("dou scroll até Drogaria São Paulo")
    public void douScrollAtéDrogariaSãoPaulo() {
        MobileElement topSaude = tela.buscarElementoNaTela("//android.widget.TextView[@text=\"TOP +\n" +
                "Recompensas\"]", 20);
        Point pontoA = topSaude.getLocation();
        MobileElement personalizarFavoritos = tela.buscarElementoNaTela("//android.widget.TextView[@text=\"Personalizar\n" +
                "Favoritos\"]", 20);
        Point pontoB = personalizarFavoritos.getLocation();
        tela.arrastarParaOLado(pontoA.getX(), pontoA.getY(), pontoB.getX(), pontoB.getY());
    }

    @E("clico em Drogaria Sao Paulo")
    public void clicoEmDrogariaSaoPaulo() {

        MobileElement drogariaSãoPaulo = tela.buscarElementoNaTela("//android.widget.TextView[@text=\"Drogaria\n" +
                "São Paulo\"]", 20);
        tela.clicarEmElemento(drogariaSãoPaulo);
    }

    @Quando("eu clico em Buscar Loja")
    public void euClicoEmBuscarLoja() {
        tela.scrollAteElemento("//android.widget.TextView[@content-desc=\"DESCONTO EM ,\n" +
                ", LOJA FÍSICA\"]", 10, "new UiSelector().text(\"BUSCAR LOJA\")");

        MobileElement buscarLoja = tela.buscarElementoNaTela("//android.widget.TextView[@content-desc=\"BUSCAR LOJA\"]", 10);
        tela.clicarEmElemento(buscarLoja);
    }

    @Então("sou direcionado para a página institucional da Drogaria Sao Paulo")
    public void souDirecionadoParaAPáginaInstitucionalDaDrogariaSaoPaulo() {
        MobileElement nossasLojas = tela.buscarElementoNaTela("(//android.widget.TextView[@text=\"Nossas Lojas\"])[1]", 10);
        Assert.assertTrue(nossasLojas.isDisplayed());
    }

    @Quando("eu clico em desconto pelo site")
    public void euClicoEmDescontoPeloSite() {
        MobileElement descontoPeloSite = tela.buscarElementoNaTela("//android.widget.TextView[@content-desc=\"DESCONTO ,\n" +
                ", PELO SITE\"]", 20);
        tela.clicarEmElemento(descontoPeloSite);
    }

    @E("clico em ir para o site")
    public void clicoEmIrParaOSite() {
        tela.scrollAteElemento("//android.widget.TextView[@content-desc=\"DESCONTO EM ,\n" +
                ", LOJA FÍSICA\"]",
                20,
                "new UiSelector().text(\"IR PARA O SITE\")");
        MobileElement irParaOSite = tela.buscarElementoNaTela("//android.widget.TextView[@content-desc=\"IR PARA O SITE\"]", 20);
        tela.clicarEmElemento(irParaOSite);
    }

    @Então("sou direcionado para o login na Drogaria Sao Paulo")
    public void souDirecionadoParaOLoginNaDrogariaSaoPaulo() {
        MobileElement textoLogin = tela.buscarElementoNaTela("//android.widget.TextView[@text=\"Cadastre-se\"]", 20);
        Assert.assertTrue(textoLogin.isDisplayed());
    }

    @E("troco a ordem de exibição das vantagens")
    public void trocoAOrdemDeExibiçãoDasVantagens() {
        MobileElement topMaisRecompensas = tela.buscarElementoNaTela("//android.widget.TextView[@text=\"TOP + RECOMPENSAS\"]", 20);
        MobileElement drogariaSp = tela.buscarElementoNaTela("//android.widget.TextView[@text=\"DROGARIA SP\"]", 20);
        Point pontoA = topMaisRecompensas.getLocation();
        Point pontoB = drogariaSp.getLocation();
        tela.arrastarParaOLado(pontoA.getX(), pontoA.getY(), pontoB.getX(), pontoB.getY());
        MobileElement confirmar = tela.buscarElementoNaTela("//android.widget.TextView[@text=\"CONFIRMAR\"]", 20);
        tela.clicarEmElemento(confirmar);
    }

    @E("clico em Personalizar Favoritos")
    public void clicoEmPersonalizarFavoritos() {
        MobileElement personalizarFavoritos = tela.buscarElementoNaTela("//android.widget.TextView[@text=\"Personalizar\n" +
                "Favoritos\"]", 20);
        tela.clicarEmElemento(personalizarFavoritos);
    }

    @Então("retorno a home com a exibicao dos menus de vantagens ordenados de acordo com a minha escolha")
    public void retornoAHomeComAExibicaoDosMenusDeVantagensOrdenadosDeAcordoComAMinhaEscolha() {
        MobileElement menuSuperTop = tela.buscarElementoNaTela("//android.widget.TextView[@text=\"SuperTOP\n" +
                "\"]", 5);
        MobileElement menuTopSaude = tela.buscarElementoNaTela("//android.widget.TextView[@text=\"TOP\n" +
                "Saúde\"]",5);
        MobileElement menuDrogariaSaoPaulo = tela.buscarElementoNaTela("//android.widget.TextView[@text=\"Drogaria\n" +
                "São Paulo\"]", 5);

        int posicaoXTopSaude = menuTopSaude.getLocation().getX();
        int posicaoXDrogariaSaoPaulo = menuDrogariaSaoPaulo.getLocation().getX();
        int posicaoXSuperTop = menuSuperTop.getLocation().getX();

        Assert.assertTrue(posicaoXTopSaude < posicaoXDrogariaSaoPaulo &&
                posicaoXTopSaude > posicaoXSuperTop);

    }

    @E("o menu de personalizar favoritos deve estar por utilmo")
    public void oMenuDePersonalizarFavoritosDeveEstarPorUtilmo() {
        MobileElement drogariaSaoPaulo = tela.buscarElementoNaTela("//android.widget.TextView[@text=\"Drogaria\n" +
                "São Paulo\"]", 20);
        Point pontoA = drogariaSaoPaulo.getLocation();
        MobileElement superTop = tela.buscarElementoNaTela("//android.widget.TextView[@text=\"SuperTOP\n" +
                "\"]", 20);
        Point pontoB = superTop.getLocation();
        tela.arrastarParaOLado(pontoA.getX(), pontoA.getY(), pontoB.getX(), pontoB.getY());
        MobileElement topMaisRecompensas = tela.buscarElementoNaTela("//android.widget.TextView[@text=\"TOP +\n" +
                "Recompensas\"]", 20);

        MobileElement personalizarFavoritos = tela.buscarElementoNaTela("//android.widget.TextView[@text=\"Personalizar\n" +
                "Favoritos\"]", 20);
        Assert.assertTrue(topMaisRecompensas.getLocation().getX() < personalizarFavoritos.getLocation().getX());
    }

    @E("assino meu nome")
    public void assinoMeuNome() {
        tela.buscarElementoNaTela("//android.widget.TextView[@text=\"Receber em casa (R$ 28,50)\"]", 120);

    }
}
