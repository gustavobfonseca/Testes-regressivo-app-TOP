package org.example.PageObjects;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login {
    private AppiumDriver driver;
    private MobileElement campoUsuario;
    private MobileElement campoSenha;
    private MobileElement botaoLogin;
    private MobileElement textoModalContaBloqueada;
    private MobileElement linkEsqueciMinhaSenha;
    private MobileElement botaoFecharModalErroCPFSenha;
    private MobileElement iconeInformativo;

    private MobileElement modalErro;

    public Login(AppiumDriver driver) {
        this.driver = driver;
    }

    public void buscarElementos() throws InterruptedException {
        WebDriverWait espera = new WebDriverWait(driver, 15);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@content-desc=\"Espaço para digitar o cpf \"]")));

        campoUsuario = (MobileElement) driver.findElementByXPath("//android.widget.EditText[@content-desc=\"Espaço para digitar o cpf \"]");
        campoSenha = (MobileElement) driver.findElementByXPath("//android.widget.EditText[@content-desc=\"Espaço para digitar senha\"]");
        botaoLogin = (MobileElement) driver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"Botão para acessar o aplicativo\"]/android.view.ViewGroup");

        linkEsqueciMinhaSenha = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text=\"Esqueci minha senha.\"]");
    }

    public void preencherFormulario(String usuario, String senha) {
        campoUsuario.sendKeys(usuario);
        campoSenha.sendKeys(senha);
    }

    public void preencherFormularioUsuario(String usuario) {
        campoUsuario.sendKeys(usuario);
    }

    public void preencherFormularioSenha(String senha) {
        campoSenha.sendKeys(senha);
    }



    public void logar() {
        botaoLogin.click();
    }

    public void buscarModalErro() {
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions
                .presenceOfElementLocated(By.xpath("//android.widget.TextView[@text=\"CPF e/ou senha inválidos.\"]")));

        modalErro = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text=\"CPF e/ou senha inválidos.\"]");

    }
    public void clicarEsqueciMinhaSenha(){
        linkEsqueciMinhaSenha.click();
    }

    public void  buscarMensagemContaBloqueada(){        
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(@text, 'sua conta foi bloqueada temporariamente.')]")));

        textoModalContaBloqueada = (MobileElement) driver.findElementByXPath("//*[contains(@text, 'sua conta foi bloqueada temporariamente.')]");
    }

    public void arrastarModalContaBloqueadaBaixo(){
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]")));

        iconeInformativo = (MobileElement) driver.findElementByXPath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]");
        buscarMensagemContaBloqueada();

        Dimension tamanhoTela = driver.manage().window().getSize();
        int alturaTela = tamanhoTela.getHeight();
        int alturaModal = alturaTela * 2 / 3;
        int larguraModal = tamanhoTela.getWidth() / 2;

        driver.executeScript("mobile: flingGesture", ImmutableMap.of("elementId", textoModalContaBloqueada.getId(),
                "percentage", 100,
                "direction", "down",
                "speed", 500));
    }

    public void buscarBotaoFecharModalCPFSenha(){
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.ViewGroup[@content-desc=\"Fechar\"]/android.view.ViewGroup")));

        botaoFecharModalErroCPFSenha = (MobileElement) driver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"Fechar\"]/android.view.ViewGroup");
    }

    public void clicarBotaoFecharModalCPFSenha(){
        botaoFecharModalErroCPFSenha.click();
    }

    public void limparCamposLogin() {
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@content-desc=\"Espaço para digitar o cpf \"]")));
        campoUsuario.clear();
        campoSenha.clear();
    }



    public MobileElement getCampoUsuario() {
        return campoUsuario;
    }

    public void setCampoUsuario(MobileElement campoUsuario) {
        this.campoUsuario = campoUsuario;
    }

    public MobileElement getCampoSenha() {
        return campoSenha;
    }

    public void setCampoSenha(MobileElement campoSenha) {
        this.campoSenha = campoSenha;
    }

    public MobileElement getBotaoLogin() {
        return botaoLogin;
    }

    public void setBotaoLogin(MobileElement botaoLogin) {
        this.botaoLogin = botaoLogin;
    }

    public MobileElement getModalErro() {
        return modalErro;
    }

    public void setModalErro(MobileElement modalErro) {
        this.modalErro = modalErro;
    }

    public MobileElement getTextoModalContaBloqueada() {
        return textoModalContaBloqueada;
}
}