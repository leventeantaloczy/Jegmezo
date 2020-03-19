package jegmezo.items;

import jegmezo.avatars.Avatar;

public class WetSuit extends Item{
	/*
	 * Ha use-olod, beállítódik, hogy viseled. 
	 * Innentől a dieByWater() nem bánthat.
	 * Zoli
	 */
	@Override
	public void use(Avatar a) {
		System.out.println("<WetSuit.use()");
		a.wearsWetsuit = true;
		System.out.println(">WetSuit.use()");
		
	}

}
