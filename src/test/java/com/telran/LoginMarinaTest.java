package com.telran;

import com.telran.pages.CompaniesMarinaPage;
import com.telran.pages.LoginMarinaPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginMarinaTest extends TestNgTestBase {

    private static final String URL_LINK = "https://greengnome.github.io/panels/?#/login";
    private static final String PSW_ADM = "12345";
    private static final String LOGIN_ADM ="Admin" ;


    private LoginMarinaPage loginMarinaPage;
    private CompaniesMarinaPage companiesMarinaPage;

    @BeforeMethod
    public void initPageObjects() {
        loginMarinaPage = PageFactory.initElements(driver, LoginMarinaPage.class);
        companiesMarinaPage = PageFactory.initElements(driver,CompaniesMarinaPage.class);
}

    @Test
    public void negativeLoginTest() {
        driver.get(URL_LINK);
        loginMarinaPage.waitForLoginPageIsLoadedTime50();
        loginMarinaPage.fillLoginField("sss");
        loginMarinaPage.fillPassField("pppp");
        loginMarinaPage.clickOnLoginButton();
        loginMarinaPage.waitForLoginPageIsLoaded();
        Assert.assertTrue(loginMarinaPage.isOnLoginPage());
    }

    @Test
    public void negativeLoginTestPswIncorrect() {
        driver.get(URL_LINK);
        loginMarinaPage.waitForLoginPageIsLoadedTime50();
        loginMarinaPage.fillLoginField(LOGIN_ADM);
        loginMarinaPage.fillPassField("hjkwi");
        loginMarinaPage.clickOnLoginButton();
        //companiesMarinaPage.waitForCompanyLoaded("Tadiran"); - it doesn't work (with dynamic element)
        companiesMarinaPage.waitForTadiranProjectLoaded();
        Assert.assertTrue(loginMarinaPage.isOnLoginPage());
    }


    @Test
    public void positiveAdminLoginTest() {
        driver.get(URL_LINK);
        loginMarinaPage.waitForLoginPageIsLoadedTime50();
        loginMarinaPage.fillLoginField(LOGIN_ADM);
        loginMarinaPage.fillPassField(PSW_ADM);
        loginMarinaPage.clickOnLoginButton();
        //companiesMarinaPage.waitForCompanyLoaded("Tadiran"); - it doesn't work (with dynamic element)
        companiesMarinaPage.waitForTadiranProjectLoaded();
        Assert.assertTrue(companiesMarinaPage.isCompanyOnCompaniesPage("Tadiran"));


    }

}
