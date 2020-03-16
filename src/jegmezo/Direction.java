package jegmezo;

public enum Direction {
	North(0), South(1), East(2), West(3);
	
	int val;
	Direction(int v){
		val = v;
	}
	
	public int showVal() {
		return val;
	}
}
