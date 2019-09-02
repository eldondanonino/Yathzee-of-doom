public class Play {

    public static void Game() {
        System.out.println("\n T H I S  I S  T H E  Y A T H Z E E  O F  D O O M !\n");

        int[] ArrayOfScores = new int[0];

        for (int x = 0; x < 6; x++) {
            int[] ArrayOfDices = Dice.Throw();
            ArrayOfScores = UpperScore.Scoring(ArrayOfDices);
            UpperScore.Display();
        }
        UpperScore.Bonus(ArrayOfScores);
    }
}
