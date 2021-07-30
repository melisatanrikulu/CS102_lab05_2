/**
 * GallowsHangmanView
 * @author Melisa Tanrikulu
 * @version 26.07.2021
 */

import javax.swing.*;
import javax.swing.border.TitledBorder;
import cs102.*;
import java.awt.*;

public class GallowsHangmanView extends JPanel implements IHangmanView {
	
	// Instance Data Members
	private final static int X = 40;
	private final static int Y = 20;
	private Hangman hangman;
	
	private JLabel knownLabel;
	private JLabel usedLabel;
	private JLabel lostLabel;
	
	private String knownSoFar;
	private String usedLetters;
	private boolean hasLost;
	
	// Constructor
	
	/*
	 * GallowsHangmanView constructor
	 * @param hangman
	 */
	public GallowsHangmanView(Hangman hangman) {
		this.hangman = hangman;
		setBackground(Color.CYAN);		
		setPreferredSize( new Dimension(200, 300));
		
		// Gets the necessary values from the game
		knownSoFar = hangman.getKnownSoFar();
		usedLetters = hangman.getUsedLetters();
		hasLost = hangman.hasLost();
		
		// Creates label accordingly
		knownLabel = new JLabel(knownSoFar);
		usedLabel = new JLabel(usedLetters);
		lostLabel = new JLabel("");
		
		// Changes the labels' font
		knownLabel.setFont( new Font("Serif", 0, 25));
		usedLabel.setFont( new Font("Serif", Font.ITALIC, 20));
		lostLabel.setFont( new Font("Serif", 0, 25));

		// Adds the labels to the panel
		add(knownLabel);
		add(usedLabel);
		add(lostLabel);
	}

	@Override
	public void updateView(Hangman hangman) {
		
		// Gets the necessary values from the game
		knownSoFar = hangman.getKnownSoFar();
		usedLetters = hangman.getUsedLetters();
		
		// Updates the labels
		knownLabel.setText(knownSoFar);
		usedLabel.setText(usedLetters);		
		
		// Updates the lostLabel label
		if ( hangman.isGameOver() ) {
			if ( hangman.hasLost() )
				lostLabel.setText("You Lost");
			else
				lostLabel.setText("You Win!");
		}
		else
			lostLabel.setText("");
		
		
		this.repaint();
	}
	
	@Override
	public void paintComponent(Graphics g) {
		// Calls the super class' method
		super.paintComponent(g);
		
		// Changes the location of the labels and their colors
		knownLabel.setLocation(20, 200);
		
		usedLabel.setLocation(20, 230);
		usedLabel.setForeground(Color.BLUE);
		
		lostLabel.setLocation(57, 137);
		lostLabel.setForeground(Color.RED);
		
		int numOfIncorrectTries = hangman.getNumOfIncorrectTries();
		
		// Paints the diagram
		g.setColor(Color.BLACK);
		g.fillRect(X, Y, 60, 10);
		g.fillRect(X, Y, 10, 150);
		g.fillRect(10, 170, 150, 20);
		g.fillRect(95, 30, 3, 20);
		
		// Parts of the body are painted if the player guesses incorrectly
		if ( numOfIncorrectTries >= 1)
			// Head
			g.drawOval(80, 50, 30, 30);
		
		if ( numOfIncorrectTries >= 2)
			// Body
			g.drawLine(95, 80, 95, 110);
		
		if ( numOfIncorrectTries >= 3)
			// Rigth Leg
			g.drawLine(95, 110, 110, 140);
		
		if ( numOfIncorrectTries >= 4)
			// Left Leg
			g.drawLine(95, 110, 80, 140);
			
		if ( numOfIncorrectTries >= 5)
			// Right Arm
			g.drawLine(95, 90, 110, 95);
		
		if ( numOfIncorrectTries >= 6)
			// Left Arm
			g.drawLine(95, 90, 80, 95);
	}

}
