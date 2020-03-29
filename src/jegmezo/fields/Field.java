package jegmezo.fields;
import java.util.ArrayList;
import java.util.List;

import jegmezo.Direction;
import jegmezo.avatars.*;
import jegmezo.items.*;

public abstract class Field {

	private int snowAmount;
	private int capacity;
	private boolean Igloo;
	public List<Avatar> avatars = new ArrayList<Avatar>();
	public Item item;
	private List<Field> neighbours = new ArrayList <Field>();
	
	/*
	 * TODO
	 * Kezdetben még legyen mindenstatikus
	 * Levente
	 */
	
	public Field(){

	}
	
	public boolean accept() {
		System.out.println("<Field.accept()");
		System.out.println(">Field.accept()");
		return true;
	}
	
	public void removeAvatar(Avatar a) {
		System.out.println("<Field.removeAvatar()");
		avatars.remove(a);
		System.out.println(">Field.removeAvatar()");
	}
	/*
	 * A regi item helyett emptyItem lesz
	 * Levente
	 */
	public void removeItem(Item i) {
		System.out.println("<Field.removeItem()");
		item = new EmptyItem();
		System.out.println(">Field.removeItem()");
	}
	
	public void addAvatar(Avatar a) {
		System.out.println("<Field.addAvatar()");
		avatars.add(a);
		System.out.println(">Field.addAvatar()");
	}
	
	/*
	 * Elvileg visszater az adott iranyu szomszeddal, nem teszteltem
	 * Levente
	 */
	
	public Field getNeighbour(Direction d) {
		System.out.println("<Field.getNeighbour()");
		System.out.println(">Field.getNeighbour()");
		return neighbours.get(d.showVal());
	}
	
	/*
	* Kap egy Field-et és befuzi a lista vegere. 
	* Emiatt a szomszedokat Eszaki, Deli, Keleti es Nyugati sorrendben kell hozzaadni.
	* Zoli
	*/
	public void setNeighbour(Field f) {
		System.out.println("<Field.setNeighbour()");
		this.neighbours.add(f);
		System.out.println(">Field.setNeighbour()");
	}
	
	/*
	 * setter
	 * Levente
	 */
	public void setSnow(int i) {
		System.out.println("<Field.setSnow()");
		snowAmount += i;
		System.out.println(">Field.setSnow()");
	}
	
	public int getSnowAmount(){
		return snowAmount;
	}
	
	/*
	 * setter
	 * Levente
	 */
	public void setIgloo() {
		System.out.println("<Field.setIgloo()");
		Igloo = !Igloo;
		System.out.println(">Field.setIgloo()");
	}
	
	/*
	 * getter
	 * Levente
	 */
	public int getCapacity() {
		System.out.println("<Field.getCapacity()");
		System.out.println(">Field.getCapacity()");
		return capacity;
	}
	
}
