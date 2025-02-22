package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.DriverFactory;

public class PopupHandler {
    private static WebDriver driver;

    private static final WebDriverWait wait = DriverFactory.getWait();

    public PopupHandler(WebDriver driver) {
        this.driver = driver;
    }

    // Pop-up var mı kontrol et
    public static boolean isPopupPresent(By locator) {
        try {
            WebElement popup = driver.findElement(locator);
            return popup.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    // Pop-up'ı kapat
    public static void closePopup(By locator) {

            WebElement closeButton = driver.findElement(locator);
            closeButton.click();
            System.out.println("Pop-up kapatıldı.");

    }

    public static void closePopupIfExists(By popupLocator, By closeButtonLocator) {
        try {
            WebElement popup = wait.until(ExpectedConditions.visibilityOfElementLocated(popupLocator));
            WebElement closeButton = popup.findElement(closeButtonLocator);
            closeButton.click();
            System.out.println("Pop-up başarıyla kapatıldı.");
        } catch (Exception e) {
            System.out.println("Pop-up bulunamadı veya zaten kapalı.");
        }
    }
}
