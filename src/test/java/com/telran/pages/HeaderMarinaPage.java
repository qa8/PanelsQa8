package com.telran.pages;

import com.telran.LogLog4j;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;


public class HeaderMarinaPage extends Page{
    private static Logger Log = Logger.getLogger(LogLog4j.class.getName());
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
    @FindBy(xpath = ".//*[@class='mdl-layout-title ng-binding'][2]")
    public WebElement projectHeader;


    //methods
    public void chooseHebrewLanguage(){
        Log.info("Choosing hebrew language ");
        selectValueInDropdown(languageSelector,"he");
    }
    public void chooseEnglishLanguage(){
        Log.info("Choosing english language ");
        selectValueInDropdown(languageSelector,"en");
    }

    public void returnToCompanies(){
        Log.info("Go to home ");
        goToHome.click();
    }
    public void waitHeaderIsLoaded(){
        Log.info("Waiting  until header page is loaded ");
        waitUntilIsLoaded(goToHome);
    }
    public Boolean projectHeaderVerification(String projectName)  {
        try {
            waitUntilElementIsLoaded(projectHeader);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //if (exists(projectHeader)){
            Log.info("projectHeader exists and text is:"+projectHeader.getText());
            String str=projectName.toLowerCase();
            Log.info("projectName.toLowerCase():"+str);
            if (projectHeader.getText().toLowerCase().equalsIgnoreCase(projectName))
                return true;
        //}
        return false;
    }

}
