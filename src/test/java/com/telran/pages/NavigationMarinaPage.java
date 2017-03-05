package com.telran.pages;

import com.telran.LogLog4j;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class NavigationMarinaPage extends Page{
    private static Logger Log = Logger.getLogger(LogLog4j.class.getName());
    public NavigationMarinaPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    //@FindBy(how = How.TAG_NAME, using = "h1")
   // public WebElement header;

   // managementList defining----------------
    @FindBy(id = "managementList")
    public WebElement managementList;

    @FindBy(xpath = "//*[@for='managementList']/li[@ui-sref='createcompany']")
    public WebElement managementListCreateCompany;
    @FindBy(xpath = "//*[@for='managementList']/li[@ui-sref='createproject']")
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
    @FindBy(xpath = "//*[@for='reportsList']/li[1]")
    public WebElement reportsViewReports;
    @FindBy(xpath = "//*[@for='reportsList']/li[2]")
    public WebElement reportsExportReports;

    //alerts button defining-----------------------
    @FindBy(id = "alertsBtn")
    public WebElement alertsButton;

    //logout button deining-------------------------
    @FindBy(id = "quit")
    public WebElement logoutButton;


// Menu Management - methods
    //Menu Management element
    public void waitManagementListIsLoaded(){
        Log.info("Waiting for management menu and points are loaded");
        waitUntilIsLoaded(managementList);
        waitUntilIsLoaded(managementListCreateCompany);
        waitUntilIsLoaded(managementListCreateProject);
        waitUntilIsLoaded(managementListEditCompany);
        waitUntilIsLoaded(managementListEditProject);
    }
    public void waitManagementListIsLoadedTime50(){
        Log.info("Waiting for management menu  (time 50)");
        waitUntilIsLoadedCustomTime(managementList,50);
    }

    public NavigationMarinaPage clickMenuManagement() {
        Log.info("Click to  management menu and waiting until all points are loaded ");
        this.managementList.click();
        this.waitManagementListIsLoaded();
        return this;
    }
    public NavigationMarinaPage clickCloseMenuManagement() {
        Log.info("Click to  management menu (without waiting for loading)");
        this.managementList.click();
        return this;
    }
    public boolean isMenuManagementOnLanguage(String language) {
        Log.info("Verification: text of menu management is on "+language);
        String text = this.managementList.getText();
        String menuManagementText = text.replaceAll(driver.findElement(By.xpath("//*[@id='managementList']/i")).getText(),"");
        //System.out.println("isMenuManagementOnLanguage: "+menuManagementText);
       // System.out.println("isMenuManagementOnLanguage: "+language);
        return isPureAscii(language,menuManagementText);
    }
    //Management - Create Company element
    public NavigationMarinaPage clickCreateCompanyManagement(){
        Log.info("Click to  create company in menu management");
        this.managementListCreateCompany.click();
        return this;
    }
    public boolean isCreateCompanyManagementOnLanguage(String language){
        Log.info("Verification: text of create company button in menu management is on "+language);
        return isPureAscii(language,this.managementListCreateCompany.getText());
    }
    //Management - Create Project element
    public NavigationMarinaPage clickCreateProjectManagement(){
        this.managementListCreateProject.click();
        return this;
    }
    public boolean isCreateProjectManagementOnLanguage(String language){
        Log.info("Verification: text of create project button in menu management is on "+language);
        return isPureAscii(language,this.managementListCreateProject.getText());
    }
    //Management - Edit Company element
    public NavigationMarinaPage clickEditCompanyManagement(){
        Log.info("Click to  edit company in menu management)");
        this.managementListEditCompany.click();
        return this;
    }
    public boolean isEditCompanyManagementOnLanguage(String language){
        Log.info("Verification: text of edit company button in menu management - "+language);
        return isPureAscii(language,this.managementListEditCompany.getText());
    }
    //Management - Edit Project element
    public NavigationMarinaPage clickEditProjectManagement(){
        Log.info("Click to  edit project in menu management");
        this.managementListEditProject.click();
        return this;
    }
    public boolean isEditProjectOnLanguage(String language){
        Log.info("Verification: text of edit project button in menu management - "+language);
        return isPureAscii(language,this.managementListEditProject.getText());
    }


// Menu Survey -methods
    //Menu Survey
    public NavigationMarinaPage clickMenuSurveys() {
        Log.info("Click to  menu surveys and waiting for until all points are leaded ");
        this.surveysList.click();
        this.waitSurveysListIsLoaded();
        return this;
    }
    public NavigationMarinaPage clickCloseMenuSurveys() {
        Log.info("Click to  menu surveys (without waiting for loading)");
        this.surveysList.click();
        return this;
    }
    public NavigationMarinaPage waitSurveysListIsLoaded(){
        Log.info("Waiting for menu surveys and all points are loaded");
        waitUntilIsLoaded(surveysList);
        waitUntilIsLoaded(surveysListCreateSurvey);
        waitUntilIsLoaded(surveysListEditSurvey);
        return this;
    }

    public boolean isMenuSurveysOnLanguage(String language){
        Log.info("Verification: text of menu surveys is on "+language);
        String text = this.surveysList.getText();
        String menuSurveysText = text.replaceAll(driver.findElement(By.xpath("//*[@id='surveysList']/i")).getText(),"");
        //System.out.println("isMenuManagementOnLanguage: "+menuManagementText);
        // System.out.println("isMenuManagementOnLanguage: "+language);
        return isPureAscii(language,menuSurveysText);
    }
    //Surveys - Create Survey
    public NavigationMarinaPage clickCreateSurvey() {
        Log.info("Click to  create survey in menu management");
        this.surveysListCreateSurvey.click();
        return this;
    }
    public boolean isCreateSurveyOnLanguage(String language){
        Log.info("Verification: text of create surveys in menu surveys is on "+language);
        return isPureAscii(language,this.surveysListCreateSurvey.getText());
    }
    //Surveys - Edit Survey
    public NavigationMarinaPage clickEditSurvey() {
        Log.info("Click to  edit survey in menu management");
        this.surveysListEditSurvey.click();
        return this;
    }
    public boolean isEditSurveyOnLanguage(String language){
        Log.info("Verification: text of edit survey in menu surveys is on "+language);
        return isPureAscii(language,this.surveysListEditSurvey.getText());
    }

    //Report List
      // Menu Reports
    public NavigationMarinaPage clickMenuReports() {
        Log.info("Click to  menu reports and waiting for until all points are loaded");
        this.reportsList.click();
        this.waitReportsListIsLoaded();
        return this;
    }
    public NavigationMarinaPage clickCloseMenuReports() {
        Log.info("Click to  menu reports (without waiting for loading)");
        this.reportsList.click();
        return this;
    }
    public NavigationMarinaPage waitReportsListIsLoaded(){
        Log.info("Waiting for until menu reports and all points are leaded");
        waitUntilIsLoaded(reportsList);
        waitUntilIsLoaded(reportsViewReports);
        waitUntilIsLoaded(reportsExportReports);
        return this;
    }

    public boolean isMenuReportsOnLanguage(String language){
        Log.info("Verification: text of menu reports is on "+language);
        String text = this.reportsList.getText();
        String menuReportsText = text.replaceAll(driver.findElement(By.xpath("//*[@id='reportsList']/i")).getText(),"");
        return isPureAscii(language,menuReportsText);
    }
    //Reports - View Reports
    public NavigationMarinaPage clickViewReports() {
        Log.info("Click to view reports in menu reports option)");
        this.reportsViewReports.click();
        return this;
    }
    public boolean isViewReportsOnLanguage(String language){
        Log.info("Verification: text of view reports in menu reports is on "+language);
        return isPureAscii(language,this.reportsViewReports.getText());
    }
    //Reports - Export Reports
    public NavigationMarinaPage clickExportReports() {
        Log.info("Click to export reports option in menu reports)");
        this.reportsExportReports.click();
        return this;
    }
    public boolean isExportReportsOnLanguage(String language){
        Log.info("Verification: text of export reports in menu reports is on "+language);
        return isPureAscii(language,this.reportsExportReports.getText());
    }
    // Menu Alerts
    public boolean isMenuAlertsOnLanguage(String language){
        Log.info("Verification: text of alerts button is on "+language);
        String text = this.alertsButton.getText();
        String menuAlertsText = text.replaceAll(driver.findElement(By.xpath("//*[@id='alertsBtn']/i")).getText(),"");
        return isPureAscii(language,menuAlertsText);
    }
    public void clickOnAlertsButton() {
        Log.info("Click to alerts button)");
        clickElement(alertsButton);
    }

    //Logout Button
    public void clickOnLogoutButton() {
        clickElement(logoutButton);
    }
    public boolean isLogoutButtonOnLanguage(String language){
        Log.info("Verification: text of logout button is on "+language);
        String text = this.logoutButton.getText();
        String logoutButtonText = text.replaceAll(driver.findElement(By.xpath("//*[@id='quit']/i")).getText(),"");
        return isPureAscii(language,logoutButtonText);
    }
   /* public void chooseEngishLanguage(){
        languageSelector.click();
        selectValueInDropdownbyText(languageSelector,englishLang);
    }
    public void chooseHebrewLanguage(){
        selectValueInDropdownbyText(languageSelector,hebrewLang);
    }*/


    public void waitAlertsIsLoaded(){
        waitUntilIsLoaded(alertsButton);
    }
    public void waitLogoutIsLoaded(){
        waitUntilIsLoaded(logoutButton);
    }


}
