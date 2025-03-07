package com.lkhoaa.testCases.outbound;

import com.lkhoaa.driver.DriverBase;
import com.lkhoaa.model.loginpage.LoginPage;
import com.lkhoaa.utils.RetryClick;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class CreateB2BOrder extends DriverBase {
    @Test
    public void createB2BOrder() throws InterruptedException {
        WebDriver driver = getDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.manage().window().maximize();

        driver.get("https://dev-admin.onpoint.vn/sign_in");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.inputUsername("***").inputPassword("1234").clickOnLoginBtn();

        driver.get("https://dev-admin.onpoint.vn/oms/b2b_orders/create");
        System.out.println("Select type");
        wait.until(ExpectedConditions.elementToBeClickable(By.id("react-select-2-input"))).sendKeys("in" + Keys.ENTER);

        System.out.println("Select Order date");
        driver.findElement(By.cssSelector("[name=\"order_date\"]")).click();
        driver.findElement(By.cssSelector(".open > .flatpickr-innerContainer > .flatpickr-rContainer > .flatpickr-days > .dayContainer > [aria-label=\"July 30, 2024\"]")).click();

        System.out.println("Select Expected date");
        driver.findElement(By.cssSelector("[name=\"delivery_date\"]")).click();
        driver.findElement(By.cssSelector(".open > .flatpickr-innerContainer > .flatpickr-rContainer > .flatpickr-days > .dayContainer > [aria-label=\"July 30, 2024\"]")).click();

        System.out.println("Select Warehouse");
        driver.findElement(By.id("react-select-3-input")).sendKeys("phuc" + Keys.ENTER);

        System.out.println("Select Group Brand");
        driver.findElement(By.id("react-select-4-input")).sendKeys("nes" + Keys.ENTER);

        System.out.println("Enter contract number");
        driver.findElement(By.name("contract_number")).sendKeys("123");

        System.out.println("Select Customer");
        driver.findElement(By.id("react-select-7-input")).sendKeys("abc" + Keys.ENTER);
        Thread.sleep(1000);

        System.out.println("Add SKU");
        driver.findElement(By.cssSelector(".b2b__sku_title > :nth-child(1) > .btn")).click();
        driver.findElement(By.cssSelector(":nth-child(2) > .on_error")).sendKeys("skuoct_tunn_48");
        driver.findElement(By.cssSelector("td:nth-child(6) > .form-control")).sendKeys("2222");
        driver.findElement(By.cssSelector("td:nth-child(7) > .form-control")).sendKeys("3333");
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(":nth-child(5) > .B2BOrderCreatePage__RightInput-sc-1d09c2f-0")).sendKeys("2");

        System.out.println("Click On Submit Button");
        driver.findElement(By.xpath("//div[@class='b2b__header']//div//div[2]//button[1]")).click();

        System.out.println("Verify that the B2B order created success");
        String titleB2BOrder = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[normalize-space()='B2B Orders']"))).getText();
        Assert.assertEquals("B2B Orders", titleB2BOrder, "Create B2B order failed");

        System.out.println("Open B2B Detail");
        WebElement firstRow = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tbody/tr[@class='content-row'][1]")));
        WebElement link = firstRow.findElement(By.xpath(".//a"));
        link.click();

        System.out.println("Approve and push order to WH");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn btn-primary' and text()='Approve']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password"))).sendKeys("1234");
        driver.findElement(By.xpath("//button[@class='btn btn-primary' and text()='Confirm']")).click();

        System.out.println("Click on Cancel button");
        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn btn-primary' and text()='Cancel']"))).click();

        System.out.println("Confirm cancel order and Verify cancel success");
        String orderStatus = RetryClick.retryClickUntilElementDisplayed(
                driver,
                By.xpath("//button[@class='btn btn-primary' and text()='Confirm']"),
                By.xpath("//span[@class='w-90 badge badge-secondary badge-pill']"),
                5,
                1000);
        Assert.assertEquals(orderStatus, "Cancelled", "Order status doesn't like expectation");
    }

}