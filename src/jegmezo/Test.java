package jegmezo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import jegmezo.avatars.Eskimo;
import jegmezo.avatars.PolarBear;
import jegmezo.avatars.Researcher;
import jegmezo.avatars.Avatar;
import jegmezo.fields.*;
import jegmezo.items.*;



public class Test {
	public static BufferedWriter bw;
	/*private List<Avatar> avatars = new ArrayList<Avatar>();	
	private List<Field> fieldsOnArea = new ArrayList<Field>();*/
	Controller controller = new Controller();
	
	
	
	private void initTest(boolean init) {
		try {
			Controller.startGame(init);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private Avatar avatar(String str, String name) throws IOException {
		if(str.equals("e")) {
			return new Eskimo(name);
		}
		else if(str.equals("p")) {
			return new PolarBear(name);
		}
		else if(str.equals("r")) {
			return new Researcher(name);
		}
		else {
			bw.write("Nem jott letre " + name + " avatar\n");
			return null;
		}
	}
	
	private Field Field(String type, String name) throws IOException {
		
		if(type.equals("s")) {
			return new StableIce(name);
		}
		else if(type.equals("u")) {
			return new UnstableIce(name);
		}
		else if(type.equals("h")) {
			return new HoleField(name); 
		}
		else if(type.equals("b")) {
			return new Border(name);	
		}
		else {
			bw.write("Nem jott letre " + name + " field\n");
			return null;
		}
	}
	
	private Avatar findAvatar(String name) {
		System.out.println("aaa");
		for(Avatar a : controller.gameArea.avatars) {
			if(a.getName().equals(name))
				return a;
		}
		
		return null;
	}
	
	private Field findField(String name) {
		for(Field f : controller.gameArea.fieldsOnArea) {
			if(f.getName().equals(name))
				return f;
		}
		return null;
	}
	
	private void Move(String name, String where) throws IOException {
		//bw.write(name + " ");
		findAvatar(name).move(Direction.valueOf(where));
	}
	
	/*
	 * beallitja a szomszedot, eloszor eszak majd del kelet nyugat 
	 */
	private void Bind(String field1, String field2) throws IOException {
		findField(field1).setNeighbour(findField(field2));
	}
	
	private void Place(String name, String field) throws IOException {
		findField(field).addAvatar(findAvatar(name));
		findAvatar(name).setField(findField(field));
	}
	
	private void specialmove(String _name){
		findAvatar(_name).specialMove();
	}
	
	private void item(String itemType, String itemName, String field) throws IOException {
		Field f = findField(field);
		switch(itemType.toLowerCase()) {
			case "rope":
				f.item = new Rope(itemName);
				break;
			case "tent":
				f.item = new Tent(itemName);
				break;
			case "emptyitem":
				f.item = new EmptyItem(itemName);
				break;
			case "flare":
				f.item = new Flare(itemName);
				break;
			case "food":
				f.item = new Food(itemName);
				break;
			case "fragileshovel":
				f.item = new FragileShovel(itemName);
				break;
			case "gun":
				f.item = new Gun(itemName);
				break;
			case "shovel":
				f.item = new Shovel(itemName);
				break;
			case "wetsuit":
				f.item = new WetSuit(itemName);
				break;
			case "cartridge":
				f.item = new Cartridge(itemName);
				break;
			default:
				System.out.println("Not correct");
		}
		
		try {
			bw.write(itemName + " added to " + f.getName() + "\n");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*
	 * amelyik mezon all azt az itemeet veszi fel
	 */
	
	private void tobackpack(String avatarName) {
		findAvatar(avatarName).addToBackpack();
	}
	
	private void feed(String avatarName) {
		try {
			findAvatar(avatarName).useItem();
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void snow(String fieldName) {
		findField(fieldName).setSnow(1);
	}
	
	private void use(String itemName, String avatarName) {
		//ebben nem vagyok fixen biztos - Hanga
		findAvatar(avatarName).useItem(findItem(itemName));
		
	}
	
	private Item findItem(String name) {
		for(Avatar a : controller.gameArea.avatars) {
			for(Item i : a.getBackpack()) {
				if(i.getName().equals(name))
					return i;
			}
		}
		return null;
	}

	/*
	 * Beallitja, hogy a FragileShovel hanyszor lett
	 * hasznalva (n)
	 * Hanga
	 */
	private void setused(String fragileShovelName, String n) {
		findItem(fragileShovelName).setUsed(Integer.parseInt(n));
	}
	
	public void evaluateTest(BufferedReader br, String fileName) throws IOException {
		bw = new BufferedWriter(new FileWriter(fileName));
		
		String st = null;
		/*
		 * Ha az elso sor fullInit, akkor az az initet teszteli
		 */
		st = br.readLine();
		if(st.equals("fullInit"))
			initTest(true);
		else
			initTest(false);
		
		while ((st = br.readLine()) != null) {
			String[] command = st.split(" ");

			switch (command[0].toLowerCase()) {
				case "init":
					initTest(true);
					break;
				case "avatar":
					controller.gameArea.avatars.add(avatar(command[1].toLowerCase(), command[2].toLowerCase()));
					break;
				case "field":
					controller.gameArea.fieldsOnArea.add(Field(command[1].toLowerCase(), command[2].toLowerCase()));
					break;
				case "move":
					Move(command[1].toLowerCase(), command[2]);
					break;
				case "bind":
					Bind(command[1].toLowerCase(), command[2].toLowerCase());
					break;
				case "place":
					Place(command[1].toLowerCase(), command[2].toLowerCase());
					break;
				case "specialmove":
					specialmove(command[1].toLowerCase());
					break;
				case "item":
					item(command[1].toLowerCase(), command[2].toLowerCase(), command[3].toLowerCase());
					break;
				case "tobackpack":
					tobackpack(command[1].toLowerCase());
					break;
				case "snow":
					snow(command[1].toLowerCase());
					break;
				case "use":
					use(command[1].toLowerCase(),command[2].toLowerCase());
					break;
				case "storm": //???EHHEZ EGESZ JATEKOT FEL KELL EPITENI MERT CONTROLLER CSINALJA A STORMOT
					controller.Storm(controller.gameArea.fieldsOnArea);
					break;
				case "freeze": //???SET HEALTHPOINTS TO 0 ??? ez egy egesz teszt hogy elfogy a healthpointja akkor mi tortenik
					for(int i = 0; i < 6; i++)
						controller.Storm(controller.gameArea.fieldsOnArea);
					break;
				case "activity": // kell-e?
					Controller.gameArea.avatars.get(0).setActivity(4);
					break;
				case "shoot":
					use(command[1].toLowerCase(),command[2].toLowerCase());
					break;
				case "setused":
					setused(command[1].toLowerCase(),command[2].toLowerCase());
					break;
				case "savetofile":
					bw.close();
					break;
			default:
				System.out.println("Rossz parancs");
				bw.write("Rossz parancs\n");
				break;
			}
		}
		bw.close();
	}
	
	public boolean didItSucced(FileReader result, FileReader keyFile) throws IOException {


		BufferedReader br1 = new BufferedReader(result);
		BufferedReader br2 = new BufferedReader(keyFile);

		String key = br2.readLine();
		System.out.println(key);
		String in;
		while((in = br1.readLine()) != null) {
			if(in.equals(key)) {
				return true;
			}
		}
		return false;
	}

	//TODO ha illegal expression van akkor ne fossa ossze magat
	 public static void main(String[] args) throws IOException { 
		 String path = Paths.get("").toAbsolutePath().toString();
		 Test t = new Test(); 
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 String fileName = br.readLine();
		 FileReader fr = new FileReader(path + "/" + fileName);
		 try {
			 while(!fileName.equals("exit")) { 
				 fr = new FileReader(path + "/" + fileName);
				 BufferedReader bread = new BufferedReader(fr);
				 String[] newName = fileName.split("\\.");
				 t.evaluateTest(bread, newName[0] + "Out." + newName[1]);
				 if(t.didItSucced(new FileReader(newName[0] + "Out." + newName[1]), new FileReader(path + "/" + newName[0] + "Control.txt"))) {
					 System.out.println(newName[0] + " succeded");
				 }else {
					 System.out.println(newName[0] + " failed");
				 }
				 fileName = br.readLine();
			 }
		 }catch (NullPointerException e) {
			System.out.println(e);
		}
	  }	
}