package com.telran;

import com.telran.pages.CompaniesMarinaPage;
import com.telran.pages.HeaderMarinaPage;
import com.telran.pages.LoginMarinaPage;
import com.telran.pages.NavigationMarinaPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginMarinaTest extends TestNgTestBase {

    private static final String URL_LINK = "https://greengnome.github.io/panels/?#/login";
    private static final String PSW_ADM = "12345";
    private static final String LOGIN_ADM ="Admin" ;
    private static final String NAME_COMPANY ="Tadiran" ;


    private LoginMarinaPage loginMarinaPage;
    private CompaniesMarinaPage companiesMarinaPage;
    private NavigationMarinaPage navigationMarinaPage;
    private HeaderMarinaPage headerMarinaPage;

    @BeforeMethod
    public void initPageObjects() {
        loginMarinaPage = PageFactory.initElements(driver, LoginMarinaPage.class);
        companiesMarinaPage = PageFactory.initElements(driver,CompaniesMarinaPage.class);
        navigationMarinaPage = PageFactory.initElements(driver, NavigationMarinaPage.class);
        headerMarinaPage = PageFactory.initElements(driver, HeaderMarinaPage.class);
        driver.get(URL_LINK);
        loginMarinaPage.waitForLoginPageIsLoadedTime50();
}

    @Test
    public void negativeLoginTest() {

        loginMarinaPage.fillLoginField("sss")
                        .fillPassField("pppp")
                        .clickOnLoginButton()
                        .waitForLoginPageIsLoaded();
        Assert.assertTrue(loginMarinaPage.isOnLoginPage());
    }

    @Test
    public void negativeLoginTestPswIncorrect() {

        loginMarinaPage.fillLoginField(LOGIN_ADM)
                        .fillPassField("hjkwi")
                        .clickOnLoginButton();
        //companiesMarinaPage.waitForCompanyLoaded("Tadiran"); - it doesn't work (with dynamic element)
        companiesMarinaPage.waitForTadiranProjectLoaded();
        Assert.assertTrue(loginMarinaPage.isOnLoginPage());
    }


    @Test
    public void positiveAdminLoginTest() throws InterruptedException {

        loginMarinaPage.fillLoginField(LOGIN_ADM)
                        .fillPassField(PSW_ADM)
                        .clickOnLoginButton();
        //companiesMarinaPage.waitForCompanyLoaded(NAME_COMPANY);// - it doesn't work (with dynamic element)
        navigationMarinaPage.waitManagementListIsLoadedTime50();
        headerMarinaPage.waitHeaderIsLoaded();
        companiesMarinaPage.waitForTadiranProjectLoaded();
        companiesMarinaPage.isCompanyOnCompaniesPage("Tadiran");

        Assert.assertTrue(companiesMarinaPage.isCompanyOnCompaniesPage("Tadiran"));


    }

}
