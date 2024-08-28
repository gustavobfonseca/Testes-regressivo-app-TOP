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
    private MobileElement mapa;
    private MobileElement bilhete;
    private MobileElement centralDeAjuda;


    public SemiLogado(AppiumDriver driver) {
        this.driver = driver;
    }

    public void buscarElementos() {
        WebDriverWait espera = new WebDriverWait(driver, 20);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text=\"Esqueci minha senha.\"]")));
        inputSenha = (MobileElement) driver.findElementByXPath("//android.widget.EditText[@content-desc=\"Espaço para digitar senha\"]");
        botaoEntrar = (MobileElement) driver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"Botão para acessar o aplicativo\"]/android.view.ViewGroup");
        linkEsqueciMinhaSenha = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text=\"Esqueci minha senha.\"]");
        mapa = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@content-desc=\"Mapa das ,\n" + ",Estações\"]");
        bilhete = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@content-desc=\"Bilhetes Offline\"]");
        centralDeAjuda = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@content-desc=\"Central de,\n" +
                ",Ajuda\"]");

        linkTrocarDeConta = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text=\"Trocar de conta\"]");
    }

    public void preencherSenha(String senha) {
        buscarElementos();
        inputSenha.sendKeys(senha);
    }

    public void preencherSenhaPadrao() {
        inputSenha.sendKeys("Devires@123");
    }

    public void clicarBotaoEntrar() {
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

    public void clicarMapaEstacao() {
        buscarElementos();
        mapa.click();
    }

    public void buscarMapa() {
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text=\"Mapa CPTM e Metrô\"]")));
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ImageView")));

    }

    public void clicarBilhetes() {
        buscarElementos();
        bilhete.click();
    }

    public void buscarBilhetes() {
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text=\"Utilizar Bilhetes\"]")));

        MeusBilhetes meusBilhetes = new MeusBilhetes(driver);

            System.out.println(meusBilhetes.getNumeroDeBilhetes());
        try{
        MobileElement txtQtdBilheteOff = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@content-desc=\"1, de ,"+meusBilhetes.getNumeroDeBilhetes()+"\"]");
        }catch (RuntimeException runtimeException){
            System.out.println("não encontramos o elemneto");
        }
    }

    public void trocarDeConta(){
        linkTrocarDeConta.click();
    }
    public void confirmarTrocaDeConta(){
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.Button[@resource-id=\"android:id/button1\"]")));

        MobileElement confirmarTroca = (MobileElement) driver.findElementByXPath("//android.widget.Button[@resource-id=\"android:id/button1\"]");
        confirmarTroca.click();
    }

    public void clicarCentralAjuda() {
        centralDeAjuda.click();
    }

    public void buscarCentralDeAjuda() {
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.webkit.WebView")));

    }
}
