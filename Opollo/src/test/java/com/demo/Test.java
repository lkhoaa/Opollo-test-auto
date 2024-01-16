package com.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {
    public static void main(String[] args) {
        WebDriver driver;
        String path = System.getProperty("user.dir");
        String chromeDriverPath = path + "/Opollo/chromedriver";
        System.setProperty("webdriver.chrome.driver", chromeDriverPath);

        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://dev-octopos-app.onpoint.vn/");

        WebElement authBox = driver.findElement(By.className("AuthBoxRow--name"));
        authBox.click();

        WebElement msEmailEle = driver.findElement(By.xpath("(//input[@id='i0116'])[1]"));
        msEmailEle.sendKeys("khoa.le@onpoint.vn");

        WebElement nextBtn = driver.findElement(By.cssSelector("*[@type='submit']"));
        nextBtn.click();

        WebElement msPass = driver.findElement(By.cssSelector("input[@type='password']"));
        msPass.sendKeys("Lekko1994");

        driver.close();
    }
}
