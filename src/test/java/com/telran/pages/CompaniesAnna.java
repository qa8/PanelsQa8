package com.telran.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


/**
 * Created on 10.02.2017.
 */
public class CompaniesAnna extends Page {
    @FindBy(how = How.TAG_NAME, using = "h1")
    public WebElement header;

    //    @FindBy(id = "managementList")
    @FindBy(xpath = "//*[@id='managementList']")
    public WebElement managementButton;

    //management Drop-down list
    @FindBy(xpath = "//*[for='managementList']")
    public WebElement managementList;

    @FindBy(xpath = "//*[@class='mdl-layout__drawer-button']")
    public WebElement menuButton;

    @FindBy(id = "surveysList")
    public WebElement surveysButton;
    //surveys Drop-down list
    @FindBy(xpath = "//*[for='surveysList']")
    public WebElement surveysList;

    @FindBy(id = "reportsList")
    public WebElement reportsButton;
    //reports Drop-down list
    @FindBy(xpath = "//*[for='reportsList']")
    public WebElement reportsList;

    @FindBy(id = "alertsBtn")
    public WebElement alertButton;

    @FindBy(id = "quit")
    public WebElement logoutButton;

    //ElementsBlock for wait method
    @FindBy(xpath = "//*[class='adminMenu']")
    public WebElement adminMenuBlock;

    //tadiranProjectButton
    @FindBy(xpath = "//*[class='mdl-grid']/div[1]//a")
    public WebElement tadiranProjectButton;

    //diklaProjectButton
    @FindBy(xpath = "//*[class='mdl-grid']/div[2]//a")
    public WebElement clalitProjectButton;
    //clalitProjectButton

    //@FindBy(xpath = "//*[class='mdl-grid']/div[3]//a")
    @FindBy(xpath = "//h2[contains(text(),'Dikla')]")
    public WebElement diklaProjectButton;

    @FindBy(xpath = "//span[contains(text(),'Companies')]")
    public WebElement companiesButton;

    @FindBy(xpath = "//*[@ng-model='selectedLanguage']")
    public WebElement languageButton;

    @FindBy(xpath = "//*[contains(text(),'חברות')]")
    public WebElement hebrewButton;


    public CompaniesAnna(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    //methods

    public void waitForCompaniesPageInLoaded() {
        waitUntilIsLoaded(adminMenuBlock);
    }
    public void clickManagementButton() {
        clickElement(managementButton);
    }
    public void selectValueInDropdownManagement(String value) {
        selectValueInDropdownbyText(managementList, value);
    }

    public void clickSurveysButton() {
        clickElement(surveysButton);
    }

    public void selectValueInDropdownSurveys(String value) {
        selectValueInDropdownbyText(surveysList, value);
    }

    public void clickReportsButton() {
        clickElement(reportsButton);
    }

    public void selectValueInDropdownReports(String value) {
        selectValueInDropdownbyText(reportsList, value);
    }

    public void clickAlertButton() {
        clickElement(alertButton);
    }

    public void clickTadiranProjectButton() {
        clickElement(tadiranProjectButton);
    }

    public void clickClalitProjectButton() {
        clickElement(clalitProjectButton);
    }

    public void clickDiclaProjectButton() {
        clickElement(diklaProjectButton);
    }

    public void clickTadiranbyNameProjectButton(String company) {
        String s = "//h2[contains(Text(),'\" + company + \"')]/../..//a";
        driver.findElement(By.xpath(s)).click();
    }

    public boolean isManagementButtonDisplayed() {
        return exists(managementButton);
    }

    public boolean isManagementButtonPresent() {
        return verifyElementIsPresent(managementButton);
    }

    public boolean isDiklaProgectPresent() {
        return verifyElementIsPresent(diklaProjectButton);
    }

    public boolean isCompaniesButtonPresent() {
        return verifyElementIsPresent(companiesButton);
    }

    public boolean isTadiranProjectPresent() {
        return verifyElementIsPresent(tadiranProjectButton);
    }

    public boolean isMenuButtonDisplayed() {
        return exists(menuButton);
    }

    public void pressLogoutButton() {
        clickElement(logoutButton);
    }

    public void chooseLanguage() {
        selectValueInDropdown(languageButton, "he");

    }

    public boolean changedLanguage() {
        return exists(hebrewButton);
    }
}

