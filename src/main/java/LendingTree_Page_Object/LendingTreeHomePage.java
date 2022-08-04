package LendingTree_Page_Object;

import Reusable_Library.Reusable_Actions_Loggers_POM;
import Reusable_Library.Reusable_Annotations;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LendingTreeHomePage extends Reusable_Annotations {
    ExtentTest logger;
    public LendingTreeHomePage(WebDriver driver){
        PageFactory.initElements(driver,this);
        this.logger = Reusable_Annotations.logger;
    }//End of Constructor Method

    @FindBy(xpath = "//*[@aria-label='Mortgages, see more']")
    WebElement mortgageTab;
    @FindBy(xpath = "//*[@class='nav-dropdown-icon lt4-Mortgage']")
    WebElement mortgageRatesTab;

    public void clickMortgageTab(){
        Reusable_Actions_Loggers_POM.clickMethod(driver,mortgageTab,logger, "Mortgage Tab");
    }//End of Mortgage Tab

    public void clickMortgageRatesTab(){
        Reusable_Actions_Loggers_POM.clickMethod(driver,mortgageRatesTab,logger,"Mortgage Rates Tab");
    }//End of Mortgage Tab






}//End of Java Class
