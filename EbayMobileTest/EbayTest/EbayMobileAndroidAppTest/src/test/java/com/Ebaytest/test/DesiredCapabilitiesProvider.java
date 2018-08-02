package com.cigniti.test.dataproviders;

import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.IOException;

public interface DesiredCapabilitiesProvider {

    public DesiredCapabilities provide() throws IOException;

}
