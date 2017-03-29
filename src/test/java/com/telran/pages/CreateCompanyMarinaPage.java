package com.telran.pages;


import com.telran.LogLog4j;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CreateCompanyMarinaPage extends  Page {
    private static Logger Log = Logger.getLogger(LogLog4j.class.getName());
    //private String nameCompany="Tadiran";


    // it's better to use array of companies names, instead of nameCompany in constructor

    public CreateCompanyMarinaPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        //this.nameCompany = nameCompany;
        //this.projectButtonCompany= driver.findElement(By.xpath(".//h2[contains(Text(),"+nameCompany+")]/../..//a)"));
    }

    //@FindBy(how = How.TAG_NAME, using = "h1")
   // public WebElement header;

    @FindBy(id = "sample1")
    public WebElement companyName;

    @FindBy(id = "sample2")
    public WebElement companyOwnerName;

    @FindBy(id = "sample3")
    public WebElement phoneNumber;

    @FindBy(id = "uploadFile")
    public WebElement uploadFile;

    @FindBy(id = "uploadBtn")
    public WebElement uploadLogoButton;


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
    public CreateCompanyMarinaPage UploadLogo(String logoFile) {
        Log.info("Attaching logo: logoFile");
        uploadLogoButton.click();
        //????
        //this.setElementText(phoneNumber, text);
        return this;
    }
    //loginTest
    //loginPage
    //CreateCompanyMarinaPage

}
