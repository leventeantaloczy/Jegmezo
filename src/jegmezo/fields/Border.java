package jegmezo.fields;

import java.io.IOException;

import jegmezo.Test;

public class Border extends Field{
	
	/**
	 * Border konstruktora 
	 */
	public Border() {}
	
	/**
	 * Border konstruktora:
	 * Beallitja a nevet 
	 * 
	 * @param _name Beallitja a border nevet / azonositojat
	 */
	public Border(String _name) throws IOException {
		super(_name);
		Test.bw.write(this.name + " created\n");
	}
	
	/**
	 * Accept:
	 * Border - false
	 *
	 * @return false
	 */
	public boolean accept() {
		System.out.println("<Field.accept()");
		System.out.println("border");
		System.out.println(">Field.accept()");
		return false;
	}
}
