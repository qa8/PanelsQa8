package com.telran.pages;

import com.telran.LogLog4j;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Andrey on 01.03.2017.
 */
public class CreateCompanyJulijaPage extends Page {
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

    public CreateCompanyJulijaPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public CreateCompanyJulijaPage clickToCompanyNameField() {
        clickElement(companyNameField);
        return this;
    }

    public CreateCompanyJulijaPage fillCompanyNameField(String text) {
        Log.info("Filling company name field");
        setElementText(companyNameField, text);
        return this;
    }

    public CreateCompanyJulijaPage fillCompanyOwnerField(String text) {
        Log.info("Filling company owner field");
        setElementText(companyNameField, text);
        return this;
    }

    public CreateCompanyJulijaPage fillTelephoneNumberField(String text) {
        Log.info("Filling company owner field");
        setElementText(companyNameField, text);
        return this;
    }

    public CreateCompanyJulijaPage clickAddCompanyButton() {
        clickElement(addCompanyButton);
        return this;
    }

}
