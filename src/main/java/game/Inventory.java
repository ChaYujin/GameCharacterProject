package game;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Inventory {
	public static final int INVENTORY_SIZE = 10; // 최대 인벤토리 크기
	private List<Item> items = new ArrayList<>();

	public void printItemDetails() {
		for (int i = 0; i < this.getItemCount(); i++) {
			String name = this.getItemName(i);
			int atk = this.getItemAttack(i);
			int def = this.getItemDefense(i);
			int heal = this.getItemHeal(i);
			System.out.println("아이템: " + name + ", 공격력: " + atk + ", 방어력: " + def + ", 회복량: " + heal);
		}
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
		for (Item item : items) {
			System.out.println("- " + item.getName() + " (공격력:" + item.getAttack() + ", 방어력:" + item.getDefense() + ", 회복력:" + item.getHeal() + ")");
		}
	}

	private void removeItem(int index) {
		items.remove(index);
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

	public Item takeItem(String itemName) {
		for ( int i= items.size()-1; i>=0 ; i-- ) {
			if ( Objects.equals(items.get(i).getName(), itemName) ) {
				Item item = items.get(i);
				removeItem(i);
				return item;
			}
		}
		return null;
	}
}
