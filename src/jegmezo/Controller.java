package jegmezo;
import jegmezo.avatars.*;
import jegmezo.fields.*;
import jegmezo.items.*;

public class Controller {
	
	public static void startGame() {
		System.out.println("<Controller.startGame()");
		
		GameEnder gameEnder = new GameEnder();
		GameArea gameArea = new GameArea(gameEnder);
		
		System.out.println(">Controller.startGame()");
	}
	
	public void Strom() {
		System.out.println("<Controller.Storm()");
		System.out.println(">Controller.Storm()");
	}
	
	public static void main(String[] args) {
        System.out.println("A legjobb targy a Projlab!! -help ;)");
        startGame();
    }
	
}
