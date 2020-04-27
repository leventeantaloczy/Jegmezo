package jegmezo.fields;

import java.io.IOException;

import jegmezo.Test;

public class HoleField extends Field{
	
	/**
	 * HoleField konstruktora:
	 * Beallitja a kills-t igaz ertekre 
	 */
	public HoleField() {
		this.kills = true;
		
	}
	
	/**
	 * HoleField konstruktora:
	 * Beallitja a nevet es a kills-t igazra allitja
	 * 
	 * @param _name HoleField neve / azonositoja erre lesz beallitva
	 */
	public HoleField(String _name) throws IOException {
		super(_name);
		this.kills = true;
		Test.bw.write(this.name + " created (HoleField) \n");
	}
}
