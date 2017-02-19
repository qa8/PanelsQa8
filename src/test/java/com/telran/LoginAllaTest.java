package com.telran;

import com.telran.pages.CompaniesAllaPage;
import com.telran.pages.LoginAllaPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginAllaTest extends TestNgTestBase {
    public LoginAllaPage loginAllaPage;
    public CompaniesAllaPage companiesAllaPage;
    private String url = "https://greengnome.github.io/panels/?#/login";
    private String rightLogin = "admin";
    private String rightPassword = "12345";

    @BeforeMethod
    public void initPageObjects() {
        loginAllaPage = PageFactory.initElements(driver, LoginAllaPage.class);
        companiesAllaPage = PageFactory.initElements(driver, CompaniesAllaPage.class);
    }

    @Test//incorrect login
    public void negativeLoginTest1() {
        driver.get(url);
        loginAllaPage.waitForLoginPageIsLoaded();
        loginAllaPage.fillLoginField("pppp");
        loginAllaPage.fillPasswordField(rightPassword);
        loginAllaPage.clickLoginButton();
        loginAllaPage.waitForLoginPageIsLoaded();
        Assert.assertTrue(loginAllaPage.isOnLoginPage());

    }

    @Test//incorrect password
    public void negativeLoginTest2() {
        driver.get(url);
        loginAllaPage.waitForLoginPageIsLoaded();
        loginAllaPage.fillLoginField(rightLogin);
        loginAllaPage.fillPasswordField("jij09i");
        loginAllaPage.clickLoginButton();
        loginAllaPage.waitForLoginPageIsLoaded();
        Assert.assertTrue(loginAllaPage.isOnLoginPage());

    }

    public void pozitiveLoginTest() {
        driver.get(url);
        loginAllaPage.waitForLoginPageIsLoaded();
        loginAllaPage.fillLoginField("admin");
        loginAllaPage.fillPasswordField("12345");
        loginAllaPage.clickLoginButton();
        companiesAllaPage.waitForCompaniesPageInLoaded();
        Assert.assertTrue(companiesAllaPage.isOnCompaniesPage());
    }
}
