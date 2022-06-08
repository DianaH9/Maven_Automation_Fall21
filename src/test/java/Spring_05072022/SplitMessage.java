package Spring_05072022;

public class SplitMessage {
    public static void main(String[] args) {
        //Declare String Variable
        String splitMessage = "My_name_is_John";
        //Declare an array of String to store the String Split
        String[] splitMessageArray = splitMessage.split("_");
        //Print out John to the console
        System.out.println("My First Name is " + splitMessageArray[3]);
    }//End of Main Method
}//End of Java Class
