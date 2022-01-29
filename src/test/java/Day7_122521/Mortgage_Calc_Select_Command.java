package Day7_122521;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class Mortgage_Calc_Select_Command {
    public static void main(String[] args) throws InterruptedException {
        //Webdriver manager to open by driver
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        //Start maximized
        options.addArguments("start-maximized");
        options.addArguments("incognito");
        //option.addArguments("headless");
        //Set the driver
        WebDriver driver = new ChromeDriver(options);

        //Navigate to Mortgage site
        driver.navigate().to("https://www.mortgagecalculator.org");
        //driver.manage().window().fullscreen();
        Thread.sleep(2500);

        //Scroll to the window loan view
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        //Scroll to the view pixels
        jse.executeScript("scroll(0,450)");

        //Clear and type your new home value
        WebElement homeVal = driver.findElement(By.xpath("//*[contains(@name,'homevalue')]"));
        homeVal.clear(); //Clear any preset values on the home value field
        homeVal.sendKeys("350000"); //Enter my name data on the home value field

        //Select my new start month let's say November
        WebElement startMonth = driver.findElement(By.xpath("//*[contains(@name,'start_month')]"));
        //Select command can only be used when the dropdown element is under 'Select' tag
        Select sMonthDropdown = new Select(startMonth);
        //Select by Visible Text
        sMonthDropdown.selectByVisibleText("Nov");
        sMonthDropdown.selectByIndex(10);

        //If the dropdown tag is not under Select then I need to click on the dropdown and click on the value
        //startMonth.click();
        //Click on the Value
        //driver.findElement(By.xpath("//*[text()='Nov']")).click();

    }//End of Main Method

}//End of Java Class
