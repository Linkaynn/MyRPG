package character;


import categories.hero.HeroCategory;
import race.Human;

public class PJ extends Character{

    private double experience = 0;

    public PJ(String name, HeroCategory category) {
        this.category = category;
        this.name = name;
        this.race = new Human();
        this.maxLife = life();
        calculateLevel();
    }

    public void changeCategory(HeroCategory category) {
        this.category = category;
    }

    public void addExp(double experience) {
        this.experience += experience;
        calculateLevel();
    }

    private void calculateLevel(){
        while (nextLevelReached())
            level++;
    }

    private boolean nextLevelReached() {
        return nextLevelExperience() <= experience;
    }

    private double nextLevelExperience() {
        return calculateExperience(level) + calculateExperience(level + 1);
    }

    private double calculateExperience(int level) {
        return level > 0 ? 7.287*Math.pow(Math.E, 0.095*level) : 0;
    }

    @Override
    public String stats() {
        return String.format("-----------------" +
                             "\nName: %s\nCategory: %s\nLevel: %s\nExperience: %s\nNext level experience: %s\n\n" +
                             "Life: %s\nAttack: %s\nDefense: %s\nSpeed: %s\nDodge Odd: %s\n" +
                             "-----------------\n\n"
                ,name, category.name(), level, experience, nextLevelExperience(),life(), attack(), defense(), speed(), dodge());
    }
}
