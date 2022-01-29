package Day4_121221;

public class Split_Command {
    public static void main(String[] args) {

        //Create a single String
        String message = "My name is John";
        //Declare String array to split the message to print out only John
        String[] arrayMessage = message.split(" ");

        //Print out John
        System.out.println("Result is " + arrayMessage[3]);

    }//End of Main

}//End of Java Class
