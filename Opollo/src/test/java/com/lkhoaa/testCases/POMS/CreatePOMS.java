package com.lkhoaa.testCases.POMS;

import com.lkhoaa.driver.DriverBase;
import com.lkhoaa.model.POMSpages.NewPOPage;
import com.lkhoaa.model.LoginPage.LoginPage;
import com.lkhoaa.utils.DataLogin;
import com.lkhoaa.utils.Url;
import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class CreatePOMS extends DriverBase {
    @Description("Create successful a new PO order")
    @Test(dataProviderClass = DataLogin.class, dataProvider = "loginData", description = "Create new PO order")
    public void createPOMS(String username, String password) {

        WebDriver driver = getDriver();
        driver.manage().window().maximize();

        driver.get(Url.currentTestUrl("LOGIN_PAGE"));
        LoginPage loginPage = new LoginPage(driver);
        loginPage
                .inputUsername(username)
                .inputPassword(password)
                .clickOnLoginBtn();

        // Create new PO order
        driver.get(Url.currentTestUrl("NEW_PO"));
        NewPOPage newPOPage = new NewPOPage(driver);
        newPOPage
                .selectExpectedDate()
                .selectPODate()
                .selectPOType()
                .selectChannel()
                .selectVendor()
                .selectModelType()
                .selectWH()
                .inputSKU()
                .inputQuantity()
                .clickOnSubmitBtn()
                .clickOnConfirmbtn()
                .getTitle();
    }
}
