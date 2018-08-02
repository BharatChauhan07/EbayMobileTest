package com.cigniti.test;

import com.cigniti.test.appiumsession.TestsExecutionContext;
import com.cigniti.test.sutmodel.ApplicationModel;
import com.cigniti.test.sutmodel.ApplicationModelFactory;

import java.io.IOException;

public class DemoFixture {

    private static TestsExecutionContext context = new TestsExecutionContext();
    private static ApplicationModel model;

    public DemoFixture(String applicationName, String platformName) throws IOException {
        context.setApplicationName(applicationName);
        context.setPlatformName(platformName);
        setApplicationModel();
    }

    public ApplicationModel getApplicationModel() {
        return model;
    }

    private void setApplicationModel() throws IOException {
        model = ApplicationModelFactory.getModel(context);
    }
}
