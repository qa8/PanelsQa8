package com.telran;

import com.telran.pages.CompaniesAnna;
import com.telran.pages.LoginAnnaPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginAnnaTest extends TestNgTestBase {

    public LoginAnnaPage loginPage;
    public CompaniesAnna companiesAnna;

    private String url = "https://greengnome.github.io/panels/?#/login";
    private String rightUsername = "admin";
    private String rightPassword = "12345";

    @BeforeMethod
    public void initPageObjects() {
        loginPage = PageFactory.initElements(driver, LoginAnnaPage.class);
        companiesAnna = PageFactory.initElements(driver, CompaniesAnna.class);
    }

    @Test
    public void negativeAllWrongLoginTest() {
        driver.get(url);
        loginPage.waitForLoginPageLoaded();

        loginPage.fillLoginField("aaaaaaa");
        loginPage.fillPasswordField("   ");

        loginPage.pressLoginButton();
        loginPage.waitUntilIsLoadedCustomTime(loginPage.alertWrongLogin, 20);

//         Assert.assertTrue(loginPage.isOnLoginPage());
        Assert.assertTrue(loginPage.isAlertDisplayed());
    }

    @Test
    public void positiveLoginTest() {
        driver.get(url);
        loginPage.waitForLoginPageLoaded();

        loginPage.fillLoginField(rightUsername);
        loginPage.fillPasswordField(rightPassword);

        loginPage.pressLoginButton();
        loginPage.waitUntilIsLoadedCustomTime(companiesAnna.managementButton, 30);
//        Assert.assertTrue(companiesAnna.isManagementButtonDisplayed());
        Assert.assertTrue(companiesAnna.isManagementButtonPresent());
    }

    @Test
    public void positiveLoginTestAnyScreen() {
        driver.get(url);
        loginPage.waitForLoginPageLoaded();

        loginPage.fillLoginField(rightUsername);
        loginPage.fillPasswordField(rightPassword);

        loginPage.pressLoginButton();
//        loginPage.wait(20000, 0);

//        loginPage.waitUntilIsLoadedCustomTime(companiesAnna.menuButton, 20);
//        if(!companiesAnna.isMenuButtonDisplayed()) {
//            Assert.assertTrue(companiesAnna.isManagementButtonPresent());
//        }

        loginPage.waitUntilIsLoadedCustomTime(companiesAnna.managementButton, 15);
        if (!companiesAnna.isManagementButtonPresent()) {
            Assert.assertTrue(companiesAnna.isMenuButtonDisplayed());
            companiesAnna.menuButton.click();
        }
//        loginPage.waitUntilIsLoadedCustomTime(companiesAnna.managementButton, 5);
        Assert.assertTrue(companiesAnna.isManagementButtonPresent());
    }

    @Test
    public void positiveDoubleClickLoginTest() {
        driver.get(url);
        loginPage.waitForLoginPageLoaded();

        loginPage.fillLoginField(rightUsername);
        loginPage.fillPasswordField(rightPassword);

        loginPage.isDoubleClicked();
        loginPage.waitUntilIsLoadedCustomTime(companiesAnna.managementButton, 30);
        Assert.assertTrue(companiesAnna.isManagementButtonDisplayed());
    }

    @Test
    public void negativeWrongUsernameLoginTest() {
        driver.get(url);
        loginPage.waitForLoginPageLoaded();

        loginPage.fillLoginField("abcde");
        loginPage.fillPasswordField(rightPassword);

        loginPage.pressLoginButton();
        loginPage.waitUntilIsLoadedCustomTime(loginPage.alertWrongLogin, 30);

        Assert.assertTrue(loginPage.isAlertDisplayed());
    }

    @Test
    public void negativeWrongPasswordLoginTest() {
        driver.get(url);
        loginPage.waitForLoginPageLoaded();

        loginPage.fillLoginField(rightUsername);
        loginPage.fillPasswordField("54321");

        loginPage.pressLoginButton();
        loginPage.waitUntilIsLoadedCustomTime(loginPage.alertWrongLogin, 30);

        Assert.assertTrue(loginPage.isAlertDisplayed());
    }

    @Test
    public void positiveLoginTestVika() {
        driver.get(url);
        loginPage.waitForLoginPageLoaded();

        loginPage.fillLoginField(rightUsername);
        loginPage.fillPasswordField(rightPassword);

        loginPage.pressLoginButton();
//        loginPage.waitUntilIsLoadedCustomTime(companiesAnna.tadiranProjectButton, 30);
        loginPage.waitUntilIsLoadedCustomTime(companiesAnna.diklaProjectButton, 30);
//        Assert.assertTrue(companiesAnna.isCompaniesButtonPresent());
        Assert.assertTrue(companiesAnna.isDiklaProgectPresent());
    }
}