package jegmezo.items;

import java.io.IOException;

import jegmezo.Test;
import jegmezo.avatars.Avatar;

public class WetSuit extends Item{
	
	public WetSuit(String _name) throws IOException{
		super(_name);
		this.important = false;
	}
	
	/*
	 * Ha use-olod, beállítódik, hogy viseled. 
	 * Innentől a dieByWater() nem bánthat.
	 * Zoli
	 */
	@Override
	public void use(Avatar a) {
		System.out.println("<WetSuit.use()");
		a.wearsWetsuit = true;
		try {
			Test.bw.write("WetSuit used\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(">WetSuit.use()");
	}
	
	@Override
	public String getName() {return name;}

}
