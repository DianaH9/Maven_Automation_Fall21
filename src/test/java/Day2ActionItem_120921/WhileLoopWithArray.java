package Day2ActionItem_120921;

public class WhileLoopWithArray {
    public static void main(String[] args) {
        //iterate through all zipcodes defined by dynamic array using for loop
        String[] zipcodes = new String[4];
        zipcodes[0] = "11111";
        zipcodes[1] = "22222";
        zipcodes[2] = "33333";
        zipcodes[3] = "44444";

        //iterate through all street numbers defined by dynamic array using for loop
        int[] streetnumber = new int[4];
        streetnumber[0] = 111;
        streetnumber[1] = 222;
        streetnumber[2] = 333;
        streetnumber[3] = 444;

        //declare and define the initial starting point
        int i = 0;
        //define while loop with you end point(condition)
        while (i < zipcodes.length) {
            System.out.println("My zipcode is " + zipcodes[i] + " and my street number is " + streetnumber[i] + ".");
            i = i + 1;//If there is no incrementation, the while loop becomes an infinite loop

        }//End of While Loop

    }//End of Main

}//End of Java Class
