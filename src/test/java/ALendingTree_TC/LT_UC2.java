package ALendingTree_TC;

import LendingTree_Page_Object.LendingTreeBaseClass;
import Reusable_Library.Reusable_Annotations;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class LT_UC2 extends Reusable_Annotations {

    @Test
    public void TC1(){
        driver.navigate().to("https://www.lendingtree.com");
        //Click on Mortgage Tab
        LendingTreeBaseClass.lendingTreeHomepage().clickMortgageTab();
        //Click on Mortgage Rates Tab
        LendingTreeBaseClass.lendingTreeHomepage().clickMortgageRatesTab();
    }//End of Test TC1

    @Test(dependsOnMethods = "TC1")
    public void TC2() throws InterruptedException {
        //Scroll into view of ZipCode Filter Element
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("scroll(0,400)");
        Thread.sleep(2000);
        //Input Zipcode into Search Bar
        LendingTreeBaseClass.lendingTreeMortgage().inputZipcode("11204");
        LendingTreeBaseClass.lendingTreeMortgage().clickUpdateRatesButton();
    }//End of Test TC2

    @Test(dependsOnMethods = "TC1")
    public void TC3(){
        //Scroll to 15-Year Fixed Header
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("scroll(0,600)");
        //Click on 15-Year Fixed Header
        LendingTreeBaseClass.lendingTreeMortgage().clickFifteenYearRateHeader();
    }//End of Test TC3

    @Test(dependsOnMethods = "TC1")
    public void TC4(){
        //Scroll to 30-Year Fixed Header
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("scroll(0,600)");
        //Click on 30-Year Fixed Header
        LendingTreeBaseClass.lendingTreeMortgage().clickThirtyYearRateHeader();
    }//End of Test TC4

}//End of Java Class
