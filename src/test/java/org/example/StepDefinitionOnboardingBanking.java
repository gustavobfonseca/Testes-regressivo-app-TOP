package org.example;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.example.PageObjects.Tela;
import org.junit.Assert;

public class StepDefinitionOnboardingBanking {

    AppiumDriver driver = AppiumDriverConfig.Instance().driver;
    Tela tela = new Tela(driver);

    @Quando("navego ate conta digital")
    public void navegoAteContaDigital() {

        MobileElement contaDigital = tela.buscarElementoNaTela("//android.widget.TextView[@text=\"Conta\n" +
                "Digital\"]", 10);
        tela.clicarEmElemento(contaDigital);
    }

    @E("clico em Quero Analisar Meu perfil")
    public void clicoEmQueroAnalisarMeuPerfil() {
        tela.scrollAteElemento("//android.widget.TextView[@text=\"Tenha muito mais benefícios com a Conta\n" +
                "Digital TOP e Cartão TOP Mastercard*\"]", 10, "new UiSelector().text(\"QUERO ANALISAR MEU PERFIL\")");

        MobileElement analisarPerfil = tela.buscarElementoNaTela("//android.widget.TextView[@content-desc=\"QUERO ANALISAR MEU PERFIL\"]", 10);
        tela.clicarEmElemento(analisarPerfil);
    }

    @E("preencho o sexo e informações de endereço")
    public void preenchoOSexoEInformaçõesDeEndereço() {
        MobileElement campoSexo = tela.buscarElementoNaTela("//android.widget.EditText[@content-desc=\"Campo de digitação de gênero de usuário\"]", 10);
        tela.clicarEmElemento(campoSexo);
        MobileElement masculino = tela.buscarElementoNaTela("//android.widget.TextView[@text=\"Masculino\"]", 10);
        tela.clicarEmElemento(masculino);
        MobileElement inputCep = tela.buscarElementoNaTela("//android.widget.EditText[@content-desc=\"Campo de digitação de CEP\"]", 10);

        tela.inputNoElemento(inputCep, "04240000");
        MobileElement botaoEnderecoCorreto = tela.buscarElementoNaTela("//android.view.ViewGroup[@content-desc=\"Endereço encontrado está correto\"]", 10);
        tela.clicarEmElemento(botaoEnderecoCorreto);
        MobileElement inputNumero = tela.buscarElementoNaTela("//android.widget.EditText[@content-desc=\"Campo de digitação de número\"]", 10);
        tela.inputNoElemento(inputNumero, "870");
        MobileElement botaoConfirmar = tela.buscarElementoNaTela("//android.widget.TextView[@content-desc=\"CONFIRMAR\"]", 10);
        tela.clicarEmElemento(botaoConfirmar);
    }

    @E("permito o usoda camera pelo app")
    public void permitoOUsodaCameraPeloApp() {
        MobileElement duranteOUsoApp = tela.buscarElementoNaTela("//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_allow_foreground_only_button\"]", 10);
        tela.clicarEmElemento(duranteOUsoApp);
    }

    @E("clico em abrir a camera")
    public void clicoEmAbrirACamera() {
        MobileElement abrirACamera = tela.buscarElementoNaTela("//android.widget.TextView[@content-desc=\"ABRIR A CÂMERA\"]", 10);
        tela.clicarEmElemento(abrirACamera);
    }

    @E("envio uma selfie")
    public void envioUmaSelfie() {
        tela.buscarElementoNaTela("//android.widget.TextView[@text=\"RG\"]", 240);
    }

    @E("seleciono RG")
    public void selecionoRG() {
        MobileElement rg = tela.buscarElementoNaTela("//android.widget.TextView[@text=\"RG\"]", 10);
        tela.clicarEmElemento(rg);

        MobileElement proximaEtapa = tela.buscarElementoNaTela("//android.widget.TextView[@content-desc=\"PRÓXIMA ETAPA\"]", 10);
        tela.clicarEmElemento(proximaEtapa);
    }

    @E("envio uma foto do RG")
    public void envioUmaFotoDoRG() {
        tela.buscarElementoNaTela("//android.widget.TextView[@text=\"Informações do seu RG\"]", 240);
    }

