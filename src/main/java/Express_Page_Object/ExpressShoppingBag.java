package Express_Page_Object;

import Reusable_Library.Reusable_Actions_Loggers_POM;
import Reusable_Library.Reusable_Annotations;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ExpressShoppingBag extends Reusable_Annotations{
    ExtentTest logger;
    public ExpressShoppingBag(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.logger = Reusable_Annotations.logger;
    }//End of the Constructor Method

    @FindBy(xpath = "//*[@id= 'qdd-0-quantity']")
    WebElement Quantity;
    @FindBy(xpath = "//*[text()= 'Checkout']")
    WebElement Checkout;
    @FindBy(xpath = "//*[text()= 'Checkout as Guest']")
    WebElement CheckoutAsGuest;

    public void SelectQuantity(String UserData){
        Reusable_Actions_Loggers_POM.dropDownSelect(driver,Quantity,UserData,logger,"Quantity");
    }//End of Method
    public void ClickCheckoutButton(){
        Reusable_Actions_Loggers_POM.clickMethod(driver,Checkout,logger,"Checkout Button");
    }//End of Method
    public void ClickCheckoutAsGuest(){
        Reusable_Actions_Loggers_POM.clickMethod(driver,CheckoutAsGuest,logger,"Checkout As Guest Button");
    }//End of Method

}//End of Java Class
