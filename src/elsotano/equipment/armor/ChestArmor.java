package elsotano.equipment.armor;

import lombok.Data;

@Data
public class ChestArmor implements Cloneable{

	private int defense;
	private int maxHP;
	private String name;
	
	public ChestArmor() {
		
		defense = 0;
		maxHP = 0;
		name = " ";
		
	}
	
	public ChestArmor(int maxHP, int defense) {
		
		this.defense = defense;
		this.maxHP = maxHP;
		name = " ";
		
	}
	
	@Override
	public ChestArmor clone() {
		
		ChestArmor copy = null;
		
		try {
			
			copy = (ChestArmor) super.clone();
			
		}catch(CloneNotSupportedException err) {
			
			err.printStackTrace();
			
		}
		
		return copy;
		
	}
	
}
