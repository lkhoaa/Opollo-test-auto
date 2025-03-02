package com.lkhoaa.testCases.pms;

import com.lkhoaa.model.loginpage.LoginPage;
import com.lkhoaa.model.pms.UpdateFileEditPhysicalBundleSKU;
import com.lkhoaa.utils.Webdriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class MassUpdatePhysicalBundleSKU {
    @Test
    public void massUpdatePhysicalBundleSKU() throws IOException, InterruptedException {
        String filePath = System.getProperty("user.dir") + "/src/test/data/pms/physical_bundle_import_update_template_v8.xlsx";
        UpdateFileEditPhysicalBundleSKU updateFileEditPhysicalBundleSKU = new UpdateFileEditPhysicalBundleSKU();
        updateFileEditPhysicalBundleSKU.updateExcelFile(filePath);

        WebDriver driver = Webdriver.getChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10000);
        driver.manage().window().maximize();

        System.out.println("Logging in");
        driver.get("https://dev-admin.onpoint.vn/sign_in");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.inputUsername("***").inputPassword("1234").clickOnLoginBtn();

        System.out.println("Start upload file");
        driver.get("https://dev-admin.onpoint.vn/pms/opollo_products/mass_update_physical_bundle");
        driver.findElement(By.xpath("//section[@class='dropzone text-center py-1 w-50 border']")).click();
        WebElement fileInput = driver.findElement(By.xpath("//input[@type='file']"));
        fileInput.sendKeys(filePath);

        Thread.sleep(1000);
        System.out.println("Click on Upload button");
        driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();

        System.out.println("Verify status success");
        String status = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[@class='success']"))).getText();
        Assert.assertEquals("Success", status, "status not match");

        driver.quit();
    }
}
