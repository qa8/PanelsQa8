package com.telran.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by user on 18.02.2017.
 */
public class CompaniesStasPage {
    //tadiranProjectButton
    @FindBy(xpath = "//*[class='mdl-grid']/div[1]//a")
    public WebElement tadiranProjectButton;
    //diklaProjectButton
    @FindBy(xpath = "//*[class='mdl-grid']/div[2]//a")
    public WebElement clalitProjectButton;
    //clalitProjectButton
    @FindBy(xpath = "//*[class='mdl-grid']/div[3]//a")
    public WebElement diklaProjectButton;
}
