package PageObjects;

import Reusable_Library.Reusable_Actions_Loggers_POM;
import Reusable_Library.Reusable_Annotations;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.xml.xpath.XPath;
import java.util.List;

public class GoogleHomePage extends Reusable_Annotations {
    //Declare the ExtentTest for each Page Object Class
    ExtentTest logger;
    //Create a Constructor Method that will reference the same name as your class, you can make your
    //Page Object Class Methods Static when you call it in your Test Class
    public GoogleHomePage(WebDriver driver){
        //Page Factory function for Page Object
        PageFactory.initElements(driver,this);
        this.logger = Reusable_Annotations.logger;
    }//End of Constructor

    //Define all the WebElements using @FindBy Concept
    @FindBy(xpath = "//*[@name='q']")
    WebElement searchField;
    @FindBy(xpath = "//*[@name='btnK']")
    WebElement googleSearchButton;
    @FindBy(xpath = "//*[@name='links']")
    List<WebElement> listLinks;

    public void searchUserValue(String userValue){
        Reusable_Actions_Loggers_POM.sendKeysMethod(driver,searchField,userValue,logger,"Search Field");
    }//End of Search Field Method

    public void submitOnGoogleSearch(){
        Reusable_Actions_Loggers_POM.submitMethod(driver,googleSearchButton,logger,"Google Search Button");
    }//End of Google Search Button

}//End of Java Class
