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
    	guessWord ();
    	//drawHangMan();
    	//winOrLoseMessage();
    	
	}
    
    private void guessWord () {
    	
    	println ("Welcome to Hangman");
    	String secretWord = selectRandomWord ();
    	println ("The word now looks like this: " + printDashes(secretWord));
    	
    	
    	// print out row of dashes, one for each letter
    	// prompt user to guess letter
    	// fill in letter or display incorrect guess
    	// keep track of guess, more than 8 incorrect guess = lose, guess word before 8 incorrect = win
    	
    }
    
   private String printDashes (String secretWord) {
	   
	   String dashes = "";
	   
	   for (int i = 0; i < secretWord.length(); i++) {
		   dashes += "- ";
	   }
	   return dashes;
   }
   
    
   private String selectRandomWord () {
	   
	   String secretWord = HangmanWords.getWord(rgen.nextInt (0, HangmanWords.getWordCount ()-1));
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
}
