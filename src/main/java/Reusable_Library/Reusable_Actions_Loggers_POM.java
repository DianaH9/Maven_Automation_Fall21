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

public class Reusable_Actions_Loggers_POM {
    //Create a Reusable Method for WebDriver and ChromeOptions
    public static WebDriver setDriver(){
        //Setup ChromeDriver
        WebDriverManager.chromedriver().setup();
        //Declare and Define the ChromeOptions
        ChromeOptions options = new ChromeOptions();
        //Declare All the Arguments you need
        //To Maximize my Driver
        options.addArguments("start-maximized");
        //options.addArguments("fullscreen"); //for mac users
        //Set as Incognito Mode
        options.addArguments("incognito");
        //Set as Headless(running the driver on background)
        //options.addArguments("headless");
        //Define the WebDriver you are using
        WebDriver driver = new ChromeDriver(options);
        return  driver;
    }//End of WebDriver Method

    //Method to Hover on any Web Element
    public static void mouseHover(WebDriver driver, WebElement xpath, ExtentTest logger, String elementName){
        //Declare Local Explicit Wait
        WebDriverWait wait = new WebDriverWait(driver,15);
        System.out.println("Hovering on element " + elementName);
        try {
            Actions actions = new Actions(driver);
            WebElement element = wait.until(ExpectedConditions.visibilityOf(xpath));
            actions.moveToElement(element).perform();
            logger.log(LogStatus.PASS,"Hovering on element " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to hover on " + elementName + " Error:" + e);
            logger.log(LogStatus.FAIL,"Unable to hover on " + elementName + " Error:" + e);
            getScreenShot(driver,elementName,logger);
        }//End of Hover Method Exception
    }//End of Hover Method

    //Creating Void Dismiss Popup Method for any WebElement
    public static void dismissPopup(WebDriver driver, WebElement xpath, ExtentTest logger, String elementName) {
        //Declare Local Explicit wait
        WebDriverWait wait = new WebDriverWait(driver, 15);
        System.out.println("Dismiss Popup " + elementName);
        logger.log(LogStatus.INFO,"Dismiss Popup " + elementName);
        try {
            wait.until(ExpectedConditions.visibilityOf(xpath)).click();
        } catch (Exception e) {
            System.out.println("Pop up didn't appear " + elementName + "Error:" + e);
            logger.log(LogStatus.PASS,"Pop Up didn't appear " + elementName + " Error:" + e);
            getScreenShot(driver,elementName,logger);
        }//End of Dismiss Popup Exception
    }//End of Dismiss PopUp Method

    //Creating Void Click Method for any Web Element
    public static void clickDismissPopUpMethod(WebDriver driver, WebElement xpath, ExtentTest logger,String elementName){
        //Declare Local Explicit Wait
        WebDriverWait wait = new WebDriverWait(driver,15);
        System.out.println("Dismiss Popup " + elementName);
        logger.log(LogStatus.INFO,"Dismiss Popup " + elementName);
        try {
            wait.until(ExpectedConditions.visibilityOf(xpath)).click();
        } catch (Exception e) {
            System.out.println("Pop up didn't appear " + elementName + " Error:" + e);
            logger.log(LogStatus.PASS,"Pop Up didn't appear " + elementName + " Error:" + e);
            getScreenShot(driver,elementName,logger);
        }//End of Dismiss Popup Click Exception
    }//End of Dismiss Popup Click Method

    //Creating Void Click Method for any Web Element
    public static void clickMethod(WebDriver driver, WebElement xpath, ExtentTest logger,String elementName){
        //Declare Local Explicit Wait
        WebDriverWait wait = new WebDriverWait(driver,15);
        System.out.println("Clicking on element " + elementName);
        try {
            wait.until(ExpectedConditions.visibilityOf(xpath)).click();
            logger.log(LogStatus.PASS,"Clicking on element " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to click on " + elementName + " Error:" + e);
            logger.log(LogStatus.FAIL,"Unable to click on " + elementName + " Error:" + e);
            getScreenShot(driver,elementName,logger);
        }//End of Click Exception
    }//End of Click Method

    //Creating Void Click Method for any Web Element
    public static void clickMethodHulu(WebDriver driver, WebElement xpath, String UserData, ExtentTest logger,String elementName){
        //Declare Local Explicit Wait
        WebDriverWait wait = new WebDriverWait(driver,15);
        System.out.println("Clicking on element " + elementName);
        try {
            wait.until(ExpectedConditions.visibilityOf(xpath)).click();
            logger.log(LogStatus.PASS,"Clicking on element " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to click on " + elementName + " Error:" + e);
            logger.log(LogStatus.FAIL,"Unable to click on " + elementName + " Error:" + e);
            getScreenShot(driver,elementName,logger);
        }//End of Click Exception
    }//End of Click Method

    //Creating Void Submit Method for any Web Element
    public static void submitMethod(WebDriver driver, WebElement xpath, ExtentTest logger,String elementName){
        //Declare Local Explicit Wait
        WebDriverWait wait = new WebDriverWait(driver,15);
        System.out.println("Submitting on element " + elementName);
        try {
            wait.until(ExpectedConditions.visibilityOf(xpath)).submit();
            logger.log(LogStatus.PASS,"Submitting on element " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to submit on " + elementName + " Error:" + e);
            logger.log(LogStatus.FAIL,"Unable to submit on " + elementName + " Error:" + e);
            getScreenShot(driver,elementName,logger);
        }//End of Submit Exception
    }//End of Submit Method

    //Creating Void sendKeys Method for any Web Element
    public static void sendKeysMethod(WebDriver driver, WebElement xpath, String userData, ExtentTest logger,String elementName){
        //Declare Local Explicit Wait
        WebDriverWait wait = new WebDriverWait(driver,15);
        System.out.println("Typing on element " + elementName);
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOf(xpath));
            //Clear First
            element.clear();
            //Enter User Data
            element.sendKeys(userData);
            logger.log(LogStatus.PASS,"Typing on element " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to type on " + elementName + " Error:" + e);
            logger.log(LogStatus.FAIL,"Unable to type on " + elementName + " Error:" + e);
            getScreenShot(driver,elementName,logger);
        }//End of Click sendKeys Method Exception
    }//end of click sendKeys Method

    //Creating Select Dropdown by Visible Text Method for any text WebElement
    public static void dropDownSelect(WebDriver driver,WebElement xpath,String userSelect, ExtentTest logger, String elementName){
        WebDriverWait wait = new WebDriverWait(driver, 15);
        System.out.println("Selecting " + userSelect + " from drop down " + elementName);
        try{
            WebElement element = wait.until(ExpectedConditions.visibilityOf(xpath));
            Select select = new Select(element);
            select.selectByVisibleText(userSelect);
            logger.log(LogStatus.PASS,"Selecting " + userSelect + " from drop down " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to select value from drop down - " + elementName + " - " + e);
            logger.log(LogStatus.FAIL,"Unable to select value from drop down - " + elementName + " - " + e);
            getScreenShot(driver,elementName,logger);
        }//End of Select Dropdown Exception
    }//End of Select Dropdown Method

    //Creating scrollingByPixel Method for any WebElement
    public static void scrollingByPixelMethod(WebDriver driver,String x, String y){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        //Scroll to the view by pixels
        jse.executeScript("window.scrollBy("  + x + " ," + y + ")");
        //End of Scroll by Pixel Exception
    }//End of Scroll by Pixel Method

    //Creating Return getText Method for any Text Web Element
    public static String getTextMethod(WebDriver driver, WebElement xpath, ExtentTest logger, String elementName){
        //Declare Local Explicit Wait
        WebDriverWait wait = new WebDriverWait(driver,15);
        System.out.println("Capturing text on element " + elementName);
        //Declare a Global Variable to Capture the Text, so I can return it
        String result = null;
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOf(xpath));
            //Capture Text
            result = element.getText();
            logger.log(LogStatus.PASS,"Capturing text on element " + elementName);
        } catch (Exception e) {
            System.out.println("Unable to capture text on " + elementName + " Error:" + e);
            logger.log(LogStatus.FAIL,"Unable to capture text on " + elementName + " Error:" + e);
            getScreenShot(driver,elementName,logger);
        }//End of Click getText Method Exception
        return result;
    }//End of Click getText Method

    //Method to Capture Screenshot When Logger Fails
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
            logger.log(LogStatus.FAIL, "Error Occurred while taking Screenshot");
            e.printStackTrace();
        }//End of get Screenshot Method Exception
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