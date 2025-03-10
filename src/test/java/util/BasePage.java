package util;

import helpers.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;


    protected ActionsHelper actionsHelper;
    protected PopupHandler popupHandler;
    protected AssertHelper assertHelper;
    protected BrowserHelper browserHelper;
    protected ButtonHelper buttonHelper;
    protected CheckboxHelper checkboxHelper;
    protected ComboBoxHelper comboBoxHelper;
    protected GenericHelper genericHelper;
    protected RadioButtonHelper radioButtonHelper;
    protected TextBoxHelper textBoxHelper;
    protected WaitHelper waitHelper;
    protected jsHelper javaScriptExecutorHelper;


    public BasePage(WebDriver driver) {

        PageFactory.initElements(DriverFactory.getDriver(), this);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));



        this.actionsHelper = new ActionsHelper(driver);
        this.popupHandler = new PopupHandler(driver);
        this.assertHelper = new AssertHelper(driver);
        this.browserHelper = new BrowserHelper(driver);
        this.buttonHelper = new ButtonHelper(driver);
        this.checkboxHelper = new CheckboxHelper(driver);
        this.comboBoxHelper = new ComboBoxHelper(driver);
        this.genericHelper = new GenericHelper(driver);
        this.radioButtonHelper = new RadioButtonHelper(driver);
        this.textBoxHelper = new TextBoxHelper(driver);
        this.waitHelper = new WaitHelper(driver);
        this.javaScriptExecutorHelper = new jsHelper(driver);
    }



    public WebElement getElement() {
        return driver.findElement(By.id("elementId"));
    }


    public void urlControl(String url) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
