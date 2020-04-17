package jegmezo.items;

import jegmezo.avatars.Avatar;

public abstract class Item {
	
	protected boolean important;

	public boolean getImportant() {
		return important;
	}
	// gun részek fontosak, egyéb tárgyak nem, gun checknél ezt nézzük
	
	/*
	 * Kiegeszitettem egy avatar parameterrel, hogy tudjuk, melyik avatar hasznalta
	 * Levente
	 */
	public abstract void use(Avatar a);
	
}
