package jegmezo.items;

import jegmezo.avatars.Avatar;

public class Cartridge extends Item{
	
	public Cartridge(){
		this.important = true;
	}
	
	@Override
	public void use(Avatar a) {
		System.out.println("Cartridge.use()");
		System.out.println(">Cartridge.use()"); 
		return;
		
	}

}
