package elsotano.combat;

import java.util.Scanner;

import elsotano.character.Player;
import elsotano.enemies.EnemyParent;
import lombok.Data;

@Data
public class Combat {

	private Player player; //TODO allow 2x2 or 1x2, etc..., arraylist or my ds
	private EnemyParent enemy;
	
	private boolean playerIsDefending; //TODO ds of booleans for each player
	//TODO do same with enemy
	
	public Combat() {
		
		player = new Player();
		enemy = new EnemyParent();
		
	}
	
	public Combat(Player player, EnemyParent enemy) { //TODO Implement clone in Player and Enemy classes
		
		this.player = player;
		this.enemy = enemy;
		
	}
	
	public String combatMenu() {
		
		return "+------------------------------------+" +
		     "\n|            COMBAT MENU             |" +
		     "\n+------------------------------------+" +
		     "\n|           [1] Attack               |" +
		     "\n|           [2] Magic                |" +
		     "\n|           [3] Hability             |" +
		     "\n|           [4] Defend               |" +
		     "\n|           [5] Item                 |" +
		     "\n|           [6] Escape               |" +
		     "\n+------------------------------------+";
		
	}
	
	public void startCombat() { //TODO Dead boolean in player, or game over message
		
		//TODO Improve this blablabla
		
		while(player.getCurrentHP() > 0 && enemy.getCurrentHP() > 0) { //TODO boolean isDead
			
			if(player.getSpeed() >= enemy.getBaseSpeed()) { //TODO If same speed, random starts
			
				int option = readCombatMenuOption(); //Make read, validate blablabla
				enterCombatMenuOption(option);
				
				if(printDeadMessages()) enemy.attack(player, playerIsDefending ? 0.35 : 1);;
				printDeadMessages();
				
			}else {
				
				enemy.attack(player, playerIsDefending ? 0.35 : 1); //TODO IA //TODO Improve defense damage reduction with defense
				
				if(printDeadMessages()) { 
					
					int option = readCombatMenuOption(); //Make read, validate blablabla
					enterCombatMenuOption(option);
					printDeadMessages();
				
				}
				
			}
			
		}
		
	}
	
	public boolean printDeadMessages() {
		
		boolean ret = false;
		
		if(enemy.getCurrentHP() > 0 && player.getCurrentHP() <= 0) System.out.println("Has muerto...Try again, insert coin");
		else if(enemy.getCurrentHP() <= 0 && player.getCurrentHP() > 0) System.out.println("Has ganado, pero esto solo es el principio, MUA HAHA HAHA");
		else if(enemy.getCurrentHP() <= 0 && player.getCurrentHP() <= 0) System.out.println("Los dos habeis muerto a la vez..., un señor que pasaba por ahi te robo el loot y te saqueo un poquito mucho, pero como estas muerto te da igual");
		else ret = true;
		
		return ret;
		
	}
	
	public void enterCombatMenuOption(int option) {
		
		switch(option) {
		
			case 1: 
				attack();
				playerIsDefending = false;
				break;
			case 2: System.out.println("En construccion"); break;
			case 3: System.out.println("En construccion"); break;
			case 4: playerIsDefending = true; break;
			case 5: System.out.println("En construccion"); break;
			case 6: System.out.println("En construccion"); break;
	
		}
		
	}
	
	//TODO Enemy IA
	public void attack() {
		
		player.attack(enemy);
		
	}
	
	//TODO boolean combat finished, main program control
	
	private int readCombatMenuOption() {
		
		int ret = 0;
		Scanner scanner = new Scanner(System.in);
		
		do {
			
			System.out.println(player.getName() + " : " + player.getCurrentHP() + "/" + player.getMaxHP() + "HP");
			System.out.println(combatMenu());
			ret = scanner.next().charAt(0) - 48;
				
		}while(ret < 1 || ret > 6);
		
		scanner.close();
		
		return ret;
		
	}
	
}
