package elsotano.enemies;

import lombok.Data;

public class SimpleEnemy extends EnemyParent {
	
	public SimpleEnemy() {
		
		super();
		
	}
	
	public SimpleEnemy(int baseMaxHP, int baseAttack, int baseDefense, int baseAgility, int baseLuck, int baseSpeed) {
		
		super(baseMaxHP, baseAttack, baseDefense, baseAgility, baseLuck, baseSpeed);
		
	}
	
}
