package elsotano.locations;

import java.util.ArrayList;
import java.util.Random;

public class Floor {

	private boolean[][] hasNode = new boolean[15][15]; //TODO delete this cuz we have node array
	private Node[][] candidates = new Node[16][16];
	private Node[][] definitive = new Node[15][15];
	private Node start;
	private int nodeCounter;
	int candidateCounter;
	
	private class Node {
		
		Room room;
		
		int quantity;
		
		int id;
		boolean checked;
		
		Node right;
		Node left;
		Node up;
		Node down;
		Node prev;
		
		int row;
		int col;
		
		ArrayList<Node> routing;// = new ArrayList<Node>(15); //TODO Change to array, or not, might be more than 15 not yet created nodes, maybe change to char, change limits to avoid outoffbounds with more nodes comming
		ArrayList<Integer> distance;// = new ArrayList<Integer>(15);
		
		public Node() {
			
			routing = new ArrayList<Node>(43);
			distance = new ArrayList<Integer>(43);
			right = null;
			left = null;
			up = null;
			down = null;
			
			for(int i = 0; i < 28; i++) {
				
				routing.add(right);
				distance.add(Integer.MAX_VALUE);
				
			}
			
		}
		
		
	}
	
	public Floor() { //TODO delete routing, not distance
		
		candidateCounter = 0;
		nodeCounter = 2;
		
		hasNode[0][0] = true;
		hasNode[0][1] = true;
		hasNode[1][0] = true;
		
		start = new Node();
		start.id = 0;
		start.room = new Room();
		start.row = 0;
		start.col = 0;
		start.distance.set(0,0);
		
		start.right = new Node();
		start.down = new Node();
		
		definitive[0][0] = start;
		definitive[0][1] = start.right;
		definitive[1][0] = start.down;
		
		start.right.room = new Room();
		start.down.room = new Room();
		start.right.left = start;
		start.down.up = start;
		start.down.id = 1;
		start.right.id = 2;
		start.down.distance.set(1,0);
		start.right.distance.set(2,0);
		start.down.row = 1;
		start.down.col = 0;
		start.right.row = 0;
		start.right.col = 1;
		
		for(int i = 0; i < 12; i++) { //TODO Reset node saves for new fillRouting
			
			fillRouting(start);
			chooseCandidate();
			
		}
		
	}
	
	private void chooseCandidate() { //TODO Method link candidate
		
		Random random = new Random();
		int randomInt = random.nextInt(candidateCounter);
		int randomCounter = 0;
		//TODO Print road direction
		for(int i = 0; i < 16; i++) {
			for(int j = 0; j < 16; j++) {
				
				if(candidates[i][j] != null) { //TODO Remove this if
					
					for(int k = 0; candidates[i][j] != null && k < candidates[i][j].quantity; k++) {
						
						if(randomInt == randomCounter) {
							
							System.out.println("iteration " + i + ", " + j); //TODO fix 2,0 always 'u'
							Node connectedTo = chooseRoad(i, j);
							char direction = chooseDirection(connectedTo, i, j);
							
							Node backPropagation = connectedTo;
							
							while(backPropagation.prev != null) {
								
								backPropagation.checked = false;
								backPropagation = backPropagation.prev;
								
							}
							
							System.out.println("["+ i + "," + j + "] : " + countRoutes(i, j) + ", direction = " + direction);
							
							definitive[i][j] = candidates[i][j];
							hasNode[i][j] = true;
							
							switch(direction) {
							
								case 'u' : 
									candidates[i][j].up = connectedTo;
									connectedTo.down = candidates[i][j];
									break;
									
								case 'd' : 
									candidates[i][j].down = connectedTo;
									connectedTo.up = candidates[i][j];
									break;
									
								case 'l' : 
									candidates[i][j].left = connectedTo;
									connectedTo.right = candidates[i][j];
									break;
									
								case 'r' :
									candidates[i][j].right = connectedTo;
									connectedTo.left = candidates[i][j];
									break;
									
								default : System.out.println("Algo falla"); break;
								
							}

							candidateCounter -= candidates[i][j].quantity;
							candidates[i][j] = null;
							
						}
						
						randomCounter++;
						
					}
					
				}
				
			}
		}
		
		for(int i = 0; i < 15; i++) {
			for(int j = 0; j < 15; j++) {
				
				if(definitive[i][j] != null) System.out.print(definitive[i][j].id + ", ");
				
			}
		}
		
		System.out.println();
		System.out.println();
		
	}
	
	private int countRoutes(int i, int j) { //TODO Dont count candidates for fillRouting
		
		int ret = 0;
		
		if(candidates[i][j].row > 0 && hasNode[ candidates[i][j].row - 1][ candidates[i][j].col ]) ret++;
		if(hasNode[ candidates[i][j].row + 1][ candidates[i][j].col ]) ret++;
		if(candidates[i][j].col > 0 && hasNode[ candidates[i][j].row][ candidates[i][j].col - 1]) ret++;
		if(hasNode[ candidates[i][j].row][ candidates[i][j].col + 1]) ret++;
		
		return ret;
		
	}
	
