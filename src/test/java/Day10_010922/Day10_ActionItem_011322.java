package Day10_010922;

import Reusable_Library.Reusable_Actions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import java.util.ArrayList;

public class Day10_ActionItem_011322 {

    //Declare the webdriver outside the annotation methods, so it can be called on all the methods
    WebDriver driver;

    @BeforeSuite
    public void SetTheDriver() {
        driver = Reusable_Actions.setDriver();

    }//End of Pre-Conditions

    @Test
    public void arrayList() throws InterruptedException {
        //Declare ArrayList for email
        ArrayList<String> email = new ArrayList<>();
        email.add("QA_2021@yahoo.com");
        email.add("QA_2022@yahoo.com");

        //Declare ArrayList for password
        ArrayList<String> password = new ArrayList<>();
        password.add("QA1isLife");
        password.add("QA2isLife");

        //Declare ArrayList for name
        ArrayList<String> name = new ArrayList<>();
        name.add("Diana");
        name.add("Adana");

        //Declare ArrayList for birth month
        ArrayList<String> birthMonth = new ArrayList<>();
        birthMonth.add("March");
        birthMonth.add("December");

        //Declare ArrayList for date of birth
        ArrayList<String> birthDate = new ArrayList<>();
        birthDate.add("2");
        birthDate.add("3");

        //Declare ArrayList for birth year
        ArrayList<String> birthYear = new ArrayList<>();
        birthYear.add("1993");
        birthYear.add("1994");

        //Declare ArrayList for gender
        ArrayList<String> gender = new ArrayList<>();
        gender.add("Female");
        gender.add("Male");

        for (int i = 0; i < email.size(); i++) {
            //Navigate Hulu page
            driver.navigate().to("https://www.hulu.com");
            //Verify the Welcome Page Title Appears as expected
            String actualTitle = driver.getTitle();
            //By using if else to compare expected with actual title
            if (actualTitle.equals("Stream TV and Movies")) {
                System.out.println("Title matches " + actualTitle);
            } else {
                System.out.println("Title doesn't match. Actual title is " + actualTitle);
            }//End of Welcome Page Title Exception

            //Scrolling by pixels to the bottom of the page
            Reusable_Actions.scrollingByPixelMethod(driver, "0", "3250");

            //Click on Select Button
            Reusable_Actions.clickMethod(driver, "//*[@class = 'button--cta button--black plan-card__cta plan-card__0_cta button--black ']", "Select");

            //Enter Email into Input Field
            Reusable_Actions.sendKeysMethod(driver, "//*[@id='email']", email.get(i), "Enter Email");

            //Enter Password into Input Field
            Reusable_Actions.sendKeysMethod(driver, "//*[@id='password']", password.get(i), "Enter Password");

            //Enter Name into Input Field
            Reusable_Actions.sendKeysMethod(driver, "//*[@id='firstName']", name.get(i), "Enter Name");

            //Click on element for month and click on month value
            Reusable_Actions.clickMethod(driver, "//*[@class = 'field field__month']", "Month");
            Reusable_Actions.clickMethod(driver, "//*[text()= '" + birthMonth.get(i) + "']", "Month Value");

            //Click on element for date and click on date value
            Reusable_Actions.clickMethod(driver, "//*[@class= 'field field__day']", "Date");
            Reusable_Actions.clickMethod(driver, "//*[text()= '" + birthDate.get(i) + "']", "Date Value");

            //Click on element for year and click on year value
            Reusable_Actions.clickMethod(driver, "//*[@class= 'field field__year']", "Year");
            Reusable_Actions.clickMethod(driver, "//*[text()= '" + birthYear.get(i) + "']", "Year Value");

            //Click on element for gender and click on gender value
            Reusable_Actions.clickMethod(driver, "//*[@class= 'field gender']", "Gender");
            Reusable_Actions.clickMethod(driver, "//*[text()= '" + gender.get(i) + "']", "Gender Value");

            //Click on Continue Button
            Reusable_Actions.clickMethod(driver, "//*[@class='button button--continue ']", "Click Button");

            Thread.sleep(4000);

            //Capture Subscription amount and store it in a variable and print amount
            String subAmount = Reusable_Actions.getTextMethod(driver, "//*[@class= 'ledger__summary']", "Capture Subscription Amount");
            System.out.println("My Subscription amount is " + subAmount);

            //Delete all cookies
            driver.manage().deleteAllCookies();

        }//End of Loop
    }//End of Test 1

    @Test (dependsOnMethods = "arrayList")
        public void HuluNavigate(){
        //Navigate to Hulu Home Page
        driver.navigate().to("https://www.hulu.com");

        //Click on Login Button on upper right corner
        Reusable_Actions.clickMethod(driver, "//*[@class = 'navigation__login-button navigation__action-button navigation__cta']", "Login Button");

        //Enter email
        Reusable_Actions.sendKeysMethod(driver, "//*[@id='email_id']", "QA2021@yahoo.com", "Enter Email");

        //Enter password
        Reusable_Actions.sendKeysMethod(driver, "//*[@id='password_id']", "QA1isLife", "Enter Password");

        //Click on Login button
        Reusable_Actions.clickMethod(driver, "//*[text() = 'LOG IN']", "Log In");

        //Verify the username displayed on homepage and print it out
        String result = Reusable_Actions.getTextMethod(driver, "//*[text()='Diana']", "Verify Username");
        System.out.println("Verify username is " + result);

    }//End of Test 2

    @AfterSuite
    public void afterTest() {
        System.out.println("This executes after each test");
    }//End of After Method

}//End of Java Class
