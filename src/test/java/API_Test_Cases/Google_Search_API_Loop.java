package API_Test_Cases;

import Reusable_Library.Reusable_Annotations;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class Google_Search_API_Loop extends Reusable_Annotations {

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
        ArrayList cities = new ArrayList();
        cities.add("Brooklyn");
        cities.add("Queens");
        cities.add("Bronx");

        for(int i=0; i<cities.size(); i ++) {
            Response myResponse =
                    given()
                            .queryParam("key", apiKey)
                            .queryParam("cx", "b9fa1276743e4e12c")
                            .queryParam("q", cities.get(i))
                            .when()
                            //Get,Post,Put or Delete method as part of when
                            .get()
                            .then()
                            .extract()
                            .response();

            //Verify if the status code is 200
            if (myResponse.statusCode() == 200) {
                System.out.println("Status code is 200 and successful");
                //This will return all the links within the item object in Json
                List<String> linkCount = myResponse.path("items.link");
                //Get all the title within item object
                List<String> titleCount = myResponse.path("items.title");
                //Verify the first 3 link you get from the link list and it's title
                for(int j = 0; j<3; j++) {
                    driver.navigate().to(linkCount.get(j));
                    Thread.sleep(2000);
                    String actualTitle = driver.getTitle();
                    if (actualTitle.equals(titleCount.get(j))) {
                        System.out.println("Title matches " + actualTitle);
                    } else {
                        System.out.println("Title doesn't match. Expected " + linkCount.get(0) + "and Actual " + actualTitle);
                    }
                }//End of SubLoop

            } else {
                System.out.println("Failed status code " + myResponse.statusCode());
            }

        }//End of Loop

    }//End of Test


}//End of Java Class
