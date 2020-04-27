package jegmezo.fields;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jegmezo.Direction;
import jegmezo.Shelter;
import jegmezo.Test;
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
	
	/**
	 * Kills - Getter
	 * 
	 * @return kills
	 */
	public boolean getKills() {
		return kills;
	}
	
	/**
	 * Field konstruktora:
	 * Beallitja a kapacitast 
	 */
	public Field(){	
		capacity = -1;
	}
	
	/**
	 * Field konstruktora:
	 * Beallitja a nevet es a kapacitast
	 * 
	 * @param _name Adott field neve / azonositoja
	 */
	public Field(String _name){	
		name = _name;
		capacity = -1;
	}
	
	/**
	 * Durability - Setter 
	 * 
	 * @param i Ennyire allitja a durability-t
	 */
	public void setDurability(int i) {
		durability = i;
	}
	
	/**
	 * Durability csokkentese eggyel ha az Tent,
	 * ha a durability nullara csokken -> Tent eltunik
	 * az adott fieldrol
	 * 
	 * @return Eltunt-e a Tent a fieldrol (true/false)
	 */
	public boolean decrementDurability() {
		if(shelter == Shelter.Tent)
			durability--;
		if(durability == 0) {
			this.setShelter(Shelter.None);
			return true;
		}
		
		return false;
	}
	
	/**
	 * Accept fuggveny:
	 * A field nem border
	 * 
	 * @return true
	 */
	public boolean accept() {
		System.out.println("<Field.accept()");
		System.out.println("Nem Border");
		System.out.println(">Field.accept()");
		return true;
	}
	
	/**
	 * Avatareltavolitas:
	 * Az adott avatart eltavolitja a fieldrol 
	 * 
	 * @param a Ezt az avatart fogja eltavolitani
	 */
	public void removeAvatar(Avatar a) {
		System.out.println("<Field.removeAvatar()");
		avatars.remove(a);
		System.out.println(">Field.removeAvatar()");
	}
	
	/**
	 * Itemeltavolitas:
	 * Eltavolitja az adott mezon talalhato itemet.
	 * Item helyett EmptyItem lesz
	 */
	public void removeItem() {
		System.out.println("<Field.removeItem()");
		try {
			item = new EmptyItem("EmptyItem");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(">Field.removeItem()");
	}
	
	/**
	 * Itemcsere:
	 * Kicsereli a fielden talalhato itemet a megadottal
	 * 
	 * @param i Erre az itemre fog cserelni
	 */
	public Item switchItem(Item i) {
		System.out.println("<Field.switchItem()");
		Item tmp;
		tmp = item;
		item = i;
		System.out.println(">Field.switchItem()");
		return tmp;
	}
	
	/**
	 * Avatart ad a fieldhez
	 * 
	 * @param a Ezt az avatart teszi a fieldre
	 */
	public void addAvatar(Avatar a) throws IOException {
		System.out.println("<Field.addAvatar()");
		avatars.add(a);
		try {
			Test.bw.write(a.getName() + " placed on: " + this.name + "\n");
		}catch (NullPointerException e) {
			System.out.println(e);
		}
		System.out.println(">Field.addAvatar()");
	}
	
	/**
	 * Neighbour - Getter 
	 *
	 * @param d Ebbe az iranyba kerdezi le a szomszedos mezot
	 * @return A szomszedos mezot adja vissza
	 */
	public Field getNeighbour(Direction d) {
		System.out.println("<Field.getNeighbour()");
		System.out.println(">Field.getNeighbour()");
		return neighbours.get(d.showVal());
	}
	
	/**
	 * Neighbours - Setter:
	 * Kap egy Field-et es befuzi a lista vegere. 
	 * Emiatt a szomszedokat Eszaki, Deli, Keleti es Nyugati sorrendben kell hozzaadni.
	 * 
	 * @param f Beallitja szomszednak az adott mezot
	 */
	public void setNeighbour(Field f) throws IOException {
		System.out.println("<Field.setNeighbour()");
		this.neighbours.add(f);
		try {
			Test.bw.write(this.name + "-" + f.getName() + " binded\n");
		}catch (NullPointerException e) {
			System.out.println(e);
		}
		System.out.println(">Field.setNeighbour()");
	}
	
	/**
	 * SnowAmount - Setter
	 * 
	 * @param i Noveli a snowAmount erteket erre a megadott szamra
	 */
	public void setSnow(int i) {
		System.out.println("<Field.setSnow()");
		snowAmount += i;
		try {
			Test.bw.write("snow fell on this field " + this.name + "\n" );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(">Field.setSnow()");
	}
	
	/**
	 * SnowAmount - Getter 
	 * 
	 * @return snowAmount
	 */
	public int getSnowAmount(){
		System.out.println("<Field.getSnowAmount()");
		System.out.println(">Field.getSnowAmount()");
		return snowAmount;
	}
	
	/**
	 * Shelter - Setter
	 * 
	 * @param sh Erre allitja be a shelter erteket
	 */
	public void setShelter(Shelter sh) {
		System.out.println("<Field.setShelter()");
		this.shelter = sh;
		try {
			Test.bw.write(sh.toString() + " is built\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(">Field.setShelter()");
	}
	
	/**
	 * Shelter - Getter 
	 *
	 * @return shelter
	 */
	public Shelter getShelter() {
		return shelter;
	}
	
	/**
	 * Capacity - Getter
	 * 
	 * @return capacity
	 */
	public int getCapacity() {
		System.out.println("<Field.getCapacity()");
		System.out.println("Capacity: " + capacity);
		System.out.println(">Field.getCapacity()");
		return capacity;
	}
	
	/**
	 * Name - Getter
	 * 
	 * @return Field neve / azonositoja
	 */
	public String getName() {
		return name;
	}
	
}
