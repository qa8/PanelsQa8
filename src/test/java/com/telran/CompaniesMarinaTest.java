package com.telran;

import com.telran.pages.CompaniesMarinaPage;
import com.telran.pages.HeaderMarinaPage;
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
    private HeaderMarinaPage headerMarinaPage;

    @BeforeMethod
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

    @Test
    public void positiveCompaniesPageLoading() {

        companiesMarinaPage.waitForTadiranProjectLoaded();
        //companiesMarinaPage.waitForCompanyLoaded("Tadiran"); - it doesn't work (with dynamic element)
        //Verification: All companies are loaded
        int count=0;
        for(int i=0; i<ARRAY_COMPANIES.length;i++){
            //System.out.println(ARRAY_COMPANIES[i]);
            if (companiesMarinaPage.isCompanyOnCompaniesPage(ARRAY_COMPANIES[i])) count++;
        }
        Assert.assertTrue(ARRAY_COMPANIES.length==count);
    }

    @Test
    public void positiveCompaniesPageLSProjectButtonsonHebrew() {

        headerMarinaPage.chooseHebrewLanguage();
        int count=0;
        for(int i=0; i<ARRAY_COMPANIES.length;i++){
            //System.out.println(ARRAY_COMPANIES[i]);
            if (companiesMarinaPage.isCompanyProjectButtonTextHebrew(ARRAY_COMPANIES[i])) count++;
        }
        Assert.assertTrue(ARRAY_COMPANIES.length==count);
    }

    @Test
    public void positiveCompaniesPageLSProjectButtonsonEnglish() {

        headerMarinaPage.chooseEnglishLanguage();
        int count=0;
        for(int i=0; i<ARRAY_COMPANIES.length;i++){
            //System.out.println(ARRAY_COMPANIES[i]);
            if (companiesMarinaPage.isCompanyProjectButtonTextEnglish(ARRAY_COMPANIES[i])) count++;
        }
        Assert.assertTrue(ARRAY_COMPANIES.length==count);
    }

    // It verifies that ManagementList on Navigation Page exits on English
    @Test
    public void positiveCompaniesPageLSNavigationMenuManagementListEnglish() {
        headerMarinaPage.chooseEnglishLanguage();
        this.languageMenuNavigationVerification("En");
    }

    // It verifies that ManagementList on Navigation Page exits on Hebrew
    @Test
    public void positiveCompaniesPageLSNavigationMenuManagementListHebrew() {
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
        Assert.assertTrue(count==12);
    }

}
