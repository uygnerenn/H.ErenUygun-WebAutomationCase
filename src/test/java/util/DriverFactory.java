package util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class DriverFactory {

    static WebDriver driver;
    static Properties properties;
    private static WebDriverWait wait;

    public static WebDriver initialize_Driver(String browser){
        properties = ConfigReader.getProperties();
        if (browser.equals("Chrome")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();
            driver = new ChromeDriver(options);
        } else if (browser.equals("Firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("chrome-headless")) {
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless"); // Headless mode
            options.addArguments("--disable-gpu");
            options.addArguments("--window-size=1920,1080");
            driver = new ChromeDriver(options);
            
        } else {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }

        String url = properties.getProperty("url");
        int impWait = Integer.parseInt(properties.getProperty("implicityWait"));
        int pageWait = Integer.parseInt(properties.getProperty("pageLoadTimeout"));
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(impWait, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(pageWait, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        return getDriver();
    }

    public static WebDriver getDriver(){
        return driver;
    }

    public static WebDriverWait getWait() {
        return wait;
    }


}
