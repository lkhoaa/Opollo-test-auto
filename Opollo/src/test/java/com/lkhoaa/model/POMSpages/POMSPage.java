package com.lkhoaa.model.POMSpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class POMSPage {
    private final WebDriver driver;
    private final By POMSHeaderSelector = By.cssSelector("[class='content-header-title float-left mb-0']");
    public POMSPage(WebDriver driver) {
        this.driver = driver;
    }
    public WebElement getPOMSHeader() {
        return driver.findElement(POMSHeaderSelector);
    }
}
