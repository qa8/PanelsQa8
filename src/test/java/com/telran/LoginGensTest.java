package com.telran;

import com.telran.pages.CompaniesGeshaPage;
import com.telran.pages.LoginGeshaPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

//import com.telran.pages.HomePage;


//import com.telran.SampleTestNgTest;

public class LoginGensTest extends TestNgTestBase {

    public LoginGeshaPage loginGeshaPage;

    public CompaniesGeshaPage companiesGeshaPage;

    // private HomePage homepage;

    @BeforeMethod
    public void initPageObjects() {
        loginGeshaPage = PageFactory.initElements(driver, LoginGeshaPage.class);

        companiesGeshaPage = PageFactory.initElements(driver, CompaniesGeshaPage.class);
    }

    @Test

    public void negativelogintest(){
        driver.get("https://greengnome.github.io/panels/#/login");
        loginGeshaPage.waitForLoginPageIsLoaded();
        loginGeshaPage.fillLoginField("sssss");
        loginGeshaPage.fillPasswordField("hjkjd");
        loginGeshaPage.clickOnLoginButton();
        Assert.assertTrue(LoginGeshaPage.isOnLoginPage());
    }

    @Test
    public void positivelogintest(){
        driver.get("https://greengnome.github.io/panels/#/login");
        loginGeshaPage.waitForLoginPageIsLoaded();
        loginGeshaPage.fillLoginField("admin");
        loginGeshaPage.fillPasswordField("12345");
        loginGeshaPage.clickOnLoginButton();
        CompaniesGeshaPage.waitForCompaniesPageInLoaded();
        Assert.assertTrue(LoginGeshaPage.isOnLoginPage);
    }
}