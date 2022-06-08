package Reusable_Library;

import com.sun.jdi.connect.Connector;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Reusable_Actions {

    //Set a static timeout variable so it can cover all explicit for all methods
    public static int timeout = 10;

    //Create a Reusable Method for Webdriver and ChromeOptions
    public static WebDriver setDriver() {
        //Setup ChromeDriver
        WebDriverManager.chromedriver().setup();
        //Declare and Define the ChromeOptions
        ChromeOptions option = new ChromeOptions();
        //Declare all the arguments you need
        //Set web browser to maximized
        option.addArguments("start-maximized");
        //Set web browser to incognito mode
        option.addArguments("incognito");
        //Set web browser to headless
        //option.addArguments("headless");
        //Define the WebDriver you are using
        WebDriver driver = new ChromeDriver(option);
        return driver;
    }//End of Webdriver Method

    //Create Void Mouse Hover Method for any WebElement
    public static void mouseHover(WebDriver driver,String xpath, String elementName) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        Actions actions = new Actions(driver);
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            actions.moveToElement(element).perform();
        } catch (Exception e) {
            System.out.println("Unable to hover on element " + elementName + "Error:" + e);
        }//End of Element Exception
    }//End of Mouse Hover

    //Creating Void Click Method for any WebElement
    public static void clickMethod(WebDriver driver, String xpath, String elementName) {
        //Declare Local Explicit wait
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        System.out.println("Clicking on Element " + elementName);
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))).click();
        } catch (Exception e) {
            System.out.println("Unable to click on " + elementName + "Error:" + e);
        }//End of Element Exception
    }//End of Click Method

    //Creating Void Submit Method for any WebElement
    public static void submitMethod(WebDriver driver, String xpath, String elementName) {
        //Declare Local Explicit wait
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        System.out.println("Submitting on Element " + elementName);
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))).submit();
        } catch (Exception e) {
            System.out.println("Unable to submit on " + elementName + "Error:" + e);
        }//End of Element Exception
    }//End of Submit Method

    //Creating Void sendKeys Method for any WebElement
    public static void sendKeysMethod(WebDriver driver,String xpath, String userData, String elementName){
        //Declare local explicit wait
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        System.out.println("Typing on element " + elementName);
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            //Clear First
            element.clear();
            //Enter User Data
            element.sendKeys(userData);
        } catch (Exception e) {
            System.out.println("Unable to type on " + elementName + "Error: " + e);
        }//End of sendKeys Exception
    }//End of click sendKeys Method

    //Creating scrollingByPixel Method for any WebElement
    public static void scrollingByPixelMethod(WebDriver driver,String x, String y){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
            //Scroll to the view by pixels
            jse.executeScript("window.scrollBy("  + x + " ," + y + ")");
        //End of Scroll by Pixel Exception
    }//End of Scroll by Pixel Method

    //Creating Return getText Method for any text WebElement
    public static String getTextMethod(WebDriver driver,String xpath, String elementName){
        //Declare local explicit wait
        WebDriverWait wait = new WebDriverWait(driver,timeout);
        System.out.println("Capturing text on element " + elementName);
        //Declare a global variable to capture the text, so I can return it
        String result = null;
        //Null or "  "
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            //Capture Text
            result = element.getText();
        } catch (Exception e) {
            System.out.println("Unable to capture text on " + elementName + "Error: " + e);
        }//End of getText Exception
        return result;
    }//End of getText Method

    //Creating Select Dropdown by Visible Text Method for any text WebElement
    public static void dropDownSelectMethod(WebDriver driver,String locator,String userSelect, String elementName){
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        System.out.println("Selecting " + userSelect + " from drop down " + elementName);
        try{
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
            Select select = new Select(element);
            select.selectByVisibleText(userSelect);
        } catch (Exception e) {
            System.out.println("Unable to select value from drop down - " + elementName + " - " + e);
        }//End of Select Dropdown Exception
    }//End of Select Dropdown Method

    //Creating a Click an Element Method by Index Number
    public static void clickByIndex(WebDriver driver,String locator, int indexNum, String elementName){
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        System.out.println("Clicking on element " + elementName + " by index number " + indexNum);
        try{
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
            Select select = new Select(element);
            select.selectByIndex(indexNum);
        } catch (Exception e) {
            System.out.println("Unable to Click on element - " + elementName + " by index number... " + e);
        }//End of Click Element by Index Number Exception
    }//End of Click on Element by Index Number Method

}//End of Java Class
