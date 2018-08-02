package com.cigniti.ebaytest.ebaytest;

import com.cigniti.test.DemoFixture;
import com.cigniti.test.appiumsession.AppiumSessionManager;
import com.cigniti.test.sutmodel.BasicScreen;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.IOException;

public class EbayTest {
    public static AppiumSessionManager sessionManager;

    public static DemoFixture fixture;

    public static BasicScreen loginScreen;
    public static BasicScreen homeSearchScreen;
    /**
     * @Test case :Login to eBay mobile application and search for an item and add to cart and purchase it 
     * @Author: bharatchauhan07@gmail.com
     **/
    @BeforeTest
    public void setup() throws IOException {

        sessionManager = new AppiumSessionManager();

        fixture = new DemoFixture(System.getProperty("platformName", "Android"),
                                    System.getProperty("appName", "eBay"));

        sessionManager.initiateSession();

        loginScreen = fixture.getApplicationModel()
                .getScreenByName("login.screen");

        homeSearchScreen = fixture.getApplicationModel()
                .getScreenByName("homesearch.screen");
    }

    @AfterTest
    public void tearDown() {
        sessionManager.cleanupSession();
    }

    public void goToLoginScreen() {
        String homeButtonLocator = loginScreen.getLocator("home-button");
        click(homeButtonLocator);
        assertHomeSearchScreenVisible();
        String signInButtonLocator = homeSearchScreen.getLocator("signin-button");
        click(signInButtonLocator);
        assertLoginScreenVisible();
    }

    public void assertHomeSearchScreenVisible() {

    }

    public void assertLoginScreenVisible() {

    }

    public void click(String locator) {
        sessionManager.getDriver().findElementByXPath(locator).click();
    }

    public void sendKeys(String locator, String text) {
        sessionManager.getDriver().findElementByXPath(locator).sendKeys(text);
    }

}
