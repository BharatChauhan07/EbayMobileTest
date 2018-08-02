package com.cigniti.ebaytest.ebaytest;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class LoginScreenTest extends EbayTest {

    public LoginScreenTest() throws IOException {
        super();
    }

    @BeforeMethod
    public void makeSureLoginScreenIsVisible() {
        goToLoginScreen();
    }

    @Test
    public void shouldAllowTypingUserName() {
        String userIdTextfieldLocator = loginScreen.getLocator("userid-textfield");
        sendKeys(userIdTextfieldLocator, "uderID_123");

    }

    @Test
    public void shouldMaskPasswordWhileTyping() {

    }



}
