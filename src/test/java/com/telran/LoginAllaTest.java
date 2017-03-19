package com.telran;

import com.telran.pages.CompaniesAllaPage;
import com.telran.pages.LoginAllaPage;
import com.telran.pages.TadiranProjectAllaPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginAllaTest extends TestNgTestBase {
  private static final String URL_LOG = "https://greengnome.github.io/panels";
  private static final String ADM_LOG = "admin";
  private static final String ADM_PSW = "12345";

  public LoginAllaPage loginAllaPage;
  public CompaniesAllaPage companiesAllaPage;
  public TadiranProjectAllaPage tadiranProjectAllaPage;
  @BeforeMethod
  public void initPageObjects() {
    loginAllaPage = PageFactory.initElements(driver, LoginAllaPage.class);
    companiesAllaPage = PageFactory.initElements(driver, CompaniesAllaPage.class);
    tadiranProjectAllaPage = PageFactory.initElements(driver, TadiranProjectAllaPage.class);

  }

  @Test(groups = {"smoke"})
  public void negativeLoginTest1() {
    driver.get(URL_LOG);
    loginAllaPage.waitForLoginPageIsLoaded()
            .fillLoginField("pppp")
            .fillPasswordField(ADM_PSW)
            .clickLoginButton()
            .waitForLoginPageIsLoaded();
    Assert.assertTrue(loginAllaPage.isOnLoginPage());

  }

  @Test(groups = {"smoke"})
  public void negativeLoginTest2() {
    driver.get(URL_LOG);
    loginAllaPage.waitForLoginPageIsLoaded()
            .fillLoginField(ADM_LOG)
            .fillPasswordField("jij09i")
            .clickLoginButton()
            .waitForLoginPageIsLoaded();
    Assert.assertTrue(loginAllaPage.isOnLoginPage());

  }

  @Test(groups = {"smoke, regression"})
  public void pozitiveLoginTest() {
    loginAllaPage.login(ADM_LOG, ADM_PSW);
    companiesAllaPage.waitForCompaniesPageInLoaded();
    Assert.assertTrue(companiesAllaPage.isOnCompaniesPage());
  }

  @Test(dataProviderClass = DataProvidersTadiranAlla.class, dataProvider = "positiveLogin")
  public void positiveLoginTest2(String login, String pass) {
    driver.get(URL_LOG);
    loginAllaPage.waitForLoginPageIsLoaded()
            .fillLoginField(login)
            .fillPasswordField(pass)
            .clickLoginButton();
    tadiranProjectAllaPage.waitForProjectPageIsLoaded();
    Assert.assertTrue(tadiranProjectAllaPage.isOnTadiranProjectPage1("CONDITIONER"));
  }

  @Test(dataProviderClass = DataProviders.class, dataProvider = "negativeAdmin2")
  public void negativeLoginTest(String login, String pass) {
    driver.get(URL_LOG);
    loginAllaPage.waitForLoginPageIsLoaded()
            .fillLoginField(login)
            .fillPasswordField(pass)
            .clickLoginButton();
    loginAllaPage.waitForLoginPageIsLoaded();
    Assert.assertTrue(loginAllaPage.isOnLoginPage());
  }
}
