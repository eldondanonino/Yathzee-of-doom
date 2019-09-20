import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        System.out.println("\nWHEN IN DOUBT, press enter! The buffer issue may cause the program to not correctly register your input, so " +
                " just try again!\nEverything should work fine if you start by pressing enter. Sorry for the disturbance and good game.  ");
        Scanner sc = new Scanner(System.in); // we set a global scanner (so that we dont spend 3 hrs like idiots trying to understand why the nextInt is not working, while it was because of a sc.close() in the middle of the code)
        Play.Game(sc);
        sc.close();
    }
}
