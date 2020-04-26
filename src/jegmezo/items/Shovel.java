package jegmezo.items;
import jegmezo.fields.Field;
import jegmezo.avatars.Avatar;

public class Shovel extends Item{
	
	public Shovel(String _name){
		super(_name);
		this.important = false;
	}
	
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
	
	@Override
	public String getName() {return name;}

}
