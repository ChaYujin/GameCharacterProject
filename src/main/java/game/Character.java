package game;

import game.enemy.Enemy;

public class Character {
	String name;
	String race;
	int hp;
	int attack;
	int defense;
	Inventory inventory = new Inventory();

	public Character(String name, String race, int hp, int attack, int defense) {
		this.name = name;
		this.race = race;
		this.hp = hp;
		this.attack = attack;
		this.defense = defense;
	}

	public void attack(Enemy enemy) {
		System.out.println(name + "이(가) " + enemy.getName() + "을(를) " + attack + "의 데미지로 공격했습니다.");
		enemy.damaged(attack);
		if (enemy.getHp() <= 0) {
			System.out.println(enemy.getName() + " 처치 완료!");
		} else {
			System.out.println(enemy.getName() + "의 남은 HP: " + enemy.getHp());
		}
	}

    public boolean obtainItem(Item item) {
		return inventory.addItem(item);
    }

	public boolean useItem(String itemName) {
		Item item = inventory.takeItem(itemName);
		if (item != null) {
			attack += item.getAttack();
			defense += item.getDefense();
			hp += item.getHeal();
			System.out.println(item.getName() + " 아이템을 사용했습니다. 현재 능력치: HP=" + hp + ", 공격력=" + attack + ", 방어력=" + defense);
			return true;
		}
		return false;
	}

    public void printItemDetails() {
		System.out.println("[아이템 상세 정보 출력 시작]");
		inventory.printItemDetails();
		System.out.println("[아이템 상세 정보 출력 끝]");
    }


	public void printInventory() {
		System.out.println(name + "의 인벤토리:");
		inventory.printInventory();
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

}
