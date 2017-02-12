package com.telran.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by G_Lab on 2/11/2017.
 */
public class CompaniesGennadyPage extends Page {

    @FindBy(how = How.TAG_NAME, using = "h1")
    @CacheLookup
    public WebElement header;

    @FindBy(id = "managementList")
    WebElement managementListButton;

    @FindBy(id = "surveysList")
    WebElement surveysListButton;

    @FindBy(id = "reportsList")
    WebElement reportsListButton;

    @FindBy(id = "alertsBtn")
    WebElement alertsBtnButton;

    @FindBy(id = "quit")
    WebElement quitButton;


    public CompaniesGennadyPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


    public void clickOnManagementListButton() {
        clickElement(managementListButton);

    }

    public void clickOnSurveysListButton() {
        clickElement(surveysListButton);
    }

    public void clickOnReportsListButton() {
        clickElement(reportsListButton);
    }

    public void clickOnAlertsBtnButton() {
        clickElement(alertsBtnButton);
    }

    public void clickOnQuitButton() {
        clickElement(quitButton);
    }
}
