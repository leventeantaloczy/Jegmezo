package jegmezo.items;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


import jegmezo.Direction;
import jegmezo.avatars.Avatar;
import jegmezo.fields.Field;

public class Rope extends Item{

	/*
	 * ugy gondoltam, hogy a parameterben kapott avatart menti meg, báár
	 * Levente
	 */
	@Override
	public void use(Avatar a) {
		System.out.println("<Rope.use()");
		
		System.out.println("Melyik iranyba?");
		Field f;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	try {
			String direction = br.readLine();
			switch(direction.toLowerCase()) {
				case "n":{
					f = a.getField().getNeighbour(Direction.North);
					if(f.avatars.size() > 0) {
						for(Avatar av : f.avatars){
							av.move(Direction.South);
						}
					System.out.println("Avatars moved");
					}
					break;
				}
				case "s":{
					f = a.getField().getNeighbour(Direction.South);
					if(f.avatars.size() > 0) {
						for(Avatar av : f.avatars){
							av.move(Direction.North);
						}
					System.out.println("Avatars moved");
					}
					break;
				}
				case "e":{
					f = a.getField().getNeighbour(Direction.East);
					if(f.avatars.size() > 0) {
						for(Avatar av : f.avatars){
							av.move(Direction.West);
						}
					System.out.println("Avatars moved");
					}
					break;
				}
				case "w":{
					f = a.getField().getNeighbour(Direction.West);
					if(f.avatars.size() > 0) {
						for(Avatar av : f.avatars){
							av.move(Direction.East);
						}
					System.out.println("Avatars moved");
					}
					break;
				}
				default:
					System.out.println("Helytelen");
					break;
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println(">Rop.use()");
		
	}

}
