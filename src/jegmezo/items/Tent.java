package jegmezo.items;

import jegmezo.Shelter;
import jegmezo.avatars.Avatar;

public class Tent extends Item{
	
	public Tent(String _name){
		super(_name);
		this.important = false;
	}
	@Override
	public void use(Avatar a) {
		if(a.getField().getShelter() == Shelter.None) {
			a.getField().setShelter(Shelter.Tent);
			
		}
	}
	
	@Override
	public String getName() {return name;}
}
