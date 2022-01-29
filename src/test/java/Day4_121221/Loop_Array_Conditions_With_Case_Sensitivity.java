package Day4_121221;

public class Loop_Array_Conditions_With_Case_Sensitivity {
    public static void main(String[] args) {
        //Create a dynamic array for 4 different cities, iterate through the values but only print when city is
        //either brooklyn or queens
        String[] cities = new String[4];
        cities[0] = "Queens";
        cities[1] = "Manhattan";
        cities[2] = "Bronx";
        cities[3] = "Brooklyn";

        int i = 0;
        while (i < cities.length) {
            //two if conditions
            //when you are not sure if the value is in upper case, lower case or mixed case
            if (cities[i].toLowerCase().equals("brooklyn")) {
                System.out.println("City is " + cities[i]);
            } else if (cities[i].toUpperCase().equals("QUEENS")) {
                System.out.println("City is " + cities[i]);
            }//End of Conditions
            i++;
        }//End of While Loop

    }//End of Main

}//End of Java Class
