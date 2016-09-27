package categories;

public abstract class Category {
    protected double life;
    protected double attack;
    protected double speed;
    protected double defense;

    protected double dodgeOdd;

    protected String name;


    public String name(){
        return name;
    }

    public double baseLife(){
        return life;
    }

    public double baseAttack(){
        return attack;
    }

    public double baseSpeed(){
        return speed;
    }

    public double baseDefense(){
        return defense;
    }

    public double baseDodge(){
        return dodgeOdd;
    }
}
