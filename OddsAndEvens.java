import java.util.*;

public class OddsAndEvens {
    public static void main(String[] args) {
        System.out.println("Let’s play a game called \"Odds and Evens\"");

        Scanner input = new Scanner(System.in);

        //Part 1 - Pick odds or evens
        System.out.print("What is your name? ");
        String name = input.nextLine();

        System.out.print("Hi " + name + ", which do you choose? (O)dds or (E)vens? ");
        String choice = input.next();

        boolean choiceFlag;
        choiceFlag = false;
        do {
            if (choice.equals("O")) {
                System.out.println(name + " has picked odds! The computer will be evens.");
                choiceFlag = true;
            } else if (choice.equals("E")) {
                System.out.println(name + " has picked evens! The computer will be odds.");
                choiceFlag = true;
            } else {
                //Taking input from the user after wrong choice made
                do {
                    System.out.println(name + "! you have made wrong choice.");
                    System.out.print("Choose either O or E, which one do you like? ");
                    choice = input.next();
                    if(choice.equals("O") || choice.equals("E"))
                        break;
                } while (!(choice.equals("E")));
            }
        } while( choiceFlag == false);
        System.out.println("--------------------------------------------------");
        System.out.println();

        //Part 2 - Play the Game
        System.out.print("How many \"finger(s)\" do you put out? ");
        int userNumber = input.nextInt();

        //Computer finger numbers
        Random rand = new Random();
        int computerNumber = rand.nextInt(6);

        boolean flag;
        flag = false;
        do {
            if(choice.equals("E") && userNumber % 2 == 0){
                if( computerNumber % 2 != 0)
                    flag = true;
                else if(computerNumber % 2 == 0)
                {
                    do{
                        computerNumber = rand.nextInt(6);
                    }while( computerNumber % 2 == 0 );
                }
            }
            else if(choice.equals("O") && userNumber % 2 != 0){
                if( computerNumber % 2 == 0)
                    flag = true;
                else if(computerNumber % 2 != 0)
                {
                    do{
                        computerNumber = rand.nextInt(6);
                    }while( computerNumber % 2 != 0 );
                }
            }
            else {
                flag = false;
                System.out.print("Choose \"fingers\" according to selected \"" + choice +  "\" choice: ");
                userNumber = input.nextInt();
            }
        } while (flag == false);

        System.out.println("The computer plays " +  computerNumber +  " \"finger(s)\".");
        System.out.println("--------------------------------------------------");
        System.out.println();
        //Results
        int sum = userNumber + computerNumber;
        System.out.println( userNumber + "+" + computerNumber + " = " + sum);
        if( sum % 2 == 0 ) {
            System.out.println( sum + " is ...even!");
            //Part 3(i) - Who won?
            if( userNumber % 2 == 0)
                System.out.println("That means " + name + " wins!");
            else
                System.out.println("That means computer wins!");
        }
        else{
            System.out.println( sum + " is ...odd!");
            //Part 3(ii) - Who won?
            if( userNumber % 2 != 0)
                System.out.println("That means " + name + " wins!");
            else
                System.out.println("That means computer wins!");
        }
        System.out.println("--------------------------------------------------");
        System.out.println();
    }
}
