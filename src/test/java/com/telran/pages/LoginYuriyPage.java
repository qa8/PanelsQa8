package com.telran.pages;

/**
 * Created by Comp on 2/19/2017.
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * Sample page
 */
public class LoginYuriyPage extends Page {

    @FindBy(how = How.TAG_NAME, using = "h1")
    @CacheLookup
    public WebElement header;
    @FindBy(id = "login")
    WebElement loginField;

    @FindBy(id = "pass")
    WebElement PassField;

    @FindBy(id = "button")
    WebElement loginButton;


    @FindBy(xpath = "//h3[Contains(Text(),'Please log in to continue')]") // ищет элемент по h3 - локатор и проверяет что на странице есть 'Please log in to continue'
            WebElement pleaseLogInheader;

    @FindBy(xpath = "//*[@id='menu']/main/div/div/div/div[2]/hgroup/h1")
    WebElement WelcomToPanelsText;

    public LoginYuriyPage(WebDriver driver) {
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

    public boolean isOnLoginPage() {
        return exists(loginButton);
    }


}