    @E("confirmo as informações do RG")
    public void confirmoAsInformaçõesDoRG() {
        MobileElement inputNumeroRg = tela.buscarElementoNaTela("//android.widget.EditText[@content-desc=\"Campo para digitação do número de RG\"]", 10);
        tela.inputNoElemento(inputNumeroRg, "383968574");

        MobileElement dtEmissao = tela.buscarElementoNaTela("//android.widget.EditText[@content-desc=\"Campo para digitação da data de emissão\"]", 10);
        tela.inputNoElemento(dtEmissao, "25052014");

        MobileElement orgaoEmissor = tela.buscarElementoNaTela("//android.widget.EditText[@content-desc=\"Campo de digitação de Orgão Emissor\"]", 10);
        tela.inputNoElemento(orgaoEmissor, "SSP");

        MobileElement uf = tela.buscarElementoNaTela("//android.widget.EditText[@content-desc=\"Campo de seleção para estado\"]", 10);
        tela.clicarEmElemento(uf);
        MobileElement inputBuscaEstado = tela.buscarElementoNaTela("//android.widget.EditText[@content-desc=\"Buscar opção\"]", 10);
        tela.inputNoElemento(inputBuscaEstado, "São Paulo");

        MobileElement saoPaulo = tela.buscarElementoNaTela("//android.widget.TextView[@text=\"São Paulo\"]", 10);
        tela.clicarEmElemento(saoPaulo);

        MobileElement nacionalidade = tela.buscarElementoNaTela("//android.widget.EditText[@content-desc=\"Campo de seleção de nacionalidade\"]", 10);
        tela.clicarEmElemento(nacionalidade);

        MobileElement brasileira = tela.buscarElementoNaTela("//android.widget.TextView[@text=\"BRASILEIRA\"]", 10);
        tela.clicarEmElemento(brasileira);

        MobileElement cidade = tela.buscarElementoNaTela("//android.widget.EditText[@content-desc=\"Campo de digitação de Cidade\"]", 10);
        tela.inputNoElemento(cidade, "São Paulo");

        MobileElement botaoProxEtapa = tela.buscarElementoNaTela("//android.widget.TextView[@content-desc=\"PRÓXIMA ETAPA\"]", 10);
        tela.clicarEmElemento(botaoProxEtapa);

    }

    @E("confirmo as informacoes adicionais")
    public void confirmoAsInformacoesAdicionais() {

//        Clica no campo estado civil
        tela.clicarEmElemento("//android.widget.EditText[@content-desc=\"Campo de digitação de estado civil\"]", 10);

//        Clica em solteiro
        tela.clicarEmElemento("//android.widget.TextView[@text=\"Solteiro\"]", 10);

//        Clica no campo de valor patrimonial
        tela.clicarEmElemento("//android.widget.EditText[@content-desc=\"Campo de seleção de Patrimônio atual\"]", 10);

//        Clica em até 50.000,00
        tela.clicarEmElemento("//android.widget.TextView[@text=\"ATÉ R$ 50.000,00\"]", 10);

//        inputa renda mensal de 5.000,00
        tela.inputNoElemento("//android.widget.EditText[@content-desc=\"Campo de digitação de renda mensal\"]", "500000");

//        Clica no campo profissao
        tela.clicarEmElemento("//android.widget.EditText[@content-desc=\"Campo de seleçaõ de profissão\"]", 10);

//        Clica em autonomo
        tela.clicarEmElemento("//android.widget.TextView[@text=\"AUTONOMO\"]", 10);

//        Clica no botao proxima etapa
        tela.clicarEmElemento("//android.widget.TextView[@content-desc=\"PRÓXIMA ETAPA\"]", 10);
    }

    @E("confirmo a oferta de Conta Digital e Cartao de Debito")
    public void confirmoAOfertaDeContaDigitalECartaoDeDebito() {

        tela.clicarEmElemento("//android.widget.TextView[@text=\"Conta Digital e Cartão de Débito\"]", 20);

        tela.clicarEmElemento("//android.widget.TextView[@content-desc=\"VAMOS LÁ!\"]", 10);
    }


