package Day6_121921;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Day6_ActionItem_122321 {

    public static void main(String[] args) throws InterruptedException {
        //Search multiple hobbies and each time capture the search number from the result page

        //Set an array
        String[] hobbies = new String[6];
        hobbies[0] = "Sewing";
        hobbies[1] = "Fishing";
        hobbies[2] = "Singing";
        hobbies[3] = "Gardening";
        hobbies[4] = "Swimming";
        hobbies[5] = "Gaming";

        //Define the WebDriver outside the for loop
        //Set the property of the chromedriver being used
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        //Declare and define the Chrome options
        ChromeOptions options = new ChromeOptions();
        //Maximize the browser
        options.addArguments("start-maximized");
        //Set to incognito mode
        options.addArguments("incognito");
        //Define the webdriver being used
        WebDriver driver = new ChromeDriver(options);

        for (int i = 0; i < hobbies.length; i++) {
            //Simply open the Bing website
            driver.navigate().to("https://www.bing.com");

            //Maximize the browser
            driver.manage().window().maximize();

            //Adding seconds to wait
            Thread.sleep(2000);

            //Searching for hobbies on Bing search field
            driver.findElement(By.xpath("//*[@name='q']")).sendKeys(hobbies[i]);

            //Hit submit on Bing Search Button
            driver.findElement(By.xpath("//*[@id='search_icon']")).submit();

            //Adding seconds to wait
            Thread.sleep(3000);

            //Capture the search result
            String result = driver.findElement(By.xpath("//*[@id='b_tween']")).getText();
            //Declaring the array variable to split the result
            String[] arrayResult = result.split(" ");
            //Print the search number only
            System.out.println("My search number for hobbies " + hobbies[i] + " is " + arrayResult[0] + ".");
        }//End of For Loop

        //Close the browser
        driver.quit();

    }//End of Main Method

}//End of Java Class

