package com.telran.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Gena on 2/19/2017.
 */
public class LoginPageG_line extends Page {

    @FindBy(how = How.TAG_NAME, using = "h1")
    public WebElement header;

    @FindBy(xpath = "//select[@ng-model='selectedLanguage']")
    public WebElement navigationLanguage;

    @FindBy(xpath = "//option[@value='en']")
    public WebDriver selectLanguage_En;

    @FindBy(xpath = "//option[@value='he']")
    public WebDriver selectLanguage_He;

    @FindBy(xpath = "//h1[Contains(Text(),'Welcome to Panels inc.')]")
    public WebElement welcomeToPanels_h1;

    @FindBy(xpath = "//h3[Contains(Text(),'Please log in to continue')]")
    public WebElement pleaseLogIn_h3;

    @FindBy(id = "login")
    public WebElement loginField;

    @FindBy(id = "pass")
    public WebElement passField;

    @FindBy(id = "button")
    public WebElement loginButton;

    public LoginPageG_line(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
// methods:

    public void fillLoginField(String text) {
        this.setElementText(loginField, text);
    }

    public void fillPassField(String text) {
        this.setElementText(passField, text);
    }

    public void clickLoginButton() {
        this.clickElement(loginButton);
    }

    public void waitForLoginPageIsLoaded() {
        waitUntilIsLoaded(loginButton);
    }

    public void waitForLoginPageIsLoaded50() {
        waitUntilIsLoadedCustomTime(loginButton, 50);
    }

    public boolean loginPageIsOn() {
        return exists(welcomeToPanels_h1);
    }
}
