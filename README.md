# PageObjectPatternAppium

To Run the TestNG test on android
    
    * Platform="android" mvn clean -Dtest=Runner test

 To Run the TestNG test on iOS
  
    * Platform="ios" mvn clean -Dtest=Runner test

 To Run the TestNG test on iOS and android both in parallel
  
    * Platform="both" mvn clean -Dtest=Runner test
    
To Run the Cucumber test


    * mvn validate && Platorm="android" mvn clean -Dtest=RunnerCukes test    

1.Please make sure you have capabilities.json  under caps folder.

2.RUNNER value in config.properties can be set with parallel or distribute. (Parallel will run the same test cases across devices & distribute will split the test cases randomly across devices)

3.No need to start appium server externally , framework takes case of starting and shutting down the server for you.

Post Run :

Once the test run is completed, HTML report will b generated at target/ExtentReport.html

If you have used ScreenshotManager to capture screenshots on runtime, you can execute generate_report.sh to view detailed reports

