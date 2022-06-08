package Spring_05292022;

import Reusable_Library.Reusable_Actions;
import Reusable_Library.Reusable_Actions_Loggers;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Google_Search_HTML_Report {
    //Declare the Local driver outside so that it can be reusable with other annotation methods
    WebDriver driver;
    ExtentReports reports;
    ExtentTest logger;

    //Before suite will set the driver you are using
    @BeforeSuite
    public void SetChromeDriver() {
        driver = Reusable_Actions.setDriver();
        //Define the path to the report
        reports = new ExtentReports("src/main/java/HTML_Report/SpringAuto.html", true);
    }//End of Before Suite Annotation

    //Test Case 1: Navigate to Google and enter a keyword on search field
    @Test(priority = 1)
    public void SearchForKeyword() {
        logger = reports.startTest("Search for a keyword");
        driver.navigate().to("https://www.google.com");
        //Enter a Keyword on Search Field
        Reusable_Actions_Loggers.sendKeysMethod(driver, "//*[@name='q']", "BMW",logger , "Search Field");
        //Submit the Go Button
        Reusable_Actions_Loggers.submitMethod(driver, "//*[@name='btnK']",logger, "Google Search Button");
        //End the logger per test
        reports.endTest(logger);
    }//End of Test 1

    /*
    dependsOnMethods is used when following @Test is dependent on previous @Test Method. If the first test fails, the dependent test will get skipped
    */
    @Test(dependsOnMethods = "SearchForKeyword")
    public void CaptureSearchNumber() {
        logger = reports.startTest("Search for a Number");
        //Capture Search Result
        String result = Reusable_Actions_Loggers.getTextMethod(driver, "//*[@id='result-stats']", logger,"Search Result");
        //Split the Result by Single Space and Print out the Search Number
        String[] arrayResult = result.split(" ");
        System.out.println("Search number is " + arrayResult[1]);
        logger.log(LogStatus.INFO,"Search number is " + arrayResult[1]);
        reports.endTest(logger);
    }//End of Test 2

    @AfterSuite
    public void quitSession() {
        driver.quit();
        reports.flush();
    }//End of After Suite

}//End of Java Class
