package org.example;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import junit.framework.TestCase;
import org.example.PageObjects.Home;
import org.example.PageObjects.Login;
import org.junit.jupiter.api.Test;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;

/**
 * Unit test for simple App.
 */
public class FeatureCadastro
        extends TestCase
{
    @Test
    public void login_com_preenchimento_correto() throws InterruptedException {
        AppiumDriver driver = AppiumDriverConfig.Instance().driver;

        Login telaLogin = new Login(driver);

        telaLogin.buscarElementos();
        telaLogin.preencherFormulario("327.721.478-86", "Devires@123");
        telaLogin.logar();

        Home telaHome = new Home(driver);

        telaHome.esperarBotaoBiometria();
        telaHome.clicarBotaoAtivarBiometria();

        telaHome.arrastarModalParaBaixo();

        Assert.assertEquals("Olá, Carlitos!", telaHome.getNomeUsuario().getText());




        assertTrue( true );

    }
}
