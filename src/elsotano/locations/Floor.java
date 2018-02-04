package elsotano.locations;

import java.util.ArrayList;
import java.util.Random;

public class Floor {

	private boolean[][] hasNode = new boolean[15][15];
	private Node[][] candidates = new Node[16][16];
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
	
	public Floor() {
		
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
		
		fillRouting(start);
		chooseCandidate();
		
	}
	
	private void chooseCandidate() {
		
		Random random = new Random();
		int randomInt = random.nextInt(candidateCounter);
		int randomCounter = 0;
		
		for(int i = 0; i < 16; i++) {
			for(int j = 0; j < 16; j++) {
				
				if(candidates[i][j] != null) {
					
					if(randomInt == randomCounter) {
						
						//candidates[i][j] //TODO Link to correct node, make weights correct
						
					}else randomCounter++;
						
					
				}
				
			}
		}
		
	}
	
	private void fillRouting(Node node) { 
		//TODO Make this all into one big thing with a var telling which side it is Node next = node.up;
		
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
					
					if(n != node && node.routing.get(n.id) == null) {
						
						node.routing.set(n.id, node.up);
						node.distance.set(n.id, node.up.distance.get(n.id) + 1);
						
					}
					else if(n != node && node.distance.get(n.id) > node.up.distance.get(n.id) + 1) {
						
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
					
					node.up = new Node(); //Dont create the node yet, just save reference
					node.up.id = nodeCounter;
					node.up.room = new Room();
					node.up.col = node.col;
					node.up.row = node.row - 1;
					node.up.distance.set(nodeCounter, 0);
					
					node.routing.set(nodeCounter, node.up);
					node.distance.set(nodeCounter, 1);
					
					candidates[node.row - 1][node.col] = node.up; //TODO put var names for node.up blablabla
					node.up.quantity = 1;
					
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
						
				if(candidates[node.row + 1][node.col] != null) {
					
					candidates[node.row + 1][node.col].quantity++;
					//node.routing.set(index, element);
				
				}else {
				
					nodeCounter++;
					
					//TODO Rows and columns and save multiple roads to same node in grid
					node.down = new Node(); //Dont create the node yet, just save reference
					node.down.id = nodeCounter;
					node.down.room = new Room();
					node.down.col = node.col;
					node.down.row = node.row + 1;
					node.down.distance.set(nodeCounter, 0);
					
					node.routing.set(nodeCounter, node.down);
					node.distance.set(nodeCounter, 1);
					
					candidates[node.row + 1][node.col] = node.down;
					node.down.quantity = 1;
					
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
					
					node.right = new Node(); //Dont create the node yet, just save reference
					node.right.id = nodeCounter;
					node.right.room = new Room();
					node.right.col = node.col + 1;
					node.right.row = node.row;
					node.right.distance.set(nodeCounter, 0);
					
					node.routing.set(nodeCounter, node.right);
					node.distance.set(nodeCounter, 1);
					
					candidates[node.row][node.col + 1] = node.right;
					node.right.quantity = 1;
					
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
					
					node.left = new Node(); //Dont create the node yet, just save reference
					node.left.id = nodeCounter;
					node.left.room = new Room();
					node.left.col = node.col - 1;
					node.left.row = node.row;
					node.left.distance.set(nodeCounter, 0);
					
					node.routing.set(nodeCounter, node.left);
					node.distance.set(nodeCounter, 1);
					
					candidates[node.row][node.col - 1] = node.left;
					node.left.quantity = 1;
					
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
