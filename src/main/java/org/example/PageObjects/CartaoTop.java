package org.example.PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartaoTop {

    private AppiumDriver driver;
    private MobileElement botaoComprarCreditos;
    private MobileElement botaoComum;
    private MobileElement botaoComprarTela2;
    private MobileElement botaoCartaoDeCredito;
    private MobileElement botaoConfirmarTela3;
    private MobileElement botaoCartaoDeDebito;
    private MobileElement inputValorCredito;
    private MobileElement botaoEscolar;
    private MobileElement botaoPix;
    private MobileElement textoCopiarCodigoPix;
    private MobileElement botaoExpandirModalSaldo;
    private MobileElement botaoSaibaMaisEscolar;
    private MobileElement textoBeneficioEscolar;
    private MobileElement mensagemPixExpirado;
    private MobileElement iconeInformativoAtualizacaoSaldo;
    private MobileElement botaoComunicarPerdaCartao;
    private MobileElement botaoProsseguirComCancelamento;
    private MobileElement nomeChatbotPefisa;
    private MobileElement iconeExpancaoModalBeneficios;
    private MobileElement linkSaibaMaisMeiaTarifa;
    private MobileElement textoBeneficioEscolarPasseLivre;

    public CartaoTop(AppiumDriver driver){
        this.driver = driver;
    }

    //Tela 1 cartão top
    public void buscarBotaoComprarCreditos(){
        WebDriverWait espera = new WebDriverWait(driver, 20);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text=\"Comprar \n" +
                "Créditos\"]")));

        botaoComprarCreditos = (MobileElement) driver.findElementByXPath("//*[@text=\"Comprar \n" +
                "Créditos\"]");
    }

    public void buscarBotaoExpandirModalSaldo(){
        WebDriverWait espera = new WebDriverWait(driver, 20);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text=\"\uE8B4\"]")));

        botaoExpandirModalSaldo = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text=\"\uE8B4\"]");
    }

    public void buscarSaibaMaisEscolar(){
        WebDriverWait espera = new WebDriverWait(driver, 20);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text=\"Saiba mais\"]")));

        botaoSaibaMaisEscolar = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text=\"Saiba mais\"]");
    }

    public void buscarIconeInformativoAtualizacaoSaldo() throws InterruptedException {
//        Thread.sleep(10000);
        WebDriverWait espera = new WebDriverWait(driver, 20);
        espera.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.widget.TextView[@index='0']")));

        //android.widget.TextView[@text="Última atualização em: 27/08/2024 - 11:53"]
        driver.findElementByXPath("//android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.view.ViewGroup[2]/android.widget.TextView[@index='0']").click();
    }

    public void buscarBotaoComunicarPerdaCartao() {
//        Thread.sleep(10000);
        WebDriverWait espera = new WebDriverWait(driver, 20);
        espera.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text=\"Comunicar \n" +
                "Perda/Roubo\"]")));

        //android.widget.TextView[@text="Última atualização em: 27/08/2024 - 11:53"]
        botaoComunicarPerdaCartao = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text=\"Comunicar \n" +
                "Perda/Roubo\"]");
    }

    public void buscarIconeExpansaoModalBeneficios(){
        WebDriverWait espera = new WebDriverWait(driver, 20);
        espera.until(ExpectedConditions.elementToBeClickable(By.xpath("(//android.widget.TextView[@text=\"\uE8B4\"])[2]")));

        iconeExpancaoModalBeneficios = (MobileElement) driver.findElementByXPath("(//android.widget.TextView[@text=\"\uE8B4\"])[2]");
    }

    public void buscarLinkSaibaMaisMeiaTarifa(){
        WebDriverWait espera = new WebDriverWait(driver, 20);
        espera.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.TextView[@text=\"Saiba mais\"]")));

        linkSaibaMaisMeiaTarifa = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text=\"Saiba mais\"]");

    }

    //Tela 2 cartão TOP
    public void buscarBotaoComum(){
        WebDriverWait espera = new WebDriverWait(driver, 20);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text=\"Comum\"]")));

        botaoComum = (MobileElement) driver.findElementByXPath("//*[@text=\"Comum\"]");
    }

    public void buscarBotaoEscolar(){
        WebDriverWait espera = new WebDriverWait(driver, 20);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text=\"Escolar\"]")));

        botaoEscolar = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text=\"Escolar\"]");

    }

    public void inputarValorDeCredito(String credito){
        WebDriverWait espera = new WebDriverWait(driver, 20);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@content-desc=\"CONFIRMAR\"]")));

        inputValorCredito = (MobileElement) driver.findElementByXPath("//android.widget.EditText[@content-desc=\"Informe o valor de crédito desejado\"]");
        inputValorCredito.sendKeys(credito);
        //driver.getKeyboard().sendKeys("400");
    }

    public void inputarValorDeCreditoEscolar(){
        WebDriverWait espera = new WebDriverWait(driver, 20);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc=\"COMPRAR\"]")));

        inputValorCredito = (MobileElement) driver.findElementByXPath("//android.widget.EditText[@content-desc=\"Informe o valor de crédito desejado\"]");
        inputValorCredito.sendKeys("1000");
        //driver.getKeyboard().sendKeys("400");
    }

    public void buscarBotaoComprarTela2(){
        WebDriverWait espera = new WebDriverWait(driver, 20);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@content-desc=\"CONFIRMAR\"]")));

        botaoComprarTela2 = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@content-desc=\"CONFIRMAR\"]");

    }

    public void buscarTelaInformativoMeiaTarifa(){
        WebDriverWait espera = new WebDriverWait(driver, 20);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@content-desc=\"Benefício Escolar (,Meia Tarifa,)\"]")));

        textoBeneficioEscolar = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@content-desc=\"Benefício Escolar (,Meia Tarifa,)\"]");

    }

    public void buscarBotaoProsseguirComCancelamento(){
        WebDriverWait espera = new WebDriverWait(driver, 20);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text=\"2. Digite seu CPF;\"]")));

        botaoProsseguirComCancelamento = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))" +
                ".scrollIntoView(new UiSelector().text(\"PROSSEGUIR COM O CANCELAMENTO\"));"));

        botaoProsseguirComCancelamento = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@content-desc=\"PROSSEGUIR COM O CANCELAMENTO\"]");

    }

    public void buscarTextoBeneficioEscolarPasseLivre(){
        WebDriverWait espera = new WebDriverWait(driver, 20);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@content-desc=\"Benefício Escolar (,Passe Livre,)\"]")));

        textoBeneficioEscolarPasseLivre = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@content-desc=\"Benefício Escolar (,Passe Livre,)\"]");

    }

    //Tela 3
    public void buscarBotaoCartaoDeCredito(){
        WebDriverWait espera = new WebDriverWait(driver, 20);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@text=\"Cartão de Crédito\"]")));

        botaoCartaoDeCredito = (MobileElement) driver.findElementByXPath("//*[@text=\"Cartão de Crédito\"]");
    }

    public void buscarBotaoConfirmarTela3(){
        WebDriverWait espera = new WebDriverWait(driver, 20);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@content-desc=\"CONFIRMAR\"]")));

        botaoConfirmarTela3 = (MobileElement) driver.findElementByXPath("//*[@content-desc=\"CONFIRMAR\"]");

    }

    public void buscarBotaoCartaoDeDebito(){
        WebDriverWait espera = new WebDriverWait(driver, 20);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text=\"Cartão de Débito\"]")));

        botaoCartaoDeDebito = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text=\"Cartão de Débito\"]");
    }

    public void buscarOpcaoPix(){
        WebDriverWait espera = new WebDriverWait(driver, 20);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text=\"Pix\"]")));

        botaoPix = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text=\"Pix\"]");
    }

    public void buscarNomeContatoChatbotPefisa(){
        WebDriverWait espera = new WebDriverWait(driver, 20);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@resource-id=\"com.whatsapp:id/conversation_contact_name\"]")));

        nomeChatbotPefisa = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@resource-id=\"com.whatsapp:id/conversation_contact_name\"]");
    }

    //Tela 4

    public void buscarTelaPix(){
        WebDriverWait espera = new WebDriverWait(driver, 20);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text=\"Copie o código Pix:\"]")));

        textoCopiarCodigoPix = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text=\"Copie o código Pix:\"]");
    }

    public void buscarTelaPixExpirado(){
        WebDriverWait espera = new WebDriverWait(driver, 180);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text=\"Parece que o tempo para pagamento do código PIX foi excedido. Por favor, realize sua compra novamente.\"]")));

        mensagemPixExpirado = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text=\"Parece que o tempo para pagamento do código PIX foi excedido. Por favor, realize sua compra novamente.\"]");
    }

    //Açoes de Clique
    public void clicarBotaoComprarCreditos(){
        botaoComprarCreditos.click();
    }

    public void clicarBotaoComum(){
        botaoComum.click();
    }

    public void clicarBotaoComprarTela2(){
        botaoComprarTela2.click();
    }

    public void clicarBotaoCartaoDeCredito(){
        botaoCartaoDeCredito.click();
    }

    public void clicarBotaoConfirmarTela3(){
        botaoConfirmarTela3.click();
    }

    public void clicarBotaoCartaoDeDebito(){
        botaoCartaoDeDebito.click();
    }

    public void clicarBotaoEscolar(){
        botaoEscolar.click();
    }

    public void clicarOpcaoPix(){
        botaoPix.click();
    }

    public void clicarBotaoExpandirModalSaldo(){
        botaoExpandirModalSaldo.click();
    }

    public void clicarBotaoSaibaMais(){
        botaoSaibaMaisEscolar.click();
    }

    public MobileElement clicarIconeInformativoAtualizacaoSaldo() throws InterruptedException { final int maxTentativas = 10;
        int tentativas = 0;

        while (tentativas < maxTentativas){
            try {
                iconeInformativoAtualizacaoSaldo.click();
                return iconeInformativoAtualizacaoSaldo;
            }catch (StaleElementReferenceException e) {
                tentativas++;
                buscarIconeInformativoAtualizacaoSaldo();
                if(tentativas == maxTentativas){
                    throw e;
                }
            }
            throw new RuntimeException("Element not found after maximum retries");
        }
        return null;
    }

    public void clicarBotaoComunicarPerdaCartao(){ botaoComunicarPerdaCartao.click();}

    public void clicarBotaoProsseguirComCancelamento(){
        botaoProsseguirComCancelamento.click();
    }

    public void clicarIconeExpansaoModalBeneficios(){
        iconeExpancaoModalBeneficios.click();
    }

    public void clicarLinkSaibaMaisMeiaTarifa(){
        linkSaibaMaisMeiaTarifa.click();
    }

    public MobileElement getTextoCopiarCodigoPix() {
        return textoCopiarCodigoPix;
    }

    public MobileElement getTextoBeneficioEscolar() {
        return textoBeneficioEscolar;
    }

    public MobileElement getMensagemPixExpirado() {
        return mensagemPixExpirado;
    }

    public MobileElement getNomeChatbotPefisa() {
        return nomeChatbotPefisa;
    }

    public MobileElement getTextoBeneficioEscolarPasseLivre() {
        return textoBeneficioEscolarPasseLivre;
    }
}
