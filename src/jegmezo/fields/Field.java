package jegmezo.fields;
import java.util.ArrayList;
import java.util.List;

import jegmezo.Direction;
import jegmezo.Shelter;
import jegmezo.avatars.*;
import jegmezo.items.*;

public abstract class Field {

	private int snowAmount;
	protected int capacity;
	private Shelter shelter = Shelter.None;
	public List<Avatar> avatars = new ArrayList<Avatar>();
	public Item item;
	private List<Field> neighbours = new ArrayList <Field>();
	private int durability;
	protected boolean kills;
	public int id;
	protected String name;
	
	
	/*
	 * TODO
	 * Kezdetben még legyen mindenstatikus
	 * Levente
	 */
	
	public boolean getKills() {
		return kills;
	}
	
	public Field(){	
		capacity = -1;
	}
	
	
	public Field(String _name){	
		name = _name;
		capacity = -1;
	}
	
	public void setDurability(int i) {
		durability = i;
	}
	
	public boolean decrementDurability() {
		if(shelter == Shelter.Tent)
			durability--;
		if(durability == 0) {
			this.setShelter(Shelter.None);
			return true;
		}
		
		return false;
	}
	
	public boolean accept() {
		System.out.println("<Field.accept()");
		System.out.println("Nem Border");
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
	public void removeItem() {
		System.out.println("<Field.removeItem()");
		item = new EmptyItem();
		System.out.println(">Field.removeItem()");
	}
	
	public Item switchItem(Item i) {
		System.out.println("<Field.switchItem()");
		Item tmp;
		tmp = item;
		item = i;
		System.out.println(">Field.switchItem()");
		return tmp;
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
		System.out.println("<Field.getSnowAmount()");
		System.out.println(">Field.getSnowAmount()");
		return snowAmount;
	}
	
	/*
	 * setter
	 * Levente
	 */
	
	public void setShelter(Shelter sh) {
		System.out.println("<Field.setShelter()");
		this.shelter = sh;
		System.out.println(">Field.setShelter()");
	}
	
	public Shelter getShelter() {
		return shelter;
	}
	
	/*
	 * getter
	 * Levente
	 */
	
	public int getCapacity() {
		System.out.println("<Field.getCapacity()");
		System.out.println("Capacity: " + capacity);
		System.out.println(">Field.getCapacity()");
		return capacity;
	}
	
	public String getName() {
		return name;
	}
	
	
}
