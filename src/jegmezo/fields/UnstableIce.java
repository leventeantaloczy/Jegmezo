package jegmezo.fields;

public class UnstableIce extends Field{
	
	public UnstableIce() {
		this.kills = false;
	}
	
	public void flip() {
		System.out.println("<UnstableIce.flip()");
		this.kills = true;
		System.out.println(">UnstableIce.flip()");	
	}
	
}
