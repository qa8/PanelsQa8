package com.telran;

import com.telran.pages.CompaniesJulijaPage;
import com.telran.pages.LeftMenuJulijaPage;
import com.telran.pages.LoginJulijaPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LeftMenuJulijaTest extends TestNgTestBase {

    private static final String ADM_LOG = "admin";
    private static final String ADM_PSW = "12345";

    public LeftMenuJulijaPage leftMenuJulijaPage;
    public LoginJulijaPage loginJulijaPage;
    public CompaniesJulijaPage companiesJulijaPage;

    @BeforeMethod
    public void initPageObjects() {
        leftMenuJulijaPage = PageFactory.initElements(driver, LeftMenuJulijaPage.class);
        loginJulijaPage = PageFactory.initElements(driver, LoginJulijaPage.class);
        companiesJulijaPage = PageFactory.initElements(driver, CompaniesJulijaPage.class);
        loginJulijaPage.login(ADM_LOG, ADM_PSW);
        companiesJulijaPage.waitForCompaniesPageInLoaded();
    }

    @Test(groups = {"regression"})
    public void createCompanyIsSelectedTest() {
        leftMenuJulijaPage.clickOnTopMenuButton()
                .waitForleftMenuInLoaded()
                .clickManagementButton()
                .clickCreateCompanyItemInDropdownManagement()
                .waitForCreateCompanyPageIsDisplayed();
        Assert.assertTrue(leftMenuJulijaPage.isOnCreateCompanyPage());
    }

    @Test(groups = {"regression"})
    public void viewReportsIsPresentedTest() {
        leftMenuJulijaPage.clickOnTopMenuButton()
                .waitForleftMenuInLoaded()
                .clickReportsButton();
        Assert.assertTrue(leftMenuJulijaPage.viewReportsItemIsPresent());
    }

    @Test(groups = {"regression"})
    public void logoutButtonTest() {
        leftMenuJulijaPage.clickOnTopMenuButton()
                .waitForleftMenuInLoaded()
                .clickLogoutButton();
        loginJulijaPage.waitForLoginPageIsLoaded();
        Assert.assertTrue(loginJulijaPage.isOnLoginPage());
    }


}