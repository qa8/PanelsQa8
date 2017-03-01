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
public class CreateCompanyAllaPage extends Page {
    private static Logger Log = Logger.getLogger(LogLog4j.class.getName());
    @FindBy(how = How.TAG_NAME, using = "h1")

    public WebElement header;

    @FindBy(xpath = "//div[1]/input[@type='text']")
    public WebElement companyNameField;

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

}
