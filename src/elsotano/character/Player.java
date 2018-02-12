package elsotano.character;

import elsotano.enemies.EnemyParent;
import elsotano.equipment.accessories.Gloves;
import elsotano.equipment.accessories.Ring;
import elsotano.equipment.accessories.Shoes;
import elsotano.equipment.armor.ChestArmor;
import elsotano.equipment.armor.HeadArmor;
import elsotano.equipment.armor.LegsArmor;
import elsotano.equipment.weapons.Sword;
import elsotano.util.MathUtilities;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class Player {

	@Getter @Setter private int baseAttack;
	@Getter @Setter private int baseDefense;
	@Getter @Setter private int baseAgility;
	@Getter @Setter private int baseLuck;
	@Getter @Setter private int baseSpeed;
	@Getter @Setter private int baseMaxHP;
	@Getter private int currentHP;
	
	@Getter @Setter private String name;
	
	private Sword sword; //TODO Make it weapon
	private ChestArmor chestArmor;
	private LegsArmor legsArmor;
	private HeadArmor headArmor;
	private Gloves gloves;
	private Shoes shoes;
	private Ring ring;
	
	public Player() {
		
		baseMaxHP = 0;
		currentHP = 0;
		baseAttack = 0;
		baseDefense = 0;
		baseAgility = 0;
		baseLuck = 0;
		baseSpeed = 0;
		
		name = " ";
		
		sword = new Sword();
		chestArmor = new ChestArmor();
		legsArmor = new LegsArmor();
		headArmor = new HeadArmor();
		gloves = new Gloves();
		shoes = new Shoes();
		ring = new Ring();
		
	}
	
	public Player(int baseMaxHP, int baseAttack, int baseDefense, int baseAgility, int baseLuck, int baseSpeed) {
		
		this.baseMaxHP = baseMaxHP;
		this.currentHP = baseMaxHP;
		this.baseAttack = baseAttack;
		this.baseDefense = baseDefense;
		this.baseAgility = baseAgility;
		this.baseLuck = baseLuck;
		this.baseSpeed = baseSpeed;
		
		name = " ";
		
		sword = new Sword();
		chestArmor = new ChestArmor();
		legsArmor = new LegsArmor();
		headArmor = new HeadArmor();
		gloves = new Gloves();
		shoes = new Shoes();
		ring = new Ring();
		
	}
	
	//Getters, setters y metodos delegados
	
	public Sword getSword() { return this.sword.clone(); }
	public void setSword(Sword sword) { this.sword = sword.clone(); }
	
	public int getSwordPower() { return sword.getPower(); }
	public void setSwordPower(int power) { sword.setPower(power); }
	
	
	public ChestArmor getChestArmor() { return this.chestArmor.clone(); }
	public void setChestArmor(ChestArmor chestArmor) { 
		
		this.chestArmor = chestArmor.clone(); 
		if(currentHP > getMaxHP()) currentHP = getMaxHP();
		
	}
	
	public int getChestArmorDefense() { return chestArmor.getDefense(); }
	public void setChestArmorDefense(int defense) { chestArmor.setDefense(defense); }
	
	public int getChestArmorMaxHP() { return chestArmor.getMaxHP(); }
	public void setChestArmorMaxHP(int maxHP) { 
		
		chestArmor.setMaxHP(maxHP); 
		if(currentHP > getMaxHP()) currentHP = getMaxHP();
		
	}
	
	
	public LegsArmor getLegsArmor() { return this.legsArmor.clone(); }
	public void setLegsArmor(LegsArmor legsArmor) { this.legsArmor = legsArmor.clone(); }
	
	public int getLegsArmorDefense() { return legsArmor.getDefense(); }
	public void setLegsArmorDefense(int defense) { legsArmor.setDefense(defense); }
	
	public int getLegsArmorAgility() { return legsArmor.getAgility(); }
	public void setLegsArmorAgility(int agility) { legsArmor.setAgility(agility); }
	
	
	public HeadArmor getHeadArmor() { return this.headArmor.clone(); }
	public void setHeadArmor(HeadArmor headArmor) { this.headArmor = headArmor.clone(); }
	
	public int getHeadArmorDefense() { return headArmor.getDefense(); }
	public void setHeadArmorDefense(int defense) { headArmor.setDefense(defense); }
	
	
	public Gloves getGloves() { return this.gloves.clone(); }
	public void setGloves(Gloves gloves) { this.gloves = gloves.clone(); }
	
	public int getGlovesDefense() { return gloves.getDefense(); }
	public void setGlovesDefense(int defense) { gloves.setDefense(defense); }
	
	
	public Shoes getShoes() { return this.shoes.clone(); }
	public void setShoes(Shoes shoes) { this.shoes = shoes.clone(); }
	
	public int getShoesAgility() { return shoes.getAgility(); }
	public void setShoesAgility(int agility) { shoes.setAgility(agility); }
	
	
	public Ring getRing() { return this.ring.clone(); }
	public void setRing(Ring ring) { this.ring = ring.clone(); }
	
	public int getRingAgility() { return ring.getLuck(); }
	public void setRingAgility(int luck) { ring.setLuck(luck); }
	
	
	public void setCurrentHP(int currentHP) {
		
		if(currentHP > getMaxHP()) this.currentHP = getMaxHP();
		else                       this.currentHP = currentHP;
		
	}
	
	public int getMaxHP() { return baseMaxHP + chestArmor.getMaxHP(); }
	public int getAttack() { return baseAttack + sword.getPower(); }
	public int getDefense() { return baseDefense + chestArmor.getDefense() + headArmor.getDefense() + legsArmor.getDefense() + gloves.getDefense(); }
	public int getAgility() { return baseAgility + shoes.getAgility() + legsArmor.getAgility(); }
	public int getLuck() { return baseLuck + ring.getLuck(); }
	public int getSpeed() { return baseSpeed; }
	
	//--------------------------------------
	
	public void healDamage(int quantity) {
		
		if(currentHP + quantity >= getMaxHP())  currentHP = getMaxHP();
		else                                    currentHP += quantity;
		
	}
	
	public void dealDamage(int quantity) {
		
		if(currentHP - quantity <= 0)  currentHP = 0;
		else                           currentHP -= quantity;
		
	}
	
	public void attack(EnemyParent enemy) { //TODO Inheritance and stuff
		
		boolean doesCritDamage = doesCritDamage();
		int baseDamage = (int)((this.getAttack() * this.getAttack()) / ((this.getAttack() + enemy.getBaseDefense())));
		int critDamage = doesCritDamage ? (int)(baseDamage * calcCritMultiplier()) : 0;
		int realDamage = (int)(critDamage + baseDamage + baseDamage * (Math.random() * 0.4 - 0.2));
		
		if(realDamage <= 0) realDamage = 1;
		
		enemy.dealDamage(realDamage);
		
		System.out.println((doesCritDamage ? "CRITICAL!! " : "") + name + " dealed " + realDamage + (doesCritDamage ? "(+" + critDamage + ")" : "") + " damage to " + enemy.getName() + ". Now it has " + enemy.getCurrentHP() + "HP.");//TODO DELETE PRINT OR SAMSING
		//TODO get gender or it (now it has, he has, she has)
	}//TODO EVASION CON AGILIDAD
	
	public double calcCritMultiplier() {
		
		double ret = 0;
		double agility = getAgility();
		
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
		int luck = getLuck();
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
	
	public String printStats() {
		
		return "-----------------------------------------------" +
				 "\n " + name.toUpperCase() +
				 "\n-----------------------------------------------" +
				 "\n HP: " + currentHP + "/" + getMaxHP() + " (" + baseMaxHP + " + " + (getMaxHP() - baseMaxHP) + ")" + 
				 "\n Attack: " + getAttack() + " (" + baseAttack + " + " + (getAttack() - baseAttack) + ")" + 
			     "\n Defense: " + getDefense() + " (" + baseDefense + " + " + (getDefense() - baseDefense) + ")" +
			     "\n Agility: " + getAgility() + " (" + baseAgility + " + " + (getAgility() - baseAgility) + ")" +
			     "\n Luck: " + getLuck() + " (" + baseLuck + " + " + (getLuck() - baseLuck) + ")" +
			     "\n Speed: " + getSpeed() + " (" + baseSpeed + " + " + (getSpeed() - baseSpeed) + ")" +
				 "\n-----------------------------------------------" + 
			     "\n Sword: \n\t" + sword.getName() + "\n\t+" + sword.getPower() + " attack." + 
				 "\n\n Head Armor: \n\t" + headArmor.getName() + "\n\t+" + headArmor.getDefense() + " defense." +
				 "\n\n Chest Armor: \n\t" + chestArmor.getName() + "\n\t+" + chestArmor.getDefense() + " defense." + "\n\t+" + chestArmor.getMaxHP() + " max HP." +
				 "\n\n Legs Armor: \n\t" + legsArmor.getName() + "\n\t+" + legsArmor.getDefense() + " defense." + "\n\t+" + legsArmor.getAgility() + " agility." +
				 "\n\n Gloves: \n\t" + gloves.getName() + "\n\t+" + gloves.getDefense() + " defense." +
				 "\n\n Shoes: \n\t" + shoes.getName() + "\n\t+" + shoes.getAgility() + " agility." +
				 "\n\n Ring: \n\t" + ring.getName() + "\n\t+" + ring.getLuck() + " luck." +
				 "\n-----------------------------------------------";
		
	}
	
}
