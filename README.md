appiumdemo
==========

a demo of testing framework utilizing appuim

This demo framework was given the following requirements:
1. The framework should leverage existing mobile automation frameworks SeeTest/Appium
2. Demo can be with any E-commerce mobile app. Can pick up any app on the AppStore which have few forms to submit and has data validation points.
3. Can take up scenario like login to app & search for a product. Framework might not be robust but should take care of below points.
   a.Loosely coupled (Test data should be read from external file)
   b.Objects should not be hardcoded in the code.
   c.Reporting after test execution

The demo is leveraging Appium framework for mobile tests automation. Application under test is eBay mobile app from google play store.
Demo has been tested only on Android simulator.

The framework loads test data from properties files which represent elements on mobile app's screen.
Thanks to this Element properties needed for tests can be added/modified without recompiling.
Whole screens can be modified as well by adding/removing elements.
Tests are executed with testNG unit testing framework which is as well responsible for creating execution reports.
Execution is configured with use of maven surefire plugin.


Installation guide:

Prerequisites:
 - PC with any mobile device/VM attached and with running Appium server application
 - eBay mobile app apk downloaded into Appium server home directory
 - maven 3
 - java 7 jdk

Running tests:

After cloning git repository, open project workspace and update properties files located in src/main/resources.

Run from terminal:
mvn test

Test execution reports will be generated in <project-home-dir>/target/surefire-reports directory
