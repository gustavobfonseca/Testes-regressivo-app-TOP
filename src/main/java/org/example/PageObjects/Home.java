package org.example.PageObjects;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Home {
    private AppiumDriver driver;
    private MobileElement msgBoaViagem;
    private MobileElement botaoBiometria;
    private MobileElement botaoBilhetes;
    private MobileElement botaoModalQueroConhecer;
    private PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
    private MobileElement modal;


    public Home(AppiumDriver driver){
        this.driver = driver;
    }

    public void esperarBotaoBiometria() {
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.ViewGroup[@content-desc=\"Botão para ativar biometria.\"]/android.view.ViewGroup")));

        botaoBiometria = (MobileElement) driver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"Botão para ativar biometria.\"]/android.view.ViewGroup");

    }

    public void clicarBotaoAtivarBiometria() {
        botaoBiometria.click();
    }

    public void buscarModal(){
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]")));

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

    public AppiumDriver getDriver() {
        return driver;
    }

    public void buscarBotaoBilhetes(){
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text=\"Bilhetes\n" +
                "QR Code\"]")));

        botaoBilhetes = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text=\"Bilhetes\n" +
                "QR Code\"]");
    }

    public void clicarBotaoBilhetes(){
        botaoBilhetes.click();
    }

    public void clicarBotaoModalQueroConhecer() {
        WebDriverWait espera = new WebDriverWait(driver, 10);
        By botaoModalQueroConhecerLocator = By.xpath("//android.view.ViewGroup[@content-desc=\"Botão de navegação tela de vantagens.\"]/android.view.ViewGroup");

        try {
            espera.until(ExpectedConditions.presenceOfElementLocated(botaoModalQueroConhecerLocator));
            MobileElement botaoModalQueroConhecer = (MobileElement) driver.findElement(botaoModalQueroConhecerLocator);
            botaoModalQueroConhecer.click();
            Thread.sleep(1000);
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
}
