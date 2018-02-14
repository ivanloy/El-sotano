package elsotano.inventories;

import elsotano.equipment.weapons.Sword;

public class EquipmentInventory {

	private Inventory<Sword> weaponInventory; //Change to weapon and do inheritance
	
	public EquipmentInventory() {
		
		weaponInventory = new Inventory<Sword>();
		
	}
		
	public void addWeapon(Sword weapon) {
		
		weaponInventory.add(weapon);
		
	}
	
	public void printWeaponInventory() {
		
		System.out.println("\n  WEAPON INVENTORY" +
						   "\n--------------------");
		
		int i = 0;
		for(Sword s : weaponInventory) {
			
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
	
	//public void viewWeaponDetails(Sword weapon)
	
}
