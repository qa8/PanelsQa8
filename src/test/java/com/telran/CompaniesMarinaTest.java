package com.telran;

import com.telran.pages.CompaniesMarinaPage;
import com.telran.pages.LoginMarinaPage;
import com.telran.pages.NavigationMarinaPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CompaniesMarinaTest extends TestNgTestBase {

    private static final String URL_LINK = "https://greengnome.github.io/panels/?#/login";
    private static final String PSW_ADM = "12345";
    private static final String LOGIN_ADM ="Admin" ;
    private static final String[] ARRAY_COMPANIES = {"Tadiran","Clalit", "Dikla"};



    private LoginMarinaPage loginMarinaPage;
    private CompaniesMarinaPage companiesMarinaPage;
    private NavigationMarinaPage navigationMarinaPage;

    @BeforeMethod
    public void initPageObjects() {
        loginMarinaPage = PageFactory.initElements(driver, LoginMarinaPage.class);
        companiesMarinaPage = PageFactory.initElements(driver, CompaniesMarinaPage.class);
        navigationMarinaPage = PageFactory.initElements(driver, NavigationMarinaPage.class);
    }

    @Test
    public void positiveCompaniesPageLoading() {
        driver.get(URL_LINK);
        loginMarinaPage.waitForLoginPageIsLoadedTime50();
        loginMarinaPage.fillLoginField(LOGIN_ADM);
        loginMarinaPage.fillPassField(PSW_ADM);
        loginMarinaPage.clickOnLoginButton();
        //companiesMarinaPage.waitForCompanyLoaded("Tadiran"); - it doesn't work (with dynamic element)
        companiesMarinaPage.waitForTadiranProjectLoaded();
        //Verification: All companies are loaded
        int count=0;
        for(int i=0; i<ARRAY_COMPANIES.length;i++){
            //System.out.println(ARRAY_COMPANIES[i]);
            if (companiesMarinaPage.isCompanyOnCompaniesPage(ARRAY_COMPANIES[i])) count++;
        }
        Assert.assertTrue(ARRAY_COMPANIES.length==count);
    }

    @Test
    public void positiveCompaniesPageLanguageSwitching() {
        driver.get(URL_LINK);
        loginMarinaPage.waitForLoginPageIsLoadedTime50();
        loginMarinaPage.fillLoginField(LOGIN_ADM);
        loginMarinaPage.fillPassField(PSW_ADM);
        loginMarinaPage.clickOnLoginButton();
        companiesMarinaPage.waitForTadiranProjectLoaded();
        companiesMarinaPage.isCompanyOnCompaniesPage("Tadiran");
        navigationMarinaPage.chooseHebrewLanguage();// it doesn't work here

        companiesMarinaPage.waitForTadiranProjectLoaded();
        Assert.assertTrue(companiesMarinaPage.isCompanyOnCompaniesPage("Tadiran"));
    }



}
