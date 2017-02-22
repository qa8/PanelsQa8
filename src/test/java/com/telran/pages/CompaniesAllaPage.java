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


    //@FindBy(xpath = "//*[@class='adminMenu']")
    //public WebElement adminMenuBlock;

    @FindBy(xpath = "//h2[contains(text(),'Tadiran')]/../..//a")
    public WebElement tadiranProjectButton;


    //@FindBy(xpath = "//*[@class='mdl-grid']/div[1]//a")
    //public WebElement tadiranProjectButton;


    @FindBy(xpath = "//select[@ng-model='selectedLanguage']")
    public WebElement selectLanguage;

    @FindBy(xpath = "//select[@ng-model='selectedLanguage']/option[1]")
    public WebElement selectEnglishLanguage;

    @FindBy(xpath = "//select[@ng-model='selectedLanguage']/option[2]")
    public WebElement selectHebrewLanguage;


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

    // public WebElement findCompanyProjectButton(String company) {
    // return driver.findElement(By.xpath("//h2[Contains(Text(),"+ company +")]/../..//a"));}


    public void selectEnglishLanguage() {
        selectValueInDropdownbyText(selectLanguage, "English");
    }

    public boolean englishLanguageIsSelected() {
        return exists(selectEnglishLanguage);
    }
    public void selecthebrewLanguage() {
        selectValueInDropdownbyText(selectLanguage, "עברית");
    }

    public boolean hebrewLanguageIsSelected() {
        return exists(selectHebrewLanguage);
    }
    }

