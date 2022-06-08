package Spring_05142022;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FindElementsExample {
    public static void main(String[] args) throws InterruptedException {
        //Go to Bing, Click on Second Element of the links by using Class and Index

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

        //Navigate to Bing Home
        driver.navigate().to("https://www.bing.com");
        Thread.sleep(3000);

        //Click on Images using Class Property with Index of 1
        //to Ignore white space in the property value we can use contains command in xpath
        driver.findElements(By.xpath("//li[contains(@class,'scope')]")).get(0).click();




    }//End of Main Method
}//End of Java Class
