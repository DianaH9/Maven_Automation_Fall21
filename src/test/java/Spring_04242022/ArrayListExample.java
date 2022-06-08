package Spring_04242022;

import java.util.ArrayList;

public class ArrayListExample {
    public static void main(String[] args) {
        //Create an ArrayList for Countries
        ArrayList<String> countries = new ArrayList<>();
        countries.add("USA"); //Index 0
        countries.add("Bangladesh"); //Index 1
        countries.add("India"); //Index 2
        countries.add("Canada"); //Index 3
        countries.add("Pakistan");//Index 4
        //Index 5 will throw index out of bound exception since there is no value stored at index 5

        //I want to print 4th value from the list and the 3rd value from the list
        System.out.println("My last country is " + countries.get(3) + " and my third country is " + countries.get(2));

    }//End of Main Method
}//End of Java Class
