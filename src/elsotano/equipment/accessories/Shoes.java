package elsotano.equipment.accessories;

import lombok.Data;

@Data
public class Shoes implements Cloneable{

	private int agility;
	private String name;
	
	public Shoes() {
		
		agility = 0;
		name = " ";
		
	}
	
	public Shoes(int agility) {
		
		this.agility = agility;
		name = " ";
		
	}
	
	@Override
	public Shoes clone() {
		
		Shoes copy = null;
		
		try {
			
			copy = (Shoes) super.clone();
			
		}catch(CloneNotSupportedException err) {
			
			err.printStackTrace();
			
		}
		
		return copy;
		
	}
	
}
