import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;


public class Dice
{

    public static void printScreen(int[] ArrayOfDice, boolean toggle) //method that prints the current hand and the sum of all dice
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
                System.out.println("Your dice n°" + n + " has a value of " + ArrayOfDice[n]);
            else
                System.out.println("Your dice n°" + n + " will be rerolled!");
            if (n==4)
                System.out.println(" ");
        }
        if (toggle)
            System.out.println("Your sum of dice has a value of  " + sum + " points!\n");
    }

    public static int Reroll (int[] ArrayOfDice, int[] Failsafe, int turnCounter)
    {
        int n, input = 0;
        Scanner sc = new Scanner(System.in);
        //System.out.println("Failsafe has these values : " + Failsafe[0] + Failsafe[1] + Failsafe[2] + Failsafe[3] + Failsafe[4] );

            do {
                //printScreen(ArrayOfDice, false);
                System.out.println("\nWould you like to reroll some dice? (1= YES / 2=NO)");
                input = sc.nextInt();
            } while (input < 1 || input > 2);

        if (input == 1) {
            System.out.println("\nReroll time! (reroll " + (turnCounter + 1) + " out of 2)");
            System.out.println("Which die do you want to reroll? (write -1 to stop the reroll)");
            do // reroll dice untill the user inputs a stop (-1)
            {
                do //we check that the dice we want to reroll exists
                {
                    n = sc.nextInt();
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
                    System.out.println("Next throw, die n°" + n + " will be rerolled!");
                }

                printScreen(ArrayOfDice, false);
                System.out.println("Which die do you want to reroll? (write -1 to stop the reroll)");
            } while (n != -1);
            System.out.println("\nREROLL DONE!");
        }
        if(input==2) // if the user does not wish to reroll anymore, we skip to the last phase of the turn
            turnCounter=2;
        return turnCounter;
    }

    public static int[] Throw ()  // method that gives a hand of 5 dice and the option to reroll them twice
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
            j=0;
           // we set up a backup array if the user changes his mind on a reroll
            do
            {
                //System.out.println("AAAAAAAAA");
                Failsafe[j] = ArrayOfDice[j];
                //System.out.println(Failsafe[j]);
                j++;
            }while(j!=5);
            //printScreen(Failsafe,true);
            turnCounter = Reroll(ArrayOfDice, Failsafe, turnCounter);
            printScreen(ArrayOfDice, true);
        }
    }
    //printScreen(ArrayOfDice, true);
    return ArrayOfDice;
    }
}

    /* Failed attempt at implementing unicode dice
    public static void UnicodeDice(int valueOfDice)
    {
        char var1 = (char)valueOfDice;
        String bob = Character.toString((char)var1);
        String unicodeDie = String.valueOf(Character.toChars(Integer.parseInt(bob, 16)));
        System.out.println(unicodeDie);
    }
*/
