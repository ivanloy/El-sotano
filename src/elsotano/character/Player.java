package elsotano.character;

import elsotano.equipment.armor.ChestArmor;
import elsotano.equipment.armor.LegsArmor;
import elsotano.equipment.armor.HeadArmor;
import elsotano.equipment.weapons.Sword;
import lombok.Getter;
import lombok.Setter;

public class Player {

	@Getter @Setter private int baseAttack;
	@Getter @Setter private int baseDefense;
	@Getter @Setter private String name;
	private Sword sword; //TODO Make it weapon
	private ChestArmor chestArmor;
	private LegsArmor legsArmor;
	private HeadArmor headArmor;
	
	public Player() {
		
		baseAttack = 0;
		baseDefense = 0;
		name = " ";
		sword = new Sword();
		chestArmor = new ChestArmor();
		legsArmor = new LegsArmor();
		headArmor = new HeadArmor();
		
	}
	
	public Player(int baseAttack, int baseDefense) {
		
		this.baseAttack = baseAttack;
		this.baseDefense = baseDefense;
		sword = new Sword();
		name = " ";
		chestArmor = new ChestArmor();
		legsArmor = new LegsArmor();
		headArmor = new HeadArmor();
		
	}
	
	//Getters, setters y metodos delegados
	
	public Sword getSword() { return this.sword.clone(); }
	public void setSword(Sword sword) { this.sword = sword.clone(); }
	
	public int getSwordPower() { return sword.getPower(); }
	public void setSwordPower(int power) { sword.setPower(power); }
	
	
	public ChestArmor getChestArmor() { return this.chestArmor.clone(); }
	public void setChestArmor(ChestArmor chestArmor) { this.chestArmor = chestArmor.clone(); }
	
	public int getChestArmorDefense() { return chestArmor.getDefense(); }
	public void setChestArmorDefense(int defense) { chestArmor.setDefense(defense); }
	
	
	public LegsArmor getLegsArmor() { return this.legsArmor.clone(); }
	public void setLegsArmor(LegsArmor legsArmor) { this.legsArmor = legsArmor.clone(); }
	
	public int getLegsArmorDefense() { return legsArmor.getDefense(); }
	public void setLegsArmorDefense(int defense) { legsArmor.setDefense(defense); }
	
	
	public HeadArmor getHeadArmor() { return this.headArmor.clone(); }
	public void setHeadArmor(HeadArmor headArmor) { this.headArmor = headArmor.clone(); }
	
	public int getHeadArmorDefense() { return headArmor.getDefense(); }
	public void setHeadArmorDefense(int defense) { headArmor.setDefense(defense); }
	
	
	public int getAttack() { return baseAttack + sword.getPower(); }
	public int getDefense() { return baseDefense + chestArmor.getDefense() + headArmor.getDefense() + legsArmor.getDefense(); }
	
	//--------------------------------------
	
	public String toString() { //TODO Put weapons and player names //TODO Make method and make just parameters toString
		
		return "-----------------------------------------------" +
			 "\n " + name.toUpperCase() +
			 "\n-----------------------------------------------" +
			 "\n Attack: " + getAttack() + " (" + baseAttack + " + " + (getAttack() - baseAttack) + ")" + 
		     "\n Defense: " + getDefense() + " (" + baseDefense + " + " + (getDefense() - baseDefense) + ")" +
			 "\n-----------------------------------------------" + 
		     "\n Sword: \n\t" + sword.getName() + "\n\t+" + sword.getPower() + " attack." + 
			 "\n\n Head Armor: \n\t" + headArmor.getName() + "\n\t+" + headArmor.getDefense() + " defense." +
			 "\n\n Chest Armor: \n\t" + chestArmor.getName() + "\n\t+" + chestArmor.getDefense() + " defense." +
			 "\n\n Legs Armor: \n\t" + legsArmor.getName() + "\n\t+" + legsArmor.getDefense() + " defense." +
			 "\n-----------------------------------------------";
		
	}
	
}
