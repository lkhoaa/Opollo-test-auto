package com.lkhoaa.testCases.inbound;

import com.lkhoaa.driver.DriverBase;
import com.lkhoaa.model.loginpage.LoginPage;
import com.lkhoaa.model.poms.CreateNewPOMS;
import com.lkhoaa.utils.DataLogin;
import com.lkhoaa.utils.Url;
import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class CreatePO extends DriverBase {
    @Description("Create successful a new PO order")
    @Test(dataProviderClass = DataLogin.class, dataProvider = "loginData", description = "Create new PO order")
    public void createPOMS(String username, String password) throws InterruptedException {
        WebDriver driver = getDriver();
        driver.manage().window().maximize();

        driver.get(Url.currentTestUrl("LOGIN_PAGE"));
        LoginPage loginPage = new LoginPage(driver);
        loginPage.inputUsername(username).inputPassword(password).clickOnLoginBtn();

        // Create new PO order
        driver.get(Url.currentTestUrl("NEW_PO"));
        CreateNewPOMS newPOPage = new CreateNewPOMS(driver);
        newPOPage.selectExpectedDate()
                .selectPODate()
                .selectPOType()
                .selectChannel()
                .selectVendor()
                .selectIBType()
                .selectModelType()
                .selectWH()
                .inputSKU()
                .inputQuantity()
                .clickOnSubmitBtn()
                .confirmPOType()
                .confirmVendor()
                .confirmModalType()
                .clickOnConfirmbtn()
                .getPONumber();
    }
}
