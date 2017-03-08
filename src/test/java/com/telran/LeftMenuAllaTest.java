package com.telran;

import com.telran.pages.CompaniesAllaPage;
import com.telran.pages.LeftMenuAllaPage;
import com.telran.pages.LoginAllaPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LeftMenuAllaTest extends TestNgTestBase {

    private static final String ADM_LOG = "admin";
    private static final String ADM_PSW = "12345";

    public LeftMenuAllaPage leftMenuAllaPage;
    public LoginAllaPage loginAllaPage;
    public CompaniesAllaPage companiesAllaPage;

    @BeforeMethod
    public void initPageObjects() {
        leftMenuAllaPage = PageFactory.initElements(driver, LeftMenuAllaPage.class);
        loginAllaPage = PageFactory.initElements(driver, LoginAllaPage.class);
        companiesAllaPage = PageFactory.initElements(driver, CompaniesAllaPage.class);
        loginAllaPage.login(ADM_LOG, ADM_PSW);
        companiesAllaPage.waitForCompaniesPageInLoaded();
    }

    @Test(groups = {"regression"})
    public void createCompanyIsSelectedTest() {
        leftMenuAllaPage.clickOnTopMenuButton()
                .waitForleftMenuInLoaded()
                .clickManagementButton()
                .clickCreateCompanyItemInDropdownManagement()
                .waitForCreateCompanyPageIsDisplayed();
        Assert.assertTrue(leftMenuAllaPage.isOnCreateCompanyPage());
    }

    @Test(groups = {"regression"})
    public void viewReportsIsPresentedTest() {
        leftMenuAllaPage.clickOnTopMenuButton()
                .waitForleftMenuInLoaded()
                .clickReportsButton();
        Assert.assertTrue(leftMenuAllaPage.viewReportsItemIsPresent());
    }

    @Test(groups = {"regression"})
    public void logoutButtonTest() {
        leftMenuAllaPage.clickOnTopMenuButton()
                .waitForleftMenuInLoaded()
                .clickLogoutButton();
        loginAllaPage.waitForLoginPageIsLoaded();
        Assert.assertTrue(loginAllaPage.isOnLoginPage());
    }


}