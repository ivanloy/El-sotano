package elsotano.equipment.weapons;

import lombok.Data;

@Data
public class Sword {

	private int power;
	
	public Sword() {
		
		power = 0;
		
	}
	
	public Sword(int power) {
		
		this.power = power;
		
	}
	
}
