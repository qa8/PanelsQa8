package com.telran.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HeaderMarinaPage extends Page{
    public HeaderMarinaPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    //@FindBy(how = How.TAG_NAME, using = "h1")
   // public WebElement header;

    //language selector defining -----------------
    @FindBy(xpath = "//select[@ng-model='selectedLanguage']")
    public WebElement languageSelector;

    @FindBy(xpath = "//select[@ng-model='selectedLanguage']/option[@value='he']")
    public String hebrewLang;
    @FindBy(xpath = "//select[@ng-model='selectedLanguage']/option[@value='en']")
    public String englishLang;
    @FindBy(xpath = ".//button [@ng-click='home()']")
    public WebElement goToHome;


    //methods
    public void chooseHebrewLanguage(){
        selectValueInDropdown(languageSelector,"he");
    }
    public void chooseEnglishLanguage(){
        selectValueInDropdown(languageSelector,"en");
    }

    public void returnToCompanies(){
        goToHome.click();
    }
    public void waitHeaderIsLoaded(){
        waitUntilIsLoaded(goToHome);
    }

}
