package Spring_05152022;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;

public class Exception_MortgageCalc {
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

        ArrayList<String> pPriceList = new ArrayList<>();
        pPriceList.add("450000");
        pPriceList.add("470000");
        pPriceList.add("500000");

        ArrayList<String> sMonthList = new ArrayList<>();
        sMonthList.add("Jun");
        sMonthList.add("Jul");
        sMonthList.add("Aug");

        for (int i = 0; i < sMonthList.size(); i++) {
            //Navigate to Mortgage Calculator
            driver.navigate().to("https://www.mlcalc.com");
            Thread.sleep(3000);

            //Handle Exception for Purchase Price
            try {
                WebElement pPrice = driver.findElement(By.xpath("//*[@id='ma']"));
                pPrice.clear();
                pPrice.sendKeys(pPriceList.get(i));
            } catch (Exception e) {
                //Print out the exception
                System.out.println("Unable to locate Purchase Price " + e);
            }//End of Purchase Price Exception

            //Handle Exception for Show Advance Option Button
            try {
                driver.findElement(By.xpath("//*[text()='Show advanced options']")).click();
            } catch (Exception e) {
                //Print out the Exception
                System.out.println("Unable to locate Show Advance Option Button " + e);
            }//End of Show Advance Option Exception

            //Handle Exception for Start Month Dropdown
            try {
                WebElement startMonth = driver.findElement(By.xpath("//*[@name='sm']"));
                Select dropdown = new Select(startMonth);
                dropdown.selectByVisibleText(sMonthList.get(i));
            } catch (Exception e) {
                //Print out the Exception
                System.out.println("Unable to locate Start Month Dropdown " + e);
            }//End of Start Month Dropdown Exception

            //Handle Exception for Calculate Button
            try {
                driver.findElement(By.xpath("//*[@value='Calculate']")).click();
            } catch (Exception e) {
                //Print out the Exception
                System.out.println("Unable to locate Calculate Button " + e);
            }//End of Calculate Exception

            Thread.sleep(3000);
            //Handle Exception for Monthly Payment
            try {
                String mntPayment = driver.findElements(By.xpath("//div[@style='font-size: 32px']")).get(0).getText();
                System.out.println("Monthly payment is " + mntPayment);
            } catch (Exception e) {
                //Print out the Exception
                System.out.println("Unable to locate monthly payment text " + e);
            }//End of Monthly Payment Exception

        }//End of Loop
        // Quit the driver
        driver.quit();
    }//End of Main Method
}//End of Java Class
