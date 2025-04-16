package game;

public class Character {
	String name;
	String race;
	int hp;
	int attack;
	int defense;
	String[] itemNames = new String[10];
	int[] itemAttack = new int[10];
	int[] itemDefense = new int[10];
	int[] itemHeal = new int[10];
	int itemCount = 0;

	public Character(String name, String race, int hp, int attack, int defense) {
		this.name = name;
		this.race = race;
		this.hp = hp;
		this.attack = attack;
		this.defense = defense;
	}

	public void addItem(String name, int atk, int def, int heal) {
		itemNames[itemCount] = name;
		itemAttack[itemCount] = atk;
		itemDefense[itemCount] = def;
		itemHeal[itemCount] = heal;
		itemCount++;
	}

	public void printInventory() {
		System.out.println(name + "의 인벤토리:");
		for (int i = 0; i < itemCount; i++) {
			System.out.println("- " + itemNames[i] + " (공격력:" + itemAttack[i] + ", 방어력:" + itemDefense[i] + ", 회복력:" + itemHeal[i] + ")");
		}
	}

	public void useItem(String itemName) {
		for (int i = 0; i < itemCount; i++) {
			if (itemNames[i].equals(itemName)) {
				attack += itemAttack[i];
				defense += itemDefense[i];
				hp += itemHeal[i];
				System.out.println(itemNames[i] + " 아이템을 사용했습니다. 현재 능력치: HP=" + hp + ", 공격력=" + attack + ", 방어력=" + defense);
				removeItem(i);
				break;
			}
		}
	}

	private void removeItem(int index) {
		for (int i = index; i < itemCount - 1; i++) {
			itemNames[i] = itemNames[i + 1];
			itemAttack[i] = itemAttack[i + 1];
			itemDefense[i] = itemDefense[i + 1];
			itemHeal[i] = itemHeal[i + 1];
		}
		itemCount--;
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

	public int getItemCount() {
		return itemCount;
	}

	public String getItemName(int index) {
		return itemNames[index];
	}

	public int getItemAttack(int index) {
		return itemAttack[index];
	}

	public int getItemDefense(int index) {
		return itemDefense[index];
	}

	public int getItemHeal(int index) {
		return itemHeal[index];
	}
}
