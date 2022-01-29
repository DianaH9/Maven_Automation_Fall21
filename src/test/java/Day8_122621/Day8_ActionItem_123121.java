package Day8_122621;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
import java.util.List;

public class Day8_ActionItem_123121 {
    public static void main(String[] args) throws InterruptedException {

        // Set an Array List for Zipcodes
        ArrayList<String> zipCode = new ArrayList<>();
        zipCode.add("11204");
        zipCode.add("11215");
        zipCode.add("11234");

        //Call the WebDriverManager
        WebDriverManager.chromedriver().setup();
        //Call ChromeOptions
        ChromeOptions option = new ChromeOptions();
        //Set web browser to maximized
        option.addArguments("start-maximized");
        //Set web browser to incognito
        option.addArguments("incognito");
        //Set my WebDriver
        WebDriver driver = new ChromeDriver(option);

        for (int i = 0; i < zipCode.size(); i++) {

            //Navigate to WeightWatchers
            driver.navigate().to("https://www.weightwatchers.com");
            Thread.sleep(2000);

            try {
                //Click on Dismiss
                driver.findElement(By.xpath("//*[text()='No Thanks']")).click();
            } catch (Exception e) {
                System.out.println("Pop up did not appear");
            }//End of Dismiss Exception

            //Click on Attend dropdown and select Unlimited Workshops as value
            try {
                driver.findElement(By.xpath("//*[@data-e2e-name='attend']")).click();
                //Click on the value Unlimited Workshops from the dropdown
                driver.findElement(By.xpath("//*[@class='MenuItem_subtitle__3LoiE']")).click();
            } catch (Exception e) {
                System.out.println("Unable to select Attend and unable to select on value " + e);
            }//End of Attend/Dropdown exception
            Thread.sleep(2000);

            //Click on Find Studio Link
            try {
                driver.findElement(By.xpath("//*[text() ='Studio']")).click();
            } catch (Exception e) {
                System.out.println("Unable to click on Find Studio Link" + e);
            }//End of Find Studio Link Exception
            Thread.sleep(1000);

            //Enter zipcode into input
            try {
                driver.findElement(By.xpath("//*[@id='location-search']")).sendKeys(zipCode.get(i));
            } catch (Exception e) {
                System.out.println("Unable to input zipcodes" + e);
            }//End of ZipCode Input
            Thread.sleep(2000);

            // Click on Search Arrow
            try {
                driver.findElement(By.xpath("//*[@id='location-search-cta']")).click();
            } catch (Exception e) {
                System.out.println("Unable to click on Search Arrow" + e);
            }//End of Search Arrow Exception
            Thread.sleep(2000);

            //Store WebElement as list for findElements
            try {
                List<WebElement>
                        myList = driver.findElements(By.xpath("//*[@class='linkUnderline-1_h4g']"));

                if (i == 0) {
                    myList.get(i).click();// If i is 0, then click on third link
                    Thread.sleep(2000);
                } if (i == 1) {
                    myList.get(i).click();// If i is 1, then click on second link
                    Thread.sleep(2000);
                } if (i == 2){
                    myList.get(i).click();//If i is 2, then click on first link
                    Thread.sleep(2000);
                }//End of If Conditions
            } catch (Exception e) {
                System.out.println("Unable to store WebElement as list for findElements" + e);
            }//End of Store WebElement Exception

            //Capture the entire address and print the address
            try {
                String result = driver.findElement(By.xpath("//*[@class='address-2PZwW']")).getText();
                System.out.println("Results location is " + result);
            } catch (Exception e) {
                System.out.println("Unable to capture address and print address" + e);
            }//End of Address Capture and Print Address Exception
            Thread.sleep(2000);

            //Scroll to the Virtual Schedule Hours table
            try {
                //Set Javascript command for scrolling
                JavascriptExecutor jse = (JavascriptExecutor) driver;
                //Scroll to the view by pixels
                jse.executeScript("scroll(0,1500)");
                Thread.sleep(2000);
            }catch (Exception e){
                System.out.println("Unable to scroll to virtual schedule hours " + e);
            }//End of Virtual Schedule Hours Table Exception

            //Capture text for Virtual Schedule Hours table
            try {
                String scheduleHours = driver.findElement(By.xpath("//*[contains(@class,'scheduleContainer')]")).getText();
                Thread.sleep(2000);
                System.out.println("Virtual Schedule Hours are " + scheduleHours);
            }catch (Exception e){
                System.out.println("No Virtual Schedule Hours Available " + e);
            }//End of Capture Virtual Schedule Hours Exception

        }//End of Loop
    }//End of Main Method
}//End of Java Class
