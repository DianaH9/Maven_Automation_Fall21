package Day5_121821;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Google_Array_Test {
    public static void main(String[] args) throws InterruptedException {

        //Search multiple cities and each time capture the search number from the result page

        //Set an array
        String[] cities = new String[4];
        cities[0] = "Brooklyn";
        cities[1] = "Queens";
        cities[2] = "Manhattan";
        cities[3] = "Bronx";

        //Define the WebDriver outside the for loop
        //Set the property of the chromedriver we are using
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        //Define the webdriver you are using
        WebDriver driver = new ChromeDriver();

        for (int i = 0; i < cities.length; i++) {
            //Simply open the Google website
            driver.navigate().to("https://www.google.com");

            //Maximize my browser
            //driver.manage().window().fullscreen(); //for mac
            driver.manage().window().maximize(); //for windows

            //Anytime when you go to a new page you should put some wait statement
            Thread.sleep(2000);

            //Searching for cities on Google search field
            driver.findElement(By.xpath("//*[@name='q']")).sendKeys(cities[i]);

            //Hit submit on Google Button
            driver.findElement(By.xpath("//*[@value='Google Search']")).submit();

            //Another wait statement since we came to a new page(result page)
            Thread.sleep(3000);

            //Capture the search result and store it as a variable
            String result = driver.findElement(By.xpath("//*[@id='result-stats']")).getText();
            //Declaring the array variable to split the result
            String[] arrayResult = result.split(" ");
            //Now print the search number only
            System.out.println("My search number for city " + cities[i] + " is " + arrayResult[1]);
        }//End of For Loop

        //Quit will be defined outside of loop because you are quitting only once at the end
        driver.quit();

    }//End of Main Method

}//End of Java Class
