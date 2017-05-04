package com.telran;

import com.telran.pages.CompaniesAllaPage;
import com.telran.pages.CompaniesIakovPage;
import com.telran.pages.LoginAllaPage;
import com.telran.pages.TadiranProjectAllaPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CompaniesIakovTest extends TestNgTestBase {
    private static final String ADM_LOG = "admin";
    private static final String ADM_PSW = "12345";
    private static Logger Log = Logger.getLogger(LogLog4j.class.getName());
    public CompaniesAllaPage companiesAllaPage;
    public LoginAllaPage loginAllaPage;
    public TadiranProjectAllaPage tadiranProjectAllaPage;
    public CompaniesIakovPage companiesIakovPage;


    @BeforeMethod
    public void initPageObjects() {
        companiesAllaPage = PageFactory.initElements(driver, CompaniesAllaPage.class);
        loginAllaPage = PageFactory.initElements(driver, LoginAllaPage.class);
        tadiranProjectAllaPage = PageFactory.initElements(driver, TadiranProjectAllaPage.class);
        companiesIakovPage = PageFactory.initElements(driver, CompaniesIakovPage.class);
        loginAllaPage.login(ADM_LOG, ADM_PSW);
        companiesAllaPage.waitForCompaniesPageInLoaded();
    }

    @Test(groups = {"RegressionIakov"})
    public void getTextFromBlock() {
        companiesAllaPage.clickTadiranProjectButton();
        tadiranProjectAllaPage.waitForProjectPageIsLoaded();
        // companiesIakovPage.getTextFromBloc();
        String projectName = "TADIRANPROJECT0";
        companiesIakovPage.clickOnSurweyOfProject(projectName);
        projectName = projectName.toLowerCase();
        Log.info("Project name is " + projectName);
        companiesIakovPage.waitForProjectPageisLoaded();
        Log.info("Checking name in page header");
        String actual = companiesIakovPage.getTextFromHeader();
        Assert.assertEquals(actual, projectName);
        Log.info("Success! Name are matching");
    }

    @Test(groups = {"RegressionIakov"})
    public void tadiranProjectButtonTest() {
        companiesAllaPage.clickTadiranProjectButton();
        tadiranProjectAllaPage.waitForProjectPageIsLoaded();
        Assert.assertTrue(tadiranProjectAllaPage.isOnTadiranProjectPage());
    }

    @Test(groups = {"regression"})
    public void homeButtonTest() {
        companiesAllaPage.clickTadiranProjectButton();
        tadiranProjectAllaPage.waitForProjectPageIsLoaded()
                .clickHomeButton();
        companiesAllaPage.waitForCompaniesPageInLoaded();
        Assert.assertTrue(companiesAllaPage.isOnCompaniesPage());
    }

    @Test(groups = {"regression"})
    public void selectEnglishLanguageTest() {
        companiesAllaPage.selectEnglishLanguage();
        Assert.assertTrue(companiesAllaPage.languageisEnglish(companiesAllaPage.getTextFromCompanyLabel()));
    }

    @Test(groups = {"regression"})
    public void selectHebrewLanguageTest() {
        companiesAllaPage.selecthebrewLanguage();
        companiesAllaPage.waitForCompaniesPageInLoaded();
        Assert.assertTrue(companiesAllaPage.languageisHebrew(companiesAllaPage.getTextFromCompanyLabel()));
    }
}