package Reusable_Library;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.lang.reflect.Method;

public class Reusable_Annotations_CrossBrowser {
    public static WebDriver driver;
    public static ExtentReports reports;
    public static ExtentTest logger;

    @Parameters("Browser")
    @BeforeSuite
    public void SetDriverAndReport(String Browser) {
        if (Browser.equalsIgnoreCase("Firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
        } else if(Browser.equalsIgnoreCase("Chrome")) {
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
            driver = new ChromeDriver(option);
        }else if(Browser.equalsIgnoreCase("Safari")){
            WebDriverManager.safaridriver().setup();
            driver.manage().window().fullscreen();
        }
        reports = new ExtentReports("src/main/java/HTML_Report/Automation_Report" + Reusable_Actions_Loggers_POM.getDateTime() + ".html", true);
    }//End of Before Suite

    @BeforeMethod
    public void captureTestName(Method methodName) {
        logger = reports.startTest(methodName.getName());
    }//End of Before Method

    @AfterMethod
    public void endTest() {
        reports.endTest(logger);
    }//End of After Method

    @AfterSuite
    public void endOfTestSuite() {
        //driver.quit();
        reports.flush();
    }//End of After Suite

}//End of Java Class
