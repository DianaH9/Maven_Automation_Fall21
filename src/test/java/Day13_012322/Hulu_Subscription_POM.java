package Day13_012322;

import Hulu_Page_Object.HuluBaseClass;
import Reusable_Library.Reusable_Actions_Loggers_POM;
import Reusable_Library.Reusable_Annotations;
import com.relevantcodes.extentreports.LogStatus;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class Hulu_Subscription_POM extends Reusable_Annotations {

    @Test
    public void Hulu_Subscription() throws BiffException, IOException, InterruptedException {
        //Step 1: Read the data from Excel sheet created
        Workbook readableFile = Workbook.getWorkbook(new File("src/main/resources/HuluExcelAI.xls"));
        //Step 2: Locating the worksheet that you created for the workbook
        Sheet readablesheet = readableFile.getSheet(0);
        //Return the physical rows present on the readable sheet
        int rowCount = readablesheet.getRows();
        System.out.println("My readable row count is " + rowCount);

        //Step 3: Create a writable file to mimic readable file to return results
        WritableWorkbook writableFile = Workbook.createWorkbook(new File("src/main/resources/HuluExcel_Results.xls"), readableFile);
        WritableSheet writableSheet = writableFile.getSheet(0);
        //Return the physical rows present on the writable sheet
        int rowCount2 = writableSheet.getRows();
        System.out.println("My writable row count is " + rowCount2);

        for (int i = 1; i < rowCount2; i++) {
            String email = writableSheet.getCell(0, i).getContents();
            String password = writableSheet.getCell(1, i).getContents();
            String name = writableSheet.getCell(2, i).getContents();
            String birthMonth = writableSheet.getCell(3, i).getContents();
            String birthDate = writableSheet.getCell(4, i).getContents();
            String birthYear = writableSheet.getCell(5, i).getContents();
            String gender = writableSheet.getCell(6, i).getContents();

            //Navigate to Hulu Home Page
            logger.log(LogStatus.INFO, "Navigating to Hulu Home Page");
            driver.navigate().to("https://www.hulu.com");
            //Verify the Welcome Page Title Appears as expected
            String actualTitle = driver.getTitle();
            if (actualTitle.contains("Stream TV and Movies")) {
                System.out.println("Title matches " + actualTitle);
            } else {
                System.out.println("Title doesn't match. Actual title is " + actualTitle);
            }//End of Welcome Page Title Exception

            // Scrolling by pixels to the bottom of the page
            Reusable_Actions_Loggers_POM.scrollingByPixelMethod(driver, "0", "3250");

            //Click on Select Button
            HuluBaseClass.huluhomepage().selectButton();

            //Enter Email into Input Field
            HuluBaseClass.huluCreateAccount().InputEmail(email);

            //Enter Password into Input Field
            HuluBaseClass.huluCreateAccount().InputPassword(password);

            //Enter Name into Input Field
            HuluBaseClass.huluCreateAccount().InputName(name);

            //Click on Element for Month and Click on Month Value
            HuluBaseClass.huluCreateAccount().ClickMonth();
            HuluBaseClass.huluCreateAccount().ClickMonthValue(birthMonth);

            //Click on Element for Date and Click on Date Value
            HuluBaseClass.huluCreateAccount().ClickDate();
            HuluBaseClass.huluCreateAccount().ClickDateValue(birthDate);

            //Click on Element for Year and Click on Year Value
            HuluBaseClass.huluCreateAccount().ClickYear();
            HuluBaseClass.huluCreateAccount().ClickYearValue(birthYear);

            //Click on Element for Gender and Click on Gender Value
            HuluBaseClass.huluCreateAccount().ClickGender();
            HuluBaseClass.huluCreateAccount().ClickGenderValue(gender);

            //Click on Continue Button
            HuluBaseClass.huluCreateAccount().ClickContinueButton();

            Thread.sleep(4000);

            //Capture Subscription amount and store it in a variable and print amount
            String subAmount = HuluBaseClass.huluCreateAccount().captureSubAmount();
            System.out.println("My Subscription amount is " + subAmount);

            //Delete all cookies
            driver.manage().deleteAllCookies();

        }//End of Loop
    }//End of Test 1

    @Test(dependsOnMethods = "Hulu_Subscription")
    public void Hulu_Verify_Login() throws InterruptedException {
        driver.navigate().to("https://www.hulu.com");

        //Click on Login Button on Upper Right Corner
        HuluBaseClass.huluVerifyLogIn().LoginButton();

        //Enter Email
        HuluBaseClass.huluVerifyLogIn().InputEmail("QA01_2022@yahoo.com");

        //Enter Password
        HuluBaseClass.huluVerifyLogIn().InputPassword("QA1isLife");

        //Click on Login Button
        HuluBaseClass.huluVerifyLogIn().ClickLoginButton();

        Thread.sleep(2000);

        //Verify the username displayed in Homepage and print it out
        String verifyName = HuluBaseClass.huluVerifyLogIn().VerifyLoginName();
        System.out.println("Verify Username is " + verifyName);

    }//End of Test 2

}//End of Java Class
