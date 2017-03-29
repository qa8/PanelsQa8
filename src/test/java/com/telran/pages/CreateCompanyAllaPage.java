package com.telran.pages;

import com.telran.LogLog4j;
import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;

/**
 * Created by Andrey on 01.03.2017.
 */
public class CreateCompanyAllaPage extends Page {
    private static Logger Log = Logger.getLogger(LogLog4j.class.getName());
    @FindBy(how = How.TAG_NAME, using = "h1")

    public WebElement header;

    @FindBy(id = "sample1")
    public WebElement companyNameField;

    @FindBy(id = "sample2")
    public WebElement companyOwnerField;

    @FindBy(id = "sample3")
    public WebElement telephoneNumberField;

    @FindBy(xpath = "//form/button")
    public WebElement addCompanyButton;
    @FindBy(id = "uploadBtn")
    public WebElement uploadLogoButton;

    public CreateCompanyAllaPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public CreateCompanyAllaPage clickToCompanyNameField() {
        clickElement(companyNameField);
        return this;
    }

    public CreateCompanyAllaPage fillCompanyNameField(String text) {
        Log.info("Filling company name field");
        setElementText(companyNameField, text);
        return this;
    }

    public CreateCompanyAllaPage fillCompanyOwnerField(String text) {
        Log.info("Filling company owner field");
        setElementText(companyNameField, text);
        return this;
    }

    public CreateCompanyAllaPage fillTelephoneNumberField(String text) {
        Log.info("Filling company owner field");
        setElementText(companyNameField, text);
        return this;
    }

    public CreateCompanyAllaPage clickAddCompanyButton() {
        clickElement(addCompanyButton);
        return this;
    }

    public CreateCompanyAllaPage UploadLogo(String logoFile) throws InterruptedException {
        Log.info("Attaching logo: logoFile");
        uploadLogoButton.click();
        Thread.sleep(1000);

        StringSelection stringSelection = new StringSelection(logoFile);
        Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
        clpbrd.setContents(stringSelection, null);

        Actions action = new Actions(driver);
        action.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();
        action.sendKeys(Keys.RETURN).perform();
        //????
        //this.setElementText(phoneNumber, text);
        return this;
    }
}
