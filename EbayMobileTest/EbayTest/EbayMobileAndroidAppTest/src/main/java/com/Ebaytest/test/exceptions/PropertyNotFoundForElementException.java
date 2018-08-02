package com.cigniti.test.exceptions;

public class PropertyNotFoundForElementException extends RuntimeException {

    public PropertyNotFoundForElementException(String errMessage) {
        super(errMessage);
    }

}
