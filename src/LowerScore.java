public class LowerScore {

    public static boolean TwoOfAKind(int[] ArrayOfDice,int trio)
    {
        for(int i=1; i < 7; i++)
        {
            int counter = 0;
            for (int c = 0; c<5; c++) //we go through our hand
            {
                if (ArrayOfDice[c] == i && i != trio)
                {
                    counter++;
                }
            }
            if (counter == 2)
            {
                return true;
            }
        }
        return false;
    }

    public static void ThreeOfAKind(int[] ArrayOfDice, int choose)
    {
        int c, counter, d, sum = 0;
        for (c = 1; c < 7; c++) //we check a 3oak for each value of die
        {counter = 0;
            for (d = 0; d < 5; d++)  //we go through our hand
            {
                if (ArrayOfDice[d] == c)
                {
                    counter++;
                }

                if (counter >= 3)
                {
                    //three of a kind
                    System.out.println("this is a three of a kind\n");
                    Chance(ArrayOfDice,choose);
                    counter=0; //anti loop measure
                }
            }
        }
        if (UpperScore.tableScore[choose - 1] == -1) {
            UpperScore.tableScore[choose - 1] = 0;
        }
    }

    public static void FourOfAKind(int[] ArrayOfDice, int choose)
    {
        int c, counter, d, sum = 0;
        for (c = 1; c < 7; c++) //we check a 3oak for each value of die
        {counter = 0;
            for (d = 0; d < 5; d++)  //we go through our hand
            {
                if (ArrayOfDice[d] == c)
                {
                    counter++;
                }

                if (counter >= 4)
                {
                    //four of a kind
                    System.out.println("this is a four of a kind\n");
                    Chance(ArrayOfDice,choose);
                    counter=0; //anti loop measure
                }
            }
        }
        if (UpperScore.tableScore[choose - 1] == -1) {
            UpperScore.tableScore[choose - 1] = 0;
        }
    }

    public static void Yahtzee(int[] ArrayOfDice, int choose)
    {
        int c, counter, d;
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

                    UpperScore.tableScore[choose - 1] = 50;
                    counter=0; //anti loop measure
                }
            }
        }
        if (UpperScore.tableScore[choose - 1] == -1) {
            UpperScore.tableScore[choose - 1] = 0;
        }
    }

    public static void FullHouse(int[] ArrayOfDice, int choose)
    {
        int c, counter, d, sum = 0, trio = 0;
        for (c = 1; c < 7; c++) //we check a 3oak for each value of die
        {
            counter = 0;
            for (d = 0; d < 5; d++)  //we go through our hand
            {
                if (ArrayOfDice[d] == c)
                {
                    counter++;
                }

                if (counter >= 3)
                {
                    //three of a kind
                    System.out.println("this is a three of a kind\n");
                    trio = c;
                    boolean pair = TwoOfAKind(ArrayOfDice, trio);
                    if (pair)
                    {
                        UpperScore.tableScore[choose - 1] = 25;
                    }
                    counter=0; //anti loop measure
                }
            }
        }
        if (UpperScore.tableScore[choose - 1] == -1) {
            UpperScore.tableScore[choose - 1] = 0;
        }
    }

    public static void Chance(int[] ArrayOfDice, int choose)
    {
        int sum = 0;
        for (int e = 0; e < 5; e++) //we sum up every die
        {
            sum += ArrayOfDice[e];
            System.out.println("value of sum " + sum + "\n");
        }
        UpperScore.tableScore[choose - 1] = sum;
    }

    public static void SmallStraight(int[] ArrayOfDice, int choose)
    {
        int sentinel = 0, cpt = 0;
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

        switch(sentinel){
            case 0:
                UpperScore.tableScore[choose - 1] = 0;
                break;

            case 1:

                for (int i = 3; i<7; i++)
                {
                    for (int j = 0; j < 5; j++)
                    {
                        if(ArrayOfDice[j] == i)
                        {
                            cpt++;
                            break;
                        }
                    }
                }
                if(cpt == 4)
                    UpperScore.tableScore[choose - 1] = 30;
                else UpperScore.tableScore[choose-1] = 0;
                break;

            case 2:
                for (int i = 2; i<6; i++)
                {
                    for (int j = 0; j < 5; j++)
                    {
                        if(ArrayOfDice[j] == i)
                        {
                            cpt++;
                            break;
                        }
                    }
                }
                if(cpt == 4)
                    UpperScore.tableScore[choose - 1] = 30;
                else UpperScore.tableScore[choose-1] = 0;
                break;

            case 3:
                for (int i = 1; i<5; i++)
                {
                    for (int j = 0; j < 5; j++)
                    {
                        if(ArrayOfDice[j] == i)
                        {
                            cpt++;
                            break;
                        }
                    }
                }
                if(cpt == 4)
                    UpperScore.tableScore[choose - 1] = 30;
                else UpperScore.tableScore[choose-1] = 0;
                break;
        }
    }

    public static void LargeStraight(int[] ArrayOfDice, int choose)
    {
        int sentinel = 0;
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
                int cpt = 0;
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
    UpperScore.tableScore[choose - 1] = 40;
                else UpperScore.tableScore[choose-1] = 0;
                break;
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
                    UpperScore.tableScore[choose - 1] = 40;
                else UpperScore.tableScore[choose-1] = 0;
                break;
            case 0 :
                UpperScore.tableScore[choose - 1] = 0;
        }
    }

    public static void Lower(int[] ArrayOfDice, int choose) {

        switch (choose) {
            case 7:
                ThreeOfAKind(ArrayOfDice, choose);
                break;
            case 8:
                FourOfAKind(ArrayOfDice, choose);
                break;
            case 9:
                FullHouse(ArrayOfDice,choose);
                break;
            case 10:
                SmallStraight(ArrayOfDice, choose);
                break;
            case 11 :
                LargeStraight(ArrayOfDice,choose);
                break;
            case 12 :
                Chance(ArrayOfDice,choose);
                break;
            case 13 :
                Yahtzee(ArrayOfDice,choose);
                break;
        }
    }
}
