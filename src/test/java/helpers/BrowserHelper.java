package helpers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;

import java.util.ArrayList;
import java.util.List;

public class BrowserHelper {
    private static WebDriver driver;

    // Constructor
    public BrowserHelper(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Tarayıcı penceresini maksimum boyuta getirir.
     */
    public static void maximizeWindow() {
        driver.manage().window().maximize();
    }

    /**
     * Tarayıcı penceresini tam ekran moduna getirir.
     */
    public static void fullScreenWindow() {
        driver.manage().window().fullscreen();
    }

    /**
     * Sayfayı yeniler (refresh).
     */
    public static void refreshPage() {
        driver.navigate().refresh();
    }

    /**
     * Tarayıcıda geri (back) tuşuna basar.
     */
    public static void navigateBack() {
        driver.navigate().back();
    }

    /**
     * Tarayıcıda ileri (forward) tuşuna basar.
     */
    public static void navigateForward() {
        driver.navigate().forward();
    }

    /**
     * Yeni bir sekme açar ve belirli bir URL'yi yükler.
     */
    public static void openNewTab(String url) {
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get(url);
    }

    /**
     * Yeni bir pencere açar ve belirli bir URL'yi yükler.
     */
    public static void openNewWindow(String url) {
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get(url);
    }

    /**
     * Açık tüm sekme pencerelerini getirir.
     */
    public static List<String> getAllWindowHandles() {
        return new ArrayList<>(driver.getWindowHandles());
    }

    /**
     * Açık olan tüm sekmeler arasında geçiş yapar.
     */
    public static void switchToWindow(int index) {
        List<String> windowHandles = new ArrayList<>(driver.getWindowHandles());
        if (index >= 0 && index < windowHandles.size()) {
            driver.switchTo().window(windowHandles.get(index));
        } else {
            throw new IllegalArgumentException("Geçersiz pencere indeksi: " + index);
        }
    }

    /**
     * Mevcut sekmeyi kapatır.
     */
    public static void closeCurrentTab() {
        driver.close();
    }

    /**
     * Tüm tarayıcı pencerelerini kapatır.
     */
    public static void closeBrowser() {
        driver.quit();
    }




}
