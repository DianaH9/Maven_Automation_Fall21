package Spring_05222022;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class MouseActions {
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

        //Navigate to USPS Home Page
        driver.navigate().to("https://www.usps.com");
        Thread.sleep(2000);

        //Declare and Define Mouse Actions
        Actions mouseActions = new Actions(driver);
        //Hover to Send Tab
        WebElement sendTab = driver.findElement(By.xpath("//*[@id='mail-ship-width']"));
        mouseActions.moveToElement(sendTab).perform();

        //Click on Tracking Using MouseActions
        WebElement tracking = driver.findElement(By.xpath("//*[text()='Tracking']"));
        mouseActions.moveToElement(tracking).click().perform();
        Thread.sleep(2000);

        //Click then Type an Invalid Tracking Number using SendKeys with mouse Action
        WebElement trackingField = driver.findElement(By.xpath("//*[@id='tracking-input']"));
        mouseActions.moveToElement(trackingField).click().perform();
        mouseActions.moveToElement(trackingField).sendKeys("12345678").perform();


    }//End of Main Method
}//End of Java Class
