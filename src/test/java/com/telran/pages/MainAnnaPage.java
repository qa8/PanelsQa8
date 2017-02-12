package com.telran.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Admin on 12-Feb-17.
 */
public class MainAnnaPage extends Page {

    @FindBy(how = How.TAG_NAME, using = "h1")
    @CacheLookup
    public WebElement header;

    @FindBy(id = "managementList")
    public WebElement managementList;

    @FindBy(id = "surveysList")
    public WebElement surveysList;

    @FindBy(id = "reportsList")
    public WebElement reportsList;

    @FindBy(id = "alertsBtn")
    public WebElement alertsButton;

    @FindBy(id = "quit")
    public WebElement logoutButton;


    public MainAnnaPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // @FindBy(class= "mdl-layout-title ng-binding")
    // public WebElement companyButton;


}
