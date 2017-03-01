package com.telran.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CompaniesMarinaPage extends  Page {
    //private String nameCompany="Tadiran";


    // it's better to use array of companies names, instead of nameCompany in constructor

    @FindBy(how = How.TAG_NAME, using = "h1")
    public WebElement header;
    @FindBy(xpath="//h2[contains(text(),'"+"Tadiran"+"')]/../..//a")
    public WebElement projectButtonTadiran;

    public CompaniesMarinaPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        //this.nameCompany = nameCompany;
        //this.projectButtonCompany= driver.findElement(By.xpath(".//h2[contains(Text(),"+nameCompany+")]/../..//a)"));
    }

    //method
    public void clickProjectButtonCompany(String nameCompany){
        findCompanyProjectButton(nameCompany).click();

    }
    public CompaniesMarinaPage clickProjectButtonTadiran(){
        projectButtonTadiran.click();
        return this;
    }
    public CompaniesMarinaPage waitForTadiranProjectLoaded(){
        waitUntilIsLoaded(projectButtonTadiran);
        return this;
    }

    public CompaniesMarinaPage waitForCompanyLoaded(String nameCompany){
        System.out.println("method waitForCompanyLoaded");
        waitUntilIsLoadedCustomTime(findCompanyProjectButton(nameCompany),50);
        System.out.println("company is loaded");
        return this;
    }
    public WebElement findCompanyProjectButton(String nameCompany){

        return driver.findElement(By.xpath("//h2[contains(text(),'"+nameCompany+"')]/../..//a"));
    }

    public boolean isCompanyOnCompaniesPage(String nameCompany){
        return exists(findCompanyProjectButton(nameCompany));
    }

    public String findCompanyProjectButtonText(String nameCompany){

        return driver.findElement(By.xpath("//h2[contains(text(),'"+nameCompany+"')]/../..//b")).getText();
    }
    public boolean isCompanyProjectButtonTextEnglish(String nameCompany){
        return isPureAscii("EN", findCompanyProjectButtonText(nameCompany));
    }
    public boolean isCompanyProjectButtonTextHebrew(String nameCompany){
        return isPureAscii("HE", findCompanyProjectButtonText(nameCompany));
    }








}
