package com.telran.pages;


import com.telran.LogLog4j;
import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;


public class CreateCompanyMarinaPage extends  Page {
    private static Logger Log = Logger.getLogger(LogLog4j.class.getName());
    //private String nameCompany="Tadiran";


    // it's better to use array of companies names, instead of nameCompany in constructor
    @FindBy(id = "sample1")
    public WebElement companyName;

    //@FindBy(how = How.TAG_NAME, using = "h1")
   // public WebElement header;
    @FindBy(id = "sample2")
    public WebElement companyOwnerName;
    @FindBy(id = "sample3")
    public WebElement phoneNumber;
    @FindBy(id = "uploadFile")
    public WebElement uploadFile;
    @FindBy(id = "uploadBtn")
    public WebElement uploadLogoButton;

    public CreateCompanyMarinaPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        //this.nameCompany = nameCompany;
        //this.projectButtonCompany= driver.findElement(By.xpath(".//h2[contains(Text(),"+nameCompany+")]/../..//a)"));
    }

    //method
    public CreateCompanyMarinaPage fillCompanyName(String text) {
        Log.info("Filling company name field: "+text);
        this.setElementText(companyName, text);
        return this;
    }
    public CreateCompanyMarinaPage fillCompanyOwnerName(String text) {
        Log.info("Filling company owner name field: "+text);
        this.setElementText(companyOwnerName, text);
        return this;
    }
    public CreateCompanyMarinaPage fillPhoneNumber(String text) {
        Log.info("Filling phone number field: "+text);
        this.setElementText(phoneNumber, text);
        return this;
    }
    //????????????
    public CreateCompanyMarinaPage UploadLogo(String logoFile) throws InterruptedException {
        Log.info("Attaching logo: logoFile");
        uploadLogoButton.click();
        Thread.sleep(1000);
        String myString = "C\\QATools\\logo.png";
        StringSelection stringSelection = new StringSelection(myString);
        Clipboard clpbrd = Toolkit.getDefaultToolkit().getSystemClipboard();
        clpbrd.setContents(stringSelection, null);

        Actions action = new Actions(driver);
        action.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();
        action.sendKeys(Keys.RETURN).perform();
        //????
        //this.setElementText(phoneNumber, text);
        return this;
    }
    //loginTest
    //loginPage
    //CreateCompanyMarinaPage

}
