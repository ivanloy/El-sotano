package elsotano.equipment.armor;

import lombok.Data;

@Data
public class HeadArmor implements Cloneable {

	private int defense;
	private String name;
	
	public HeadArmor() {
		
		defense = 0;
		name = " ";
		
	}
	
	public HeadArmor(int defense) {
		
		this.defense = defense;
		name = " ";
		
	}
	
	@Override
	public HeadArmor clone() {
		
		HeadArmor copy = null;
		
		try {
			
			copy = (HeadArmor) super.clone();
			
		}catch(CloneNotSupportedException err) {
			
			err.printStackTrace();
			
		}
		
		return copy;
		
	}
	
}
