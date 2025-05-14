package game;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Character {
	String name;
	String race;
	int hp;
	int attack;
	int defense;
	public static final int INVENTORY_SIZE = 10; // 최대 인벤토리 크기
	List<Item> items = new ArrayList<>();

	public Character(String name, String race, int hp, int attack, int defense) {
		this.name = name;
		this.race = race;
		this.hp = hp;
		this.attack = attack;
		this.defense = defense;
	}

	public boolean addItem(Item item) {
		if( items.size() < INVENTORY_SIZE) {
			items.add(item);
			return true;
		} else {
			System.out.println("인벤토리가 가득 찼습니다.");
			return false;
		}
	}

	public void printInventory() {
		System.out.println(name + "의 인벤토리:");
		for (Item item : items) {
			System.out.println("- " + item.getName() + " (공격력:" + item.getAttack() + ", 방어력:" + item.getDefense() + ", 회복력:" + item.getHeal() + ")");
		}
	}

	public boolean useItem(String itemName) {
		for ( int i= items.size()-1; i>=0 ; i-- ) {
			if ( Objects.equals(items.get(i).getName(), itemName) ) {
				System.out.println(items.get(i).getName() + " 아이템을 사용했습니다. 현재 능력치: HP=" + hp + ", 공격력=" + attack + ", 방어력=" + defense);
				removeItem(i);
				return true;
			}
		}
		return false;
	}

	private void removeItem(int index) {
		items.remove(index);
	}

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

	public int getInventoryItemCount() {
		return items.size();
	}

	public String getItemName(int index) {
		return items.get(index).getName();
	}

	public int getItemAttack(int index) {
		return items.get(index).getAttack();
	}

	public int getItemDefense(int index) {
		return items.get(index).getDefense();
	}

	public int getItemHeal(int index) {
		return items.get(index).getHeal();
	}

	public int getItemCount() {
		return items.size();
	}

}
