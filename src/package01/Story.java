package package01;

import java.awt.Color;

import package02.Enemy_Goblin;
import package02.Enemy_Guard;
import package02.SuperclassEnemy;
import package02.Weapon_Knife;
import package02.Weapon_LongSword;

// This class displays the content of components (i.e. text)

public class Story
{
	Game game;
	UI ui;
	VisibilityManager vManager;
	Player player = new Player();
	SuperclassEnemy enemy;
	
	public boolean playerHasDefeatedGoblin, playerHasDefeatedGuard;
	
	public Story(Game gameObject, UI uiObject, VisibilityManager visibilityManagerObject)
	{
		game = gameObject;
		ui = uiObject;
		vManager = visibilityManagerObject;
	}
	
	public void defaultSetup()
	{
		player.hp = 10;
		player.maxHP = 25;
		ui.hpNumberLabel.setText("" + player.hp);
		
		player.currentWeapon = new Weapon_Knife();
		ui.weaponNameLabel.setText(player.currentWeapon.name);
		
		player.attackDamage = 0;
		player.guardVisits = 0;
		player.gotShield = false;
		
		playerHasDefeatedGoblin = false;
		playerHasDefeatedGuard = false;
	}
	
	public void selectPosition(String nextPosition)
	{
		switch (nextPosition)
		{
		case "townGate": townGate(); break;
		case "talkGuard": talkGuard(); break;
		case "attackGuard": attackGuard(); break;
		case "crossroad": crossroad(); break;
		case "north": north(); break;
		case "east": east(); break;
		case "west": west(); break;
		case "fight": fight(); break;
		case "playerAttack": playerAttack(); break;
		case "playerShield": playerShield(); break;
		case "enemyAttack": enemyAttack(); break;
		case "flee": flee(); break;
		case "defeatedGoblin": defeatedGoblin(); break;
		case "defeatedGuard": defeatedGuard(); break;
		case "goodEnding": goodEnding(); break;
		case "goodEnding2": goodEnding2(); break;
		case "badEnding": badEnding(); break;
		case "deathScreen": deathScreen(); break;
		case "theEnd": theEnd(); break;
		}
	}
	
	public void townGate()
	{
		ui.mainTextArea.setText("You are at the gate of the town. \nA guard is standing in front of you. \n\nWhat will you do?");
		
		ui.choice1.setText("Talk to the guard");
		ui.choice2.setText("Attack the guard");
		ui.choice3.setText("Leave");
		ui.choice4.setText("");
		
		vManager.hideEmptyButtons();
		
		if (!playerHasDefeatedGoblin)
			game.nextPosition1 = "talkGuard";
		else
			game.nextPosition1 = "goodEnding";
		game.nextPosition2 = "attackGuard";
		game.nextPosition3 = "crossroad";
		game.nextPosition4 = "";
	}
	
	public void talkGuard()
	{
		switch (player.guardVisits)
		{
		case 0:
			ui.mainTextArea.setText("Guard: Hello, stranger. I have never seen your face. \nI'm sorry, but we cannot let a stranger enter our town.");
			player.guardVisits++;
			break;
		case 1:
			ui.mainTextArea.setText("Guard: Hello again, stranger. As I told you a while ago, \nwe cannot let a stranger like you to enter our town. Sorry about that.");
			player.guardVisits++;
			break;
		default:
			switch (new java.util.Random().nextInt(1,11))
			{
			case 1: ui.mainTextArea.setText("Guard: Just give up already..."); break;
			case 2: ui.mainTextArea.setText("Guard: Not a chance."); break;
			case 3: ui.mainTextArea.setText("Guard: Nu-uh."); break;
			case 4: ui.mainTextArea.setText("Guard: Nope."); break;
			case 5: ui.mainTextArea.setText("Guard: Why are you here again? \nAh, I remember. You cannot enter here."); break;
			case 6: ui.mainTextArea.setText("Guard: Too bad, you cannot enter here."); break;
			case 7: ui.mainTextArea.setText("Guard: Who's there? \nOh, it's just you... Go away already!"); break;
			case 8: ui.mainTextArea.setText("Guard: We might let you enter our town if you do something GREAT. \nNot entirely sure what that is, though."); break;
			case 9: ui.mainTextArea.setText("Guard: Shoo!"); break;
			case 10: ui.mainTextArea.setText("Guard: Staring at me don't do anything. Just stop."); break;
			}
			break;
		}
		
		ui.choice1.setText("Back");
		ui.choice2.setText("");
		ui.choice3.setText("");
		ui.choice4.setText("");
		
		vManager.hideEmptyButtons();
		
		game.nextPosition1 = "townGate";
		game.nextPosition2 = "";
		game.nextPosition3 = "";
		game.nextPosition4 = "";
	}
	
