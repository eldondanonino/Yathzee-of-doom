public class Play {
 static boolean cheating = false;
    public static void Game() {
        boolean cheating = false;

        StringBuffer b = new StringBuffer();
        b.append('\u2620');
        System.out.println();
        System.out.println(b + " T H I S  I S  T H E  Y A T H Z E E  O F  D O O M ! " + b + "\n");

        int[] ArrayOfScores = new int[0];

        for (int i = 0; i < 13; i++) {
            int[] ArrayOfDices = Dice.Throw();
            ArrayOfScores = UpperScore.Scoring(ArrayOfDices);
            UpperScore.Display();
        }
        UpperScore.Bonus(ArrayOfScores);
    }
}
