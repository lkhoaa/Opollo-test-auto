package com.lkhoaa.testCases.B2B;

import com.lkhoaa.driver.DriverBase;
import com.lkhoaa.model.B2BPages.NewB2BPage;
import com.lkhoaa.model.LoginPage.LoginPage;
import com.lkhoaa.utils.DataLogin;
import com.lkhoaa.utils.Url;
import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class CreateB2BOrder extends DriverBase {
    @Description("Create successful a B2B order")
    @Test(dataProviderClass = DataLogin.class, dataProvider = "loginData", description = "Create new B2B order")
    public void createB2BOrder(String username, String password){
        WebDriver driver = getDriver();
        driver.manage().window().maximize();

        driver.get(Url.currentTestUrl("LOGIN_PAGE"));
        LoginPage loginPage = new LoginPage(driver);
        loginPage.inputUsername(username).inputPassword(password).clickOnLoginBtn();

        //Create B2B order
        driver.get(Url.currentTestUrl("NEW_B2B"));
        NewB2BPage newB2BPage = new NewB2BPage(driver);
        newB2BPage
                .selectType()
                .selectOrderDate()
                .selectWH()
                .selectExpectedDate()
                .selectGroupBrand()
                .enterContractNumber()
                .selectCustomer()
                .addNewSKU()
                .clickOnSubmitBtn();
        newB2BPage.assertTitle();
    }
}