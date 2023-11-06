package package02;

public class Enemy_Guard extends SuperclassEnemy
{
	public Enemy_Guard()
	{
		name = "Guard";
		hp = 60;
		attackDamage = 12;
		nextPositionWhenDefeated = "defeatedGuard";
		fleeMessage = "Ha! Run, you coward! RUN.";
	}
}
