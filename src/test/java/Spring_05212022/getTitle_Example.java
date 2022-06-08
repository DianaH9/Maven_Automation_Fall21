package Spring_05212022;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class getTitle_Example {
    public static void main(String[] args) {
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

        //Navigate to Google
        driver.navigate().to("https://www.google.com");
        //Capture the title of the page and compare it with your expected title "GOOGLE"
        String actualTitle = driver.getTitle();
        if(actualTitle.equals("Google")) {
            System.out.println("My title matches");
        }else {
            System.out.println("Title doesn't match. Actual Title is " + actualTitle);
        }//End of Actual Title Exception
    }//End of Main Method
}//End of Java Class
