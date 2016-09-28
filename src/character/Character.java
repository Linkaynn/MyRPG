package character;

import categories.Category;
import race.Race;

abstract public class Character {
    protected String name;
    protected Category category;
    protected Race race;

    protected double maxLife = 0;

    protected int level = 1;

    private double damage = 0;
    private double armorIntegrity = 1;
    private double speedFactor = 1;

    public String name() {
        return name;
    }

    public String category() {
        return category.name();
    }

    public int level() {
        return level;
    }

    public double life(){
        return level * category.baseLife() * race.lifeBonus() - damage;
    }

    public double attack(){
        return level * category.baseAttack() * race.attackBonus();
    }

    public double defense(){
        return level * category.baseDefense() * race.defenseBonus() * armorIntegrity;
    }

    public double speed(){
        return level * category.baseSpeed() * race.speedBonus() * speedFactor;
    }

    public double dodge(){
        return category.baseDodge() * race.dodgeBonus();
    }

    public double maxLife(){
        return maxLife;
    }

    public String toString() {
        return name;
    }

    public abstract String stats();

    public Race race(){
        return race;
    }

    public void takeDamage(double damage) {
        this.damage += defense() < damage ? damage - defense() : 0;
        armorIntegrity -= 0.05;
    }

    public void speedDown() {
        speedFactor -= speedFactor == 1 ? 0.1 : 0.05;
        if (speedFactor < 0.5) speedFactor = 0.1;
    }

    public void speedUp() {
        speedFactor += 0.1;
        if (speedFactor > 1) speedFactor = 1;
    }
}
