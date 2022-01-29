package Day3_121121;

public class Reusable_Methods {

    //Create a void method that will add two numbers
    public static void add(int x, int y) {
        System.out.println("Result of addition is " + (x + y));
    }//End of Add Method

    //Create a void method that will subtract two numbers
    public static void subtract(int x, int y) {
        System.out.println("Result of subtraction is " + (x - y));
    }//End of Subtract Method

    //Create a Return Method that will add two numbers and return the result of it
    public static int addReturn(int x, int y) {
        //Declare and define a new int variable to store x+y
        int result = x + y;
        System.out.println("Result of addition is " + result);

        //Returning the variable result which is storing x+y values
        return result;

    }//End of AddReturn Method

}//End of Java Class
