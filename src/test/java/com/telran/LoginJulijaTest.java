package com.telran;

import com.telran.pages.CompaniesJulijaPage;
import com.telran.pages.LoginJulijaPage;
import com.telran.pages.TadiranProjectJulijaPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginJulijaTest extends TestNgTestBase {
    private static final String URL_LOG = "https://greengnome.github.io/panels";
    private static final String ADM_LOG = "admin";
    private static final String ADM_PSW = "12345";

    public LoginJulijaPage loginJulijaPage;
    public CompaniesJulijaPage companiesJulijaPage;
    public TadiranProjectJulijaPage tadiranProjectJulijaPage;

    @BeforeMethod
    public void initPageObjects() {
        loginJulijaPage = PageFactory.initElements(driver, LoginJulijaPage.class);
        companiesJulijaPage = PageFactory.initElements(driver, CompaniesJulijaPage.class);
        tadiranProjectJulijaPage = PageFactory.initElements(driver, TadiranProjectJulijaPage.class);

    }

    @Test(groups = {"smoke"})
    public void negativeLoginTest1() {
        driver.get(URL_LOG);
        loginJulijaPage.waitForLoginPageIsLoaded()
                .fillLoginField("pppp")
                .fillPasswordField(ADM_PSW)
                .clickLoginButton()
                .waitForLoginPageIsLoaded();
        Assert.assertTrue(loginJulijaPage.isOnLoginPage());

    }

    @Test(groups = {"smoke"})
    public void negativeLoginTest2() {
        driver.get(URL_LOG);
        loginJulijaPage.waitForLoginPageIsLoaded()
                .fillLoginField(ADM_LOG)
                .fillPasswordField("jij09i")
                .clickLoginButton()
                .waitForLoginPageIsLoaded();
        Assert.assertTrue(loginJulijaPage.isOnLoginPage());

    }

    @Test(groups = {"smoke, regression"})
    public void pozitiveLoginTest() {
        loginJulijaPage.login(ADM_LOG, ADM_PSW);
        companiesJulijaPage.waitForCompaniesPageInLoaded();
        Assert.assertTrue(companiesJulijaPage.isOnCompaniesPage());
    }

}