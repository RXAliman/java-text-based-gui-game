package package01;


// This class will handle what is to be shown on the screen

public class VisibilityManager
{
	UI ui;
	
	public VisibilityManager(UI uiObject)
	{
		ui = uiObject;
	}
	
	public void showTitleScreen()
	{
		// Show Title Screen components
		ui.titleNamePanel.setVisible(true);
		ui.startButtonPanel.setVisible(true);
		
		// Hide Game Screen components
		ui.playerPanel.setVisible(false);
		ui.mainTextPanel.setVisible(false);
		ui.choiceButtonPanel.setVisible(false);
		
		// Render all components properly to the window
		ui.window.setVisible(true);
	}
	
	public void titleToTown()
	{
		// Hide Title Screen components
		ui.titleNamePanel.setVisible(false);
		ui.startButtonPanel.setVisible(false);
		
		// Show Game Screen components
		ui.playerPanel.setVisible(true);
		ui.mainTextPanel.setVisible(true);
		ui.choiceButtonPanel.setVisible(true);
		
		// Render all components properly to the window
		ui.window.setVisible(true);
	}
	
	public void hideEmptyButtons()
	{		
		ui.choice2.setVisible((ui.choice2.getText().isBlank() ? false : true));
		ui.choice3.setVisible((ui.choice3.getText().isBlank() ? false : true));
		ui.choice4.setVisible((ui.choice4.getText().isBlank() ? false : true));
	}
}
