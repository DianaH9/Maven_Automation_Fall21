package Spring_05152022;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class Select_MortgageCalc {
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

        //Navigate to Mortgage Calculator
        driver.navigate().to("https://www.mortgagecalculator.org");
        Thread.sleep(3000);
        //Select Start Month from the dropdown
        WebElement startMonth = driver.findElement(By.xpath("//*[@name='param[start_month]']"));
        //Define Select Command
        //Select dropDown = new Select(startMonth);
        //Select by Visible Text
        //dropDown.selectByVisibleText("Jun");

        //Clicking on Dropdown and it's value if the Dropdown Tag is not under Select Tag
        startMonth.click();
        //Click on the Value of the Start Month
        driver.findElement(By.xpath("//*[text()='Jun']")).click();

        //Select Loan Type from the dropdown
        driver.findElements(By.xpath("//li[contains(@class,'scope')]")).get(0).click();

    }//End of Main Method
}//End of Java Class
