package jegmezo.fields;

public class Border extends Field{
	
	
	public boolean accept() {
		System.out.println("<Field.accept()");
		System.out.println(">Field.accept()");
		return false;
	}
}
