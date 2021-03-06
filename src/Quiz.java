import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;

public class Quiz {
    public static void main(String[] args) {
        int attempts = 0;           //login attempt counter
        String Username = "";           //Empty string introduced before login loop which uses it as a condition
        ArrayList<String> LoginDatabase = new ArrayList<>(Arrays.asList("admin","Password123"));    //Creates Login database that includes username and password
        Scanner in = new Scanner(System.in);

        //Start loop
        boolean Login = false;
        while (!Login) {
            System.out.println("(N)New or (E)Existing User?");
            System.out.println("Please respond with either N or E as appropriate");
            String Menuchoice = in.nextLine();
            if (Menuchoice.equalsIgnoreCase("N")){
                System.out.println("New Username:");
                String NewUser = in.nextLine();                     //New Username input
                System.out.println("New Password:");
                String NewPass = in.nextLine();                     //New Password input
                System.out.println("Confirm Password");
                String Passconfirm = in.nextLine();                 //Password confirm
                if (NewPass.equals(Passconfirm)) {
                    boolean Found = false;
                    for (int i=0;i<LoginDatabase.size(); i=i+2){                    //for loop containing check to see if new username is already in database
                        if (NewUser.equalsIgnoreCase(LoginDatabase.get(i))) {
                            Found = true;
                            break;
                        }
                    }
                    if (Found) {                                                    //Once new username is confirmed to already exist returns error message before sending them back to start.
                        System.out.println("Please choose another username");
                    } else {
                        System.out.println("User Account created");                 //Creates a new user account before sending them to login screen
                        LoginDatabase.add(NewUser);
                        LoginDatabase.add(NewPass);
                        Login = true;
                    }
                } else {
                    System.out.println("Passwords do not match, Please try again"); //Error message when new password doesn't match password confirmation
                }
            } else if (Menuchoice.equalsIgnoreCase("E")){
                System.out.print("\n|Login|\n");                                    //Sends user to login
                Login = true;
            } else {
                System.out.println("Invalid input, please choose either \"N\" or \"E\"");       //Informs user that input doesn't match requirements
            }
        }

        //Login Loop
        boolean Lock = true;            //Determines if lock is in effect
        while (Lock) {
            Username="";
            while (Username == ""){
                System.out.println("Username:");
                Username = in.nextLine();               //Username input
                if (Username == "") {
                    System.out.println("Please Enter a Username");
                }
            }
            System.out.println("Password:");
            String Password = in.nextLine();        //Password input
            String Lockpass = null;
            boolean Found = false;
            for (int i=0;i<LoginDatabase.size(); i=i+2) {
                if (Username.equalsIgnoreCase(LoginDatabase.get(i))) {                  //Checks if User is in login database
                    Found = true;
                    Lockpass = LoginDatabase.get(i+1);                                  //creates a variable with password in database to later compare against entered password
                }
            }
            if (Found) {
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

        System.out.println("Login successful");
        System.out.println(" ");                                    //gap between lines to improve user experience

        //Quiz
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
        System.out.print("\n\nWhat is Prak's Favourite colour?\nIs it...\nA: Red\nB: Green\nC: Blue\nD: Black\nPlease select either A,B,C or D:\n");   //Question 2 with possible answers included - different approach - reduced line count but readability obscured
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
        System.out.println("Well done "+Username+" on completing this quiz");
        System.out.println("Your score is "+Points);                        //Score output message
        System.out.println("You got "+(3-Points)+" questions wrong");       //mentions number of questions wrong
    }
}