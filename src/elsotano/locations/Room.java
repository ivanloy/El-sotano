package elsotano.locations;

import lombok.Data;

@Data
public class Room {
	
	private String roomCode;
	
	boolean[] hasDoor = new boolean[4];
	private float temperature;
	private float humidity;
	
	public Room() {
		
		roomCode = " ";
		temperature = 0;
		humidity = 0;
		
	}
	
	public Room(String roomCode, boolean[] hasDoor, float temperature, float humidity) {
		
		this.roomCode = roomCode;
		this.hasDoor = hasDoor;
		this.temperature = temperature;
		if(humidity <= 100) this.humidity = humidity;
		else this.humidity = 100;

	}
	
}
