package com.lkhoaa.testCases.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ExampleTest {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver,10);
        driver.get("https://automationexercise.com/");

        List<WebElement> productList = driver.findElements(By.className("single-products"));
        Actions actions = new Actions(driver);
        actions.moveToElement(productList.get(1)).perform();
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        WebElement addToCartBtn = driver.findElement(By.xpath("/html/body/section[2]/div/div/div[2]/div[1]/div[3]/div/div[1]/div[2]/div/a"));
        addToCartBtn.click();

        WebElement closeModalBtn = driver.findElement(By.xpath("cy.get('.modal-footer > .btn')"));
        closeModalBtn.click();

        actions.moveToElement(productList.get(2)).perform();
        driver.findElement(By.xpath("/html/body/section[2]/div/div/div[2]/div/div[4]/div/div[1]/div[2]/div/a")).click();
        driver.findElement(By.cssSelector("href=\"/view_cart\"")).click();
        List<WebElement> deleteBtn = driver.findElements(By.className("cart_quantity_delete"));
        deleteBtn.get(0).click();
    }
}
