package Spring_04242022;

import java.util.ArrayList;

public class forLoop {
    public static void main(String[] args) {
        //Create an ArrayList for cities and loop/iterating through all the values using for loop
        ArrayList<String> cities = new ArrayList<>();
        cities.add("Brooklyn");
        cities.add("Queens");
        cities.add("Bronx");
        cities.add("Long Island");
        cities.add("Staten Island");

        for (int i = 0; i < cities.size(); i++){
            System.out.println("i is now " + i);
            System.out.println("My city is " + cities.get(i));
        }//End of For Loop
    }//End of Main Method
}//End of Java Class
