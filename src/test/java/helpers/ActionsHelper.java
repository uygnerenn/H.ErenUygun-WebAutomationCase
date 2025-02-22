package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionsHelper {


    private static Actions action;
    private static WebDriver driver;


    public ActionsHelper(WebDriver driver) {

        this.action = new Actions(driver);
        this.driver = driver;
    }

    public static void scrollToElement(By locator) {
        WebElement element = driver.findElement(locator);
        String scrollElementIntoMiddle = "var viewPortHeight = Math.max(document.documentElement.clientHeight, window.innerHeight || 0);"
                + "var elementTop = arguments[0].getBoundingClientRect().top;"
                + "window.scrollBy(0, elementTop-(viewPortHeight/2));";
        ((JavascriptExecutor) driver).executeScript(scrollElementIntoMiddle, element);

    }


    public static void hoverOverElement(By locator) {
        WebElement element = driver.findElement(locator);
        action.moveToElement(element).build().perform();
    }



    public static void doubleClickElement(By locator) {
        WebElement element = driver.findElement(locator);
        action.doubleClick(element).perform();
    }


    public static void rightClickElement(By locator) {
        WebElement element = driver.findElement(locator);
        action.contextClick(element).perform();
    }


    public static void dragAndDrop(By source, By target) {
        WebElement element1 = driver.findElement(source);
        WebElement element2 = driver.findElement(target);
        action.dragAndDrop(element1, element2).perform();
    }

    // Mouse hareketi ile bir elementin üzerine git
    public static void moveToElement(By locator) {
        WebElement element = driver.findElement(locator);
        action.moveToElement(element).perform();
    }

    // Mouse hareketi ile bir noktaya git ve tıkla
    public static void moveToElementAndClick(By locator) {
        WebElement element = driver.findElement(locator);
        action.moveToElement(element).click().perform();
    }

    // Mouse'u belirli bir koordinata hareket ettirme
    public static void moveByOffset(int x, int y) {
        action.moveByOffset(x, y).perform();
    }




}
