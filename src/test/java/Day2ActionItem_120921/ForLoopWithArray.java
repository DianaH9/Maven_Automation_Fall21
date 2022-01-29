package Day2ActionItem_120921;

public class ForLoopWithArray {
    public static void main(String[] args) {

        //create a String dynamic array for zipcodes
        String[] zipcodes = new String[4]; //you set the limit/boundaries for array
        // now define my values by the variables indexing
        zipcodes[0] = "11111";
        zipcodes[1] = "22222";
        zipcodes[2] = "33333";
        zipcodes[3] = "44444";

        //integer dynamic array
        int[] streetNumber = new int[4];
        streetNumber[0] = 111;
        streetNumber[1] = 222;
        streetNumber[2] = 333;
        streetNumber[3] = 444;
        for (int i = 0; i < zipcodes.length; i++) {
            System.out.println("My zipcode is " + zipcodes[i] + " and my street number is " + streetNumber[i] + ".");
        }//End of For Loop

    }//End of Main

}//End of Java Class
