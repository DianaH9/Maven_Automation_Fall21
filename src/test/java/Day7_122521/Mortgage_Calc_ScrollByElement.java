package Day7_122521;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Mortgage_Calc_ScrollByElement {
    public static void main(String[] args) throws InterruptedException {
        //Webdriver manager to open by driver
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        //Start maximized
        options.addArguments("start-maximized");
        //Set the driver
        WebDriver driver = new ChromeDriver(options);

        //Navigate to mortgage calculator
        driver.navigate().to("https://www.mortgagecalculator.org");
        Thread.sleep(2500);

        //Scroll to the window of loan view
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        //Scroll to the view by element 'Home Value' text
        //Declare as WebElement
        WebElement homeValueText = driver.findElement(By.xpath("//*[contains(text(),'Home Value:')]"));
        //Actually scroll down to your set web element
        jse.executeScript("arguments[0].scrollIntoView(true);", homeValueText);

        Thread.sleep(2000);
        driver.quit();

    }//End of Main Method
}//End of Java Class
