package Reusable_Library;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Reusable_Actions_Loggers {
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

    //Method to hover on any web element
    public static void mouseHover(WebDriver driver, String xpath, ExtentTest logger, String elementName){
        //Declare local explicit wait
        WebDriverWait wait = new WebDriverWait(driver,15);
        System.out.println("Hovering on element " + elementName);
        logger.log(LogStatus.INFO,"Hovering on element " + elementName);
        try {
            Actions actions = new Actions(driver);
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            actions.moveToElement(element).perform();
        } catch (Exception e) {
            System.out.println("Unable to hover on " + elementName + " Error:" + e);
            logger.log(LogStatus.FAIL,"Unable to hover on " + elementName + " Error:" + e);
            getScreenShot(driver,elementName,logger);
        }//End of Hover Exception
    }//end of hover method

    //Creating Void Dismiss Popup Method for any WebElement
    public static void dismissPopup(WebDriver driver, String xpath, ExtentTest logger, String elementName) {
        //Declare Local Explicit wait
        WebDriverWait wait = new WebDriverWait(driver, 15);
        System.out.println("Dismiss Popup " + elementName);
        logger.log(LogStatus.INFO,"Dismiss Popup " + elementName);
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))).click();
        } catch (Exception e) {
            System.out.println("Pop up didn't appear " + elementName + "Error:" + e);
            logger.log(LogStatus.PASS,"Pop Up didn't appear " + elementName + " Error:" + e);
            getScreenShot(driver,elementName,logger);
        }//End of Dismiss Popup Exception
    }//End of Dismiss PopUp Method

    //Creating Void Click Method for any WebElement
    public static void clickMethod(WebDriver driver, String xpath, ExtentTest logger, String elementName) {
        //Declare Local Explicit wait
        WebDriverWait wait = new WebDriverWait(driver, 15);
        System.out.println("Clicking on Element " + elementName);
        logger.log(LogStatus.INFO,"Clicking on Element " + elementName);
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))).click();
        } catch (Exception e) {
            System.out.println("Unable to click on " + elementName + "Error:" + e);
            logger.log(LogStatus.FAIL,"Unable to click on " + elementName + " Error:" + e);
            getScreenShot(driver,elementName,logger);
        }//End of Element Exception
    }//End of Click Method

    //Creating Void Submit Method for any WebElement
    public static void submitMethod(WebDriver driver, String xpath, ExtentTest logger, String elementName) {
        //Declare Local Explicit wait
        WebDriverWait wait = new WebDriverWait(driver, 15);
        System.out.println("Submitting on Element " + elementName);
        logger.log(LogStatus.INFO,"Submitting on Element " + elementName);
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath))).submit();
        } catch (Exception e) {
            System.out.println("Unable to submit on " + elementName + "Error:" + e);
            logger.log(LogStatus.FAIL,"Unable to submit on " + elementName + " Error:" + e);
            getScreenShot(driver,elementName,logger);
        }//End of Element Exception
    }//End of Submit Method

    //Creating Void sendKeys Method for any WebElement
    public static void sendKeysMethod(WebDriver driver,String xpath, String userData, ExtentTest logger, String elementName){
        //Declare local explicit wait
        WebDriverWait wait = new WebDriverWait(driver,15);
        System.out.println("Typing on element " + elementName);
        logger.log(LogStatus.INFO,"Typing on element " + elementName);
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            //Clear First
            element.clear();
            //Enter User Data
            element.sendKeys(userData);
        } catch (Exception e) {
            System.out.println("Unable to type on " + elementName + "Error: " + e);
            logger.log(LogStatus.FAIL,"Unable to type on " + elementName + " Error:" + e);
            getScreenShot(driver,elementName,logger);
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
    public static String getTextMethod(WebDriver driver,String xpath, ExtentTest logger,String elementName){
        //Declare local explicit wait
        WebDriverWait wait = new WebDriverWait(driver,15);
        System.out.println("Capturing text on element " + elementName);
        //Declare a global variable to capture the text, so I can return it
        String result = null;
        //Null or "  "
        logger.log(LogStatus.INFO,"Capturing text on element " + elementName);
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            //Capture Text
            result = element.getText();
        } catch (Exception e) {
            System.out.println("Unable to capture text on " + elementName + "Error: " + e);
            logger.log(LogStatus.FAIL,"Unable to capture text on " + elementName + "Error: " + e);
            getScreenShot(driver,elementName,logger);
        }//End of getText Exception
        return result;
    }//End of getText Method

    //Creating Select Dropdown by Visible Text Method for any text WebElement
    public static void dropDownSelect(WebDriver driver,String locator,String userSelect, ExtentTest logger, String elementName){
        WebDriverWait wait = new WebDriverWait(driver, 15);
        System.out.println("Selecting " + userSelect + " from drop down " + elementName);
        logger.log(LogStatus.INFO,"Selecting " + userSelect + " from drop down " + elementName);
        try{
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
            Select select = new Select(element);
            select.selectByVisibleText(userSelect);
        } catch (Exception e) {
            System.out.println("Unable to select value from drop down - " + elementName + " - " + e);
            logger.log(LogStatus.FAIL,"Unable to select value from drop down - " + elementName + " - " + e);
            getScreenShot(driver,elementName,logger);
        }//End of Select Dropdown Exception
    }//End of Select Dropdown Method

    //Creating a Click an Element Method by Index Number
    public static void clickByIndex(WebDriver driver,String locator, int indexNum, ExtentTest logger, String elementName){
        WebDriverWait wait = new WebDriverWait(driver, 15);
        System.out.println("Clicking on element " + elementName);
        logger.log(LogStatus.INFO,"Clicking on element " + elementName);
        try{
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(locator))).get(indexNum).click();
        } catch (Exception e) {
            System.out.println("Unable to Click on element " + elementName + " --" + e);
            logger.log(LogStatus.FAIL,"Unable to Click by Index on " + elementName + "Error:" + e);
            getScreenShot(driver,elementName,logger);
        }//End of Click Element by Index Number Exception
    }//End of Click on Element by Index Number Method

    //Creating a Capture Screenshot Method when Logger Fails
    public static void getScreenShot(WebDriver driver,String imageName,ExtentTest logger) {
        try {
            String fileName = imageName + ".png";
            String directory = null;
            String snPath = null;
            directory = "src/main/java/HTML_Report/Screenshots/";
            snPath = "Screenshots/";
            File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(sourceFile, new File(directory + fileName));
            //String imgPath = directory + fileName;
            String image = logger.addScreenCapture(snPath + fileName);
            logger.log(LogStatus.FAIL, "", image);
        } catch (Exception e) {
            logger.log(LogStatus.FAIL, "Error Occurred while taking SCREENSHOT!!!");
            e.printStackTrace();
        }//End of getScreenshot Method Exception
    }//End of getScreenshot Method

    public static String getDateTime() {
        SimpleDateFormat sdfDateTime;
        String strDateTime;
        sdfDateTime = new SimpleDateFormat("yyyyMMdd'_'HHmmss'_'SSS");
        Date now = new Date();
        strDateTime = sdfDateTime.format(now);
        return strDateTime;
    }//End of getDataTime Method

}//End of Java Class
