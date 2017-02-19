package com.telran;

import com.telran.pages.CompaniesYuriyPage;
import com.telran.pages.LoginYuriyPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Comp on 2/19/2017.
 */
public class TestYuriyLoginPage extends TestNgTestBase {

    public LoginYuriyPage loginYuriyPage;
    public CompaniesYuriyPage companiesYuriyPage;

    @BeforeMethod
    public void initPageObjects() {
        loginYuriyPage = PageFactory.initElements(driver, LoginYuriyPage.class);
        companiesYuriyPage = PageFactory.initElements(driver, CompaniesYuriyPage.class);
    }

    @Test
    public void negativelogintest() {
        driver.get("https://greengnome.github.io/panels/?#/login");
        loginYuriyPage.waitForLoginPageIsLoaded();
        loginYuriyPage.fillLoginField("sssss");
        loginYuriyPage.fillPasswordField(" ");
        loginYuriyPage.pressLoginButton();
        loginYuriyPage.waitForLoginPageIsLoaded();
        Assert.assertTrue(loginYuriyPage.isOnLoginPage());

    }

    @Test
    public void positivelogintest() {
        driver.get("https://greengnome.github.io/panels/?#/login");
        loginYuriyPage.waitForLoginPageIsLoaded();
        loginYuriyPage.fillLoginField("admin");
        loginYuriyPage.fillPasswordField("12345");
        loginYuriyPage.pressLoginButton();
        companiesYuriyPage.waitForCompaniesPageInLoaded();
        Assert.assertTrue(companiesYuriyPage.isOnCompaniesPage());


    }
}

