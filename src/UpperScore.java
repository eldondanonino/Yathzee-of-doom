import java.util.Scanner;

 class UpperScore {

    static int[] tableScore[] = {{-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1},
            {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1}, {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1}}; //the -1 means that the specified line doesn't have a score yet


     static int[][] Scoring(int[] ArrayOfDice, int player, Scanner line) //a method that saves the player's score in a table
    {
        UpperScore.Display(player, ArrayOfDice);

        System.out.println("\nChoose the line that you want to fill");
        do {
            line.nextLine();
        }while(!line.hasNextInt());
        int choose = line.nextInt();


        while (choose < 1 || choose > 13 || UpperScore.tableScore[player][choose - 1] != -1) //we check that the line chosen exists or hasn't been picked already]
        {
            System.out.println("\nYou can't put your score here, please try again");
            UpperScore.Display(player, ArrayOfDice);
            do {
                line.nextLine();
            }while(!line.hasNextInt());
            choose = line.nextInt();
        }

        if (choose > 6) {
            LowerScore.Lower(ArrayOfDice, choose, player);
        }
        if (choose < 7) {
            int d = 0;


            for (int c = 0; c < 5; c++) { //we count the total of the specified die faces
                if (ArrayOfDice[c] == choose) {
                    d++;
                }
            }

            UpperScore.tableScore[player][choose - 1] = d * choose; //we put the score in the table
        }
        return UpperScore.tableScore;
    }


     static void Bonus(int[][] ArrayOfScores, int player)
    {
        int sum1=0, sum2=0, bonus=0;

        /*if(Play.cheating)
        System.out.println("You have used the debug command, so your score cannot be validated (it would'nt be fair for regular players)");
        else
        {*/
        for (int i=0; i < player; i++) {
            for (int c = 0; c < 6; c++) //we count the total score
            {
                sum1 += ArrayOfScores[i][c];
            }

            if (sum1 >= 63) //we check if the player gets the bonus
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
                sum2 += ArrayOfScores[player][c];
            }
            System.out.println("Lower Score : " + sum2);
            System.out.println("Total Score : " + (sum1 + sum2));
        }
        }

     private static int Epitaph(int line, int[] ArrayOfDice) {
        int d = 0, c , counter, sum = 0, cpt = 0, sentinel = 0;
        switch (line) {

            case 1:

                for (c = 0; c < 5; c++) { //we count the total of the specified die faces
                    if (ArrayOfDice[c] == line) {
                        d++;
                    }
                }
                return (d * line);
            case 2:

                for (c = 0; c < 5; c++) { //we count the total of the specified die faces
                    if (ArrayOfDice[c] == line) {
                        d++;
                    }
                }
                return (d * line);
            case 3:

                for (c = 0; c < 5; c++) { //we count the total of the specified die faces
                    if (ArrayOfDice[c] == line) {
                        d++;
                    }
                }
                return (d * line);
            case 4:

                for (c = 0; c < 5; c++) { //we count the total of the specified die faces
                    if (ArrayOfDice[c] == line) {
                        d++;
                    }
                }
                return (d * line);
            case 5:

                for (c = 0; c < 5; c++) { //we count the total of the specified die faces
                    if (ArrayOfDice[c] == line) {
                        d++;
                    }
                }
                return (d * line);
            case 6:

                for (c = 0; c < 5; c++) { //we count the total of the specified die faces
                    if (ArrayOfDice[c] == line) {
                        d++;
                    }
                }
                return (d * line);

            case 7:

                for (c = 1; c < 7; c++) //we check a 3oak for each value of die
                {
                    counter = 0;
                    for (d = 0; d < 5; d++)  //we go through our hand
                    {
                        if (ArrayOfDice[d] == c) {
                            counter++;
                        }

                        if (counter >= 3) {

                            for (int e = 0; e < 5; e++) //we sum up every die
                            {
                                sum += ArrayOfDice[e];
                            }
                            return sum;
                        }
                    }
                }
                break;

            case 8:

                for (c = 1; c < 7; c++) //we check a 3oak for each value of die
                {
                    counter = 0;
                    for (d = 0; d < 5; d++)  //we go through our hand
                    {
                        if (ArrayOfDice[d] == c) {
                            counter++;
                        }

                        if (counter >= 4) {

                            for (int e = 0; e < 5; e++) //we sum up every die
                            {
                                sum += ArrayOfDice[e];
                            }
                            return sum;
                        }
                    }
                }
                break;

            case 9:
                int trio = 0;
                for (c = 1; c < 7; c++) //we check a 3oak for each value of die
                {
                    counter = 0;
                    for (d = 0; d < 5; d++)  //we go through our hand
                    {
                        if (ArrayOfDice[d] == c) {
                            counter++;
                        }

                        if (counter >= 3) {

                            trio = c;
                            boolean pair = LowerScore.TwoOfAKind(ArrayOfDice, trio, 1);
                            if (pair) {
                                return 25;
                            }
                        }
                    }
                }
                break;

            case 10:
                cpt = 0;
                for(int i = 0; i<5; i++)
                {
                    if (ArrayOfDice[i] == 6) { // if our hand contains 6 then we must check for 3 4 5 6
                        for (int j = 0; j < 5; j++)
                        {
                            if (ArrayOfDice[j] == 5) //only if we have 5 in our hand
                                sentinel = 1;
                        }

                    }
                    if (sentinel != 0)
                        break;
                }

                if(sentinel == 0) {
                    for (int i = 0; i < 5; i++) {
                        if (ArrayOfDice[i] == 5) { // if our hand contains 1 then we must check for 2 3 4 5
                            for (int j = 0; j < 5; j++) {
                                if (ArrayOfDice[j] == 4)
                                    sentinel = 2;
                            }

                        }
                        if (sentinel != 0)
                            break;
                    }
                }

                if(sentinel == 0) {
                    for (int i = 0; i < 5; i++) {
                        if (ArrayOfDice[i] == 4) { // if our hand contains 1 then we must check for 1 2 3 4
                            for (int j = 0; j < 5; j++) {
                                if (ArrayOfDice[j] == 3)
                                    sentinel = 3;
                            }

                        }
                        if (sentinel != 0)
                            break;
                    }
                }

                switch(sentinel) {
                    case 0:
                        return 0;


                    case 1:

                        for (int i = 3; i < 7; i++) {
                            for (int j = 0; j < 5; j++) {
                                if (ArrayOfDice[j] == i) {
                                    cpt++;
                                    break;
                                }
                            }
                        }
                        if (cpt == 4)
                            return 30;
                        else return 0;


                    case 2:
                        for (int i = 2; i < 6; i++) {
                            for (int j = 0; j < 5; j++) {
                                if (ArrayOfDice[j] == i) {
                                    cpt++;
                                    break;
                                }
                            }
                        }
                        if (cpt == 4)
                            return 30;
                        else return 0;


                    case 3:
                        for (int i = 1; i < 5; i++) {
                            for (int j = 0; j < 5; j++) {
                                if (ArrayOfDice[j] == i) {
                                    cpt++;
                                    break;
                                }
                            }
                        }
                        if (cpt == 4)
                            return 30;
                        else return 0;
                }


                    case 11:

                        for(int i = 0; i<5; i++)
                        {
                            if(ArrayOfDice[i] == 1) { // if our hand contains 1 then we must check for 1 2 3 4 5
                                sentinel = 1;
                                break;
                            }
                            if(ArrayOfDice[i] == 6) // if our hand contains 6 then we must check for 2 3 4 5 6
                            {
                                sentinel = 2;
                            }
                        }
                        switch(sentinel)
                        {
                            case 1 :
                                cpt = 0;
                                for(int j = 1; j< 6; j++) // we look for the 1 2 3 4 5 straight
                                {
                                    for(int k = 0; k < 5; k++)
                                    {
                                        if(ArrayOfDice[k] == j)
                                        {
                                            cpt++;
                                            break;
                                        }
                                    }
                                }
                                if(cpt == 5)
                                    return 40;
                                else return 0;

                            case 2 :
                                cpt = 0;
                                for(int j = 2; j< 7; j++) //we look for the 2 3 4 5 6 straight
                                {
                                    for(int k = 0; k < 5; k++)
                                    {
                                        if(ArrayOfDice[k] == j)
                                        {
                                            cpt++;
                                            break;
                                        }
                                    }
                                }
                                if(cpt == 5)
                                    return 40;
                                else return 0;

                            case 0 :
                                return 0;
                        }


            case 12:

                for (int e = 0; e < 5; e++) //we sum up every die
                {
                    sum += ArrayOfDice[e];

                }
                return sum;

            case 13:
                for (c = 1; c < 7; c++) //we check a Yahtzee for each value of die
                {counter = 0;
                    for (d = 0; d < 5; d++)  //we go through our hand
                    {
                        if (ArrayOfDice[d] == c)
                        {
                            counter++;
                        }

                        if (counter >= 5)
                        {

                            return  50;

                        }
                    }
                }
        }
    return 0;}

     static void Display(int player, int[] ArrayOfDice) { //a method that displays the current score after each throw


        System.out.println( Menu.player[player] + "'s current set of scores is : ");
        for (int x = 0; x < 6; x++) {
            if (UpperScore.tableScore[player][x] == -1) {
                System.out.println("                [" + (x + 1) + "]" + "   | ( " + UpperScore.Epitaph((x+1), ArrayOfDice) + " )");
            } else {
                System.out.println("                [" + (x + 1) + "]" + "   | " + UpperScore.tableScore[player][x]);
            }

        }

        for (int x = 6; x < 13; x++) {
            switch (x) {
                case 6:
                    if (UpperScore.tableScore[player][x] == -1) {
                        System.out.println("Three of a kind (7)   | ( " + UpperScore.Epitaph((x+1), ArrayOfDice) + " )");
                    } else {
                        System.out.println("Three of a kind (7)   | " + UpperScore.tableScore[player][x]);
                    }
                    break;

                case 7:
                    if (UpperScore.tableScore[player][x] == -1) {
                        System.out.println("Four of a kind  (8)   | ( " + UpperScore.Epitaph((x+1), ArrayOfDice) + " )");
                    } else {
                        System.out.println("Four of a kind  (8)   | " + UpperScore.tableScore[player][x]);
                    }
                    break;

                case 8:
                    if (UpperScore.tableScore[player][x] == -1) {
                        System.out.println("Full House      (9)   | ( " + UpperScore.Epitaph((x+1), ArrayOfDice) + " )");
                    } else {
                        System.out.println("Full House      (9)   | " + UpperScore.tableScore[player][x]);
                    }
                    break;

                case 9:
                    if (UpperScore.tableScore[player][x] == -1) {
                        System.out.println("Small Straight  (10)  | ( " + UpperScore.Epitaph((x+1), ArrayOfDice) + " )");
                    } else {
                        System.out.println("Small Straight  (10)  | " + UpperScore.tableScore[player][x]);
                    }
                    break;

                case 10:
                    if (UpperScore.tableScore[player][x] == -1) {
                        System.out.println("Large Straight  (11)  | ( " + UpperScore.Epitaph((x+1), ArrayOfDice) + " )");
                    } else {
                        System.out.println("Large Straight  (11)  | " + UpperScore.tableScore[player][x]);
                    }
                    break;

                case 11:
                    if (UpperScore.tableScore[player][x] == -1) {
                        System.out.println("Chance          (12)  | ( " + UpperScore.Epitaph((x+1), ArrayOfDice) + " )");
                    } else {
                        System.out.println("Chance          (12)  | " + UpperScore.tableScore[player][x]);
                    }
                    break;

                case 12:
                    if (UpperScore.tableScore[player][x] == -1) {
                        System.out.println("YAHTZEE         (13)  | ( " + UpperScore.Epitaph((x+1), ArrayOfDice) + " )");
                    } else {
                        System.out.println("YAHTZEE         (13)  | " + UpperScore.tableScore[player][x]);
                    }
                    break;
            }
        }


    }
}
