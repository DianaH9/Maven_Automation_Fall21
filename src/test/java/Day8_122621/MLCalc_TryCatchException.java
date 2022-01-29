package Day8_122621;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class MLCalc_TryCatchException {
    public static void main(String[] args) throws InterruptedException {

        //Call the WebDriverManager
        WebDriverManager.chromedriver().setup();
        //Call ChromeOptions
        ChromeOptions options = new ChromeOptions();
        //Set incognito and maximize the driver
        options.addArguments("start-maximized");
        options.addArguments("incognito");
        //Set my webdriver
        WebDriver driver = new ChromeDriver(options);

        //Navigate to MLCalc
        driver.navigate().to("https://www.mlcalc.com");
        Thread.sleep(2500);

        //Enter value to Purchase Price
        try {
            WebElement pPrice = driver.findElement(By.xpath("//*[@id='ma']"));
            pPrice.clear();
            pPrice.sendKeys("400000");
        } catch (Exception e) {
            System.out.println("Unable to type value on Purchase price " + e);
        }//End of Purchase Price exception

        //Click on 'Show Advance Action'
        try {
            driver.findElement(By.xpath("//*[text()='Show advanced options']")).click();
        } catch (Exception e) {
            System.out.println("Unable to click on Show Advanced Options " + e);
        }//End of 'Show Advanced Options' exception

        //Select Start Month
        Thread.sleep(1000);
        try {
            WebElement sMonth = driver.findElement(By.xpath("//*[@name='sm']"));
            Select sMonthDropdown = new Select(sMonth);
            sMonthDropdown.selectByVisibleText("Oct");
        } catch (Exception e) {
            System.out.println("Unable to select value from start month list " + e);
        }//End of Start Month exception

        //Select start year
        Thread.sleep(1000);
        try {
            WebElement syear = driver.findElement(By.xpath("//*[@name='sy']"));
            Select sMonthDropdown = new Select(syear);
            sMonthDropdown.selectByVisibleText("2027");
        }catch (Exception e){
            System.out.println("Unable to select value from start year list " + e);
        }//End of start year exception

    }//End of Main

}//End of Java Class
