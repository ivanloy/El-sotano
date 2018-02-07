package elsotano.tests;

import elsotano.character.Player;
import elsotano.equipment.armor.ChestArmor;
import elsotano.equipment.armor.LegsArmor;
import elsotano.equipment.armor.HeadArmor;
import elsotano.equipment.weapons.Sword;

public class PlayerTest {

	public static void main(String[] args) {
		
		Sword sword = new Sword(38);
		sword.setName("Femur afilado");
		
		ChestArmor chestArmor = new ChestArmor(11);
		chestArmor.setName("Chaleco a prueba de doble return");
		
		HeadArmor headArmor = new HeadArmor(5);
		headArmor.setName("Craneo de alumno suspenso (Y muerto)");
		
		LegsArmor legsArmor = new LegsArmor(7);
		legsArmor.setName("Piernas completamente normales y para nada sospechosas");
		
		Player player = new Player(34, 8);
		
		player.setSword(sword);
		player.setChestArmor(chestArmor);
		player.setLegsArmor(legsArmor);
		player.setHeadArmor(headArmor);
		player.setName("Manolo");
		
		System.out.println(player.toString());
		
		
	}

}
