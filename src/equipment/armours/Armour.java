package equipment.armours;

import categories.hero.HeroCategory;
import sun.reflect.misc.ConstructorUtil;
import sun.reflect.misc.ReflectUtil;

import java.util.ArrayList;
import java.util.function.Predicate;

public class Armour {
    private final int levelRequirement;
    private final double protectionValue;
    private final ArrayList<HeroCategory> classes;

    public Armour(int levelRequirement, double protectionValue, ArrayList<HeroCategory> classes) {

        this.levelRequirement = levelRequirement;
        this.protectionValue = protectionValue;
        this.classes = classes;
    }

    public int requirement() {
        return levelRequirement;
    }

    public double protection() {
        return protectionValue;
    }

    public boolean allowTo(final Class<? extends HeroCategory> category) {
        return classes.stream().anyMatch(heroCategory -> heroCategory.getClass() == category);
    }
}
