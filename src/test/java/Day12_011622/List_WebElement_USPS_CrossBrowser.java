package Day12_011622;

import Reusable_Library.Reusable_Actions_Loggers;
import Reusable_Library.Reusable_Annotations;
import Reusable_Library.Reusable_Annotations_CrossBrowser;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.List;

public class List_WebElement_USPS_CrossBrowser extends Reusable_Annotations_CrossBrowser {

    @Test
    public void USPS_Testing_Links(){
        //Navigate to USPS
        driver.navigate().to("https://www.usps.com");

        //Using explicit wait to get the count of elements within same class group
        WebDriverWait wait = new WebDriverWait(driver,10);
        try{
            List<WebElement> uspsTabs = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//li[contains(@class,'menuheader')]")));
            System.out.println("My Nav list count is " + uspsTabs.size());
            logger.log(LogStatus.PASS,"Successfully got the count " +uspsTabs.size());
        } catch (Exception e) {
            System.out.println("Unable to locate links " + e);
            logger.log(LogStatus.FAIL,"Unable to locate links " + e);
            Reusable_Actions_Loggers.getScreenShot(driver, "Links count", logger);
        }//End of Count of Elements Exception

    }//End of test
}//End of Java Class
