/*
 * Tester.java 
 * 
 * A program that you can use to make test calls to the methods that you 
 * write as part of your Wordle implementation. 
 */

import java.util.*;

public class Tester {
    public static void main(String[] args) {
        //Scanner console = new Scanner(System.in);

        // sample test for the includes method
        //System.out.println("\nTesting includes method...");
        //boolean result = Wordle.includes("hello", 'e');
        //System.out.println("includes(\"hello\", 'e') returns " + result);

        // Add additional tests below to ensure that your methods
        // work correctly.

        

        // Test for isAlpha static method.
       
        //boolean result2 = Wordle.isAlpha("hello");
        //System.out.println("isAlpha(\"hello\") returns " + result2);

        // Test for numOccur static method.
        
        //int result3 = Wordle.numOccur('x', "hello");
        //System.out.println("numOccur('x',\"hello\") returns " + result3);

        // Test for numInSamePosn static method.
        
        //int result4 = Wordle.numInSamePosn('p', "apple", "maple");
        //System.out.println("numInSamePosn('p',\"apple\", \"maple\") returns " + result4);

        // Test for isValidGuess static method.
       
        //System.out.print("Guess 1: ");
        //String guessUser = console.next();
        //boolean result5 = Wordle.isValidGuess(guessUser);
        //System.out.println(guessUser + " is a valid guess: " + result5);

        // test for processGuest static method
        System.out.println(Wordle.processGuess("daddy", "undid"));
    }
}
