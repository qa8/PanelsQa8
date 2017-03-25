package com.telran;

import com.telran.pages.CompaniesPaulaPage;
import com.telran.pages.LoginPaulaPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPaulaTest extends TestNgTestBase {

    public LoginPaulaPage loginPaulaPage;
    public CompaniesPaulaPage companiesIakovPage;

    @BeforeMethod
    public void initPageObjects() {
        loginPaulaPage = PageFactory.initElements(driver, LoginPaulaPage.class);
        companiesIakovPage = PageFactory.initElements(driver, CompaniesPaulaPage.class);
    }

    @Test(groups = {"smoke", "regression"}, dataProviderClass = DataProvidersPaula.class, dataProvider = "pozitiveAdmin")
    public void positivelogintest(String login, String pass) {
        driver.get("https://greengnome.github.io/panels/");
        loginPaulaPage.waitForLoginPageIsLoaded();
        loginPaulaPage.fillLoginField(login);
        loginPaulaPage.fillPasswordField(pass);
        loginPaulaPage.pressLoginButton();
        companiesIakovPage.waitForCompaniesPageIsLoaded();
        Assert.assertTrue(companiesIakovPage.isOnCompaniesPage());

    }
    @Test(dataProviderClass = DataProvidersPaula.class, dataProvider = "negativeAdmin")
    public void negativelogintest(String login, String pass) {
        driver.get("https://greengnome.github.io/panels");
        loginPaulaPage.waitForLoginPageIsLoaded();
        loginPaulaPage.fillLoginField(login);
        loginPaulaPage.fillPasswordField(pass);
        loginPaulaPage.pressLoginButton();
        Assert.assertTrue(loginPaulaPage.isOnLoginPage());
    }


}
