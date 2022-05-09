import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;

public class Quiz {
    public static void main(String[] args) {
        int attempts = 0;           //login attempt counter
        String Username = "";           //
        ArrayList<String> LoginDatabase = new ArrayList<>(Arrays.asList("admin","Password123"));
        Scanner in = new Scanner(System.in);
        while (Username.equals("")){        //Responsible for keeping user trapped if login was not correct
            boolean Lock = true;            //Determines if lock is in effect
            while (Lock) {
                System.out.println("Username:");
                Username = in.nextLine();
                System.out.println("Password:");
                String Password = in.nextLine();
                String Lockuser = LoginDatabase.get(0);
                String Lockpass = LoginDatabase.get(1);
                if (Username.equalsIgnoreCase(Lockuser)) {
                    if (attempts == 3) {
                        System.out.println("3 attempts used, try again later");     //if attempts are used up prevents login
                    } else {
                        if (Password.equals(Lockpass)) {
                            Lock = false;                       //Lets user out of both loops
                        } else {
                            attempts = attempts + 1;
                            if (attempts == 3){
                                System.out.println("3 attempts used, try again later");     //initial attempts used up message
                            } else {
                                System.out.println("Incorrect username/password, Try again");   //lets user know login is incorrect (password at fault)
                            }
                        }
                    }

                } else {
                    System.out.println("Incorrect username/password, Try again");               //lets user know login is incorrect (username at fault)
                }
            }
        }
        System.out.println("Login successful");
        System.out.println(" ");                                    //gap between lines to improve user experience
        System.out.println("Welcome to Prak's Quiz");
        System.out.println(" ");                                    //gap between lines to improve user experience
        int Points = 0;                                             //Point counter
        System.out.println("What is Prak's Favourite food?");       //Question 1
        System.out.println("Is it...");
        System.out.println("A: Pizza");                             //Possible Answers
        System.out.println("B: Banana");
        System.out.println("C: Cake");
        System.out.println("D: Lasagne");
        System.out.println("Please select either A,B,C or D:");
        String[] ResponsesQ1 = {"Yep, its yummy","I ain't no monkeh","Close but not quite","Was...once upon a time"};      //Stored responses in array for more readability of code
        String[] Errors = {"Please Select an answer","Invalid option, Try again"};      //Stored error messages in array to improve readability of code
        boolean Qlock = false;                                                 //Checks Question 1 is answered
        while (!Qlock){
            String choice = in.nextLine();                                  //takes value for choice
            if (choice.equalsIgnoreCase("A")) {                 //if else statements to provide responses and also add points where necessary, tried switch statements but dealing with answers of different case unknown
                Points = Points + 1;
                Qlock = true;
                System.out.println(ResponsesQ1[0]);
            } else if(choice.equalsIgnoreCase("B")) {           //used .equalsIgnoreCase to allow for non-case sensitive answers
                Qlock = true;
                System.out.println(ResponsesQ1[1]);
            } else if(choice.equalsIgnoreCase("C")) {
                Qlock = true;
                System.out.println(ResponsesQ1[2]);
            } else if(choice.equalsIgnoreCase("D")) {
                Qlock = true;
                System.out.println(ResponsesQ1[3]);
            } else if(choice=="") {                                         //error for no input
                System.out.println(Errors[0]);
            } else {                                                        //error for unrecognised inputs
                System.out.println(Errors[1]);
            }
        }
        System.out.print("\n\nWhat is Prak's Favourite colour?\nIs it...\nA: Red\nB: Green\nC: Blue\nD: Black\nPlease select either A,B,C or D:\n");                                        //Question 2 with possible answers included - different approach - reduced line count but readability obscured
        String[] ResponsesQ2 = {"Not a fan tbh","*Sick Face*","Cool as the seas *sunglasses smiley*","Go to for looking nice but not favourite"};      //Stored responses in array for more readability of code
        Qlock = false;         //Checks Question 2 is answered
        while (!Qlock){
            String choice = in.nextLine();                                  //takes value for choice
            if (choice.equalsIgnoreCase("A")) {                 //if else statements to provide responses and also add points where necessary,
                Qlock = true;
                System.out.println(ResponsesQ2[0]);
            } else if(choice.equalsIgnoreCase("B")) {
                Qlock = true;
                System.out.println(ResponsesQ2[1]);
            } else if(choice.equalsIgnoreCase("C")) {
                Points = Points + 1;
                Qlock = true;
                System.out.println(ResponsesQ2[2]);
            } else if(choice.equalsIgnoreCase("D")) {
                Qlock = true;
                System.out.println(ResponsesQ2[3]);
            } else if(choice=="") {                                         //error for no input
                System.out.println(Errors[0]);
            } else {                                                        //error for unrecognised inputs
                System.out.println(Errors[1]);
            }
        }
        System.out.println(" ");                                    //gap between lines to improve user experience
        System.out.println("What is Prak's Favourite game?");       //Question 3
        System.out.println("Is it...");
        System.out.println("A: Rocket League");                     //Possible Answers
        System.out.println("B: League of Legends");
        System.out.println("C: Valorant");
        System.out.println("D: Age of Darkness:Final Stand");
        System.out.println("Please select either A,B,C or D:");
        String[] ResponsesQ3 = {"Not a footie fan","The sad truth","too old for FPS","Only would play this to kill time at least till multiplayer comes out"};      //Stored responses in array for more readability of code
        Qlock = false;                                                      //Checks Question 3 is answered
        while (!Qlock){
            String choice = in.nextLine();                                  //takes value for choice
            if (choice.equalsIgnoreCase("A")) {                 //if else statements to provide responses and also add points where necessary,
                Qlock = true;
                System.out.println(ResponsesQ3[0]);
            } else if(choice.equalsIgnoreCase("B")) {
                Points = Points + 1;
                Qlock = true;
                System.out.println(ResponsesQ3[1]);
            } else if(choice.equalsIgnoreCase("C")) {
                Qlock = true;
                System.out.println(ResponsesQ3[2]);
            } else if(choice.equalsIgnoreCase("D")) {
                Qlock = true;
                System.out.println(ResponsesQ3[3]);
            } else if(choice=="") {                                         //error for no input
                System.out.println(Errors[0]);
            } else {                                                        //error for unrecognised inputs
                System.out.println(Errors[1]);
            }
        }
        System.out.println(" ");                                            //gap between lines to improve user experience
        System.out.println("Well done on completing this quiz");
        System.out.println("Your score is "+Points);                        //Score output message
        System.out.println("You got "+(3-Points)+" questions wrong");       //mentions number of questions wrong
    }
}