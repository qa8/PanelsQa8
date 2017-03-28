package com.telran.pages;

import com.telran.LogLog4j;
import com.telran.TestNgTestBase;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CompaniesJulijaTest extends TestNgTestBase {
    public static final String ADM_LOG = "admin";
    private static final String ADM_PSW = "12345";
    private static Logger Log = Logger.getLogger(LogLog4j.class.getName());
    public CompaniesJulijaPage companiesJulijaPage;
    public LoginJulijaPage loginJulijaPage;
    public TadiranProjectJulijaPage tadiranProjectJulijaPage;
    String projectName = "Tadiran";

    @BeforeMethod
    public void initPageObjects() {
        companiesJulijaPage = PageFactory.initElements(driver, CompaniesJulijaPage.class);
        loginJulijaPage = PageFactory.initElements(driver, LoginJulijaPage.class);
        tadiranProjectJulijaPage = PageFactory.initElements(driver, TadiranProjectJulijaPage.class);
        loginJulijaPage.login(ADM_LOG, ADM_PSW);
        companiesJulijaPage.waitForCompaniesPageInLoaded();
    }

    @Test(groups = {"regression"})
    public void tadiranProjectButtonTest() {

        //companiesAllaPage.getTextFromBloc();
        companiesJulijaPage.headerCompanyIsPresent("Tadiran");
        companiesJulijaPage.clickProjectButtonByName("Tadiran");
        tadiranProjectJulijaPage.waitForProjectPageIsLoaded();
        Assert.assertTrue(tadiranProjectJulijaPage.isOnTadiranProjectPage1("CONDITIONER"));
    }

    @Test(groups = {"regression"})
    public void homeButtonTest() {
        companiesJulijaPage.clickTadiranProjectButton();
        tadiranProjectJulijaPage.waitForProjectPageIsLoaded()
                .clickHomeButton();
        companiesJulijaPage.waitForCompaniesPageInLoaded();
        Assert.assertTrue(companiesJulijaPage.isOnCompaniesPage());
    }

    @Test(groups = {"regression"})
    public void selectEnglishLanguageTest() {
        companiesJulijaPage.selectEnglishLanguage()
                .waitForCompaniesPageInLoaded();
        Assert.assertTrue(companiesJulijaPage.languageisEnglish(companiesJulijaPage.getTextFromCompanyLabel()));
    }

    @Test(groups = {"regression"})
    public void selectHebrewLanguageTest() {
        companiesJulijaPage.selecthebrewLanguage()
                .waitForCompanyLabelHebrew();
        Assert.assertTrue(companiesJulijaPage.languageisHebrew(companiesJulijaPage.getTextFromCompanyLabelHebrew()));
    }
}