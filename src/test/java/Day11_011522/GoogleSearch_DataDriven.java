package Day11_011522;

import Day9_010822.Reusable_Actions;
import Reusable_Library.Reusable_Actions_Loggers;
import Reusable_Library.Reusable_Annotations;
import com.relevantcodes.extentreports.LogStatus;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class GoogleSearch_DataDriven extends Reusable_Annotations {

    @Test
    public void Google_Search_DataDriven() throws BiffException, IOException, WriteException {
        //Step 1: Read the data from the Excel sheet you created
        Workbook readableFile = Workbook.getWorkbook(new File("src/main/resources/GoogleSearch.xls"));
        //Step 2: Locating the worksheet that you created for the workbook
        //Sheet readablesheet = readableFile.getSheet(0);
        //Will return the physical rows present on the sheet
        //int rowCount = readablesheet.getRows();
        //System.out.println("My readable row count is " + rowCount);

        //Step 3: Create a writable file to mimic readable, you can also write back the results to this file
        WritableWorkbook writableFile = Workbook.createWorkbook(new File("src/main/resources/GoogleSearch_Results.xls"),readableFile);
        WritableSheet writableSheet = writableFile.getSheet(0);
        //Will return the physical rows present on the sheet
        int rowCount2 = writableSheet.getRows();
        System.out.println("My writable row count is " + rowCount2);

        //Generate the for/while loop
        int i = 1;
        while( i < rowCount2){
            //Store the countries list as a variable
            String countries = writableSheet.getCell(0,i).getContents();
            System.out.println("My values are " + countries);

            //Navigate to Google
            logger.log(LogStatus.INFO, "Navigating to Google Home Page");
            driver.navigate().to("https://www.google.com");
            //Enter Countries on my Google Search Field
            Reusable_Actions_Loggers.sendKeysMethod(driver, "//*[@name= 'q']", countries, logger, "Search Field");
            //Submit to Google Search Button
            Reusable_Actions_Loggers.submitMethod(driver,"//*[@name = 'btnK']", logger, "Google Search Button");

            //Capture the result
            String results = Reusable_Actions_Loggers.getTextMethod(driver,"//*[@id = 'result-stats']",logger,"Search Result");
            String[] arrayResults = results.split(" ");

            //Step 5: Storing the values to the writeable Excel sheet
            Label label = new Label(1,i,arrayResults[1]);
            //I need to write back to the writable sheet
            writableSheet.addCell(label);

            //Increment
            i = i+1;
        }//End of loop

        //Step 6: Writing back to the writable file to see
        writableFile.write();
        writableFile.close();

    }//End of Test
}//End of Java Class
