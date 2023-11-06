package package01;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import package01.Game.ChoiceHandler;


// This class initialize all Java components needed

public class UI
{
	// Window
	JFrame window;
	// Title Screen components
	JPanel titleNamePanel, startButtonPanel;
	JLabel titleNameLabel;
	JButton startButton;
	JTextArea mainTextArea;
	// Game Screen components
	JPanel mainTextPanel, choiceButtonPanel, playerPanel;
	JLabel hpLabel, hpNumberLabel, weaponLabel, weaponNameLabel;
	JButton choice1, choice2, choice3, choice4;
	// Font
	Font titleFont = new Font("Times New Roman",Font.PLAIN,90);
	Font normalFont = new Font("Times New Roman",Font.PLAIN,26);
	
	public void createUI(ChoiceHandler choiceHandlerObject)
	{
		// Initialize Java window
		window = new JFrame();
		window.setSize(800,600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.black);
		window.setLayout(null);
		window.setResizable(false);
		
		// Title Screen
		titleNamePanel = new JPanel();
		titleNamePanel.setBounds(100,100,600,500);
		titleNamePanel.setBackground(Color.black);
		titleNameLabel = new JLabel("ADVENTURE");
		titleNameLabel.setForeground(Color.white);
		titleNameLabel.setFont(titleFont);
		titleNamePanel.add(titleNameLabel);
		
		// Start Button
		startButtonPanel = new JPanel();
		startButtonPanel.setBounds(300,400,200,100);
		startButtonPanel.setBackground(Color.black);
		startButton = new JButton("START");
		startButton.setBackground(Color.black);
		startButton.setForeground(Color.white);
		startButton.setFont(normalFont);
		startButton.setFocusPainted(false);
		startButton.addActionListener(choiceHandlerObject);
		startButton.setActionCommand("start");
		startButtonPanel.add(startButton);
		
		// Add Title Screen components to window
		window.add(titleNamePanel);
		window.add(startButtonPanel);
		
		// Game Screen
		mainTextPanel = new JPanel();
		mainTextPanel.setBounds(100,100,600,250);
		mainTextPanel.setBackground(Color.black);
		
		mainTextArea = new JTextArea("This is the main text area");
		mainTextArea.setBounds(100,100,600,250);
		mainTextArea.setBackground(Color.black);
		mainTextArea.setForeground(Color.white);
		mainTextArea.setFont(normalFont);
		mainTextArea.setLineWrap(true);
		mainTextArea.setWrapStyleWord(true);
		mainTextArea.setEditable(false);
		mainTextArea.setHighlighter(null);
		mainTextPanel.add(mainTextArea);
		
		choiceButtonPanel = new JPanel();
		choiceButtonPanel.setBounds(250,350,300,150);
		choiceButtonPanel.setBackground(Color.black);
		choiceButtonPanel.setLayout(new GridLayout(4,1));
		
		choice1 = new JButton("Choice 1");
		choice1.setBackground(Color.black);
		choice1.setForeground(Color.white);
		choice1.setFont(normalFont);
		choice1.setFocusPainted(false);
		choice1.addActionListener(choiceHandlerObject);
		choice1.setActionCommand("c1");

		choice2 = new JButton("Choice 2");
		choice2.setBackground(Color.black);
		choice2.setForeground(Color.white);
		choice2.setFont(normalFont);
		choice2.setFocusPainted(false);
		choice2.addActionListener(choiceHandlerObject);
		choice2.setActionCommand("c2");
		
		choice3 = new JButton("Choice 3");
		choice3.setBackground(Color.black);
		choice3.setForeground(Color.white);
		choice3.setFont(normalFont);
		choice3.setFocusPainted(false);
		choice3.addActionListener(choiceHandlerObject);
		choice3.setActionCommand("c3");
		
		choice4 = new JButton("Choice 4");
		choice4.setBackground(Color.black);
		choice4.setForeground(Color.white);
		choice4.setFont(normalFont);
		choice4.setFocusPainted(false);
		choice4.addActionListener(choiceHandlerObject);
		choice4.setActionCommand("c4");
		
		// Add Choice Buttons to Choice Button Panel
		choiceButtonPanel.add(choice1);
		choiceButtonPanel.add(choice2);
		choiceButtonPanel.add(choice3);
		choiceButtonPanel.add(choice4);

		// Add Game Screen components to window
		window.add(mainTextPanel);
		window.add(choiceButtonPanel);		
		
		playerPanel = new JPanel();
		playerPanel.setBounds(100,15,600,50);
		playerPanel.setBackground(Color.black);
		playerPanel.setLayout(new GridLayout(1,4));
		window.add(playerPanel); // Add Player Panel to window
		
		hpLabel = new JLabel("HP:");
		hpLabel.setForeground(Color.white);
		hpLabel.setFont(normalFont);
		playerPanel.add(hpLabel);
		hpNumberLabel = new JLabel();
		hpNumberLabel.setForeground(Color.white);
		hpNumberLabel.setFont(normalFont);
		playerPanel.add(hpNumberLabel);
		weaponLabel = new JLabel("Weapon:");
		weaponLabel.setForeground(Color.white);
		weaponLabel.setFont(normalFont);
		playerPanel.add(weaponLabel);
		weaponNameLabel = new JLabel();
		weaponNameLabel.setForeground(Color.white);
		weaponNameLabel.setFont(normalFont);
		playerPanel.add(weaponNameLabel);
	}
}
