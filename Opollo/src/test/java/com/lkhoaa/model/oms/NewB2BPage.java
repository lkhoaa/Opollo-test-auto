package com.lkhoaa.model.oms;

import io.qameta.allure.Step;
import org.apache.commons.math3.analysis.function.Exp;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class NewB2BPage {
    private WebDriver driver;
    private final WebDriverWait wait = new WebDriverWait(driver, 10000);

    public NewB2BPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Select type")
    public NewB2BPage selectType() {
        driver.findElement(By.id("react-select-2-input")).sendKeys("in" + Keys.ENTER);
        return this;
    }

    @Step("Select Order date")
    public NewB2BPage selectOrderDate() {
        WebElement calendarIcon = driver.findElement(By.cssSelector("[name=\"order_date\"]"));
        calendarIcon.click();
        WebElement desiredDate = driver.findElement(By.cssSelector(".open > .flatpickr-innerContainer > .flatpickr-rContainer > .flatpickr-days > .dayContainer > [aria-label=\"July 30, 2024\"]"));
        desiredDate.click();
        return this;
    }

    @Step("Select Expected delivery date")
    public NewB2BPage selectExpectedDate() {
        WebElement calendarIcon = driver.findElement(By.cssSelector("[name=\"delivery_date\"]"));
        calendarIcon.click();
        WebElement desiredDate = driver.findElement(By.cssSelector(".open > .flatpickr-innerContainer > .flatpickr-rContainer > .flatpickr-days > .dayContainer > [aria-label=\"July 30, 2024\"]"));
        desiredDate.click();
        return this;
    }

    @Step("Select Warehouse")
    public NewB2BPage selectWH() {
        driver.findElement(By.id("react-select-3-input")).sendKeys("phuc" + Keys.ENTER);
        return this;
    }

    @Step("Select Group Brand")
    public NewB2BPage selectGroupBrand() {
        driver.findElement(By.id("react-select-4-input")).sendKeys("nes" + Keys.ENTER);
        return this;
    }

    @Step("Enter contract number")
    public NewB2BPage enterContractNumber() {
        driver.findElement(By.name("contract_number")).sendKeys("123");
        return this;
    }

    @Step("Select Customer")
    public NewB2BPage selectCustomer() throws InterruptedException {
        driver.findElement(By.id("react-select-7-input")).sendKeys("abc" + Keys.ENTER);
        Thread.sleep(1000);
        return this;
    }

    @Step("Add SKU")
    public NewB2BPage addNewSKU() throws InterruptedException {
        driver.findElement(By.cssSelector(".b2b__sku_title > :nth-child(1) > .btn")).click();
        driver.findElement(By.cssSelector(":nth-child(2) > .on_error")).sendKeys("skuoct_tunn_48");
        driver.findElement(By.cssSelector("td:nth-child(6) > .form-control")).sendKeys("2222");
        driver.findElement(By.cssSelector("td:nth-child(7) > .form-control")).sendKeys("3333");
        Thread.sleep(1000);
        driver.findElement(By.cssSelector(":nth-child(5) > .B2BOrderCreatePage__RightInput-sc-1d09c2f-0")).sendKeys("2");
        return this;
    }

    @Step("Click On Submit Button")
    public void clickOnSubmitBtn() throws InterruptedException {
        driver.findElement(By.xpath("//div[@class='b2b__header']//div//div[2]//button[1]")).click();
        Thread.sleep(10000);
    }

    @Step("Verify that the B2B order create success")
    public void assertTitle() {
        String titleB2BOrder = driver.findElement(By.xpath("//h2[normalize-space()='B2B Orders']")).getText();
        Assert.assertEquals("B2B Orders", titleB2BOrder, "Create B2B order failed");
    }

    @Step("Open B2B detail")
    public NewB2BPage openB2BDetail() {
        WebElement firstRow = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//tbody/tr[@class='content-row'][1]")));
        WebElement link = firstRow.findElement(By.xpath(".//a"));
        link.click();
        return this;
    }

    @Step("Approve and push order to WH")
    public NewB2BPage pushOrderToWH() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn btn-primary' and text()='Approve']"))).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("password"))).sendKeys("1234");
        driver.findElement(By.xpath("//button[@class='btn btn-primary' and text()='Confirm']")).click();
        return this;
    }

    @Step("Cancel order")
    public void verifyStatusCancel() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn btn-primary' and text()='Cancel']"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn btn-primary' and text()='Confirm']"))).click();
        String orderStatus = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='w-90 badge badge-secondary badge-pill']"))).getText();
        Assert.assertEquals(orderStatus, "Cancelled", "Order status doesn't like expectation");
    }
}