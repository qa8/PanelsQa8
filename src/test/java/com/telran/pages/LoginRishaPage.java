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
public class LoginRishaPage extends Page {

    @FindBy(how = How.TAG_NAME, using = "h1")

    @CacheLookup
    public WebElement header;

    @FindBy(id = "login")
    WebElement loginField;

    @FindBy(id = "pass")
    WebElement passwordField;


    @FindBy(id = "button")
    WebElement loginButton;

    @FindBy(id = "managementList")
    WebElement managementList;

    @FindBy(xpath = "//h3[Contains(Text(),'Please log in to continue')]")
    WebElement pleaseLogInheader;

    @FindBy(id = "surveysList")
    WebElement surveysList;

    @FindBy(id = "reportsList")
    WebElement reportsListt;

    @FindBy(id = "quit")
    WebElement logoutButton;

    public LoginRishaPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    //methods
    public void fillLoginField(String text) {
        setElementText(loginField, text);
    }

    public void fillPasswordField(String text) {
        setElementText(passwordField, text);
    }

    public void clickOnLogButtonField() {
        clickElement(loginButton);
    }

    public void YuriyTurnManagementList() {
        clickElement(managementList);
    }

    public void waitForLoginPageIsLoaded() {
        waitUntilIsLoadedCustomTime(loginButton, 700);
    }

    public boolean isOnLoginPage() {
        return exists(pleaseLogInheader);
    }
}
