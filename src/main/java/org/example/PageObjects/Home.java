package org.example.PageObjects;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Home {
    private AppiumDriver driver;
    private MobileElement msgBoaViagem;
    private MobileElement botaoBiometria;
    private MobileElement botaoSair;
    private MobileElement botaoConfirmarSair;
    private MobileElement botaoNaoAtivarBiometria;
    private MobileElement botaoBilhetes;
    private MobileElement botaoModalQueroConhecer;
    private PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
    private MobileElement modal;
    private MobileElement fotoDePerfil;
    private MobileElement textoDadosPessoais;
    private MobileElement textoMockTokenGemalto;
    private MobileElement botaoTogleMockTokenGemalto;
    private MobileElement botaoCartaoTop;
    private MobileElement iconePerfil;
    private MobileElement menuBiometria;
    private MobileElement campoSenhaDoAplicativo;
    private MobileElement senhaAtualRedefinir;
    private MobileElement botaoEditarSenha;
    private MobileElement senhaNovaRedefinir;
    private MobileElement confirmarSenhaNovaRedefinir;
    private MobileElement botaoEnviarRedefinirSenha;
    private MobileElement fotoDePerfilAdicionada;


    public Home(AppiumDriver driver) {
        this.driver = driver;
    }

    public void perfilPelaApresentacao() {
        MobileElement apresentacao = (MobileElement) driver.findElementByXPath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]");
        apresentacao.click();
    }

    public void buscarFotoDePerfilAdicionada() {
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.widget.ImageView")));
    }

    public void buscarFotoDePerfil() {
        WebDriverWait espera = new WebDriverWait(driver, 40);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]")));

        fotoDePerfil = (MobileElement) driver.findElementByXPath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]");
    }

    public void esperarBotaoBiometria() throws InterruptedException {
        int tentativa = 0;
        int tentativaMax = 10;
        Tela tela = new Tela(this.driver);
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.ViewGroup[@content-desc=\"Botão para ativar biometria.\"]/android.view.ViewGroup")));
        while(tentativa < tentativaMax){
            try{
                botaoBiometria = (MobileElement) driver.findElementByXPath("//android.view.ViewGroup[@resource-id=\"Botão para ativar biometria.\"]/android.view.ViewGroup");
                botaoBiometria.click();
                Thread.sleep(6000);
                List elementos = driver.findElementsByXPath("//android.widget.TextView[@text=\"Ativar biometria\"]");
                if(elementos.isEmpty()){
                    break;
                }
                driver.findElementByXPath("//android.widget.EditText[@content-desc=\"Digite a senha atual\"]");
            }catch (Exception e){
                tentativa++;
                if(tentativa==tentativaMax){
                    throw e;
                }
            }
        }

//        Thread.sleep(5000);
//        botaoNaoAtivarBiometria = (MobileElement) driver.findElementByXPath("//android.view.ViewGroup[@resource-id=\"Botão para não ativar biometria.\"]/android.view.ViewGroup");

    }

    public void redefinirSenhaPeloPerfil() throws InterruptedException {
        clicarIconePerfil();
        clicarPerfilSenhaDoAplicativo();
        redefinirSenha("Teste1234", "Teste123", "Teste123");

    }

    public void redefinirSenha(String senhaAtual, String novaSenha, String confirmaSenha) throws InterruptedException {
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@content-desc=\"Digite a senha atual\"]")));
        senhaAtualRedefinir = (MobileElement) driver.findElementByXPath("//android.widget.EditText[@content-desc=\"Digite a senha atual\"]");
        senhaAtualRedefinir.sendKeys(senhaAtual);
        botaoEditarSenha = (MobileElement) driver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"Botão EDITAR\"]/android.view.ViewGroup");
        botaoEditarSenha.click();
        Thread.sleep(1000);
        senhaNovaRedefinir = (MobileElement) driver.findElementByXPath("//android.widget.EditText[@content-desc=\"Digite a nova senha\"]");
        confirmarSenhaNovaRedefinir = (MobileElement) driver.findElementByXPath("//android.widget.EditText[@content-desc=\"Digite a nova senha novamente\"]");
        senhaNovaRedefinir.sendKeys(novaSenha);
        confirmarSenhaNovaRedefinir.sendKeys(confirmaSenha);
        Thread.sleep(1000);
        botaoEnviarRedefinirSenha = (MobileElement) driver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"Botão ENVIAR\"]/android.view.ViewGroup");
        botaoEnviarRedefinirSenha.click();

        WebDriverWait espera2 = new WebDriverWait(driver, 60);
        espera2.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.ViewGroup[@content-desc=\"Clique para editar a senha\"]/android.view.ViewGroup")));


    }


