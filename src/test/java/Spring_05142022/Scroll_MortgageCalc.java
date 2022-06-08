package Spring_05142022;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Scroll_MortgageCalc {
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

        //Navigate to Mortgage Calculator Site
        driver.navigate().to("https://www.mortgagecalculator.org");
        Thread.sleep(3000);

        //Declare Javascript Executor Variable
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        //Scroll to pixel 400 on Mortgage Calc Website
        //jse.executeScript("scroll(0,800)");
        //Wait a bit for Browser to Perform Scrolling
        //Thread.sleep(3000);
        //Declare a WebElement Variable that we want to scroll into
        WebElement shareButton = driver.findElement(By.xpath("//*[@id='share_button']"));
        //Scroll into share this Calculation Button
        jse.executeScript("arguments[0].scrollIntoView(true);", shareButton);
        Thread.sleep(2000);
        //Click on the share this calculation button
        shareButton.click();
        Thread.sleep(2000);
        //Scroll back up
        jse.executeScript("scroll(0,-400)");
        Thread.sleep(2000);
        driver.quit();

    }//End of Main Method
}//End of Java Class
