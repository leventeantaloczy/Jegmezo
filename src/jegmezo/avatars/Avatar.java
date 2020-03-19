package jegmezo.avatars;
import jegmezo.fields.*;

import java.util.LinkedList;
import java.util.List;

import jegmezo.Direction;
import jegmezo.items.*;

public abstract class Avatar {
	
	public Field field;
	private List<Item> backpack;
	private int activityPoints;
	private int healthPoints;
	public boolean wearsWetsuit = false;
	
	
	/*
	 * TODO; field beállítása
	 * mindenkinek 4 activityPoints-a van, bár ez állítható
	 * Levente
	 */
	
	public Avatar(int hp) {	
		backpack = new LinkedList<Item>();
		healthPoints = hp;
		activityPoints = 4;
	}
	
	/*
	 * a backpack lancolt lista vegere fuzi az itemet
	 * Levente
	 */
	
	public void addToBackpack(Item i) {
		System.out.println("<Avatar.addToBackpack()");
		backpack.add(i);
		System.out.println(">Avatar.addToBackpack()");
	}
	/*
	 * használja az adott itemet
	 * Levente
	 */
	public void useItem(Item i) {
		System.out.println("<Avatar.useItem()");
		i.use(this);
		System.out.println(">Avatar.useItem()");
	}
	
	/*
	 * TODO
	 * Várni kell majd előbb egy kört
	 */
	
	public void dieByWater() {
		System.out.println("<Avatar.dieByWater()");
		if(!wearsWetsuit)
			//endGame
		System.out.println(">Avatar.dieByWater()");
	}
	/*
	 * TODO
	 */
	
	public void dieByHeatLoss() {
		System.out.println("<Avatar.dieByHeatLoss()");
		//endGame
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
			this.dieByHeatLoss();
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
	 *d irányba elmozdul ha tud (csak akkor nem tud ha határmező van ott) 
	 * Levente
	 */
	public void move(Direction d) {
		System.out.println("<Avatar.move()");
		Field f = field.getNeighbour(d);
		
		if(f.accept()) {
			f.addAvatar(this);
			field.removeAvatar(this);
			this.setActivity(1);
		}
		
		System.out.println(">Avatar.move()");
	}
	/*
	 * TODO
	 */
	
	public void endTurn() {
		System.out.println("<Avatar.endTurn()");
		System.out.println(">Avatar.endTurn()");
	}
	
	/*
	 *  Az activityPoints atributumhoz hozzadja (levonja)
	 * azt amennyi kell a munka végrehajtásához.
	 * Ha kifogy, meghívódik az endTurn()	
	 * Levente															
	 */
	
	public void setActivity(int i) {
		System.out.println("<Avatar.setActivity()");
		activityPoints += i;
		if(activityPoints == 0) {
			this.endTurn();
		}
		System.out.println(">Avatar.setActivity()");
	}
	
}
