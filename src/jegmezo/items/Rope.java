package jegmezo.items;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


import jegmezo.Direction;
import jegmezo.Test;
import jegmezo.avatars.Avatar;
import jegmezo.fields.Field;

public class Rope extends Item{
	
	/**
	 * Rope konstruktora:
	 * Beallitja a fontossagot hamisra es a nevet
	 * 
	 *  @param _name Erre a nevre allitja be a Rope nevet
	 */
	public Rope(String _name) throws IOException{
		super(_name);
		this.important = false;
	}
	
	/**
	 * Name - Getter 
	 *
	 * @return name
	 */
	@Override
	public String getName() {return name;}
	
	/**
	 * Rope hasznalata:
	 * Az adott avatart menti meg a kotel
	 *  
	 *  @param a Ez az avatar lesz megmentve a Rope-pal
	 */
	@Override
	public void use(Avatar a) {
		System.out.println("<Rope.use()");
		//testre atirva
		
		Field f;
		f = a.getField().getNeighbour(Direction.North);
		if(f.avatars.size() > 0) {
			for(Avatar av : f.avatars){
				/*try {
					Test.bw.write(av.getName() + " rescued\n");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}*/
				av.move(Direction.South);
			}
		}
		
		/*System.out.println("Melyik iranyba?");
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
		}*/
		
		
		System.out.println(">Rope.use()");
		
	}

}
