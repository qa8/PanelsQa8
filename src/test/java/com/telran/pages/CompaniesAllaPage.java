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

    public void waitForCompaniesPageInLoaded2() {
        Log.info("Waiting for companies page ");
        waitUntilIsLoadedCustomTime(projectsButtons, 40);
    }

    public String getTextFromBloc() {
        String w = projectButtonText.getText();
        Log.info("Text found is " + w);
        return w;
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
        String s = "//h2[contains (Text(),'" + w + "')]/../..//a";
        driver.findElement(By.xpath(s)).click();

    }
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
        return isPureAscii("en", "Companies");
    }

    public boolean languageisHebrew() {
        Log.info("Checking for hebrew language on the page");
        return isPureAscii("he", "חברות");

    }
    /* public WebElement findProjectButtonbyName(String company) {
       String s = "//h2[contains(Text(),'" + company + "')]/../..//a";
      return driver.findElement(By.xpath(s));}*/
    }

