package Spring_06042022;

import PageObjects.BaseClass;
import Reusable_Library.Reusable_Annotations;
import org.testng.annotations.Test;

public class GoogleSearch_POM extends Reusable_Annotations {
    @Test
    public void SearchForAKeywordOnGoogleHome(){
        driver.navigate().to("https://www.google.com");
        BaseClass.googleHomePage().searchUserValue("BMW");
        BaseClass.googleHomePage().submitOnGoogleSearch();
    }//End of Test

    @Test(dependsOnMethods = "SearchForAKeywordOnGoogleHome")
    public void CaptureSearchNumberFromGoogle(){
        BaseClass.googleSearchResultPage().CaptureSearchNumberAndPrintIt();
    }//End of Test

}//End of Java Class
