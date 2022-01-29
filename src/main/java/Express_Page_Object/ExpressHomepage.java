package Express_Page_Object;

import Reusable_Library.Reusable_Actions_Loggers_POM;
import Reusable_Library.Reusable_Annotations;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.xml.xpath.XPath;

public class ExpressHomepage extends Reusable_Annotations {

    ExtentTest logger;
    public ExpressHomepage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.logger = Reusable_Annotations.logger;
    }//End of the Constructor Method

    @FindBy(xpath= "//*[text()='Women']" )
    WebElement mouseHover;
    @FindBy(xpath = "//*[text()='Dresses']")
    WebElement Dresses;

    public void mouseHoverWomen(){
        Reusable_Actions_Loggers_POM.mouseHover(driver, mouseHover,logger,"Mouse Hover");
    }//End of Method
    public void clickDressTab(){
        Reusable_Actions_Loggers_POM.clickMethod(driver, Dresses,logger,"Dress");
    }//End of Method

}//End of Java Class
