package game.enemy;

public class Enemy {
    private String name;
    private int hp;
    
    public Enemy(String name, int hp) {
        this.name = name;
        this.hp = hp;
    }

    public String getName() {
        return name;
    }
    public int getHp() {
        return hp;
    }

    public void damaged(int attack) {
        this.hp -= attack;
    }
}
