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
        while (Username.equals("")){
            boolean Lock = true;
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
        ArrayList<String> Options = new ArrayList<String>();            //Created list for input values
        Options.add("A");           //Added options one by one
        Options.add("B");
        Options.add("C");
        Options.add("D");
        System.out.println("What is Prak's Favourite food?");       //Question
        System.out.println("Is it...");
        System.out.println("A: Pizza");     //Possible Answers
        System.out.println("B: Banana");
        System.out.println("C: Cake");
        System.out.println("D: Lasagne");
        int Points = 0;         //Point counter
        String choice = in.nextLine();          //takes value for choice
        boolean Q1 = false;         //Checks Question 1 is answered
        while (Q1 == false){
            switch (choice) {
                case  Options.get(0):
                    Points = Points + 1;
                    Q1 = true;
                    System.out.println("Correct");
                case  Options.get(1):
                    Q1 = true;
                    System.out.println("Incorrect");
                case  Options.get(2):
                    Q1 = true;
                    System.out.println("Incorrect");
                case  Options.get(3):
                    Q1 = true;
                    System.out.println("Incorrect");
                default:
                    System.out.println("Invalid option, Try again");
        }



        }
    }
}