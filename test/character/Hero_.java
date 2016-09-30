package character;

import categories.hero.Assassin;
import categories.hero.CategoryTester;
import categories.hero.Paladin;
import equipment.armours.Armour;
import equipment.armours.ArmourBuilder;
import org.junit.Before;
import org.junit.Test;
import race.Human;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

public class Hero_ {
    private PJ hero;

    @Before
    public void setUp() throws Exception {
        hero = new PJ("Linkaynn", new CategoryTester());
    }

    @Test
    public void must_have_a_name() throws Exception {
        assertThat(hero.name(), is("Linkaynn"));
    }

    @Test
    public void must_have_category() throws Exception {
        assertThat(hero.category(), is(not(nullValue())));
    }

    @Test
    public void must_be_human() throws Exception {
        assertThat(hero.race(), is(instanceOf(Human.class)));
    }

    @Test
    public void new_hero_must_have_1_lvl() throws Exception {
        assertThat(hero.level(), is(1));
    }

    @Test
    public void with_17xp_must_have_2_lvl() throws Exception {
        hero.addExp(17);
        assertThat(hero.level(), is(2));
    }

    @Test
    public void with_20xp_must_have_3_lvl() throws Exception {
        hero.addExp(20);
        assertThat(hero.level(), is(3));
    }

    @Test
    public void categories_should_change() throws Exception {
        hero.addExp(20);
        System.out.println(hero.stats());
        hero.changeCategory(new Assassin());
        assertThat(hero.category(), is("Assassin"));
        System.out.println(hero.stats());
        hero.changeCategory(new Paladin());
        assertThat(hero.category(), is("Paladin"));
        System.out.println(hero.stats());
    }

    @Test
    public void should_take_damage() throws Exception {
        hero.takeDamage(15.0);
        assertThat(hero.life(), lessThan(hero.maxLife()));
    }

    @Test
    public void natural_armor_should_decay_after_take_damage() throws Exception {
        double maxDefense = hero.defense();
        hero.takeDamage(15.0);
        assertThat(hero.defense(), lessThan(maxDefense));
    }

    @Test
    public void should_equip_armour_which_category_match() throws Exception {
        double naturalDefense = hero.defense();
        hero.equip(armorWithCategoryMatch());
        assertThat(hero.defense(), greaterThan(naturalDefense));
        hero.removeArmour();
        assertThat(hero.defense(), is(equalTo(naturalDefense)));
    }

    @Test
    public void should_not_equip_armour_which_category_doesnt_match() throws Exception {
        hero.equip(armorWithoutCategoryMatch());
        assertThat(hero.armour(), is(nullValue()));
    }

    private Armour armorWithoutCategoryMatch() {
        return new ArmourBuilder().levelRequirement(5).protection(15.2).classRequirement(new Paladin()).build();
    }

    private Armour armorWithCategoryMatch() {
        return new ArmourBuilder().levelRequirement(5).protection(15.2).classRequirement(new CategoryTester(), new Assassin()).build();
    }
}
