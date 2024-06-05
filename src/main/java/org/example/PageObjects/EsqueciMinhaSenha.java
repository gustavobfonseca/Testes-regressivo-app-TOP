package org.example.PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EsqueciMinhaSenha {
    private AppiumDriver driver;

    private MobileElement textoModalContaBloqueada;
    private MobileElement inputCPFUsuario;
    private MobileElement botaoConfirmar;
    private MobileElement msgCPFInvalido;
    private MobileElement botaoCancelar;
    private MobileElement input0;
    private MobileElement input1;


    public EsqueciMinhaSenha(AppiumDriver driver) {
        this.driver = driver;
    }


    public void buscarElementos() throws InterruptedException {
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@content-desc=\"Digite o seu cpf para recuperar a senha\"]")));

        inputCPFUsuario = (MobileElement) driver.findElementByXPath("//android.widget.EditText[@content-desc=\"Digite o seu cpf para recuperar a senha\"]");
        botaoConfirmar = (MobileElement) driver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"Botão para confirmar o cpf\"]/android.view.ViewGroup");
        botaoCancelar = (MobileElement) driver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"Botão para cancelar a recuperação de senha\"]");
    }

    public void preencherInputCpf(String cpf) {
        inputCPFUsuario.sendKeys(cpf);
    }

    public void clicarBotaoConfirmar(){
        botaoConfirmar.click();
    }

    public void clicarBotaoCancelar(){
        botaoCancelar.click();
    }

    public void  buscarMensagemContaBloqueada(){
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@text, 'sua conta foi bloqueada temporariamente.')]")));

        textoModalContaBloqueada = (MobileElement) driver.findElementByXPath("//*[contains(@text, 'sua conta foi bloqueada temporariamente.')]");
    }

    public void buscarMensagemCPFInvalido(){
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@content-desc=\"Erro Digite o seu cpf para recuperar a senha\"]")));

        msgCPFInvalido = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@content-desc=\"Erro Digite o seu cpf para recuperar a senha\"]");

    }

    public void buscarInput0(){
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[1]")));

        input0 = (MobileElement) driver.findElementByXPath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]");

    }

    public void clicarInput0() {
        input0.click();
    }

    public void inserirInputs(String input0){
        driver.getKeyboard().sendKeys(input0);
    }

    public MobileElement getTextoModalContaBloqueada() {
        return textoModalContaBloqueada;
    }

    public MobileElement getMsgCPFInvalido() {
        return msgCPFInvalido;
    }
}

