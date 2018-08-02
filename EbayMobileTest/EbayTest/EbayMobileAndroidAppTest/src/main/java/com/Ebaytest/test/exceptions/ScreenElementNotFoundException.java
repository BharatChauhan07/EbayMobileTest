package com.cigniti.test.exceptions;

public class ScreenElementNotFoundException extends RuntimeException {
    public ScreenElementNotFoundException(String format) {
        super(format);
    }
}
