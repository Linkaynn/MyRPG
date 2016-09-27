package categories;

import categories.hero.Assassin;
import categories.hero.Paladin;
import categories.hero.Warrior;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class Categories_ {

    @Test
    public void warriors_should_have_75L_10A_3_5S_8D_and_10_percent_dodge() throws Exception {
        Warrior warrior = new Warrior();
        assertThat(warrior.baseLife(), is(75.0));
        assertThat(warrior.baseAttack(), is(10.0));
        assertThat(warrior.baseSpeed(), is(3.5));
        assertThat(warrior.baseDefense(), is(8.0));
        assertThat(warrior.baseDodge(), is(0.1));
    }

    @Test
    public void assassins_should_have_65L_8A_9_5S_3_35D_and_25_percent_dodge() throws Exception {
        Assassin assassin = new Assassin();
        assertThat(assassin.baseLife(), is(65.0));
        assertThat(assassin.baseAttack(), is(8.0));
        assertThat(assassin.baseSpeed(), is(9.5));
        assertThat(assassin.baseDefense(), is(3.35));
        assertThat(assassin.baseDodge(), is(0.25));
    }

    @Test
    public void paladin_should_have_60L_7_2A_4S_11D_and_15_percent_dodge() throws Exception {
        Paladin paladin = new Paladin();
        assertThat(paladin.baseLife(), is(60.0));
        assertThat(paladin.baseAttack(), is(7.2));
        assertThat(paladin.baseSpeed(), is(4.0));
        assertThat(paladin.baseDefense(), is(11.0));
        assertThat(paladin.baseDodge(), is(0.15));
    }
}
