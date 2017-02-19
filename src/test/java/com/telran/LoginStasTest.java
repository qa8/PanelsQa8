package com.telran;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by user on 15.02.2017.
 */
public class LoginStasTest extends TestNgTestBase {

    public com.telran.pages.LoginStasPage LoginStasPage;
    public com.telran.pages.CompaniesStasPage CompaniesStasPage;


    @BeforeMethod
    public void initPageObjects() {
        LoginStasPage = PageFactory.initElements(driver, com.telran.pages.LoginStasPage.class);
        CompaniesStasPage = PageFactory.initElements(driver, com.telran.pages.CompaniesStasPage.class);
    }

    @Test
    public void negativeLoginTest() {

        driver.get("https://greengnome.github.io/panels/?#/login");
        LoginStasPage.waitForLoginPageIsLoaded();
        LoginStasPage.fillLoginField("ddddd");
        LoginStasPage.fillPasswordField("568");
        LoginStasPage.pressLoginButton();
        LoginStasPage.waitUntilIsLoadedCustomTime(LoginStasPage.wrongLogin, 40);
        Assert.assertTrue(LoginStasPage.isWrongLogin());
    }

    @Test

    public void positiveLoginTest() {
        driver.get("https://greengnome.github.io/panels/?#/login");
        LoginStasPage.waitForLoginPageIsLoaded();
        LoginStasPage.fillLoginField("admin");
        LoginStasPage.fillPasswordField("12345");
        LoginStasPage.pressLoginButton();
        LoginStasPage.waitUntilIsLoadedCustomTime(CompaniesStasPage.buttonHome, 40);
        Assert.assertTrue(CompaniesStasPage.isButtonHomeDisplay());

        
    }
}


