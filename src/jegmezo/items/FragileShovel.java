package jegmezo.items;

import jegmezo.avatars.Avatar;
import jegmezo.fields.Field;

public class FragileShovel extends Item{
	private int numOfUsage = 0;

	@Override
	public void use(Avatar a) {
		// TODO Auto-generated method stub
		if(numOfUsage < 3) {
			Field f = a.getField();
			f.setSnow(-2);
			numOfUsage++;
		}else {
			
			//kitorlodik a hatizsakból
		}
		
	}

	/*
	 * Hogy legyen? Ki hívja kinek legyen a felelossége? Sztem nem kell bele elég ha a use-ban elpusztul
	 * Levente
	 */
	public void expire() {
		
	}
}
