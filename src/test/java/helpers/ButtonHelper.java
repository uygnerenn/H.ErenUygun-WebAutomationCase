package helpers;

import org.openqa.selenium.*;

public class ButtonHelper {
    private static WebDriver driver;

    // Constructor
    public ButtonHelper(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Belirtilen butona tıklar.
     */
    public static void clickButton(By locator) {
        WebElement element = driver.findElement(locator);
        element.click();
    }

    /**
     * Belirtilen butonun etkin (enabled) olup olmadığını kontrol eder.
     */
    public static boolean isButtonEnabled(By locator) {
        WebElement element = driver.findElement(locator);
        return element.isEnabled();
    }

    /**
     * Belirtilen butonun görünür olup olmadığını kontrol eder.
     */
    public static boolean isButtonDisplayed(By locator) {
        WebElement element = driver.findElement(locator);
        return element.isDisplayed();
    }

    /**
     * Belirtilen butona JavaScript kullanarak tıklama yapar.
     */
    public static void clickButtonUsingJS(By locator) {
        WebElement element = driver.findElement(locator);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);
    }

    /**
     * Belirtilen butonun metnini döndürür.
     */
    public static String getButtonText(By locator) {
        WebElement element = driver.findElement(locator);
        return element.getText();
    }

    public static void safeClick(By locator) {
        int retries = 3;
        for (int i = 0; i < retries; i++) {
            try {
                WebElement element = driver.findElement(locator);
                element.click();
                return;
            } catch (StaleElementReferenceException e) {
                System.out.println("Element kayboldu, tekrar aranıyor... " + (i + 1));
            }
        }
        throw new RuntimeException("Element bulunamadı: " + locator);
    }
}
