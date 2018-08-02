package com.cigniti.test.dataproviders;

import static junit.framework.Assert.assertEquals;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;
import java.util.Properties;

public class DataProvidersTest {

    @Test
    public void shouldCreateDesiredCapabilitiesFromPropertiesFile() throws IOException {
        Properties prop = new Properties();
        prop.setProperty("abc", "def");
        prop.setProperty("123", "098");

        DesiredCapabilitiesFromPropertyFileProvider dcp = new DesiredCapabilitiesFromPropertyFileProvider();
        dcp.properties = prop;

        DesiredCapabilities dc = dcp.provide();
        assertEquals("def", dc.getCapability("abc"));
        assertEquals("098", dc.getCapability("123"));

    }

}
