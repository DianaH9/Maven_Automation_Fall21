package Hulu_Page_Object;

import Reusable_Library.Reusable_Actions_Loggers_POM;
import Reusable_Library.Reusable_Annotations;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HuluVerifyLogIn extends Reusable_Annotations{
    ExtentTest logger;
    public HuluVerifyLogIn(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.logger = Reusable_Annotations.logger;
    }//End of the Constructor Method

    @FindBy(xpath = "//*[@class = 'navigation__login-button navigation__action-button navigation__cta']")
    WebElement loginButton;
    @FindBy(xpath = "//*[@id='email_id']")
    WebElement email;
    @FindBy(xpath = "//*[@id='password_id']")
    WebElement password;
    @FindBy(xpath = "//*[text() = 'LOG IN']")
    WebElement LoginButton;
    @FindBy(xpath = "//*[text()='Diana']")
    WebElement verifyName;

    public void LoginButton(){
        Reusable_Actions_Loggers_POM.clickMethod(driver,loginButton, logger, "Login Button");
    }//End of Login Button

    public void InputEmail(String UserData){
        Reusable_Actions_Loggers_POM.sendKeysMethod(driver, email, UserData, logger, "Email");
    }//End of Input Email

    public void InputPassword(String UserData){
        Reusable_Actions_Loggers_POM.sendKeysMethod(driver, password,UserData,logger,"Password");
    }//End of Input Password

    public void ClickLoginButton(){
        Reusable_Actions_Loggers_POM.clickMethod(driver,LoginButton,logger, "LogIn Button");
    }//End of Click Login Button

    public String VerifyLoginName(){
        String result = Reusable_Actions_Loggers_POM.getTextMethod(driver,verifyName, logger,"Verify Name");
        return result;
    }//End of Verify Name

}//End of Java Class
