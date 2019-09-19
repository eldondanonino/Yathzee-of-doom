import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in); // we set a global scanner (so that we dont spend 3 hrs like idiots trying to understand why the nextInt is not working, while it was because of a sc.close() in the middle of the code)
        Play.Game(sc);
        sc.close();
    }
}
