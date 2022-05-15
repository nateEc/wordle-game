/*
 * Wordle.java 
 * 
 * An console-based implementation of a popular word-guessing game
 * 
 * starter code: Computer Science 112 staff (cs112-staff@cs.bu.edu)
 *
 * completed by: 
 */

import java.util.*;

public class Wordle {
    // the name of a file containing a collection of English words, one word per line
    public static final String WORD_FILE = "words.txt";

    /*
     * printWelcome - prints the message that greets the user at the beginning of the game
     */  
    public static void printWelcome() {
        System.out.println();   
        System.out.println("Welcome to Wordle!");
        System.out.println("The mystery word is a 5-letter English word.");
        System.out.println("You have 6 chances to guess it.");
        System.out.println();
    }
    
    /*
     * initWordList - creates the WordList object that will be used to select
     * the mystery work. Takes the array of strings passed into main(),
     * since that array may contain a random seed specified by the user 
     * from the command line.
     */
    public static WordList initWordList(String[] args) {
        int seed = -1;
        if (args.length > 0) {
            seed = Integer.parseInt(args[0]);
        }

        return new WordList(WORD_FILE, seed);
    }

    /*
     * readGuess - reads a single guess from the user and returns it
     * inputs:
     *   guessNum - the number of the guess (1, 2, ..., 6) that is being read
     *   console - the Scanner object that will be used to get the user's inputs
     */
    public static String readGuess(int guessNum, Scanner console) {
        String guess;
        do {
            System.out.print("guess " + guessNum + ": ");
            guess = console.next();
        } while (! isValidGuess(guess));

        return guess.toLowerCase();
    }

    /**** ADD YOUR METHODS FOR TASK 1 HERE ****/
     
     public static boolean includes(String s, char c){
         /* Includes - takes two parameters: an arbitrary String 
          * object s followed by a single char c. The method should
          * return the boolean literal true if c is found somewhere
          * in s, and it should return the boolean literal false 
          * otherwise.
         */
         return s.contains(c + "");
     }

    public static boolean isAlpha(String s) {
        /* returns true if all of the characters in s are
         * in the alphabet, false otherwise
         */
        boolean result = true;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (! Character.isAlphabetic(c)) {
                result = false;
            }
        }
        return result;
    }

    public static int numOccur(char c, String s){
        /* count and return the number of times 
         * that c occurs in s.
         */
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == c)
            result += 1;
        }
        return result;
    }

    public static int numInSamePosn(char c, String s1, String s2){
    /* takes three parameters: a single char c followed by two 
     *  String objects s1 and s2 that you may assume have the same 
     * length. The method should count and return the number of times 
     * that c occurs in the same position in both s1 and s2. 
     */
    
    int result = 0;
    for (int i = 0; i < s1.length(); i++) {
        if (s1.charAt(i) == c && c == s2.charAt(i)) {
            result += 1;
        }
    }
    return result;
    }
    
    
    
    /*
     * TASK 2: Implement this method
     * 
     * isValidGuess -  takes an arbitrary string guess and returns true
     * if it is a valid guess for Wordle, and false otherwise
     */
    public static boolean isValidGuess(String guess) {
        boolean result = false;
        if (guess.length() == 5 && isAlpha(guess)) {
            result = true;
        }else if(guess.length() != 5){
            System.out.println("Your guess must be 5 letters long. ");
        }else if(guess.length() == 5 && ! isAlpha(guess)){
            System.out.println("Your guess must only contain letters of the alphabet. ");
        }
        return result;
    }

    /**** ADD YOUR METHOD FOR TASKS 3 and 5 HERE. ****/
    public static boolean processGuess(String guess, String mystery){
        String result = "";
        boolean returnval = true;
        for (int i = 0; i < guess.length(); i++) {
            int test = numOccur(guess.charAt(i), mystery.substring(i));
            if (guess.charAt(i) == mystery.charAt(i)){
                result += guess.charAt(i);
                result += " ";
            }else if(includes(mystery, guess.charAt(i))){
                if (numOccur(guess.charAt(i), guess) > numOccur(guess.charAt(i), mystery)){
                    if (numInSamePosn(guess.charAt(i), guess, mystery) == 0 && test != 0){
                        result += "[" + guess.charAt(i) + "]";
                        result += " ";
                        returnval = false;
                        test --;
                    }else{
                    result += "_";
                    result += " ";
                    }
                }else{
                result += "[" + guess.charAt(i) + "]";
                result += " ";
                returnval = false;}
            }else{
                result += "_";
                result += " ";
                returnval = false;
            }
        }
        System.out.println(result);
        return returnval;
    }
    
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        
        printWelcome();

        // Create the WordList object for the collection of possible words.
        WordList words= initWordList(args);

        // Choose one of the words as the mystery word.
        String mystery = words.getRandomWord();
        
        /*** TASK 4: Implement the rest of the main method below. ***/
        int i;
        for (i = 0; i < 6; i++) {
            if (processGuess(readGuess(i+1, console), mystery)) {
                System.out.println("Congrats! You guessed it!");
                break;
            }
        }
        if (i == 6){
            System.out.println("Sorry! Better luck next time!");
            System.out.println("The word was " + mystery + ".");
        }

        console.close();
    }
}