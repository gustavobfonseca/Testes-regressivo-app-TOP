package org.example.PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;


public class Cadastro {
    private AppiumDriver driver;
    private MobileElement inputCpf;
    private MobileElement inputNome;
    private MobileElement dtNasc;
    private MobileElement genero;
    private MobileElement masculino;
    private MobileElement inputEmail;
    private MobileElement inputTelefone;
    private MobileElement botaoContinuar;
    private MobileElement nomeObrigatorio;
    private MobileElement dtObrigatorio;
    private MobileElement generoObrigatorio;
    private MobileElement emailObrigatorio;
    private MobileElement telefoneObrigatorio;
    private MobileElement botaoConfirmarCadastroSenha;
    private MobileElement botaoTermos;
    private MobileElement botaoContinuarTermos;
    private MobileElement botaoPrivacidade;
    private MobileElement botaoContinuarPrivacidade;
    private MobileElement modalCadastrado;
    private MobileElement botaoIrParaLogin;
    private MobileElement botaoIrParaLoginModalJaCadastrado;
    private MobileElement cpfInvalido;
    private MobileElement modalErroSms;
    private MobileElement botaoReverCodigo;


    public Cadastro(AppiumDriver driver) {
        this.driver = driver;
    }

    public void buscarElementos() {
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@content-desc=\"Campo com cpf digitado\"]")));

        inputCpf = (MobileElement) driver.findElementByXPath("//android.widget.EditText[@content-desc=\"Campo com cpf digitado\"]");
        inputNome = (MobileElement) driver.findElementByXPath("//android.widget.EditText[@content-desc=\" Campo para digitação do nome completo\"]");
        dtNasc = (MobileElement) driver.findElementByXPath("//android.widget.EditText[@content-desc=\"Campo para informar data de nascimento completa\"]");
        genero = (MobileElement) driver.findElementByXPath("//android.widget.EditText[@content-desc=\"Campo para informar o gênero\"]");
        inputEmail = (MobileElement) driver.findElementByXPath("//android.widget.EditText[@content-desc=\"Campo para informar email\"]");
        inputTelefone = (MobileElement) driver.findElementByXPath("//android.widget.EditText[@content-desc=\"Campo para informar telefone\"]");
        botaoContinuar = (MobileElement) driver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"Botão para próximo passo do cadastro\"]/android.view.ViewGroup");
    }

    public void preencherCpf(String cpf) {
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.EditText[@content-desc=\"Campo com cpf digitado\"]")));

        inputCpf.sendKeys(cpf);
    }

    public void preencherCpf() throws Exception {
        String cpf = fakeCpf();
        inputCpf.sendKeys(cpf);
    }

    public void preencherNome() {
        inputNome.sendKeys("Teste Cadastro");
    }

    public void preencherDataNascimento(String dataNascimento) {
        dtNasc.sendKeys(dataNascimento);
    }

    public void preencherDataNascimentoPadrao() {
        dtNasc.sendKeys("24052005");
    }

    public void escolherGenero() {
        genero.click();
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text=\"Masculino\"]")));
        masculino = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text=\"Masculino\"]");
        masculino.click();
    }

    public void preencherEmail(String email) {
        inputEmail.sendKeys(email);
    }

    public void preencherEmailPadrao() {
        inputEmail.sendKeys("lucas.kuroda@devires.com.br");
    }

    public void preencherTelefone(String telefone) {
        inputTelefone.sendKeys(telefone);
    }
    public void limparTelefone() {
        inputTelefone.clear();
    }

    public void preencherTelefonePadrao() {
        inputTelefone.sendKeys("14996237865");
    }

    public void clicarBotaoContinuar() {
        botaoContinuar.click();
    }

    public void mensagemCpfInválido() {
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@content-desc=\"Erro Campo com cpf digitado\"]")));
        cpfInvalido = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@content-desc=\"Erro Campo com cpf digitado\"]");
        cpfInvalido.getText().equals("CPF inválido");
    }

    public void mensagemEmailInvalido() {
        WebDriverWait espera = new WebDriverWait(driver, 10);
        MobileElement emailObrigatorio = (MobileElement) espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@content-desc=\"Erro Campo para informar email\"]")));
        String mensagemErro = emailObrigatorio.getText();
        if (mensagemErro.equalsIgnoreCase("Email inválido")) {
            System.out.println("A mensagem de erro está correta.");
        } else {
            System.out.println("A mensagem de erro está incorreta. Mensagem encontrada: " + mensagemErro);
        }
    }
    public void dtNascInvalida() {
        WebDriverWait espera = new WebDriverWait(driver, 10);
        MobileElement dtNascInvalida = (MobileElement) espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@content-desc=\"Erro Campo para informar data de nascimento completa\"]")));
        String mensagemErro = dtNascInvalida.getText();

        if (mensagemErro.equalsIgnoreCase("Não é possível cadastrar menores de idade")) {
            System.out.println("A mensagem de erro está correta.");
        } else {
            System.out.println("A mensagem de erro está incorreta. Mensagem encontrada: " + mensagemErro);
        }
    }

    public void mensagemTelefoneInvalido() {
        WebDriverWait espera = new WebDriverWait(driver, 10);

        MobileElement telefone = (MobileElement) espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@content-desc=\"Erro Campo para informar telefone\"]")));
        String mensagemErro = telefone.getText();
        if (mensagemErro.equalsIgnoreCase("Telefone inválido")) {
            System.out.println("A mensagem de erro está correta.");
        } else {
            System.out.println("A mensagem de erro está incorreta. Mensagem encontrada: " + mensagemErro);
        }
    }

    public void clicarBotaoConfirmarCadastroSenha() throws InterruptedException {
        botaoConfirmarCadastroSenha = (MobileElement) driver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"Botão para confirmar o cadastro\"]/android.view.ViewGroup");
        botaoConfirmarCadastroSenha.click();

    }

    public void aceitarTermos() throws InterruptedException {
        WebDriverWait espera = new WebDriverWait(driver, 20);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.ViewGroup[@content-desc=\"Aceitar termos de uso\"]")));
        botaoTermos = (MobileElement) driver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"Aceitar termos de uso\"]");
        botaoTermos.click();
        Thread.sleep(500);
        botaoContinuarTermos = (MobileElement) driver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"Botão para Confirmar\"]/android.view.ViewGroup");
        botaoContinuarTermos.click();

        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.view.ViewGroup[@content-desc=\"Botão para Confirmar\"]/android.view.ViewGroup")));
        botaoPrivacidade = (MobileElement) driver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"Aceitar política de privacidade\"]");
        botaoPrivacidade.click();
        Thread.sleep(500);
        botaoContinuarPrivacidade = (MobileElement) driver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"Botão para Confirmar\"]/android.view.ViewGroup");
        botaoContinuarPrivacidade.click();
    }

    public void visualizarModalCadastrado() throws InterruptedException {
        WebDriverWait espera = new WebDriverWait(driver, 20);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup")));

        //        modalCadastrado = (MobileElement) driver.findElementByXPath("//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup");
        botaoIrParaLogin = (MobileElement) driver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"Cadastro realizado, entrar no aplicativo\"]/android.view.ViewGroup");
        botaoIrParaLogin.click();
    }


    public void buscarMensagensErroObrigatoria() {
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@content-desc=\"Erro  Campo para digitação do nome completo\"]")));

        nomeObrigatorio = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@content-desc=\"Erro  Campo para digitação do nome completo\"]");
        dtObrigatorio = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@content-desc=\"Erro Campo para informar data de nascimento completa\"]");
        generoObrigatorio = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@content-desc=\"Erro Campo para informar o gênero\"]");
        emailObrigatorio = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@content-desc=\"Erro Campo para informar email\"]");
        telefoneObrigatorio = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@content-desc=\"Erro Campo para informar telefone\"]");

    }


    public void preencherFormularioInteiro() throws Exception {
        preencherCpf(fakeCpf());
        buscarElementos();
        preencherNome();
        preencherDataNascimentoPadrao();
        preencherEmailPadrao();
        preencherTelefonePadrao();
        clicarBotaoContinuar();
    }

    public void buscarModalCpfJaCadastrado() {
        WebDriverWait espera = new WebDriverWait(driver, 5);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text=\"Vimos que você já tem cadastro no App\"]")));
        botaoIrParaLoginModalJaCadastrado = (MobileElement) driver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"Botão ir para a tela de login\"]/android.view.ViewGroup");
        botaoIrParaLoginModalJaCadastrado.click();
    }

    private static String fakeCpf() throws Exception {
        String url = "https://www.4devs.com.br/ferramentas_online.php";
        HttpResponse<String> response = Unirest.post(url)
                .header("Content-Type", "application/x-www-form-urlencoded")
                .field("acao", "gerar_cpf")
                .field("sexo", "I")
                .field("pontuacao", "N")
                .field("idade", "20")
                .field("cep_estado", "SP")
                .field("txt_qtde", "1")
                .field("cep_cidade", "9668")
                .asString();

        if (response.getStatus() == 200) {
            return response.getBody();
        } else {
            throw new RuntimeException("Erro ao gerar CPF: " + response.getStatusText());
        }
    }

    public void buscarModalErroSms(){
        WebDriverWait espera = new WebDriverWait(driver, 10);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//android.widget.TextView[@text=\"Opa! O código informado é inválido.\"]")));
        modalErroSms = (MobileElement) driver.findElementByXPath("//android.widget.TextView[@text=\"Opa! O código informado é inválido.\"]");

        botaoReverCodigo = (MobileElement) driver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"Botão rever código\"]/android.view.ViewGroup");
        botaoReverCodigo.click();

    }


    public static void main(String[] args) throws Exception {
        System.out.println(fakeCpf());

    }
}
