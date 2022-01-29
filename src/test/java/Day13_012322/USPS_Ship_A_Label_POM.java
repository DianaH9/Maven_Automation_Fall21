package Day13_012322;

import Reusable_Library.Reusable_Annotations;
import USPS_Page_Object.BaseClass;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.Test;

public class USPS_Ship_A_Label_POM extends Reusable_Annotations {

    @Test
    public void USPS_Verify_Tabs_Then_Ship_A_Label(){

        //Navigate to USPS
        logger.log(LogStatus.INFO,"Navigating to USPS home page");
        driver.navigate().to("https://www.usps.com");

        //Verify the Tabs Count
        BaseClass.homepage().getNavigationTabsCount();

        //Click on Send Tab
        BaseClass.homepage().clickOnSendTab();

        //Click on Ship a Label
        BaseClass.sendMailAndPackages().clickOnPrintLabelButton();

    }//End of Test
}//End of Java Class
