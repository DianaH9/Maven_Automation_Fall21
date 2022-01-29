package Day6_121921;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FindElements_Example {

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
       // options.addArguments("headless");
        //Define the webdriver you are using
        WebDriver driver = new ChromeDriver(options);

        //Navigate to Yahoo
        driver.navigate().to("https://www.yahoo.com");
        Thread.sleep(2000);

        //Click on News link using findElements
        driver.findElements(By.xpath("//*[contains(@class,'_yb_1rhax ')]")).get(0).click();

    }//End of Main Method

}//End of Java Class
