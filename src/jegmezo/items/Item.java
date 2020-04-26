package jegmezo.items;

import java.io.IOException;

import jegmezo.Test;
import jegmezo.avatars.Avatar;

public abstract class Item {
	
	protected boolean important;
	protected String name;
	
	public Item(String _name) {
		name = _name;
		try {
			Test.bw.write(this.name + " created\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public boolean getImportant() {
		return important;
	}
	// gun reszek fontosak, egyeb targyak nem, gun checknel ezt nezzek
	
	/*
	 * Kiegeszitettem egy avatar parameterrel, hogy tudjuk, melyik avatar hasznalta
	 * Levente
	 */
	public abstract void use(Avatar a);
	
	
}
