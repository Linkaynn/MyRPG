package combat;

import categories.monster.Assassin;
import character.Monster;
import character.PJ;
import org.junit.Before;
import org.junit.Test;
import race.Goblin;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.core.IsNull.nullValue;

public class Combat_ {

    private Combat combat;

    @Before
    public void setUp() throws Exception {
        combat = new Combat(new PJ("Linkaynn", new categories.hero.Assassin()), new Monster(new Goblin(), new Assassin(), 1));
    }

    @Test
    public void should_have_a_hero_and_monster() throws Exception {
        assertThat(combat.hero(), is(not(nullValue())));
        assertThat(combat.monster(), is(not(nullValue())));
    }

    @Test(timeout=1000)
    public void both_should_attack_sometimes() throws Exception {
        boolean hasHeroTurn = false;
        boolean hasMonsterTurn = false;

        while (!hasHeroTurn || !hasMonsterTurn){
            hasHeroTurn = hasHeroTurn || combat.whoIsNext().name().equals("Linkaynn");
            hasMonsterTurn = hasMonsterTurn || !combat.whoIsNext().name().equals("Linkaynn");
        }
    }

    @Test
    public void should_have_a_winner() throws Exception {
        CombatController combatController = new CombatController(combat, true);
        combatController.start();
        assertThat(combatController.looser(), is(not(nullValue())));
        assertThat(combatController.winner(), is(not(nullValue())));
    }
}
