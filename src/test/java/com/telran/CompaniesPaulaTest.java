package com.telran;

import com.telran.pages.CompaniesPaulaPage;
import com.telran.pages.LoginPaulaPage;
import com.telran.pages.TadiranProjectAllaPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CompaniesPaulaTest extends TestNgTestBase {
    private static final String ADM_LOG = "admin";
    private static final String ADM_PSW = "12345";
    private static Logger Log = Logger.getLogger(LogLog4j.class.getName());
    public LoginPaulaPage loginPaulaPage;
    public TadiranProjectAllaPage tadiranProjectAllaPage;
    public CompaniesPaulaPage companiesPaulaPage;


    @BeforeMethod
    public void initPageObjects() {
        companiesPaulaPage = PageFactory.initElements(driver, CompaniesPaulaPage.class);
        loginPaulaPage = PageFactory.initElements(driver, LoginPaulaPage.class);
        tadiranProjectAllaPage = PageFactory.initElements(driver, TadiranProjectAllaPage.class);
        companiesPaulaPage = PageFactory.initElements(driver, CompaniesPaulaPage.class);
        loginPaulaPage.login(ADM_LOG, ADM_PSW);
        companiesPaulaPage.waitForCompaniesPageInLoaded();
    }

    @Test(groups = {"junk"})
    public void getTextFromBlock() {
        companiesPaulaPage.clickTadiranProjectButton();
        tadiranProjectAllaPage.waitForProjectPageIsLoaded();
        // companiesIakovPage.getTextFromBloc();
        String projectName = "TADIRANPROJECT0";
        companiesPaulaPage.clickOnSurweyOfProject(projectName);
        projectName = projectName.toLowerCase();
        Log.info("Project name is " + projectName);
        companiesPaulaPage.waitForProjectPageisLoaded();
        Log.info("Checking name in page header");
        String actual =companiesPaulaPage.getTextFromHeader();
        Assert.assertEquals(actual, projectName);
        Log.info("Success! Name are matching");
    }

    @Test(groups = {"regression"})
    public void tadiranProjectButtonTest() {
        companiesPaulaPage.clickTadiranProjectButton();
        tadiranProjectAllaPage.waitForProjectPageIsLoaded();
        Assert.assertTrue(tadiranProjectAllaPage.isOnTadiranProjectPage());
    }

    @Test(groups = {"regression"})
    public void homeButtonTest() {
        companiesPaulaPage.clickTadiranProjectButton();
        tadiranProjectAllaPage.waitForProjectPageIsLoaded()
                .clickHomeButton();
        companiesPaulaPage.waitForCompaniesPageInLoaded();
        Assert.assertTrue(companiesPaulaPage.isOnCompaniesPage());
    }

    @Test(groups = {"regression"})
    public void selectEnglishLanguageTest() {
        companiesPaulaPage.selectEnglishLanguage();
        Assert.assertTrue(companiesPaulaPage.languageisEnglish());
    }

    @Test(groups = {"regression"})
    public void selectHebrewLanguageTest() {
        companiesPaulaPage.selecthebrewLanguage();
        companiesPaulaPage.waitForCompaniesPageInLoaded();
        Assert.assertTrue(companiesPaulaPage.languageisHebrew());
    }
}