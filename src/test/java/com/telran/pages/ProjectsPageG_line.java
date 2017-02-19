package com.telran.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Gena on 2/19/2017.
 */
public class ProjectsPageG_line extends Page {

    //ElementsBlock for wait method
    @FindBy(xpath = "//*[@class='mdl-grid']")
    public WebElement projectsBlock;

    @FindBy(id = "reportsList")
    public WebElement reportsButton;

    @FindBy(xpath = "//ul[@for='reportsList']")
    public WebElement reportsList;

    @FindBy(id = "alertsBtn")
    public WebElement alertButton;

    @FindBy(id = "quit")
    public WebElement logOutButton;

    @FindBy(xpath = "//select[@ng-model='selectedLanguage']")
    public WebElement navigationLanguage;

    @FindBy(xpath = "//*[@ng-model='selectedLanguage']")
    public WebElement selectLanguage;

    @FindBy(xpath = "//divb[1]/div/div[2]/a")
    public WebElement showSurveysButtonClalitProject_0;
    @FindBy(xpath = "//divb[2]/div/div[2]/a")
    public WebElement showSurveysButtonClalitProject_1;

    @FindBy(xpath = "//button[@ng-click='home()']")
    public WebElement homePageButton;


    public ProjectsPageG_line(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


    //methods:
    public void waitForProjectsPageInLoaded() {
        waitUntilIsLoadedCustomTime(projectsBlock, 50);
    }

    public boolean isOnCompaniesPage() {
        return exists(projectsBlock);
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

    public void clickLogOutButton() {
        clickElement(logOutButton);
    }

    public void clickHomePageButton() {
        clickElement(homePageButton);
    }

    public void clickShowSurveysButtonClalitProject_0_Button() {
        clickElement(showSurveysButtonClalitProject_0);
    }

    public void clickShowSurveysButtonClalitProject_1_Button() {
        clickElement(showSurveysButtonClalitProject_1);
    }

    public void clickNavigationLanguage() {
        clickElement(navigationLanguage);
    }

    public void selectEnglishLanguage(String value) {
        selectValueInDropdownbyText(selectLanguage, value);
    }

}

