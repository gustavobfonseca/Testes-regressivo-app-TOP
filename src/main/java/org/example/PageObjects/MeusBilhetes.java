package org.example.PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MeusBilhetes {
    private AppiumDriver driver;
    private MobileElement botaoComprarBilhetes;
    private MobileElement bilheteMetro;
    private MobileElement botaoUnidade;
    private MobileElement opcaoCartaoDeCredito;
    private MobileElement botaoConfirmarFormaPagamento;
    private MobileElement inputCvv;
    private MobileElement botaoConfirmarCompra;
    private MobileElement mensagemCompraRealizadaComSucesso;
    private MobileElement mensagemFalhaNoPagamento;
    private MobileElement botaoVoltarParaHome;

    public MeusBilhetes(AppiumDriver driver){
        this.driver = driver;
    }

    public void buscarElementos(){
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text=\"Comprar \n" +
                "Bilhetes\"]")));

        botaoComprarBilhetes = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text=\"Comprar \n" +
                "Bilhetes\"]");

    }

    public void buscarBotaoCPTM(){
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text=\"CPTM / METRÔ\"]")));

        bilheteMetro = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text=\"CPTM / METRÔ\"]");
    }

    public void clicarBotaoCPTM(){bilheteMetro.click();}

    public void clicarBotaoComprarBilhetes(){
        botaoComprarBilhetes.click();
    }

    public void buscarBotaoUnidades(){
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.ViewGroup[@content-desc=\"1 unidade no valor R$5\"]")));

        botaoUnidade = (MobileElement) driver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"1 unidade no valor R$5\"]");

    }

    public void clicarBotaoUnidades(){
        botaoUnidade.click();
    }

    public void buscarOpcaoCartaoDeCredito(){
        WebDriverWait espera = new WebDriverWait(driver, 30);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text=\"Cartão de Crédito\"]")));

        opcaoCartaoDeCredito = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text=\"Cartão de Crédito\"]");
        botaoConfirmarFormaPagamento = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@content-desc=\"CONFIRMAR\"]");
    }

    public void clicarOpcaoCartaoDeCredito(){
        opcaoCartaoDeCredito.click();
    }

    public void clicarBotaoConfirmarFormaPagamento(){
        botaoConfirmarFormaPagamento.click();
    }

    public void buscarElementosConfirmarCompra(){
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@content-desc=\"informar cvv\"]")));

        inputCvv = (MobileElement) driver.findElementByXPath("//android.widget.EditText[@content-desc=\"informar cvv\"]");
        botaoConfirmarCompra = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@content-desc=\"CONFIRMAR\"]");
    }

    public void inserirCvv(String cvv){
        inputCvv.sendKeys(cvv);
    }

    public void clicarBotaoConfirmarCompra(){botaoConfirmarCompra.click();}

    public void buscarMensagemCompraRealizadaComSucesso(){
        WebDriverWait espera = new WebDriverWait(driver, 20);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text=\"Sua compra foi realizada\n" +
                "com sucesso!\"]")));

        mensagemCompraRealizadaComSucesso = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text=\"Sua compra foi realizada\n" +
                "com sucesso!\"]");
    }

    public void buscarMensagemFalhaNoPagamento(){
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text=\"Falha no pagamento!\"]")));

        mensagemFalhaNoPagamento = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text=\"Falha no pagamento!\"]");
    }

    public void buscarBotaoVoltarParaHome(){
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@content-desc=\"MEUS BILHETES\"]")));

        botaoVoltarParaHome = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@content-desc=\"VOLTAR À PÁGINA INICIAL\"]");

    }

    public void clicarBotaoVoltarParaHome(){
        botaoVoltarParaHome.click();
    }

    public MobileElement getMensagemCompraRealizadaComSucesso() {
        return mensagemCompraRealizadaComSucesso;
    }

    public MobileElement getMensagemFalhaNoPagamento() {
        return mensagemFalhaNoPagamento;
    }
}
