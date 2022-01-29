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
    public static WebDriver driver;
    public static ExtentReports reports;
    public static ExtentTest logger;

    @BeforeSuite
    public void SetDriverAndReport(){
        driver = Reusable_Actions_Loggers.setDriver();
        reports = new ExtentReports("src/main/java/HTML_Report/Automation_Report"+ Reusable_Actions_Loggers_POM.getDateTime()+".html",true);
    }//End of Before Suite

    @BeforeMethod
    public void captureTestName(Method methodName){
        logger = reports.startTest(methodName.getName());
    }//End of Before Method

    @AfterMethod
    public void endTest(){
        reports.endTest(logger);
    }//End of After Method

    @AfterSuite
    public void endOfTestSuite(){
        //driver.quit();
        reports.flush();
    }//End of After Suite

}//End of Java Class
