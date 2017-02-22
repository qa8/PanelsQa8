package com.telran.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * Sample page
 */
public class LoginAllaPage extends Page {

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
  public LoginAllaPage fillLoginField(String text) {

    setElementText(loginField, text);
    return this;
  }

  public LoginAllaPage fillPasswordField(String text) {

    setElementText(passwordField, text);
    return this;
  }

  public LoginAllaPage clickLoginButton() {

    clickElement(loginButton);
    return this;
  }

  public LoginAllaPage waitForLoginPageIsLoaded() {
    waitUntilIsLoadedCustomTime(pleaseLogInheader, 40);
    return this;
  }

  public boolean isOnLoginPage() {
    return exists(pleaseLogInheader);
  }
}