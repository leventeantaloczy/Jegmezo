package jegmezo.items;

import jegmezo.avatars.Avatar;
import jegmezo.fields.Field;

public class FragileShovel extends Item{
	private int numOfUsage = 0;

	@Override
	public void use(Avatar a) {
		if(numOfUsage < 3) {
			Field f = a.getField();
			f.setSnow(-2);
			numOfUsage++;
		}else {
			a.removeFromBackpack(this);
		}
		
	}
}
