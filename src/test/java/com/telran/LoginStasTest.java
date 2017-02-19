package com.telran;

import com.telran.pages.CompaniesStasPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginStasTest extends TestNgTestBase {

    public com.telran.pages.LoginStasPage LoginStasPage;
    public CompaniesStasPage CompaniesStasPage;


    @BeforeMethod
    public void initPageObjects() {
        LoginStasPage = PageFactory.initElements(driver, com.telran.pages.LoginStasPage.class);
        CompaniesStasPage = PageFactory.initElements(driver, CompaniesStasPage.class);
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
}


