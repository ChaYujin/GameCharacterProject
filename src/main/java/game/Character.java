package game;

import java.util.HashMap;
import java.util.Map;

public class Character {
	String name;
	String race;
	int hp;
	int attack;
	int defense;
	// String[] itemNames = new String[10]; // 10개까지만 가질 수 있음
	// int[] itemAttack = new int[10];
	// int[] itemDefense = new int[10];
	// int[] itemHeal = new int[10];
	// int itemCount = 0;
	private final int INVENTORY_SIZE = 10; // 최대 인벤토리 크기
	Map<Item, Integer> inventory = new HashMap<>();

	public Character(String name, String race, int hp, int attack, int defense) {
		this.name = name;
		this.race = race;
		this.hp = hp;
		this.attack = attack;
		this.defense = defense;
	}

	public boolean addItem(Item item) {
		if( inventory.size() < INVENTORY_SIZE) {
			inventory.put(item, inventory.getOrDefault(item, 0) + 1);
			return true;
		} else {
			System.out.println("인벤토리가 가득 찼습니다.");
			return false;
		}
	}

	// public void addItem(String name, int atk, int def, int heal) {
	// 	itemNames[itemCount] = name;
	// 	itemAttack[itemCount] = atk;
	// 	itemDefense[itemCount] = def;
	// 	itemHeal[itemCount] = heal;
	// 	itemCount++;
	// }

	public void printInventory() {
		// System.out.println(name + "의 인벤토리:");
		// for (int i = 0; i < itemCount; i++) {
		// 	System.out.println("- " + itemNames[i] + " (공격력:" + itemAttack[i] + ", 방어력:" + itemDefense[i] + ", 회복력:" + itemHeal[i] + ")");
		// }
	}

	// public void useItem(String itemName) {
	// 	for (int i = 0; i < itemCount; i++) {
	// 		if (itemNames[i].equals(itemName)) {
	// 			attack += itemAttack[i];
	// 			defense += itemDefense[i];
	// 			hp += itemHeal[i];
	// 			System.out.println(itemNames[i] + " 아이템을 사용했습니다. 현재 능력치: HP=" + hp + ", 공격력=" + attack + ", 방어력=" + defense);
	// 			removeItem(i);
	// 			break;
	// 		}
	// 	}
	// }

	// private void removeItem(int index) {
	// 	for (int i = index; i < itemCount - 1; i++) {
	// 		itemNames[i] = itemNames[i + 1];
	// 		itemAttack[i] = itemAttack[i + 1];
	// 		itemDefense[i] = itemDefense[i + 1];
	// 		itemHeal[i] = itemHeal[i + 1];
	// 	}
	// 	itemCount--;
	// }

	public void attack(String enemyName, int enemyHp) {
		System.out.println(name + "이(가) " + enemyName + "을(를) " + attack + "의 데미지로 공격했습니다.");
		if (enemyHp - attack <= 0) {
			System.out.println(enemyName + " 처치 완료!");
		} else {
			System.out.println(enemyName + "의 남은 HP: " + (enemyHp - attack));
		}
	}

	public int getHp() {
		return hp;
	}

	public int getAttack() {
		return attack;
	}

	public String getName() {
		return name;
	}

	public int getItemCount() {
		return inventory.values().stream().reduce(0, Integer::sum);
	}

}
