package Day10_010922;

import Reusable_Library.Reusable_Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Day10_OptionalActionItem {

    //Declare the webdriver outside the annotation methods, so it can be called on all the methods
    WebDriver driver;

    @BeforeMethod
    public void SetTheDriver() {
        driver = Reusable_Actions.setDriver();
        //Navigate to BestBuy Homepage
        driver.navigate().to("https://www.bestbuy.com");
        try {
            //Click on Dismiss
            driver.findElement(By.xpath("//*[@class='c-close-icon-svg']")).click();
        } catch (Exception e) {
            System.out.println("Pop up did not appear");
        }//End of Dismiss Exception
    }//End of Before Method

    @Test(priority = 1)
    public void macPurchase() throws InterruptedException {
        //Verify the Page Title appears as expected
        String actualTitle = driver.getTitle();
        if (actualTitle.contains("Best Buy | Official Online Store")) {
            System.out.println("Title matches " + actualTitle);
        } else {
            System.out.println("Title doesn't match. Actual title is " + actualTitle);
        }//End of Page Title Exception

        //Click on search field
        Reusable_Actions.clickMethod(driver,"//*[@id = 'gh-search-input']", "Search Field");

        //Enter laptop name on search field
        Reusable_Actions.sendKeysMethod(driver, "//*[@id = 'gh-search-input']","Macbook", "Macbook Laptop");

        //Click on Search button
        Reusable_Actions.clickMethod(driver,"//*[@class = 'header-search-icon']", "Search button");

        Thread.sleep(2000);
        try {
            //Click on Dismiss
            driver.findElement(By.xpath("//*[@id='shop-master-ad-94243778']")).click();
        } catch (Exception e) {
            System.out.println("Pop up did not appear");
        }//End of Dismiss Exception

        Reusable_Actions.clickMethod(driver,"//*[@id = '6418601']", "Click Item");

        //Click to Add Item to Cart
        Reusable_Actions.clickMethod(driver, "//*[@id = '6450853']", "Add to Cart");

        //Click on Cart
        Reusable_Actions.clickMethod(driver, "//*[text() = '6450853']", "Cart");

        //Click on Checkout
        Reusable_Actions.clickMethod(driver, "//*[text() = 'Checkout']", "Checkout");

        //Click on Continue as Guest
        Reusable_Actions.clickMethod(driver, "//*[text() = 'Continue as Guest']", "Continue as Guest");

        //Enter First Name into Input
        Reusable_Actions.sendKeysMethod(driver, "//*[@id = 'firstName']", "Diana", "First Name");

        //Enter Last Name into Input
        Reusable_Actions.sendKeysMethod(driver,"//*[@id = 'lastName']", "Huang", "Last Name");

        //Enter Address into Input
        Reusable_Actions.sendKeysMethod(driver, "//*[@id = 'street']", "1711 65th Street", "Address");

        //Enter City into Input
        Reusable_Actions.sendKeysMethod(driver,"//*[@id = 'city']", "Brooklyn", "City");

        //Select NY from state dropdown by visible text
        WebElement states = driver.findElement(By.xpath("//*[@id ='state']"));
        Select state = new Select(states);
        state.selectByVisibleText("NY");

        //Enter zipcode into input
        Reusable_Actions.sendKeysMethod(driver,"//*[@id= 'zipcode']", "11204", "Zipcode");





    }//End of Test 1

    //@Test(priority = 2)
    //public void windowsHpPurchase() {

   // }//End of Test 2


}//End of Java Class
