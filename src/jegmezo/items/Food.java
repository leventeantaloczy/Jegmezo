package jegmezo.items;

import java.io.IOException;

import jegmezo.Test;
import jegmezo.avatars.Avatar;

public class Food extends Item{

	public Food(String _name) throws IOException{
		super(_name);
		this.important = false;
	}
	
	@Override
	public String getName() {return name;}
	
	/*
	 * TODO aktivitas???
	 * Eszik es felmegy az elete
	 * Levente
	 */
	@Override
	public void use(Avatar a) {
		System.out.println("<Food.use()");
		a.gainHealth();
		try {
			Test.bw.write("Food used\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(">Food.use()");
		
	}
	
}
