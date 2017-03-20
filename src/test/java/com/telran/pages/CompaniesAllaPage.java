package com.telran.pages;

import com.telran.LogLog4j;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
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


    @FindBy(xpath = "//div[@class='mdl-grid']")
    public WebElement projectButtonText;

    @FindBy(xpath = "//h2[contains(text(),'Tadiran')]/../..//a")
    public WebElement tadiranProjectButton;

    @FindBy(xpath = "//div[@class='mdl-grid']//a")
    public WebElement projectsButtons;

    @FindBy(xpath = "//select[@ng-model='selectedLanguage']")
    public WebElement selectLanguage;

    //for Hebrew
    @FindBy(xpath = "//span[1][@class='mdl-layout-title ng-binding'][text()='חברות']")
    public WebElement companyLabelHebrew;
    //for English
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

    public CompaniesAllaPage waitForCompanyLabelHebrew() {
        Log.info("Waiting for companies page ");
        waitUntilIsLoaded(companyLabelHebrew);
        return this;
    }

    //for Hebrew
    public String getTextFromCompanyLabelHebrew() {
        String w = companyLabelHebrew.getText();
        Log.info("Text found is " + w);
        return w;
    }

    //for English
    public String getTextFromCompanyLabel() {
        String u = companyLabel.getText();
        Log.info("Text found is " + u);
        return u;
    }
    public boolean headerCompanyIsPresent(String companyName) {
        Log.info("verify for company is present on the page");
        return verifyTextBoolean(projectButtonText, companyName);
    }

    public boolean isOnCompaniesPage() {
        Log.info("Checking that we are in companies page");
        return exists(companyLabel);

    }

    public void clickTadiranProjectButton() {
        Log.info("Clicking to tadiranProject button ");
        clickElement(tadiranProjectButton);
        
    }

    public void clickProjectButtonByName(String w) {
        Log.info("Clicking to tadiranProject button ");
        String s = "//h2[contains(text(),'" + w + "')]/../..//a";
        driver.findElement(By.xpath(s)).click();

    }
    public CompaniesAllaPage selectEnglishLanguage() {
        Log.info("Selecting for english language");
        selectValueInDropdown(selectLanguage, "en");
        return this;
    }

    public CompaniesAllaPage selecthebrewLanguage() {
        Log.info("Selecting for hebrew language");
        selectValueInDropdown(selectLanguage, "he");
        return this;
    }

    public boolean languageisEnglish(String d) {
        Log.info("Checking for english language on the page");
        return isPureAscii("en", d);
    }

    public boolean languageisHebrew(String p) {
        Log.info("Checking for hebrew language on the page");
        return isPureAscii("he", p);

    }
    /* public WebElement findProjectButtonbyName(String company) {
       String s = "//h2[contains(Text(),'" + company + "')]/../..//a";
      return driver.findElement(By.xpath(s));}*/
    }

