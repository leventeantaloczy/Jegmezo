package jegmezo.items;

import java.io.IOException;

import jegmezo.Test;
import jegmezo.avatars.Avatar;

public class Cartridge extends Item{
	
	public Cartridge(String _name){
		super(_name);
		this.important = true;
	}
	
	@Override
	public void use(Avatar a) {
		System.out.println("Cartridge.use()");
		try {
			Test.bw.write("Cartidge used\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(">Cartridge.use()"); 
		return;
		
	}
	
	@Override
	public String getName() {return name;}

}
