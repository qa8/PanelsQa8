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
public class MainStasPagee extends Page {

  @FindBy(how = How.TAG_NAME, using = "h1")
  @CacheLookup
  public WebElement header;

  @FindBy(id="login")
  public WebElement loginField;

  @FindBy(id="pass")
  public WebElement passField;

  @FindBy(id = "loginButton")
  public WebElement loginButton;

  public MainStasPagee(WebDriver driver) {
    super(driver);
    PageFactory.initElements(driver, this);
  }

  //methods
  //vvodit text v loginfield
  public void fillLoginField(String text){
    setElementText(loginField, text);
   }
  //vvodit text v password
  public void fillPassField(String text){
    setElementText(passField, text);
  }

  //press on the loginButton
  public void clickOnLoginButton() {
    clickElement(loginButton);
  }



}
