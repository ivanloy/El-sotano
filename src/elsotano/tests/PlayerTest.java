package elsotano.tests;

import elsotano.character.Player;
import elsotano.enemies.SimpleEnemy;
import elsotano.equipment.accessories.Gloves;
import elsotano.equipment.accessories.Ring;
import elsotano.equipment.accessories.Shoes;
import elsotano.equipment.armor.ChestArmor;
import elsotano.equipment.armor.HeadArmor;
import elsotano.equipment.armor.LegsArmor;
import elsotano.equipment.weapons.Sword;

public class PlayerTest {

	public static void main(String[] args) {
		
		Sword sword = new Sword(26);
		sword.setName("Femur afilado");
		
		ChestArmor chestArmor = new ChestArmor(34, 12);
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
		
		Player player = new Player(89, 44, 8, 12, 0);
		
		player.setSword(sword);
		player.setChestArmor(chestArmor);
		player.setLegsArmor(legsArmor);
		player.setHeadArmor(headArmor);
		player.setGloves(gloves);
		player.setShoes(shoes);
		player.setRing(ring);
		
		player.setCurrentHP(200);
		chestArmor.setMaxHP(10);
		player.setChestArmor(chestArmor);
		player.setChestArmorMaxHP(5);
		//player.dealDamage(100);
		
		player.setName("Manolo");
		
		System.out.println(player.printStats());
		
		SimpleEnemy enemy = new SimpleEnemy(280, 12, 15, 5, 3);
		enemy.setName("Psudocodigo zombie");
		
		player.attack(enemy);
		player.attack(enemy);
		player.attack(enemy);
		player.attack(enemy);
		player.attack(enemy);
		player.attack(enemy);
				
	}

}
