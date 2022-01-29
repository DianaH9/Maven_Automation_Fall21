package Day8_122621;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class SwitchToTabs_UHC {
    public static void main(String[] args) throws InterruptedException {

        //Call the webdrivermanager
        WebDriverManager.chromedriver().setup();
        //Call Chromeoptions
        ChromeOptions options = new ChromeOptions();
        //Set incognito and maximize the driver
        options.addArguments("start-maximized");
        options.addArguments("incognito");
        //Set my webdriver
        WebDriver driver = new ChromeDriver(options);

        //Navigate to UHC
        driver.navigate().to("https://www.uhc.com");
        Thread.sleep(2500);
        //Click on find a doctor
        driver.findElement(By.xpath("//*[text()='Find a doctor']")).click();
        Thread.sleep(2500);
        //Click on select your plan dropdown and choose medicare as value
        driver.findElement(By.xpath("//*[contains(text(), 'Select your plan to sign in')]")).click();
        driver.findElement(By.xpath("//*[text()='Medicare plan']")).click();

        //To switch to new tab use arrayList
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        //Switch to new tab
        driver.switchTo().window(tabs.get(1));
        Thread.sleep(2500);
        //Click on Dismiss
        driver.findElement(By.xpath("//*[@id='alert-sticky__dismiss-button']")).click();
        Thread.sleep(1000);
        //Click on Sign In
        driver.findElement(By.xpath("//*[text()='Sign In']")).click();

    }//End of Main Method

}//End of Java Class
