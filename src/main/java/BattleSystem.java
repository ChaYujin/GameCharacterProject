package main.java;
public class BattleSystem {
	public void fight(Character character, String enemyName, int enemyHp) {
		System.out.println("전투 시작! " + character.getName() + " VS " + enemyName);
		while (enemyHp > 0 && character.getHp() > 0) {
			System.out.println("-- 턴 시작 --");
			enemyHp -= character.getAttack();
			if (enemyHp <= 0) {
				System.out.println(enemyName + "를 쓰러뜨렸습니다!");
				break;
			}
			System.out.println(enemyName + "의 반격!");
			character.hp -= 15;
			System.out.println(character.getName() + "의 남은 HP: " + character.getHp());
		}
		System.out.println("전투 종료.");
	}
}
