package elsotano.equipment.armor;

import lombok.Data;

@Data
public class LegsArmor implements Cloneable { //TODO change to LEGS Armor...wtf

	private int defense;
	private String name;
	
	public LegsArmor() {
		
		defense = 0;
		name = " ";
		
	}
	
	public LegsArmor(int defense) {
		
		this.defense = defense;
		name = " ";
		
	}
	
	@Override
	public LegsArmor clone() {
		
		LegsArmor copy = null;
		
		try {
			
			copy = (LegsArmor) super.clone();
			
		}catch(CloneNotSupportedException err) {
			
			err.printStackTrace();
			
		}
		
		return copy;
		
	}
	
}
