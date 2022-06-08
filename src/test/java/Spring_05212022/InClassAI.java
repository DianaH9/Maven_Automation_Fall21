package Spring_05212022;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class InClassAI {
    public static void main(String[] args) throws InterruptedException {
        //Setup your Chromedriver with WebDriverManager
        WebDriverManager.chromedriver().setup();
        //Set ChromeOptions Arguments
        ChromeOptions options = new ChromeOptions();
        //Set the Condition to incognito mode
        options.addArguments("incognito");
        //Set the condition to maximize/fullscreen your driver
        options.addArguments("start-maximized");
        //For Mac use FullScreen
        //options.addArguments("start-fullscreen");
        //Define the webdriver I am going to use
        WebDriver driver = new ChromeDriver(options);

        ArrayList<String> destState = new ArrayList<>();
        destState.add("Hawaii");
        destState.add("Florida City");
        destState.add("Cancun");

        ArrayList<String> checkIn = new ArrayList<>();
        checkIn.add("5");
        checkIn.add("6");
        checkIn.add("7");

        ArrayList<String> checkOut = new ArrayList<>();
        checkOut.add("15");
        checkOut.add("16");
        checkOut.add("17");

        for (int i = 0; i < 1; i++) {
            // Navigate to Hotels webpage
            driver.navigate().to("https://www.hotels.com");
            Thread.sleep(2000);

            //Click on destination on the search field
            try {
                WebElement destinationClick = driver.findElement(By.xpath("//*[@class='uitk-fake-input uitk-form-field-trigger']"));
                destinationClick.click();
            }catch (Exception e) {
                System.out.println("Unable to locate destination " + e);
            }

            //Type destination on the search field
            try {
                WebElement destinationSearch = driver.findElement(By.xpath("//*[@id='location-field-destination']"));
                destinationSearch.sendKeys(destState.get(i));
                Thread.sleep(2000);
            }catch (Exception e) {
                System.out.println("Unable to locate destination " + e);
            }

            //Click the first dropdown link
            try {
                //Select Loan Type from the dropdown
                driver.findElements(By.xpath("//li[contains(@class,'uitk-typeahead-result-item has-subtext')]")).get(0).click();
                Thread.sleep(2000);
            }catch (Exception e) {
                System.out.println("Unable to click first destination link " + e);
            }

            //Enter CheckIn date on Check in field
            try {
                //
                WebElement checkInClick = driver.findElement(By.xpath("//*[@id ='d1-btn']"));
                checkInClick.click();
                Thread.sleep(2000);
                WebElement checkInDate = driver.findElements(By.xpath("//*[@data-day='"+checkIn.get(i)+"']")).get(0);
                checkInDate.click();
                Thread.sleep(2000);
                //Click on Button
                driver.findElement(By.xpath("//*[@data-stid='apply-date-picker']")).click();
            }catch (Exception e) {
                System.out.println("Unable to click first destination link " + e);
            }

            //Enter CheckOut date on Check Out field
            try {
                //
                WebElement checkOutClick = driver.findElement(By.xpath("//*[@id ='d2-btn']"));
                checkOutClick.click();
                Thread.sleep(2000);
                WebElement checkOutDate = driver.findElements(By.xpath("//*[@data-day='"+checkOut.get(i)+"']")).get(0);
                checkOutDate.click();
                Thread.sleep(2000);
                //Click on Button
                driver.findElement(By.xpath("//*[@data-stid='apply-date-picker']")).click();
            }catch (Exception e) {
                System.out.println("Unable to click first destination link " + e);
            }

            //Click on Travelers Tab
            try {
                driver.findElement(By.xpath("//*[@data-testid='travelers-field-trigger']")).click();
            }catch (Exception e) {
                System.out.println("Unable to click first destination link " + e);
            }

            //Click on Search Button
            try {
                driver.findElement(By.xpath("//*[@data-testid='submit-button']")).click();
            }catch (Exception e) {
                System.out.println("Unable to click on Search Button " + e);
            }

            Thread.sleep(2000);

            //Store WebElement as list for findElements
            try {
                List<WebElement>
                        myList = driver.findElements(By.xpath("//*[@class='listing__link uitk-card-link']"));

                if (i == 0) {
                    myList.get(i).click();// If i is 0, then click on first link
                    Thread.sleep(2000);
                } if (i == 1) {
                    myList.get(i).click();// If i is 1, then click on third link
                    Thread.sleep(2000);
                } if (i == 2){
                    myList.get(i).click();//If i is 2, then click on second link
                    Thread.sleep(2000);
                }//End of If Conditions
            } catch (Exception e) {
                System.out.println("Unable to store WebElement as list for findElements" + e);
            }//End of Store WebElement Exception















        }//End of For Loop









    }//End of Main Method
}//End of Java Class
