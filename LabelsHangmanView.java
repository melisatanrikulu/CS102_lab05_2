/**
 * LabelsHangmanView
 * @author Melisa Tanrikulu
 * @version 26.07.2021
 */

import javax.swing.*;
import cs102.*;
import java.awt.*;

public class LabelsHangmanView extends JPanel implements IHangmanView {
	
	// Instance Data Members
	private JLabel triesLabel;
	private JLabel knownLabel;
	private JLabel usedLabel;
	private JLabel lostLabel;
	
	private int numOfIncorrectTries;
	private String knownSoFar;
	private String usedLetters;
	private boolean hasLost;
	
	// Constructor
	
	/*
	 * LabelsHangmanView constructor
	 * @param hangman
	 */
	public LabelsHangmanView(Hangman hangman) {
		this.setLayout( new GridLayout(8, 1) );
		setPreferredSize( new Dimension(225, 300) );
		this.setBackground(Color.GREEN);
		this.setVisible(true);
		
		// Gets the necessary values from the game
		numOfIncorrectTries = hangman.getNumOfIncorrectTries();
		knownSoFar = hangman.getKnownSoFar();
		usedLetters = hangman.getUsedLetters();
		hasLost = hangman.hasLost();
		
		// Creates label accordingly
		triesLabel = new JLabel("" + numOfIncorrectTries);
		knownLabel = new JLabel(knownSoFar);
		usedLabel = new JLabel(usedLetters);
		lostLabel = new JLabel("");
				
		// Changes the labels' font
		Font font = new Font("Serif", 0, 25);
		
		triesLabel.setFont(font);
		knownLabel.setFont(font);
		usedLabel.setFont(font);
		lostLabel.setFont(font);
		
		// Aligns the labels to center
		triesLabel.setHorizontalAlignment(JLabel.CENTER);
		knownLabel.setHorizontalAlignment(JLabel.CENTER);
		usedLabel.setHorizontalAlignment(JLabel.CENTER);
		lostLabel.setHorizontalAlignment(JLabel.CENTER);
		
		// Adds the labels to the panel
		add(knownLabel);		
		add(triesLabel);
		add(usedLabel);
		add(lostLabel);
	}
	
	@Override
	public void updateView(Hangman hangman) {
		// Gets the necessary values from the game
		numOfIncorrectTries = hangman.getNumOfIncorrectTries();
		knownSoFar = hangman.getKnownSoFar();
		usedLetters = hangman.getUsedLetters();
		hasLost = hangman.hasLost();
		
		// Updates the labels
		triesLabel.setText("" + numOfIncorrectTries);
		knownLabel.setText(knownSoFar);
		usedLabel.setText(usedLetters);
		
		// Updates the lostLabel label
		if (hangman.isGameOver()) {
			if ( hasLost )
				lostLabel.setText("LOST");
			else
				lostLabel.setText("WON");
		}
		else
			lostLabel.setText("");
		
		this.repaint();
	}

}
