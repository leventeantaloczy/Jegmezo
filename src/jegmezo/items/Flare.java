package jegmezo.items;

import jegmezo.avatars.Avatar;

public class Flare extends Item{
	
	public Flare(String _name){
		super(_name);
		this.important = true;
	}

	@Override
	public void use(Avatar a) {
		System.out.println("<Flare.use()");
		
		System.out.println(">Flare.use()");
		return;
		
	}
	
	@Override
	public String getName() {return name;}

}
