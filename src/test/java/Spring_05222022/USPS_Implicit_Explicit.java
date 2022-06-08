package Spring_05222022;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class USPS_Implicit_Explicit {
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

        //Set your Global Implicit Wait
        //driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);

        //Navigate to USPS
        driver.navigate().to("https://www.usps.com");

        //Declare Mouse Actions
        Actions actions = new Actions(driver);

        //Declare and Define Explicit Wait
        WebDriverWait wait = new WebDriverWait(driver, 8);

        //Hover to Quick Tools
        WebElement quickTools = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Quick Tools']")));
        actions.moveToElement(quickTools).perform();

        //Click on Track a Package
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Track a Package']"))).click();

        //Click and then Type on Track a Package Field
        WebElement packageField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='tracking-input']")));
        packageField.click();
        packageField.sendKeys("123456789");


    }//End of Main Method
}//End of Java Class
