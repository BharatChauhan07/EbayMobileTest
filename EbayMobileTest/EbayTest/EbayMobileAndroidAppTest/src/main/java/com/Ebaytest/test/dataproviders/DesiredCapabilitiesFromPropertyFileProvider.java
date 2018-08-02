package com.cigniti.test.dataproviders;

import org.openqa.selenium.remote.DesiredCapabilities;
import java.io.IOException;

public class DesiredCapabilitiesFromPropertyFileProvider extends SystemPropertiesLoader implements DesiredCapabilitiesProvider {

    public DesiredCapabilitiesFromPropertyFileProvider() throws IOException {
        super("appium-capabilities.properties");
    }

    public DesiredCapabilities provide() throws IOException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        for(String key : properties.stringPropertyNames()) {
            capabilities.setCapability(key, getProperty(key));
        }
        return capabilities;
    }

}
