package helpers;

import org.openqa.selenium.*;

public class TextBoxHelper {
    private WebDriver driver;
    private WebElement element;

    // Constructor
    public TextBoxHelper(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Belirtilen metin kutusuna metin yazar.
     */
    public void typeInTextBox(By locator, String text) {
        element = driver.findElement(locator);
        element.sendKeys(text);
    }

    /**
     * Belirtilen metin kutusunun içeriğini temizler.
     */
    public void clearTextBox(By locator) {
        element = driver.findElement(locator);
        element.clear();
    }

    /**
     * Belirtilen metin kutusunun içindeki metni döndürür.
     */
    public String getText(By locator) {
        element = driver.findElement(locator);
        return element.getText();
    }

    /**
     * Belirtilen metin kutusundaki mevcut değeri döndürür.
     */
    public String getValue(By locator) {
        element = driver.findElement(locator);
        return element.getAttribute("value");
    }

    /**
     * Belirtilen metin kutusundaki belirli bir attribute değerini döndürür.
     */
    public String getValue(By locator, String attribute) {
        element = driver.findElement(locator);
        return element.getAttribute(attribute);
    }

    /**
     * Belirtilen metin kutusuna metin yazar ve ENTER tuşuna basar.
     */
    public void typeInTextBoxEnter(By locator, String text) {
        element = driver.findElement(locator);
        element.sendKeys(text + Keys.ENTER);
    }

    /**
     * Belirtilen metin kutusunun placeholder değerini döndürür.
     */
    public String getPlaceholder(By locator) {
        element = driver.findElement(locator);
        return element.getAttribute("placeholder") == null ? "" : element.getAttribute("placeholder");
    }

    /**
     * JavaScript kullanarak metin kutusuna tarih değeri girer.
     */
    public void setDate(WebDriver driver, By locator, String date) {
        WebElement element = driver.findElement(locator);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value = arguments[1];", element, date);
    }
}
