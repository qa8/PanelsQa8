package com.telran.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by user on 18.02.2017.
 */
public class CompaniesStasPage extends Page {

    //tadiranProjectButton
    @FindBy(xpath = "//*[class='mdl-grid']/div[1]//a")
    public WebElement tadiranProjectButton;
    //diklaProjectButton
    @FindBy(xpath = "//*[class='mdl-grid']/div[2]//a")
    public WebElement clalitProjectButton;
    //clalitProjectButton
    @FindBy(xpath = "//*[class='mdl-grid']/div[3]//a")
    public WebElement diklaProjectButton;

    @FindBy(xpath = "//*[@ng-click = 'home()']")
    public WebElement buttonHome;

    public CompaniesStasPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

//methods

    public boolean isButtonHomeDisplay() {
        return exists(buttonHome);
    }
}
