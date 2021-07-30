import java.awt.*;
import cs102.*;

/**
 * GUIHangman - GUI based MVC test for cs102 Hangman & IHangmanSetup
 *
 * @author David
 * @version 1.00 2013/4/7
 */

public class GUIHangman
{
	public GUIHangman()
	{
    	System.out.println( "Start of GUIHangman\n");

		HangmanModel						hangman;
		IHangmanSetup						basicSetup;
		TextFieldControlPanel				textControl;
		NewGameButtonControl				buttonControl;
		LabelsHangmanView					consoleView;
		GallowsHangmanView					gameView;
		HangmanLetterButtonControls			buttons;
		HangmanLetterButtonsController 		listener;

		basicSetup = new BasicSetup();
		hangman = new HangmanModel( basicSetup);
		textControl = new TextFieldControlPanel(hangman);
		buttonControl = new NewGameButtonControl(hangman);
		buttons = new HangmanLetterButtonControls(hangman.getAllLetters(), 13, 2);
		listener = new HangmanLetterButtonsController(hangman);
		consoleView = new LabelsHangmanView(hangman);
		gameView = new GallowsHangmanView(hangman);
		
		buttons.addActionListener(listener);
		hangman.addView( consoleView);
		hangman.addView( gameView );
		hangman.addView( buttonControl );
		hangman.addView( buttons );

		new SimpleJFrame( "GUIHangman", 	// title
							gameView,		// center
							textControl, buttonControl,		// north, south
							buttons, consoleView );	// east, west
	}

	public static void main( String[] args)
	{
		new GUIHangman();

//		// This is the approved way to initialise GUIs
//		// but won't work with the ConsoleControl as is!
//		// --------------------------------------------
//		SwingUtilities.invokeLater(
//			new Runnable() {
//			    public void run() {
//	        		new GUIHangman();
//	        		new GUIHangman();
//	    		}
//			});
	}

} // end of class GUIHangman
