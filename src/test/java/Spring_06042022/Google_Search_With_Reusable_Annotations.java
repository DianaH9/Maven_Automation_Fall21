package Spring_06042022;

import Reusable_Library.Reusable_Actions_Loggers;
import Reusable_Library.Reusable_Annotations;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

public class Google_Search_With_Reusable_Annotations extends Reusable_Annotations {

    //Test Case 1: Navigate to Google and enter a keyword on search field
    @Test(priority = 1)
    public void GoogleSearchForKeyword() {
        driver.navigate().to("https://www.google.com");
        //Enter a Keyword on Search Field
        Reusable_Actions_Loggers.sendKeysMethod(driver, "//*[@name='q']", "BMW",logger , "Search Field");
        //Submit the Go Button
        Reusable_Actions_Loggers.submitMethod(driver, "//*[@name='btnK']",logger, "Google Search Button");
    }//End of Test 1

    /*
    dependsOnMethods is used when following @Test is dependent on previous @Test Method. If the first test fails, the dependent test will get skipped
    */
    @Test(dependsOnMethods = "GoogleSearchForKeyword")
    public void GoogleCaptureSearchNumber() {
        String result = Reusable_Actions_Loggers.getTextMethod(driver, "//*[@id='result-stats']", logger,"Search Result");
        //Split the Result by Single Space and Print out the Search Number
        String[] arrayResult = result.split(" ");
        System.out.println("Search number is " + arrayResult[1]);
        logger.log(LogStatus.INFO,"Search number is " + arrayResult[1]);
    }//End of Test 2

}//End of Java Class