	public void attackGuard()
	{
		player.guardVisits = 2;
		
		if (player.currentWeapon.name.equals(new Weapon_Knife().name))
		{
			int guardAttackDamage = 3;
			
			if (player.hp < guardAttackDamage)
				guardAttackDamage = player.hp;
			player.hp -= guardAttackDamage;
			
			switch (new java.util.Random().nextInt(1,4))
			{
			case 1:
				ui.mainTextArea.setText("You attempt to hit the guard with the Knife. \n\nGuard: Hey, don't be such a fool! \n\nThe guard attacked you so hard and you gave up. \n(You received " + guardAttackDamage + " damage)");
				break;
			case 2:
				ui.mainTextArea.setText("You attempt to hit the guard with the Knife. \n\nGuard: You think that hurts? \n\nThe guard attacked you so hard and you gave up. \n(You received " + guardAttackDamage + " damage)");
				break;
			case 3:
				ui.mainTextArea.setText("You attempt to hit the guard with your Knife. \n\nGuard: Is that all you've got? \n\nThe guard attacked you so hard and you gave up. \n(You received " + guardAttackDamage + " damage)");
				break;
			}
			
			ui.hpNumberLabel.setText("" + player.hp);
			
			ui.choice1.setText("Back to town gate");
			ui.choice2.setText("");
			ui.choice3.setText("");
			ui.choice4.setText("");
			
			vManager.hideEmptyButtons();
			
			game.nextPosition1 = "townGate";
			game.nextPosition2 = "";
			game.nextPosition3 = "";
			game.nextPosition4 = "";
		}
		else
		{
			game.prevPosition = "townGate";
			enemy = new Enemy_Guard();
			
			ui.mainTextArea.setText("Guard: A Long Sword, huh? Bold of you to assume you can get past me. \nIf you want a duel, I can give it to you.");
			
			ui.choice1.setText("Fight");
			ui.choice2.setText("Run");
			ui.choice3.setText("");
			ui.choice4.setText("");
			
			vManager.hideEmptyButtons();
			
			game.nextPosition1 = "fight";
			game.nextPosition2 = "townGate";
			game.nextPosition3 = "";
			game.nextPosition4 = "";
		}
	}
	
	public void crossroad()
	{
		ui.mainTextArea.setText("You are at the crossroad. \n\nIf you go south, you will go back to the town");
		
		ui.choice1.setText("Go north");
		ui.choice2.setText("Go east");
		ui.choice3.setText("Go south");
		ui.choice4.setText("Go west");
		
		vManager.hideEmptyButtons();
		
		game.nextPosition1 = "north";
		game.nextPosition2 = "east";
		game.nextPosition3 = "townGate";
		game.nextPosition4 = "west";
	}
	
