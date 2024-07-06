package com.lkhoaa.model.oms;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {
    private final WebDriver driver;

    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Select first product")
    public LandingPage selectFirstProduct(){
        driver.findElement(By.xpath("//button[@type='button']")).click();
        return this;
    }

    @Step("Input full name")
    public LandingPage inputName(){
        driver.findElement(By.name("full_name")).sendKeys("qc testing");
        return this;
    }

    @Step("Input email")
    public LandingPage inputEmail(){
        driver.findElement(By.name("email")).sendKeys("a@a.com");
        return this;
    }

    @Step("Input phone")
    public LandingPage inputPhone(){
        driver.findElement(By.name("phone")).sendKeys("0912312312");
        return this;
    }

}
