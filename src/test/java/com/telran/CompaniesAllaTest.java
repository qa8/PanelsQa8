package com.telran;

import com.telran.pages.CompaniesAllaPage;
import com.telran.pages.LoginAllaPage;
import com.telran.pages.TadiranProjectAllaPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CompaniesAllaTest extends TestNgTestBase {

  //private static final String URL_LOG = "https://greengnome.github.io/panels/?#/login";
  private static final String ADM_LOG = "admin";
  private static final String ADM_PSW = "12345";

  public CompaniesAllaPage companiesAllaPage;
  public LoginAllaPage loginAllaPage;
  public TadiranProjectAllaPage tadiranProjectAllaPage;


  @BeforeMethod
  public void initPageObjects() {
    companiesAllaPage = PageFactory.initElements(driver, CompaniesAllaPage.class);
    loginAllaPage = PageFactory.initElements(driver, LoginAllaPage.class);
    tadiranProjectAllaPage = PageFactory.initElements(driver, TadiranProjectAllaPage.class);
    loginAllaPage.login(ADM_LOG, ADM_PSW);
    companiesAllaPage.waitForCompaniesPageInLoaded();
    }
  @Test
  public void tadiranProjectButtonTest() {
    companiesAllaPage.clickTadiranProjectButton();
    tadiranProjectAllaPage.waitForProjectPageIsLoaded();
    Assert.assertTrue(tadiranProjectAllaPage.isOnTadiranProjectPage());
  }
  @Test
  public void homeButtonTest() {
    companiesAllaPage.clickTadiranProjectButton();
    tadiranProjectAllaPage.waitForProjectPageIsLoaded()
            .clickHomeButton();
    companiesAllaPage.waitForCompaniesPageInLoaded();
    Assert.assertTrue(companiesAllaPage.isOnCompaniesPage());
  }
  @Test
  public void selectEnglishLanguageTest() {
    companiesAllaPage.selectEnglishLanguage();
    Assert.assertTrue(companiesAllaPage.languageisEnglish());
  }

  @Test
  public void selectHebrewLanguageTest() {
    companiesAllaPage.selecthebrewLanguage();
    Assert.assertTrue(companiesAllaPage.languageisHebrew());
  }
}