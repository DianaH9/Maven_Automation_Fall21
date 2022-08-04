package ALendingTree_TC;

import LendingTree_Page_Object.LendingTreeBaseClass;
import Reusable_Library.Reusable_Actions_Loggers_POM;
import Reusable_Library.Reusable_Annotations;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class LT_UC1 extends Reusable_Annotations {
    @Test
    public void TC1(){
        driver.navigate().to("https://www.lendingtree.com");
        //Click on Mortgage Tab
        LendingTreeBaseClass.lendingTreeHomepage().clickMortgageTab();
    }//End of Test TC1

    @Test
    public void TC2(){
        driver.navigate().to("https://www.lendingtree.com");
        //Click on Mortgage Tab
        LendingTreeBaseClass.lendingTreeHomepage().clickMortgageTab();
        //Click on Mortgage Rates Tab
        LendingTreeBaseClass.lendingTreeHomepage().clickMortgageRatesTab();
        //Scroll to the bottom of the page to locate 15-year Fixed Rate vs 30-Year Fixed Rate mortgage
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        WebElement yearRateInfo = driver.findElement(By.xpath("//*[contains(text(),'Which mortgage loan type is best? ')]"));
        jse.executeScript("arguments[0].scrollIntoView(true);", yearRateInfo);
        //Click on 15-Year Fixed Rate vs 30-Year Fixed Rate Mortgage
        LendingTreeBaseClass.lendingTreeMortgage().clickOn15To30YearRateInfo();
    }//End of Test TC2

    @Test
    public void TC3(){
        driver.navigate().to("https://www.lendingtree.com");
        //Click on Mortgage Tab
        LendingTreeBaseClass.lendingTreeHomepage().clickMortgageTab();
        //Click on Mortgage Rates Tab
        LendingTreeBaseClass.lendingTreeHomepage().clickMortgageRatesTab();
        //Scroll to the bottom of the page to locate 30-Year Fixed Rate vs 5/1 ARM Mortgage
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        WebElement yearRateInfo = driver.findElement(By.xpath("//*[contains(text(),'Which mortgage loan type is best? ')]"));
        jse.executeScript("arguments[0].scrollIntoView(true);", yearRateInfo);
        //Click on 30-Year Fixed Rate vs 5/1 ARM Mortgage
        LendingTreeBaseClass.lendingTreeMortgage().clickOnFifthARMTo30YearRateInfo();
    }//End of Test TC3

    @Test
    public void TC4(){
        driver.navigate().to("https://www.lendingtree.com");
        //Click on Mortgage Tab
        LendingTreeBaseClass.lendingTreeHomepage().clickMortgageTab();
        //Click on Mortgage Rates Tab
        LendingTreeBaseClass.lendingTreeHomepage().clickMortgageRatesTab();
        //Scroll to the bottom of the page to locate 10/1 ARM vs 5/1 ARM Mortgage
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        WebElement yearRateInfo = driver.findElement(By.xpath("//*[contains(text(),'Which mortgage loan type is best? ')]"));
        jse.executeScript("arguments[0].scrollIntoView(true);", yearRateInfo);
        //Click on 10/1 ARM vs 5/1 ARM Mortgage
        LendingTreeBaseClass.lendingTreeMortgage().clickOnTenthToFifthARMYearRateInfo();
    }//End of Test TC4

}//End of Java Class
