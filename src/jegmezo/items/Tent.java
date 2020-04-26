package jegmezo.items;

import java.io.IOException;

import jegmezo.Shelter;
import jegmezo.Test;
import jegmezo.avatars.Avatar;

public class Tent extends Item{
	
	public Tent(String _name){
		super(_name);
		this.important = false;
	}
	@Override
	public void use(Avatar a) {
		if(a.getField().getShelter() == Shelter.None) {
			a.getField().setShelter(Shelter.Tent);
			try {
				Test.bw.write("Tent used\n");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public String getName() {return name;}
}
