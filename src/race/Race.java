package race;

abstract public class Race {
    protected String name;

    protected double lifeBonus;
    protected double attackBonus;
    protected double defenseBonus;
    protected double speedBonus;
    protected double dodgeBonus;

    public String name() {
        return name;
    }

    public double lifeBonus() {
        return lifeBonus;
    }

    public double attackBonus() {
        return attackBonus;
    }

    public double defenseBonus() {
        return defenseBonus;
    }

    public double speedBonus() {
        return speedBonus;
    }

    public double dodgeBonus() {
        return dodgeBonus;
    }

    @Override
    public String toString() {
        return name;
    }
}
