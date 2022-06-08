package PageObjects;

import Reusable_Library.Reusable_Annotations;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BaseClass extends Reusable_Annotations {
    public BaseClass(WebDriver driver){
        PageFactory.initElements(driver,this);
    }//End of Constructor Class

    //Create Static Reference for Google Home Page
    public static GoogleHomePage googleHomePage(){
        GoogleHomePage googleHomePage = new GoogleHomePage(driver);
        return googleHomePage;
    }//End of googleHomePage Method

    //Create Static Reference for Google Search Result Page
    public static GoogleSearchResultPage googleSearchResultPage(){
        GoogleSearchResultPage googleSearchResultPage = new GoogleSearchResultPage(driver);
        return googleSearchResultPage;
    }//End of googleHomePage Method

}//End of Java Class
