package org.example.PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SemiLogado {
    private AppiumDriver driver;
    private MobileElement inputSenha;
    private MobileElement botaoEntrar;
    private MobileElement linkTrocarDeConta;
    private MobileElement linkEsqueciMinhaSenha;
    private MobileElement iconeVisuSenha;

    public SemiLogado(AppiumDriver driver) {
        this.driver = driver;
    }

    public void buscarElementos(){
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text=\"Esqueci minha senha.\"]")));
        inputSenha = (MobileElement) driver.findElementByXPath("//android.widget.EditText[@content-desc=\"Espaço para digitar senha\"]");
        botaoEntrar = (MobileElement) driver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"Botão para acessar o aplicativo\"]/android.view.ViewGroup");
        linkEsqueciMinhaSenha = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text=\"Esqueci minha senha.\"]");
//        linkTrocarDeConta = (MobileElement) driver.findElementByXPath("");
    }

    public void preencherSenha(String senha){
        buscarElementos();
        inputSenha.sendKeys(senha);
    }

    public void preencherSenhaPadrao(){
        inputSenha.sendKeys("Devires@123");
    }
    public void clicarBotaoEntrar(){
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.ViewGroup[@content-desc=\"Botão para acessar o aplicativo\"]/android.view.ViewGroup")));
        espera.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.view.ViewGroup[@content-desc=\"Botão para acessar o aplicativo\"]/android.view.ViewGroup")));

        botaoEntrar = (MobileElement) driver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"Botão para acessar o aplicativo\"]/android.view.ViewGroup");
        System.out.println("tentando clicar");
        botaoEntrar.click();
    }


    public void buscarMensagemSenhaObrigatoria() throws InterruptedException {
        WebDriverWait espera = new WebDriverWait(driver, 10);
        Thread.sleep(3000);
        espera.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("android.widget.TextView[@resource-id=\"error_password_login_input\"]")));
    }

    public MobileElement getLinkEsqueciMinhaSenha() {
        return linkEsqueciMinhaSenha;
    }
}
