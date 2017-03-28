package com.telran;

import com.telran.pages.CompaniesJulijaPage;
import com.telran.pages.CreateCompanyJulijaPage;
import com.telran.pages.LeftMenuJulijaPage;
import com.telran.pages.LoginJulijaPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class CreateCompanyJulijaTest extends TestNgTestBase {
    private static final String ADM_LOG = "admin";
    private static final String ADM_PSW = "12345";

    public CompaniesJulijaPage companiesJulijaPage;
    public LoginJulijaPage loginJulijaPage;
    public CreateCompanyJulijaPage createCompanyJulijaPage;
    public LeftMenuJulijaPage leftMenuJulijaPage;

    @BeforeMethod
    public void initPageObjects() {
        createCompanyJulijaPage = PageFactory.initElements(driver, CreateCompanyJulijaPage.class);
        companiesJulijaPage = PageFactory.initElements(driver, CompaniesJulijaPage.class);
        loginJulijaPage = PageFactory.initElements(driver, LoginJulijaPage.class);
        leftMenuJulijaPage = PageFactory.initElements(driver, LeftMenuJulijaPage.class);
        loginJulijaPage.login(ADM_LOG, ADM_PSW);
        companiesJulijaPage.waitForCompaniesPageInLoaded();

    }

    @Test(groups = {"regression"})
    public void addCompanyTest() {
        leftMenuJulijaPage.clickOnTopMenuButton()
                .clickManagementButton()
                .waitForleftMenuInLoaded()
                .clickCreateCompanyItemInDropdownManagement()
                .waitForCreateCompanyPageIsDisplayed();
        createCompanyJulijaPage.clickToCompanyNameField()
                .fillCompanyNameField("dgtrhgv")
                .fillCompanyOwnerField("kjhv")
                .fillTelephoneNumberField("978750998")
                .clickAddCompanyButton();
        companiesJulijaPage.waitForCompaniesPageInLoaded();
        companiesJulijaPage.isOnCompaniesPage();
        companiesJulijaPage.getTextFromCompanyLabel();
    }
}