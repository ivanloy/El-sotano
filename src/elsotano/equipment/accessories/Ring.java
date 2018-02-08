package elsotano.equipment.accessories;

import lombok.Data;

@Data
public class Ring implements Cloneable{

	private int luck;
	private String name;
	
	public Ring() {
		
		luck = 0;
		name = " ";
		
	}
	
	public Ring(int luck) {
		
		this.luck = luck;
		name = " ";
		
	}
	
	@Override
	public Ring clone() {
		
		Ring copy = null;
		
		try {
			
			copy = (Ring) super.clone();
			
		}catch(CloneNotSupportedException err) {
			
			err.printStackTrace();
			
		}
		
		return copy;
		
	}
	
}
