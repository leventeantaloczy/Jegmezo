package jegmezo.avatars;
import jegmezo.fields.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import jegmezo.Direction;
import jegmezo.Test;

public class Researcher extends Avatar{

	public Researcher(String _name) throws IOException {
		super(_name); 
		this.healthPoints = 4;
		// TODO Auto-generated constructor stub
		Test.bw.write(this.name + " letrejott\n");
	}
	
	/*
	 * A d iranyu mezot leelenorzi és visszater annak kapacitas ertekevel
	 * Levente
	 */
	public int specialMove() {
		System.out.println("<Researcher.checkField()");
		
		Field f = new StableIce(); 
		System.out.println("Melyik iranyba?");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			String direction = br.readLine();
			switch(direction.toLowerCase()) {
				case "n":{
					f = field.getNeighbour(Direction.North);
					break;
				}
				case "s":{
					f = field.getNeighbour(Direction.South);
					break;
				}
				case "e":{
					f = field.getNeighbour(Direction.East);
					break;
				}
				case "w":{
					f = field.getNeighbour(Direction.West);
					break;
				}
				default:
					System.out.println("Helytelen");
					break;
			}
		}catch(IOException e){
			
		}
		this.setActivity(1);
		
		System.out.println(">Researcher.checkField()");
		return f.getCapacity();
	}
	
}
