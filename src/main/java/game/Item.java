package game;

public class Item {
    private String name;
    private int attack;
    private int defense;
    private int heal;

    public Item(String name, int atk, int def, int heal) {
        this.name = name;
        this.attack = atk;
        this.defense = def;
        this.heal = heal;
    }

    public String getName() {
        return this.name;
    }

    public int getAttack() {
        return this.attack;
    }

    public int getDefense() {
        return this.defense;
    }

    public int getHeal() {
        return this.heal;
    }
    
    // hashCode 메소드 재정의
    @Override
    public int hashCode() {
        return name.hashCode() + attack + defense + heal;
    }

    // equals 메소드 재정의
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Item item = (Item) obj;
        return attack == item.attack &&
                defense == item.defense &&
                heal == item.heal &&
                name.equals(item.name);
    }
}
