package com.telran;

import com.telran.pages.*;
import com.telran.util.PropertyLoader;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import ru.stqa.selenium.factory.WebDriverPool;

import java.io.IOException;

/**
 * Base class for TestNG-based test classes
 */
public class TestNgTestBase {

  protected static String gridHubUrl;
  protected static String baseUrl;
  protected static Capabilities capabilities;
  public LoginPaulaPage loginPaulaPage;
  public TadiranProjectAllaPage tadiranProjectAllaPage;
  public CompaniesPaulaPage companiesPaulaPage;
  public LoginAnnaPage loginPage;
  public CompaniesAnna companiesAnna;
  protected WebDriver driver;

  @BeforeSuite(alwaysRun = true)
  public void initTestSuite() throws IOException {
    baseUrl = PropertyLoader.loadProperty("site.url");
    gridHubUrl = PropertyLoader.loadProperty("grid.url");
    if ("".equals(gridHubUrl)) {
      gridHubUrl = null;
    }
    capabilities = PropertyLoader.loadCapabilities();
  }

  @BeforeClass(alwaysRun = true)
  public void initWebDriver() {
    driver = WebDriverPool.DEFAULT.getDriver(gridHubUrl, capabilities);
    companiesPaulaPage = PageFactory.initElements(driver, CompaniesPaulaPage.class);
    loginPaulaPage = PageFactory.initElements(driver, LoginPaulaPage.class);
    tadiranProjectAllaPage = PageFactory.initElements(driver, TadiranProjectAllaPage.class);
    companiesPaulaPage = PageFactory.initElements(driver, CompaniesPaulaPage.class);
    loginPage = PageFactory.initElements(driver, LoginAnnaPage.class);
    companiesAnna = PageFactory.initElements(driver, CompaniesAnna.class);
  }

  @AfterSuite(alwaysRun = true)
  public void tearDown() {
    WebDriverPool.DEFAULT.dismissAll();
  }
}
