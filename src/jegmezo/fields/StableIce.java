package jegmezo.fields;

import java.io.IOException;

import jegmezo.Test;

public class StableIce extends Field{
	public StableIce() {
		this.kills = false;
	}
	
	public StableIce(String _name) throws IOException {
		super(_name);
		this.kills = false;
		Test.bw.write(this.name + " letrejott\n");
	}
}
