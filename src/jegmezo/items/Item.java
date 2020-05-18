package jegmezo.items;

import java.io.IOException;

import graphics.ItemGraphics;
import jegmezo.Direction;
import jegmezo.Test;
import jegmezo.avatars.Avatar;

public abstract class Item {
	
	protected boolean important;
	protected String name;
	protected ItemGraphics graphics;
	
	/**
	 * Item konstruktora:
	 * Beallitja a nevet
	 * 
	 * @param _name Erre allitja be az item nevet / azonositojat
	 */
	public Item(String _name) throws IOException {
		name = _name;
		/*try {
			Test.bw.write(this.name + " created\n");
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}*/
	}
	
	public ItemGraphics getGraphics() {
		return graphics;
	}
	
	public void use(Avatar a, Direction d) {}
	
	/**
	 * Important - Getter
	 * 
	 * @return important
	 */
	public boolean getImportant() {
		return important;
	}
	// gun reszek fontosak, egyeb targyak nem, gun checknel ezt nezzek
	
	/**
	 * Beallitja az adott targyra, hogy hanyszor
	 * lett hasznalva
	 * 
	 * @param n Ennyiszer lett hasznalva - erre allitja be
	 */
	public void setUsed(int n) {}
	
	/**
	 * Itemhasznalat
	 * abstract
	 * 
	 * @param a Adott avatar hasznalja az itemet
	 */
	public abstract void use(Avatar a);

	/**
	 * Name - Getter
	 * absract
	 * 
	 * @return name
	 */
	public abstract String getName();
	
}
