package com.lkhoaa.testCases.outbound;

import com.lkhoaa.model.loginpage.LoginPage;
import com.lkhoaa.utils.Webdriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;

public class CreateRTVOrder {
    @Test
    public void createRTVOrder() {
        WebDriver driver = Webdriver.getChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.manage().window().maximize();

        driver.get("https://dev-admin.onpoint.vn/sign_in");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.inputUsername("***").inputPassword("1234").clickOnLoginBtn();

        driver.get("https://dev-admin.onpoint.vn/poms/return_to_vendor/create");
        System.out.println("Select Group Brand");
        wait.until(ExpectedConditions.elementToBeClickable(By.id("react-select-2-input"))).sendKeys("nes" + Keys.ENTER);

        System.out.println("Select Order Date");
        driver.findElement(By.cssSelector("[name=\"order_date\"]")).click();
        driver.findElement(By.cssSelector(".open > .flatpickr-innerContainer > .flatpickr-rContainer > .flatpickr-days > .dayContainer > [aria-label=\"July 30, 2024\"]")).click();

        System.out.println("Select Warehouse");
        driver.findElement(By.id("react-select-14-input")).sendKeys("octopos phuc" + Keys.ENTER);

        System.out.println("Select Delivery date");
        driver.findElement(By.cssSelector("[name=\"delivery_date\"]")).click();
        driver.findElement(By.cssSelector(".open > .flatpickr-innerContainer > .flatpickr-rContainer > .flatpickr-days > .dayContainer > [aria-label=\"July 30, 2024\"]")).click();

        System.out.println("Select Vendor");
        driver.findElement(By.id("react-select-16-input")).sendKeys("1002" + Keys.ENTER);

        System.out.println("Select Model Type");
        driver.findElement(By.id("react-select-17-input")).click();
        driver.findElement(By.id("react-select-17-option-0")).click();

        System.out.println("Add SKU");
        driver.findElement(By.xpath("//button[@class='btn btn-primary'] and text()='Add new SKU'")).click();
        driver.findElement(By.xpath("//input[@class='on_error form-control']")).sendKeys("Stock001");
        driver.findElement(By.xpath("//input[@class='B2BStockPullOutCreateEdit__RightInput-sc-150xsds-0 dnnbCb form-control on_error form-control']")).sendKeys("2");
        driver.findElement(By.xpath("//input[@placeholder='Selling Price']")).sendKeys("2000");

        System.out.println("Click On Submit Button");
        driver.findElement(By.xpath("//button[@class='btn btn-primary' and text()='Submit']")).click();
    }
}
