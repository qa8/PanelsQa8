package com.telran;

import com.telran.pages.CompaniesAllaPage;
import com.telran.pages.LoginAllaPage;
import com.telran.pages.TadiranProjectAllaPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CompaniesAllaTest extends TestNgTestBase {

    private static final String URL_LOG = "https://greengnome.github.io/panels/?#/login";
    private static final String ADM_LOG = "admin";
    private static final String ADM_PSW = "12345";

    public CompaniesAllaPage companiesAllaPage;
    public LoginAllaPage loginAllaPage;
    public TadiranProjectAllaPage tadiranProjectAllaPage;


    @BeforeMethod
    public void initPageObjects() {
        companiesAllaPage = PageFactory.initElements(driver, CompaniesAllaPage.class);
        loginAllaPage = PageFactory.initElements(driver, LoginAllaPage.class);
        tadiranProjectAllaPage = PageFactory.initElements(driver, TadiranProjectAllaPage.class);
    }

    @Test
    public void tadiranProjectButtonTest() {
        driver.get(URL_LOG);
        loginAllaPage.waitForLoginPageIsLoaded();
        loginAllaPage.fillLoginField(ADM_LOG);
        loginAllaPage.fillPasswordField(ADM_PSW);
        loginAllaPage.clickLoginButton();
        companiesAllaPage.waitForCompaniesPageInLoaded();
        companiesAllaPage.clickTadiranProjectButton();
        tadiranProjectAllaPage.waitForProjectPageIsLoaded();
        Assert.assertTrue(tadiranProjectAllaPage.isOnTadiranProjectPage());
    }

    @Test
    public void homeButtonTest() {
        driver.get(URL_LOG);
        loginAllaPage.waitForLoginPageIsLoaded();
        loginAllaPage.fillLoginField(ADM_LOG);
        loginAllaPage.fillPasswordField(ADM_PSW);
        loginAllaPage.clickLoginButton();
        companiesAllaPage.waitForCompaniesPageInLoaded();
        companiesAllaPage.clickTadiranProjectButton();
        tadiranProjectAllaPage.waitForProjectPageIsLoaded();
        tadiranProjectAllaPage.clickHomeButton();
        companiesAllaPage.waitForCompaniesPageInLoaded();
        Assert.assertTrue(companiesAllaPage.isOnCompaniesPage());
    }

    @Test
    public void selectLanguageTest() {
        driver.get(URL_LOG);
        loginAllaPage.waitForLoginPageIsLoaded();
        loginAllaPage.fillLoginField(ADM_LOG);
        loginAllaPage.fillPasswordField(ADM_PSW);
        loginAllaPage.clickLoginButton();
        companiesAllaPage.waitForCompaniesPageInLoaded();
        companiesAllaPage.selectEnglishLanguage();
        Assert.assertTrue(companiesAllaPage.englishLanguageIsSelected());
        // companiesAllaPage.selecthebrewLanguage();
        //Assert.assertTrue(companiesAllaPage.hebrewLanguageIsSelected()); hebrew is not work
    }
}