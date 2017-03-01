package com.telran.pages;

import com.telran.LogLog4j;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


/**
 * Created on 10.02.2017.
 */
public class CompaniesAllaPage extends Page {
    private static Logger Log = Logger.getLogger(LogLog4j.class.getName());
    @FindBy(how = How.TAG_NAME, using = "h1")
    public WebElement header;


    @FindBy(xpath = "//*[@class='adminMenu']")
    public WebElement adminMenuBlock;

    @FindBy(xpath = "//h2[contains(text(),'Tadiran')]/../..//a")
    public WebElement tadiranProjectButton;

    //@FindBy(xpath = "//*[@class='mdl-grid']/div[1]//a")
    //public WebElement tadiranProjectButton;

    @FindBy(xpath = "//select[@ng-model='selectedLanguage']")
    public WebElement selectLanguage;

    @FindBy(xpath = "//span[1][@class='mdl-layout-title ng-binding']")
    public WebElement companyLabel;

    @FindBy(id = "quit")
    public WebElement logoutButton;

    public CompaniesAllaPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    //methods
    public void waitForCompaniesPageInLoaded() {
        Log.info("Waiting for companies page ");
        waitUntilIsLoadedCustomTime(tadiranProjectButton, 40);
    }

    public boolean isOnCompaniesPage() {
        Log.info("Checking that we are in companies page");
        return exists(tadiranProjectButton);
    }

    public void clickTadiranProjectButton() {
        Log.info("Clicking to tadiranProject button ");
        clickElement(tadiranProjectButton);
    }

    public void waitForTadiranProjectLoaded() {
        waitUntilIsLoaded(tadiranProjectButton);
    }
   /* public boolean isOnCompanies(String company){
        return exists(findProjectButtonbyName(company));}*/

    public void selectEnglishLanguage() {
        Log.info("Selecting for english language");
        selectValueInDropdown(selectLanguage, "en");
    }

    public void selecthebrewLanguage() {
        Log.info("Selecting for hebrew language");
        selectValueInDropdown(selectLanguage, "he");
    }

    public boolean languageisEnglish() {
        Log.info("Checking for english language on the page");
        // return companyLabel.getText() == "Companies";
        return verifyTextBoolean(companyLabel, "Companies");
    }

    public boolean languageisHebrew() {
        Log.info("Checking for hebrew language on the page");
        return verifyTextBoolean(companyLabel, "חברות");

    }
    /* public WebElement findProjectButtonbyName(String company) {
       String s = "//h2[contains(Text(),'" + company + "')]/../..//a";
      return driver.findElement(By.xpath(s));}*/
    }

