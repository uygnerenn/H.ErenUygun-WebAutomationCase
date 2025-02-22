package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class ComboBoxHelper {
    private static WebDriver driver;

    // Constructor
    public ComboBoxHelper(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Açılır menüden (combobox) belirli bir değeri seçer (Visible Text ile).
     */
    public static void selectByVisibleText(By locator, String visibleText) {
        WebElement dropdown = driver.findElement(locator);
        Select select = new Select(dropdown);
        select.selectByVisibleText(visibleText);
    }

    /**
     * Açılır menüden (combobox) belirli bir değeri seçer (Value Attribute ile).
     */
    public static void selectByValue(By locator, String value) {
        WebElement dropdown = driver.findElement(locator);
        Select select = new Select(dropdown);
        select.selectByValue(value);
    }

    /**
     * Açılır menüden (combobox) belirli bir index değerini seçer.
     */
    public static void selectByIndex(By locator, int index) {
        WebElement dropdown = driver.findElement(locator);
        Select select = new Select(dropdown);
        select.selectByIndex(index);
    }

    /**
     * Açılır menüde seçili olan değeri döndürür.
     */
    public static String getSelectedValue(By locator) {
        WebElement dropdown = driver.findElement(locator);
        Select select = new Select(dropdown);
        return select.getFirstSelectedOption().getText();
    }

    /**
     * Açılır menüdeki tüm seçenekleri döndürür.
     */
    public static List<String> getAllOptions(By locator) {
        WebElement dropdown = driver.findElement(locator);
        Select select = new Select(dropdown);
        return select.getOptions().stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    /**
     * Açılır menüde belirli bir değerin olup olmadığını kontrol eder.
     */
    public static boolean isOptionAvailable(By locator, String optionText) {
        return getAllOptions(locator).contains(optionText);
    }
}
