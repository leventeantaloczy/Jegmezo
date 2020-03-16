package jegmezo.avatars;
import jegmezo.fields.*;
import jegmezo.Direction;

public class Researcher extends Avatar{

	public Researcher(int hp) {
		super(hp);
		// TODO Auto-generated constructor stub
	}
	
	/*
	 * A d iranyu mezot leelenorzi és visszater annak kapacitas ertekevel
	 * Levente
	 */
	public int checkField(Direction d) {
		System.out.println("<Researcher.checkField()");
		
		Field f = new Field(); 
		f = field.getNeighbour(d);
		this.setActivity(1);
		
		System.out.println(">Researcher.checkField()");
		return f.getCapacity();
	}
	
}
