package pages;

import helpers.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import util.BasePage;
import util.DriverFactory;

import java.util.List;


public class insiderQAPage extends BasePage {

    public insiderQAPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(DriverFactory.getDriver(), this);
    }



    private By pageCheck = By.xpath("//a[contains(text(), 'Why Insider')]");
    private By acceptCookies = By.xpath("//a[@id='wt-cli-accept-all-btn']");
    private By companyMenu = By.xpath("//a[contains(text(), 'Company')]");
    private By careersMenu = By.xpath("//a[contains(text(), 'Careers')]");
    private By seeAllTeamsBttn = By.cssSelector(".row .btn.btn-outline-secondary ");
    private By ourLocationsLine = By.xpath("//h3[contains(text(), 'Our Locations')]");
    private By lifeAtInsiderLine = By.xpath("//h2[contains(text(), 'Life at Insider')]");
    private By seeAllQaJobsBttn = By.cssSelector(".button-group .btn.btn-outline-secondary");
    private By filterByLocation = By.xpath("(//span[@class='select2-selection__arrow'])[1]");
    private By chooseLocation = By.xpath("//li[contains(text(),'Istanbul, Turkiye')]");
    private By QATitle = By.xpath("//span[@title='Quality Assurance']");
    private By filterByDepartment = By.xpath("(//span[@class='select2-selection__arrow'])[2]");
    private By chooseDepartment = By.xpath("//li[contains(text(),'Quality Assurance')]");
    private By jobList = By.xpath("//div[@id='jobs-list']/div[1]");
    private By positionTitle = By.cssSelector(".position-title");
    private By positionDepartment = By.cssSelector(".position-department");
    private By positionLocation = By.cssSelector(".position-location");
    private By viewRoleBttn = By.xpath("(//a[contains(text(), 'View Role')])[1]");
    private By leverTitleCheck = By.xpath("//h2");
    private By leverApplyForThisJob = By.cssSelector(".postings-btn-wrapper .template-btn-submit");
    private By leverApplyForThisJob2 = By.linkText("APPLY FOR THIS JOB");





    public void insiderPageCheck( ){
        String WhyInsider = "Why Insider";
        //page opened confirmed
        AssertHelper.assertTextContains(pageCheck, WhyInsider);
        //cookie acceptance button clicked
        ButtonHelper.clickButton(acceptCookies);


    }

    public void companyMenuWay(){
        //Click on the company button in the navigation bar
        ButtonHelper.clickButton(companyMenu);
        //Click on the career button under the company in the navigation bar
        ButtonHelper.clickButton(careersMenu);
        jsHelper.waitForPageLoad();
        //its Locations, Teams, and Life at Insider blocks checked
        ActionsHelper.moveToElement(seeAllTeamsBttn);
        AssertHelper.assertTextContains(seeAllTeamsBttn,"See all teams");
        ActionsHelper.moveToElement(ourLocationsLine);
        AssertHelper.assertTextContains(ourLocationsLine,"Our Locations");
        ActionsHelper.moveToElement(lifeAtInsiderLine);
        AssertHelper.assertTextContains(lifeAtInsiderLine,"Life at Insider");
    }

     public void qaJobsPage(){
        //The specified url was visited
        driver.get("https://useinsider.com/careers/quality-assurance/");
        //the presence of all Qa Jobs buttons is checked and clicked.
        AssertHelper.assertElementIsEnabled(seeAllQaJobsBttn);
        ButtonHelper.clickButton(seeAllQaJobsBttn);
        //Waits until drop down lists are loaded
        WaitHelper.waitForDropdownOptionsToLoad(QATitle, 45);
        //Performs selection in drop down lists
        ButtonHelper.clickButton(filterByLocation);
        RadioButtonHelper.selectRadioButton(chooseLocation);
        ButtonHelper.clickButton(filterByDepartment);
        RadioButtonHelper.selectRadioButton(chooseDepartment);
        //move to the work list tab
        ActionsHelper.moveToElement(jobList);

     }

     public void qaJobsCheck(){
        jsHelper.waitForPageLoad();
        //Waits until text appears
        WaitHelper.waitForText(positionDepartment, "Quality Assurance");
        //Check that all jobs’ Position contains “Quality Assurance”, Department contains “Quality Assurance”, and Location contains “Istanbul, Turkey”
        AssertHelper.assertListEqualsMultipleText(positionTitle, "Quality Assurance" , "QA");
        AssertHelper.assertListEquals(positionDepartment, "Quality Assurance");
        AssertHelper.assertListEquals(positionLocation, "Istanbul, Turkiye");
     }

     public void leverApplicationForm(){
        //Go to the first job in the list and click
        WaitHelper.waitForText(positionDepartment, "Quality Assurance");
        ActionsHelper.hoverOverElement(viewRoleBttn);
        jsHelper.clickElement(viewRoleBttn);
        //Check that you are on the right tab
        BrowserHelper.switchToWindow(1);
         //Check that you are on the right page
        AssertHelper.assertUrlContains("https://jobs.lever.co/useinsider/");
        AssertHelper.assertTextContains(leverTitleCheck,"Senior Software Quality Assurance Engineer");


    }













}