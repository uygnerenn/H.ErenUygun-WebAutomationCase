package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.DriverFactory;

import java.time.Duration;
import java.util.List;

public class WaitHelper {
    private static WebDriver driver;
    private static final WebDriverWait wait = DriverFactory.getWait();

    // Constructor
    public WaitHelper(WebDriver driver) {
        this.driver = driver;

    }

    public static void waitForDropdownOptionsToLoad(By dropdownListLocator, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.presenceOfElementLocated(dropdownListLocator));
    }


    /**
     * Belirtilen öğeyi görünür olana kadar bekler.
     */
    public static WebElement waitForElementToBeVisible(By locator) {
        WebElement element = driver.findElement(locator);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
    public static String waitForElementToBeVisibleText(By locator) {
        WebElement element = driver.findElement(locator);
        return wait.until(ExpectedConditions.visibilityOf(element)).getText();
    }

    /**
     * Belirtilen öğeyi tıklanabilir olana kadar bekler.
     */
    public static WebElement waitForElementToBeClickable(By locator) {
        WebElement element = driver.findElement(locator);
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    /**
     * Belirtilen öğeyi tıklanabilir olana kadar bekler.
     */
    public static  WebElement waitForClick(By locator) {
        WebElement element = driver.findElement(locator);
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        return element;
    }

    /**
     * Belirtilen öğenin DOM'da mevcut olmasını bekler.
     */
    public static WebElement waitForElementToBePresent(By locator) {
        WebElement element = driver.findElement(locator);
        return wait.until(ExpectedConditions.presenceOfElementLocated((By) element));
    }

    /**
     * Sayfanın tamamen yüklenmesini bekler.
     */
    public static void waitForPageToLoad() {
        wait.until(driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
    }

    /**
     * Belirtilen öğenin metninin değişmesini bekler.
     */
    public static boolean waitForTextToBePresentInElement(By locator, String text)  {
        WebElement element = driver.findElement(locator);
        return wait.until(ExpectedConditions.textToBePresentInElement(element, text));
    }

    /**
     * Belirtilen öğenin görünmez olmasını bekler.
     */
    public static boolean waitForElementToBeInvisible(By locator) {
        WebElement element = driver.findElement(locator);
        return wait.until(ExpectedConditions.invisibilityOf(element));
    }


    public static void  visibilityOfElementLocated(By locator){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

    }
    public static void  visibilityOfElementLocatedtext(By locator){
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();

    }

    public static void waitForText( By locator , String Text){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement element = driver.findElement(locator);

        wait.until(driver -> {
            List<WebElement> elements = driver.findElements(locator);

            for (WebElement title : elements) {
                if (!title.getText().contains(Text)) {
                    return false;
                }
            }
            return true;
        });

        System.out.println("SUCCESS: Text is True'.");
    }



}
