package com.cigniti.test.dataproviders;

import java.io.IOException;

public class DesiredCapabilitiesProviderFactory {

    public static DesiredCapabilitiesProvider getCapabilitiesProvider() throws IOException {

        return new DesiredCapabilitiesFromPropertyFileProvider();
    }

}
