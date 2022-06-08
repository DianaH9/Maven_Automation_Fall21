package Day10_010922;

import Reusable_Library.Reusable_Actions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

public class TestNG_GoogleSearch {

/*
   Pre-Condition - Set the driver and navigate to Google website
   Test 1 - Verify the Google title and search for Google keyword and hit submit
   Test 2 - Capture search result and only print out the search number
   Post-Condition - Quit your driver
 */

    //Declare the webdriver outside the annotation methods, so it can be called on all the methods
    WebDriver driver;

    @BeforeSuite
    public void SetTheDriver() {
        driver = Reusable_Actions.setDriver();
        //Navigate Google page
        driver.navigate().to("https://www.google.com");
    }//End of Pre-Condition

    @Test(priority = 1)
    public void SearchForAKeyword() {
        //Verify the title says 'Google'
        String actualTitle = driver.getTitle();
        if (actualTitle.equals("Google")) {
            System.out.println("Title matches as 'Google'");
        } else {
            System.out.println("Title doesn't match. Actual title is " + actualTitle);
        }//End of Multiple Conditions

        //Search for a keyword
        Reusable_Actions.sendKeysMethod(driver, "//*[@name='q']", "Cars", "Google Search");
        //Submit
        Reusable_Actions.submitMethod(driver, "//*[@name='btnK']", "Submit Button");

    }//End of Test 1

    @Test(priority = 2)
    public void CaptureSearchNumber() {
        String result = Reusable_Actions.getTextMethod(driver, "//*[@id='result-stats']", "Search Result");
        String[] arrayResult = result.split(" ");
        System.out.println("My search number for cars is " + arrayResult[1]);
    }//End of Test 2

    @AfterSuite
    public void quitSession() {
        driver.quit();
    }//End of Quit

    @BeforeMethod
    public void beforeTest() {
        System.out.println("This executes before each test");
    }//End of Before Method

    @AfterMethod
    public void afterTest() {
        System.out.println("This executes after each test");
    }//End of After Method

}//End of Java Class
