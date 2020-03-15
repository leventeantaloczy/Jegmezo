package jegmezo.fields;
import jegmezo.Direction;
import jegmezo.avatars.*;
import jegmezo.items.*;

public class Field {
	
	private int snowAmount;
	private int capacity;
	private boolean Igloo;
	public Avatar avatars[];
	public Item item;
	private Field neighbours[];
		
	public boolean accept() {
		System.out.println("<Field.accept()");
		System.out.println(">Field.accept()");
		return true;
	}
	
	public void removeAvatar(Avatar a) {
		System.out.println("<Field.removeAvatar()");
		System.out.println(">Field.removeAvatar()");
	}
	
	public void removeItem(Item i) {
		System.out.println("<Field.removeItem()");
		System.out.println(">Field.removeItem()");
	}
	
	public void addAvatar(Avatar a) {
		System.out.println("<Field.addAvatar()");
		System.out.println(">Field.addAvatar()");
	}
	
	public Field[] getNeighbour(Direction d) {
		System.out.println("<Field.getNeighbour()");
		System.out.println(">Field.getNeighbour()");
		return neighbours;
	}
	
	public void setSnow(int i) {
		System.out.println("<Field.setSnow()");
		System.out.println(">Field.setSnow()");
	}
	
	public void setIgloo() {
		System.out.println("<Field.setIgloo()");
		System.out.println(">Field.setIgloo()");
	}
	
	public int getCapacity() {
		System.out.println("<Field.getCapacity()");
		System.out.println(">Field.getCapacity()");
		return capacity;
	}
	
}