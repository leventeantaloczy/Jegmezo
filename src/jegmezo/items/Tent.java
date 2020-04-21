package jegmezo.items;

import jegmezo.Shelter;
import jegmezo.avatars.Avatar;

public class Tent extends Item{

	@Override
	public void use(Avatar a) {
		if(a.getField().getShelter() == Shelter.Nothing) {
			a.getField().setShelter(Shelter.Tent);
		}
	}
	
	public void expire() {
		
	}

}
