package com.telran;

import com.telran.pages.CompaniesAllaPage;
import com.telran.pages.LoginAllaPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginAllaTest extends TestNgTestBase {
  private static final String URL_LOG = "https://greengnome.github.io/panels/?#/login";
  private static final String ADM_LOG = "admin";
  private static final String ADM_PSW = "12345";

  public LoginAllaPage loginAllaPage;
  public CompaniesAllaPage companiesAllaPage;

  @BeforeMethod
  public void initPageObjects() {
    loginAllaPage = PageFactory.initElements(driver, LoginAllaPage.class);
    companiesAllaPage = PageFactory.initElements(driver, CompaniesAllaPage.class);
  }

  @Test//incorrect login
  public void negativeLoginTest1() {
    driver.get(URL_LOG);
    loginAllaPage.waitForLoginPageIsLoaded();
    loginAllaPage.fillLoginField("pppp");
    loginAllaPage.fillPasswordField(ADM_PSW);
    loginAllaPage.clickLoginButton();
    loginAllaPage.waitForLoginPageIsLoaded();
    Assert.assertTrue(loginAllaPage.isOnLoginPage());

  }

  @Test//incorrect password
  public void negativeLoginTest2() {
    driver.get(URL_LOG);
    loginAllaPage.waitForLoginPageIsLoaded()
            .fillLoginField(ADM_LOG)
            .fillPasswordField("jij09i")
            .clickLoginButton()
            .waitForLoginPageIsLoaded();
    Assert.assertTrue(loginAllaPage.isOnLoginPage());

  }

  @Test
  public void pozitiveLoginTest() {
    driver.get(URL_LOG);
    loginAllaPage.waitForLoginPageIsLoaded();
    loginAllaPage.fillLoginField(ADM_LOG);
    loginAllaPage.fillPasswordField(ADM_PSW);
    loginAllaPage.clickLoginButton();
    companiesAllaPage.waitForCompaniesPageInLoaded();
    Assert.assertTrue(companiesAllaPage.isOnCompaniesPage());
  }
}
