package com.telran.pages;

import com.telran.LogLog4j;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * Sample page
 */
public class LoginAllaPage extends Page {
  private static Logger Log = Logger.getLogger(LogLog4j.class.getName());
  @FindBy(how = How.TAG_NAME, using = "h1")

  public WebElement header;

  @FindBy(id = "login")
  public WebElement loginField;

  @FindBy(id = "pass")
  public WebElement passwordField;

  @FindBy(id = "button")
  public WebElement loginButton;

  @FindBy(xpath = "//hgroup/h3")
  WebElement pleaseLogInheader;

  public LoginAllaPage(WebDriver driver) {

    super(driver);
    PageFactory.initElements(driver, this);
  }

  //methods
  public LoginAllaPage fillLoginField(String test) {
    Log.info("Filling login field with " + test);
    setElementText(loginField, test);
    return this;
  }

  public LoginAllaPage fillPasswordField(String test) {
    Log.info("Filling password field with " + test);
    setElementText(passwordField, test);
    return this;
  }

  public LoginAllaPage clickLoginButton() {
    Log.info("Clicking to login button ");
    clickElement(loginButton);
    return this;
  }

  public LoginAllaPage waitForLoginPageIsLoaded() {
    Log.info("Waiting for login page");
    waitUntilIsLoadedCustomTime(pleaseLogInheader, 40);
    return this;
  }
  public boolean isOnLoginPage() {
    Log.info("Checking that we are in login page");
    return exists(pleaseLogInheader);
  }

  public void login(String username, String password) {
    openloginpage();
    waitForLoginPageIsLoaded();
    fillLoginField(username);
    fillPasswordField(password);
    clickLoginButton();
  }

  public void openloginpage() {
    driver.get("https://greengnome.github.io/panels");
  }
}