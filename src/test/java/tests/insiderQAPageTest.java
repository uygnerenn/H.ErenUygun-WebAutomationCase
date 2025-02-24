package tests;


import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;

import org.testng.annotations.*;
import pages.insiderQAPage;
import util.AllureReportListener;
import util.ConfigReader;
import util.DriverFactory;

import java.util.Properties;

@Listeners({AllureReportListener.class})
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
    @Description("Visit https://useinsider.com/ and check Insider home page is opened or not")
    public void TheUserNavigatesToInsider(){
        insiderPage = new insiderQAPage(driver);
        insiderPage.insiderPageCheck();
    }

    @Test(groups = "Carrers Page", priority = 2)
    @Description("Select the “Company” menu in the navigation bar, select “Careers” and check Career\n" +
            "page, its Locations, Teams, and Life at Insider blocks are open or not")
    public void CareersPage(){
        insiderPage=new insiderQAPage(driver);
        insiderPage.insiderPageCheck();
        insiderPage.companyMenuWay();
    }

    @Test(groups = "QA Jobs Page" , priority = 3)
    @Description("Go to https://useinsider.com/careers/quality-assurance/, click “See all QA jobs”, filter\n" +
            "jobs by Location: “Istanbul, Turkey”, and Department: “Quality Assurance”, check the\n" +
            "presence of the jobs list")
    public void QAJobsPage() {
        insiderPage=new insiderQAPage(driver);
        insiderPage.insiderPageCheck();
        insiderPage.qaJobsPage();
    }

    @Test(groups = "QA Jobs Page Check", priority = 4)
    @Description("Check that all jobs’ Position contains “Quality Assurance”, Department contains\n" +
            "“Quality Assurance”, and Location contains “Istanbul, Turkey”")
    public void QAJobsCheck () {
        insiderPage=new insiderQAPage(driver);
        insiderPage.insiderPageCheck();
        insiderPage.qaJobsPage();
        insiderPage.qaJobsCheck();
    }

    @Test(groups = "Lever Application Form Check", priority = 5)
    @Description("Click the “View Role” button and check that this action redirects us to the Lever\n" +
            "Application form page")
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





