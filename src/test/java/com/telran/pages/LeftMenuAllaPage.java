package com.telran.pages;

import com.telran.LogLog4j;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Andrey on 16.02.2017.
 */
public class LeftMenuAllaPage extends Page {
    private static Logger Log = Logger.getLogger(LogLog4j.class.getName());
    @FindBy(how = How.TAG_NAME, using = "h1")
    public WebElement header;
    @FindBy(xpath = "//div[@class='mdl-layout__drawer-button']")
    public WebElement topMenuButton;

    @FindBy(xpath = "//div[@class='mdl-layout__drawer'][@aria-hidden='false']")
    public WebElement leftMenuVisible;

    @FindBy(xpath = "//div[@class='mdl-layout__drawer'][@aria-hidden='true']")
    public WebElement leftMenuHidden;

    @FindBy(xpath = "//*[@class='mdl-grid']")
    public WebElement page;

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
    public LeftMenuAllaPage clickOnTopMenuButton() {
        Log.info("Clicking left menu top-button");
        if (!exists(managementButton)) {
            clickElement(topMenuButton);
        }
        return this;
    }

    public LeftMenuAllaPage waitForleftMenuInLoaded() {
        Log.info("Waiting for left menu load");
        waitUntilIsLoaded(adminMenuBlock);
        return this;
    }

    public LeftMenuAllaPage clickManagementButton() {
        Log.info("Clicking to management button");
        clickElement(managementButton);
        return this;
    }

    public LeftMenuAllaPage clickCreateCompanyItemInDropdownManagement() {
        Log.info("Clicking to create company item");
        clickElement(createCompanyItem);
        return this;
    }

    public LeftMenuAllaPage waitForCreateCompanyPageIsDisplayed() {
        Log.info("Waiting for create company page");
        waitUntilIsLoaded(createCompanyHeader);
        return this;
    }

    public boolean isOnCreateCompanyPage() {
        Log.info("Checking that we are in create company page");
        return exists(createCompanyHeader);
    }

    public boolean viewReportsItemIsPresent() {
        Log.info("Checking that view reports item is present in drop-down");
        return exists(viewReportsItem);
    }

    public LeftMenuAllaPage clickLogoutButton() {
        Log.info("Clicking to logout button");
        clickElement(logoutButton);
        return this;
    }

    public void clickViewReportsInDropDownReports() {
        clickElement(viewReportsItem);
    }

    public LeftMenuAllaPage clickReportsButton() {
        Log.info("Clicking to reports button");
        clickElement(reportsButton);
        return this;
    }

    public void clickSurveysButton() {
        clickElement(surveysButton);
    }

    public void clickAlertButton() {
        clickElement(alertButton);
    }

}