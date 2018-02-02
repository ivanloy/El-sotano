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
				if(i > 0) {
					
					hasDoor[3] = salas[i-1][j].getHasDoor()[1];
					
				}
				if(j == 0) hasDoor[0] = true;
				else if(j == 4) hasDoor[2] = true;
				if(j > 0) {
					
					hasDoor[0] = salas[i][j-1].getHasDoor()[2];
					
				}
				
				if(i == 0 && j == 0) {
					
					hasDoor[1] = false;
					hasDoor[2] = false;
					
				}
				
				if(i == 4 && j == 4) {
					
					hasDoor[3] = false;
					hasDoor[0] = false;
					
				}
				
				float humidity = random.nextFloat()*100;
				float temperature = random.nextFloat()*40-10;
				String roomCode = (char)(i + 65) + "" + j;
				
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
