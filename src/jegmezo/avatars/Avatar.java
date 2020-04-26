package jegmezo.avatars;
import jegmezo.fields.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import jegmezo.Direction;
import jegmezo.GameEnder;
import jegmezo.Test;
import jegmezo.items.*;

public abstract class Avatar {
	
	protected Field field;
	private List<Item> backpack = new ArrayList<Item>();
	private int activityPoints;
	private int durability;
	public boolean EndTurn = false;
	public boolean wearsWetsuit = false;
	public GameEnder gameEnder;
	protected int healthPoints;
	protected String name;
	private boolean NPC = false;
	
	
	/*
	 * mindenkinek 4 activityPoints-a van, bár ez állítható
	 * Levente
	 */
	
	public Avatar(String _name) {	
		backpack = new LinkedList<Item>();
		name = _name;
		activityPoints = 4;
	}
	
	
	/*public Avatar(String _name, BufferedWriter bw) {	
		backpack = new LinkedList<Item>();
		name = _name;
		activityPoints = 4;
	}*/
	
	public void setNPC(boolean b) {
		this.NPC = b;
	}
	
	public boolean getNPC() {
		return NPC;
	}
	
	
	public List<Item> getBackpack(){
		return backpack;
	}
	
	public void setDurability(int i) {
		durability = i;
	}
	
	public void decrementDurability() {
		if(this.field.getKills())
			durability--;
		if(durability == 0)
			gameEnder.endGame();
	}
	
	protected void dropItem() throws IOException{
		System.out.println("Which Item, please enter a number");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String i = br.readLine();
		
		while(Integer.parseInt(i) > backpack.size()) {
			System.out.println("Again, please");
			try {
				i = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		backpack.add(field.switchItem(backpack.remove(Integer.parseInt(i))));
	}

	
	/*
	 * a backpack lancolt lista vegere fuzi az itemet
	 * Levente
	 */
	
	public void addToBackpack() {
		System.out.println("<Avatar.addToBackpack()");
		backpack.add(field.item);
		
		try {
			Test.bw.write(field.item + " added to backpack");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		field.removeItem();
		System.out.println(">Avatar.addToBackpack()");
	}
	
	public void removeFromBackpack(Item i) {
		backpack.remove(i);
	}
	
	/*
	 * használja az adott itemet, aktivitasa no
	 * Levente
	 */
	public void useItem() throws NumberFormatException, IOException {
		System.out.println("<Avatar.useItem()");
		System.out.println("Hanyas itemet hasznaljam?");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int command = Integer.parseInt(br.readLine());
    	backpack.get(command).use(this);
		this.setActivity(1);
		System.out.println(">Avatar.useItem()");
	}
	
	/*
	 * adott item hasznalata ha az a hatizsakban van
	 * Hanga
	 */
	public void useItem(Item item) {
		System.out.println("<Avatar.useItem()");
		int indexOfItem = backpack.indexOf(item);
		if(indexOfItem!=null) {
			backpack.get(indexOfItem).use(this);
		this.setActivity(1);
		}
		else {
			System.out.println("No such item.");
		}
		System.out.println(">Avatar.useItem()");
	}
	
	/*
	 * TODO	public Field field;

	 * Meg kell hívni a gameEnder endGame()-jét de nem tudom, azt látja-e
	 * Várni kell majd előbb egy kört
	 */
	public void dieByWater() {
		System.out.println("<Avatar.dieByWater()");
		if(!wearsWetsuit)
		gameEnder.endGame();
		System.out.println(">Avatar.dieByWater()");
	}
	
	/*
	* Kihűl, elhalálozik
	* Zoli
	*/
	public void instantDeath() {
		System.out.println("<Avatar.dieByHeatLoss()");
		gameEnder.endGame();
		System.out.println(">Avatar.dieByHeatLoss()");
	}
	
	/*
	 * Eletero novekszik etel hatiasara
	 * Levente 
	 */
	public void gainHealth() {
		System.out.println("<Avatar.gainHealth()");
		healthPoints++;
		System.out.println(">Avatar.gainHealth()");
	}
	
	/*
	 * hp vesztes, ha 0 meghal heatLoss-ban
	 * Levente
	 */
	public void loseHealth() {
		System.out.println("<Avatar.loseHealth()");
		healthPoints--;
		if(healthPoints == 0)
			this.instantDeath();
		System.out.println(">Avatar.loseHealth()");
	}
	
	/*
	 * getter
	 * Levente
	 */
	public Field getField() {
		System.out.println("<Avatar.getField()");
		System.out.println(">Avatar.getField()");
		return field;
	}
	
	/*
	 * d irányba elmozdul ha tud (csak akkor nem tud ha határmező van ott) 
	 * Levente
	 */
	public void move(Direction d){
		System.out.println("<Avatar.move()");
		System.out.println("ezen a mezon allok: " + this.field.id);
		if(this.field.getKills() == false) {
			if(this.field.getNeighbour(d).accept()) {
				try {
					field.getNeighbour(d).addAvatar(this);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				field.removeAvatar(this);
				field = field.getNeighbour(d);
				this.setActivity(1);
			}
		}else {
			this.endTurn();
		}
		System.out.println("ezen a mezon allok: " + this.field.id);
		try {
			Test.bw.write(this.name + " moved to the " +  d.toString() + "\n");
		}catch (NullPointerException e) {
			System.out.println(e);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(">Avatar.move()");
	}
	
	/*
	 * Ezt tudtam kitalalni arra hogy "szol controllernek"
	 * Benedek
	 */
	public void endTurn() {
		System.out.println("<Avatar.endTurn()");
		this.activityPoints = 4;
		this.EndTurn = true;
		System.out.println(">Avatar.endTurn()");
	}
	public void setEndTurn() {
		this.EndTurn = false;
	}
	
	/*
	 *  Az activityPoints atributumhoz hozzadja (levonja)
	 * azt amennyi kell a munka végrehajtásához.
	 * Ha kifogy, meghívódik az endTurn()	
	 * Levente															
	 */
	
	public void setActivity(int i) {
		System.out.println("<Avatar.setActivity()");
		activityPoints -= i;
		System.out.println(activityPoints);
		if(activityPoints <= 0) {
			this.endTurn();
		}
		System.out.println(">Avatar.setActivity()");
	}
	
	public String getName() {
		return name;
	}
	
	public void setField(Field _field) {
		field = _field;
		try {
			Test.bw.write(field.getName() + " has " + this.name + "\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public abstract int specialMove();
}
