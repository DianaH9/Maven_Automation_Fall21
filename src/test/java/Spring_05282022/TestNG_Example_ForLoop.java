package Spring_05282022;

import Reusable_Library.Reusable_Actions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class TestNG_Example_ForLoop {
    //Declare the Local driver outside so that it can be reusable with other annotation methods
    WebDriver driver;

    //Before suite will set the driver you are using
    @BeforeSuite
    public void SetChromeDriver() {
        driver = Reusable_Actions.setDriver();
    }//End of Before Suite Annotation

    //Test Case 1: Navigate to Google and enter a keyword on search field
    @Test
    public void SearchForKeyword() {
        ArrayList<String> cars = new ArrayList<>();
        cars.add("BMW");
        cars.add("Mercedes");
        cars.add("Tesla");
        for (int i = 0; i < cars.size(); i++) {
            driver.navigate().to("https://www.google.com");
            //Enter a Keyword on Search Field
            Reusable_Actions.sendKeysMethod(driver, "//*[@name='q']", cars.get(i), "Search Field");
            //Submit the Go Button
            Reusable_Actions.submitMethod(driver, "//*[@name='btnK']", "Google Search Button");
            //Capture Search Result
            String result = Reusable_Actions.getTextMethod(driver, "//*[@id='result-stats']", "Search Result");
            //Split the Result by Single Space and Print out the Search Number
            String[] arrayResult = result.split(" ");
            System.out.println("Search number is " + cars.get(i) + " is " + arrayResult[1]);
        }//End of Loop
    }//End of Test

    @AfterSuite
    public void quitSession() {
        driver.quit();
    }//End of After Suite
}
