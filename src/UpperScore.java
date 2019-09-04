import java.util.Scanner;

public class UpperScore<tableScore> {

    static int tableScore[] = {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1}; //the -1 means that the specified line doesn't have a score yet


    public static int[] Scoring(int[] ArrayOfDice) //a method that saves the player's score in a table
    {
        Scanner line = new Scanner(System.in);

        UpperScore.Display();

        System.out.println("\nChoose the line that you want to fill");

        int choose = line.nextInt();

        while (choose < 1 || choose > 13 || UpperScore.tableScore[choose-1] != -1) //we check that the line chosen exists or hasn't been picked already
        {
            System.out.println("\nYou can't put your score here, please try again");
            UpperScore.Display();
            choose = line.nextInt();
        }

        if (choose>6)
        {
            LowerScore.Lower(ArrayOfDice, choose);
        }
        if (choose<7) {
            int d = 0;


            for (int c = 0; c < 5; c++) { //we count the total of the specified die faces
                if (ArrayOfDice[c] == choose) {
                    d++;
                }
            }

            UpperScore.tableScore[choose - 1] = d * choose; //we put the score in the table
        }
        return UpperScore.tableScore;
    }

    public static void Bonus(int[] ArrayOfScores)
    {
        int sum1=0, sum2=0, bonus=0;

        if(Play.cheating)
        System.out.println("You have used the debug command, so your score cannot be validated (it would'nt be fair for regular players)");
        else
        {
            for(int c = 0; c<6; c++) //we count the total score
            {
                sum1+=ArrayOfScores[c];
            }

            if(sum1>=63) //we check if the player gets the bonus
            {
                bonus = 35;
            }
            System.out.println("______________________________________________");
            System.out.println("Upper Score : " + sum1);
            System.out.println("Bonus (Upper Score >62) : " + bonus);
            System.out.println("Total of Upper Score : " + (sum1+bonus));
            System.out.println("______________________________________________");
            for(int c = 6; c < 13; c++) //we count the total score
            {
                sum2+=ArrayOfScores[c];
            }
            System.out.println("Lower Score : " + sum2);
            System.out.println("Total Score : " + (sum1 + sum2));
        }
        }
    public static void Display() { //a method that displays the current score after each throw
        System.out.println("Your current set of scores is : ");
        for(int x = 0; x<6; x++) {
            if(UpperScore.tableScore[x] == -1)
            {
                System.out.println("                [" + (x+1) + "]" + "   | X");
            }
            else
                {
                System.out.println("                [" + (x+1) + "]" + "   | " + UpperScore.tableScore[x]);
            }

        }

        for (int x = 6; x<13; x++){
            switch (x){
                case 6:
                    if(UpperScore.tableScore[x] == -1)
                    {
                        System.out.println("Three of a kind (7)   | X");
                    }
                    else
                    {
                        System.out.println("Three of a kind (7)   | " + UpperScore.tableScore[x]);
                    }
                    break;

                case 7:
                    if(UpperScore.tableScore[x] == -1)
                    {
                        System.out.println("Four of a kind  (8)   | X");
                    }
                    else
                    {
                        System.out.println("Four of a kind  (8)   | " + UpperScore.tableScore[x]);
                    }
                    break;

                case 8:
                    if(UpperScore.tableScore[x] == -1)
                    {
                        System.out.println("Full House      (9)   | X");
                    }
                    else
                    {
                        System.out.println("Full House      (9)   | " + UpperScore.tableScore[x]);
                    }
                    break;

                case 9:
                    if(UpperScore.tableScore[x] == -1)
                    {
                        System.out.println("Small Straight  (10)  | X");
                    }
                    else
                    {
                        System.out.println("Small Straight  (10)  | " + UpperScore.tableScore[x]);
                    }
                    break;

                case 10:
                    if(UpperScore.tableScore[x] == -1)
                    {
                        System.out.println("Large Straight  (11)  | X");
                    }
                    else
                    {
                        System.out.println("Large Straight  (11)  | " + UpperScore.tableScore[x]);
                    }
                    break;

                case 11:
                    if(UpperScore.tableScore[x] == -1)
                    {
                        System.out.println("Chance          (12)  | X");
                    }
                    else
                    {
                        System.out.println("Chance          (12)  | " + UpperScore.tableScore[x]);
                    }
                    break;

                case 12:
                    if(UpperScore.tableScore[x] == -1)
                    {
                        System.out.println("YAHTZEE         (13)  | X");
                    }
                    else
                    {
                        System.out.println("YAHTZEE         (13)  | " + UpperScore.tableScore[x]);
                    }
                    break;
            }
        }


    }
}
