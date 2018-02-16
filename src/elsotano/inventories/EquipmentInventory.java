package elsotano.inventories;

import elsotano.equipment.accessories.Gloves;
import elsotano.equipment.accessories.Ring;
import elsotano.equipment.accessories.Shoes;
import elsotano.equipment.armor.ChestArmor;
import elsotano.equipment.armor.HeadArmor;
import elsotano.equipment.armor.LegsArmor;
import elsotano.equipment.weapons.Sword;

public class EquipmentInventory {

	private Inventory<Sword> weaponInventory; //Change to weapon and do inheritance
	private Inventory<ChestArmor> chestArmorInventory;
	private Inventory<HeadArmor> headArmorInventory;
	private Inventory<LegsArmor> legsArmorInventory;
	private Inventory<Gloves> glovesInventory;
	private Inventory<Ring> ringInventory;
	private Inventory<Shoes> shoesInventory;
	
	public EquipmentInventory() {
		
		weaponInventory = new Inventory<>();
		chestArmorInventory = new Inventory<>();
		headArmorInventory = new Inventory<>();
		legsArmorInventory = new Inventory<>();
		glovesInventory = new Inventory<>();
		ringInventory = new Inventory<>();
		shoesInventory = new Inventory<>();
		
	}
		
	public void addWeapon(Sword weapon) { weaponInventory.add(weapon); }
	public void addChestArmor(ChestArmor chestArmor) { chestArmorInventory.add(chestArmor); }
	public void addHeadArmor(HeadArmor headArmor) { headArmorInventory.add(headArmor); }
	public void addLegsArmor(LegsArmor legsArmor) { legsArmorInventory.add(legsArmor); }
	public void addGloves(Gloves gloves) { glovesInventory.add(gloves); }
	public void addRing(Ring ring) { ringInventory.add(ring); }
	public void addShoes(Shoes shoes) { shoesInventory.add(shoes); }
	
	public void printWeaponInventory() {
		
		System.out.println("\n  WEAPONS INVENTORY" +
						   "\n--------------------");
		
		int i = 0;
		for(Sword s : weaponInventory) {
			
			System.out.print("[" + (++i) + "] ");
			System.out.println(s.getName());
			
		}
		
	}
	
	public void printChestArmorInventory() {
		
		System.out.println("\n  CHEST ARMORS INVENTORY" +
						   "\n-------------------------");
		
		int i = 0;
		for(ChestArmor a : chestArmorInventory) {
			
			System.out.print("[" + (++i) + "] ");
			System.out.println(a.getName());
			
		}
		
	}
	
	public void printHeadArmorInventory() {
		
		System.out.println("\n  HEAD ARMORS INVENTORY" +
						   "\n-------------------------");
		
		int i = 0;
		for(HeadArmor a : headArmorInventory) {
			
			System.out.print("[" + (++i) + "] ");
			System.out.println(a.getName());
			
		}
		
	}

	public void printLegsArmorInventory() {
		
		System.out.println("\n  LEGS ARMORS INVENTORY" +
						   "\n-------------------------");
		
		int i = 0;
		for(LegsArmor a : legsArmorInventory) {
			
			System.out.print("[" + (++i) + "] ");
			System.out.println(a.getName());
			
		}
		
	}
	
	public void printGlovesInventory() {
		
		System.out.println("\n  GLOVES INVENTORY" +
						   "\n-------------------------");
		
		int i = 0;
		for(Gloves g : glovesInventory) {
			
			System.out.print("[" + (++i) + "] ");
			System.out.println(g.getName());
			
		}
		
	}
	
	public void printRingInventory() {
		
		System.out.println("\n  RINGS INVENTORY" +
						   "\n-------------------------");
		
		int i = 0;
		for(Ring r : ringInventory) {
			
			System.out.print("[" + (++i) + "] ");
			System.out.println(r.getName());
			
		}
		
	}

	public void printShoesInventory() {
		
		System.out.println("\n  SHOES INVENTORY" +
						   "\n-------------------------");
		
		int i = 0;
		for(Shoes s : shoesInventory) {
			
			System.out.print("[" + (++i) + "] ");
			System.out.println(s.getName());
			
		}
		
	}


	
	public void printWeaponDetails(int index) {
		
		Sword weapon = weaponInventory.peek(index);
		
		System.out.println(weapon.getName().toUpperCase() + 
				        "\n-----------------------------" +
				       "\n +" + weapon.getPower() + " attack"); //TODO DESCRIPTION
		
	}
	
	public void printChestArmorDetails(int index) {
		
		ChestArmor chestArmor = chestArmorInventory.peek(index);
		
		System.out.println(chestArmor.getName().toUpperCase() + 
				        "\n-----------------------------" +
				       "\n +" + chestArmor.getMaxHP() + " max HP" +
				       "\n +" + chestArmor.getDefense() + " defense"); 
		
	}
	
	public void printHeadArmorDetails(int index) {
		
		HeadArmor headArmor = headArmorInventory.peek(index);
		
		System.out.println(headArmor.getName().toUpperCase() + 
				        "\n-----------------------------" +
				        "\n +" + headArmor.getDefense() + " defense"); 
		
	}

	public void printLegsArmorDetails(int index) {
	
		LegsArmor legsArmor = legsArmorInventory.peek(index);
		
		System.out.println(legsArmor.getName().toUpperCase() + 
				        "\n-----------------------------" +
				       "\n +" + legsArmor.getAgility() + " agility" +
				       "\n +" + legsArmor.getDefense() + " defense"); 
	
	}

	public void printGlovesDetails(int index) {
		
		Gloves gloves = glovesInventory.peek(index);
		
		System.out.println(gloves.getName().toUpperCase() + 
				        "\n-----------------------------" +
				       "\n +" + gloves.getDefense() + " defense"); 
	
	}
	
	public void printRingDetails(int index) {
		
		Ring ring = ringInventory.peek(index);
		
		System.out.println(ring.getName().toUpperCase() + 
				        "\n-----------------------------" +
				       "\n +" + ring.getLuck() + " luck"); 
	
	}
	
	public void printShoesDetails(int index) {
		
		Shoes shoes = shoesInventory.peek(index);
		
		System.out.println(shoes.getName().toUpperCase() + 
				        "\n-----------------------------" +
				       "\n +" + shoes.getAgility() + " agility"); 
	
	}
	
}
