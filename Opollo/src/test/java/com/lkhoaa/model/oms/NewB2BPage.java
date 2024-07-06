package com.lkhoaa.model.oms;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class NewB2BPage {
    private final WebDriver driver;

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

    @Step("Select WH")
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
    public NewB2BPage addNewSKU() throws InterruptedException{
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
}