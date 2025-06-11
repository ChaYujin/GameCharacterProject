package game;

import game.enemy.Enemy;

public class BattleSystem {
	public void fight(Character character, Enemy enemy) {
		System.out.println("전투 시작! " + character.getName() + " VS " + enemy.getName());
		while (enemy.getHp() > 0 && character.getHp() > 0) {
			System.out.println("-- 턴 시작 --");
			enemy.damaged(character.getAttack());

			if (enemy.getHp() <= 0) {
				System.out.println(enemy.getName() + "를 쓰러뜨렸습니다!");
				break;
			}
			System.out.println(enemy.getName() + "의 반격!");
			character.hp -= 15;
			System.out.println(character.getName() + "의 남은 HP: " + character.getHp());
		}
		System.out.println("전투 종료.");
	}
}
