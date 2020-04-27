package jegmezo.items;

import java.io.IOException;

import jegmezo.Test;
import jegmezo.avatars.Avatar;

public class Flare extends Item{
	
	/**
	 * Flare konstruktora:
	 * Beallitja a fontossagot hamisra es a nevet
	 * 
	 * @param _name Beallitja erre a Flare nevet / azonositojat
	 */
	public Flare(String _name) throws IOException{
		super(_name);
		this.important = true;
	}

	/**
	 * Flare hasznalata:
	 * Az adott avatar hasznalja fel ezt a targyat.
	 * 
	 * @param a Ez az avatar fogja hasznalni a Flare-t
	 */
	@Override
	public void use(Avatar a) {
		System.out.println("<Flare.use()");
		try {
			Test.bw.write("Flare used\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(">Flare.use()");
	}
	
	/**
	 * Name - Getter
	 * 
	 *  @return name
	 */
	@Override
	public String getName() {return name;}

}
