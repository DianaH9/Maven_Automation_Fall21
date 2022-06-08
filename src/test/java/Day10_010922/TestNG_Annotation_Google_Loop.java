package Day10_010922;

import Reusable_Library.Reusable_Actions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class TestNG_Annotation_Google_Loop {

    //Declare the webdriver outside the annotation methods, so it can be called on all the methods
    WebDriver driver;

    @BeforeSuite
    public void SetTheDriver() {
        driver = Reusable_Actions.setDriver();
    }//End of Pre-Conditions

    @Test
    public void googleSearchLoop() {
        ArrayList<String> cars = new ArrayList<>();
        cars.add("BMX");
        cars.add("Mercedes");
        cars.add("Telsa");

        for (int i = 0; i < cars.size(); i++) {
            //Navigating to Goggle
            driver.navigate().to("https://www.google.com");
            //Entering a unique keyword from Array List
            Reusable_Actions.sendKeysMethod(driver, "//*[@name='q']", cars.get(i), "Search Field");
        }//End of For Loop
    }//End of Test

    @AfterSuite
    public void endSession() {
        driver.quit();
    }//End of Quit

}//End of Java Class
