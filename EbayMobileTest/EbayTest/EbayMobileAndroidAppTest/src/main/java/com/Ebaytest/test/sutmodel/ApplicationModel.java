package com.cigniti.test.sutmodel;

import com.cigniti.test.appiumsession.TestsExecutionContext;

import java.util.HashMap;

public class ApplicationModel {

    private TestsExecutionContext context;

    private HashMap<String, BasicScreen> screens = new HashMap<String, BasicScreen>();

    public ApplicationModel(TestsExecutionContext context) {
        this.context = context;
    }

    public BasicScreen getScreenByName(String name) {
        return screens.get(name);
    }

    public void loadScreen(String name, BasicScreen screen) {
        screens.put(name, screen);
    }

    public String getAppNAme() {
        return context.getApplicationName();
    }

    public String getPlatformName() {
        return context.getPlatformName();
    }
}