	public void north()
	{
		int healthIncrement = new java.util.Random().nextInt(2,6);
		
		if (player.hp+healthIncrement > player.maxHP)
			healthIncrement = player.maxHP - player.hp;
		
		if (player.hp < player.maxHP)
			ui.mainTextArea.setText("There is a river. \nYou drink the water and rest at the riverside. \n\n(Your HP is recovered by "+ healthIncrement +")");
		else
			ui.mainTextArea.setText("For some reason, there is no river. \nYou might have lost or the river has disappeared.");
		
		player.hp += healthIncrement;
		
		ui.hpNumberLabel.setText("" + player.hp);
		
		
		ui.choice1.setText("Go south");
		ui.choice2.setText("");
		ui.choice3.setText("");
		ui.choice4.setText("");
		
		vManager.hideEmptyButtons();
		
		game.nextPosition1 = "crossroad";
		game.nextPosition2 = "";
		game.nextPosition3 = "";
		game.nextPosition4 = "";
	}
	
	public void east()
	{
		if (!player.currentWeapon.name.equals(new Weapon_LongSword().name))
		{
			ui.mainTextArea.setText("You walked into a forest and found a Long Sword! \n\n(You obtained the Long Sword)");

			player.currentWeapon = new Weapon_LongSword();
			ui.weaponNameLabel.setText(player.currentWeapon.name);
		}
		else
		{
			if (!player.gotShield)
			{
				if (new java.util.Random().nextInt(20) == 0)
				{
					player.gotShield = true;
					ui.mainTextArea.setText("You searched the forest and found a Worn Shield! \n\n(You obtained the Worn Shield. \nYou can now SHIELD enemy attacks)");
				}
				else
					ui.mainTextArea.setText("You searched the forest and found nothing.");
			}
			else
				ui.mainTextArea.setText("You wandered through the forest and gazed upon its natural wonders. \n\nIt pleased your soul.");
		}
		
		ui.choice1.setText("Go west");
		ui.choice2.setText("");
		ui.choice3.setText("");
		ui.choice4.setText("");
		
		vManager.hideEmptyButtons();
		
		game.nextPosition1 = "crossroad";
		game.nextPosition2 = "";
		game.nextPosition3 = "";
		game.nextPosition4 = "";
	}
	
	public void west()
	{
		if (!playerHasDefeatedGoblin)
		{
			game.prevPosition = "crossroad";
			enemy = new Enemy_Goblin();
			
			ui.mainTextArea.setText("You encounter a Goblin! \n\nGoblin: Hey, you! Give me all of your riches!");
			
			ui.choice1.setText("Fight");
			ui.choice2.setText("Run");
			ui.choice3.setText("");
			ui.choice4.setText("");
			
			vManager.hideEmptyButtons();
			
			game.nextPosition1 = "fight";
			game.nextPosition2 = "crossroad";
			game.nextPosition3 = "";
			game.nextPosition4 = "";
		}
		else
		{
			ui.mainTextArea.setText("Well, no goblin or anything on sight.");
			
			ui.choice1.setText("Go east");
			ui.choice2.setText("");
			ui.choice3.setText("");
			ui.choice4.setText("");
			
			vManager.hideEmptyButtons();
			
			game.nextPosition1 = "crossroad";
			game.nextPosition2 = "";
			game.nextPosition3 = "";
			game.nextPosition4 = "";
		}
	}
	
	public void fight()
	{
		ui.mainTextArea.setText(enemy.name + " HP: " + enemy.hp + "\n\nWhat will you do?");
		
		ui.choice1.setText("Attack");
		if (player.gotShield)
		{
			ui.choice2.setText("Shield");
			ui.choice3.setText("Flee");
			ui.choice4.setText("");
		}
		else
		{
			ui.choice2.setText("Flee");
			ui.choice3.setText("");
			ui.choice4.setText("");
		}
		
		vManager.hideEmptyButtons();
		
		game.nextPosition1 = "playerAttack";
		if (player.gotShield)
		{
			game.nextPosition2 = "playerShield";
			game.nextPosition3 = "flee";
			game.nextPosition4 = "";
		}
		else
		{
			game.nextPosition2 = "flee";
			game.nextPosition3 = "";
			game.nextPosition4 = "";
		}
	}
	
