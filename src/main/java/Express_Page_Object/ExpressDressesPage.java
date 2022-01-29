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

import static Reusable_Library.Reusable_Actions_Loggers_POM.getScreenShot;

public class ExpressDressesPage extends Reusable_Annotations {
    ExtentTest logger;
    public ExpressDressesPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.logger = Reusable_Annotations.logger;
    }//End of the Constructor Method

    @FindBy(xpath = "//*[@name='bluecoreCloseButton']")
    WebElement Popup;
    @FindBy(xpath = "//*[contains(@class, '-qIS3zH7eoemBZF9mo1K5')]")
    WebElement SecondImage;

    public void dismissPopUP(){
        Reusable_Actions_Loggers_POM.clickDismissPopUpMethod(driver, Popup,logger,"Dismiss PopUp" );
    }//End of Method
    public void ClickSecondImage(int indexNum){
        WebDriverWait wait = new WebDriverWait(driver, 15);
        System.out.println("Clicking on element " + indexNum);
        logger.log(LogStatus.INFO,"Clicking on element " + indexNum);
        try{
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[contains(@class, '_1vuRDTYH _3jxErwTw')]"))).get(indexNum).click();
        } catch (Exception e) {
            System.out.println("Unable to Click on element " + indexNum + " --" + e);
            logger.log(LogStatus.FAIL,"Unable to Click by Index on " + indexNum + "Error:" + e);
        }//End of Click Element by Index Number Exception
    }//End of Method

}//End of Java Class
