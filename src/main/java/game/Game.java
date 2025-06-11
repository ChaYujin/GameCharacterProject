package game;

import game.character.Elf;
import game.enemy.Enemy;

public class Game {
	public static void main(String[] args) {
		Character hero = new Elf("Artemis");
		hero.obtainItem(new Item("검", 10, 0, 0));
		hero.obtainItem(new Item("방패", 0, 10, 0));
		hero.obtainItem(new Item("포션", 0, 0, 50));
		hero.printInventory();
		hero.attack(new Enemy("고블린", 50));
		hero.useItem("포션");
		hero.printInventory();

		hero.attack(new Enemy("오크", 40));
		System.out.println("최종 HP: " + hero.getHp());

		BattleSystem battle = new BattleSystem();
		
		battle.fight(hero, new Enemy("드래곤", 120));

		hero.printItemDetails();
	}
}
