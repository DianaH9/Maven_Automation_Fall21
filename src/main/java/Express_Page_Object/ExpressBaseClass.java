package Express_Page_Object;

import Reusable_Library.Reusable_Annotations;

public class ExpressBaseClass extends Reusable_Annotations {
    //Create Static Reference for Express Home Page
    public static ExpressHomepage expressHomepage(){
        ExpressHomepage expressHomepage = new ExpressHomepage(driver);
        return expressHomepage;
    }//End of Express Home Page Reference

    //Create Static Reference for Express Dresses Page
    public static ExpressDressesPage expressDressesPage(){
        ExpressDressesPage expressDressesPage = new ExpressDressesPage(driver);
        return expressDressesPage;
    }//End of Express Dresses Page Reference

    //Create Static Reference for Express Dress Item Page
    public static ExpressDressItem expressDressItem(){
        ExpressDressItem expressDressItem = new ExpressDressItem(driver);
        return expressDressItem;
    }//End of Express Dress Item Page

    //Create Static Reference for Express Shopping Bag Page
    public static ExpressShoppingBag expressShoppingBag(){
        ExpressShoppingBag expressShoppingBag = new ExpressShoppingBag(driver);
        return expressShoppingBag;
    }//End of Express Shopping Bag Page

    //Create Static Reference for Express Checkout Page
    public static ExpressCheckout expressCheckout(){
        ExpressCheckout expressCheckout = new ExpressCheckout(driver);
        return expressCheckout;
    }//End of Express Checkout Page

}//End of Java Class

