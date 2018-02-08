package elsotano.enemies;

import lombok.Data;

@Data	
public class SimpleEnemy {
	
	int baseAttack;
	int baseDefense;
	int baseAgility;
	int baseLuck;
	
	String name;
	
	public SimpleEnemy() {
		
		baseAttack = 0;
		baseDefense = 0;
		baseAgility = 0;
		baseLuck = 0;
		
		name = " ";
		
	}
	
	public SimpleEnemy(int baseAttack, int baseDefense, int baseAgility, int baseLuck) {
		
		this.baseAttack = baseAttack;
		this.baseDefense = baseDefense;
		this.baseAgility = baseAgility;
		this.baseLuck = baseLuck;
		
		name = " ";
		
	}
	
}