//    public void clicarBotaoAtivarBiometria() throws InterruptedException {
//        botaoBiometria.click();
//    }

    public void clicarBotaoNaoAtivarBiometria() {
        botaoNaoAtivarBiometria.click();
    }

    public void clicarFotoDePerfil() {
        fotoDePerfil.click();
    }

    public void buscarModal() {
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]")));

        modal = (MobileElement) driver.findElementByXPath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]");


    }

    public void buscarMensagemBemVindo() {
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text=\"Tenha uma boa viagem.\"]")));
        msgBoaViagem = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text=\"Tenha uma boa viagem.\"]");
    }


    public void arrastarModalParaBaixo() throws InterruptedException {
        Thread.sleep(10000);
        buscarModal();
        driver.executeScript("gesture: swipe", ImmutableMap.of("elementId", modal.getId(), "percentage", 100, "direction", "down"));
        Thread.sleep(500);
        buscarMensagemBemVindo();
    }

    public void scrolAteOpcaoMock() {
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text=\"DADOS PESSOAIS\"]")));

        textoMockTokenGemalto = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))" + ".scrollIntoView(new UiSelector().text(\"Mock gemalto token\"));"));

        botaoTogleMockTokenGemalto = (MobileElement) driver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"Mock gemalto token\"]/android.view.ViewGroup");

    }

    public void clicarBotaoMockTokenGemalto() {
        botaoTogleMockTokenGemalto.click();
    }

    public AppiumDriver getDriver() {
        return driver;
    }

    public void buscarBotaoBilhetes() {
        WebDriverWait espera = new WebDriverWait(driver, 20);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text=\"Bilhetes\n" + "QR Code\"]")));

        botaoBilhetes = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text=\"Bilhetes\n" + "QR Code\"]");
    }

    public void buscarBotaoCartaoTop() {
        WebDriverWait espera = new WebDriverWait(driver, 50);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text=\"Cartão\n" + "TOP\"]")));

        botaoCartaoTop = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text=\"Cartão\n" + "TOP\"]");
    }

    public void clicarBotaoCartaoTop() {
        botaoCartaoTop.click();
    }

    public void clicarBotaoBilhetes() {
        botaoBilhetes.click();
    }

    public void clicarIconePerfil() {
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[1]")));
        iconePerfil = (MobileElement) driver.findElementByXPath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[1]");
        iconePerfil.click();

        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text=\"DADOS PESSOAIS\"]")));
    }

    public void clicarPerfilSenhaDoAplicativo() {
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text=\"DADOS PESSOAIS\"]")));

        campoSenhaDoAplicativo = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))" + ".scrollIntoView(new UiSelector().text(\"Senha do aplicativo\"));"));

        campoSenhaDoAplicativo = (MobileElement) driver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"Clique para editar a senha\"]/android.view.ViewGroup");
        campoSenhaDoAplicativo.click();
    }

    public void clicarBotaoModalQueroConhecer() {
        WebDriverWait espera = new WebDriverWait(driver, 15);
        By botaoModalQueroConhecerLocator = By.xpath("//android.view.ViewGroup[@content-desc=\"Botão de navegação tela de vantagens.\"]/android.view.ViewGroup");

        try {
            espera.until(ExpectedConditions.presenceOfElementLocated(botaoModalQueroConhecerLocator));
            MobileElement botaoModalQueroConhecer = (MobileElement) driver.findElement(botaoModalQueroConhecerLocator);
            botaoModalQueroConhecer.click();
            Thread.sleep(2000);
            driver.navigate().back();
            buscarMensagemBemVindo();
        } catch (TimeoutException e) {
            buscarMensagemBemVindo();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    public MobileElement getMsgBoaViagem() {
        return msgBoaViagem;
    }

    public PointerInput getFinger() {
        return finger;
    }

    public MobileElement getModal() {
        return modal;
    }

    public void clicarSair() {
        WebDriverWait espera = new WebDriverWait(driver, 10);

        botaoSair = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))" + ".scrollIntoView(new UiSelector().text(\"Sair do Aplicativo\"));"));

        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text=\"Sair do Aplicativo\"]")));
        botaoSair = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text=\"Sair do Aplicativo\"]");
        botaoSair.click();

        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.Button[@resource-id=\"android:id/button1\"]")));
        botaoConfirmarSair = (MobileElement) driver.findElementByXPath("//android.widget.Button[@resource-id=\"android:id/button1\"]");
        botaoConfirmarSair.click();
    }

    public void deslogar() {
//        clicarIconePerfil();
        clicarSair();
    }

    public void desativarBiometria() throws InterruptedException {
        clicarIconePerfil();
        clicarMenuBiometria();
        clicarSair();
    }

    public void clicarMenuBiometria() throws InterruptedException {
        WebDriverWait espera = new WebDriverWait(driver, 10);
        menuBiometria = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))" + ".scrollIntoView(new UiSelector().resourceId(\"Autenticação biométrica\"));"));

        menuBiometria = (MobileElement) driver.findElement(By.xpath("//android.widget.TextView[@text=\"Autenticação biométrica\"]"));
        Thread.sleep(3000);
        menuBiometria.click();
        Thread.sleep(3000);
    }

    public void buscarMapa() {
        MobileElement mapaMobilidade = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).className(\"android.widget.HorizontalScrollView\"))" + ".setAsHorizontalList()" + ".scrollIntoView(new UiSelector().text(\"Mapa das\n" + "Estações\"))"));

        if (mapaMobilidade != null) {
            mapaMobilidade.click();
        } else {
            System.out.println("Elemento 'mapa' não encontrado.");
        }
    }

    public void buscarMobilidade() {
        try {
            MobileElement viewGroup = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).className(\"android.widget.HorizontalScrollView\"))" + ".setAsHorizontalList()" + ".scrollIntoView(new UiSelector().text(\"Mobilidade\"))"));

            MobileElement mapaMobilidade = (MobileElement) driver.findElementByXPath("//android.widget.ScrollView/android.view.ViewGroup/android.widget.HorizontalScrollView[2]/android.view.ViewGroup/android.view.ViewGroup[3]/android.view.ViewGroup/android.view.ViewGroup");

//            if (mapaMobilidade != null) {
//                mapaMobilidade.click();
//            } else {
//                System.out.println("Elemento 'Mobilidade' não encontrado.");
//            }
        } catch (NoSuchElementException e) {
            System.out.println("Elemento 'Mobilidade' não encontrado: " + e.getMessage());
        }
    }

    public void buscarDisponivelEmBreve() {
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text=\"Disponível em breve\"]")));
    }

    public void buscarApelidoNomeSocialModificado() {
        String nomeAtualizado = PerfilDoUsuario.getNomeAtualizado();
        WebDriverWait espera = new WebDriverWait(driver, 10);
        MobileElement apelidoNomeSocial = (MobileElement) espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text=\"Olá, " + nomeAtualizado + "!\"]")));


    }
}
