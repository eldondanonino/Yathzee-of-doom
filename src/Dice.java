import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Dice
{
    public static void Throw ()
    {
    int[]ArrayOfDice = new int[5];
    int n, sum = 0;
    for (n=0;n<5; n++)
    {
        ArrayOfDice[n] = ThreadLocalRandom.current().nextInt(1, 6 + 1);
        sum += ArrayOfDice[n];
        System.out.println("Your dice n°"+ n + " has a value of " + ArrayOfDice[n]);
    }
    System.out.println("your sum of dice is " + sum);

    }


}
