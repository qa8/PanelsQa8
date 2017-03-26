package com.telran;

import com.telran.pages.CompaniesMarinaPage;
import com.telran.pages.HeaderMarinaPage;
import com.telran.pages.LoginMarinaPage;
import com.telran.pages.NavigationMarinaPage;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CompaniesMarinaTest extends TestNgTestBase {
    private static Logger Log = Logger.getLogger(LogLog4j.class.getName());

    private static final String URL_LINK = "https://greengnome.github.io/panels/?#/login";
    private static final String PSW_ADM = "12345";
    private static final String LOGIN_ADM ="Admin" ;
    private static final String[] ARRAY_COMPANIES = {"Tadiran","Clalit", "Dikla"};

    private LoginMarinaPage loginMarinaPage;
    private CompaniesMarinaPage companiesMarinaPage;
    private NavigationMarinaPage navigationMarinaPage;
    private HeaderMarinaPage headerMarinaPage;

    @BeforeMethod(alwaysRun = true)
    public void initPageObjects() {
        loginMarinaPage = PageFactory.initElements(driver, LoginMarinaPage.class);
        companiesMarinaPage = PageFactory.initElements(driver, CompaniesMarinaPage.class);
        navigationMarinaPage = PageFactory.initElements(driver, NavigationMarinaPage.class);
        headerMarinaPage = PageFactory.initElements(driver, HeaderMarinaPage.class);
        //application loading
        driver.get(URL_LINK);
        loginMarinaPage.waitForLoginPageIsLoadedTime50()
                        .fillLoginField(LOGIN_ADM)
                        .fillPassField(PSW_ADM)
                        .clickOnLoginButton();
        navigationMarinaPage.waitManagementListIsLoadedTime50();
        headerMarinaPage.waitHeaderIsLoaded();
    }

    @Test(groups = {"smoke", "regression"})
    public void positiveCompaniesPageLoading() {
        Log.info("Test: positiveCompaniesPageLoading");
        companiesMarinaPage.waitForTadiranProjectLoaded();
        //companiesMarinaPage.waitForCompanyLoaded("Tadiran"); - it doesn't work (with dynamic element)
        //Verification: All companies are loaded
        int count=0;
        for(int i=0; i<ARRAY_COMPANIES.length;i++){
            //System.out.println(ARRAY_COMPANIES[i]);
            if (companiesMarinaPage.isCompanyOnCompaniesPage(ARRAY_COMPANIES[i])) count++;
        }
        Assert.assertTrue(ARRAY_COMPANIES.length==count, "Not passed. Not all companies are loaded.");
    }

    @Test(groups =  "regression")
    public void positiveCompaniesPageLSProjectButtonsonHebrew() {
        Log.info("----Test: positiveCompaniesPageLSProjectButtonsonHebrew");
        headerMarinaPage.chooseHebrewLanguage();
        int count=0;
        for(int i=0; i<ARRAY_COMPANIES.length;i++){
            //System.out.println(ARRAY_COMPANIES[i]);
            if (companiesMarinaPage.isCompanyProjectButtonTextHebrew(ARRAY_COMPANIES[i])) count++;
        }
        Assert.assertTrue(ARRAY_COMPANIES.length==count, "Not passed. Exists text (on project button) that is not on Hebrew.");
    }

    @Test(groups = "regression")
    public void positiveCompaniesPageLSProjectButtonsonEnglish() {
        Log.info("----Test: positiveCompaniesPageLSProjectButtonsonEnglish");
        headerMarinaPage.chooseEnglishLanguage();
        int count=0;
        for(int i=0; i<ARRAY_COMPANIES.length;i++){
            //System.out.println(ARRAY_COMPANIES[i]);
            if (companiesMarinaPage.isCompanyProjectButtonTextEnglish(ARRAY_COMPANIES[i])) count++;
        }
        Assert.assertTrue(ARRAY_COMPANIES.length==count,"Not passed. Exists text (on project button) that is not on English." );
    }

    // It verifies navigation menu on English
    @Test(groups =  "regression")
    public void positiveCompaniesPageLSNavigationMenuManagementListEnglish() {
        Log.info("----Test: positiveCompaniesPageLSNavigationMenuManagementListEnglish");
        headerMarinaPage.chooseEnglishLanguage();
        this.languageMenuNavigationVerification("En");
    }

    // It verifies navigation menu on Hebrew
    @Test(groups =  "regression")
    public void positiveCompaniesPageLSNavigationMenuManagementListHebrew() {
        Log.info("----Test: positiveCompaniesPageLSNavigationMenuManagementListHebrew");
        headerMarinaPage.chooseHebrewLanguage();
        this.languageMenuNavigationVerification("He");
    }




    public void languageMenuNavigationVerification(String language){
        int count=0;

        navigationMarinaPage.clickMenuManagement()
                .waitManagementListIsLoaded();
        if (navigationMarinaPage.isMenuManagementOnLanguage(language)) count++;
        if (navigationMarinaPage.isCreateCompanyManagementOnLanguage(language)) count++;
        if (navigationMarinaPage.isCreateProjectManagementOnLanguage(language)) count++;
        if (navigationMarinaPage.isEditCompanyManagementOnLanguage(language)) count++;
        if (navigationMarinaPage.isEditProjectOnLanguage(language)) count++;
        navigationMarinaPage.clickCloseMenuManagement()
                .clickMenuSurveys()
                .waitSurveysListIsLoaded();
        if (navigationMarinaPage.isMenuSurveysOnLanguage(language)) count++;
        if (navigationMarinaPage.isCreateSurveyOnLanguage(language)) count++;
        if (navigationMarinaPage.isEditSurveyOnLanguage(language)) count++;
        navigationMarinaPage.clickCloseMenuSurveys()
                .clickMenuReports()
                .waitReportsListIsLoaded();
        if (navigationMarinaPage.isMenuReportsOnLanguage(language)) count++;
        if (navigationMarinaPage.isViewReportsOnLanguage(language)) count++;
        if (navigationMarinaPage.isExportReportsOnLanguage(language)) count++;
        navigationMarinaPage.clickCloseMenuReports();
        if (navigationMarinaPage.isLogoutButtonOnLanguage(language))count++;
        Assert.assertTrue(count==12, "Not passed. Not all menu elements on "+language);
    }

}
