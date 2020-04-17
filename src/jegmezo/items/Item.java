package jegmezo.items;

import jegmezo.avatars.Avatar;

public abstract class Item {
	
	protected boolean important;

	public boolean getImportant() {
		return important;
	}
	// gun r�szek fontosak, egy�b t�rgyak nem, gun checkn�l ezt n�zz�k
	
	/*
	 * Kiegeszitettem egy avatar parameterrel, hogy tudjuk, melyik avatar hasznalta
	 * Levente
	 */
	public abstract void use(Avatar a);
	
}
