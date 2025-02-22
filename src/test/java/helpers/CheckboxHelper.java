package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckboxHelper {
    private static WebDriver driver;

    // Constructor
    public CheckboxHelper(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Checkbox'ı seçer.
     */
    public static void checkCheckbox(By locator) {
        WebElement element = driver.findElement(locator);
        if (!element.isSelected()) {
            element.click();
        }
    }

    /**
     * Checkbox'ı kaldırır (Uncheck).
     */
    public static void uncheckCheckbox(By locator) {
        WebElement element = driver.findElement(locator);
        if (element.isSelected()) {
            element.click();
        }
    }

    /**
     * Checkbox'ın seçili olup olmadığını kontrol eder.
     */
    public static boolean isCheckboxChecked(By locator) {
        WebElement element = driver.findElement(locator);
        String flag = element.getAttribute("checked");
        return flag != null && (flag.equals("true") || flag.equals("checked"));
    }

    /**
     * Checkbox'ı JavaScript kullanarak seçer.
     */
    public static void checkCheckboxUsingJS(By locator) {
        WebElement element = driver.findElement(locator);
        if (!element.isSelected()) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        }
    }

    /**
     * Checkbox'ı JavaScript kullanarak kaldırır.
     */
    public static void uncheckCheckboxUsingJS(By locator) {
        WebElement element = driver.findElement(locator);
        if (element.isSelected()) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        }
    }
}
