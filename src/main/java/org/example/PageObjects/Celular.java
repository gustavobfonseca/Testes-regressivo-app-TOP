package org.example.PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;

public class Celular {
    private static String appId;

    public static void resetApp(AppiumDriver driver){
        appId = (String) driver.getCapabilities().getCapability(AndroidMobileCapabilityType.APP_PACKAGE);
        driver.terminateApp(appId);
        driver.activateApp(appId);
    }
}
