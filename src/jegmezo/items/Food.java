package jegmezo.items;

import java.io.IOException;

import jegmezo.Test;
import jegmezo.avatars.Avatar;

public class Food extends Item{

	/**
	 * Food konstruktora:
	 * Beallitja a fontossagot hamisra es a nevet 
	 * 
	 * @param _name Erre a nevre allitja be a Food nevet / azonositojat
	 */
	public Food(String _name) throws IOException{
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
	
	/*TODO aktivitas???*/
	
	/**
	 * Food hasznalata:
	 * Adott avatar hasznalja fel ezt a targyat, melynek hatasara 
	 * eleteropontja novekszik egy egysegnyivel.
	 * 
	 * @param a Ez az avatar fog enni
	 */
	@Override
	public void use(Avatar a) {
		System.out.println("<Food.use()");
		a.gainHealth();
		try {
			Test.bw.write("Food used\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(">Food.use()");
		
	}
	
}
