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

    public CompaniesMarinaPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        //this.nameCompany = nameCompany;
        //this.projectButtonCompany= driver.findElement(By.xpath(".//h2[contains(Text(),"+nameCompany+")]/../..//a)"));
    }

    @FindBy(how = How.TAG_NAME, using = "h1")
    public WebElement header;

    @FindBy(xpath="//h2[contains(text(),"+"Tadiran"+")]/../..//a")
    public WebElement projectButtonTadiran;



    //method
    public void clickProjectButtonCompany(String nameCompany){
        findCompanyProjectButton(nameCompany).click();

    }
    public void clickProjectButtonTadiran(){
        projectButtonTadiran.click();
    }
    public void waitForTadiranProjectLoaded(){
        waitUntilIsLoaded(projectButtonTadiran);
    }

    public void waitForCompanyLoaded(String nameCompany){
        //System.out.println("method waitForCompanyLoaded");
        waitUntilIsLoadedCustomTime(findCompanyProjectButton(nameCompany),30);
        //System.out.println("company is loaded");
    }
    public WebElement findCompanyProjectButton(String nameCompany){
        return driver.findElement(By.xpath("//h2[contains(text(),"+nameCompany+")]/../..//a"));
    }
    //public boolean isCompanyByNameOnCompaniesPage(String nameCompany){
    //    return exists(driver.findElement(By.xpath("//h2[contains(text(),"+nameCompany+")]/../..//a")));
    //}
    public boolean isCompanyOnCompaniesPage(String nameCompany){
        return exists(findCompanyProjectButton(nameCompany));
    }








}
