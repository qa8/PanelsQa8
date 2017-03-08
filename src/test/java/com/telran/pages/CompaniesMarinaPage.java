package com.telran.pages;


import com.telran.LogLog4j;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class CompaniesMarinaPage extends  Page {
    private static Logger Log = Logger.getLogger(LogLog4j.class.getName());
    //private String nameCompany="Tadiran";


    // it's better to use array of companies names, instead of nameCompany in constructor

    public CompaniesMarinaPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        //this.nameCompany = nameCompany;
        //this.projectButtonCompany= driver.findElement(By.xpath(".//h2[contains(Text(),"+nameCompany+")]/../..//a)"));
    }

    @FindBy(how = How.TAG_NAME, using = "h1")
    public WebElement header;

    @FindBy(xpath = "//h2[contains(text(),'" + "Tadiran" + "')]/../..//a")
    public WebElement projectButtonTadiran;


    //method
    public void clickProjectButtonCompany(String nameCompany) {
        Log.info("Click to project button, company - " + nameCompany);
        findCompanyProjectButton(nameCompany).click();

    }

    public CompaniesMarinaPage clickProjectButtonTadiran() {
        Log.info("Click to Tadiran project button");
        projectButtonTadiran.click();
        return this;
    }

    public CompaniesMarinaPage waitForTadiranProjectLoaded() {
        Log.info("Waiting until Tadiran company is loaded");
        waitUntilIsLoaded(projectButtonTadiran);
        return this;
    }

    public CompaniesMarinaPage waitForCompanyLoaded(String nameCompany) {
        Log.info("Waiting until company is loaded (time 50) - " + nameCompany);
        //System.out.println("method waitForCompanyLoaded");
        waitUntilIsLoadedCustomTime(findCompanyProjectButton(nameCompany), 50);
        //System.out.println("company is loaded");
        return this;
    }
    public CompaniesMarinaPage waitForCompanyLoadedByName(String nameCompany){
        String locator = "//h2[contains(text(),'"+nameCompany+"')]/../..//b";
        waitAndFindWebElement(By.xpath(locator));
        return this;
    }

    public WebElement findCompanyProjectButton(String nameCompany){
        Log.info("Finding company - "+nameCompany);
        return driver.findElement(By.xpath("//h2[contains(text(),'"+nameCompany+"')]/../..//a"));
    }

    public boolean isCompanyOnCompaniesPage(String nameCompany){
        Log.info("Verification: company exsts - "+nameCompany);
        return exists(findCompanyProjectButton(nameCompany));
    }

    public String findCompanyProjectButtonText(String nameCompany){
        Log.info("Receiving text of company project button - "+nameCompany);
        return driver.findElement(By.xpath("//h2[contains(text(),'"+nameCompany+"')]/../..//b")).getText();
    }
    public boolean isCompanyProjectButtonTextEnglish(String nameCompany){
        Log.info("Verification: project button text - EN - "+nameCompany);
        return isPureAscii("EN", findCompanyProjectButtonText(nameCompany));
    }
    public boolean isCompanyProjectButtonTextHebrew(String nameCompany){
        Log.info("Verification: project button text - HE - "+nameCompany);
        return isPureAscii("HE", findCompanyProjectButtonText(nameCompany));
    }









}
