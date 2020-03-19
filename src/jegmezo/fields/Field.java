package jegmezo.fields;
import java.util.List;

import jegmezo.Direction;
import jegmezo.avatars.*;
import jegmezo.items.*;

public abstarct class Field {

	private int snowAmount;
	private int capacity;
	private boolean Igloo;
	public List<Avatar> avatars;
	public Item item;
	private List<Field> neighbours;
	
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
	* Ide kell majd egy setNeighbour(), ami kap egy Field-et, ami a szomszédja lesz és
	* egy Direction-t, hogy tudja, melyik szomszédja. 
	* A Field-et berakja a neighbours-ba és jó. 
	* Majd megcsinálom, csak ezt előbb ide akartam tenni, hogy meglegyen az elképzelés.
	* Zoli
	*/
	
	/*
	 * setter
	 * Levente
	 */
	public void setSnow(int i) {
		System.out.println("<Field.setSnow()");
		snowAmount += i;
		System.out.println(">Field.setSnow()");
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
