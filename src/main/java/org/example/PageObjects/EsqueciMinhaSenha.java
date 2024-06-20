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
    private MobileElement inputSuaSenha;
    private MobileElement inputConfirmarSenha;
    private MobileElement botaoConfirmar;
    private MobileElement botaoConfirmarSms;
    private MobileElement botaoConfirmarEmail;
    private MobileElement botaoConfirmarRedefinirSenha;
    private MobileElement msgCPFInvalido;
    private MobileElement botaoCancelar;
    private MobileElement input0;


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

    public void preencherInputSuaSenha(String senhaNova) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@content-desc=\"Campo para digitar nova senha\"]\n")));

        inputSuaSenha = (MobileElement) driver.findElementByXPath("//android.widget.EditText[@content-desc=\"Campo para digitar nova senha\"]\n");

        inputSuaSenha.sendKeys(senhaNova);
    }

    public void preencherInputConfirmarSenha(String confirmarSenha) {
        inputConfirmarSenha = (MobileElement) driver.findElementByXPath("//android.widget.EditText[@content-desc=\"Campo para digitar confirmação de senha\"]\n");

        inputConfirmarSenha.sendKeys(confirmarSenha);
    }

    public void clicarBotaoConfirmar() {
        botaoConfirmar.click();
    }

    public void clicarBotaoConfirmarSms() {
        driver.navigate().back();
        botaoConfirmarSms = (MobileElement) driver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"Botão Confirmar código do Sms\"]/android.view.ViewGroup\n");
        botaoConfirmarSms.click();

    }

    public void clicarBotaoConfirmarEmail() {
        botaoConfirmarEmail = (MobileElement) driver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"Botão Confirmar código do Email\"]/android.view.ViewGroup\n");
        botaoConfirmarEmail.click();
    }

    public void clicarBotaoConfirmarRedefinirSenha() {
        botaoConfirmarRedefinirSenha = (MobileElement) driver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"Botão para confirmar a nova senha\"]/android.view.ViewGroup\n");
        botaoConfirmarRedefinirSenha.click();
    }

    public void clicarBotaoCancelar() {
        botaoCancelar.click();
    }

    public void buscarMensagemContaBloqueada() {
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@text, 'sua conta foi bloqueada temporariamente.')]")));

        textoModalContaBloqueada = (MobileElement) driver.findElementByXPath("//*[contains(@text, 'sua conta foi bloqueada temporariamente.')]");
    }

    public void buscarMensagemCPFInvalido() {
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@content-desc=\"Erro Digite o seu cpf para recuperar a senha\"]")));

        msgCPFInvalido = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@content-desc=\"Erro Digite o seu cpf para recuperar a senha\"]");

    }

    public void buscarInput0Sms() {
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[1]")));

        input0 = (MobileElement) driver.findElementByXPath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]");

    }
    public void buscarInput0Email() {
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[1]")));

        input0 = (MobileElement) driver.findElementByXPath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.view.ViewGroup[1]\n");

    }

    public void clicarInput0() {
        input0.click();
    }

    public void inserirInputs(String input0) {
        driver.getKeyboard().sendKeys(input0);
    }

    public MobileElement getTextoModalContaBloqueada() {
        return textoModalContaBloqueada;
    }

    public MobileElement getMsgCPFInvalido() {
        return msgCPFInvalido;
    }
}

