package Hulu_Page_Object;

import Reusable_Library.Reusable_Actions_Loggers_POM;
import Reusable_Library.Reusable_Annotations;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HuluCreateAccount extends Reusable_Annotations {

    ExtentTest logger;
    public HuluCreateAccount(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.logger = Reusable_Annotations.logger;
    }//End of the Constructor Method

    @FindBy(xpath = "//*[@id='email']")
    WebElement email;
    @FindBy(xpath = "//*[@id='password']")
    WebElement password;
    @FindBy(xpath = "//*[@id ='firstName']")
    WebElement name;
    @FindBy(xpath = "//*[@class = 'field field__month']")
    WebElement month;
    @FindBy(xpath = "//*[@id='birthdayMonth-menu']")
    WebElement monthValue;
    @FindBy(xpath = "//*[@class= 'field field__day']")
    WebElement date;
    @FindBy(xpath = "//*[@id='birthdayDay-menu']")
    WebElement dateValue;
    @FindBy(xpath = "//*[@class= 'field field__year']")
    WebElement year;
    @FindBy(xpath = "//*[@id='birthdayYear-menu']")
    WebElement yearValue;
    @FindBy(xpath = "//*[@class= 'field gender']")
    WebElement gender;
    @FindBy(xpath = "//*[@id = 'gender-menu']")
    WebElement genderValue;
    @FindBy(xpath = "//*[@class='button button--continue ']")
    WebElement Continue;
    @FindBy(xpath = "//*[@class= 'ledger__summary']")
    WebElement subAmount;


    public void InputEmail(String UserData) {
        Reusable_Actions_Loggers_POM.sendKeysMethod(driver, email, UserData, logger, "Email");
    }//End of Method

    public void InputPassword(String UserData) {
        Reusable_Actions_Loggers_POM.sendKeysMethod(driver, password, UserData, logger, "Password");
    }//End of Method

    public void InputName(String UserData) {
        Reusable_Actions_Loggers_POM.sendKeysMethod(driver, name, UserData, logger, "Name");
    }//End of Method

    public void ClickMonth() {
        Reusable_Actions_Loggers_POM.clickMethod(driver, month, logger, "Month");
    }//End of Method

    public void ClickMonthValue(String UserData) {
        Reusable_Actions_Loggers_POM.clickMethodHulu(driver, monthValue, UserData, logger, "Month Value");
    }//End of Method

    public void ClickDate() {
        Reusable_Actions_Loggers_POM.clickMethod(driver, date, logger, "Date");
    }//End of Method

    public void ClickDateValue(String UserData) {
        Reusable_Actions_Loggers_POM.clickMethodHulu(driver, dateValue, UserData, logger, "Date Value");
    }//End of Method

    public void ClickYear(){
        Reusable_Actions_Loggers_POM.clickMethod(driver, year,logger,"Year");
    }//End of Method

    public void ClickYearValue(String UserData){
        Reusable_Actions_Loggers_POM.clickMethodHulu(driver,yearValue,UserData, logger, "Year Value");
    }//End of Method

    public void ClickGender(){
        Reusable_Actions_Loggers_POM.clickMethod(driver,gender,logger,"Gender");
    }//End of Method

    public void ClickGenderValue(String UserData){
        Reusable_Actions_Loggers_POM.clickMethodHulu(driver,genderValue, UserData,logger, "Gender Value");
    }//End of Method

    public void ClickContinueButton(){
        Reusable_Actions_Loggers_POM.clickMethod(driver,Continue,logger,"Continue Button");
    }//End of Method

    public String captureSubAmount(){
        String result = Reusable_Actions_Loggers_POM.getTextMethod(driver,subAmount, logger,"Capture SubAmount");
        return result;
    }//End of Method

}//End of Java Class
