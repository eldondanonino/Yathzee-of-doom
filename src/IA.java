import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class IA {
    static int[]ArrayOfDices= {0,0,0,0,0};
    static int[]ScoreIA= {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};

    static void higherDice(Scanner sc){

        int higher=0;

        for (int i=0; i < 5; i++)
        {
            IA.ArrayOfDices[i]= ThreadLocalRandom.current().nextInt(1, 6 + 1);
            if (IA.ArrayOfDices[i] > higher)
            {
                higher = IA.ArrayOfDices[i];
            }
        }

        DisplayIA();

        for (int j=0; j < 2; j++) {
            for (int i = 0; i < 5; i++) {
                if (higher > IA.ArrayOfDices[i]) {
                    rerollIA(i);
                }
                if (IA.ArrayOfDices[i] > higher)
                {
                    higher = IA.ArrayOfDices[i];
                }
            }
            for (int n = 0; n < 5; n++){
                System.out.println("The AI's dice n'" + (n+1) + " has a value of " + IA.ArrayOfDices[n]);
            }
            System.out.println(" ");
        }
        fillScore();
        DisplayIA();
        sc.nextLine();
        sc.nextLine();
    }

    static void rerollIA(int Dice){
        IA.ArrayOfDices[Dice]= ThreadLocalRandom.current().nextInt(1, 6 + 1);
    }

    static void DisplayIA(){


        System.out.println("\nThe AI's score is: \n");
        for (int x = 0; x < 6; x++) {
            if (IA.ScoreIA[x] == -1) {
                System.out.println("                [" + (x + 1) + "]" + "   | ( " + UpperScore.Epitaph((x+1), IA.ArrayOfDices) + " )");
            } else {
                System.out.println("                [" + (x + 1) + "]" + "   | " + IA.ScoreIA[x]);
            }

        }

        for (int x = 6; x < 13; x++) {
            switch (x) {
                case 6:
                    if (IA.ScoreIA[x] == -1) {
                        System.out.println("Three of a kind (7)   | ( " + UpperScore.Epitaph((x+1), IA.ArrayOfDices) + " )");
                    } else {
                        System.out.println("Three of a kind (7)   | " + IA.ScoreIA[x]);
                    }
                    break;

                case 7:
                    if (IA.ScoreIA[x] == -1) {
                        System.out.println("Four of a kind  (8)   | ( " + UpperScore.Epitaph((x+1), IA.ArrayOfDices) + " )");
                    } else {
                        System.out.println("Four of a kind  (8)   | " + IA.ScoreIA[x]);
                    }
                    break;

                case 8:
                    if (IA.ScoreIA[x] == -1) {
                        System.out.println("Full House      (9)   | ( " + UpperScore.Epitaph((x+1), IA.ArrayOfDices) + " )");
                    } else {
                        System.out.println("Full House      (9)   | " + IA.ScoreIA[x]);
                    }
                    break;

                case 9:
                    if (IA.ScoreIA[x] == -1) {
                        System.out.println("Small Straight  (10)  | ( " + UpperScore.Epitaph((x+1), IA.ArrayOfDices) + " )");
                    } else {
                        System.out.println("Small Straight  (10)  | " + IA.ScoreIA[x]);
                    }
                    break;

                case 10:
                    if (IA.ScoreIA[x] == -1) {
                        System.out.println("Large Straight  (11)  | ( " + UpperScore.Epitaph((x+1), IA.ArrayOfDices) + " )");
                    } else {
                        System.out.println("Large Straight  (11)  | " + IA.ScoreIA[x]);
                    }
                    break;

                case 11:
                    if (IA.ScoreIA[x] == -1) {
                        System.out.println("Chance          (12)  | ( " + UpperScore.Epitaph((x+1), IA.ArrayOfDices) + " )");
                    } else {
                        System.out.println("Chance          (12)  | " + IA.ScoreIA[x]);
                    }
                    break;

                case 12:
                    if (IA.ScoreIA[x] == -1) {
                        System.out.println("YAHTZEE         (13)  | ( " + UpperScore.Epitaph((x+1), IA.ArrayOfDices) + " )");
                    } else {
                        System.out.println("YAHTZEE         (13)  | " + IA.ScoreIA[x]);
                    }
                    break;
            }
        }



    }

    static void fillScore(){
        int bestscore=-1;
        int bestindex=-1;
        for (int x=0; x<13; x++)
        {
            if (UpperScore.Epitaph((x+1), IA.ArrayOfDices)>=bestscore && IA.ScoreIA[x]==-1)
            {
                bestscore=UpperScore.Epitaph((x+1), IA.ArrayOfDices);
                bestindex=x;
            }
        }
        IA.ScoreIA[bestindex]=bestscore;
    }

    static void BonusIA(){
        int sum1=0, sum2=0, bonus=0;

            for (int c = 0; c < 6; c++) //we count the total score
            {
                sum1 += IA.ScoreIA[c];
            }

            if (sum1 >= 63) //we check if the IA gets the bonus
            {
                bonus = 35;
            }
            System.out.println("______________________________________________");
            System.out.println("Upper Score : " + sum1);
            System.out.println("Bonus (Upper Score >62) : " + bonus);
            System.out.println("Total of Upper Score : " + (sum1 + bonus));
            System.out.println("______________________________________________");
            for (int c = 6; c < 13; c++) //we count the total score
            {
                sum2 += IA.ScoreIA[c];
            }
            System.out.println("Lower Score : " + sum2);
            System.out.println("Total Score : " + (sum1 + sum2));

    }

}

