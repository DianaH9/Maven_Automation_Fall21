package Day12_011622;

import Day9_010822.Reusable_Actions;
import Reusable_Library.Reusable_Actions_Loggers;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class Day12_ActionItem_012022 {
    WebDriver driver;
    ExtentReports reports;
    ExtentTest logger;

    @BeforeSuite
    public void SetTheDriver() {
        driver = Reusable_Actions.setDriver();
        reports = new ExtentReports("C:/Users/missd/Downloads/HTML_Reports/ExpressAI.html", true);
    }//End of Pre-Conditions

    @Test()
    public void expressTest() throws BiffException, IOException, InterruptedException, WriteException {
        logger = reports.startTest("Making a Purchase on Express");
        Workbook readableFile = Workbook.getWorkbook(new File("src/main/resources/ExpressAI.xls"));
        Sheet readablesheet = readableFile.getSheet(0);
        int rowCount = readablesheet.getRows();
        System.out.println("My readable row count is " + rowCount);

        WritableWorkbook writableFile = Workbook.createWorkbook(new File("src/main/resources/ExpressAI_Results.xls"), readableFile);
        WritableSheet writableSheet = writableFile.getSheet(0);
        int rowCount2 = writableSheet.getRows();
        System.out.println("My writable row count is " + rowCount2);

        for (int i = 1; i < rowCount2; i++) {
            String size = writableSheet.getCell(0, i).getContents();
            String quantity = writableSheet.getCell(1, i).getContents();
            String firstName = writableSheet.getCell(2, i).getContents();
            String lastName = writableSheet.getCell(3, i).getContents();
            String email = writableSheet.getCell(4, i).getContents();
            String phoneNumber = writableSheet.getCell(5, i).getContents();
            String address = writableSheet.getCell(6, i).getContents();
            String zipCode = writableSheet.getCell(7, i).getContents();
            String city = writableSheet.getCell(8, i).getContents();
            String state = writableSheet.getCell(9, i).getContents();
            String cardNumber = writableSheet.getCell(10, i).getContents();
            String expMonth = writableSheet.getCell(11, i ).getContents();
            String expYear = writableSheet.getCell(12,i).getContents();
            String CVV = writableSheet.getCell(13,i).getContents();

            //Navigate to Express
            logger.log(LogStatus.INFO, "Navigate to Express Home Page");
            driver.navigate().to("https://www.express.com");
            //Verify the Welcome Page Title Appears as expected
            String actualTitle = driver.getTitle();
            if (actualTitle.contains("Men's and Women's Clothing")) {
                System.out.println("Title matches " + actualTitle);
            } else {
                System.out.println("Title doesn't match. Actual title is " + actualTitle);
            }//End of Welcome Page Title Exception

            //Hover on 'Women' tab
            Reusable_Actions_Loggers.mouseHover(driver, "//*[text()='Women']", logger, "Women Tab");
            //Click on 'Dress' link
            Reusable_Actions_Loggers.clickMethod(driver, "//*[text()='Dresses']", logger, "Dresses Link");
            Thread.sleep(3000);
            //Scroll by Pixel
            Reusable_Actions_Loggers.scrollingByPixelMethod(driver, "0","600");
            //Dismiss PopUp
            try {
                //Click on Dismiss
                driver.findElement(By.xpath("//*[@name='bluecoreCloseButton']")).click();
            } catch (Exception e) {
                System.out.println("Pop up did not appear");
            }//End of Dismiss Exception
            //Click on Second Image
            Reusable_Actions_Loggers.clickByIndex(driver, "//*[contains(@class, '-qIS3zH7eoemBZF9mo1K5')]", 1, logger,"Second Image" );
            Thread.sleep(3000);
            //Click on Specific Size
            Reusable_Actions_Loggers.clickMethod(driver,"//*[text()= '" + size + "']", logger, "Size");
            //Click on 'Add to Bag' button
            Reusable_Actions_Loggers.clickMethod(driver, "//*[text()= 'Add to Bag']",logger, "Add to Bag");
            //Click on 'View Bag' on Pop Up
            Reusable_Actions_Loggers.clickMethod(driver,"//*[text()= 'View Bag']", logger,"View Bag");
            Thread.sleep(3000);
            //Select a Quantity
            Reusable_Actions_Loggers.dropDownSelect(driver, "//*[@id= 'qdd-0-quantity']", quantity, logger, "Quantity");
            //Click on 'Checkout' button
            Reusable_Actions_Loggers.clickMethod(driver, "//*[text()= 'Checkout']", logger,"Checkout");
            Thread.sleep(3000);
            //Click 'Continue as Guest' button
            Reusable_Actions_Loggers.clickMethod(driver, "//*[text()= 'Checkout as Guest']", logger,"Continue as Guest");
            Thread.sleep(3000);
            //Enter First Name
            Reusable_Actions_Loggers.sendKeysMethod(driver, "//*[@name = 'firstname']", firstName, logger,"First Name");
            //Enter Last Name
            Reusable_Actions_Loggers.sendKeysMethod(driver, "//*[@name = 'lastname']", lastName, logger, "Last Name" );
            //Enter Email Address
            Reusable_Actions_Loggers.sendKeysMethod(driver, "//*[@name = 'email']", email, logger, "Email Address");
            //Re-Enter Email Address
            Reusable_Actions_Loggers.sendKeysMethod(driver, "//*[@name = 'confirmEmail']", email, logger, "Email Address");
            //Enter Phone Number
            Reusable_Actions_Loggers.sendKeysMethod(driver, "//*[@name = 'phone']", phoneNumber, logger, "Phone Number");
            //Click on 'Continue' Button
            Reusable_Actions_Loggers.clickMethod(driver, "//*[text() = 'Continue']", logger," Continue Button");
            //Enter Address
            Reusable_Actions_Loggers.sendKeysMethod(driver, "//*[@name = 'shipping.line1']", address, logger, "Address");
            //Enter ZipCode
            Reusable_Actions_Loggers.sendKeysMethod(driver, "//*[@name = 'shipping.postalCode']", zipCode, logger, "ZipCode");
            //Enter City
            Reusable_Actions_Loggers.sendKeysMethod(driver, "//*[@name = 'shipping.city']", city, logger, "City");
            //Select State(NY)
            Reusable_Actions_Loggers.dropDownSelect(driver, "//*[@name = 'shipping.state']", state, logger, "State" );
            //Click on Continue Button
            Reusable_Actions_Loggers.clickMethod(driver, "//*[text() = 'Continue']",logger, "Continue Button");
            //Click on Continue Button Again
            Reusable_Actions_Loggers.clickMethod(driver, "//*[text() = 'Continue']",logger, "Continue Button");
            //Enter Card Number
            Reusable_Actions_Loggers.sendKeysMethod(driver, "//*[@id = 'creditCardNumberInput']", cardNumber,logger,"Card Number");
            //Select Expiration Month
            Reusable_Actions_Loggers.dropDownSelect(driver, "//*[@name = 'expMonth']", expMonth, logger, "Expiration Month");
            //Select Expiration Year
            Reusable_Actions_Loggers.dropDownSelect(driver, "//*[@name = 'expYear']", expYear, logger, "Expiration Year");
            //Enter CVV
            Reusable_Actions_Loggers.sendKeysMethod(driver, "//*[@name = 'cvv']", CVV, logger, "CVV");
            //Click 'Place Order' Button
            Reusable_Actions_Loggers.clickMethod(driver, "//*[text() = 'Place Order']", logger, "Place Order");
            //Capture the Error Message for Card Number field and send it back to ErrorMessage column in Excel
            String error = Reusable_Actions_Loggers.getTextMethod(driver,"//*[@id = 'rvn-note-NaN']", logger, "Error Message" );
            Label label = new Label(14,i,error);
            writableSheet.addCell(label);

            driver.manage().deleteAllCookies();
        }//End of Loop

        reports.endTest(logger);
        writableFile.write();
        writableFile.close();
    }//End of Test

    @AfterSuite
    public void endTest() {
        driver.quit();
        reports.flush();
    }//End of After Suite

}//End of Java Class
