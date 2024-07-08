package com.lkhoaa.model.poms;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CreateNewPOMS {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public CreateNewPOMS(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, 10);
    }

    @Step("Select expected date")
    public CreateNewPOMS selectExpectedDate() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name=\"received_date\"]"))).click();
        WebElement desiredDate = driver.findElement(By.cssSelector(".open > .flatpickr-innerContainer > .flatpickr-rContainer > .flatpickr-days > .dayContainer > [aria-label=\"July 30, 2024\"]"));
        desiredDate.click();
        return this;
    }

    @Step("Select PO date")
    public CreateNewPOMS selectPODate() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[name=\"po_date\"]"))).click();
        WebElement desiredDate = driver.findElement(By.cssSelector(".open > .flatpickr-innerContainer > .flatpickr-rContainer > .flatpickr-days > .dayContainer > [aria-label=\"July 30, 2024\"]"));
        desiredDate.click();
        return this;
    }

    @Step("Input PO Type as B2B")
    public CreateNewPOMS selectPOType() {
        driver.findElement(By.id("react-select-2-input")).sendKeys("b2b" + Keys.ENTER);
        return this;
    }

    @Step("Input channel as landingpage10")
    public CreateNewPOMS selectChannel() {
        driver.findElement(By.id("react-select-3-input")).sendKeys("landingpage10" + Keys.ENTER);
        return this;
    }

    @Step("Input vendor")
    public CreateNewPOMS selectVendor() {
        driver.findElement(By.id("react-select-4-input")).sendKeys("1002" + Keys.ENTER);
        return this;
    }

    @Step("Input model type as outright")
    public CreateNewPOMS selectModelType() {
        driver.findElement(By.id("react-select-5-input")).sendKeys("outright" + Keys.ENTER);
        return this;
    }

    @Step("Input WH")
    public CreateNewPOMS selectWH() {
        driver.findElement(By.id("react-select-6-input")).sendKeys("phuc" + Keys.ENTER);
        return this;
    }

    @Step("Enter SKU TEST0011")
    public CreateNewPOMS inputSKU() {
        driver.findElement(By.xpath("//input[@placeholder='Enter SKU here']")).sendKeys("skuoct_tunn_48");
        return this;
    }

    @Step("Enter quantity")
    public CreateNewPOMS inputQuantity() {
        driver.findElement(By.xpath("//input[@placeholder='Quantity']")).sendKeys("2");
        return this;
    }

    @Step("Submit PO Order")
    public CreateNewPOMS clickOnSubmitBtn() throws InterruptedException {
        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='bg-white text-right card-footer']//button[text()='Submit']"))).click();
        return this;
    }

    @Step("Confirm PO Type")
    public CreateNewPOMS confirmPOType() throws InterruptedException {
        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[@for='confirm_po_type']"))).click();
        return this;
    }

    @Step("Confirm Vendor")
    public CreateNewPOMS confirmVendor() {
        driver.findElement(By.xpath("//label[@for='confirm_vendor_name']")).click();
        return this;
    }

    @Step("Confirm Modal Type")
    public CreateNewPOMS confirmModalType() {
        driver.findElement(By.xpath("//label[@for='confirm_model_type']")).click();
        return this;
    }

    @Step("Comfirm create PO")
    public CreateNewPOMS clickOnConfirmbtn() {
        By confirmBtnElem = By.cssSelector(":nth-child(3) > .d-flex > .btn-primary");
        wait.until(ExpectedConditions.elementToBeClickable(confirmBtnElem));
        driver.findElement(By.cssSelector(":nth-child(3) > .d-flex > .btn-primary")).click();
        return this;
    }

    @Step("Verify that the PO order create success")
    public void getPONumber() throws InterruptedException {
        WebElement inputElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='PO Number']")));
        boolean isDisplayed = inputElement.isDisplayed();
        Thread.sleep(2000);
        String inputValue = inputElement.getAttribute("value");
        System.out.println("Element is displayed: " + isDisplayed);
        if (isDisplayed) {
            System.out.println("Input value: " + inputValue);
        } else {
            System.out.println("Element is not displayed on the page.");
        }
    }
}
