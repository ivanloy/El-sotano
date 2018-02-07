package elsotano.character;

import elsotano.equipment.weapons.Sword;
import lombok.Data;

@Data //Change this
public class Player {

	private int baseAttack;
	private int baseDefense;
	private Sword sword;
	
	public Player() {
		
		baseAttack = 0;
		sword = new Sword();
		
	}
	
	public Player(int baseAttack) { //TODO Delegacion 
		
		this.baseAttack = baseAttack;
		this.sword = new Sword();
		
	}
	
	public int getAttack() {
		
		return baseAttack + sword.getPower();
		
	}
	
	public int getSwordPower() {
		
		return sword.getPower();
		
	}

	
	public void setSwordPower(int power) {
		
		sword.setPower(power);
		
	}
	
}
