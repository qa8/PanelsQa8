package com.telran;

//import com.telran.pages.HomePage;

import com.telran.pages.CompaniesPage_Risha;
import com.telran.pages.LoginRishaPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CompaniesRishaTest extends TestNgTestBase {
    public LoginRishaPage loginRishaPage;
    public CompaniesPage_Risha companiesPage_Risha;
    private String url = "https://greengnome.github.io/panels/#/login";

    @BeforeMethod
    public void initPageObjects() {

        loginRishaPage = PageFactory.initElements(driver, LoginRishaPage.class);
        companiesPage_Risha = PageFactory.initElements(driver, CompaniesPage_Risha.class);
    }
    @Test
    public void positiveMenuCompaniesTest() {
        driver.get(url);
        loginRishaPage.waitForLoginPageIsLoaded();
        loginRishaPage.fillLoginField("admin");
        loginRishaPage.fillPasswordField("12345");
        loginRishaPage.clickOnLogButtonField();
        companiesPage_Risha.waitForCompaniesPageInLoaded();
        // companiesPage_Risha.clickOnManagementButton();
        // companiesPage_Risha.selectValueInDropdownManagement();
        // companiesPage_Risha.clickOnSurveysButton();
        //companiesPage_Risha.selectValueInDropdownSurveys();
        //companiesPage_Risha.clickOnReportsButton();
        // companiesPage_Risha.selectValueInDropdownReports();
        //companiesPage_Risha.clickOnAlertsButton();
        // companiesPage_Risha.selectValueInDropdownAlerts();
        companiesPage_Risha.clickOnQuitButton();
        loginRishaPage.waitForLoginPageIsLoaded();
        Assert.assertTrue(loginRishaPage.isOnLoginPage());
    }
}
