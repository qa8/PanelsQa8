package com.telran.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Andrey on 19.02.2017.
 */
public class TadiranProjectAllaPage extends Page {
    @FindBy(how = How.TAG_NAME, using = "h1")
    public WebElement header;

    // home button
    @FindBy(xpath = "//button[@ng-click='home()']")
    public WebElement homeButton;

    @FindBy(xpath = "//h2[contains(text(),'TADIRANPROJECT')]")
    public WebElement tadiranProjectHeader;

    public TadiranProjectAllaPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


    //methods
    public TadiranProjectAllaPage waitForProjectPageIsLoaded() {
        waitUntilIsLoadedCustomTime(tadiranProjectHeader, 40);
        return this;
    }

    public boolean isOnTadiranProjectPage() {
        return exists(tadiranProjectHeader);
    }

    public TadiranProjectAllaPage clickHomeButton() {
        clickElement(homeButton);
        return this;
    }
}
