package jegmezo.items;

import java.io.IOException;

import jegmezo.Test;
import jegmezo.avatars.Avatar;
import jegmezo.fields.Field;

public class FragileShovel extends Item{
	private int numOfUsage = 0;

	/**
	 * FragileShovel konstruktora:
	 * Beallitja a fontossagot hamisra es a nevet 
	 * 
	 * @param _name Erre a nevre allitja be a nevet
	 */
	 public FragileShovel(String _name) throws IOException {
		super(_name);
		this.important = false;
	}

	 /**
	  * Name - Getter 
	  * 
	  * @return name
	  */
	 @Override
	public String getName() {return name;}
	
	/**
	 * FragileShovel hasznalata:
	 * Adott avatar hasznalja fel, ha a numOfUsage nagyobb lesz
	 * mint 3, automatikusan eltunik az avatar backpack-jebol.
	 * Hasznalataval 2 egyseg havat lapatol el az avatar arrol
	 * a fieldrol, ahol eppen all.
	 * 
	 * @param a Ez az avatar fogja hasznalni a FragileShovel-t
	 */
	@Override
	public void use(Avatar a) {
		if(numOfUsage < 3) {
			Field f = a.getField();
			/*try {
				Test.bw.write("FragileShovel used\n");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			f.setSnow(-2);
			numOfUsage++;
		}else {
			a.removeFromBackpack(this);
			/*try {
				Test.bw.write("FragileShovel broken\n");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
		}
		
	}
	
	/**
	 * Used - Setter:
	 * Beallitja, hogy hanyszor lett hasznalva a targy
	 * 
	 *  @param n Ennyiszer lett hasznalva
	 */
	public void setUsed(int n) {
		numOfUsage = n;
	}
}
