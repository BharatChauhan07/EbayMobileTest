package com.seleniummaster.mobiletest;

import static org.junit.Assert.*;
import io.selendroid.SelendroidCapabilities;
import io.selendroid.SelendroidConfiguration;
import io.selendroid.SelendroidDriver;
import io.selendroid.SelendroidLauncher;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
public class EbayMoileTest {
  private SelendroidLauncher selendroidServer = null;
  private WebDriver driver = null;
  @Test
  /*
     Step 1: navigate to http://m.ebay.com

     Step 2: type in android in the search box

     Step 3: click on search button or press enter.

     Step 4: assert that the website returns number of android merchandises.
   * 
   * 
   * @Author: bharatchauhan07@gmail.com
   * 
   * 
   * */
  public void ShouldLogin() throws InterruptedException {
      
      driver.get("http://m.ebay.com");
      Thread.sleep(5000);
    //enter items to search
      driver.findElement(By.id("kw")).sendKeys("android");
      Thread.sleep(2000);
      //click enter button
      driver.findElement(By.id("kw")).sendKeys(Keys.ENTER);
      Thread.sleep(5000);
      //assert the Search Count text has the word results 
      for (int second = 0;; second++) {
        if (second >= 60) fail("timeout");
        try { if (isElementPresent(By.id("SearchCount"))) break; } catch (Exception e) {}
        Thread.sleep(1000);
      }

      assertTrue(driver.findElement(By.id("SearchCount")).getText().contains("results"));
    }
   
  private boolean isElementPresent(By by) {
      try {
        driver.findElement(by);
        return true;
      } catch (NoSuchElementException e) {
        return false;
      }
    }

  @Before
  public void startSelendroidServer() throws Exception {
    if (selendroidServer != null) {
    selendroidServer.stopSelendroid();
   }
    SelendroidConfiguration config = new SelendroidConfiguration();

    selendroidServer = new SelendroidLauncher(config);
    selendroidServer.lauchSelendroid();

    DesiredCapabilities caps = SelendroidCapabilities.android();

    driver = new SelendroidDriver(caps);
 // Thread.sleep(50000);
  }

  @After
  public void stopSelendroidServer() {
    if (driver != null) {
      driver.quit();
    }
    if (selendroidServer != null) {
      selendroidServer.stopSelendroid();
    }
  }
}