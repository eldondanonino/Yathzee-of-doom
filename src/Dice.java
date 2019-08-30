import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Dice
{
    public static int[] Throw ()
    {
        Scanner sc = new Scanner(System.in);
    int[]ArrayOfDice = new int[]{-1,-1,-1,-1,-1};
    int n, sum = 0;
    int turnCounter, input;
    for (turnCounter = 0; turnCounter<3; turnCounter++)
    {
        for (n = 0; n < 5; n++)
        {
            if (ArrayOfDice[n] == -1)
            {
                ArrayOfDice[n] = ThreadLocalRandom.current().nextInt(1, 6 + 1);
            }
            sum += ArrayOfDice[n];
            System.out.println("Your dice n°" + n + " has a value of " + ArrayOfDice[n]);
        }
        System.out.println("your sum of dice is " + sum);
        sum=0;
        if(turnCounter != 2)
        {
            System.out.println("Would you like to reroll some dice? (1= YES / 2=NO)");
            input = sc.nextInt();
            if (input==1)
            {
                System.out.println("Reroll time! (Turn n°" + turnCounter + ")");
                System.out.println("Which die do you want to reroll? (write -1 to stop the reroll)");
              do
            {
                do
                {
                    n = sc.nextInt();
                    if(n<-1 || n>5)
                    System.out.println("This dice does not exist!");
                }  while(n<-1 || n>5);
                if(n==-1) break;
                if(ArrayOfDice[n] == -1)
                {
                    System.out.println("This dice will already be rerolled!");
                }
                if (n <= 5 && n >= 0 && ArrayOfDice[n] != -1)
                {
                    ArrayOfDice[n] = -1;
                    System.out.println("Next throw, die n°" + n + " will be rerolled!");
                }
            }while(n != -1);
            }
            if(input==2)
                turnCounter=2;
        }
    }
    return ArrayOfDice;
    }
}
