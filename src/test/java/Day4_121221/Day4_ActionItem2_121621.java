package Day4_121221;

public class Day4_ActionItem2_121621 {
    public static void main(String[] args) {

        /*
        Create a dynamic array for 4 different states, iterate through the values but only print when state is
        either New York or California
        */
        String[] states = new String[4];
        states[0] = "New York";
        states[1] = "New Jersey";
        states[2] = "California";
        states[3] = "Ohio";

        //Declare and define the initial starting point
        int i = 0;
        //Define while loop with conditions
        while (i < states.length) {
            //Two if conditions
            if (states[i] == "New York") {
                System.out.println("Result is " + states[i]);
            } else if (states[i] == "California") {
                System.out.println("Result is " + states[i]);
            }//End of Conditions
            i = i + 1; //If there is no incrementation, the while loop becomes an infinite loop
        }//End of While Loop

    }//End of Main Method

}//End of Java Class
