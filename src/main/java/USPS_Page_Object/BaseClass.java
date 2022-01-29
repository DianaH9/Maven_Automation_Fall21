package USPS_Page_Object;

import Reusable_Library.Reusable_Annotations;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BaseClass extends Reusable_Annotations {
    public BaseClass(WebDriver driver){
        PageFactory.initElements(driver,this);
    }//End of Constructor Class

    //Create Static Reference for USPS Home Page
    public static Homepage homepage(){
        Homepage homepage = new Homepage(driver);
        return  homepage;
    }//End of USPS Home Page Reference

    //Create Static Reference for Send Mail and Packages Page
    public static SendMailAndPackages sendMailAndPackages(){
        SendMailAndPackages sendMailAndPackages = new SendMailAndPackages(driver);
        return  sendMailAndPackages;
    }//End of Send Mail and Packages Page

}//End of Java Class