	public void flee()
	{
		ui.mainTextArea.setText(enemy.name + ": " + enemy.fleeMessage + "\n\nYou flee from the " + enemy.name);
		
		ui.choice1.setText(">");
		ui.choice2.setText("");
		ui.choice3.setText("");
		ui.choice4.setText("");
		
		vManager.hideEmptyButtons();
		
		game.nextPosition1 = game.prevPosition;
		game.nextPosition2 = "";
		game.nextPosition3 = "";
		game.nextPosition4 = "";
	}
	
	public void playerAttack()
	{
		player.isShielded = false;
		player.attackDamage = new java.util.Random().nextInt(player.currentWeapon.attackDamage);
		
		if (enemy.hp < player.attackDamage)
		{
			player.attackDamage = enemy.hp;
			enemy.hp = 0;
		}
		else
			enemy.hp -= player.attackDamage;
		
		ui.mainTextArea.setText(enemy.name + " HP: " + enemy.hp + "\n\nYou attacked the " + enemy.name + (player.attackDamage == 0 ?
			", but you miss." : " and gave " + player.attackDamage + " damage!"));
		
		ui.choice1.setText(">");
		ui.choice2.setText("");
		ui.choice3.setText("");
		ui.choice4.setText("");
		
		vManager.hideEmptyButtons();
		
		if (enemy.hp > 0)
		{
			game.nextPosition1 = "enemyAttack";
			game.nextPosition2 = "";
			game.nextPosition3 = "";
			game.nextPosition4 = "";
		}
		else
		{
			game.nextPosition1 = enemy.nextPositionWhenDefeated;
			game.nextPosition2 = "";
			game.nextPosition3 = "";
			game.nextPosition4 = "";
		}
	}
	
	public void playerShield()
	{
		player.isShielded = true;
		
		ui.mainTextArea.setText(enemy.name + " HP: " + enemy.hp + "\n\nYou block the attack with your Shield.");
		
		ui.choice1.setText(">");
		ui.choice2.setText("");
		ui.choice3.setText("");
		ui.choice4.setText("");
		
		vManager.hideEmptyButtons();
		
		game.nextPosition1 = "enemyAttack";
		game.nextPosition2 = "";
		game.nextPosition3 = "";
		game.nextPosition4 = "";
	}
	
	public void enemyAttack()
	{	
		if (player.isShielded)
			ui.mainTextArea.setText(enemy.name + " HP: " + enemy.hp + "\n\nThe " + enemy.name + " attacked you, but you blocked it and gave no damage!");
		else
		{	
			int enemyAttackDamage = new java.util.Random().nextInt(enemy.attackDamage);
			
			if (player.hp < enemyAttackDamage)
			{
				enemyAttackDamage = player.hp;
				player.hp = 0;
			}
			else
				player.hp -= enemyAttackDamage;
			
			ui.mainTextArea.setText(enemy.name + " HP: " + enemy.hp + "\n\nThe " + enemy.name + " attacked you" + (enemyAttackDamage == 0 ?
				(player.attackDamage == 0 ? ", but it also misses.": ", but it misses.") :
				" and gave " + enemyAttackDamage + " damage!"));
		}
		
		ui.hpNumberLabel.setText("" + player.hp);
		
		ui.choice1.setText(">");
		ui.choice2.setText("");
		ui.choice3.setText("");
		ui.choice4.setText("");
		
		vManager.hideEmptyButtons();
		
		if (player.hp > 0)
		{
			game.nextPosition1 = "fight";
			game.nextPosition2 = "";
			game.nextPosition3 = "";
			game.nextPosition4 = "";
		}
		else
		{
			game.nextPosition1 = "deathScreen";
			game.nextPosition2 = "";
			game.nextPosition3 = "";
			game.nextPosition4 = "";
		}
	}
	
