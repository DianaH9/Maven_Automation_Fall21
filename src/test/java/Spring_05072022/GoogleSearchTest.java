package Spring_05072022;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchTest {
    public static void main(String[] args) throws InterruptedException {
        //Set up your Chromedriver with WebDriverManager
        WebDriverManager.chromedriver().setup();
        //Define the Webdriver I am going to use
        WebDriver driver = new ChromeDriver();

        //Go to Google Home Page
        driver.navigate().to("http://www.google.com");
        //Maximize the Driver
        driver.manage().window().maximize();
        Thread.sleep(3000);
        //Locate Element for Search Field and Type Keyword 'cars'
        driver.findElement(By.xpath("//*[@name='q']")).sendKeys("cars");
        //Submit on Google Search Button
        driver.findElement(By.xpath("//*[@name='btnK']")).submit();
        //Capture the Google Search and Print it
        String searchResult = driver.findElement(By.xpath("//*[@id='result-stats']")).getText();
        System.out.println("Result is " + searchResult);
        //Extract out the number and print the Search Number only
        String[] arrayResult = searchResult.split(" ");
        //To Replace ( and ) from the seconds that's coming from arrayList[3] use .replace command to replace it with ""(no space)
        String replaceParanth = arrayResult[3].replace("(","").replace(")","");
        System.out.println("My search number is " + arrayResult[1]);

        //Quit the driver
        driver.quit();

    }//End of Main Method
}//End of Java Class
