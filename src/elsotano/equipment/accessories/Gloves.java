package elsotano.equipment.accessories;

import lombok.Data;

@Data
public class Gloves implements Cloneable{

	private int defense;
	private String name;
	
	public Gloves() {
		
		defense = 0;
		name = " ";
		
	}
	
	public Gloves(int defense) {
		
		this.defense = defense;
		name = " ";
		
	}
	
	@Override
	public Gloves clone() {
		
		Gloves copy = null;
		
		try {
			
			copy = (Gloves) super.clone();
			
		}catch(CloneNotSupportedException err) {
			
			err.printStackTrace();
			
		}
		
		return copy;
		
	}
	
}
