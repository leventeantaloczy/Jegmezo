package jegmezo.fields;

import java.io.IOException;

import jegmezo.Test;

public class StableIce extends Field{
	
	/**
	 * StableIce konstruktora:
	 * Beallitja a kills-t hamis ertekre
	 */
	public StableIce() {
		this.kills = false;
	}
	
	/**
	 * StableIce konstruktora:
	 * Beallitja a nevet, kills-t hamisra
	 * 
	 * @param _name Erre a nevre fogja beallitani
	 */
	public StableIce(String _name) throws IOException {
		super(_name);
		this.kills = false;
		Test.bw.write(this.name + " created\n");
	}
}
