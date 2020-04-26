package jegmezo.fields;

import java.io.IOException;

import jegmezo.Test;

public class Border extends Field{
	
	public Border() {}
	
	public Border(String _name) throws IOException {
		super(_name);
		Test.bw.write(this.name + " created\n");
	}
	
	
	public boolean accept() {
		System.out.println("<Field.accept()");
		System.out.println("border");
		System.out.println(">Field.accept()");
		return false;
	}
}
