package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GenericHelper {
    private static WebDriver driver;

    // Constructor
    public GenericHelper(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Belirtilen locator'a sahip öğeyi bulur ve döndürür.
     */
    public static WebElement getElement(By locator) {
        return driver.findElement(locator);
    }

    /**
     * Belirtilen locator'a sahip tüm öğeleri bulur ve liste olarak döndürür.
     */
    public static List<WebElement> getElements(By locator) {
        return driver.findElements(locator);
    }

    /**
     * Belirtilen öğenin görünür olup olmadığını kontrol eder.
     */
    public static boolean isElementVisible(By locator) {
        List<WebElement> elements = driver.findElements(locator);
        return !elements.isEmpty() && elements.get(0).isDisplayed();
    }

    /**
     * Belirtilen öğenin mevcut olup olmadığını kontrol eder.
     */
    public static boolean isElementPresent(By locator) {
        return !driver.findElements(locator).isEmpty();
    }

    /**
     * Belirtilen öğenin etkin (enabled) olup olmadığını kontrol eder.
     */
    public static boolean isElementEnabled(By locator) {
        WebElement element = driver.findElement(locator);
        return element.isEnabled();
    }

    /**
     * Belirtilen öğenin içindeki metni döndürür.
     */
    public static  String getElementText(By locator) {
        WebElement element = driver.findElement(locator);
        String text = element.getText();

        System.out.println("Locator = " + locator + " | Found Text = " + text);
        return text;
    }

    /**
     * Belirtilen öğenin belirli bir attribute değerini döndürür.
     */
    public static String getElementAttribute(By locator, String attribute) {
        return driver.findElement(locator).getAttribute(attribute);
    }

    /**
     * Belirtilen öğeye tıklar.
     */
    public static void clickElement(By locator) {
        driver.findElement(locator).click();
    }

    /**
     * Belirtilen öğeye metin gönderir (input alanlarına yazı yazmak için).
     */
    public static void sendKeysToElement(By locator, String text) {
        WebElement element = driver.findElement(locator);
        element.clear();
        element.sendKeys(text);
    }



}
