package Spring_04242022;

public class whileLoop {
    public static void main(String[] args) {
        //Iterate through Zipcode and House Number using Linear Array and While Loop
        String[] zipcode = new String[]{"11218", "11219", "11232", "10001"};
        int[] houseNumber = new int[]{111,222,333,444};

        //Initialize your Starting Point Before Calling While Loop
        int i = 0;
        //Define the End Point in While Loop
        while (i < houseNumber.length){
            System.out.println("My zipcode is " + zipcode[i] + " house number " + houseNumber[i]);
            //Incrementing
            i = i + 1;
        }//End of While Loop
    }//End of Main Method
}//End of Java Class
