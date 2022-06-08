package PageObjects;

import Reusable_Library.Reusable_Actions_Loggers_POM;
import Reusable_Library.Reusable_Annotations;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class GoogleSearchResultPage extends Reusable_Annotations{
    //Declare the ExtentTest for each Page Object Class
    ExtentTest logger;
    //Create a Constructor Method that will reference the same name as your class, you can make your
    //Page Object Class Methods Static when you call it in your Test Class
    public GoogleSearchResultPage(WebDriver driver){
        //Page Factory function for Page Object
        PageFactory.initElements(driver,this);
        this.logger = Reusable_Annotations.logger;
    }//End of Constructor

    //Define all the WebElements using @FindBy Concept
    @FindBy(xpath = "//*[@id='result-stats']")
    WebElement searchResult;

    public void CaptureSearchNumberAndPrintIt(){
        String result = Reusable_Actions_Loggers_POM.getTextMethod(driver,searchResult,logger,"Search Results");
        String[] arrayResult = result.split(" ");
        System.out.println("My search number is " + arrayResult[1]);
        logger.log(LogStatus.INFO,"My search number is " + arrayResult[1]);
    }//End of Capture Search Number



}
