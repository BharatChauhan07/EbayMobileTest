package com.cigniti.test.sutmodel;

import com.cigniti.test.appiumsession.TestsExecutionContext;

public class ModelIdentifier {

    private String ID;

    public ModelIdentifier(String appName, String platformName) {
        ID = appName + platformName;
    }

    @Override
    public String toString() {
        return ID;
    }

    public static ModelIdentifier getModelId(TestsExecutionContext context) {
        return new ModelIdentifier(context.getApplicationName(), context.getPlatformName());
    }

    public static ModelIdentifier getModelId(ApplicationModel model) {
        return new ModelIdentifier(model.getAppNAme(), model.getPlatformName());
    }

}
