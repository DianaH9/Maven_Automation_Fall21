package Day9_010822;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class MouseActions_USPS {
    public static void main(String[] args) throws InterruptedException {
        //Call the WebDriverManager
        WebDriverManager.chromedriver().setup();
        //Call ChromeOptions
        ChromeOptions option = new ChromeOptions();
        //Set web browser to maximized
        option.addArguments("start-maximized");
        //Set web browser to incognito
        option.addArguments("incognito");
        //Set my WebDriver
        WebDriver driver = new ChromeDriver(option);

        //Navigate to USPS
        driver.navigate().to("https://www.usps.com");
        Thread.sleep(2000);

        //Verify the Welcome Page Title Appears as expected
        String actualTitle = driver.getTitle();
        //By using if else to compare expected with actual title
        if (actualTitle.equals("Welcome | USPS")) {
            System.out.println("Title matches " + actualTitle);
        } else {
            System.out.println("Title doesn't match. Actual title is " + actualTitle);
        }//End of Welcome Page Title Exception

        //Declare Mouse Actions
        Actions mouseAction = new Actions(driver);

        //Hover over Send Tab to open up the dropdown list
        try {
            WebElement sendTab = driver.findElement(By.xpath("//*[text()='Send']"));
            mouseAction.moveToElement(sendTab).perform();
        } catch (Exception e) {
            System.out.println("Unable to hover to Send Tab " + e);
        }//End of Send Tab exception

        //Click on Look up a Zip Code from the dropdown
        try {
            WebElement zipCodeLookup = driver.findElement(By.xpath("//*[text()='Look Up a ZIP Code']"));
            mouseAction.moveToElement(zipCodeLookup).click().perform();
        } catch (Exception e) {
            System.out.println("Unable to click on Look Up a ZIP Code " + e);
        }//End of ZipCode Exception

    }//End of Main Method
}//End of Java Class
