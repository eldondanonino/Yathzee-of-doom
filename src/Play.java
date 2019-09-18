import java.util.Scanner;

 class Play {
 static boolean cheating = false;
     static void Game(Scanner sc) {
        String[] PlayerList = {"X", "X", "X", "X"};
        int [][]ArrayOfScores = new int[10][10];
        PlayerList = Menu.choice(sc);
        System.out.println("There are " + Menu.PlayerCounter(PlayerList) + " players");
        StringBuffer b = new StringBuffer();
        b.append('\u2620');
        System.out.println();
        System.out.println(b + " T H I S  I S  T H E  Y A T H Z E E  O F  D O O M ! " + b + "\n");

        for (int i = 0; i < 13; i++) {
            for (int j = 0;  j< Menu.PlayerCounter(PlayerList); j++)
            {
                System.out.println("\nIt's " + Menu.player[j] + "'s turn to play!");
                int[] ArrayOfDices = Dice.Throw(sc);
                ArrayOfScores = UpperScore.Scoring(ArrayOfDices, j, sc);
                UpperScore.Display(j, ArrayOfDices);
            }
        }
        UpperScore.Bonus(ArrayOfScores, Menu.PlayerCounter(PlayerList));
    }
}
