package Express_Page_Object;

import Reusable_Library.Reusable_Actions_Loggers_POM;
import Reusable_Library.Reusable_Annotations;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ExpressCheckout extends Reusable_Annotations {
    ExtentTest logger;
    public ExpressCheckout(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.logger = Reusable_Annotations.logger;
    }//End of the Constructor Method

    @FindBy(xpath ="//*[@name = 'firstname']")
    WebElement firstName;
    @FindBy(xpath = "//*[@name = 'lastname']")
    WebElement lastName;
    @FindBy(xpath = "//*[@name = 'email']")
    WebElement email;
    @FindBy(xpath = "//*[@name = 'confirmEmail']")
    WebElement confirmEmail;
    @FindBy(xpath = "//*[@name = 'phone']")
    WebElement phoneNumber;
    @FindBy(xpath = "//*[text() = 'Continue']")
    WebElement Continue;
    @FindBy(xpath = "//*[@name = 'shipping.line1']")
    WebElement address;
    @FindBy(xpath = "//*[@name = 'shipping.postalCode']")
    WebElement zipcode;
    @FindBy(xpath = "//*[@name = 'shipping.city']")
    WebElement city;
    @FindBy(xpath = "//*[@name = 'shipping.state']")
    WebElement state;
    @FindBy(xpath = "//*[@id = 'creditCardNumberInput']")
    WebElement cardNumber;
    @FindBy(xpath = "//*[@name = 'expMonth']")
    WebElement expMonth;
    @FindBy(xpath = "//*[@name = 'expYear']")
    WebElement expYear;
    @FindBy(xpath = "//*[@name = 'cvv']")
    WebElement cvv;
    @FindBy(xpath = "//*[text() = 'Place Order']")
    WebElement placeOrder;
    @FindBy(xpath = "//*[@id = 'rvn-note-NaN']")
    WebElement errorMsg;

    public void InputFirstName(String UserData){
        Reusable_Actions_Loggers_POM.sendKeysMethod(driver, firstName,UserData,logger, "First Name");
    }//End of Method
    public void InputLastName(String UserData){
        Reusable_Actions_Loggers_POM.sendKeysMethod(driver,lastName,UserData,logger,"Last Name");
    }//End of Method
    public void InputEmail(String UserData){
        Reusable_Actions_Loggers_POM.sendKeysMethod(driver,email,UserData,logger, "Email");
    }//End of Method
    public void InputConfirmEmail(String UserData){
        Reusable_Actions_Loggers_POM.sendKeysMethod(driver,confirmEmail,UserData,logger,"Confirm Email");
    }//End of Method
    public void InputPhoneNumber(String UserData){
        Reusable_Actions_Loggers_POM.sendKeysMethod(driver,phoneNumber,UserData,logger,"Phone Number");
    }//End of Method
    public void ClickContinueButton(){
        Reusable_Actions_Loggers_POM.clickMethod(driver,Continue,logger,"Continue Button");
    }//End of Method
    public void InputAddress(String UserData){
        Reusable_Actions_Loggers_POM.sendKeysMethod(driver, address,UserData,logger, "Address");
    }//End of Method
    public void InputZipcode(String UserData){
        Reusable_Actions_Loggers_POM.sendKeysMethod(driver,zipcode,UserData,logger,"Zipcode");
    }//End of Method
    public void InputCity(String UserData){
        Reusable_Actions_Loggers_POM.sendKeysMethod(driver,city,UserData,logger,"City");
    }//End of Method
    public void InputState(String UserSelect){
        Reusable_Actions_Loggers_POM.dropDownSelect(driver,state,UserSelect,logger,"State");
    }//End of Method
    public void InputCardNumber(String UserData){
        Reusable_Actions_Loggers_POM.sendKeysMethod(driver,cardNumber,UserData,logger,"Card Number");
    }//End of Method
    public void InputExpMonth(String UserSelect){
        Reusable_Actions_Loggers_POM.dropDownSelect(driver,expMonth,UserSelect,logger,"Expiration Month");
    }//End of Method
    public void InputExpYear(String UserSelect){
        Reusable_Actions_Loggers_POM.dropDownSelect(driver,expYear,UserSelect,logger,"Expiration Year");
    }//End of Method
    public void InputCvv(String UserData){
        Reusable_Actions_Loggers_POM.sendKeysMethod(driver,cvv,UserData,logger,"CVV");
    }//End of Method
    public void ClickPlaceOrder(){
        Reusable_Actions_Loggers_POM.clickMethod(driver,placeOrder,logger,"Place Order Button");
    }//End of Method
    public String ErrorMessage(){
        String errorMessage = Reusable_Actions_Loggers_POM.getTextMethod(driver,errorMsg,logger,"Error Message");
        return errorMessage;
    }//End of Method

}//End of Java Class
