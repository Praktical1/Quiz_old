import java.util.Scanner;
import java.util.ArrayList;

public class Quiz {
    public static void main(String[] args) {
        int attempts = 0;           //login attempt counter
        String Username = "";           //
        ArrayList<String> LoginDatabase = new ArrayList<String>();
        String Lockuser = "admin";
        String Lockpass = "Password123";
        Scanner in = new Scanner(System.in);
        while (Username.equals("")){        //
            boolean Lock = true;            //Determines if lock is in effect
            while (Lock) {
                System.out.println("Username:");
                Username = in.nextLine();
                System.out.println("Password:");
                String Password = in.nextLine();
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
        System.out.println("Welcome to Prak's Quiz");
        System.out.println("What is Prak's Favourite food?");       //Question 1
        System.out.println("Is it...");
        System.out.println("A: Pizza");     //Possible Answers
        System.out.println("B: Banana");
        System.out.println("C: Cake");
        System.out.println("D: Lasagne");
        int Points = 0;         //Point counter
        boolean Q1 = false;         //Checks Question 1 is answered
        while (!Q1){
            String choice = in.nextLine();          //takes value for choice
            if (choice.equalsIgnoreCase("A")) {
                Points = Points + 1;
                Q1 = true;
                System.out.println("Yep, its yummy");
            } else if(choice.equalsIgnoreCase("B")) {
                Q1 = true;
                System.out.println("I ain't no monkeh");
            } else if(choice.equalsIgnoreCase("C")) {
                Q1 = true;
                System.out.println("Close but not quite");
            } else if(choice.equalsIgnoreCase("D")) {
                Q1 = true;
                System.out.println("Was...once upon a time");
            } else if(choice=="") {
                System.out.println("Please Select an answer");
            } else {
                System.out.println("Invalid option, Try again");
            }
        }
        System.out.println("What is Prak's Favourite colour?");       //Question 2
        System.out.println("Is it...");
        System.out.println("A: Red");     //Possible Answers
        System.out.println("B: Green");
        System.out.println("C: Blue");
        System.out.println("D: Black");
        boolean Q2 = false;         //Checks Question 2 is answered
        System.out.println("What is Prak's Favourite game?");       //Question 3
        System.out.println("Is it...");
        System.out.println("A: Rocket League");     //Possible Answers
        System.out.println("B: League of Legends");
        System.out.println("C: Valorant");
        System.out.println("D: Age of Darkness:Final Stand");
        boolean Q3 = false;         //Checks Question 3 is answered

    }
}