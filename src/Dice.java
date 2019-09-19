import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;


class Dice
{

    private static void printScreen(int[] ArrayOfDice, boolean toggle) //method that prints the current hand and the sum of all dice
    {
        int n, sum=0;

        System.out.println("\n");
        for (n = 0; n < 5; n++)
        {
            if (ArrayOfDice[n] == -1 && toggle ) // if the die is not yet initialized, we give it a random value between 1 and 6
            {
                ArrayOfDice[n] = ThreadLocalRandom.current().nextInt(1, 6 + 1);
            }
            sum += ArrayOfDice[n]; // Value of the sum of our hand
            if(ArrayOfDice[n]!=-1)
                System.out.println("Your dice n°" + (n+1) + " has a value of " + ArrayOfDice[n]);
            else
                System.out.println("Your dice n°" + (n+1) + " will be rerolled!");
            if (n==4)
                System.out.println(" ");
        }
        if (toggle)
            System.out.println("Your sum of dice has a value of  " + sum + " points!\n"); // if true, we will output the sum of our hand (doesnt work if we have some -1 values)
                                                                                                                                        //this will be useful for when we will implement the lower part of the table
    }

    private static int Cheat(int[] ArrayOfDice, Scanner sc)
    {
        for (int i = 0; i<5; i++)
        {
            System.out.println("input value of die" + i);
            do {
                sc.nextLine();
            }while(!sc.hasNextInt());
            ArrayOfDice[i] = sc.nextInt();
        }
        return 2;
    }

    private static int Reroll (int[] ArrayOfDice, int[] Failsafe, int turnCounter, Scanner bob) //method that rerolls the value of selected dice
    {
        int n, input = 0;
        //System.out.println("Failsafe has these values : " + Failsafe[0] + Failsafe[1] + Failsafe[2] + Failsafe[3] + Failsafe[4] );
            do {
                //printScreen(ArrayOfDice, false);
                System.out.println("Let's reroll!");
                bob.nextLine();
                System.out.println("\nWould you like to reroll some dice? Press ENTER and then choose from (1= YES / 2=NO / 3=DEBUG)");
                do {
                    bob.nextLine();
                   // System.out.println("Baby proof loop");
                }while(!bob.hasNextInt());
                input = bob.nextInt();
                //System.out.println("it's ok man");
            } while (input < 1 || input > 3);

        if (input == 1) {
            System.out.println("\nReroll time! (reroll " + (turnCounter + 1) + " out of 2)");
            System.out.println("Which die do you want to reroll? (write 0 to stop the reroll)");
            System.out.println("Pro tip! You can write all the dice that you want to reroll at once, just put a space in between each one!");
            do // reroll dice until the user inputs a stop (0)
            {
                do //we check that the dice we want to reroll exists
                {
                    do {
                        bob.nextLine();
                    }while(!bob.hasNextInt());
                    n = bob.nextInt();
                    n--;
                    if (n < -1 || n > 4)
                        System.out.println("This dice does not exist!");
                } while (n < -1 || n > 4);

                if (n == -1) break;  // we stop the reroll if the user wants to

                if (ArrayOfDice[n] == -1) // if the user changes his mind we reset the dice to its previous value
                {
                    ArrayOfDice[n] = Failsafe[n];
                    System.out.println(ArrayOfDice[n]);
                    //printScreen(ArrayOfDice,false);
                }

                else

                if (n <= 5 && n >= 0 && ArrayOfDice[n] != -1) // actual reroll phase (we give it an uninitialized value of -1 like in the beginning)
                {
                    ArrayOfDice[n] = -1;
                    System.out.println("Next throw, die n°" + (n+1) + " will be rerolled!");
                }

                printScreen(ArrayOfDice, false);
                System.out.println("Which die do you want to reroll? (write 0 to stop the reroll)");
            } while (n != -1);
            System.out.println("\nREROLL DONE!");
        }
        if(input==2) // if the user does not wish to reroll anymore, we skip to the last phase of the turn
            turnCounter=2;
        if(input == 3) {
            Play.cheating = true;
            turnCounter = Cheat(ArrayOfDice, bob);
        }
        return turnCounter;
    }

     static int[] Throw (Scanner sc)  // method that gives a hand of 5 dice and the option to reroll them twice
    {
        int[]ArrayOfDice = new int[]{-1,-1,-1,-1,-1}; // our "Hand" of dice, still waiting to be initialized
        int turnCounter; //the "phase" of our turn (ranging from 0 to 2)
        int[]Failsafe = new int[]{-1,-1,-1,-1,-1};
        int j;
        printScreen(ArrayOfDice,true);
    for (turnCounter = 0; turnCounter<3; turnCounter++)
    {
        if(turnCounter != 2) // We can reroll dice only twice (aka on turn 0 and 1)
        {
           // we set up a backup array if the user changes his mind on a reroll
            for(j = 0;j<5; j++ ) {
                //System.out.println("AAAAAAAAA");
                Failsafe[j] = ArrayOfDice[j];
                //System.out.println(Failsafe[j]);
            }
            turnCounter = Reroll(ArrayOfDice, Failsafe, turnCounter,sc);
            printScreen(ArrayOfDice, true);
        }
    }
    //printScreen(ArrayOfDice, true);
    return ArrayOfDice;
    }

    /*
    // Failed attempt at implementing unicode dice
    public static void UnicodeDice(int valueOfDice)
    {
        char var1 = (char)valueOfDice;
        String bob = Character.toString((char)var1);
        String unicodeDie = String.valueOf(Character.toChars(Integer.parseInt(bob, 30)));
        System.out.println(unicodeDie);
    }
    */

    //Working implementation of unicode!
    /*
    StringBuffer b = new StringBuffer();
        b.append('\u2059');
        System.out.println(b);*/
}


