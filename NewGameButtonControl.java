/**
 * NewGameButtonControl
 * @author Melisa Tanrikulu
 * @version 26.07.2021
 */

import javax.swing.*;
import cs102.*;
import java.awt.event.*;

public class NewGameButtonControl extends JButton implements IHangmanView {
	// Instance Data Members
	private HangmanModel hangman;
	
	// Constructor
	
	/*
	 * NewGameButtonControl constructor
	 * @param hangman
	 */
	public NewGameButtonControl(HangmanModel hangman) {
		this.hangman = hangman;
		this.setText("New Game");
		
		// Disenables the button initially
		this.setEnabled(false);
		
		// Adds a listener to the button
		ActionListener listener = new ButtonListener();
		this.addActionListener(listener);
	}
	
	/*
	 * ActionListener
	 */
	class ButtonListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// If the new game button is clicked, disenables the button and initializes a new game
			( (JButton) e.getSource() ).setEnabled(false);
			hangman.initNewGame();
		}
	}
	
	@Override
	public void updateView(Hangman hangman) {
		// If the game is over, enables the button
		if ( hangman.isGameOver() )
			this.setEnabled(true);
		
		this.repaint();
	}

}
