package org.example.PageObjects;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Home {
    private AppiumDriver driver;
    private MobileElement msgBoaViagem;
    private MobileElement botaoBiometria;
    private MobileElement botaoBilhetes;
    private PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
    private MobileElement modal;
    private MobileElement fotoDePerfil;
    private MobileElement textoDadosPessoais;
    private MobileElement textoMockTokenGemalto;
    private MobileElement botaoTogleMockTokenGemalto;
    private MobileElement botaoCartaoTop;


    public Home(AppiumDriver driver){
        this.driver = driver;
    }

    public void buscarFotoDePerfil(){
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]")));

        fotoDePerfil = (MobileElement) driver.findElementByXPath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[2]");
    }

    public void esperarBotaoBiometria() {
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.ViewGroup[@content-desc=\"Botão para ativar biometria.\"]/android.view.ViewGroup")));

        botaoBiometria = (MobileElement) driver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"Botão para ativar biometria.\"]/android.view.ViewGroup");

    }

    public void clicarBotaoAtivarBiometria() {
        botaoBiometria.click();
    }

    public void clicarFotoDePerfil(){
        fotoDePerfil.click();
    }

    public void buscarModal(){
       modal = (MobileElement) driver.findElementByXPath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]");

    }

    public void buscarMensagemBemVindo(){
        msgBoaViagem = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text=\"Tenha uma boa viagem.\"]");
    }


    public void arrastarModalParaBaixo() throws InterruptedException {
        Thread.sleep(10000);
        buscarModal();
        driver.executeScript("gesture: swipe", ImmutableMap.of("elementId", modal.getId(),
                "percentage", 100,
                "direction", "down"));
        Thread.sleep(500);
        buscarMensagemBemVindo();
    }

    public void scrolAteOpcaoMock(){
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text=\"DADOS PESSOAIS\"]")));

        textoMockTokenGemalto = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))" +
                ".scrollIntoView(new UiSelector().text(\"Mock gemalto token\"));"));

        botaoTogleMockTokenGemalto = (MobileElement) driver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"Mock gemalto token\"]/android.view.ViewGroup");

    }

    public void clicarBotaoMockTokenGemalto(){
        botaoTogleMockTokenGemalto.click();
    }

    public AppiumDriver getDriver() {
        return driver;
    }

    public void buscarBotaoBilhetes(){
        WebDriverWait espera = new WebDriverWait(driver, 20);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text=\"Bilhetes\n" +
                "QR Code\"]")));

        botaoBilhetes = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text=\"Bilhetes\n" +
                "QR Code\"]");
    }

    public void buscarBotaoCartaoTop(){
        WebDriverWait espera = new WebDriverWait(driver, 20);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text=\"Cartão\n" +
                "TOP\"]")));

        botaoCartaoTop = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text=\"Cartão\n" +
                "TOP\"]");
    }

    public void clicarBotaoBilhetes(){
        botaoBilhetes.click();
    }

    public void clicarBotaoCartaoTop(){
        botaoCartaoTop.click();
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
}
