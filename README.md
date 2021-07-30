# CS102_lab05_b

Lab05 - The Hangman Game GUI & MVC - Part2
This is the second half of the assignment...
please make sure you complete the other half first!

In this lab you will create a GUI version of the hangman game. Your solution will use the MVC (Model-View-Controller) design pattern. This pattern separates the core logic of the game (the model), from the way in which the user interacts with it--how the user views and controls it. There are literally hundreds of variations of this basic theme. This lab introduces you to one that is (hopefully) easy to understand, yet principled and extensible. This should allow you to write a simple program to begin with and later, with minimum changes/effort, adapt it to much more sophisticated situations.

Part (d)
We are now ready to start building the GUI version. We will do this step-by-step by creating a collection of components, including multiple views & controllers, which can be wired together as desired to produce something like this. 

Hangman Example GUI

We will use the GUIHangman project from now on, so make it the active project. 

Note: Download and extract the files into the src folder of the GUIHangman project (allow it to replace the GUIHangman.java file with the new one), then right-click on the src folder in JCreator, select add existing files, and include all the files there into the project.

Note: The download includes ConsoleHangmanView & Hangman model. You can use these or replace them with your own versions from the ConsoleHangman project.

Make sure the project compiles and runs before continuing. You may need to modify project settings to include the cs102 Hangman files again (see above).

Take a look at the source code of the GUIHangman. The main method creates an instance of itself. I doing so, it creates an instance of HangmanModel using BasicSetup, then adds an instance of ConsoleHangmanView to it, as before. It then creates a SimpleJFrame (which has nothing in it right now), and then calls ConsoleControl.controlFor(hangman). If you look at this method you will see it simply reads a char from the keyboard and calls hangman.tryThis, again, pretty much what you had before. Time now for the GUI...


Part (e)  - Adding controls.
We will first add some simple controls to the hangman game. First, create a new class, TextFieldControlPanel, which extends JPanel. Its constructor should take a reference to a Hangman object and simply store it in a property. The class should also have a TextField property, again initialised in the constructor. Add an ActionListener to the TextField. The event handler (the listener) should get the text from the TextField and, for each letter in it, call the Hangman (model) object's tryThis method. After processing all the letters it should clear the TextField.

In GUIHangman, create an instance of your new TextFieldControlPanel class (using HangmanModel) and add it to the "north" of the SimpleJFrame. Compile and run the project. You should now be able to type lots of letters into the TextField, press enter and they will be processed by the HangmanModel class, each time updating the ConsoleHangmanView. Of course, entering individual letters on the console still works too. Try adding another instance of TextFieldControlPanel  either to the "south" of the existing SimpleJFrame or to another instance of it.

Next, create another class, NewGameButtonControl. This time extend JButton. In the constructor, set the button's text to "New Game" and add an ActionListener which calls the HangmanModel's initNewgame() method. Add an instance of the NewGameButtonControl class to the "south" of your SimpleJFrame. Confirm that it does indeed start a new game (i.e. chooses a new secret word) each time it is pressed.

Part (f) - Adding views
It's now time to make some GUI views to replace the ConsoleHangmanView we have been using so far. Create a new class, LabelsHangmanView which extends JPanel and implements IHangmanView. It will need JLabel's for each item you wish to show, e.g. getNumOfIncorrectTries(), getKnownSoFar(), getUsedLetters() and hasLost(). You can adjust the layout, fonts, background colours, etc., to suit your taste. More important, however, is to make the updateView(Hangman) method, query the Hangman object for the required information and update the JLabel's accordingly.

Create a new instance of your LabelsHangmanView, add it to the HangmanModel as a view, and place it in the "west" of your SimpleJFrame. When you run the program it should now automatically update this view as well as showing the information on the console.

You should now be able to make a more conventional looking hangman game. Create a new class, GallowsHangmanView, which also extends JPanel and implements IHangmanView. This time, however, you should override the JPanel's paintComponent( Graphics) method to display the gallows and the hanging man, based on the state of the HangmanModel--you can also include other information, e.g getKnownSoFar() and getUsedLetters() if you want. For this to work, your class will need to maintain a reference to the HangmanModel as a property, initialised via the constructor or set in the updateView method. The updateView method will normally simply tell the view to repaint() itself.

Create an instance of your GallowsHangmanView class, add it to the hangman model as a view, and place it in the center of the SimpleJFrame. Run the program and confirm it too shows the progress of the game.

Part (g) - Controls which are also views!
You may have noticed that the new game button is always enabled, allowing the user to abandon the current game and start a new one whenever they wish. While this may be acceptable, one might want to keep the button disabled by default, enabling only after the current game has been properly completed. Doing this requires the button know the state of the game. The simplest way to do this is to make the control a view too, in other words, have the NewGameButtonControl implement IHangmanView too. Disable the button in its ActionListener, but in the updateView method if the game is over, re-enable it. Do these modifications and confirm the desired behaviour.

Finally, take a look at the LetterButtonControls class included in the project. This provides a simple virtual keyboard that can be used in lots of applications. Create an instance of it by passing it the letters you want to appear on the keys (obtained from the getAllLetters() method of the hangman object), and the number of rows and columns of buttons that you want (for example, try 13 & 2 to get a vertically oriented virtual keyboard for the 26 English letters). You can add it to the "east" of the SimpleJFrame, however, to have it work properly you will need to write an ActionListener and add it to the LetterButtonControls. This listener class, HangmanLetterButtonsController say, should maintain a reference to the hangman object. In the actionPerformed method it should get the letter of the key that was pressed and pass it to the tryThis method of the hangman object, then disable the button (hint, use the event source). Confirm that you can play the game using this keyboard.

There is one minor problem with this; if the user enters letters using the TextFieldControlPanel, the corresponding buttons on the LetterButtonControls are not disabled. This won't affect the logic of the game (entering the same letter again doesn't change anything), however, it is not very aesthetic. The difficulty only occurs when there are multiple controls some of which keep state. The solution is, again, to make the control a view too. Whilst you could modify the LetterButtonControls class, since these changes are specific to the Hangman class, it is probably best to leave it alone and make the necessary changes by sub-classing it. So, create HangmanLetterButtonControls which extends LetterButtonControls and implements IHangmanView. In the updateView method call the setEnabledAll & setDisabled( letters) appropriately (hint, use the hangman getUsedLetters() method).
