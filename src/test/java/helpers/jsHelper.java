package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class jsHelper {
    private static WebDriver driver;
    private static JavascriptExecutor js;
    private static WebDriverWait wait;

    // Constructor
    public jsHelper(WebDriver driver) {
        this.driver = driver;
        this.js = (JavascriptExecutor) driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    // **Bir elemente JavaScript ile tıklama**
    public static void clickElement(By locator) {
        WebElement element = driver.findElement(locator);
        js.executeScript("arguments[0].click();", element);
    }

    // **Bir elementin görünmesini bekleyerek JavaScript ile tıklama**
    public static void clickElementWhenVisible(By locator) {
        WebElement element = driver.findElement(locator);
        try {
            Thread.sleep(2000); // Kısa süre bekleyerek elementin yüklenmesini sağla
            js.executeScript("arguments[0].click();", element);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // **Elementin değerini değiştirme**
    public static void setElementValue(By locator, String value) {
        WebElement element =driver.findElement(locator);
        js.executeScript("arguments[0].value = arguments[1];", element, value);
    }

    // **Sayfayı belirli bir piksel aşağı kaydırma**
    public static void scrollDown(int pixels) {
        js.executeScript("window.scrollBy(0," + pixels + ");");
    }

    // **Sayfanın en altına kaydırma**
    public static void scrollToBottom() {
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    // **Elementin bulunduğu yere kaydırma**
    public static void scrollToElement(By locator) {
        WebElement element = driver.findElement(locator);
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    // **Sayfayı belirli bir piksel yukarı kaydırma**
    public static void scrollUp(int pixels) {
        js.executeScript("window.scrollBy(0,-" + pixels + ");");
    }

    // **Sayfadaki tüm uyarı (alert) pop-up'larını kapatma**
    public static void dismissAlert() {
        try {
            driver.switchTo().alert().dismiss();
        } catch (Exception e) {
            System.out.println("Uyarı pop-up'ı bulunamadı.");
        }
    }

    public void scrollAndClick(By locator) {
        WebElement element = driver.findElement(locator);
        try {
            js.executeScript("arguments[0].scrollIntoView(true);", element);
            Thread.sleep(1000);  // Bekleme süresi
            element.click();
            System.out.println("Elemente başarıyla tıklandı.");
        } catch (Exception e) {
            System.out.println("Tıklama sırasında hata oluştu: " + e.getMessage());
        }
    }

    public static void waitForPageLoad() {
        wait.until(driver -> js.executeScript("return document.readyState").toString().equals("complete"));
        System.out.println("Sayfa tamamen yüklendi.");
    }

    // **2. Belirli bir elementin yüklenmesini bekleme**
    public static void waitForElementToLoad(By locator) {
        wait.until(driver -> driver.findElement(locator).isDisplayed());
        System.out.println("Element yüklendi: " + locator);
    }

    public static void autoDismissPopups() {
        try {
            js.executeScript("window.alert = function() {}; window.confirm = function() {}; window.prompt = function() {};");
            System.out.println("Pop-up'lar devre dışı bırakıldı.");
        } catch (Exception e) {
            System.out.println("Pop-up engelleme başarısız: " + e.getMessage());
        }
    }

    public void waitForPageToLoad() {
        js.executeScript("return document.readyState").equals("complete");
    }


}
