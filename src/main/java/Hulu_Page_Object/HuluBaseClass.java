package Hulu_Page_Object;

import Reusable_Library.Reusable_Annotations;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class HuluBaseClass extends Reusable_Annotations {
    public HuluBaseClass(WebDriver driver){
        PageFactory.initElements(driver,this);
    }//End of Constructor Class

    //Create Static Reference for Hulu Home Page
    public static HuluHomepage huluhomepage(){
        HuluHomepage huluhomepage = new HuluHomepage(driver);
        return huluhomepage;
    }//End of Hulu Home Page Reference

    //Create Static Reference for Hulu Create Account
    public static HuluCreateAccount huluCreateAccount(){
        HuluCreateAccount huluCreateAccount = new HuluCreateAccount(driver);
        return huluCreateAccount;
    }//End of Hulu Create Account Reference

    //Create Static Reference for Hulu Verify Login
    public static HuluVerifyLogIn huluVerifyLogIn(){
        HuluVerifyLogIn huluVerifyLogIn = new HuluVerifyLogIn(driver);
        return huluVerifyLogIn;
    }//End of Hulu Verify Login Reference



}//End of Java Class
