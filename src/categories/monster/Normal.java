package categories.monster;

public class Normal extends MonsterCategory {
    public Normal() {
        super.name = "Normal";
        super.life = 35;
        super.attack = 5;
        super.speed = 5;
        super.defense = 5;
        super.dodgeChance = 0.1;
    }
}
