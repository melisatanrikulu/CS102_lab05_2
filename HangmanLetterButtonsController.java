/**
 * HangmanLetterButtonsController
 * @author Melisa Tanrikulu
 * @version 26.07.2021
 */

import java.awt.event.*;
import javax.swing.*;
import cs102.*;

public class HangmanLetterButtonsController implements ActionListener {
	// ýnstance Data Members
	private Hangman hangman;
	
	// Constructor
	
	/*
	 * HangmanLetterButtonsController constructor
	 * @param hangman
	 */
	public HangmanLetterButtonsController(Hangman hangman) {
		this.hangman = hangman;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// Obtains the button
		JButton source = (JButton) ( e.getSource() );
		
		// Obtains the letter in the button
		char letter = source.getText().charAt(0);	

		// Tries the letter
		hangman.tryThis(letter);
	}
}
