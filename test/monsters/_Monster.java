package monsters;

import character.Monster;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.Is.is;

public class _Monster {
    @Test
    public void should_generate_a_random_monster() throws Exception {
        Monster monster = new Monster(50);
        assertThat(monster.level(), lessThanOrEqualTo(50));
        assertThat(monster.category(), is(not(nullValue())));
        assertThat(monster.race(), is(not(nullValue())));
        assertThat(monster.name(), is(String.format("%s %s", monster.category(), monster.race())));
        System.out.println(monster.stats());
    }

    @Test
    public void stats_should_be_greater_than_0_at_level_0() throws Exception {
        Monster monster = new Monster(1);
        assertThat("Life", monster.life(), greaterThan(0.0));
        assertThat("Attack", monster.attack(), greaterThan(0.0));
        assertThat("Defense", monster.defense(), greaterThan(0.0));
        assertThat("Speed", monster.speed(), greaterThan(0.0));
    }
}
