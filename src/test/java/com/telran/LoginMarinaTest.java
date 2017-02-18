package com.telran;

import com.telran.pages.CompaniesMarinaPage;
import com.telran.pages.LoginMarinaPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginMarinaTest extends TestNgTestBase {
    private LoginMarinaPage loginMarinaPage;
    private CompaniesMarinaPage companiesMarinaPage;

    @BeforeMethod
    public void initPageObjects() {
        loginMarinaPage = PageFactory.initElements(driver, LoginMarinaPage.class);
        companiesMarinaPage = PageFactory.initElements(driver,CompaniesMarinaPage.class);
}

    @Test
    public void negativeLoginTest() {
        driver.get("https://greengnome.github.io/panels/?#/login");
        loginMarinaPage.waitForLoginPageIsLoadedTime50();
        loginMarinaPage.fillLoginField("sss");
        loginMarinaPage.fillPassField("pppp");
        loginMarinaPage.clickOnLoginButton();
        loginMarinaPage.waitForLoginPageIsLoaded();
        Assert.assertTrue(loginMarinaPage.isOnLoginPage());
    }

    @Test
    public void positiveAdminLoginTest() {
        driver.get("https://greengnome.github.io/panels/?#/login");
        loginMarinaPage.waitForLoginPageIsLoadedTime50();
        loginMarinaPage.fillLoginField("Admin");
        loginMarinaPage.fillPassField("12345");
        loginMarinaPage.clickOnLoginButton();
        //companiesMarinaPage.waitForCompanyLoaded("Tadiran"); - it doesn't work (with dynamic element)
        companiesMarinaPage.waitForTadiranProjectLoaded();
        Assert.assertTrue(companiesMarinaPage.isCompanyOnCompaniesPage("Tadiran"));


    }

}
