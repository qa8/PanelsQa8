package com.telran;

import com.telran.pages.CompaniesAnna;
import com.telran.pages.LoginAnnaPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Admin on 19-Feb-17.
 */
public class CompaniesAnnaTest extends TestNgTestBase {

    public LoginAnnaPage loginPage;
    public CompaniesAnna companiesAnna;

    private String url = "https://greengnome.github.io/panels/?#/login";
    private String rightUsername = "admin";
    private String rightPassword = "12345";

    @BeforeMethod
    public void initPageObjects() {
        loginPage = PageFactory.initElements(driver, LoginAnnaPage.class);
        companiesAnna = PageFactory.initElements(driver, CompaniesAnna.class);
        //loginTest = PageFactory.initElements(driver.LoginAnnaTest.class);

    }

    @Test
    public void positiveLogoutTest() {
        driver.get(url);
        loginPage.waitForLoginPageLoaded();

        loginPage.fillLoginField(rightUsername);
        loginPage.fillPasswordField(rightPassword);

        loginPage.pressLoginButton();
        loginPage.waitUntilIsLoadedCustomTime(companiesAnna.managementButton, 30);
//        Assert.assertTrue(companiesAnna.isManagementButtonDisplayed());
        Assert.assertTrue(companiesAnna.isManagementButtonPresent());
        companiesAnna.pressLogoutButton();
        loginPage.waitUntilIsLoadedCustomTime(loginPage.pleaseLogInheader, 30);
        Assert.assertTrue(loginPage.isOnLoginPage());
    }

    @Test
    public void chooseLanguageTest() {
        driver.get(url);
        loginPage.waitForLoginPageLoaded();

        loginPage.fillLoginField(rightUsername);
        loginPage.fillPasswordField(rightPassword);

        loginPage.pressLoginButton();
        loginPage.waitUntilIsLoadedCustomTime(companiesAnna.languageButton, 30);

        companiesAnna.chooseLanguage();
        loginPage.waitUntilIsLoadedCustomTime(companiesAnna.menuButton, 20);
        Assert.assertTrue(companiesAnna.changedLanguage());
    }
}
