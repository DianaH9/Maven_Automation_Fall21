package LendingTree_Page_Object;

import Express_Page_Object.ExpressHomepage;
import Reusable_Library.Reusable_Annotations;

public class LendingTreeBaseClass extends Reusable_Annotations {
    //Create Static Reference for LendingTree Home Page
    public static LendingTreeHomePage lendingTreeHomepage(){
        LendingTreeHomePage lendingTreeHomePage = new LendingTreeHomePage(driver);
        return lendingTreeHomePage;
    }//End of Lending Tree Home Page Reference

    //Create Static Reference for LendingTree Mortgage Page
    public static LendingTreeMortgage lendingTreeMortgage(){
        LendingTreeMortgage lendingTreeMortgage = new LendingTreeMortgage(driver);
        return lendingTreeMortgage;
    }//End of Lending Tree Mortgage Page Reference

}//End of Java Class
