package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import util.DriverFactory;

import java.time.Duration;
import java.util.List;


public class AssertHelper {

    private static WebDriver driver;
    private static final WebDriverWait wait = DriverFactory.getWait();

    public AssertHelper(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * İki string değerinin eşit olup olmadığını kontrol eder.
     */
    public static void assertTextEquals(By locator, String expected) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        String actualText = element.getText();
        actualText = actualText.replaceAll("[^\\x00-\\x7F]", "").trim();
        expected = expected.replaceAll("[^\\x00-\\x7F]", "").trim();
        Assert.assertEquals(" HATA: Beklenen ve gerçek değer eşleşmiyor! Beklenen: '" + expected + "' | Bulunan: '" + actualText + "'",
                expected, actualText);
    }


    /**
     * İki string değerinin eşit olmadığını kontrol eder.
     */
    public static void assertTextNotEquals(String actual, String expected) {
        Assert.assertNotEquals(actual, expected, "HATA: Beklenen ve gerçek değer aynı olmamalı!");
    }

    /**
     * WebElement'in görülebilir olduğunu doğrular.
     */
    public static void assertElementIsDisplayed(By locator) {
        WebElement element = driver.findElement(locator);
        Assert.assertTrue(element.isDisplayed(), "HATA: Öğe görüntülenemiyor!");
    }

    /**
     * WebElement'in görünmez olduğunu doğrular.
     */
    public static void assertElementIsNotDisplayed(By locator) {
        WebElement element = driver.findElement(locator);
        Assert.assertFalse(element.isDisplayed(), "HATA: Öğe görünür olmamalı!");
    }

    /**
     * WebElement'in etkin (enabled) olup olmadığını doğrular.
     */
    public static void assertElementIsEnabled(By locator) {
        WebElement element = driver.findElement(locator);
        Assert.assertTrue(element.isEnabled(), "HATA: Öğe etkin değil!");
    }

    /**
     * WebElement'in devre dışı (disabled) olduğunu doğrular.
     */
    public static void assertElementIsDisabled(By locator) {
        WebElement element = driver.findElement(locator);
        Assert.assertFalse(element.isEnabled(), "HATA: Öğe etkin olmamalı!");
    }

    /**
     * WebElement'in seçili (selected) olup olmadığını doğrular.
     */
    public static void assertElementIsSelected(By locator) {
        WebElement element = driver.findElement(locator);
        Assert.assertTrue(element.isSelected(), "HATA: Öğe seçili değil!");
    }

    /**
     * WebElement'in seçili olmadığını doğrular.
     */
    public static void assertElementIsNotSelected(By locator) {
        WebElement element = driver.findElement(locator);
        Assert.assertFalse(element.isSelected(), "HATA: Öğe seçili olmamalı!");
    }

    /**
     * Belirtilen metnin bir WebElement içinde bulunup bulunmadığını doğrular.
     */
    public static void assertTextContains(By locator, String expectedText) {
        WebElement element = driver.findElement(locator);
        Assert.assertTrue(element.getText().contains(expectedText),
                "HATA: Öğede beklenen metin bulunamadı! Beklenen: " + expectedText);
    }

    /**
     * Boolean değerin doğru olduğunu doğrular.
     */
    public static void assertTrue(boolean condition, String message) {
        Assert.assertTrue(condition, message);
    }

    /**
     * Boolean değerin yanlış olduğunu doğrular.
     */
    public static void assertFalse(boolean condition, String message) {
        Assert.assertFalse(condition, message);
    }
    public static void urlCheck(String expectedUrl, String actualUrl){
        actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(actualUrl, expectedUrl, "URL beklenenle eşleşmiyor!");
    }

    public static void assertListEquals(By locator, String expectedText){
        List<WebElement> elements = driver.findElements(locator);
        AssertHelper.assertFalse(elements.isEmpty(),
                "ERROR: No elements found for locator '" + locator.toString() + "'");
        for (WebElement element : elements) {
            AssertHelper.assertTrue(element.getText().contains(expectedText),
                    "ERROR: Expected text to contain '" + expectedText + "' but found: '" + element.getText() + "'");
        }
        System.out.println(" SUCCESS: All elements contain the expected text: '" + expectedText + "' !");

    }
    public static void assertListEqualsMultipleText(By locator, String expectedText1, String expectedText2){
        List<WebElement> elements = driver.findElements(locator);
        AssertHelper.assertFalse(elements.isEmpty(),
                "ERROR: No elements found for locator '" + locator.toString() + "'");
        for (WebElement element : elements) {
            String text = element.getText();
            AssertHelper.assertTrue(
                    text.contains(expectedText1) || text.contains(expectedText2),
                    "ERROR: Expected text to contain " + expectedText1 + " \nor " + expectedText2 +"but found: '" + text + "'"
            );
        }
        System.out.println(" SUCCESS: All elements contain the expected text: '" + expectedText1 + "\nor" + expectedText2 + "' !");

    }

    public static void assertUrlContains(String expectedText) {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains(expectedText),
                " ERROR: The URL does not contain the expected value! \nExpected: '" + expectedText + "'\nFound: '" + currentUrl + "'");
        System.out.println("SUCCESS: The URL contains the expected text -> " + expectedText);
    }


}
