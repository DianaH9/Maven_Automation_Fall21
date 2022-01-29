package Express_Page_Object;

import Reusable_Library.Reusable_Actions_Loggers_POM;
import Reusable_Library.Reusable_Annotations;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Locale;

import static Reusable_Library.Reusable_Actions_Loggers_POM.getScreenShot;

public class ExpressDressItem extends Reusable_Annotations {
    ExtentTest logger;
    public ExpressDressItem(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.logger = Reusable_Annotations.logger;
    }//End of the Constructor Method

    @FindBy(xpath = "//*[text()= 'Add to Bag']")
    WebElement AddToBag;
    @FindBy(xpath = "//*[text()= 'View Bag']")
    WebElement ViewBag;

    public void ClickSize(String UserData){
       String size = UserData.toLowerCase(Locale.ROOT);
        WebDriverWait wait = new WebDriverWait(driver,10);
        System.out.println("Clicking on size " + UserData);
        logger.log(LogStatus.INFO,"Clicking on size " + UserData);
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(@aria-label, 'Select "+size+" Size')]"))).click();
        } catch (Exception e) {
            System.out.println("Unable to click on size " + UserData + e);
            logger.log(LogStatus.FAIL,"Unable to click on " + UserData + " Error:" + e);
            Reusable_Actions_Loggers_POM.getScreenShot(driver,UserData,logger);
        }//End of Click Exception
    }//End of Method
    public void ClickAddtoBag(){
        Reusable_Actions_Loggers_POM.clickMethod(driver,AddToBag,logger,"Add to Bag");
    }//End of Method
    public void ClickViewBag(){
        Reusable_Actions_Loggers_POM.clickMethod(driver,ViewBag,logger,"View Bag");
    }//End of Method

}//End of Java Class
