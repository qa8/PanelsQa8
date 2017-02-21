package com.telran.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * Sample page
 */
public class LoginGeshaPage extends Page {

  public static boolean isOnLoginPage;
  //private static WebElement pleaseLogInheader;
  //public static boolean isOnLoginPage;
  @FindBy(how = How.TAG_NAME, using = "h1")
  @CacheLookup
  public WebElement header;

  @FindBy(id = "login")
  WebElement loginField;

  @FindBy(id = "pass")
  WebElement passwordField;

  @FindBy(id = "Loginbutton")
  WebElement loginbutton;

  @FindBy(id = "managementList")
  WebElement managementList;

  @FindBy(id = "surveysList")
  WebElement surveysList;

  @FindBy(id = "reportsList")
  WebElement reportsListt;

  @FindBy(id = "quit")
  WebElement LogOut;

  @FindBy(xpath = "//h3[Contains(Text(),'Please log in to continue')]")
  static // ищет элемент по h3 - локатор и проверяет что на странице есть 'Please log in to continue'
          WebElement pleaseLogInheader;


  public LoginGeshaPage(WebDriver driver) {
    super(driver);//наследуем от супер-класса
    PageFactory.initElements(driver, this);

  }

  //metods
  public void fillLoginField(String test) {
    setElementText(loginField, test);
  }

  public void fillPasswordField(String test) {
    setElementText(passwordField, test);
  }

  public void pressLoginButton() {
    clickElement(loginbutton);
  }

  public void YuriyExpandManagementList() {
    clickElement(managementList);
  }

  public void YuriyTurnManagementList() {
    clickElement(managementList);
  }


  public void waitForLoginPageIsLoaded() {
    waitUntilIsLoadedCustomTime(loginbutton, 25);
  }

  public static boolean isOnLoginPage() {
    return exists(pleaseLogInheader);
  }

  public void clickOnLoginButton() {
  }
}




