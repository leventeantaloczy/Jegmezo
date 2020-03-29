package jegmezo.avatars;
import jegmezo.fields.*;
import jegmezo.Direction;

public class Researcher extends Avatar{

	public Researcher() {
		super(4); 
		// TODO Auto-generated constructor stub
	}
	
	/*
	 * A d iranyu mezot leelenorzi és visszater annak kapacitas ertekevel
	 * Levente
	 */
	public int specialMove(Direction d) {
		System.out.println("<Researcher.checkField()");
		
		Field f = new StableIce(); 
		f = field.getNeighbour(d);
		this.setActivity(1);
		
		System.out.println(">Researcher.checkField()");
		return f.getCapacity();
	}
	
}
