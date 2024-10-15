package org.example.PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.util.Assert;

public class Tela {

    private AppiumDriver driver;

    public Tela(AppiumDriver driver) {
        this.driver = driver;
    }

    public MobileElement buscarElementoNaTela(String xPath, int tempoEspera){
        WebDriverWait espera = new WebDriverWait(driver, tempoEspera);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xPath)));

        return (MobileElement) driver.findElementByXPath(xPath);
    }

    public void clicarEmElemento(MobileElement elementoClicavel){
        elementoClicavel.click();
    }

    public void clicarEmElemento(String xPathElementoClicavel, String xPathElementoVisivel){
        int tentativas = 0;
        int tentativasMaximas = 10;

        while (tentativas <= tentativasMaximas){
            try{
                MobileElement elementoClicável = buscarElementoNaTela(xPathElementoClicavel, 5);
                elementoClicável.click();
                MobileElement elementoVisivel = buscarElementoNaTela(xPathElementoVisivel, 5);
                Thread.sleep(2000);
                Assert.isTrue(elementoVisivel.isDisplayed());
                break;
            }catch (RuntimeException e){
                tentativas++;
                if(tentativas==tentativasMaximas){
                    throw e;
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }


    }

    public void inputNoElemento(MobileElement elementoInput, String input){
        elementoInput.sendKeys(input);
    }

    public void scrollAteElemento(String xPathElementoDeEspera, int tempoEspera, String xPathElementoBuscavel){
        WebDriverWait espera = new WebDriverWait(driver, tempoEspera);
        espera.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xPathElementoDeEspera)));

        MobileElement elementoBuscado = (MobileElement) driver.findElement(MobileBy.AndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true))" +
                ".scrollIntoView(" + xPathElementoBuscavel + ");"));

//        elementoBuscado = (MobileElement) driver.findElementByXPath(xPathElementoBuscavel);
    }
}
