package package02;

public class Enemy_Goblin extends SuperclassEnemy
{
	public Enemy_Goblin()
	{
		name = "Goblin";
		hp = 20;
		attackDamage = 6;
		nextPositionWhenDefeated = "defeatedGoblin";
		fleeMessage = "Wait, come back here! I'm not done with you!";
	}
}
