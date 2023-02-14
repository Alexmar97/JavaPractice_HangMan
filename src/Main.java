import java.sql.SQLOutput;
import java.util.Scanner;


public class Main
{

    public static String wordToGuess;
    //public static char [] wordToGuessArray;
    public static int dashesAmount;



    public static int correct = 0;
    public static int incorrect = 0;

    public static void main(String[] args)
    {

        int searchResult;

        //dashArray = new char[dashesAmount];

        Scanner input = new Scanner(System.in);

        char[] alphabet = {'a','b','c','d','e','f','g','h','i','j','k','l', 'm','n','o','p','q','r','s',
                't','u','v','w','x','y','z'};

        int guessCounter;

        int lives = 6;


        //Word to guess:

        System.out.println("What word would you like to guess? ");

        wordToGuess = input.nextLine();
        char []wordToGuessArray = wordToGuess.toCharArray();
        char[] lineDashes = dashes(wordToGuessArray);

        //System.out.println(lineDashes + " THIS IS LINE DASHES");

        char[] dashArray = new char[dashes(wordToGuessArray).length];

        for(int i = 0; i<wordToGuessArray.length; i++)
        {
            //System.out.print("_");
            dashArray[i] = '_';
            System.out.print(dashArray[i]);
        }

        //Guessing:

        while(incorrect < lives || correct != wordToGuessArray.length)
        {
            System.out.println("\n Enter a letter: ");
            System.out.println("Keep in mind, you have " + lives + " left");

            lines();

            String letterGuessed = input.next();
            char letterGuessedChar = letterGuessed.charAt(0);

                searchResult = search(wordToGuessArray, letterGuessedChar);

                if(searchResult == -1)
                {
                    incorrect++;
                    lives--;
                }

                else if (searchResult != -1)
                {
                    correct++;
                }

                updateDashes(wordToGuessArray, letterGuessedChar, dashArray);

            System.out.println("");

        }



    }


    public static void lines() {
        if (incorrect == 0)
        {
            System.out.println(" ---------");
            System.out.println("|        |");
            System.out.println("|");
            System.out.println("|");
        }

        else if (incorrect == 1) {
            System.out.println(" ---------");
            System.out.println("|        |");
            System.out.println("|        O");
            System.out.println("|");
        }

        else if (incorrect == 2)
        {
            System.out.println(" ---------");
            System.out.println("|        |");
            System.out.println("|        O");
            System.out.println("|        |");
            System.out.println("|");
        }

        else if (incorrect == 3)
        {
            System.out.println(" ---------");
            System.out.println("|        |");
            System.out.println("|        O");
            System.out.println("|       /|");
            System.out.println("|");
        }

        else if (incorrect == 4)
        {
            System.out.println(" ---------");
            System.out.println("|        |");
            System.out.println("|        O");
            System.out.println("|       /|\\");
            System.out.println("|");
        }

        else if (incorrect == 5)
        {
            System.out.println(" ---------");
            System.out.println("|        |");
            System.out.println("|        O");
            System.out.println("|       /|\\");
            System.out.println("|        |");
            System.out.println("|");
        }

        else if (incorrect == 6)
        {
            System.out.println(" ---------");
            System.out.println("|        |");
            System.out.println("|        O");
            System.out.println("|       /|\\");
            System.out.println("|        |");
            System.out.println("|       / \\");
            System.out.println("|");

            System.out.println("");

            System.out.println("GAME OVER");

            System.out.println("The correct word is: " + wordToGuess);
        }

    }


    public static int search (char[] wordToGuessArray, char attempt)
    {
        for (int i = 0; i<wordToGuessArray.length; i++)
        {
            if (attempt == wordToGuessArray[i])
            {
                correct++;
                return i;
            }
        }
        return -1;
    }


    public static char[] dashes(char[] wordToGuessArray)
    {
        //dashesAmount = wordToGuessArray.length;
        char dashArray[] = new char[wordToGuessArray.length];

        for(int i = 0; i<wordToGuessArray.length; i++)
        {
            //System.out.print("_");
            dashArray[i] = '_';
            //System.out.print(dashArray[i]);
        }
        return dashArray;
    }


    public static void updateDashes(char[] wordToGuessArray, char letterGuessedChar, char[] dashArray)
    {
        System.out.println("Array length: " + wordToGuessArray.length);

        for (int i = 0; i < wordToGuessArray.length; i++)
        {
            if (wordToGuessArray[i] == letterGuessedChar)
            {
                dashArray[i] = letterGuessedChar;
            }

            System.out.print(dashArray[i]);
        }

        System.out.println("");

    }


}
