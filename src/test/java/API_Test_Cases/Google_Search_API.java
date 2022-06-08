package API_Test_Cases;

import Reusable_Library.Reusable_Actions;
import Reusable_Library.Reusable_Annotations;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class Google_Search_API extends Reusable_Annotations {

    //Set the BaseURL/Endpoint in beforeClass to call it once
    @BeforeSuite
    public void baseUrl(){
        RestAssured.baseURI="https://www.googleapis.com/customsearch/";
        RestAssured.basePath="/v1";
    }//End of Set Up

    @Test
    public void googleSearch() throws InterruptedException {
        //Store the API Key in a variable
        String apiKey = "AIzaSyBXX4fvw1m7Syp0Sup1JfDM_ynkFbubfzU";
        Response myResponse =
                given()
                        .queryParam("key", apiKey)
                        .queryParam("cx","b9fa1276743e4e12c")
                        .queryParam("q", "Mercedes")
                .when()
                        //Get,Post,Put or Delete method as part of when
                        .get()
                .then()
                        .extract().response();

        //Verify if the status code is 200
        if(myResponse.statusCode()==200) {
            System.out.println("Status code is 200 and successful");
            //This will return all the links within the item object in Json
            List<String> linkCount = myResponse.path("items.link");
            //Get all the title within item object
            List<String> titleCount = myResponse.path("items.title");
            System.out.println("Titles: " + titleCount);
            System.out.println("Links: " + linkCount.toString());
            //Want to verify first link and the title of that link appears when I navigate
            driver.navigate().to(linkCount.get(0));
            Thread.sleep(2000);
            String actualTitle = Reusable_Actions.getTextMethod(driver, "//*[text()='Mercedes-Benz']", "Title");
            if(actualTitle.equals(titleCount.get(0))) {
                System.out.println("Title matches " + actualTitle);
            }else{
                System.out.println("Title doesn't match. Expected " + linkCount.get(0) + "and Actual " + actualTitle);
            }

        }else{
            System.out.println("Failed status code " + myResponse.statusCode());
        }

    }//End of Test


}//End of Java Class
