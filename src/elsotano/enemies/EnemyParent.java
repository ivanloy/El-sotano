package elsotano.enemies;

import elsotano.character.Player;
import elsotano.util.MathUtilities;
import lombok.Data;

@Data
public class EnemyParent {

	private int baseAttack;
	private int baseDefense;
	private int baseAgility;
	private int baseLuck;
	private int baseSpeed;
	
	private int currentHP;
	private int baseMaxHP;
	
	String name;
	
	public EnemyParent() {
		
		baseAttack = 0;
		baseDefense = 0;
		baseAgility = 0;
		baseLuck = 0;
		currentHP = 0;
		baseMaxHP = 0;
		baseSpeed = 0;
		
		name = " ";
		
	}
	
	public EnemyParent(int baseMaxHP, int baseAttack, int baseDefense, int baseAgility, int baseLuck, int baseSpeed) {
		
		this.baseAttack = baseAttack;
		this.baseDefense = baseDefense;
		this.baseAgility = baseAgility;
		this.baseLuck = baseLuck;
		this.baseMaxHP = baseMaxHP;
		this.currentHP = baseMaxHP;
		this.baseSpeed = baseSpeed;
		
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
	
	public void attack(Player player, double damageMult) { //TODO Inheritance and stuff
		
		boolean doesCritDamage = doesCritDamage();
		int baseDamage = (int)((this.getBaseAttack() * this.getBaseAttack()) / ((this.getBaseAttack() + player.getBaseDefense()))); //TODO Add armor and getAttack() methods
		int critDamage = doesCritDamage ? (int)(baseDamage * calcCritMultiplier()) : 0;
		int realDamage = (int)(critDamage + baseDamage + baseDamage * (Math.random() * 0.4 - 0.2));
		realDamage *= damageMult;
		
		if(realDamage <= 0) realDamage = 1;
		
		player.dealDamage(realDamage);
		
		System.out.println((doesCritDamage ? "CRITICAL!! " : "") + name + " dealed " + realDamage + (doesCritDamage ? "(+" + critDamage + ")" : "") + " damage to " + player.getName() + ". Now it has " + player.getCurrentHP() + "HP.");
		
	}
	
	public void attack(Player player) {
		
		attack(player, 1);
		
	}
	
	public double calcCritMultiplier() {
		
		double ret = 0;
		double agility = getBaseAgility();
		
		if(agility <= 0)              ret = 0.1; //TODO Improve
		else if (agility <= 100)      ret = MathUtilities.map(agility, 1, 100, 0.1, 0.3);
		else if (agility <= 1000)     ret = MathUtilities.map(agility, 100, 1000, 0.3, 0.8);
		else if (agility <= 10000)    ret = MathUtilities.map(agility, 1000, 10000, 0.8, 1.5);
		else if (agility <= 100000)   ret = MathUtilities.map(agility, 10000, 100000, 1.5, 2.5);		
		else if (agility <= 1000000)  ret = MathUtilities.map(agility, 100000, 1000000, 2.5, 5);
		else                          ret = 5;
		
		return ret;
		
	}
	
	public boolean doesCritDamage() {
		
		boolean ret = false;
		int luck = getBaseLuck();
		double critPercentage;
		double random = Math.random();
		
		if(luck <= 0)             critPercentage = 0.1; 
		else if (luck <= 10)      critPercentage = MathUtilities.map(luck, 1, 10, 0.1, 1);
		else if (luck <= 40)      critPercentage = MathUtilities.map(luck, 10, 40, 1, 2);
		else if (luck <= 280)     critPercentage = MathUtilities.map(luck, 40, 280, 2, 7);
		else if (luck <= 500)     critPercentage = MathUtilities.map(luck, 280, 500, 7, 11);
		else if (luck <= 1750)    critPercentage = MathUtilities.map(luck, 500, 1750, 11, 15);
		else if (luck <= 2000)    critPercentage = MathUtilities.map(luck, 1750, 2000, 15, 17);
		else if (luck <= 3000)    critPercentage = MathUtilities.map(luck, 2000, 3000, 17, 19);
		else if (luck <= 4000)    critPercentage = MathUtilities.map(luck, 3000, 4000, 19, 22);
		else if (luck <= 5000)    critPercentage = MathUtilities.map(luck, 4000, 5000, 22, 24);
		else if (luck <= 15000)   critPercentage = MathUtilities.map(luck, 5000, 15000, 24, 28);
		else if (luck <= 20000)   critPercentage = MathUtilities.map(luck, 15000, 20000, 28, 30);
		else if (luck <= 50000)   critPercentage = MathUtilities.map(luck, 20000, 50000, 30, 33);
		else if (luck <= 250000)  critPercentage = MathUtilities.map(luck, 50000, 250000, 33, 39);
		else if (luck <= 1000000) critPercentage = MathUtilities.map(luck, 250000, 1000000, 39, 50);
		else                      critPercentage = 50; //FINISH THIS
		
		if(random * 100 < critPercentage) ret = true;
		//System.out.println(random * 100 + " < " + critPercentage);
		
		return ret;
		
	}
	
}
