import java.util.Scanner;

public class Play {
 static boolean cheating = false;
    public static void Game(Scanner sc) {
        String[] PlayerList = {"X", "X", "X", "X"};
        int[] ArrayOfScores = new int[0];
        PlayerList = Menu.choice(sc);
        System.out.println("There are " + Menu.PlayerCounter(PlayerList) + "players");
        StringBuffer b = new StringBuffer();
        b.append('\u2620');
        System.out.println();
        System.out.println(b + " T H I S  I S  T H E  Y A T H Z E E  O F  D O O M ! " + b + "\n");

        for (int i = 0; i < 13; i++) {
            int[] ArrayOfDices = Dice.Throw(sc);
            ArrayOfScores = UpperScore.Scoring(ArrayOfDices,sc);
            UpperScore.Display();
        }
        UpperScore.Bonus(ArrayOfScores);
    }
}
