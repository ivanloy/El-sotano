package elsotano.tests;

import elsotano.character.Player;
import elsotano.equipment.accessories.Gloves;
import elsotano.equipment.accessories.Ring;
import elsotano.equipment.accessories.Shoes;
import elsotano.equipment.armor.ChestArmor;
import elsotano.equipment.armor.HeadArmor;
import elsotano.equipment.armor.LegsArmor;
import elsotano.equipment.weapons.Sword;

public class PlayerTest {

	public static void main(String[] args) {
		
		Sword sword = new Sword(24);
		sword.setName("Femur afilado");
		
		ChestArmor chestArmor = new ChestArmor(12);
		chestArmor.setName("Chaleco a prueba de doble return");
		
		HeadArmor headArmor = new HeadArmor(6);
		headArmor.setName("Craneo de alumno suspenso (Y muerto)");
		
		LegsArmor legsArmor = new LegsArmor(9, 12);
		legsArmor.setName("Piernas completamente normales y para nada sospechosas");
		
		Gloves gloves = new Gloves(4);
		gloves.setName("Guantes de piel de humano");
		
		Shoes shoes = new Shoes(1200);
		shoes.setName("Calcetines sudados");
		
		Ring ring = new Ring(1);
		ring.setName("Anillo de los chinos");
		
		Player player = new Player(34, 8, 12, 0);
		
		player.setSword(sword);
		player.setChestArmor(chestArmor);
		player.setLegsArmor(legsArmor);
		player.setHeadArmor(headArmor);
		player.setGloves(gloves);
		player.setShoes(shoes);
		player.setRing(ring);
		
		player.setName("Manolo");
		
		System.out.println(player.printStats());
		
		
	}

}
