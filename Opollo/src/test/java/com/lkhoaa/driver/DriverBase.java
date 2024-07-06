package com.lkhoaa.driver;

import io.qameta.allure.Allure;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class DriverBase {
    private static final List<DriverFactory> webdriverThreadPool = Collections.synchronizedList(new ArrayList<>());
    private static ThreadLocal<DriverFactory> driverThread;

    @BeforeSuite(alwaysRun = true)
    public static void initWebdriverObject(){
        driverThread = ThreadLocal.withInitial(() -> {
            DriverFactory webDriverThread = new DriverFactory();
            webdriverThreadPool.add(webDriverThread);
            return webDriverThread;
        });
    }

    public static WebDriver getDriver(){
        return driverThread.get().getDriver();
    }

    @AfterSuite(alwaysRun = true)
    public void afterMethod(){
        for (DriverFactory driver : webdriverThreadPool){
            driver.quitDriver();
        }
    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod(ITestResult result) {
        getDriver().manage().deleteAllCookies();

        if (result.getStatus()==ITestResult.FAILURE){
            // 1. Get the test method name
            String testMethod = result.getName();

            // 2. Declare file location
            Calendar calendar = new GregorianCalendar();
            int y = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DATE);
            int hr = calendar.get(Calendar.HOUR_OF_DAY);
            int min = calendar.get(Calendar.MINUTE);
            int sec = calendar.get(Calendar.SECOND);

            String takenTime = y + "-" + (month+1) + "-" + day + "-" + hr + "-" + min + "-" + sec;
            String fileLocation = System.getProperty("user.dir") + "/screenshots/" + testMethod + "-" + takenTime + ".png";

            // 3. Save screenshot to the system
            File screenShot = ((TakesScreenshot) driverThread.get().getDriver()).getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(screenShot, new File(fileLocation));
                Path content = Paths.get(fileLocation);
                try (InputStream is = Files.newInputStream(content)){
                    Allure.addAttachment(testMethod,is);
                }
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
