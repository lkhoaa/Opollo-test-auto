package com.lkhoaa.testCases.pms;

import com.lkhoaa.model.loginpage.LoginPage;
import com.lkhoaa.utils.DataLogin;
import com.lkhoaa.utils.Webdriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchSKU {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = Webdriver.getChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10000);
        driver.manage().window().maximize();

        System.out.println("Logging in");
        driver.get("https://dev-admin.onpoint.vn/sign_in");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.inputUsername("khoa.le@onpoint.vn").inputPassword("1234").clickOnLoginBtn();

        driver.get("https://dev-admin.onpoint.vn/pms/opollo_products?status=active");
        System.out.println("Input SKU");
        driver.findElement(By.xpath("(//div[@class='btn btn-more'])[1]")).click();
        driver.findElement(By.xpath("//textarea")).sendKeys("skuoct_tunn_48");
        driver.findElement(By.xpath("//button[normalize-space()='Apply']")).click();

        System.out.println("Select Group Brand");
        driver.findElement(By.id("react-select-2-input")).sendKeys("nes" + Keys.ENTER);

        System.out.println("Select Brand");
        driver.findElement(By.id("react-select-3-input")).sendKeys("nes" + Keys.ENTER);

        System.out.println("Select Classification");
        driver.findElement(By.id("react-select-4-input")).sendKeys("sing" + Keys.ENTER);

        System.out.println("Select Warehouse Platform");
        driver.findElement(By.id("react-select-5-input")).sendKeys("oc" + Keys.ENTER);

        System.out.println("Select Warehouse Code");
        driver.findElement(By.id("react-select-6-input")).sendKeys("phuc thinh" + Keys.ENTER);
        Thread.sleep(1000);

        System.out.println("Click on Search button");
        driver.findElement(By.xpath("//button[normalize-space()='Search']")).click();

        System.out.println("Verify that SKU has been displayed");
        String productSKU = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div.ml-1"))).getText();
        Assert.assertEquals("skuoct_tunn_48", productSKU, "Product SKU not match");

        driver.quit();
    }
}
