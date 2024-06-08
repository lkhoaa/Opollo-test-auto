package com.lkhoaa.model.LandingPage;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import static com.lkhoaa.driver.DriverBase.getDriver;

public class LandingPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public LandingPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    @Step("Select product")
    public LandingPage selectProduct() {
        driver.findElement(By.xpath("//button[@type='button'][normalize-space()='MUA NGAY'])[1]"));
        return this;
    }

    @Step("Enter username")
    public LandingPage inputUsername() {
        driver.findElement(By.xpath("//input[@name='full_name']"));
        return this;
    }

    @Step("Enter email product")
    public LandingPage inputEmail() {
        driver.findElement(By.xpath("//input[@name='email']"));
        return this;
    }

    @Step("Enter phone number")
    public LandingPage inputPhoneNumber() {
        driver.findElement(By.xpath("//input[@name='phone']"));
        return this;
    }

    @Step("Select city")
    public LandingPage selectCity() {
        Select select = new Select(driver.findElement(By.xpath("//select[@id='js-province'])[1]")));
        select.selectByValue("2");
        return this;
    }

    @Step("Select district")
    public LandingPage selectDistrict() {
        Select select = new Select(driver.findElement(By.xpath("//select[@id='js-district'])[1]")));
        select.selectByValue("1");
        return this;
    }

    @Step("Select ward")
    public LandingPage selectWard() {
        Select select = new Select(driver.findElement(By.xpath("(//select[@id='js-province'])[2]")));
        select.selectByValue("2");
        return this;
    }

    @Step("Enter address")
    public LandingPage inputAddress() {
        driver.findElement(By.xpath("//input[@name='address']"));
        return this;
    }

    @Step("Select delivery")
    public LandingPage selectDelivery(){
        driver.findElement(By.xpath("//label[normalize-space()='Giao Hàng Nhanh']"));
        return this;
    }

    @Step("Select payment method")
    public LandingPage selectPaymentMethod(){
        driver.findElement(By.xpath("//button[contains(text(),'Đặt hàng')]"));
        return this;
    }

    @Step("Verify order created success")
    public void assertHeader(){
        By titleHeader = By.xpath("//div[@class='head-title text-center']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(titleHeader));
        String pageTitle = driver.getTitle();
        System.out.println(pageTitle);
        Assert.assertTrue(pageTitle.contains("B2B Orders"));
    }

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "/Users/lkhoaa/IdeaProjects/Opollo-test-auto/Opollo/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://dev-landing.onpoint.vn/order_complete?channel=LDP10&order_number=LDP10-SEP98A21T2&total=124200&op_source=&referral_id=&created_by=");
        String pageTitle = driver.getTitle();
        System.out.println(pageTitle);
        driver.quit();
    }
}
