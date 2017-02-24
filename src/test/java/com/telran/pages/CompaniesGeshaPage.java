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
public class CompaniesGeshaPage extends Page {

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
    public boolean isOnCompaniesPage;
    private boolean onCompaniesPage;

    @FindBy(xpath = "//select[@ng-model='selectedLanguage']")
    public WebElement selectLanguage;


    public CompaniesGeshaPage(WebDriver driver) {
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

    public static void waitForCompaniesPageInLoaded() {
    }
    public boolean isOnCompaniesPage() {
        return onCompaniesPage;
    }
    public void selectEnglishLanguege(){
        selectValueInDropdownbyText(selectLanguage,"English");
    }
    public void SelectLanguageHebrewLanguage(){
        selectValueInDropdownbyText(selectLanguage,"עברית");
    }
}
