package com.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test {
    public static void main(String[] args) {
        WebDriver driver;
        String path = System.getProperty("user.dir");
        String chromeDriverPath = path + "/Opollo/chromedriver";
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);

        driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.manage().window().maximize();

        driver.get("https://dev-octopos-app.onpoint.vn/");

        WebElement authBox = driver.findElement(By.className("AuthBoxRow--name"));
        authBox.click();

        WebElement msEmail = driver.findElement(By.xpath("//input[@type='email']"));
        wait.until(ExpectedConditions.visibilityOfElementLocated((By) msEmail));
        msEmail.sendKeys("khoa.le@onpoint.vn");

        WebElement nextBtn = driver.findElement(By.cssSelector("*[@type='submit']"));
        nextBtn.click();

        WebElement msPass = driver.findElement(By.cssSelector("input[@type='password']"));
        msPass.sendKeys("Lekko1994");

        driver.close();

//        String actualText = driver.findElement(By.id("element")).getText();
//        String expectedText = "Expected Text";
//        if(actualText.equals(expectedText)) {
//            System.out.println("Text validation passed");
//        } else {
//            System.out.println("Text validation failed");
//        }
    }
}
