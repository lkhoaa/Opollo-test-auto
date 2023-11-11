package com.lkhoaa.model.POMSpages;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class NewPOPage {
    private final WebDriver driver;
    private WebDriverWait wait;

    public NewPOPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 10);
    }

    @Step("Select expected date")
    public NewPOPage selectExpectedDate() {
        By calendarElem = By.cssSelector("[name=\"received_date\"]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(calendarElem));
        WebElement calendarIcon = driver.findElement(By.cssSelector("[name=\"received_date\"]"));
        calendarIcon.click();
        WebElement desiredDate = driver.findElement(By.cssSelector(".open > .flatpickr-innerContainer > .flatpickr-rContainer > .flatpickr-days > .dayContainer > [aria-label=\"April 16, 2023\"]"));
        desiredDate.click();
        return this;
    }

    @Step("Select PO date")
    public NewPOPage selectPODate() {
        WebElement calendarIcon = driver.findElement(By.cssSelector("[name=\"po_date\"]"));
        calendarIcon.click();
        WebElement desiredDate = driver.findElement(By.cssSelector(".open > .flatpickr-innerContainer > .flatpickr-rContainer > .flatpickr-days > .dayContainer > [aria-label=\"April 16, 2023\"]"));
        desiredDate.click();
        return this;
    }

    @Step("Input PO Type as B2B")
    public NewPOPage selectPOType() {
        driver.findElement(By.id("react-select-2-input")).sendKeys("b2b" + Keys.ENTER);
        return this;
    }

    @Step("Input channel as landingpage10")
    public NewPOPage selectChannel() {
        driver.findElement(By.id("react-select-3-input")).sendKeys("landingpage10" + Keys.ENTER);
        return this;
    }

    @Step("Input vendor as kishan")
    public NewPOPage selectVendor() {
        driver.findElement(By.id("react-select-4-input")).sendKeys("kishan" + Keys.ENTER);
        return this;
    }

    @Step("Input model type as outright")
    public NewPOPage selectModelType() {
        driver.findElement(By.id("react-select-5-input")).sendKeys("outright" + Keys.ENTER);
        return this;
    }

    @Step("Input vendor as tnc")
    public NewPOPage selectWH() {
        driver.findElement(By.id("react-select-6-input")).sendKeys("tnc" + Keys.ENTER);
        return this;
    }

    @Step("Enter SKU TEST0011")
    public NewPOPage inputSKU() {
        driver.findElement(By.cssSelector(".content-row > :nth-child(2) > .form-control")).sendKeys("TEST0011");
        return this;
    }

    @Step("Enter quantity")
    public NewPOPage inputQuantity() {
        driver.findElement(By.cssSelector(".content-row > :nth-child(7) > .form-control")).sendKeys("2");
        return this;
    }

    @Step("Submit PO Order")
    public NewPOPage clickOnSubmitBtn() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.xpath("//*[@id=\"app\"]/div[3]/div[5]/div/div/div[2]/div/div[2]/div[3]/button[2]")).click();
        return this;
    }

    @Step("Comfirm create PO")
    public NewPOPage clickOnConfirmbtn() {
        By confirmBtnElem = By.cssSelector(":nth-child(3) > .d-flex > .btn-primary");
        wait.until(ExpectedConditions.elementToBeClickable(confirmBtnElem));
        driver.findElement(By.cssSelector(":nth-child(3) > .d-flex > .btn-primary")).click();
        return this;
    }

    @Step("Verify that the PO order create success")
    public void getTitle() {
        By titleElem = By.cssSelector("[aria-label=\"breadcrumb\"]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(titleElem));
        String pageTitle = driver.getTitle();
        Assert.assertTrue(pageTitle.contains("POMS | OnPoint"));
//        String currentUrl = driver.getCurrentUrl();
//        Assert.assertEquals(currentUrl, "Expected URL");
    }
}
