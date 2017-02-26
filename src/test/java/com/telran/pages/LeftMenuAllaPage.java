package com.telran.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Andrey on 16.02.2017.
 */
public class LeftMenuAllaPage extends Page {
    @FindBy(how = How.TAG_NAME, using = "h1")
    public WebElement header;

    @FindBy(xpath = "//*[@class='adminMenu']")
    public WebElement adminMenuBlock;

    @FindBy(xpath = "//h2[contains (text(), 'Create Company')]")
    public WebElement createCompanyHeader;
    //management Drop-down list
    @FindBy(id = "managementList")
    public WebElement managementButton;

    @FindBy(xpath = "//*[@for='managementList']/li[contains (text(), 'Create Company')]")
    public WebElement createCompanyItem;
    //reports Drop-down list
    @FindBy(id = "reportsList")
    public WebElement reportsButton;
    @FindBy(xpath = "//*[@for='reportsList']/li[contains (text(),'View Reports')]")
    public WebElement viewReportsItem;

    @FindBy(id = "surveysList")
    public WebElement surveysButton;
    //surveys Drop-down list
    @FindBy(xpath = "//*[@for='surveysList']")
    public WebElement surveysList;

    @FindBy(id = "alertsBtn")
    public WebElement alertButton;

    @FindBy(id = "quit")
    public WebElement logoutButton;

    public LeftMenuAllaPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    //methods
    public void waitForleftMenuInLoaded() {
        waitUntilIsLoadedCustomTime(adminMenuBlock, 40);
    }

    public void clickManagementButton() {
        clickElement(managementButton);
    }

    public void clickCreateCompanyItemInDropdownManagement() {
        clickElement(createCompanyItem);
    }

    public void waitForCreateCompanyPageIsDisplayed() {
        waitUntilIsLoaded(createCompanyHeader);
    }

    public boolean isOnCreateCompanyPage() {
        return exists(createCompanyHeader);
    }

    public boolean viewReportsItemIsPresent() {
        return exists(viewReportsItem);
    }

    public void clickLogoutButton() {
        clickElement(logoutButton);
    }

    public void clickViewReportsInDropDownReports() {
        clickElement(viewReportsItem);
    }

    public void clickReportsButton() {
        clickElement(reportsButton);
    }

    public void clickSurveysButton() {
        clickElement(surveysButton);
    }

    public void clickAlertButton() {
        clickElement(alertButton);
    }

}