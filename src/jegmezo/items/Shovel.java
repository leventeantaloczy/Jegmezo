package jegmezo.items;
import jegmezo.fields.Field;

import java.io.IOException;

import jegmezo.Test;
import jegmezo.avatars.Avatar;

public class Shovel extends Item{
	
	/**
	 * Shovel konstruktora:
	 * Beallitja a fontossagot hamisra es a nevet.
	 * 
	 * @param _name Erre a nevre allitja be a Shovel nevet
	 */
	public Shovel(String _name) throws IOException{
		super(_name);
		this.important = false;
	}
	
	/**
	 * Shovel hasznalata:
	 * A megadott avatar fogja felhasznalni ezt az itemet,
	 * leszed az avatar field-jerol 2 egyseg havat.
	 * 
	 * @param a Ez az avatar fogja haszalni a targyat
	 */
	@Override
	public void use(Avatar a) {
		System.out.println("<Shovel.use()");
		Field f = a.getField();
		f.setSnow(-2);
		try {
			Test.bw.write("Shovel used\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(">Shovel.use()");
	}
	
	@Override
	public String getName() {return name;}

}
