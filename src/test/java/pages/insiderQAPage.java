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
        AssertHelper.assertTextContains(pageCheck, WhyInsider); //sayfanın açıldığı teyit edildi
        ButtonHelper.clickButton(acceptCookies);    //cookie kabul butonuna tıklandı

    }

    public void companyMenuWay(){
        ButtonHelper.clickButton(companyMenu);
        ButtonHelper.clickButton(careersMenu);
        jsHelper.waitForPageLoad();
        ActionsHelper.moveToElement(seeAllTeamsBttn);
        AssertHelper.assertTextContains(seeAllTeamsBttn,"See all teams");
        ActionsHelper.moveToElement(ourLocationsLine);
        AssertHelper.assertTextContains(ourLocationsLine,"Our Locations");
        ActionsHelper.moveToElement(lifeAtInsiderLine);
        AssertHelper.assertTextContains(lifeAtInsiderLine,"Life at Insider");
    }

     public void qaJobsPage(){
        driver.get("https://useinsider.com/careers/quality-assurance/");
        AssertHelper.assertElementIsEnabled(seeAllQaJobsBttn);
        ButtonHelper.clickButton(seeAllQaJobsBttn);
        WaitHelper.waitForDropdownOptionsToLoad(QATitle, 30);
        ButtonHelper.clickButton(filterByLocation);
        RadioButtonHelper.selectRadioButton(chooseLocation);
        ButtonHelper.clickButton(filterByDepartment);
        RadioButtonHelper.selectRadioButton(chooseDepartment);
        ActionsHelper.moveToElement(jobList);

     }

     public void qaJobsCheck(){
        jsHelper.waitForPageLoad();
        WaitHelper.waitForText(positionDepartment, "Quality Assurance");
        AssertHelper.assertListEqualsMultipleText(positionTitle, "Quality Assurance" , "QA");
        AssertHelper.assertListEquals(positionDepartment, "Quality Assurance");
        AssertHelper.assertListEquals(positionLocation, "Istanbul, Turkiye");
     }

     public void leverApplicationForm(){
        WaitHelper.waitForText(positionDepartment, "Quality Assurance");
        ActionsHelper.hoverOverElement(viewRoleBttn);
        jsHelper.clickElement(viewRoleBttn);
        BrowserHelper.switchToWindow(1);
        AssertHelper.assertUrlContains("https://jobs.lever.co/useinsider/");
        AssertHelper.assertTextContains(leverTitleCheck,"Senior Software Quality Assurance Engineer");


    }













}