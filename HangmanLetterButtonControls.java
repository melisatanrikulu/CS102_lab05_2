/**
 * HangmanLetterButtonControls
 * @author Melisa Tanrikulu
 * @version 26.07.2021
 */

import cs102.*;
	
public class HangmanLetterButtonControls extends LetterButtonControls implements IHangmanView {
	private String usedLetters;
	
	// Constructor
	
	/*
	 * HangmanLetterButtonControls constructor
	 * @param letters, row count, column count
	 */
	public HangmanLetterButtonControls(String letters, int rows, int cols) {
		// Calls the super class
		super(letters, rows, cols);
	}
	
	@Override
	public void updateView(Hangman hangman) {
		// Obtains the used letters
		usedLetters = hangman.getUsedLetters();
		
		// First enables all the letter (necessary when a new game is initialized)
		this.setEnabledAll(true);
		
		// Then disenables all the used letters
		this.setDisabled(usedLetters);
		
		repaint();
	}
}
