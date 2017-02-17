package com.telran.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * Sample page
 */
public class LoginAnnaPage extends Page {

    @FindBy(how = How.TAG_NAME, using = "h1")

    public WebElement header;

    @FindBy(id = "login")
    public WebElement loginField;

    @FindBy(id = "pass")
    public WebElement passwordField;

    @FindBy(xpath = "//h3[Contains(Text(),'Please log in to continue')]")
    public WebElement pleaseLogInheader;

    @FindBy(xpath = "//p[@ng-bind='alert']")
    // (xpath="//p[Contains(Text(),'wrong login or password')]")
    public WebElement alertWrongLogin;

    @FindBy(id = "button")
    public WebElement loginButton;

    public LoginAnnaPage(WebDriver driver) {
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

    public void pressLoginButton() {
        clickElement(loginButton);
    }

    public void waitForLoginPageLoaded() {
        waitUntilIsLoaded(loginButton);
    }

    public boolean isOnLoginPage() {
        return exists(pleaseLogInheader);
    }

    public boolean isAlertDisplayed() {
        return exists(alertWrongLogin);
    }

    public void isDoubleClicked() {
        Actions act = new Actions(driver);
        // act.doubleClick(driver.findElement(By.xpath("//*[@id = 'button']"))).build().perform();
        act.doubleClick(loginButton).build().perform();
    }

}
