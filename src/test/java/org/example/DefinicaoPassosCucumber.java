package org.example;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.example.PageObjects.Login;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Driver;

import static org.junit.Assert.assertTrue;

public class DefinicaoPassosCucumber {
    AppiumDriver driver = AppiumDriverConfig.Instance().driver;
    Login telaLogin = new Login(driver);

    @Dado("que estou na tela de login")
    public void buscarElementosTelaLogin() throws InterruptedException {
        telaLogin.buscarElementos();
    }

    @Quando("Quando insiro o cpf bloqueado {string}")
    public void inserirCpfBloqueado(String cpf) {
        telaLogin.preencherFormularioUsuario(cpf);
    }

        @E("preencho com qualquer senha dentro dos criterios de aceite {string}")
        public void inserirSenha(String senha){
            telaLogin.preencherFormularioSenha(senha);
    }


    @E("clico no botao de entrar")
    public void clicarBotaoEntrar(){
        telaLogin.logar();
    }

    @Entao("visualizo o modal com a mensagem de conta bloqueada")
    public void visualizarModalComMensagemDeContaBloqueada(){
        telaLogin.buscarMensagemContaBloqueada();
        assertTrue(telaLogin.getTextoModalContaBloqueada().isDisplayed());
        assertTrue( true );
    }
}
