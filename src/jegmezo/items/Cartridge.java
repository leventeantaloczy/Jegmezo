package jegmezo.items;

import java.io.IOException;

import jegmezo.Test;
import jegmezo.avatars.Avatar;

public class Cartridge extends Item{
	
	/**
	 * Cartridge konstruktora:
	 * Beallitja a fontossagat hamisra, illetve a nevet
	 * 
	 * @param _name Erre a nevre fogja beallitani a nevet
	 */
	public Cartridge(String _name) throws IOException{
		super(_name);
		this.important = true;
	}
	
	/**
	 * Cartridge hasznalata:
	 * Adott avatar hasznalja fel.
	 * 
	 * @param a Ez az avatar fogja hasznalni
	 */
	@Override
	public void use(Avatar a) {
		System.out.println("Cartridge.use()");
		try {
			Test.bw.write("Cartidge used\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(">Cartridge.use()"); 
		return;
		
	}
	
	/**
	 * Name - Getter
	 * 
	 * @return name
	 */
	@Override
	public String getName() {return name;}

}
