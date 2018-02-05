package elsotano.resources;

public class Grid {

	private short rows;
	private short cols;
	private byte[][] tile;
	
	public Grid(int cols, int rows) {
		
		this((short)cols, (short)rows);
		
	}
	
	public Grid(short cols, short rows) {
		
		this.rows = rows;
		this.cols = cols;
		
		tile = new byte[cols][rows];
		System.out.println(rows + ", " + cols);
		
	}
	
	
	public void setTile(int tile, int x, int y) {
		
		setTile((byte)tile, (short)x, (short)y);
		
	}
	
	public void setTile(byte tile, short x, short y) {
		
		this.tile[x][y] = tile;
		
	}
	
	private void printTileChar(short x, short y){
		
		switch(tile[x][y]) {
		
			case 0 : System.out.print(" "); break;
			case 1 : System.out.print("═"); break;
			case 2 : System.out.print("║"); break;
			case 3 : System.out.print("╔"); break;
			case 4 : System.out.print("╗"); break;
			case 5 : System.out.print("╚"); break;
			case 6 : System.out.print("╝"); break;
			case 7 : System.out.print("╬"); break;
			case 8 : System.out.print("╠"); break;
			case 9 : System.out.print("╣"); break;
			case 10 : System.out.print("╦"); break;
			case 11 : System.out.print("╩"); break;
			case 12 : System.out.print("^"); break;
			
		}
		
	}
	
	public void printGrid() {
		int rowCount = 0;
		
		//System.out.print("    ");
		//for(short i = 0; i < cols; i++) {
			
			//System.out.print(i/10); //poner hacia abajo 
			
		//}
		
		//System.out.println();
		
		//System.out.print("    ");
		//for(short i = 0; i < cols; i++) {
			
			//System.out.print(i%10); //poner hacia abajo 
			
		//}
		
		System.out.println();
		
		for(short i = 0; i < rows; i++) {
			
			/*if(rowCount < 10) System.out.print(rowCount +"   ");
			else if(rowCount < 100) System.out.print(rowCount +"  ");
			else if(rowCount < 1000) System.out.print(rowCount +" ");*/
			
			for(short j = 0; j < cols; j++) {
			
				printTileChar(j, i);
				
			}
			
			System.out.println();
			rowCount++;
		}
		
	}
	

	public void rect(int x, int y, int width, int height) {
		
		rect((short)x, (short)y, (short)width, (short)height);
		
	}
	
	/** Prints a rectangle into the Grid using UTF-8 double line box drawing characters
	 * 
	 * @param x x coordinate of the up left corner of the rectangle
	 * @param y y coordinate of the up left corner of the rectangle
	 * @param width width of the rectangle
	 * @param height height of the rectangle
	 * 
	 */
	
