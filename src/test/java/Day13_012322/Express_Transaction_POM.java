package Day13_012322;

import Express_Page_Object.ExpressBaseClass;
import Reusable_Library.Reusable_Actions_Loggers;
import Reusable_Library.Reusable_Actions_Loggers_POM;
import Reusable_Library.Reusable_Annotations;
import com.relevantcodes.extentreports.LogStatus;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class Express_Transaction_POM extends Reusable_Annotations {

    @Test
    public void Express_Transaction() throws BiffException, IOException, InterruptedException, WriteException {
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
            String expMonth = writableSheet.getCell(11, i).getContents();
            String expYear = writableSheet.getCell(12, i).getContents();
            String CVV = writableSheet.getCell(13, i).getContents();

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

            //Hover on 'Women' Tab
            ExpressBaseClass.expressHomepage().mouseHoverWomen();
            //Click on 'Dress' link
            ExpressBaseClass.expressHomepage().clickDressTab();
            Thread.sleep(2000);
            //Scroll by Pixel
            Reusable_Actions_Loggers_POM.scrollingByPixelMethod(driver, "0","600");
            //Dismiss PopUp
            ExpressBaseClass.expressDressesPage().dismissPopUP();
            //Click on Second Image
            ExpressBaseClass.expressDressesPage().ClickSecondImage(1);
            Thread.sleep(1000);
            //Click on Specific Size
            ExpressBaseClass.expressDressItem().ClickSize(size);
            //Click on 'Add to Bag' button
            ExpressBaseClass.expressDressItem().ClickAddtoBag();
            //Click on 'View Bag' on Pop Up
            ExpressBaseClass.expressDressItem().ClickViewBag();
            Thread.sleep(2000);
            //Select a Quantity
            ExpressBaseClass.expressShoppingBag().SelectQuantity(quantity);
            //Click on 'Checkout' button
            ExpressBaseClass.expressShoppingBag().ClickCheckoutButton();
            Thread.sleep(2000);
            //Click 'Continue as Guest' button
            ExpressBaseClass.expressShoppingBag().ClickCheckoutAsGuest();
            Thread.sleep(2000);
            //Enter First Name
            ExpressBaseClass.expressCheckout().InputFirstName(firstName);
            //Enter Last Name
            ExpressBaseClass.expressCheckout().InputLastName(lastName);
            //Enter Email Address
            ExpressBaseClass.expressCheckout().InputEmail(email);
            //Re-Enter Email Address
            ExpressBaseClass.expressCheckout().InputConfirmEmail(email);
            //Enter Phone Number
            ExpressBaseClass.expressCheckout().InputPhoneNumber(phoneNumber);
            //Click on 'Continue' Button
            ExpressBaseClass.expressCheckout().ClickContinueButton();
            //Enter Address
            ExpressBaseClass.expressCheckout().InputAddress(address);
            //Enter ZipCode
            ExpressBaseClass.expressCheckout().InputZipcode(zipCode);
            //Enter City
            ExpressBaseClass.expressCheckout().InputCity(city);
            //Select State(NY)
            ExpressBaseClass.expressCheckout().InputState(state);
            //Click on Continue Button
            ExpressBaseClass.expressCheckout().ClickContinueButton();
            //Click on Continue Button Again
            ExpressBaseClass.expressCheckout().ClickContinueButton();
            //Enter Card Number
            ExpressBaseClass.expressCheckout().InputCardNumber(cardNumber);
            //Select Expiration Month
            ExpressBaseClass.expressCheckout().InputExpMonth(expMonth);
            //Select Expiration Year
            ExpressBaseClass.expressCheckout().InputExpYear(expYear);
            //Enter CVV
            ExpressBaseClass.expressCheckout().InputCvv(CVV);
            //Click 'Place Order' Button
            ExpressBaseClass.expressCheckout().ClickPlaceOrder();
            //Capture the Error Message for Card Number field and send it back to ErrorMessage column in Excel
            String error = ExpressBaseClass.expressCheckout().ErrorMessage();
            Label label = new Label(14,i,error);
            writableSheet.addCell(label);

            driver.manage().deleteAllCookies();
        }//End of Loop
    }//End of Test
}//End of Java Class
