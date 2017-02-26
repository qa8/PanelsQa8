package com.telran;

import com.telran.pages.LeftMenuAllaPage;
import com.telran.pages.LoginAllaPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LeftMenuAllaTest extends TestNgTestBase {

    //private static final String URL_LOG = "https://greengnome.github.io/panels/?#/login";
    private static final String ADM_LOG = "admin";
    private static final String ADM_PSW = "12345";

    public LeftMenuAllaPage leftMenuAllaPage;
    public LoginAllaPage loginAllaPage;

    @BeforeMethod
    public void initPageObjects() {
        leftMenuAllaPage = PageFactory.initElements(driver, LeftMenuAllaPage.class);
        loginAllaPage = PageFactory.initElements(driver, LoginAllaPage.class);
        loginAllaPage.login(ADM_LOG, ADM_PSW);
        leftMenuAllaPage.waitForleftMenuInLoaded();
    }

    @Test
    public void createCompanyIsSelectedTest() {
        leftMenuAllaPage.clickManagementButton();
        leftMenuAllaPage.clickCreateCompanyItemInDropdownManagement();
        leftMenuAllaPage.waitForCreateCompanyPageIsDisplayed();
        Assert.assertTrue(leftMenuAllaPage.isOnCreateCompanyPage());

    }

    @Test
    public void viewReportsIsPresentedTest() {
        leftMenuAllaPage.clickReportsButton();
        Assert.assertTrue(leftMenuAllaPage.viewReportsItemIsPresent());
    }

    @Test
    public void logoutButtonTest() {
        leftMenuAllaPage.clickLogoutButton();
        loginAllaPage.waitForLoginPageIsLoaded();
        Assert.assertTrue(loginAllaPage.isOnLoginPage());
    }
}