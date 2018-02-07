package elsotano.equipment.weapons;

import lombok.Data;

@Data
public class Sword implements Cloneable{ //TODO Put names to weapons, armors and player

	private int power; 
	private String name;
	
	public Sword() {
		
		power = 0;
		name = " ";
		
	}
	
	public Sword(int power) {
		
		this.power = power;
		name = " ";
		
	}
	
	@Override
	public Sword clone() {
		
		Sword copy = null;
		
		try {
			
			copy = (Sword) super.clone();
			
		}catch(CloneNotSupportedException err) {
			
			err.printStackTrace();
			
		}
		
		return copy;
		
	}
	
}
