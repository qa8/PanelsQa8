package com.telran.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by user on 18.02.2017.
 */
public class LoginStasPage extends Page {
    @FindBy(how = How.TAG_NAME, using = "h1")
    @CacheLookup
    public WebElement header;
    @FindBy(id = "button")
    public WebElement loginButton;
    @FindBy(xpath = "//p[Contains(Text(),'wrong login or password')]")
    public WebElement pleaseLogInHeader;
    @FindBy(xpath = "//p[@ng-bind='alert']")
    public WebElement wrongLogin;
    @FindBy(id = "login")
    WebElement loginField;
    @FindBy(id = "pass")
    WebElement PassField;
    @FindBy(id = "managementList")
    WebElement managementList;

    public LoginStasPage(WebDriver driver) {
        super(driver);//наследуем от супер-класса
        PageFactory.initElements(driver, this);
    }

    //metods
    public void fillLoginField(String test) {
        setElementText(loginField, test);
    }

    public void fillPasswordField(String test) {
        setElementText(PassField, test);
    }

    public void pressLoginButton() {
        clickElement(loginButton);
    }

    public void waitForLoginPageIsLoaded() {
        waitUntilIsLoadedCustomTime(loginButton, 40);
    }

    //public boolean isOnLoginPage(){        return exists(pleaseLogInHeader);    }

    public boolean isWrongLogin() {
        return exists(wrongLogin);


    }


}




