package jegmezo.items;

import java.io.IOException;

import jegmezo.Test;
import jegmezo.avatars.Avatar;

public class Flare extends Item{
	
	public Flare(String _name) throws IOException{
		super(_name);
		this.important = true;
	}

	@Override
	public void use(Avatar a) {
		System.out.println("<Flare.use()");
		try {
			Test.bw.write("Flare used\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(">Flare.use()");
	}
	
	@Override
	public String getName() {return name;}

}
