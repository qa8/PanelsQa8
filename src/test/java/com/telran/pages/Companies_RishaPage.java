package com.telran.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Boss on 11.02.2017.
 */
public class Companies_RishaPage extends LoginIakovPage {
    @FindBy(how = How.TAG_NAME, using = "h1")

    @CacheLookup
    public WebElement header;


    @FindBy(id = "managementList")
    WebElement managemenButton;

    @FindBy(id = "surveysList")
    WebElement surveyButton;


    @FindBy(id = "reportsList")
    WebElement reportsButton;

    @FindBy(id = "alertsBtn")
    WebElement alertsButton;

    @FindBy(id = "quit")
    WebElement quitButton;

    public Companies_RishaPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    //methods

    public void clickOnManagementButton() {
        clickElement(managemenButton);
    }

    public void clickOnSurveysButton() {
        clickElement(surveyButton);
    }

    public void clickOnReportsButton() {
        clickElement(reportsButton);
    }

    public void clickOnAlertsButton() {
        clickElement(alertsButton);
    }

    private void clickOnQuitButton() {
        clickElement(quitButton);
    }
}

