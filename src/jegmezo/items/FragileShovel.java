package jegmezo.items;

import java.io.IOException;

import jegmezo.Test;
import jegmezo.avatars.Avatar;
import jegmezo.fields.Field;

public class FragileShovel extends Item{
	private int numOfUsage = 0;

	 public FragileShovel(String _name) throws IOException {
		super(_name);
		this.important = false;
	}

	 @Override
	public String getName() {return name;}
	
	@Override
	public void use(Avatar a) {
		if(numOfUsage < 3) {
			Field f = a.getField();
			try {
				Test.bw.write("FragileShovel used\n");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			f.setSnow(-2);
			numOfUsage++;
		}else {
			a.removeFromBackpack(this);
			try {
				Test.bw.write("FragileShovel broken\n");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public void setUsed(int n) {
		numOfUsage = n;
	}
}
