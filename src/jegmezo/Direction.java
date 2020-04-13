package jegmezo;

import java.util.HashMap;
import java.util.Map;

public enum Direction {
	North(0), South(1), East(2), West(3);
	
	

	
	private int val;
	Direction(int v){
		val = v;
	}
	
	private static Map map = new HashMap<>();
	
	static {
		for (Direction dir : Direction.values()) {
			map.put(dir.val, dir);
    	}
	}
	
	public int showVal() {
		return val;
	}
	
    public static Direction valueOf(int direction) {
        return (Direction) map.get(direction);
    }
}
