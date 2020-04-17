package jegmezo.items;

import jegmezo.avatars.Avatar;

public class Gun extends Item{

	
	public Gun(){
		this.important = true;
		
	}
	
	/*
	 * Elsütni csak akkor tudja, ha ennek az a Avatarnak a taaskajaban van Cartridge es Flare
	 * Levente
	 */
	@Override
	public void use(Avatar a) {
		System.out.println("<Gun.use()");
		System.out.println(">Gun.use()");
		if(true) {
			//TODO game won + osszes egy mezon -> avatars mérete = a játékosook számával
		}
		
		return;
	}

}
