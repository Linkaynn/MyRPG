package generators;

import categories.monster.Assassin;
import categories.monster.Giant;
import categories.monster.MonsterCategory;
import categories.monster.Normal;
import race.Ghoul;
import race.Goblin;
import race.Race;
import race.Troll;

import java.util.Random;

public class MonsterGenerator {

    private static Race[] races = {new Goblin(), new Troll(), new Ghoul()};
    private static MonsterCategory[] categories = {new Assassin(), new Giant(), new Normal()};


    public static Race generateRace() {
        return races[new Random().nextInt(races.length)];
    }

    public static MonsterCategory generateCategory() {
        return categories[new Random().nextInt(categories.length)];
    }
}
