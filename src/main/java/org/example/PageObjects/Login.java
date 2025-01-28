package org.example.PageObjects;

import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.util.Assert;

public class Login {
    private AppiumDriver driver;
    private MobileElement campoUsuario;
    private MobileElement campoSenha;
    private MobileElement botaoLogin;
    private MobileElement textoModalContaBloqueada;
    private MobileElement linkEsqueciMinhaSenha;
    private MobileElement botaoFecharModalErroCPFSenha;
    private MobileElement iconeInformativo;
    private MobileElement botaoAtendimentoViaWhatsApp;
    private MobileElement centralDeAjuda;
    private MobileElement enviarMensagem;
    private MobileElement criarConta;


    private MobileElement modalErro;

    public Login(AppiumDriver driver) {
        this.driver = driver;
    }

    public void buscarElementos() throws InterruptedException {
        WebDriverWait espera = new WebDriverWait(driver, 30);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@content-desc=\"Espaço para digitar o cpf \"]")));
        try {
            campoUsuario = (MobileElement) driver.findElementByXPath("//android.widget.EditText[@content-desc=\"Espaço para digitar o cpf \"]");
            criarConta = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text=\"Crie uma conta.\"]");
            campoSenha = (MobileElement) driver.findElementByXPath("//android.widget.EditText[@content-desc=\"Espaço para digitar senha\"]");
            botaoLogin = (MobileElement) driver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"Botão para acessar o aplicativo\"]/android.view.ViewGroup");
            linkEsqueciMinhaSenha = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text=\"Esqueci minha senha.\"]");
        } catch (Exception e) {
            criarConta = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))" +
                    ".scrollIntoView(new UiSelector().text(\"Crie uma conta.\"));"));
            buscarElementos();
        }
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

    public void clicarEsqueciMinhaSenha() {
        linkEsqueciMinhaSenha.click();
    }

    public void buscarModalContaBloqueada() {
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.ViewGroup[@resource-id=\"modal_bloqueio\"]")));
    }

    public void buscarMensagemContaBloqueada() {
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text=\"Para sua segurança o acesso ao Aplicativo foi\n" +
                "temporariamente bloqueado.\n" +
                "Te ajudamos a desbloquear através da nossa\n" +
                "Central de Atendimento.\n" +
                "\n" +
                "Ligue para (11) 3888-2200 ou chame-nos no WhatsApp.\"]")));

        textoModalContaBloqueada = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text=\"Para sua segurança o acesso ao Aplicativo foi\n" +
                "temporariamente bloqueado.\n" +
                "Te ajudamos a desbloquear através da nossa\n" +
                "Central de Atendimento.\n" +
                "\n" +
                "Ligue para (11) 3888-2200 ou chame-nos no WhatsApp.\"]");
    }

    public void arrastarModalContaBloqueadaBaixo() {
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

    public void buscarBotaoFecharModalCPFSenha() {
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.ViewGroup[@content-desc=\"Fechar\"]/android.view.ViewGroup")));

        botaoFecharModalErroCPFSenha = (MobileElement) driver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"Fechar\"]/android.view.ViewGroup");
    }

    public void clicarBotaoFecharModalCPFSenha() {
        botaoFecharModalErroCPFSenha.click();
    }

    public void clicarBotaoAtendimentoWhatsApp() throws InterruptedException {
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.elementToBeClickable(By.id("br.com.autopass.top.hml:id/botao_modal_bloqueio")));

        botaoAtendimentoViaWhatsApp = (MobileElement) driver.findElementByXPath("br.com.autopass.top.hml:id/botao_modal_bloqueio");
        botaoAtendimentoViaWhatsApp.click();
    }

    public void clicarCentralDeAjuda() {
        centralDeAjuda = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text=\"Central de Ajuda\"]");
        centralDeAjuda.click();
    }

    public void clicarCriarConta() {
        criarConta.click();
    }

    public void clicarEnviarMensagem() {
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text=\"ENVIAR MENSAGEM\"]")));

        enviarMensagem = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text=\"ENVIAR MENSAGEM\"]");
        enviarMensagem.click();
    }

    public void verificarRedirecionamentoWhatsapp() throws InterruptedException {
        WebDriverWait espera = new WebDriverWait(driver, 15);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@resource-id=\"com.whatsapp:id/conversation_contact_name\"]")));

        MobileElement elemento = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@resource-id=\"com.whatsapp:id/conversation_contact_name\"]");

        if (elemento.getText().equals("Autopass")) {
            System.out.println(elemento.getText());
        } else {
            throw new AssertionError("Nome do contato não é Autopass.");
        }

        //        String nomeApp = driver.getCapabilities().getCapability("appPackage").toString();
//        System.out.println(nomeApp);
//        Boolean whatsAberto = nomeApp.equals("com.whatsapp");
//        Assert.state(whatsAberto, "Usuário não foi redirecionado para o WhatsApp.");
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