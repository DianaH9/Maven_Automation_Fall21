package Day9_010822;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class ImplicitWait_UPS {
    public static void main(String[] args) throws InterruptedException {
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

        //Declare and define your Global Implicit Wait for all web elements
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        //Navigate to UPS
        driver.navigate().to("https://www.ups.com/us/en/Home.page");
        Thread.sleep(2000);
        //Click on Track
        driver.findElement(By.xpath("//*[text() = 'Tracking']")).click();
        //Click on Track a Package
        driver.findElement(By.xpath("//*[text() = 'Track a Package']")).click();

    }//End of Main Method
}//End of Java Class
