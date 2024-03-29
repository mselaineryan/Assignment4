/*
 * File: Hangman.java
 * ------------------
 * This program will eventually play the Hangman game from
 * Assignment #4.
 */

import acm.graphics.*;
import acm.program.*;
import acm.util.*;
import java.io.*;

import java.awt.*;

public class Hangman extends ConsoleProgram {

    public void run() {
		/* You fill this in */
    	
    	println ("Welcome to Hangman");
    	
    		guessWord ();
    		//drawHangMan();
    		//winOrLoseMessage();
    	
	}
    
    private void guessWord () {
    	
    	
    	String secretWord = selectRandomWord ();
    	println ("The word now looks like this: " + printDashes(secretWord));
    	println ("You have " + TURNS + " guesses left.");
    
    	
    	firstGuess (secretWord);
    	
    	
    	
    	
    }
    
   
    
    
    private void firstGuess (String secretWord) {
    	String result = printDashes (secretWord);
    		while (TURNS > 0) {
        		String guess = readLine ("Your guess: ");
        		guess = guess.toUpperCase();
    			

        	
        		for (int i = 0; i < secretWord.length(); i++) {
        		
        			char ch = guess.charAt(0);
        			
        			int pos = secretWord.indexOf(ch);
        		
        			
        			if (ch == secretWord.charAt(i)) {
        				
        				result = result.substring(0,pos) + ch + result.substring((pos+1));
        				
        				println (result);
        			}
        		
        		}
        	
        	
        		
        			for (int i = 0; i < result.length(); i++) {
        				char ch = result.charAt(i);
        				if (Character.isLetter(ch)) {
        					println ("That letter is correct.");
        					break;
        				} 
        			
        		
        			}
        		
        			if (secretWord.indexOf (guess) == -1) {
        				println ("There are no " + guess + "'s in the word.");
        				TURNS -= 1;
        			
        			}
        	
        	
        	
        		
        			println ("The word now looks like this:" + result);	
        			println ("You have " + TURNS + " guesses left");
        	
        			
        	
        	
        	
        		}
        	
    	
    }
    
   private String printDashes (String secretWord) {
	   
	   String dashes = "";
	   
	   for (int i = 0; i < secretWord.length(); i++) {
		   dashes += "-";
	   }
	   return dashes;
   }
   
    
   private String selectRandomWord () {
	   
	   String secretWord = HangmanWords.getWord(rgen.nextInt (0, HangmanWords.getWordCount ()-1));
	   //test
	   println (secretWord);
	   return secretWord;
	   
	   
   }
   
   private BufferedReader openFile (String filename) {
	   
	   BufferedReader rd = null;
	   while (rd == null) {
		   try {
			   rd = new BufferedReader (new FileReader (filename));
		   } catch (IOException ex) {
			   println ("file doesn't exist");
		   }
		   
		   
		   
	   }
	   return rd;
   }
   
    private HangmanLexicon HangmanWords = new HangmanLexicon ();
    private RandomGenerator rgen = RandomGenerator.getInstance ();
    private static int TURNS = 8;
}