	private char chooseDirection(Node node, int i, int j) {
		
		char ret = ' ';
		
		if(i > 0 && node == definitive[i - 1][j]) ret = 'u';
		if(node == definitive[i + 1][j]) ret = 'd';
		if(j > 0 && node == definitive[i][j - 1]) ret = 'l';
		if(node == definitive[i][j + 1]) ret = 'r';
		
		return ret;
		
	}
	
	private Node chooseRoad(int i, int j) {
		
		Node ret = new Node();
		int routes = countRoutes(i, j);
		
		Random random = new Random();
		int randomInt = random.nextInt(routes);
		int randomCounter = 0;
		
		if(candidates[i][j].row > 0 && hasNode[ candidates[i][j].row - 1][ candidates[i][j].col ]) {
			
			if(randomCounter == randomInt) ret = definitive[i - 1][j];
					
			randomCounter++;
			
		}
		
		if(hasNode[ candidates[i][j].row + 1][ candidates[i][j].col ]) {
			
			if(randomCounter == randomInt) ret = definitive[i + 1][j];
					
			randomCounter++;
			
		}
		
		if(candidates[i][j].col > 0 && hasNode[ candidates[i][j].row][ candidates[i][j].col - 1]) {
			
			if(randomCounter == randomInt) ret = definitive[i][j - 1];
					
			randomCounter++;
			
		}
		
		if(hasNode[ candidates[i][j].row][ candidates[i][j].col + 1]) {
			
			if(randomCounter == randomInt) ret = definitive[i][j + 1];
					
			randomCounter++;
			
		}
		
		return ret;
		
	}
	
