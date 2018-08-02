package com.cigniti.test.appiumsession;

import com.cigniti.test.dataproviders.ServerUrlProvider;
import io.appium.java_client.AppiumDriver;

import java.io.IOException;

import static com.cigniti.test.dataproviders.DesiredCapabilitiesProviderFactory.getCapabilitiesProvider;

public class AppiumSessionManager {

    private AppiumDriver driver;

    public void initiateSession() throws IOException {
        driver = new AppiumDriver( ServerUrlProvider.provide(), getCapabilitiesProvider().provide());
    }

    public void cleanupSession() {
        driver.quit();
    }

    public AppiumDriver getDriver() {
        return driver;
    }
}
