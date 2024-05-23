package org.example.PageObjects;

import com.google.common.collect.ImmutableMap;
import com.sun.scenario.effect.impl.sw.java.JSWBlend_SRC_INPeer;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.util.Assert;

public class Home {
    private AppiumDriver driver;
    private MobileElement nomeUsuario;
    private MobileElement botaoBiometria;
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
       modal = (MobileElement) driver.findElementByXPath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]");

    }

    public void buscarMensagemBemVindo(){
        nomeUsuario = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text=\"Olá, Carlitos!\"]");
    }


    public void arrastarModalParaBaixo() throws InterruptedException {
        Thread.sleep(4000);
        buscarModal();
        driver.executeScript("gesture: swipe", ImmutableMap.of("elementId", modal.getId(),
                "percentage", 50,
                "direction", "down"));
        Thread.sleep(500);
        buscarMensagemBemVindo();
    }

    public AppiumDriver getDriver() {
        return driver;
    }

    public MobileElement getNomeUsuario() {
        return nomeUsuario;
    }

    public MobileElement getBotaoBiometria() {
        return botaoBiometria;
    }

    public PointerInput getFinger() {
        return finger;
    }

    public MobileElement getModal() {
        return modal;
    }
}
