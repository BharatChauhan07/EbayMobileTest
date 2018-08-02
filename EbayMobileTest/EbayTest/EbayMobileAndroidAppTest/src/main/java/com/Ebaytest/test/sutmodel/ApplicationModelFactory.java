package com.cigniti.test.sutmodel;

import com.cigniti.test.appiumsession.TestsExecutionContext;

import java.io.IOException;

import static com.cigniti.test.sutmodel.ModelIdentifier.getModelId;

public final class ApplicationModelFactory {

    private static ApplicationModelLoader loader;

    public static ApplicationModel getModel(TestsExecutionContext context) throws IOException {
        loader = new ApplicationModelLoader(getModelId(context).toString());
        ApplicationModel model = new ApplicationModel(context);
        loader.loadModelFromFiles(model);
        return model;
    }

}
