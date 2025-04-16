package main.java;
public class InventoryManager {
	public void printItemDetails(Character c) {
		System.out.println("[아이템 상세 정보 출력 시작]");
		for (int i = 0; i < c.getItemCount(); i++) {
			String name = c.getItemName(i);
			int atk = c.getItemAttack(i);
			int def = c.getItemDefense(i);
			int heal = c.getItemHeal(i);
			System.out.println("아이템: " + name + ", 공격력: " + atk + ", 방어력: " + def + ", 회복량: " + heal);
		}
		System.out.println("[아이템 상세 정보 출력 끝]");
	}
}
