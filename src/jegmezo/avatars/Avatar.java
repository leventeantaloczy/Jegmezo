package jegmezo.avatars;
import jegmezo.fields.*;
import jegmezo.Direction;
import jegmezo.items.*;

public class Avatar {
	
	public Field field;
	private Item backpack[];
	private int activityPoints;
	private int healthPoints;
	
	public void pickUpItem(Item i) {
		System.out.println("<Avatar.pickUpItem()");
		System.out.println(">Avatar.pickUpItem()");
	}
	
	public void addToBackpack(Item i) {
		System.out.println("<Avatar.addToBackpack()");
		System.out.println(">Avatar.addToBackpack()");
	}
	
	public void useItem(Item i) {
		System.out.println("<Avatar.useItem()");
		System.out.println(">Avatar.useItem()");
	}
	
	public void dieByWater() {
		System.out.println("<Avatar.dieByWater()");
		System.out.println(">Avatar.dieByWater()");
	}
	
	public void dieByHeatLoss() {
		System.out.println("<Avatar.dieByHeatLoss()");
		System.out.println(">Avatar.dieByHeatLoss()");
	}
	
	public void gainHealth() {
		System.out.println("<Avatar.gainHealth()");
		System.out.println(">Avatar.gainHealth()");
	}
	
	public void loseHealth() {
		System.out.println("<Avatar.loseHealth()");
		System.out.println(">Avatar.loseHealth()");
	}
	
	public Field getField() {
		System.out.println("<Avatar.getField()");
		System.out.println(">Avatar.getField()");
		return field;
	}
	
	public void move(Direction d) {
		System.out.println("<Avatar.move()");
		System.out.println(">Avatar.move()");
	}
	
	public void endTurn() {
		System.out.println("<Avatar.endTurn()");
		System.out.println(">Avatar.endTurn()");
	}
	
	public void setActivity(int i) {
		System.out.println("<Avatar.setActivity()");
		System.out.println(">Avatar.setActivity()");
	}
	
}