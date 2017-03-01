package com.telran;

import com.telran.pages.CompaniesIakovPage;
import com.telran.pages.LoginIakovPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginIakovTest extends TestNgTestBase {

    public LoginIakovPage loginIakovPage;
    public CompaniesIakovPage companiesIakovPage;

    @BeforeMethod
    public void initPageObjects() {
        loginIakovPage = PageFactory.initElements(driver, LoginIakovPage.class);
        companiesIakovPage = PageFactory.initElements(driver, CompaniesIakovPage.class);
    }

    @Test
    public void negativelogintest() {
        driver.get("https://greengnome.github.io/panels/?#/login");
        loginIakovPage.waitForLoginPageIsLoaded();
        loginIakovPage.fillLoginField("sssss");
        loginIakovPage.fillPasswordField(" ");
        loginIakovPage.pressLoginButton();
        Assert.assertTrue(loginIakovPage.isOnLoginPage());
    }

    @Test(groups = {"smoke", "regression"})
    public void positivelogintest() {
        driver.get("https://greengnome.github.io/panels/?#/login");
        loginIakovPage.waitForLoginPageIsLoaded();
        loginIakovPage.fillLoginField("admin");
        loginIakovPage.fillPasswordField("12345");
        loginIakovPage.pressLoginButton();
        companiesIakovPage.waitForCompaniesPageIsLoaded();
        Assert.assertTrue(companiesIakovPage.isOnCompaniesPage());

    }

}
