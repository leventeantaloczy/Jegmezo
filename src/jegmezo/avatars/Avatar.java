package jegmezo.avatars;
import jegmezo.fields.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import jegmezo.Direction;
import jegmezo.GameEnder;
import jegmezo.Test;
import jegmezo.items.*;

public abstract class Avatar {
	
	protected Field field;
	private List<Item> backpack = new ArrayList<Item>();
	private int activityPoints;
	private int durability;
	public boolean EndTurn = false;
	public boolean wearsWetsuit = false;
	public GameEnder gameEnder;
	protected int healthPoints;
	protected String name;
	private boolean NPC = false;
	
	
	/**
	 * Avatar konstruktora:
	 * Letrehozza az adott avatar backpack-jet, amibe kesobb itemek ker�lnek,
	 * valamint beallitja a nevet �s a kezdetleges activityPoint-ot.
	 * 
	 * @param _name Avatar azonositoja
	 */
	public Avatar(String _name) {	
		backpack = new LinkedList<Item>();
		name = _name;
		activityPoints = 4;
		System.out.println(name + " letrejott");
	}
	
	
	/*public Avatar(String _name, BufferedWriter bw) {	
		backpack = new LinkedList<Item>();
		name = _name;
		activityPoints = 4;
	}*/
	
	/**
	 * NPC - Setter
	 * 
	 * @param b Erre lesz beallitva az NPC erteke.
	 */
	public void setNPC(boolean b) {
		this.NPC = b;
	}
	
	/**
	 * NPC - Getter 
	 * 
	 * @return NPC
	 */
	public boolean getNPC() {
		return NPC;
	}
	
	/**
	 * Backpack - Getter
	 * 
	 * @return Maga a backpack.
	 */
	public List<Item> getBackpack(){
		return backpack;
	}
	
	/**
	 * Durability - Setter
	 * 
	 * @param i Ennyire allitja a durability-t
	 */
	public void setDurability(int i) {
		durability = i;
	}
	
	/**
	 * Csokkenti a durability-t eggyel 
	 */
	public void decrementDurability() {
		System.out.println(durability + " durab");
		if(this.field.getKills() && !this.wearsWetsuit)
			durability--;
		if(durability <= 0)
			gameEnder.endGame();
	}
	
