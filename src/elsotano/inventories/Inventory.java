package elsotano.inventories;

import java.util.Iterator;

public class Inventory<T> implements Iterable<T>{ //TODO ORDENACION

	private int size;
	private T[] inventory;
	
	public Inventory(){
		
		size = 0;
		inventory = (T[]) new Object[10];
		
	}
	
	public Inventory(int initSize){
		
		size = 0;
		inventory = (T[]) new Object[initSize];
		
	}
	
	boolean isEmpty() { return size == 0; }
	int getSize() { return size; }
	public T peek(int index) { return inventory[index]; }
	
	public void add(T item) {
		
		if(size >= inventory.length) resize(size * 2);
		inventory[size++] = item;
		
	}
	
	public boolean remove(T item) {
		
		boolean ret = false;
		int index = -1;
		
		for(int i = 0; i < size; i++) {
			
			if(inventory[i] == item) {
		
				index = i;
				ret = true;
			
			}
			
		}
		
		if(ret) shiftLeftFromIndex(index + 1);	
		
		return ret;
		
	}
	
	public T remove(int index) {
		
		T item = inventory[index]; //TODO RESIZE
		
		shiftLeftFromIndex(index + 1);
		
		return item;
		
	}
	
	private void resize(int max) {
		
		T[] inventory_ = (T[]) new Object[max]; 
		for(int i = 0; i < size; i++) inventory_[i] = inventory[i];
		inventory = inventory_;
		
	}
	
	private void shiftLeftFromIndex(int index) {
		
		for(int i = index; index > 0 && i < inventory.length; i++) {
			
			inventory[i-1] = inventory[i];
			
		}
		
		inventory[--size] = null;
		if(size > 0 && size <= inventory.length / 4) resize(inventory.length / 2);
		
	}
	
	public Iterator<T> iterator(){
		
		return new ReversedIterator(); 
		
	}
	
	private class ReversedIterator implements Iterator<T>{
		
		private int i = size;
		
		public T next() { return inventory[--i]; }
		public boolean hasNext() { return i > 0; }
		
	}
	
}
