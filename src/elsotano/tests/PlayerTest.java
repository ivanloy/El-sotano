package elsotano.tests;

import elsotano.character.Player;
import elsotano.equipment.weapons.Sword;

public class PlayerTest {

	public static void main(String[] args) {
		
		Sword sword = new Sword(13);
		Player player = new Player(10);
		player.setSword(sword);
		
		System.out.println(player.getAttack() + ", " + player.getSwordPower());
		
		player.setSwordPower(10);
		
		System.out.println(player.getAttack() + ", " + player.getSwordPower());
		
	}

}
