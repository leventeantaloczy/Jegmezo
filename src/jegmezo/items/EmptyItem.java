package jegmezo.items;

import java.io.IOException;

import jegmezo.Test;
import jegmezo.avatars.Avatar;

public class EmptyItem extends Item{
	
	public EmptyItem(String _name) throws IOException{
		super(_name);
		this.important = false;
	}
	
	/*
	 * emptyItem nem fog semmit sem csinálni
	 * Levente
	 */
	
	public void use(Avatar a) {
		System.out.println("<EmptyItem.use()");
		try {
			Test.bw.write("EmptyItem used\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(">EmptyItem.use()");
		return;
	}
	
	@Override
	public String getName() {return name;}
}
