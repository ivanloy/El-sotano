package elsotano.tests;

import elsotano.locations.Floor;
import elsotano.locations.Room;
import elsotano.resources.Grid;

public class Tests {

	public static void main(String[] args) {
		
		Floor floor = new Floor();
		Room[][] rooms = floor.exportFloor();
		
		Grid grid = new Grid(floor.getWidth() * 10, floor.getHeight() * 5); //TODO get width and height of the dungeon
		
		for(int i = 0; i < 15; i++) {
			for(int j = 0; j < 15; j++){
				
				if(rooms[i][j] != null) grid.drawRoom(j, i, rooms[i][j].getHasDoor());
				if(rooms[i][j] != null) System.out.println("a [" + i + "," + j + "] : " + rooms[i][j].toString());
				if(rooms[i][j] != null) System.out.println("f [" + i + "," + j + "] : " + rooms[i][j].getHasDoor()[0] + ", " + rooms[i][j].getHasDoor()[1] + ", " + rooms[i][j].getHasDoor()[2] + ", " + rooms[i][j].getHasDoor()[3] + "\n");
				
			}
		}
		
		grid.printGrid();
		
	}

}
