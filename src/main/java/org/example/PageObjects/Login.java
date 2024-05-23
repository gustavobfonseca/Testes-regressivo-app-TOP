package org.example.PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login {
    private AppiumDriver driver;
    private MobileElement campoUsuario;
    private MobileElement campoSenha;
    private MobileElement botaoLogin;

    public Login(AppiumDriver driver){
        this.driver = driver;
    }

    public void buscarElementos() throws InterruptedException {
        Thread.sleep(15000);
        campoUsuario = (MobileElement) driver.findElementByXPath("//android.widget.EditText[@content-desc=\"Espaço para digitar o cpf \"]");
        campoSenha = (MobileElement) driver.findElementByXPath("//android.widget.EditText[@content-desc=\"Espaço para digitar senha\"]");
        botaoLogin = (MobileElement) driver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"Botão para acessar o aplicativo\"]/android.view.ViewGroup");
    }

    public void preencherFormulario(String usuario, String senha){
        campoUsuario.sendKeys(usuario);
        campoSenha.sendKeys(senha);
    }

    public void logar(){
        botaoLogin.click();
    }

}