	private void fillRouting(Node node) { 
		//TODO Make this all into one big thing with a var telling which side it is Node next = node.up;
		//TODO Make methods to make this more understandable
		
		//UP
 		if(node.row > 0 && 
		  ((node.prev != null && node.prev != node.up) || node.prev == null) &&
		  //!hasNode[node.row - 1][node.col] &&
		  ((node.up != null && !node.up.checked) || node.up == null)) {
			
			if(node.up != null) {
				
				node.routing.set(node.up.id, node.up);
				node.distance.set(node.up.id, 1);
				node.up.prev = node;
				fillRouting(node.up); 
				
				for(Node n : node.up.routing) {
					
					if(n != node && n != null &&  node.routing.get(n.id) == null) {
						
						node.routing.set(n.id, node.up);
						node.distance.set(n.id, node.up.distance.get(n.id) + 1);
						//TODO CORRECT DISTANCES
					}
					else if(n != node && n != null &&  node.distance.get(n.id) > node.up.distance.get(n.id) + 1) {
						
						node.routing.set(n.id, node.up);
						node.distance.set(n.id, node.up.distance.get(n.id) + 1);
						
					}
					
				}
				
			}else if(node.row > 0 && !hasNode[node.row - 1][node.col]){
				
				if(candidates[node.row - 1][node.col] != null) {
				
					candidates[node.row - 1][node.col].quantity++;
					//node.routing.set(index, element);
				
				}else {
				
					nodeCounter++;
					
					Node up = new Node(); //Dont create the node yet, just save reference
					up.id = nodeCounter;
					up.room = new Room();
					up.col = node.col;
					up.row = node.row - 1;
					up.distance.set(nodeCounter, 0);
					
					node.routing.set(nodeCounter, up);
					node.distance.set(nodeCounter, 1);
					
					candidates[node.row - 1][node.col] = up; //TODO put var names for node.up blablabla
					up.quantity = 1;
					
				}

				candidateCounter++;
				
			}
			
			
		}
		
		//DOWN
		if(((node.prev != null && node.prev != node.down) || node.prev == null) &&
		  ((node.down != null && !node.down.checked) || node.down == null)) {
					
			if(node.down != null) {
						
				node.routing.set(node.down.id, node.down);
				node.distance.set(node.down.id, 1);
				node.down.prev = node;
				fillRouting(node.down); 
				
				for(Node n : node.down.routing) {
					
					if(n != node && n != null && node.routing.get(n.id) == null) {
								
						node.routing.set(n.id, node.down);
						node.distance.set(n.id, node.down.distance.get(n.id) + 1);
							
					}
					else if(n != node && n != null && node.distance.get(n.id) > node.down.distance.get(n.id) + 1) {
								
						node.routing.set(n.id, node.down);
						node.distance.set(n.id, node.down.distance.get(n.id) + 1);
								
					}
							
				}
						
			}else if(!hasNode[node.row + 1][node.col]) {
						
				if(candidates[node.row + 1][node.col] != null) { //TODO FIX WEIGHTS, checks if a node already counted a candidate
					//TODO Too many left, dont know if its just bad luck //too many in first row
					
					candidates[node.row + 1][node.col].quantity++;
					//node.routing.set(index, element);
				
				}else {
				
					nodeCounter++;
					
					//TODO Rows and columns and save multiple roads to same node in grid
					Node down = new Node(); //Dont create the node yet, just save reference
					down.id = nodeCounter;
					down.room = new Room();
					down.col = node.col;
					down.row = node.row + 1;
					down.distance.set(nodeCounter, 0);
					
					node.routing.set(nodeCounter, down);
					node.distance.set(nodeCounter, 1);
					
					candidates[node.row + 1][node.col] = down;
					down.quantity = 1;
					
				}

				candidateCounter++;
				
			}
					
					
		}
		
		
		//RIGHT
		if(((node.prev != null && node.prev != node.right) || node.prev == null) &&
		  //!hasNode[node.row][node.col+1] &&
		  ((node.right != null && !node.right.checked) || node.right == null)) {
					
			if(node.right != null) {

				node.routing.set(node.right.id, node.right);
				node.distance.set(node.right.id, 1);
				node.right.prev = node;
				fillRouting(node.right); 
				
				for(Node n : node.right.routing) {
							
					if(n != node && n != null && node.routing.get(n.id) == null) {
								
						node.routing.set(n.id, node.right);
						node.distance.set(n.id, node.right.distance.get(n.id) + 1);
							
					}
					else if(n != node && n != null && node.distance.get(n.id) > node.right.distance.get(n.id) + 1) {
								
						node.routing.set(n.id, node.right);
						node.distance.set(n.id, node.right.distance.get(n.id) + 1);
								
					}
							
				}
						
			}else if(!hasNode[node.row][node.col + 1]) {
						
				if(candidates[node.row][node.col + 1] != null) {
					
					candidates[node.row][node.col + 1].quantity++;
					//node.routing.set(index, element);
				
				}else {
				
					nodeCounter++;
					
					Node right = new Node(); //Dont create the node yet, just save reference
					right.id = nodeCounter;
					right.room = new Room();
					right.col = node.col + 1;
					right.row = node.row;
					right.distance.set(nodeCounter, 0);
					
					node.routing.set(nodeCounter, right);
					node.distance.set(nodeCounter, 1);
					
					candidates[node.row][node.col + 1] = right;
					right.quantity = 1;
					
				}

				candidateCounter++; 
				
			}
					
					
		}
		
		//LEFT
		if((node.col > 0 &&
 		  (node.prev != null && node.prev != node.left) || node.prev == null) &&
		  //!hasNode[node.row][node.col+1] &&
		  ((node.left != null && !node.left.checked) || node.left == null)) {
					
			if(node.left != null) {

				node.routing.set(node.left.id, node.left);
				node.distance.set(node.left.id, 1);
				node.left.prev = node;
				fillRouting(node.left); 
				
				for(Node n : node.left.routing) {
							
					if(n != node && n != null && node.routing.get(n.id) == null) {
								
						node.routing.set(n.id, node.left);
						node.distance.set(n.id, node.left.distance.get(n.id) + 1);
							
					}
					else if(n != node && n != null && node.distance.get(n.id) > node.left.distance.get(n.id) + 1) {
								
						node.routing.set(n.id, node.left);
						node.distance.set(n.id, node.left.distance.get(n.id) + 1);
								
					}
							
				}
						
			}else if(node.col > 0 && !hasNode[node.row][node.col - 1]) {
						
				if(candidates[node.row][node.col - 1] != null) {
					
					candidates[node.row][node.col - 1].quantity++;
					//node.routing.set(index, element);
				
				}else {
				
					nodeCounter++;
					
					Node left = new Node(); //Dont create the node yet, just save reference
					left.id = nodeCounter;
					left.room = new Room();
					left.col = node.col - 1;
					left.row = node.row;
					left.distance.set(nodeCounter, 0);
					
					node.routing.set(nodeCounter, left);
					node.distance.set(nodeCounter, 1);
					
					candidates[node.row][node.col - 1] = left;
					left.quantity = 1;
					
				}

				candidateCounter++; 
				
			}
					
					
		}
		
		node.checked = true;
		System.out.println(node.id + " : " + node.routing.toString());
		System.out.println(node.id + " : " + node.distance.toString());
		System.out.print("Candidates: ");
		
		for(int i = 0; i < 16; i++) {
			for(int j = 0; j < 16; j++) {
				
				if(candidates[i][j] != null) System.out.print("id " + candidates[i][j].id + " = " + candidates[i][j].quantity + ", ");
				
			}
		}
		
		System.out.println();
		
		System.out.println();
		
	}
	
}
