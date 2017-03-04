package com.telran.pages;

import com.panel.LogLog4j;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * Sample page
 */
public class LoginMarinaPage extends Page {
    private static Logger Log = Logger.getLogger(LogLog4j.class.getName());

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
        Log.info("Filling login field: "+text);
        this.setElementText(loginField, text);
        return this;
    }

    public LoginMarinaPage fillPassField(String text) {
        Log.info("Filling password field: "+text);
        this.setElementText(passwordField, text);
        return this;
    }

    public LoginMarinaPage clickOnLoginButton() {
        Log.info("Clicking to login button ");
        this.clickElement(loginButton);
        return this;
    }
    public LoginMarinaPage waitForLoginPageIsLoaded() {
        Log.info("Waiting for login page");
        waitUntilIsLoaded(loginButton);
        return this;
    }
    public LoginMarinaPage waitForLoginPageIsLoadedTime50() {
        Log.info("Waiting for login page (time 50)");
        waitUntilIsLoadedCustomTime(loginButton, 50);
        return this;
    }

    public boolean isOnLoginPage(){
        Log.info("Verification: Is on login page (login header exists)");
        return exists(pleaseLogInHeader);
    }
}
