package jegmezo.items;
import jegmezo.fields.Field;
import jegmezo.avatars.Avatar;

public class Shovel extends Item{

	/*
	 * 2 havat eltakarit
	 * Levente
	 */
	@Override
	public void use(Avatar a) {
		System.out.println("<Shovel.use()");
		Field f = a.getField();
		f.setSnow(-2);
		System.out.println(">Shovel.use()");
		
	}

}
