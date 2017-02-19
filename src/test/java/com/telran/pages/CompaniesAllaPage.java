package com.telran.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
 * Created on 10.02.2017.
 */
public class CompaniesAllaPage extends Page {


    //ElementsBlock for wait method
    @FindBy(xpath = "//*[@class='adminMenu']")
    public WebElement adminMenuBlock;

    //tadiranProjectButton
    @FindBy(xpath = "//*[contains(@style,'tadiran')]/..//a")
    public WebElement tadiranbyNameProjectButton;

    @FindBy(xpath = "//*[@class='mdl-grid']/div[1]//a")
    public WebElement tadiranProjectButton;

    //diklaProjectButton
    @FindBy(xpath = "//*[@class='mdl-grid']/div[2]//a")
    public WebElement clalitProjectButton;
    //clalitProjectButton
    @FindBy(xpath = "//*[@class='mdl-grid']/div[3]//a")
    public WebElement diklaProjectButton;

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
        waitUntilIsLoadedCustomTime(adminMenuBlock, 40);
    }

    public boolean isOnCompaniesPage() {
        return exists(tadiranProjectButton);
    }

    public void clickTadiranProjectButton() {
        clickElement(tadiranProjectButton);
    }

    public void clickProjectButtonbyName(String company) {
        String s = "//h2[contains(Text(),'" + company + "')]/../..//a";
        driver.findElement(By.xpath(s)).click();
    }

    public void clickClalitProjectButton() {
        clickElement(clalitProjectButton);
    }

    public void clickDiclaProjectButton() {
        clickElement(diklaProjectButton);
    }

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

