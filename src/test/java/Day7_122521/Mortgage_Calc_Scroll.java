package Day7_122521;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Mortgage_Calc_Scroll {
    public static void main(String[] args) throws InterruptedException {
        //Webdriver manager to open by driver
        WebDriverManager.chromedriver().setup();

        ChromeOptions options= new ChromeOptions();
        //Start maximized
        options.addArguments("start-maximized");
        //Set the driver
        WebDriver driver = new ChromeDriver(options);

        //Navigate to mortgage calculator
        driver.navigate().to("https://www.mortgagecalculator.org");
        Thread.sleep(2500);

        //Scroll to the window of loan view
        //Set you Javascript command for scrolling
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        //Scroll to the view by pixels
        jse.executeScript("scroll(0,450)");

    }//End of Main Method

}//End of Java
