package Day4_121221;

public class Loop_Array_Conditions {
    public static void main(String[] args) {

        //Create a dynamic array for 4 different cities, iterate through the values but only print when city is
        //either brooklyn or queens
        String[] cities = new String[4];
        cities[0] = "Brooklyn";
        cities[1] = "Manhattan";
        cities[2] = "Queens";
        cities[3] = "Bronx";

        int i = 0;
        while (i < cities.length) {
            //two if conditions
            if (cities[i] == "Brooklyn") {
                System.out.println("City is " + cities[i]);
            } else if (cities[i] == "Queens") {
                System.out.println("City is " + cities[i]);
            }//End of Conditions
            i++; //incrementing
        }//End of While Loop

    }//End of Method

}//End of Java Class
