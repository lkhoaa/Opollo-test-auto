package com.lkhoaa.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Webdriver {
    public static WebDriver getChromeDriver(){

        // For chrome
        String path = System.getProperty("user.dir");
        String chromeDriverPath = path + "//chromedriver";
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);
        return new ChromeDriver();
//
//        //For firefox
//        String path = System.getProperty("user.dir");
//        String firefoxDriverPath = path + "//geckodriver.exe";
//        System.setProperty("webdriver.gecko.driver", firefoxDriverPath);
//        return new FirefoxDriver();
//
//        //For MicrosoftEdge
//        String path = System.getProperty("user.dir");
//        String edgeDriverPath = path + "//chromedriver.exe";
//        System.setProperty("webdriver.edge.driver", edgeDriverPath);
//        return new EdgeDriver();
    }
}
