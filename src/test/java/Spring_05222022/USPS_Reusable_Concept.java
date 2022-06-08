package Spring_05222022;

import Reusable_Library.Reusable_Actions;
import org.openqa.selenium.WebDriver;

public class USPS_Reusable_Concept {
    public static void main(String[] args) throws InterruptedException {

        //Setting the Local Driver to Reusable setDriver Method
        WebDriver driver = Reusable_Actions.setDriver();

        //Navigate to USPS Home Page
        driver.navigate().to("https://www.usps.com");

        //Hovering to the Quick Tools
        Reusable_Actions.mouseHover(driver, "//*[text()='Quick Tools']", "Quick Tools");

        //Hover to Send Tab
        Reusable_Actions.mouseHover(driver, "//*[@id='mail-ship-width']", "Send Tab");

        //Click on Calculate A Price
        Reusable_Actions.clickMethod(driver, "//*[@class='tool-calc']", "Calculate a Price");

        //Print out Header Text Info
        String result = Reusable_Actions.getTextMethod(driver, "//*[@class='header-usps row']", "Header Info");
        System.out.println("My header info is " + result);

        //Enter my Zipcode
        Reusable_Actions.sendKeysMethod(driver, "//*[@id='Origin']", "11204", "Zipcode");

    }//End of Main Method
}//End of Java Class
