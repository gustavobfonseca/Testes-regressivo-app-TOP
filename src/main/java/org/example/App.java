package org.example;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws MalformedURLException {

        DesiredCapabilities config = new DesiredCapabilities();
        File apk = new File("C:\\Users\\v8\\Desktop\\ptojetos-appium\\proketo-alura-appium\\src\\main\\resources\\alura_esporte.apk");
        config.setCapability("appPackage", "br.com.autopass.top.hml");
        config.setCapability("appActivity", "br.com.autopass.top.MainActivity");
        config.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        config.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
        config.setCapability(MobileCapabilityType.UDID, "RQ8NA0A9GYW");
        config.setCapability(MobileCapabilityType.PLATFORM_VERSION, "13");


        URL urlConexao = new URL("http://127.0.0.1:4723");
        AppiumDriver driver = new AppiumDriver<>(urlConexao, config);
    }
}
