package com.telran.pages;


import com.telran.LogLog4j;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


public class ProjectsMarinaPage extends  Page {
    private static final String LIST_PROJECT_LOCATOR ="//div[@class='mdl-grid']/divb";
    private static Logger Log = Logger.getLogger(LogLog4j.class.getName());

    public ProjectsMarinaPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);

    }
    //locator to list of pojects= ".//div[@class="mdl-grid"]/divb"

    @FindBy(how = How.TAG_NAME, using = "h1")
    public WebElement header;

    @FindBy(xpath = LIST_PROJECT_LOCATOR)
    public List<WebElement> projectsList;


    //method

    public WebElement findProjectByName(String projectName){
        //By mySelector = By.xpath(locator);
        //List<WebElement> myElements = driver.findElements(mySelector);
        Log.info("Iterating of projects list and searching required project by text");
        return findWebElementInListByText(projectsList,projectName);
    }

    public int findNumberOfProjectByName(String projectName){
        Log.info("Iterating of projects list and searching required project");
        int i=findNumberInListByText(LIST_PROJECT_LOCATOR,projectName);
        if (i==-1) Log.info("The project was not found in the list.");
        else Log.info("The number of the required project is: "+i);
        return i;
    }
    public ProjectsMarinaPage waitForProjectByNumberIsLoaded(int num){
        Log.info("Waiting for the project #"+num+" and verification that it's loaded");
        waitAndFindWebElement(By.xpath(LIST_PROJECT_LOCATOR+"["+num+"]"));
        return this;
    }
    public boolean isProjectOnProjectsPage(String projectName){
        Log.info("Verification: company exsts - "+projectName);
        return exists(findProjectByName(projectName));
    }
    public int getNumberOfProjects(){
        Log.info("Getting number of projects");
        int num=projectsList.size();
        Log.info("Number of projects: "+num);
        return num;
    }
    public ProjectsMarinaPage clickSurveysButton (String projectName){
        Log.info("Geting the number of required project in projects list");
        int num =findNumberOfProjectByName(projectName);
        Log.info("Number of required project: "+num);
        String locator= LIST_PROJECT_LOCATOR+"["+num+"]"+"//a";
        Log.info("Getting locator for surveys button for require project: "+locator);
        Log.info("Clicking to suveys button");
        driver.findElement(By.xpath(locator)).click();
        return this;
    }



}
