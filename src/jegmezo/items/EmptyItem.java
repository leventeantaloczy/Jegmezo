package jegmezo.items;

import java.io.IOException;

import jegmezo.Test;
import jegmezo.avatars.Avatar;

public class EmptyItem extends Item{
	
	/**
	 * EmptyItem konstruktora:
	 * Beallitja a fontossagot hamisra es a nevet
	 * 
	 *  @param _name Erre a nevre fogja beallitani az EmptyItem nevet
	 */
	public EmptyItem(String _name) throws IOException{
		super(_name);
		this.important = false;
	}
	
	/**
	 * EmptItem hasznalata:
	 * Ez tulajdonkeppen nem csinal semmit (urestargy) 
	 * 
	 * @param a Ez az avatar hasznalja fel
	 */
	public void use(Avatar a) {
		System.out.println("<EmptyItem.use()");
		try {
			Test.bw.write("EmptyItem used\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(">EmptyItem.use()");
		return;
	}
	
	/**
	 * Name - Getter
	 * 
	 *  @return name
	 */
	@Override
	public String getName() {return name;}
}
