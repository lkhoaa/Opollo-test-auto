package com.lkhoaa.testCases.pms;

import com.lkhoaa.model.loginpage.LoginPage;
import com.lkhoaa.model.pms.UpdateFileCreateSingleSKU;
import com.lkhoaa.utils.Webdriver;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.time.Duration;

public class MassCreateSingleSKU {
    @Test
    public void massCreateSingleSKU() throws IOException, InterruptedException {
        String filePath = System.getProperty("user.dir") + "/src/test/data/pms/single_product_import_create_template_v7.xlsx";
        UpdateFileCreateSingleSKU updateFileCreateSingleSKU = new UpdateFileCreateSingleSKU();
        updateFileCreateSingleSKU.updateExcelFile(filePath);

        WebDriver driver = Webdriver.getChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.manage().window().maximize();

        System.out.println("Logging in");
        driver.get("https://dev-admin.onpoint.vn/sign_in");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.inputUsername("khoa.le@onpoint.vn").inputPassword("1234").clickOnLoginBtn();

        System.out.println("Start upload file");
        driver.get("https://dev-admin.onpoint.vn/pms/opollo_products/import_single_sku");
        driver.findElement(By.xpath("//section[@class='dropzone text-center py-1 w-50 border']")).click();
        WebElement fileInput = driver.findElement(By.xpath("//input[@type='file']"));
        fileInput.sendKeys(filePath);

        Thread.sleep(1000);
        System.out.println("Click on Upload button");
        driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();

        System.out.println("Verify status success");
        SoftAssert softAssert = new SoftAssert();
        WebElement statusElement;
        try {
            statusElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@class='success']")));
        } catch (TimeoutException e) {
            statusElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@class='danger']")));
        }
        String status = statusElement.getText();
        softAssert.assertEquals(status, "success", "Status does not match expected 'success'");
        softAssert.assertAll();

        driver.quit();
    }
}
