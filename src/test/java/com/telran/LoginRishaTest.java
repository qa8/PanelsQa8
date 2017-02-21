package com.telran;

import com.telran.pages.LoginRishaPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginRishaTest extends TestNgTestBase {

    public LoginRishaPage loginRishaPage;
    public CompaniesPage_Risha companiesPage_Risha;
    private String url = "https://greengnome.github.io/panels/#/login";


    @BeforeMethod
    public void initPageObjects() {

        loginRishaPage = PageFactory.initElements(driver, LoginRishaPage.class);
        companiesPage_Risha = PageFactory.initElements(driver, CompaniesPage_Risha.class);

    }

    @Test
    public void negativeLoginTest() {
        driver.get(url);
        loginRishaPage.waitForLoginPageIsLoaded();
        loginRishaPage.fillLoginField("rrrrrrrrrrrr");
        loginRishaPage.fillPasswordField("12345");
        loginRishaPage.clickOnLogButtonField();
        Assert.assertTrue(loginRishaPage.isOnLoginPage());
    }

    @Test
    public void negativePasswordTest() {
        driver.get(url);
        loginRishaPage.waitForLoginPageIsLoaded();
        loginRishaPage.fillLoginField("admin");
        loginRishaPage.fillPasswordField("0000");
        loginRishaPage.clickOnLogButtonField();
        companiesPage_Risha.waitForCompaniesPageInLoaded();
        Assert.assertTrue(loginRishaPage.isOnLoginPage());
    }

    @Test
    public void negativeLoginANDpassTest() {
        driver.get(url);
        loginRishaPage.waitForLoginPageIsLoaded();
        loginRishaPage.fillLoginField("Nesnaika");
        loginRishaPage.fillPasswordField("??????????");
        loginRishaPage.clickOnLogButtonField();
        Assert.assertTrue(loginRishaPage.isOnLoginPage());
    }

    @Test
    public void positiveLoginTest() {
        driver.get(url);
        loginRishaPage.waitForLoginPageIsLoaded();
        loginRishaPage.fillLoginField("admin");
        loginRishaPage.fillPasswordField("12345");
        loginRishaPage.clickOnLogButtonField();
        companiesPage_Risha.waitForCompaniesPageInLoaded();
        Assert.assertTrue(companiesPage_Risha.isOnCompaniesPage());

    }
}
