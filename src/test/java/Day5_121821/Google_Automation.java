package Day5_121821;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Google_Automation {
    public static void main(String[] args) throws InterruptedException {

        //Set the property of the chromedriver we are using
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        //Define the web driver you are using
        WebDriver driver = new ChromeDriver();

        //Simply open the Google website
        driver.navigate().to("https://www.google.com");

        //Maximize my browser
        //driver.manage().window().fullscreen(); //for mac
        driver.manage().window().maximize(); //for windows

        //Anytime when you go to a new page you should put some wait statement
        Thread.sleep(2000);

        //Searching fo cars on Google search field
        driver.findElement(By.xpath("//*[@name='q']")).sendKeys("cars");

        //Hit submit on Google Button
        driver.findElement(By.xpath("//*[@value='Google Search']")).submit();

        //Another wait statement since we came to a new page(result page)
        Thread.sleep(3000);

        //Capture the search result and store it as a variable
        String result = driver.findElement(By.xpath("//*[@id='result-stats']")).getText();
        //Declaring the array variable to split the result
        String[] arrayResult = result.split(" ");
        //Now print the search number only
        System.out.println("My search result is " + arrayResult[1]);

        //Close the browser
        driver.quit();

    }//End of Main

}//End of Java Class
