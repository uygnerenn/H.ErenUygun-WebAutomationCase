package tests;


import org.openqa.selenium.WebDriver;

import org.testng.annotations.*;
import pages.insiderQAPage;
import util.ConfigReader;
import util.DriverFactory;

import java.util.Properties;

public class insiderQAPageTest   {




    WebDriver driver = DriverFactory.getDriver();
    insiderQAPage insiderPage;
    Properties properties;

    @BeforeMethod
    public void before() {
        String browser = "chrome";
        properties = ConfigReader.initialize_Properties();
        driver = DriverFactory.initialize_Driver(browser);

        if (driver == null) {
            throw new RuntimeException("Driver initialization failed! WebDriver instance is null.");
        }

    }



    @Test(groups = "Navigate Insider", priority = 1)
    public void TheUserNavigatesToInsider(){
        insiderPage = new insiderQAPage(driver);
        insiderPage.insiderPageCheck();
    }

    @Test(groups = "Carrers Page", priority = 2)
    public void CareersPage(){
        insiderPage=new insiderQAPage(driver);
        insiderPage.insiderPageCheck();
        insiderPage.companyMenuWay();
    }

    @Test(groups = "QA Jobs Page" , priority = 3)
    public void QAJobsPage() {
        insiderPage=new insiderQAPage(driver);
        insiderPage.insiderPageCheck();
        insiderPage.qaJobsPage();
    }

    @Test(groups = "QA Jobs Page Check", priority = 4)
    public void QAJobsCheck () {
        insiderPage=new insiderQAPage(driver);
        insiderPage.insiderPageCheck();
        insiderPage.qaJobsPage();
        insiderPage.qaJobsCheck();
    }

    @Test(groups = "Lever Application Form Check", priority = 5)
    public void leverApplicationFormCheck() {
        insiderPage=new insiderQAPage(driver);
        insiderPage.insiderPageCheck();
        insiderPage.qaJobsPage();
        insiderPage.leverApplicationForm();
    }

    @AfterMethod
    public void after() {
        if (driver != null) {
            driver.quit();

        }
    }




}





