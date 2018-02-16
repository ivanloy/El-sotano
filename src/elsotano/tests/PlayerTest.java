package elsotano.tests;

import elsotano.character.Player;
import elsotano.combat.Combat;
import elsotano.enemies.SimpleEnemy;
import elsotano.equipment.accessories.Gloves;
import elsotano.equipment.accessories.Ring;
import elsotano.equipment.accessories.Shoes;
import elsotano.equipment.armor.ChestArmor;
import elsotano.equipment.armor.HeadArmor;
import elsotano.equipment.armor.LegsArmor;
import elsotano.equipment.weapons.Sword;
import elsotano.inventories.EquipmentInventory;

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
		
		Player player = new Player(89, 44, 8, 12, 13, 23);
		
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
		
		SimpleEnemy enemy = new SimpleEnemy(280, 12, 15, 5, 3, 2324);
		enemy.setName("Pseudocodigo zombie");
		
		player.attack(enemy); //ADD Logs instead or prints or something
		player.attack(enemy);
		player.attack(enemy);
		player.attack(enemy);
		player.attack(enemy);
		player.attack(enemy);
		
		enemy.attack(player);
		System.out.println(player.printStats());
		enemy.attack(player);
		System.out.println(player.printStats());
		enemy.attack(player);
		System.out.println(player.printStats());
		
		enemy.healDamage(200);
		
		Combat combat = new Combat(player, enemy);
		combat.startCombat();
		
		EquipmentInventory eqInv = new EquipmentInventory();
		
		Sword sword2 = new Sword(222);
		
 		eqInv.addWeapon(sword = player.getSword()); 
 		sword2.setName("Filo del suspenso");
 		eqInv.addWeapon(sword2); //TODO do it above, this is garbage
 		eqInv.addChestArmor(chestArmor);
 		eqInv.addHeadArmor(headArmor);
 		eqInv.addLegsArmor(legsArmor);
 		eqInv.addGloves(gloves);
 		eqInv.addRing(ring);
 		eqInv.addShoes(shoes);
 		
 		eqInv.printWeaponDetails(0);
 		eqInv.printChestArmorDetails(0);
 		eqInv.printHeadArmorDetails(0);
 		eqInv.printLegsArmorDetails(0);
 		eqInv.printGlovesDetails(0);
 		eqInv.printRingDetails(0);
 		eqInv.printShoesDetails(0);
 		
 		sword.setPower(20);
 		eqInv.printWeaponDetails(0);
 		System.out.println(sword.getPower());
 		
		eqInv.printWeaponInventory();
		eqInv.printChestArmorInventory();
		eqInv.printHeadArmorInventory();
		eqInv.printLegsArmorInventory();
		eqInv.printGlovesInventory();
		eqInv.printRingInventory();
		eqInv.printShoesInventory();
		
		eqInv.printWeaponDetails(1);
		
	}

}
