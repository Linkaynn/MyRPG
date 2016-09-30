package character;

import categories.monster.MonsterCategory;
import equipment.armours.Armour;
import generators.MonsterGenerator;
import race.Race;

import java.util.Random;

public class Monster extends Character {


    public Monster(Race race, MonsterCategory category, int level) {
        this.category = category;
        this.race = race;
        this.name = String.format("%s %s", category.name(), race.name());
        this.level = level;
        this.maxLife = life();
    }

    public Monster(int maxLevel) {
        this(MonsterGenerator.generateRace(), MonsterGenerator.generateCategory(), new Random().nextInt(maxLevel) + 1);
    }

    @Override
    public String stats() {
        return String.format("-----------------" +
                        "\nName: %s\nCategory: %s\nLevel: %s\n\n" +
                        "Life: %s\nAttack: %s\nDefense: %s\nSpeed: %s\nDodge Odd: %s\n" +
                        "-----------------\n\n"
                , name, category.name(), level, life(), attack(), defense(), speed(), dodge());

    }
}
