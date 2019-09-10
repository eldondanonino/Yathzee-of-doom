import java.util.Scanner;


public class Menu {

    public static String[] choice (Scanner sc) {

    String[] player = {"X", "X", "X", "X"}; //we define a set of stri,gs which will hold the players names
    System.out.println("_____________________");
    System.out.println("1- Play Yathzee");
    System.out.println("2- Informations");
    System.out.println("3- Exit");
    System.out.println("_____________________");
    int option = sc.nextInt();

    switch(option){ //We ask for the menu option
        case 1 :
            player = Menu.Choice1(sc); //if the choice is to play, we need to retrieve the number of players
            break;
        case 2 :
            Menu.Choice2(sc); //we diplay the rules and come back to the menu
            break;
        case 3:
            Menu.Choice3(); //we exit the game
            break;
        }
    return player;
    }

    public static int PlayerCounter (String[] player){ //a simple methods that returns the number of players
        int i = 0;
            do
            {
                i++;
            }while (player[i-1] != "X" || i != 4 );
        return i;
    }


    public static String[] Choice1 (Scanner sc)
    {
        String[] player = {"X", "X", "X", "X"};
        int i ;

        System.out.println("Input the number of players : ");
        int player_number = sc.nextInt();

        while (player_number > 3) {
            System.out.println("The number of players must be lower than four");
            System.out.println("Input the number of players : ");
            player_number = sc.nextInt();
        }
        while (player_number < 1) {
            System.out.println("The number of players is insufficient");
            System.out.println("Input the number of players : ");
            player_number = sc.nextInt();
        }

        for (i = 0; i < player_number; i++) {
            System.out.println("Press enter to continue :) ");
            sc.nextLine(); //temporary fix to the buffer issue (will be fixed with the use of a gui)
            System.out.printf("Please input the name of player " + (i+1) + " : ");
            player[i] = sc.nextLine();
        }
        return player;
    }

    public static void Choice2 (Scanner sc) {
        System.out.println("\nInformations about Yahtzee\n");
        System.out.println("1. Roll up to 3 times each turn to rack up the best possible score.");
        System.out.println("2. Decide which dice combo you're going for.");
        System.out.println("3. After each turn, mark your score in one empty box on the score card. \n  ");
        System.out.println("Press any key to continue");
        sc.nextLine();
        Menu.choice(sc);
    }

    public static void Choice3 () {
                System.exit(0);
            }
}

