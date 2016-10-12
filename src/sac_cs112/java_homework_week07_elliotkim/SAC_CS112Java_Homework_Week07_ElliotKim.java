/*
 * SAC_CS112-Java_Homework_Week07_ElliotKim
 * Objective:   Implement an Odd/Even game using objects
 *		Design objects using UML before implementation
 *		Make sure to include constructor
 *		Optional
 *			Display game summary using example in section 5.10 as guide
 * https://github.com/SacCs112KimElliot/SAC_CS112-Java_Homework_Week07_ElliotKim.git
 */
package sac_cs112.java_homework_week07_elliotkim;

import java.util.Scanner;
import javax.swing.JOptionPane;

public class SAC_CS112Java_Homework_Week07_ElliotKim 
{
       public static void main(String[] args) 
    {
        // Introduce the game to user
        JOptionPane.showMessageDialog( null, "Let's play Guess-A-Dice game");
                    
        // Making arrays to store values
        //      [0]First array is to count total number of games user played
        //      [1]Second array is to store whether the random number generated is odd number
        //      [2]Third array is to count total number of user's odd guess
        //      [3]Fourth array is to count total number of user's good guess
        //      [4]Fifth array is to store user's decision on playing the game again or not
        int [] ArraysToHoldValues = new int [5];
        ArraysToHoldValues[0] = 0;
        ArraysToHoldValues[1] = 0;
        ArraysToHoldValues[2] = 0;
        ArraysToHoldValues[3] = 0;
        ArraysToHoldValues[4] = 1;
        
        // Prompt user to throw the dice
        JOptionPane.showMessageDialog( null, "Why don't we start the game?\nPlease press OK button to throw the dice.");
        
        do
        {
            // Generate a random number 
            //int RandomNumber = 1; 
            //RandomNumber = 1 + (int) ( Math.random() * 6);
            //System.out.println("\nRandom number generated is " + RandomNumber);
            
            //RandomNumber getANumber = new RandomNumber(highNumber);
            RandomNumber randomNumberFromOtherClass = new RandomNumber();
            int randomNumber;
            int lowNumber = 1;
            int highNumber = 10;
            randomNumber = randomNumberFromOtherClass.GetANumber(lowNumber,highNumber);
            
            // Prompt user to guess whether the dice thrown is odd or even number
            String UserGuessStr =
                    JOptionPane.showInputDialog("Can you guess whether the dice thrown is in odd or even number?"
                            + "\nPress 1 for odd number or\nPress 2 for even number");
            // Convert string input to integer
            int UserGuess1or2 = Integer.parseInt(UserGuessStr); 
            // Put a filter to accept only valid value from a user between number 1 or 2
            //      Keep asking a user to provide correct input between 1 or 2.       
            while (UserGuess1or2>2||UserGuess1or2<0)
            {
                UserGuessStr =
                    JOptionPane.showInputDialog("Invalid input.\nYour guess must be either 1 or 2\nPress 1 for guessing odd or\nPress 2 for guessing even:");
                UserGuess1or2 = Integer.parseInt(UserGuessStr);
            }
            System.out.println("User's guess after the while loop is " + UserGuess1or2);
            
            // Count odd guess
            ArraysToHoldValues[2] = (UserGuess1or2 == 1)?(ArraysToHoldValues[2]+1):ArraysToHoldValues[2];
            System.out.println("Total number of odd guess is " + ArraysToHoldValues[2]);
            
            // Is the random number odd or even number?
            //      If result of RandomNumber%2 is 1, then the random number is odd number.
            //      If RnadomNumber is odd, then 1 will be given.
            
            ArraysToHoldValues[1] = ((randomNumber%2)==1)?1:2;
            System.out.println("The random number's remainer by 2 is " + ArraysToHoldValues[1]);
            
            // Let the user know of the result
            if (ArraysToHoldValues[1] == UserGuess1or2)
            {
                JOptionPane.showMessageDialog( null, "Wow! You won it.");
                // count how many right guess the user made
                ArraysToHoldValues[3] = ArraysToHoldValues[3] + 1;
            }
            else
            {
                JOptionPane.showMessageDialog( null, "Sorry. You lost it.");
            }
            // counter total number of games played
            ArraysToHoldValues[0] = ArraysToHoldValues[0] + 1;
            
            int [] GameStatus = {ArraysToHoldValues[0],ArraysToHoldValues[3],ArraysToHoldValues[2]};
            
            // Get user a game statistic and ask whether wants to play again.
            String PlayAgainStr =
                JOptionPane.showInputDialog("Game Statistic is as follwing:\n"
                        + "Number of games you played is " + ArraysToHoldValues[0]
                        + ".\nNumber of guess you claimed odd is " + ArraysToHoldValues[2]
                        + ".\nNumber of guess you claimed even is " + (ArraysToHoldValues[0]-ArraysToHoldValues[2]) 
                        + ".\nRate of right guess is %" + (float)ArraysToHoldValues[3]/ArraysToHoldValues[0]*100
                        + ".\n\nHey, do you want to play it again?\nPress 1 to play again \nor press 2 to quie:");
            ArraysToHoldValues[4] = Integer.parseInt(PlayAgainStr);  
        }
        while (ArraysToHoldValues[4] == 1);
        
        JOptionPane.showMessageDialog( null, "Good Bye");
    } 
}

// Good job, Elliot.
// Regarding array, please consider using 5 different arrays. Declare an int variable to track the round number.  Use this int as the index to the arrays.

