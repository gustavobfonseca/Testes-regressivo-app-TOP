package org.example.PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EsqueciMinhaSenha {
    private AppiumDriver driver;

    private MobileElement textoModalContaBloqueada;
    private MobileElement inputUsuario;
    private MobileElement botaoConfirmar;



    public EsqueciMinhaSenha(AppiumDriver driver) {
        this.driver = driver;
    }


    public void buscarElementos() throws InterruptedException {
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("XPATH INPUT USUÁRIO")));

        inputUsuario = (MobileElement) driver.findElementByXPath("");
        botaoConfirmar = (MobileElement) driver.findElementByXPath("");
    }

    public void preencherInputCpf(String cpf) {
        inputUsuario.sendKeys(cpf);
    }

    public void clicarBotaoConfirmar(){
        botaoConfirmar.click();
    }

    public void  buscarMensagemContaBloqueada(){
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]")));

        textoModalContaBloqueada = (MobileElement) driver.findElementByXPath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]");
    }






    public MobileElement getTextoModalContaBloqueada() {
        return textoModalContaBloqueada;
    }
}
