package com.lkhoaa.testCases.outbound;

import com.lkhoaa.model.loginpage.LoginPage;
import com.lkhoaa.utils.RetryClick;
import com.lkhoaa.utils.Webdriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class CreateB2COrder {
    @Test
    public void createB2COrder() throws InterruptedException {
        WebDriver driver = Webdriver.getChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.manage().window().maximize();

        System.out.println("Loading Url");
        driver.get("https://dev-landing.onpoint.vn/LDP10?op_source=&referral_id=&created_by=");

        System.out.println("Select first product");
        driver.findElement(By.xpath("//button[@type='button']")).click();

        System.out.println("Input full name");
        driver.findElement(By.name("full_name")).sendKeys("qc testing");

        System.out.println("Input email");
        driver.findElement(By.name("email")).sendKeys("a@a.com");

        System.out.println("Input phone");
        driver.findElement(By.name("phone")).sendKeys("0912312312");

        System.out.println("Select province");
        driver.findElement(By.id("js-province")).click();
        new Select(driver.findElement(By.id("js-province"))).selectByVisibleText("Hồ Chí Minh");

        System.out.println("Select district");
        Thread.sleep(1000);
        driver.findElement(By.id("js-district")).click();
        new Select(driver.findElement(By.id("js-district"))).selectByVisibleText("Quận 1");

        System.out.println("Input address");
        driver.findElement(By.name("address")).sendKeys("street abc");

        System.out.println("Select delivery method");
        driver.findElement(By.xpath("//div[@id='app']/div/div/div[3]/div/div/div[2]/div/div/label")).click();

        System.out.println("Select payment method");
        driver.findElement(By.xpath("//div[@id='app']/div/div/div[4]/div/div/div[2]/div/label")).click();

        System.out.println("Click on place order");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@id='app']/div/div/div[6]/div[2]/button")).click();

        System.out.println("Get order number after ordering");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='app']/div/div/div[2]/strong")));
        String orderNo = driver.findElement(By.xpath("//div[@id='app']/div/div/div[2]/strong")).getText();

        /*Open Opollo to verify order*/
        driver.get("https://dev-admin.onpoint.vn/sign_in");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.inputUsername("***").inputPassword("1234").clickOnLoginBtn();

        System.out.println("Verify order has been pulled to Opollo");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='#Order No']"))).sendKeys(orderNo);
        RetryClick.retryClickUntilElementDisplayed(
                driver,
                By.xpath("//button[text()='Search']"),
                By.xpath("//div[@id='app']/div[3]/div[5]/div/div[3]/div[3]/div[2]/div/div/div/div/div/strong"),
                5,
                1000);

        System.out.println("Finished TC");
        driver.quit();
    }
}
