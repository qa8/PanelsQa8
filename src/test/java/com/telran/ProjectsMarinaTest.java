package com.telran;

import com.telran.pages.*;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProjectsMarinaTest extends TestNgTestBase {

    private static final String URL_LINK = "https://greengnome.github.io/panels/?#/login";
    private static final String PSW_ADM = "12345";
    private static final String LOGIN_ADM ="Admin" ;
    //private static final String[] ARRAY_COMPANIES = {"Tadiran","Clalit", "Dikla"};
    private static final String NAME_COMPANY ="Tadiran" ;
    private static final String[] ARRAY_PROJECTS = {"TADIRANPROJECT1","TADIRANPROJECT0"};

    private LoginMarinaPage loginMarinaPage;
    private CompaniesMarinaPage companiesMarinaPage;
    private NavigationMarinaPage navigationMarinaPage;
    private HeaderMarinaPage headerMarinaPage;
    private ProjectsMarinaPage projectsMarinaPage;

    @BeforeMethod
    public void initPageObjects() {
        loginMarinaPage = PageFactory.initElements(driver, LoginMarinaPage.class);
        companiesMarinaPage = PageFactory.initElements(driver, CompaniesMarinaPage.class);
        navigationMarinaPage = PageFactory.initElements(driver, NavigationMarinaPage.class);
        headerMarinaPage = PageFactory.initElements(driver, HeaderMarinaPage.class);
        projectsMarinaPage = PageFactory.initElements(driver, ProjectsMarinaPage.class);
        //application loading
        driver.get(URL_LINK);
        loginMarinaPage.waitForLoginPageIsLoadedTime50()
                        .fillLoginField(LOGIN_ADM)
                        .fillPassField(PSW_ADM)
                        .clickOnLoginButton();
        companiesMarinaPage.waitForCompanyLoadedByName(NAME_COMPANY);

    }

    // Verification that all projects are loaded
    @Test
    public void positiveTestAllProjectsAreLoaded() {
        companiesMarinaPage.clickProjectButtonCompany(NAME_COMPANY);
        projectsMarinaPage.waitForProjectByNumberIsLoaded(1);
        //int num = projectsMarinaPage.getNumberOfProjects();
        int  num = ARRAY_PROJECTS.length;
        int count=0;
        for (int i=0; i<num; i++)
            if (projectsMarinaPage.isProjectOnProjectsPage(ARRAY_PROJECTS[i])) count++;
        Assert.assertTrue(count==num);
    }

    // Clicking to surveys button (for project by name)
    @Test
    public void positiveTestClickingOnSurveysButton() {
        companiesMarinaPage.clickProjectButtonCompany(NAME_COMPANY);
        projectsMarinaPage.waitForProjectByNumberIsLoaded(1)
                        .clickSurveysButton(ARRAY_PROJECTS[0]);
        headerMarinaPage.waitHeaderIsLoaded();
        Assert.assertTrue(headerMarinaPage.projectHeaderVerification(ARRAY_PROJECTS[0]));


    }

}
