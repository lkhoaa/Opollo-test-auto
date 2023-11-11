package com.lkhoaa.driver;

import com.lkhoaa.utils.Webdriver;
import org.openqa.selenium.WebDriver;

public class DriverFactory {
    private WebDriver webDriver;

    //Singleton Design Pattern
    WebDriver getDriver(){
        if (webDriver == null) {
            webDriver = Webdriver.getChromeDriver();
        }
        return webDriver;
    }

    void quitDriver(){
        if (webDriver !=null){
            webDriver.quit();
            webDriver = null;
        }
    }
}
