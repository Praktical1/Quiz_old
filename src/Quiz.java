import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;

public class Quiz {
    public static void main(String[] args) {
        int attempts = 0;           //login attempt counter
        String Username = "";           //
        ArrayList<String> LoginDatabase = new ArrayList<>(Arrays.asList("admin","Password123"));
        Scanner in = new Scanner(System.in);
        while (Username.equals("")){        //
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
                        System.out.println("3 attempts used, try again later");
                    } else {
                        if (Password.equals(Lockpass)) {
                            Lock = false;
                        } else {
                            attempts = attempts + 1;
                            Lock = false;
                            Username = "";
                            if (attempts == 3){
                                System.out.println("3 attempts used, try again later");
                            } else {
                                System.out.println("Incorrect username/password, Try again");
                            }
                        }
                    }

                } else {
                    System.out.println("Incorrect username/password, Try again");
                    Lock = false;
                    Username = "";
                }
            }
        }
        System.out.println("Login successful");
        System.out.println(" ");
        System.out.println("Welcome to Prak's Quiz");
        System.out.println(" ");
        int Points = 0;         //Point counter
        System.out.println("What is Prak's Favourite food?");       //Question 1
        System.out.println("Is it...");
        System.out.println("A: Pizza");     //Possible Answers
        System.out.println("B: Banana");
        System.out.println("C: Cake");
        System.out.println("D: Lasagne");
        String[] ResponsesQ1 = {"Yep, its yummy","I ain't no monkeh","Close but not quite","Was...once upon a time"};
        String[] Errors = {"Please Select an answer","Invalid option, Try again"};
        boolean Q1 = false;         //Checks Question 1 is answered
        while (!Q1){
            String choice = in.nextLine();          //takes value for choice
            if (choice.equalsIgnoreCase("A")) {
                Points = Points + 1;
                Q1 = true;
                System.out.println(ResponsesQ1[0]);
            } else if(choice.equalsIgnoreCase("B")) {
                Q1 = true;
                System.out.println(ResponsesQ1[1]);
            } else if(choice.equalsIgnoreCase("C")) {
                Q1 = true;
                System.out.println(ResponsesQ1[2]);
            } else if(choice.equalsIgnoreCase("D")) {
                Q1 = true;
                System.out.println(ResponsesQ1[3]);
            } else if(choice=="") {
                System.out.println(Errors[0]);
            } else {
                System.out.println(Errors[1]);
            }
        }
        System.out.println(" ");
        System.out.println("What is Prak's Favourite colour?");       //Question 2
        System.out.println("Is it...");
        System.out.println("A: Red");     //Possible Answers
        System.out.println("B: Green");
        System.out.println("C: Blue");
        System.out.println("D: Black");
        String[] ResponsesQ2 = {"Not a fan tbh","*Sick Face*","Cool as the seas *sunglasses smiley*","Go to for looking nice but not favourite"};
        boolean Q2 = false;         //Checks Question 2 is answered
        while (!Q2){
            String choice = in.nextLine();          //takes value for choice
            if (choice.equalsIgnoreCase("A")) {
                Q2 = true;
                System.out.println(ResponsesQ2[0]);
            } else if(choice.equalsIgnoreCase("B")) {
                Q2 = true;
                System.out.println(ResponsesQ2[1]);
            } else if(choice.equalsIgnoreCase("C")) {
                Points = Points + 1;
                Q2 = true;
                System.out.println(ResponsesQ2[2]);
            } else if(choice.equalsIgnoreCase("D")) {
                Q2 = true;
                System.out.println(ResponsesQ2[3]);
            } else if(choice=="") {
                System.out.println(Errors[0]);
            } else {
                System.out.println(Errors[1]);
            }
        }
        System.out.println(" ");
        System.out.println("What is Prak's Favourite game?");       //Question 3
        System.out.println("Is it...");
        System.out.println("A: Rocket League");     //Possible Answers
        System.out.println("B: League of Legends");
        System.out.println("C: Valorant");
        System.out.println("D: Age of Darkness:Final Stand");
        String[] ResponsesQ3 = {"Not a footie fan","The sad truth","too old for FPS","Only would play this to kill time at least till multiplayer comes out"};
        boolean Q3 = false;         //Checks Question 3 is answered
        while (!Q3){
            String choice = in.nextLine();          //takes value for choice
            if (choice.equalsIgnoreCase("A")) {
                Q3 = true;
                System.out.println(ResponsesQ3[0]);
            } else if(choice.equalsIgnoreCase("B")) {
                Points = Points + 1;
                Q3 = true;
                System.out.println(ResponsesQ3[1]);
            } else if(choice.equalsIgnoreCase("C")) {
                Q3 = true;
                System.out.println(ResponsesQ3[2]);
            } else if(choice.equalsIgnoreCase("D")) {
                Q3 = true;
                System.out.println(ResponsesQ3[3]);
            } else if(choice=="") {
                System.out.println(Errors[0]);
            } else {
                System.out.println(Errors[1]);
            }
        }
        System.out.println(" ");
        System.out.println("Well done on completing this quiz");
        System.out.println("Your score is "+Points);
        System.out.println("You got "+(3-Points)+" questions wrong");
    }
}