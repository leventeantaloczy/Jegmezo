package jegmezo.avatars;

import jegmezo.Direction;

public class Eskimo extends Avatar{
	
	
	public Eskimo() {
		super(5);
		// TODO Auto-generated constructor stub
	}
	
	/*
	 * a field igloo flagjét beállítja
	 * Levente
	 */

	public int specialMove(Direction d) {
		System.out.println("<Eskimo.build()");
		field.setIgloo();
		this.setActivity(1);
		System.out.println(">Eskimo.build()");
		return 1;
	}

}
