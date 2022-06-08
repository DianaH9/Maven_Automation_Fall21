package Spring_05292022;

import Reusable_Library.Reusable_Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Boolean_With_Checkbox {
    //Declare the local driver outside so that it can be Reusable with other Annotation Methods
    WebDriver driver;

    //Declare Suite will set the driver you are using
    @BeforeSuite
    public void SetChromeDriver() {
        driver = Reusable_Actions.setDriver();
    }//End of Before Suite Annotation

    @Test
    public void Yahoo_Stay_Signed_In_Checkbox_Verificatipn() {
        //Navigate to Yahoo
        driver.navigate().to("https://www.yahoo.com");
        //Click on Sign In
        Reusable_Actions.clickMethod(driver, "//*[text()='Sign in']", "Sign In");
        //Verify the stay signed in checkbox is selected or not
        WebDriverWait wait = new WebDriverWait(driver, 10);
        Boolean elementState = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='checkbox']"))).isSelected();
        System.out.println("Is Element checked? " + elementState);
    }//End of Test

    @AfterSuite
    public void quitSession() {
        driver.quit();
    }//End of After Suite


}//End of Java Class
