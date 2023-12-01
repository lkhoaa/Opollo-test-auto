package com.lkhoaa.model.LoginPage;

//import com.lkhoaa.model.components.FooterComponent;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private final WebDriver driver;
    private final By usernameSelector = By.cssSelector("[name='email']");
    private final By passwordSelector = By.cssSelector("[name='password']");
    private final By loginBtnSelector = By.cssSelector("[type='submit']");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public WebElement loginBtn() {
        return driver.findElement(loginBtnSelector);
    }

    @Step("Input username as {username}")
    public LoginPage inputUsername(String username){
        WebElement usernameElem = driver.findElement(usernameSelector);
        usernameElem.sendKeys(username);
        return this;
    }
    @Step("Input password as {password}")
    public LoginPage inputPassword(String password){
        WebElement passwordElem = driver.findElement(passwordSelector);
        passwordElem.sendKeys(password);
        return this;
    }
    @Step("Click on login button")
    public void clickOnLoginBtn(){
        loginBtn().click();
    }
}
