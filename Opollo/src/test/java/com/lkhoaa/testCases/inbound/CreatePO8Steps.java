package com.lkhoaa.testCases.inbound;

import com.lkhoaa.model.loginpage.LoginPage;
import com.lkhoaa.utils.Webdriver;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class CreatePO8Steps {
    @Test
    public void createPO8Steps() throws InterruptedException {
        WebDriver driver = Webdriver.getChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        SoftAssert softAssert = new SoftAssert();
        driver.manage().window().maximize();

        /*Step 1: Login*/
        driver.get("https://dev-admin.onpoint.vn/sign_in");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.inputUsername("***").inputPassword("1234").clickOnLoginBtn();

        /*Step 2: Navigate to create PO page*/
        driver.get("https://dev-admin.onpoint.vn/purchase_order_v2/new");

        /*Step 3: Creating PO*/
        wait.until(ExpectedConditions.elementToBeClickable(By.id("react-select-2-input"))).sendKeys("b2b" + Keys.ENTER);
        driver.findElement(By.id("react-select-3-input")).sendKeys("landingpage10" + Keys.ENTER);
        driver.findElement(By.id("react-select-4-input")).sendKeys("1002" + Keys.ENTER);
        driver.findElement(By.id("react-select-5-input")).sendKeys("outright" + Keys.ENTER);
        driver.findElement(By.id("react-select-6-input")).sendKeys("octopos phuc" + Keys.ENTER);
        driver.findElement(By.id("react-select-7-input")).sendKeys("item" + Keys.ENTER);
        driver.findElement(By.xpath("//input[@placeholder='Enter SKU here']")).sendKeys("POMS8STEP");
        driver.findElement(By.xpath("//input[@placeholder='Quantity']")).sendKeys("2");

        /*Submit PO*/
        Thread.sleep(2000);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='bg-white text-right card-footer']//button[text()='Submit']"))).click();
        Thread.sleep(1000);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[@for='confirm_po_type']"))).click();
        driver.findElement(By.xpath("//label[@for='confirm_vendor_name']")).click();
        driver.findElement(By.xpath("//label[@for='confirm_model_type']")).click();
        WebElement element = driver.findElement(By.xpath("//label[@for=\"confirm_inbound_type\"]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(500);
        element.click();

        /*Confirm create PO*/
        By confirmBtnElem = By.cssSelector(":nth-child(3) > .d-flex > .btn-primary");
        wait.until(ExpectedConditions.elementToBeClickable(confirmBtnElem));
        driver.findElement(By.cssSelector(":nth-child(3) > .d-flex > .btn-primary")).click();

        /*Step 4: Verify PO steps*/
        boolean isStep8Displayed = false;

        WebElement inputElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@placeholder='PO Number']")));
        wait.until(d -> {
            String value = inputElement.getAttribute("value");
            return value != null && !value.isEmpty();
        });
        String POCode = inputElement.getAttribute("value");

        try {
            WebElement step8Element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='step-text' and text()='8']")));
            isStep8Displayed = step8Element.isDisplayed();
        } catch (TimeoutException e) {}

        if (isStep8Displayed) {
            System.out.println("PASS: Step 8 displayed");
            System.out.println("PO created with PO number: " + POCode);
            WebElement amountElement = driver.findElement(By.xpath("(//td//input[@class='form-control'])[8]"));
            System.out.println("PO Amount: " + amountElement.getAttribute("value"));
        } else {
            System.out.println("FAIL: Steps 8 are invisible");
            softAssert.fail("Unexpected step visible");
        }

        softAssert.assertAll();

        driver.close();
    }
}
