package com.telran.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


/**
 * Created on 10.02.2017.
 */
public class CompaniesAllaPage extends Page {
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

    public CompaniesAllaPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    //methods
    public void waitForCompaniesPageInLoaded() {
        waitUntilIsLoadedCustomTime(tadiranProjectButton, 40);
    }

    public boolean isOnCompaniesPage() {
        return exists(tadiranProjectButton);
    }

    public void clickTadiranProjectButton() {
        clickElement(tadiranProjectButton);
    }

    public void waitForTadiranProjectLoaded() {
        waitUntilIsLoaded(tadiranProjectButton);
    }
   /* public boolean isOnCompanies(String company){
        return exists(findProjectButtonbyName(company));}*/

    public void selectEnglishLanguage() {
        selectValueInDropdown(selectLanguage, "en");
    }

    public void selecthebrewLanguage() {
        selectValueInDropdown(selectLanguage, "he");
    }

    public boolean languageisEnglish() {
        // return companyLabel.getText() == "Companies";
        return verifyTextBoolean(companyLabel, "Companies");
    }

    public boolean languageisHebrew() {
        return verifyTextBoolean(companyLabel, "חברות");

    }
    /* public WebElement findProjectButtonbyName(String company) {
       String s = "//h2[contains(Text(),'" + company + "')]/../..//a";
      return driver.findElement(By.xpath(s));}*/
    }

