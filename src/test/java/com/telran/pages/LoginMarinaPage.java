package com.telran.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * Sample page
 */
public class LoginMarinaPage extends Page {

    @FindBy(how = How.TAG_NAME, using = "h1")
    public WebElement header;

    @FindBy(id = "login")
    WebElement loginField;

    @FindBy(id = "pass")
    WebElement passwordField;

    @FindBy(id = "button")
    WebElement loginButton;

    @FindBy(xpath = "//h3[contains(text(),'Please log in to continue')]")
    WebElement pleaseLogInHeader;

    public LoginMarinaPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    //methods
    public LoginMarinaPage fillLoginField(String text) {
        this.setElementText(loginField, text);
        return this;
    }

    public LoginMarinaPage fillPassField(String text) {
        this.setElementText(passwordField, text);
        return this;
    }

    public LoginMarinaPage clickOnLoginButton() {
        this.clickElement(loginButton);
        return this;
    }
    public LoginMarinaPage waitForLoginPageIsLoaded() {
        waitUntilIsLoaded(loginButton);
        return this;
    }
    public LoginMarinaPage waitForLoginPageIsLoadedTime50() {
        waitUntilIsLoadedCustomTime(loginButton, 50);
        return this;
    }

    public boolean isOnLoginPage(){
    return exists(pleaseLogInHeader);
    }
}
