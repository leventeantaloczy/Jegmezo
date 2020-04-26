package jegmezo.avatars;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import jegmezo.Shelter;
import jegmezo.Test;

public class Eskimo extends Avatar{
	
	
	public Eskimo(String _name) throws IOException{
		super(_name);
		this.healthPoints = 5;
		try {
			Test.bw.write(this.name + " letrejott\n");
		}catch(NullPointerException e){
			System.out.println("NullpointerException: " + e);
		}
	}

	
	/*
	 * a field igloo flagjét beállítja
	 * Levente
	 */


	public int specialMove() {
		System.out.println("<Eskimo.build()");
		field.setShelter(Shelter.Igloo);
		this.setActivity(1);
		System.out.println(">Eskimo.build()");
		return 1;
	}

}
