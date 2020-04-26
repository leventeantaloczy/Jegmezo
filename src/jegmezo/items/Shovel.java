package jegmezo.items;
import jegmezo.fields.Field;

import java.io.IOException;

import jegmezo.Test;
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
		try {
			Test.bw.write("Shovel used\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(">Shovel.use()");
	}
	
	@Override
	public String getName() {return name;}

}
