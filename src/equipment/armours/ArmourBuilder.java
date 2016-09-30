package equipment.armours;

import categories.hero.Assassin;
import categories.hero.HeroCategory;
import categories.hero.Paladin;

import java.util.ArrayList;
import java.util.Collections;

public class ArmourBuilder {

    private int levelRequirement;
    private double protectionValue;
    private ArrayList<HeroCategory> classes = new ArrayList<>();

    public ArmourBuilder levelRequirement(int levelRequirement) {
        this.levelRequirement = levelRequirement;
        return this;
    }

    public ArmourBuilder protection(double protectionValue) {
        this.protectionValue = protectionValue;
        return this;
    }

    public ArmourBuilder classRequirement(HeroCategory... categories) {
        Collections.addAll(classes, categories);
        return this;
    }

    public Armour build() {
        return new Armour(levelRequirement, protectionValue, classes);
    }
}