	public void defeatedGoblin()
	{
		playerHasDefeatedGoblin = true;
		player.maxHP += 25;
		
		ui.mainTextArea.setText("Goblin: Argh! You're too strong. I can't beat you! Until we meet again... \n\nYou defeated the Goblin and it dropped a ring. \n\n(You obtained the Silver Ring. \nYou Max HP has increased by 25)");
		
		ui.choice1.setText("Go east");
		ui.choice2.setText("");
		ui.choice3.setText("");
		ui.choice4.setText("");
		
		vManager.hideEmptyButtons();
		
		game.nextPosition1 = "crossroad";
		game.nextPosition2 = "";
		game.nextPosition3 = "";
		game.nextPosition4 = "";
	}
	
	public void defeatedGuard()
	{
		playerHasDefeatedGuard = true;
		
		ui.mainTextArea.setText("Guard: HEH... heh.. heh. You put up a good fight. \nSince you've defeated me, you have to kill me. That will save me from enormous amount of shame from my town. \nDo it for me.");
		
		ui.choice1.setText("Attack");
		ui.choice2.setText("Spare");
		ui.choice3.setText("");
		ui.choice4.setText("");
		
		vManager.hideEmptyButtons();
		
		game.nextPosition1 = "badEnding";
		game.nextPosition2 = "goodEnding2";
		game.nextPosition3 = "";
		game.nextPosition4 = "";
	}
	
	public void deathScreen()
	{
		vManager.showTitleScreen();
		
		ui.titleNameLabel.setText("YOU DIED");
		ui.titleNameLabel.setForeground(Color.white);
		ui.startButton.setText("Retry");
	}
	
	public void goodEnding()
	{
		ui.mainTextArea.setText("Guard: Wait, is that a Silver Ring!? \nThat means you have killed that goblin who kept stealing in our town! \nThank you so much! You are a true hero. \n\nWelcome to our town!");
		
		ui.choice1.setText(">");
		ui.choice2.setText("");
		ui.choice3.setText("");
		ui.choice4.setText("");
		
		vManager.hideEmptyButtons();
		
		game.nextPosition1 = "theEnd";
		game.nextPosition2 = "";
		game.nextPosition3 = "";
		game.nextPosition4 = "";
	}
	
	public void goodEnding2()
	{
		playerHasDefeatedGuard = false;
		ui.mainTextArea.setText("Guard: Y-you didn't want to? Ah well, I guess you made the right choice. Fancy on being one of us? Let me take you to my fellow guards. Come on! \n\n(You became a guard of the town)");
		
		ui.choice1.setText(">");
		ui.choice2.setText("");
		ui.choice3.setText("");
		ui.choice4.setText("");
		
		vManager.hideEmptyButtons();
		
		game.nextPosition1 = "theEnd";
		game.nextPosition2 = "";
		game.nextPosition3 = "";
		game.nextPosition4 = "";
	}
	
	public void badEnding()
	{
		ui.mainTextArea.setText("You killed the guard with your " + player.currentWeapon.name + ". \nYou contemplate for a while and realized you've made a huge mistake. Now the other guards are after you. \n\n(You got killed in the process)");
		
		ui.choice1.setText(">");
		ui.choice2.setText("");
		ui.choice3.setText("");
		ui.choice4.setText("");
		
		vManager.hideEmptyButtons();
		
		game.nextPosition1 = "theEnd";
		game.nextPosition2 = "";
		game.nextPosition3 = "";
		game.nextPosition4 = "";
	}
	
	public void theEnd()
	{
		vManager.showTitleScreen();
		
		if (playerHasDefeatedGuard)
		{
			ui.titleNameLabel.setText("THE END");
			ui.titleNameLabel.setForeground(Color.red);
			ui.startButton.setText("Retry");
		}
		else
		{
			ui.titleNameLabel.setText("THE END");
			ui.titleNameLabel.setForeground(Color.yellow);
			ui.startButton.setText("Retry");
		}
	}
}