	public void rect(short x, short y, short width, short height) { //COMENTAR MEJOR TODO ESTO Y ORDENAR
		
		if(tile[x][y] == 2 || tile[x][y] == 5 || tile[x][y] == 8) tile[x][y] = 8;
		else if(tile[x][y] == 1 || tile[x][y] == 4 || tile[x][y] == 10) tile[x][y] = 10;  
		else if(tile[x][y] == 6 || tile[x][y] == 9 || tile[x][y] == 11 || tile[x][y] == 7) tile[x][y] = 7; //╬
		else tile[x][y] = 3;                                             //╔
		
		hLine((short)(x+1), y, (short)(width-2));                   //═
		hLine((short)(x+1), (short)(y+height-1), (short)(width-2)); //═
		
		if(tile[x+width-1][y] == 2 || tile[x+width-1][y] == 6 || tile[x+width-1][y] == 9) tile[x+width-1][y] = 9;
		else if(tile[x+width-1][y] == 1 || tile[x+width-1][y] == 3 || tile[x+width-1][y] == 10) tile[x+width-1][y] = 10;  //╦
		else if(tile[x+width-1][y] == 5 || tile[x+width-1][y] == 8 || tile[x+width-1][y] == 11 || tile[x+width-1][y] == 7) tile[x+width-1][y] = 7;
		else tile[x+width-1][y] = 4;                                     //╗
		
		vLine(x, (short)(y+1), (short)(height-2));                  //║
		vLine((short)(x+width-1), (short)(y+1), (short)(height-2)); //║
		
		if(tile[x][y+height-1] == 2 || tile[x][y+height-1] == 3 || tile[x][y+height-1] == 8) tile[x][y+height-1] = 8;        //╠
		else if(tile[x][y+height-1] == 1 || tile[x][y+height-1] == 6 || tile[x][y+height-1] == 11) tile[x][y+height-1] = 11;  //╩
		else if(tile[x][y+height-1] == 4 || tile[x][y+height-1] == 9 || tile[x][y+height-1] == 10 || tile[x][y+height-1] == 7) tile[x][y+height-1] = 7;
		else tile[x][y+height-1] = 5;                                    //╚
		
		if(tile[x+width-1][y+height-1] == 2 || tile[x+width-1][y+height-1] == 4 || tile[x+width-1][y+height-1] == 9) tile[x+width-1][y+height-1] = 9; //╣
		else if(tile[x+width-1][y+height-1] == 1 || tile[x+width-1][y+height-1] == 5 || tile[x+width-1][y+height-1] == 11) tile[x+width-1][y+height-1] = 11;
		else if(tile[x+width-1][y+height-1] == 3 || tile[x+width-1][y+height-1] == 8 || tile[x+width-1][y+height-1] == 10 || tile[x+width-1][y+height-1] == 7) tile[x+width-1][y+height-1] = 7;
		else tile[x+width-1][y+height-1] = 6;                            //╝
		
	}
	
	public void hLine(short x, short y, short length) { //HACER CAMBIOS PARA CUANDO SE ENCUENTRAN CON ESQUINAS Y PARA LIMITES SIN CUADRADO
		
		for(short i = x; i < x + length; i++) {
			
			if(tile[i][y] == 2 || tile[i][y] == 7 || tile[i][y] == 8 || tile[i][y] == 9) tile[i][y] = 7; //╬
			else if(tile[i][y] == 3 || tile[i][y] == 4 || tile[i][y] == 10) tile[i][y] = 10; //╦
			else if(tile[i][y] == 5 || tile[i][y] == 6 || tile[i][y] == 11) tile[i][y] = 11; //╩
			else tile[i][y] = 1;                //═
			
		}
		
	}
	
	public void vLine(short x, short y, short length) { //COMENTAR TODO MEJOR Y HACER JAVADOC
		//TO DO 1 HACER QUE SI EL PRIMER O ULTIMO CARACTER COINCIDEN CON LA LINEA PERPENDICULAR, PONGA LA T Y NO EL CRUCE, SI NO ES DE UN CUADRADO
		for(short i = y; i < y + length; i++) {
			
			if(tile[x][i] == 1 || tile[x][i] == 7 || tile[x][i] == 10 || tile[x][i] == 11) tile[x][i] = 7; //╬
			else if(tile[x][i] == 3 || tile[x][i] == 5 || tile[x][i] == 8) tile[x][i] = 8; //╠
			else if(tile[x][i] == 4 || tile[x][i] == 6 || tile[x][i] == 9) tile[x][i] = 9; //╣
			else tile[x][i] = 2;                //║
			
		}
		
	}
	
	public void drawRoom(int row, int col, boolean[] hasDoor) {
		
		 rect(row * 9, col * 4, 10, 5);
		 
		 System.out.println("f [" + row + "," + col + "] : " + hasDoor[0] + ", " + hasDoor[1] + ", " + hasDoor[2] + ", " + hasDoor[3]);
		 
		 if(hasDoor[0]) {
			 
			 tile[row * 9 + 4][col * 4] = 0;
			 tile[row * 9 + 5][col * 4] = 0;
			 
		 }
		 
		 if(hasDoor[1]) {
			 
			 tile[row * 9 + 9][col * 4 + 2] = 0;
			 
		 }
		 
		 if(hasDoor[2]) {
			 
			 tile[row * 9 + 4][col * 4 + 4] = 0;
			 tile[row * 9 + 5][col * 4 + 4] = 0;
			 
		 }
		 
		 if(hasDoor[3]) {
			 
			 tile[row * 9][col * 4 + 2] = 0;
			 
		 }
		
	}


}