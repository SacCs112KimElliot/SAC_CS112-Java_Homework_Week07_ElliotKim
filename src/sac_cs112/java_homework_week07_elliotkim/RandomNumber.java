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

import java.util.Random;

public class RandomNumber 
{
    // public is access modifier making this class available to main class
    // int means that this class (method in other class) will return a value in int data type
    // GetANUmber..... is the name of the class given
    // () means no input is required to excute this method
    public int GetANumber(int lowNumber, int highNumber)
    {
        // an equation to create a random number is being implemented
        int randomNumber = lowNumber + (int) ( Math.random() * highNumber);
        // displaying the random number
        System.out.println("The random number is " + randomNumber);
        // After method is executed, randomNumber in int data type will be returned.
        return randomNumber;
    }
} 




