package Day6_121921;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Google_ChromeOptions {
    public static void main(String[] args) throws InterruptedException {

        //Set the property of the chromedriver we are using
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        //Declare and define the Chrome options
        ChromeOptions options = new ChromeOptions();
        //Declare all the arguments you need
        //To maximize my driver
        options.addArguments("start-maximized");
        //Set as incognito mode
        options.addArguments("incognito");
        //Set as headless(running the driver on background)
        options.addArguments("headless");
        //Define the webdriver you are using
        WebDriver driver = new ChromeDriver(options);

        //Navigate to Google
        driver.navigate().to("https://www.google.com");
        Thread.sleep(2000);
        System.out.println("Navigated to Google");

        //Enter a keyword on Google search
        driver.findElement(By.xpath("//*[@name='q']")).sendKeys("cars");
        System.out.println("Entered keyword car on Google Search");

    }//End of Main Method

}//End of Java Class
