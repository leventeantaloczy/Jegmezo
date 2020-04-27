package jegmezo.items;

import java.io.IOException;

import jegmezo.Test;
import jegmezo.avatars.Avatar;

public abstract class Item {
	
	protected boolean important;
	protected String name;
	
	public Item(String _name) throws IOException {
		name = _name;
		try {
			Test.bw.write(this.name + " created\n");
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
	}
	
	
	public boolean getImportant() {
		return important;
	}
	// gun reszek fontosak, egyeb targyak nem, gun checknel ezt nezzek
	

	
	public void setUsed(int n) {}
	
	/*
	 * Kiegeszitettem egy avatar parameterrel, hogy tudjuk, melyik avatar hasznalta
	 * Levente
	 */
	public abstract void use(Avatar a);

	public abstract String getName();
	
}
