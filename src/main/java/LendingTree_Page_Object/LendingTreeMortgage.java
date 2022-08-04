package LendingTree_Page_Object;

import Reusable_Library.Reusable_Actions_Loggers_POM;
import Reusable_Library.Reusable_Annotations;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LendingTreeMortgage extends Reusable_Annotations{
    ExtentTest logger;
    public LendingTreeMortgage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.logger = Reusable_Annotations.logger;
    }//End of Constructor Method

    @FindBy(xpath = "//*[text()='15-year fixed-rate vs. 30-year fixed-rate mortgage ']")
    WebElement yearRateInfo15to30;
    @FindBy(xpath = "//*[text()='5/1 ARM vs. 30-year fixed-rate mortgage ']")
    WebElement yearRateInfoFifthARMto30;
    @FindBy(xpath = "//*[text()='10/1 ARM vs. 5/1 ARM ']")
    WebElement yearRateInfoTenthToFifthARM;
    @FindBy(xpath = "//*[@id='stInput']")
    WebElement zipcodeInput;
    @FindBy(xpath = "//*[@class='btn btn-orange']")
    WebElement updateRatesButton;
    @FindBy(xpath = "//*[@id='program-tab-1']")
    WebElement fifteenYearRateHeader;
    @FindBy(xpath = "//*[@id='program-tab-0']")
    WebElement thirtyYearRateHeader;

    public void clickOn15To30YearRateInfo(){
        Reusable_Actions_Loggers_POM.clickMethod(driver,yearRateInfo15to30,logger,"15 vs 30 Year Rate Info");
    }//End of Method

    public void clickOnFifthARMTo30YearRateInfo(){
        Reusable_Actions_Loggers_POM.clickMethod(driver,yearRateInfoFifthARMto30,logger,"5/1 ARM vs 30 Year Rate Info");
    }//End of Method

    public void clickOnTenthToFifthARMYearRateInfo(){
        Reusable_Actions_Loggers_POM.clickMethod(driver,yearRateInfoTenthToFifthARM,logger,"10/1 ARM vs 5/1 ARM Rate Info");
    }//End of Method

    public void clickOnInputZipcode(){
        Reusable_Actions_Loggers_POM.clickMethod(driver,zipcodeInput,logger,"Click ZipCode Input");
    }//End of Method

    public void inputZipcode(String userValue){
        Reusable_Actions_Loggers_POM.sendKeysMethod(driver,zipcodeInput, userValue, logger, "Input Zipcode");
    }//End of Method

    public void clickUpdateRatesButton(){
        Reusable_Actions_Loggers_POM.clickMethod(driver,updateRatesButton,logger,"Update Rates Button");
    }//End of Method

    public void clickFifteenYearRateHeader(){
        Reusable_Actions_Loggers_POM.clickMethod(driver,fifteenYearRateHeader,logger,"Fifteen Year Rate Header");
    }//End of Method

    public void clickThirtyYearRateHeader(){
        Reusable_Actions_Loggers_POM.clickMethod(driver,thirtyYearRateHeader,logger,"Thirty Year Rate Header");
    }//End of Method

}//End of Java Class