	/**
	 * Avatar eldob egy itemet:
	 * Meg kell adni benne hanyas itemet dobja el, majd
	 * ha az megtalalhato az avatar backpackjeben,
	 * akkor azt kiveszi onnan.
	 */
	public void dropItem() throws IOException{
		System.out.println("Which Item, please enter a number");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String i = br.readLine();
		
		while(Integer.parseInt(i) > backpack.size()) {
			System.out.println("Again, please");
			try {
				i = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		backpack.add(field.switchItem(backpack.remove(Integer.parseInt(i))));
		setActivity(1);
	}

	/**
	 * Hozzaad egy itemet a backpackhez:
	 * Amelyik mezon all az avatar, az azon megtalalhato itemet
	 * fogja annak backpackjebe tenni.
	 */
	public void addToBackpack() {
		System.out.println("<Avatar.addToBackpack()");
		if(this.field.getSnowAmount() <= 0) {
			backpack.add(field.item);
			
			/*try {
				Test.bw.write(field.item.getName() + " added to backpack\n");
			} catch (IOException e) {
				e.printStackTrace();
			}*/
			
			field.removeItem();
			setActivity(1);
		}
		System.out.println(">Avatar.addToBackpack()");
	}
	
	/**
	 * Eltavolit egy itemet a backpackbol
	 * 
	 * @param i Az adott item, amit el akarunk tavolitani.
	 */
	public void removeFromBackpack(Item i) {
		backpack.remove(i);
	}
	
	/*
	 * használja az adott itemet, aktivitasa no
	 * Levente
	 */
	/**
	 * Adott item hasznalata:
	 * A felhasznalonak kell megadni hanyadik elemet szeretne
	 * felhasznalni a backpacknek. Ez az item lesz felhasznalva,
	 * illetve az activityPoint beallitasra kerul.
	 */
	public void useItem() throws NumberFormatException, IOException {
		System.out.println("<Avatar.useItem()");
		System.out.println("Hanyas itemet hasznaljam?");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int command = Integer.parseInt(br.readLine());
    	backpack.get(command).use(this);
		this.setActivity(1);
		System.out.println(">Avatar.useItem()");
	}
	
	/**
	 * Adott item hasznalata:
	 * Ezzel a fuggvennyel az avatar felhasznalja az adott itemet,
	 * felteve ha az benne van a backpack-jeben.
	 * Illetve az activityPoint-ot n�veli eggyel.
	 * 
	 * @param item A felhasznalni kivant item
	 */
	public void useItem(Item item) {
		System.out.println("<Avatar.useItem()");
		int indexOfItem = backpack.indexOf(item);
		backpack.get(indexOfItem).use(this);
		this.setActivity(1);
		System.out.println(">Avatar.useItem()");
	}
	
	/*
	 * TODO	public Field field;

	 * Meg kell hívni a gameEnder endGame()-jét de nem tudom, azt látja-e
	 * Várni kell majd előbb egy kört
	 */
	/**
	 * Avatar megfullad:
	 * Ha az avatar nem visel buvarruhat, megfullad.
	 */
	public void dieByWater() {
		System.out.println("<Avatar.dieByWater()");
		if(!wearsWetsuit)
		gameEnder.endGame();
		System.out.println(">Avatar.dieByWater()");
	}
	
	/*
	* Kihűl, elhalálozik
	* Zoli
	*/
	/**
	 *Instant halal:
	 *Az avatar azonnal meghal.
	 */
	public void instantDeath() {
		System.out.println("<Avatar.dieByHeatLoss()");
		gameEnder.endGame();
		System.out.println(">Avatar.dieByHeatLoss()");
	}
	
	/*
	 * Eletero novekszik etel hatiasara
	 * Levente 
	 */
	/**
	 * Eleteronoveles
	 */
	public void gainHealth() {
		System.out.println("<Avatar.gainHealth()");
		healthPoints++;
		System.out.println(">Avatar.gainHealth()");
	}
	
	/*
	 * hp vesztes, ha 0 meghal heatLoss-ban
	 * Levente
	 */
	/**
	 * Eleterocsokkentes 
	 * Amennyiben nullara csokkent az eleteropontja,
	 * az avatar automatikusan meghal.
	 */
	public void loseHealth() {
		System.out.println("<Avatar.loseHealth()");
		healthPoints--;
		if(healthPoints == 0)
			this.instantDeath();
		System.out.println(">Avatar.loseHealth()");
	}
	
	/*
	 * getter
	 * Levente
	 */
	/**
	 * Field - Getter
	 * 
	 * @return Az adott avatar melyik fielden all.
	 */
	public Field getField() {
		System.out.println("<Avatar.getField()");
		System.out.println(">Avatar.getField()");
		return field;
	}
	
	/*
	 * d irányba elmozdul ha tud (csak akkor nem tud ha határmező van ott) 
	 * Levente
	 */
	/**
	 * Avatar mozog:
	 * Ha annak a fieldnek van szomszedja, ahol az avatar
	 * eppen all d iranyban, akkor az avatar atlep arra a
	 * fieldre, egyebkent hibat dob.
	 * 
	 * @param d Ebbe az iranyba fog elmozdulni az avatar
	 */
	public void move(Direction d){
		System.out.println("<Avatar.move()");
		System.out.println("ezen a mezon allok: " + this.field.id);
		if(this.field.getKills() == false) {
			if(this.field.getNeighbour(d).accept()) {
				try {
					field.getNeighbour(d).addAvatar(this);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				field.removeAvatar(this);
				field = field.getNeighbour(d);
				this.setActivity(1);
			}
		}else {
			this.endTurn();
		}
		System.out.println("ezen a mezon allok: " + this.field.id);
		/*try {
			Test.bw.write(this.name + " moved to the " +  d.toString() + "\n");
		}catch (NullPointerException e) {
			System.out.println(e);
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		System.out.println(">Avatar.move()");
	}
	
	/*
	 * Ezt tudtam kitalalni arra hogy "szol controllernek"
	 * Benedek
	 */
	/**
	 * Avatar korenek vege:
	 * Beallitja az activityPoints-ot a maximumra (4)
	 */
	public void endTurn() {
		System.out.println("<Avatar.endTurn()");
		this.activityPoints = 4;
		this.EndTurn = true;
		System.out.println(">Avatar.endTurn()");
	}
	
	/**
	 * EndTurn - Setter
	 * Beallitja hamisra az attributumot
	 */
	public void setEndTurn() {
		this.EndTurn = false;
	}
	
	/*
	 *  Az activityPoints atributumhoz hozzadja (levonja)
	 * azt amennyi kell a munka végrehajtásához.
	 * Ha kifogy, meghívódik az endTurn()	
	 * Levente															
	 */
	
	/**
	 * Beallitja az aktivitaspontot:
	 * Ha ez nullara (vagy az ala) esik, automatikusan
	 * meghivodik az endturn metodus.
	 * 
	 * @param i Adott ertekkel csokkenti az aktivitaspontot
	 */
	public void setActivity(int i) {
		System.out.println("<Avatar.setActivity()");
		activityPoints -= i;
		System.out.println(activityPoints);
		if(activityPoints <= 0) {
			/*try {
				Test.bw.write("EndTurn\n");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
			this.endTurn();
		}
		System.out.println(">Avatar.setActivity()");
	}
	
	/**
	 * Name - Getter
	 * 
	 *  @return Az avatar neve
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Field - Setter
	 *
	 * @param _field Beallitja erre a fieldre az avatar fieldjet
	 * @throws IOException 
	 */
	public void setField(Field _field) throws IOException {
		field = _field;
		/*try {
			Test.bw.write(field.getName() + " has " + this.name + "\n");
		} catch (NullPointerException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}*/
		
	}
	
	public int getHealthPoints() {
		return healthPoints;
	}
	
	/**
	 * Avatar specialis kepesseget hasznalja
	 * abstarct fuggveny
	 */
	public abstract int specialMove();
}
