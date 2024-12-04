package org.example;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
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
}
