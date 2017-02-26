package com.telran.pages;

import com.telran.LogLog4j;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * Sample page
 */
public class LoginIakovPage extends Page {
  private static Logger Log = Logger.getLogger(LogLog4j.class.getName());

  @FindBy(how = How.TAG_NAME, using = "h1")

  @CacheLookup
  public WebElement header;

  @FindBy(id = "login")
  WebElement loginField;

  @FindBy(id = "pass")
  WebElement PassField;

  @FindBy(id = "button")
  WebElement loginButton;

  @FindBy(id = "managementList")
  WebElement managementList;

  @FindBy(id = "surveysList")
  WebElement surveysList;

  @FindBy(id = "reportsList")
  WebElement reportsListt;

  @FindBy(id = "quit")
  WebElement LogOut;

  @FindBy(xpath = "//h3[Contains(Text(),'Please log in to continue')]") // ищет элемент по h3 - локатор и проверяет что на странице есть 'Please log in to continue'
          WebElement pleaseLogInheader;


  public LoginIakovPage(WebDriver driver) {
    super(driver);//наследуем от супер-класса
    PageFactory.initElements(driver, this);

  }

  //metods
  public void fillLoginField(String test) {
    Log.info("Filling login field with " + test);
    setElementText(loginField, test);
  }

  public void fillPasswordField(String test) {
    Log.info("Filling password field with " + test);
    setElementText(PassField, test);
  }

  public void pressLoginButton() {
    Log.info("Clicking to login button ");
    clickElement(loginButton);
  }

  public void YuriyExpandManagementList() {
    clickElement(managementList);
  }

  public void YuriyTurnManagementList() {
    clickElement(managementList);
  }


  public void waitForLoginPageIsLoaded() {
    Log.info("Waiting for login page");
    waitUntilIsLoadedCustomTime(loginButton, 40);
  }

  public boolean isOnLoginPage() {
    Log.info("Checking that we are in login page");
    return exists(pleaseLogInheader);
  }

  public void login(String username, String password) {
    openloginpage();
    fillLoginField(username);
    fillPasswordField(password);
    pressLoginButton();
  }

  public void openloginpage() {
    driver.get("");
  }
}
