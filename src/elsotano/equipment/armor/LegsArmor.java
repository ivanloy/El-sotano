package elsotano.equipment.armor;

import lombok.Data;

@Data
public class LegsArmor implements Cloneable { //TODO add inheritance

	private int defense;
	private int agility;
	
	private String name;
	
	public LegsArmor() {
		
		defense = 0;
		agility = 0;
		name = " ";
		
	}
	
	public LegsArmor(int defense, int agility) {
		
		this.defense = defense;
		this.agility = agility;
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
