package elsotano.enemies;

import lombok.Data;

@Data	
public class SimpleEnemy {
	
	int baseAttack;
	int baseDefense;
	int baseAgility;
	int baseLuck;
	
	int currentHP;
	int baseMaxHP;
	
	String name;
	
	public SimpleEnemy() {
		
		baseAttack = 0;
		baseDefense = 0;
		baseAgility = 0;
		baseLuck = 0;
		currentHP = 0;
		baseMaxHP = 0;
		
		name = " ";
		
	}
	
	public SimpleEnemy(int baseMaxHP, int baseAttack, int baseDefense, int baseAgility, int baseLuck) {
		
		this.baseAttack = baseAttack;
		this.baseDefense = baseDefense;
		this.baseAgility = baseAgility;
		this.baseLuck = baseLuck;
		this.baseMaxHP = baseMaxHP;
		this.currentHP = baseMaxHP;
		
		name = " ";
		
	}
	
	public void healDamage(int quantity) { //TODO Armor (not simple enemy) and maxHP blablablabla...bla
		
		if(currentHP + quantity >= baseMaxHP)  currentHP = baseMaxHP;
		else                                    currentHP += quantity;
		
	}
	
	public void dealDamage(int quantity) {
		
		if(currentHP - quantity <= 0)  currentHP = 0;
		else                           currentHP -= quantity;
		
	}
	
	
}
