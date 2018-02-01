package elsotano.mains;

import java.util.Random;

import elsotano.locations.Sala;
import elsotano.resources.Grid;


public class Main {

	public static void main(String[] args) {
		
		Sala[][] salas = new Sala[5][5];
		Random random = new Random();
		Grid grid = new Grid(5 * 10, 5 * 5);
		
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++){
					
				boolean[] hasDoor = {random.nextBoolean(), random.nextBoolean(), random.nextBoolean(), random.nextBoolean()};
				
				if(i == 0) hasDoor[3] = true;
				else if(i == 4) hasDoor[1] = true;
				else {
					
					//hasDoor[3] = salas[i][j-]
					
				}
				if(j == 0) hasDoor[0] = true;
				else if(j == 4) hasDoor[2] = true;
				if(j > 0) {
					
					hasDoor[3] = salas[i][j-1].getHasDoor()[1];
					
				}
				
				
				
				float humidity = random.nextFloat()*100;
				float temperature = random.nextFloat()*40-10;
				String roomCode = (char)(j + 65) + "" + i;
				
				salas[i][j] = new Sala(roomCode, hasDoor, temperature, humidity);
				
			}
		}
		
		
		for(int i = 0; i < 5; i++) {
			for(int j = 0; j < 5; j++){
		
				System.out.println("[" + i + "," + j + "] : " + salas[i][j].toString());
				grid.drawRoom(i, j, salas[i][j].getHasDoor());
				
			}
		}
		
		grid.printGrid();
		
	}

}
