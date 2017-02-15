package com.telran.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CompaniesMarinaPage extends  Page {

    public CompaniesMarinaPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    @FindBy(how = How.TAG_NAME, using = "h1")

    public WebElement header;

    @FindBy(id = "managemenList")
    public WebElement managementList;

    @FindBy(id = "surveysList")
    public WebElement surveysList;

    @FindBy(id = "reportsList")
    public WebElement reportsList;

    @FindBy(id = "alertsBtn")
    public WebElement alertsButton;

    @FindBy(id = "quit")
    public WebElement logout;

    //Question about the companies - do we know what companies have to be here or we don't know(?)

    //methods
    public void selectValueFromManagementList(int value) {
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
        clickElement(logout);
    }




}
