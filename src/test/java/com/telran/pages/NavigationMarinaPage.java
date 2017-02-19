package com.telran.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class NavigationMarinaPage extends Page{
    public NavigationMarinaPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    //@FindBy(how = How.TAG_NAME, using = "h1")
   // public WebElement header;

   // managementList defining----------------
    @FindBy(id = "managementList")
    public WebElement managementList;

    @FindBy(xpath = "//*[@for='managementList']/li[@ui-sref=\"createcompany\"]")
    public WebElement managementListCreateCompany;
    @FindBy(xpath = "//*[@for='managementList']/li[@ui-sref=\"createproject\"]")
    public WebElement managementListCreateProject;
    @FindBy(xpath = "//*[@for='managementList']/li[3]")
    public WebElement managementListEditCompany;
    @FindBy(xpath = "//*[@for='managementList']/li[4]")
    public WebElement managementListEditProject;

    //surveyList defining-----------------------
    @FindBy(id = "surveysList")
    public WebElement surveysList;
    @FindBy(xpath = "//*[@for='surveysList']/li[1]")
    public WebElement surveysListCreateSurvey;
    @FindBy(xpath = "//*[@for='surveysList']/li[2]")
    public WebElement surveysListEditSurvey;

    //reportList defining----------------------
    @FindBy(id = "reportsList")
    public WebElement reportsList;
    @FindBy(xpath = "//*[@for='reportList']/li[1]")
    public WebElement reportsListCreateReport;
    @FindBy(xpath = "//*[@for='reportList']/li[2]")
    public WebElement reportsListEditReport;

    //alerts button defining-----------------------
    @FindBy(id = "alertsBtn")
    public WebElement alertsButton;

    //logout button deining-------------------------
    @FindBy(id = "quit")
    public WebElement logoutButton;

    //language selector defining -----------------
    @FindBy(xpath = "//select[@ng-model='selectedLanguage']")
    public WebElement languageSelector;

    //methods
    public void clickEditCompany() {
        managementList.click();
        try {
            wait(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        managementListEditCompany.click();


    }

    public void clickMenuManagement() {
        //select from dropDownList, container for="managementList"

    }

    public void selectValueFromSurveysList(int value) {
        //select from dropDownList
    }
    public void selectValueFromReportsList(int value) {
        //select from dropDownList
    }
    public void clickOnAlertsButton() {
        clickElement(alertsButton);
    }
    public void clickOnLogoutButton() {
        clickElement(logoutButton);
    }
    public void chooseEngishLanguage(){
        languageSelector.click();
        selectValueInDropdownbyText(languageSelector,"English");
    }
    public void chooseHebrewLanguage(){
        selectValueInDropdownbyText(languageSelector,"עברית");
    }

    public void waitManagementListIsLoaded(){
        waitUntilIsLoaded(managementList);
        waitUntilIsLoaded(managementListCreateCompany);
        waitUntilIsLoaded(managementListCreateProject);
        waitUntilIsLoaded(managementListEditCompany);
        waitUntilIsLoaded(managementListEditProject);
    }

    public void waitSurveyListIsLoaded(){
        waitUntilIsLoaded(surveysList);
        waitUntilIsLoaded(surveysListCreateSurvey);
        waitUntilIsLoaded(surveysListEditSurvey);
    }
    public void waitReportListIsLoaded(){
        waitUntilIsLoaded(reportsList);
        waitUntilIsLoaded(reportsListCreateReport);
        waitUntilIsLoaded(reportsListEditReport);
    }
    public void waitAlertsIsLoaded(){
        waitUntilIsLoaded(alertsButton);
    }
    public void waitLogoutIsLoaded(){
        waitUntilIsLoaded(logoutButton);
    }


}
