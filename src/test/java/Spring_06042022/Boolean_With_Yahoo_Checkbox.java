package Spring_06042022;

import Reusable_Library.Reusable_Actions_Loggers;
import Reusable_Library.Reusable_Annotations;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

public class Boolean_With_Yahoo_Checkbox extends Reusable_Annotations {

    @Test(priority = 1)
    public void Yahoo_Stay_Signed_In_Checkbox_Verification()  {
        //Navigate to Yahoo
        driver.navigate().to("https://www.yahoo.com");
        //Click on Sign In
        Reusable_Actions_Loggers.clickMethod(driver, "//*[text()='Sign in']", logger,"Sign In");
        //Verify the stay signed in checkbox is selected or not
        WebDriverWait wait = new WebDriverWait(driver, 10);
        Boolean elementState = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='checkbox']"))).isSelected();
        if(elementState==true){
            logger.log(LogStatus.PASS,"Checkbox is selected as expected");
        } else {
            logger.log(LogStatus.FAIL,"Checkbox is not selected");
        }
        System.out.println("Is Element checked? " + elementState);
    }//End of Test

    @Test(priority = 2)
    public void NavigateToYahooHome(){
        //Navigate to USPS
        logger.log(LogStatus.INFO,"Navigating to Home Page");
        driver.navigate().to("https://www.yahoo.com");
    }//End of Test 2

}//End of Java Class
