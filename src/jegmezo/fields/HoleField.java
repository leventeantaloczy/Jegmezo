package jegmezo.fields;

import java.io.IOException;

import jegmezo.Test;

public class HoleField extends Field{
	
	public HoleField() {
		this.kills = true;
		
	}
	
	public HoleField(String _name) throws IOException {
		super(_name);
		this.kills = true;
		Test.bw.write(this.name + " letrejott\n");
	}
}
