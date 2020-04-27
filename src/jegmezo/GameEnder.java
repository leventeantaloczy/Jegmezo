package jegmezo;

import java.io.IOException;

public class GameEnder {
	//majd singletonna kell tenni
	
	public static void endGame() {
		System.out.println("<GameEnder.endGame()");
		try {
			Test.bw.write("Game Over");
		}catch(NullPointerException e){
			System.out.println("NullpointerException: " + e);
		}catch(IOException e1) {
			e1.printStackTrace();
		}
		System.out.println(">GameEnder.endGame()");
	}
}
