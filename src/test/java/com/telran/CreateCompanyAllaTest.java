package com.telran;

import com.telran.pages.CompaniesAllaPage;
import com.telran.pages.CreateCompanyAllaPage;
import com.telran.pages.LeftMenuAllaPage;
import com.telran.pages.LoginAllaPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Andrey on 01.03.2017.
 */
public class CreateCompanyAllaTest extends TestNgTestBase {
    private static final String ADM_LOG = "admin";
    private static final String ADM_PSW = "12345";

    public CompaniesAllaPage companiesAllaPage;
    public LoginAllaPage loginAllaPage;
    public CreateCompanyAllaPage createCompanyAllaPage;
    public LeftMenuAllaPage leftMenuAllaPage;

    @BeforeMethod
    public void initPageObjects() {
        createCompanyAllaPage = PageFactory.initElements(driver, CreateCompanyAllaPage.class);
        companiesAllaPage = PageFactory.initElements(driver, CompaniesAllaPage.class);
        loginAllaPage = PageFactory.initElements(driver, LoginAllaPage.class);
        leftMenuAllaPage = PageFactory.initElements(driver, LeftMenuAllaPage.class);
        loginAllaPage.login(ADM_LOG, ADM_PSW);
        companiesAllaPage.waitForCompaniesPageInLoaded();

    }

    @Test(groups = {"regression"})
    public void fillCompanyNameTest() {
        leftMenuAllaPage.clickOnTopMenuButton()
                .clickManagementButton()
                .waitForleftMenuInLoaded()
                .clickCreateCompanyItemInDropdownManagement()
                .waitForCreateCompanyPageIsDisplayed();
        createCompanyAllaPage.clickToCompanyNameField()
                .fillCompanyNameField("dffhgv");
    }
}