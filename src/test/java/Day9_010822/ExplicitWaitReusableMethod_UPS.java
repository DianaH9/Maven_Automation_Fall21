package Day9_010822;

import Reusable_Library.Reusable_Actions;
import org.openqa.selenium.WebDriver;

public class ExplicitWaitReusableMethod_UPS {
    public static void main(String[] args) {

        WebDriver driver = Reusable_Actions.setDriver();

        //Navigate to UPS
        driver.navigate().to("https://www.ups.com/us");

        //Click on Track
        Reusable_Actions.clickMethod(driver, "//*[text()='Tracking']", "Track");

        //Click on Track a Package
        Reusable_Actions.clickMethod(driver, "//*[text()='Track a Package']", "Track a Package");

        //Enter any Tracking Number
        Reusable_Actions.sendKeysMethod(driver,"//*[@id='stApp_trackingNumber']","1111111111111","Enter Tracking");

        //Click on Track Button
        Reusable_Actions.clickMethod(driver,"//*[@id='stApp_btnTrack']", "Track Button");

        //Capture the error message and print out only 'We could not locate the shipment'
        String resultValue = Reusable_Actions.getTextMethod(driver, "//*[@id='stApp_error_alert_list0']","Error Message");
        //Declare array and split
        String[] arrayResult = resultValue.split("details");
        System.out.println("My error info is " + arrayResult[0]);

    }//End of Main Method
}//End of Java Class