    @E("aceito os termos e condicoes da conta digital top")
    public void aceitoOsTermosECondicoesDaContaDigitalTop() {
        tela.clicarEmElemento("//android.widget.TextView[@text=\"LI E ACEITO OS TERMOS E CONDIÇÕES DA CONTA DIGITAL TOP\"]", 10);

        tela.clicarEmElemento("//android.widget.TextView[@content-desc=\"CONTINUAR\"]", 10);
    }

    @E("aceito as politicas de privacidade")
    public void aceitoAsPoliticasDePrivacidade() {
        tela.clicarEmElemento("//android.widget.TextView[@text=\"LI E ACEITO AS POLÍTICAS DE PRIVACIDADE\"]", 10);

        tela.clicarEmElemento("//android.widget.TextView[@content-desc=\"CONTINUAR\"]", 10);
    }

    @E("confirmo recebimento em casa")
    public void confirmoRecebimentoEmCasa() {
        tela.clicarEmElemento("//android.widget.TextView[@text=\"Receber em casa (R$ 28,50)\"]", 10);
         tela.clicarEmElemento("//android.widget.TextView[@content-desc=\"CONTINUAR\"]", 10);
         tela.clicarEmElemento("//android.view.ViewGroup[@content-desc=\"Confirmar\"]", 10);
    }

    @Entao("visualizo a tela de solicitacao enviada para conta digital")
    public void visualizoATelaDeSolicitacaoEnviadaParaContaDigital() {
        tela.buscarElementoNaTela("//android.widget.TextView[@text=\"Muito obrigado por escolher o TOP!\"]", 20);
    }

    @Quando("navego ate cartao de credito")
    public void navegoAteCartaoDeCredito() {
        tela.clicarEmElemento("//android.widget.TextView[@text=\"Cartão de\n" +
                "Crédito\"]", 10);
    }

    @E("confirmo a oferta de Conta Digital e Cartao de Credito")
    public void confirmoAOfertaDeContaDigitalECartaoDeCredito() {

        tela.clicarEmElemento("//android.widget.TextView[@text=\"Conta Digital e Cartão de Crédito\"]", 20);

        tela.clicarEmElemento("//android.widget.TextView[@content-desc=\"VAMOS LÁ!\"]", 10);

    }

    @E("informo a data de vencimento do cartao")
    public void informoADataDeVencimentoDoCartao() {
        tela.clicarEmElemento("//android.widget.TextView[@text=\"DIA 1\"]", 10);
        tela.clicarEmElemento("//android.widget.TextView[@content-desc=\"CONTINUAR\"]", 10);
    }

    @E("aceito os termos e condicoes da conta digital top e os termos de contrato do cartao")
    public void aceitoOsTermosECondicoesDaContaDigitalTopEOsTermosDeContratoDoCartao() {
        tela.clicarEmElemento("//android.widget.TextView[@content-desc=\"CONTINUAR\"]", 10);
        tela.clicarEmElemento("//android.widget.TextView[@text=\"LI E ACEITO OS TERMOS DE CONTRATO DO CARTÃO\"]",10);
        tela.clicarEmElemento("//android.widget.TextView[@content-desc=\"CONTINUAR\"]", 10);
    }

    @E("visualizo a opcao Manter apenas funcao Transporte")
    public void visualizoAOpcaoManterApenasFuncaoTransporte() {
        tela.buscarElementoNaTela("//android.widget.TextView[@text=\"Manter apenas função Transporte\"]", 60);
    }

    @Então("visualizo a tela de inibição de upgrade")
    public void visualizoATelaDeInibiçãoDeUpgrade() {
        MobileElement textoInibicao = tela.buscarElementoNaTela("//android.widget.TextView[@text=\"Desculpe!\n" +
                "Você ainda não pode\n" +
                "solicitar esse produto.\"]", 20);

        Assert.assertTrue(textoInibicao.isDisplayed());
    }

    @Entao("visualizo o modal de Como Validar Sua Recarga?")
    public void visualizoOModalDeComoValidarSuaRecarga() {
        MobileElement textoModalValidar = tela.buscarElementoNaTela("//android.widget.TextView[@text=\"Como validar a recarga?\"]", 10);
        Assert.assertTrue(textoModalValidar.isDisplayed());
    }
}
