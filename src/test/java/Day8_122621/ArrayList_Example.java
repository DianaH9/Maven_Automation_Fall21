package Day8_122621;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ArrayList_Example {

    public static void main(String[] args) {

        /*Array List is a resizable array which means you don't need to add the length to
        add more array values
        */
        ArrayList<String> cities = new ArrayList<>();
        cities.add("Brooklyn");
        cities.add("Queens");
        cities.add("Manhattan");

        //Shortcut for println is sout lowercase
        System.out.println("My city is " + cities.get(2));

        ArrayList<Integer> streetNumber = new ArrayList<>();
        streetNumber.add(111);
        streetNumber.add(112);
        streetNumber.add(113);

        System.out.println("My third city is " + cities.get(2) + " and my third house number is " + streetNumber.get(2));

    } //End of Main Method

} //End of Java Class
