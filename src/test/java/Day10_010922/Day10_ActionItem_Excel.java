package Day10_010922;

import Reusable_Library.Reusable_Actions;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class Day10_ActionItem_Excel {
    WebDriver driver;
    @BeforeSuite
    public void SetTheDriver() {
        driver = Reusable_Actions.setDriver();
    }//End of BeforeSuite

    @Test
    public void HuluDataDriven() throws InterruptedException, BiffException, IOException {
        //Step 1: Read the data from Excel sheet created
        Workbook readableFile = Workbook.getWorkbook(new File("src/main/resources/HuluExcelAI.xls"));
        //Step 2: Locating the worksheet that you created for the workbook
        Sheet readablesheet = readableFile.getSheet(0);
        //Return the physical rows present on the readable sheet
        int rowCount = readablesheet.getRows();
        System.out.println("My readable row count is " + rowCount);

        //Step 3: Create a writable file to mimic readable file to return results
        WritableWorkbook writableFile = Workbook.createWorkbook(new File("src/main/resources/HuluExcel_Results.xls"),readableFile);
        WritableSheet writableSheet = writableFile.getSheet(0);
        //Return the physical rows present on the writable sheet
        int rowCount2 = writableSheet.getRows();
        System.out.println("My writable row count is " + rowCount2);

        for (int i = 1; i < rowCount2; i++) {
            String email = writableSheet.getCell(0,i).getContents();
            String password = writableSheet.getCell(1,i).getContents();
            String name = writableSheet.getCell(2,i).getContents();
            String birthMonth = writableSheet.getCell(3,i).getContents();
            String birthDate = writableSheet.getCell(4,i).getContents();
            String birthYear = writableSheet.getCell(5,i).getContents();
            String gender = writableSheet.getCell(6,i).getContents();

            //Navigate Hulu page
            driver.navigate().to("https://www.hulu.com");
            //Verify the Welcome Page Title Appears as expected
            String actualTitle = driver.getTitle();
            //By using if else to compare expected with actual title
            if (actualTitle.equals("Stream TV and Movies")) {
                System.out.println("Title matches " + actualTitle);
            } else {
                System.out.println("Title doesn't match. Actual title is " + actualTitle);
            }//End of Welcome Page Title Exception

            //Scrolling by pixels to the bottom of the page
            Reusable_Actions.scrollingByPixelMethod(driver, "0", "3250");

            //Click on Select Button
            Reusable_Actions.clickMethod(driver, "//*[@class = 'button--cta button--black plan-card__cta plan-card__0_cta button--black ']", "Select");

            //Enter Email into Input Field
            Reusable_Actions.sendKeysMethod(driver, "//*[@id='email']", email, "Enter Email");

            //Enter Password into Input Field
            Reusable_Actions.sendKeysMethod(driver, "//*[@id='password']", password, "Enter Password");

            //Enter Name into Input Field
            Reusable_Actions.sendKeysMethod(driver, "//*[@id='firstName']", name, "Enter Name");

            //Click on element for month and click on month value
            Reusable_Actions.clickMethod(driver, "//*[@class = 'field field__month']", "Month");
            Reusable_Actions.clickMethod(driver, "//*[text()= '" + birthMonth + "']", "Month Value");

            //Click on element for date and click on date value
            Reusable_Actions.clickMethod(driver, "//*[@class= 'field field__day']", "Date");
            Reusable_Actions.clickMethod(driver, "//*[text()= '" + birthDate + "']", "Date Value");

            //Click on element for year and click on year value
            Reusable_Actions.clickMethod(driver, "//*[@class= 'field field__year']", "Year");
            Reusable_Actions.clickMethod(driver, "//*[text()= '" + birthYear + "']", "Year Value");

            //Click on element for gender and click on gender value
            Reusable_Actions.clickMethod(driver, "//*[@class= 'field gender']", "Gender");
            Reusable_Actions.clickMethod(driver, "//*[text()= '" + gender + "']", "Gender Value");

            //Click on Continue Button
            Reusable_Actions.clickMethod(driver, "//*[@class='button button--continue ']", "Click Button");

            Thread.sleep(4000);

            //Capture Subscription amount and store it in a variable and print amount
            String subAmount = Reusable_Actions.getTextMethod(driver, "//*[@class= 'ledger__summary']", "Capture Subscription Amount");
            System.out.println("My Subscription amount is " + subAmount);

            //Delete all cookies
            driver.manage().deleteAllCookies();

        }//End of Loop
    }//End of Test 1

    @Test (dependsOnMethods = "HuluDataDriven")
    public void HuluNavigate(){
        //Navigate to Hulu Home Page
        driver.navigate().to("https://www.hulu.com");

        //Click on Login Button on upper right corner
        Reusable_Actions.clickMethod(driver, "//*[@class = 'navigation__login-button navigation__action-button navigation__cta']", "Login Button");

        //Enter email
        Reusable_Actions.sendKeysMethod(driver, "//*[@id='email_id']", "QA2021@yahoo.com", "Enter Email");

        //Enter password
        Reusable_Actions.sendKeysMethod(driver, "//*[@id='password_id']", "QA1isLife", "Enter Password");

        //Click on Login button
        Reusable_Actions.clickMethod(driver, "//*[text() = 'LOG IN']", "Log In");

        //Verify the username displayed on homepage and print it out
        String result = Reusable_Actions.getTextMethod(driver, "//*[text()='Diana']", "Verify Username");
        System.out.println("Verify username is " + result);

    }//End of Test 2

    @AfterSuite
    public void afterTest() {
        System.out.println("This executes after each test");
    }//End of After Suite

}
