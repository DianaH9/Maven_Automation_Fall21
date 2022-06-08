package Day9_010822;

import Reusable_Library.Reusable_Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWait_UPS {
    public static void main(String[] args) {

        WebDriver driver = Reusable_Actions.setDriver();

        //Navigate to UPS
        driver.navigate().to("https://www.ups.com/us");
        //Declaring explicit wait
        WebDriverWait wait = new WebDriverWait(driver, 15);

        //Click on Track
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text() = 'Tracking']"))).click();
        } catch (Exception e) {
            System.out.println("Unable to click on Track " + e);
        }//End of Track Exception

        //Click on Track a Package
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Track a Package']"))).click();
        } catch (Exception e) {
            System.out.println("Unable to click on Track a Package " + e);
        }//End of Track a Package Exception

    }//End of Main Method
}//End of Java Class
