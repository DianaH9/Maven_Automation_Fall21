package Spring_05292022;

import Reusable_Library.Reusable_Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.List;

public class USPS_List_WebElement {
    //Declare the local driver outside so that it can be Reusable with other Annotation Methods
    WebDriver driver;

    //Declare Suite will set the driver you are using
    @BeforeSuite
    public void SetChromeDriver() {
        driver = Reusable_Actions.setDriver();
    }//End of Before Suite Annotation

    @Test
    public void USPS_Tabs_Count() throws InterruptedException {
        //Navigate to USPS
        driver.navigate().to("https://www.usps.com");
        //Declare explicit wait for the tabs
        WebDriverWait wait = new WebDriverWait(driver, 10);
        //Store the Navigation tabs as a list to get the count
        List<WebElement> tabsCount = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//li[contains(@class,'menuheader')]")));
        //Print the Tab Count
        System.out.println("Tabs count is " + tabsCount.size());

        for (int i = 0; i < tabsCount.size(); i++) {
            driver.navigate().to("https://www.usps.com");
            Thread.sleep(3000);
            tabsCount = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//li[contains(@class,'menuheader')]")));
            //Click on each Tab
            tabsCount.get(i).click();
        }//End of Loop
    }//End of Test

    @AfterSuite
    public void quitSession() {
        driver.quit();
    }//End of After Suite





}//End of Java Class
