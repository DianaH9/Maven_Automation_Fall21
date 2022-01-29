package Hulu_Page_Object;

import Reusable_Library.Reusable_Actions_Loggers_POM;
import Reusable_Library.Reusable_Annotations;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HuluHomepage extends Reusable_Annotations {
    ExtentTest logger;
    public HuluHomepage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.logger = Reusable_Annotations.logger;
    }//End of the Constructor Method

    @FindBy(xpath = "//*[@class = 'button--cta button--black plan-card__cta plan-card__0_cta button--black ']")
    WebElement selectButton;

    //Click on Select Button
    public void selectButton() {
        Reusable_Actions_Loggers_POM.clickMethod(driver, selectButton, logger,"Select");
    }//End of Select

}//End of Java Class
