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

    // it doesn't work; I cannot receive text from managementListCreateCompany, for ex
    @Test
    public void positiveCompaniesPageLSNavigationMenuEnglish() {
        headerMarinaPage.chooseEnglishLanguage();
        //????
        System.out.println(navigationMarinaPage.managementList.getText());
        if(navigationMarinaPage.managementListCreateCompany.getText().isEmpty()) System.out.println("empty");
        else {System.out.println("notEmpty"+navigationMarinaPage.managementListCreateCompany.getText());}
       Assert.assertTrue(companiesMarinaPage.isPureAscii("He", navigationMarinaPage.managementListCreateCompany.getText()));
        System.out.println(navigationMarinaPage.managementListEditCompany.getText());
        System.out.println(navigationMarinaPage.managementListCreateProject.getText());
        System.out.println(navigationMarinaPage.managementListEditProject.getText());

    }

}
