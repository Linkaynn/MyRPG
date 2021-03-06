package combat;

import character.Character;
import character.Monster;
import character.PJ;

import java.util.Random;

public class Combat {
    private final PJ hero;
    private final Monster monster;

    private Character attacker;
    private Character defender;
    private boolean dodged = false;

    public Combat(PJ hero, Monster monster) {
        this.hero = hero;
        this.monster = monster;
    }

    public PJ hero() {
        return hero;
    }

    public Monster monster(){
        return monster;
    }

    public Character whoIsNext() {

        Character fasterCharacter = hero.speed() - monster.speed() <= 0 ? monster : hero;
        Character slowerCharacter = fasterCharacter instanceof PJ ? monster : hero;

        int target = new Random().nextInt((int) (hero.speed() + monster.speed()));

        return slowerCharacter.speed() - target <= 0 ? slowDown(fasterCharacter) : slowDown(slowerCharacter);
    }

    private Character slowDown(Character character) {
        if (character instanceof PJ)
            monster.speedUp();
        else
            hero.speedUp();
        character.speedDown();
        return character;
    }

    public double fight() {
        this.attacker = whoIsNext();
        this.defender = whoIsTheOther(attacker);

        dodged = defender.dodge() * 10 - new Random().nextInt(100) >= 0;

        double damage = defender.life();
        if (!dodged) defender.takeDamage(attacker.attack());
        return damage - defender.life();
    }

    private Character whoIsTheOther(Character character) {
        return character instanceof PJ ? monster : hero;
    }

    public Character attacker() {
        return attacker;
    }

    public Character defender() {
        return defender;
    }

    public boolean dodged() {
        return dodged;
    }
}
