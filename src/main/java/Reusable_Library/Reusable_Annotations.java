package Reusable_Library;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class Reusable_Annotations {
    //Set all Global Variable here with public static
    public static WebDriver driver;
    public static ExtentReports reports;
    public static ExtentTest logger;

    //Set Before Suite for Report Path and Set Driver
    @BeforeSuite
    public void SetDriverAndReport(){
        driver = Reusable_Actions_Loggers.setDriver();
        reports = new ExtentReports("src/main/java/HTML_Report/Automation_Report"+ Reusable_Actions_Loggers_POM.getDateTime()+".html",true);
    }//End of Before Suite

    //Set Before Method to capture test name for each @Test, so it can be added to the html report later
    @BeforeMethod
    public void captureTestName(Method testName){
        logger = reports.startTest(testName.getName());
    }//End of Before Method

    //Set after Method to end the logger for each @Test in your test class
    @AfterMethod
    public void endTest(){
        reports.endTest(logger);
    }//End of After Method

    //After Suite to Flush the Report and Quit the Driver
    @AfterSuite
    public void endOfTestSuite(){
        //driver.quit();
        reports.flush();
    }//End of After Suite

}//End of Java Class
