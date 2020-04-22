package jegmezo.items;

import jegmezo.avatars.Avatar;

public abstract class Item {
	
	protected boolean important;

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
