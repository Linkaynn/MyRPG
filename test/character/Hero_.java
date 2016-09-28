package character;

import categories.hero.Assassin;
import categories.hero.CategoryTester;
import categories.hero.Paladin;
import org.junit.Before;
import org.junit.Test;
import race.Human;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.Matchers.isA;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.number.IsCloseTo.closeTo;
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
    public void armor_should_decay_after_take_damage() throws Exception {
        double maxDefense = hero.defense();
        hero.takeDamage(15.0);
        assertThat(hero.defense(), lessThan(maxDefense));
    }
}
