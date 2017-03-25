package com.telran.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


/**
 * Sample page
 */
public class MainPaulaPage extends Page {

    @FindBy(how = How.TAG_NAME, using = "h1")
    public WebElement header;

    @FindBy(id = "login")
    WebElement loginField;

    @FindBy(id = "pass")
    WebElement passwordField;

    @FindBy(id = "loginButton")
    WebElement loginButton;

    public MainPaulaPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    //methods
    public void fillLoginField(String text) {
        setElementText(loginField, text);
    }

    public void clickOnLoginButton() {
        clickElement(loginButton);


    }
}
