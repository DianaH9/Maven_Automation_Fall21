package Spring_05142022;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebElement_mortgagecalc {
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

        //Click, Clear and Enter new value on Home Value
        WebElement homeValue = driver.findElement(By.xpath("//*[@id = 'homeval']"));
        homeValue.click();
        homeValue.clear();
        Thread.sleep(1500);
        homeValue.sendKeys("450000");

        //Click on % Ratio Button
        driver.findElement(By.xpath("//*[@value ='percent']")).click();

        //Click, Clear and Enter new data on Down Payment Field
        WebElement downPayment = driver.findElement(By.xpath("//*[@id = 'downpayment']"));
        downPayment.click();
        downPayment.clear();
        downPayment.sendKeys("5");

    }//End of Main Method
}//End of Java Class
