package Spring_05152022;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;

public class FedilisCare_Tabs {
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

        //Navigate to Fidelis Care website
        driver.navigate().to("https://www.fideliscare.org");
        Thread.sleep(3000);

        //Click on Shop for a Plan
        //We are clicking on Index 0 because there are two elements for this xpath
        driver.findElements(By.xpath("//*[text()='Shop For a Plan']")).get(0).click();
        Thread.sleep(1000);
        //Click on Medicaid Managed Care
        driver.findElements(By.xpath("//*[text()='Medicaid Managed Care']")).get(0).click();
        Thread.sleep(1000);
        //Click on Search under Find a Doctor Card
        driver.findElement(By.xpath("//*[@href='/findadoctor']")).click();
        Thread.sleep(1000);
        //Store New Tabs in an Array List, we use getWindowHandles Method to get list of Tabs
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        //Switch to new tab, it should be at Index 1
        driver.switchTo().window(tabs.get(1));
        //Click on new Search Button
        driver.findElement(By.xpath("//*[@class='fal fa-search-plus']")).click();
        Thread.sleep(1000);
        //Close the new Tab
        driver.close();
        //Switch back to the Default tab
        driver.switchTo().window(tabs.get(0));
        //Then Click on Providers Card
        driver.findElement(By.xpath("//*[@class='fal fa-stethoscope fa-fw']")).click();
        Thread.sleep(1000);

    }//End of Main Method
}//End of Java Class
