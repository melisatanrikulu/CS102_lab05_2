/**
 * TextFieldControlPanel
 * @author Melisa Tanrikulu
 * @version 26.07.2021
 */

import cs102.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class TextFieldControlPanel extends JPanel {
	
	// Instance Data Members
	private final static int FIELD_WIDTH = 20;
	
	private HangmanModel hangman;
	private JTextField textField;
	
	// Constructor

	/*
	 * TextFieldControlPanel constructor.
	 * @param hangman
	 */
	public TextFieldControlPanel(HangmanModel hangman) {
		this.hangman = hangman;
		textField = new JTextField(FIELD_WIDTH);
		
		// Adds a listener to the text field
		ActionListener listener = new FieldListener();
		textField.addActionListener(listener);
		
		// Adds the field to the panel
		add(textField);
		
	}
	
	/*
	 * ActionListener class
	 */
	class FieldListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// Variables
			String text = textField.getText();
			int length = text.length();
			
			// Tries each character in the text field
			for ( int index = 0; index < length; index++ )  {
				hangman.tryThis(text.charAt(index));
			}
			
			// Deletes all the text in the field
			textField.setText("");
		}
	}
}
