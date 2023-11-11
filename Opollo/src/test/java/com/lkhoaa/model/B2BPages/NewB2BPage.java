package com.lkhoaa.model.B2BPages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class NewB2BPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public NewB2BPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
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
        WebElement desiredDate = driver.findElement(By.cssSelector(".open > .flatpickr-innerContainer > .flatpickr-rContainer > .flatpickr-days > .dayContainer > [aria-label=\"April 30, 2023\"]"));
        desiredDate.click();
        return this;
    }

    @Step("Select Expected delivery date")
    public NewB2BPage selectExpectedDate() {
        WebElement calendarIcon = driver.findElement(By.cssSelector("[name=\"delivery_date\"]"));
        calendarIcon.click();
        WebElement desiredDate = driver.findElement(By.cssSelector(".open > .flatpickr-innerContainer > .flatpickr-rContainer > .flatpickr-days > .dayContainer > [aria-label=\"April 30, 2023\"]"));
        desiredDate.click();
        return this;
    }

    @Step("Select WH")
    public NewB2BPage selectWH() {
        driver.findElement(By.id("react-select-3-input")).sendKeys("vinculum::kho" + Keys.ENTER);
        return this;
    }

    @Step("Select Group Brand")
    public NewB2BPage selectGroupBrand() {
        driver.findElement(By.id("react-select-4-input")).sendKeys("gold" + Keys.ENTER);
        return this;
    }

    @Step("Enter contract number")
    public NewB2BPage enterContractNumber() {
        driver.findElement(By.name("contract_number")).sendKeys("123");
        return this;
    }

    @Step("Select Customer")
    public NewB2BPage selectCustomer() {
        driver.findElement(By.id("react-select-6-input")).sendKeys("kishan" + Keys.ENTER);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    @Step("Add SKU")
    public NewB2BPage addNewSKU() {
        driver.findElement(By.cssSelector(".b2b__sku_title > :nth-child(1) > .btn")).click();
        driver.findElement(By.cssSelector(":nth-child(2) > .on_error")).sendKeys("TEST0011");
        driver.findElement(By.cssSelector(":nth-child(5) > .B2BOrderCreatePage__RightInput-sc-1d09c2f-0")).sendKeys("2");

        WebElement purchasePrice = driver.findElement(By.cssSelector("td:nth-child(6) > .form-control"));
        Actions builder = new Actions(driver);
        builder.doubleClick(purchasePrice).perform();
        purchasePrice.sendKeys("100");
        WebElement sellingPrice = driver.findElement(By.cssSelector("td:nth-child(7) > .form-control"));
        builder.doubleClick(sellingPrice).perform();
        sellingPrice.sendKeys("200");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return this;
    }

    @Step("Submit PO Order")
    public void clickOnSubmitBtn() {
        driver.findElement(By.cssSelector(":nth-child(1) > .op-space > :nth-child(2) > .btn")).click();
    }

    @Step("Verify that the B2B order create success")
    public void assertTitle() {
        By titleElem = By.cssSelector(".content-header-title.float-left.mb-0");
        wait.until(ExpectedConditions.visibilityOfElementLocated(titleElem));
        String pageTitle = driver.getTitle();
        System.out.println(pageTitle);
        Assert.assertTrue(pageTitle.contains("B2B Orders"));
    }
}