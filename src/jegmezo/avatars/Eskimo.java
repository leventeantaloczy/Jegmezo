package jegmezo.avatars;

import jegmezo.Shelter;

public class Eskimo extends Avatar{
	
	
	public Eskimo(String _name) {
		super(_name);
		this.healthPoints = 5;

	}
	
	/*
	 * a field igloo flagjét beállítja
	 * Levente
	 */

	public int specialMove() {
		System.out.println("<Eskimo.build()");
		field.setShelter(Shelter.Igloo);
		this.setActivity(1);
		System.out.println(">Eskimo.build()");
		return 1;
	}

}
