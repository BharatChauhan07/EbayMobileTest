package com.cigniti.test.sutmodel;

import com.cigniti.test.exceptions.PropertyNotFoundForElementException;
import com.cigniti.test.exceptions.ScreenElementNotFoundException;

import java.util.HashMap;

public class BasicScreen {
    private String name;
    private HashMap<String, BasicElement> elements = new HashMap<String, BasicElement>();

    public BasicScreen(String name) {
        this.name = name;
    }

    public BasicScreen withElement(BasicElement element) {
        elements.put(element.getName(), element);
        return this;
    }

    public BasicElement getElementByName(String name) {
        BasicElement element = elements.get(name);
        if (element == null) {
            throw new ScreenElementNotFoundException(String.format("Element %s is not present on screen %s", name, this.name));
        }
        return element;
    }

    public String getLocator(String elementName) throws ScreenElementNotFoundException, PropertyNotFoundForElementException {
        BasicElement element = getElementByName(elementName);
        String locator = element.getProperty("locator");
        return locator;
    }

}
